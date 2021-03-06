/**
 * The BSD License
 *
 * Copyright (c) 2010-2018 RIPE NCC
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   - Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   - Neither the name of the RIPE NCC nor the names of its contributors may be
 *     used to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package mx.nic.lab.rpki.db.pojo;

import java.math.BigInteger;
import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import mx.nic.lab.rpki.db.util.Sha256;
import net.ripe.rpki.commons.crypto.CertificateRepositoryObject;
import net.ripe.rpki.commons.crypto.UnknownCertificateRepositoryObject;
import net.ripe.rpki.commons.crypto.cms.RpkiSignedObject;
import net.ripe.rpki.commons.crypto.cms.ghostbuster.GhostbustersCms;
import net.ripe.rpki.commons.crypto.cms.manifest.ManifestCms;
import net.ripe.rpki.commons.crypto.cms.roa.RoaCms;
import net.ripe.rpki.commons.crypto.crl.X509Crl;
import net.ripe.rpki.commons.crypto.x509cert.X509ResourceCertificate;
import net.ripe.rpki.commons.crypto.x509cert.X509RouterCertificate;

public class RpkiObject extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = RpkiObject.class.getSimpleName();
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String SIGNING_TIME = "signingTime";
	public static final String LAST_MARK_REACHABLE_AT = "lastMarkedReachableAt";
	public static final String AUTHORITY_KEY_IDENTIFIER = "authorityKeyIdentifier";
	public static final String SUBJECT_KEY_IDENTIFIER = "subjectKeyIdentifier";
	public static final String SHA256 = "sha256";
	public static final String IS_CA = "isCa";
	public static final String ENCODED_RPKI_OBJECT = "encodedRpkiObject";
	public static final String RPKI_REPOSITORIES = "rpkiRepositories";
	public static final String LOCATIONS = "locations";
	public static final String ROAS = "roas";
	public static final String GBR = "gbr";

	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 1024 * 1024;

	public enum Type {
		CER, MFT, CRL, ROA, GBR, ROUTER_CER, OTHER;
	}

	private Long id;

	private Type type;

	private BigInteger serialNumber;

	private Instant signingTime;

	private Instant lastMarkedReachableAt;

	private byte[] authorityKeyIdentifier;

	private byte[] subjectKeyIdentifier;

	private byte[] sha256;

	private boolean isCa;

	private EncodedRpkiObject encodedRpkiObject;

	private Set<Long> rpkiRepositories;

	private SortedSet<String> locations;

	private List<Roa> roas;

	private Gbr gbr;

	public RpkiObject() {
		this.rpkiRepositories = new HashSet<>();
		this.locations = new TreeSet<>();
		this.roas = new ArrayList<>();
	}

	public RpkiObject(URI location, Long rpkiRepositoryId, CertificateRepositoryObject object) {
		this(location.toASCIIString(), rpkiRepositoryId, object);
	}

	public RpkiObject(String location, Long rpkiRepositoryId, CertificateRepositoryObject object) {
		this();
		this.rpkiRepositories.add(rpkiRepositoryId);
		this.locations.add(location);
		byte[] encoded = object.getEncoded();
		this.sha256 = Sha256.hash(encoded);
		this.encodedRpkiObject = new EncodedRpkiObject(this, encoded);
		this.lastMarkedReachableAt = Instant.now();
		this.isCa = false;
		if (object instanceof X509ResourceCertificate) {
			X509ResourceCertificate certificate = (X509ResourceCertificate) object;
			this.serialNumber = certificate.getSerialNumber();
			this.signingTime = null; // Use not valid before instead?
			this.authorityKeyIdentifier = certificate.getAuthorityKeyIdentifier();
			this.subjectKeyIdentifier = certificate.getSubjectKeyIdentifier();
			this.type = Type.CER; // FIXME separate certificate types? CA, EE, Router, ?
			this.isCa = certificate.isCa();
		} else if (object instanceof X509RouterCertificate) {
			X509RouterCertificate certificate = (X509RouterCertificate) object;
			this.serialNumber = certificate.getSerialNumber();
			this.signingTime = null;
			this.authorityKeyIdentifier = certificate.getAuthorityKeyIdentifier();
			this.subjectKeyIdentifier = certificate.getSubjectKeyIdentifier();
			this.type = Type.ROUTER_CER;
			this.isCa = certificate.isCa();
		} else if (object instanceof X509Crl) {
			this.serialNumber = ((X509Crl) object).getNumber();
			this.signingTime = Instant.ofEpochMilli(((X509Crl) object).getThisUpdateTime().getMillis());
			this.authorityKeyIdentifier = ((X509Crl) object).getAuthorityKeyIdentifier();
			this.type = Type.CRL;
		} else if (object instanceof RpkiSignedObject) {
			RpkiSignedObject signedObject = (RpkiSignedObject) object;
			this.serialNumber = signedObject.getCertificate().getSerialNumber();
			this.signingTime = Instant.ofEpochMilli(signedObject.getSigningTime().getMillis());
			this.authorityKeyIdentifier = signedObject.getCertificate().getAuthorityKeyIdentifier();
			this.subjectKeyIdentifier = signedObject.getCertificate().getSubjectKeyIdentifier();
			if (object instanceof ManifestCms) {
				this.type = Type.MFT;
			} else if (object instanceof RoaCms) {
				RoaCms roaCms = (RoaCms) object;
				this.type = Type.ROA;
				this.roas = roaCms.getPrefixes().stream()
						.map(prefix -> Roa.of(prefix.getPrefix(), prefix.getMaximumLength(), roaCms.getAsn()))
						.collect(Collectors.toList());
			} else if (object instanceof GhostbustersCms) {
				GhostbustersCms gbrCms = (GhostbustersCms) object;
				this.type = Type.GBR;
				this.gbr = new Gbr(gbrCms.getVCardContent());
			} else {
				this.type = Type.OTHER;
			}
		} else if (object instanceof UnknownCertificateRepositoryObject) {
			// FIXME store these at all?
			throw new IllegalArgumentException("unsupported certificate repository object type " + object);
		} else {
			throw new IllegalArgumentException("unsupported certificate repository object type " + object);
		}
	}

	public boolean addRpkiRepository(Long rpkiRepositoryId) {
		return this.rpkiRepositories.add(rpkiRepositoryId);
	}

	public void addLocation(String location) {
		this.locations.add(location);
	}

	public void removeLocation(String location) {
		this.locations.remove(location);
	}

	/**
	 * Mark this object as currently reachable by following a chain of references
	 * from the trust anchors through manifest to this object.
	 */
	public void markReachable(Instant now) {
		this.lastMarkedReachableAt = now;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RpkiObject.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(TYPE).append("=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append(SERIAL_NUMBER).append("=").append(serialNumber != null ? serialNumber : "null");
		sb.append(", ");
		sb.append(SIGNING_TIME).append("=").append(signingTime != null ? signingTime : "null");
		sb.append(", ");
		sb.append(LAST_MARK_REACHABLE_AT).append("=")
				.append(lastMarkedReachableAt != null ? lastMarkedReachableAt : "null");
		sb.append(", ");
		sb.append(AUTHORITY_KEY_IDENTIFIER).append("=")
				.append(authorityKeyIdentifier != null ? authorityKeyIdentifier : "null");
		sb.append(", ");
		sb.append(SUBJECT_KEY_IDENTIFIER).append("=")
				.append(subjectKeyIdentifier != null ? subjectKeyIdentifier : "null");
		sb.append(", ");
		sb.append(SHA256).append("=").append(sha256 != null ? sha256 : "null");
		sb.append(", ");
		sb.append(IS_CA).append("=").append(isCa);
		sb.append(", ");
		sb.append(ENCODED_RPKI_OBJECT).append("=").append(encodedRpkiObject != null ? encodedRpkiObject : "null");
		sb.append(", ");
		sb.append(RPKI_REPOSITORIES).append("=").append(rpkiRepositories != null ? rpkiRepositories : "null");
		sb.append(", ");
		sb.append(LOCATIONS).append("=").append(locations != null ? locations : "null");
		sb.append(", ");
		sb.append(ROAS).append("=").append(roas != null ? roas : "null");
		sb.append(", ");
		sb.append(GBR).append("=").append(gbr != null ? gbr : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((signingTime == null) ? 0 : signingTime.hashCode());
		result = prime * result + ((authorityKeyIdentifier == null) ? 0 : authorityKeyIdentifier.hashCode());
		result = prime * result + ((subjectKeyIdentifier == null) ? 0 : subjectKeyIdentifier.hashCode());
		result = prime * result + ((sha256 == null) ? 0 : sha256.hashCode());
		result = prime * result + (isCa ? 1 : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RpkiObject))
			return false;
		RpkiObject other = (RpkiObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (signingTime == null) {
			if (other.signingTime != null)
				return false;
		} else if (!signingTime.equals(other.signingTime))
			return false;
		if (!Arrays.equals(authorityKeyIdentifier, other.authorityKeyIdentifier)) {
			return false;
		}
		if (!Arrays.equals(subjectKeyIdentifier, other.subjectKeyIdentifier)) {
			return false;
		}
		if (!Arrays.equals(sha256, other.sha256)) {
			return false;
		}
		if (isCa != other.isCa) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public BigInteger getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(BigInteger serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Instant getSigningTime() {
		return this.signingTime;
	}

	public void setSigningTime(Instant signingTime) {
		this.signingTime = signingTime;
	}

	public Instant getLastMarkedReachableAt() {
		return this.lastMarkedReachableAt;
	}

	public void setLastMarkedReachableAt(Instant lastMarkedReachableAt) {
		this.lastMarkedReachableAt = lastMarkedReachableAt;
	}

	public byte[] getAuthorityKeyIdentifier() {
		return this.authorityKeyIdentifier;
	}

	public void setAuthorityKeyIdentifier(byte[] authorityKeyIdentifier) {
		this.authorityKeyIdentifier = authorityKeyIdentifier;
	}

	public byte[] getSubjectKeyIdentifier() {
		return this.subjectKeyIdentifier;
	}

	public void setSubjectKeyIdentifier(byte[] subjectKeyIdentifier) {
		this.subjectKeyIdentifier = subjectKeyIdentifier;
	}

	public byte[] getSha256() {
		return this.sha256;
	}

	public void setSha256(byte[] sha256) {
		this.sha256 = sha256;
	}

	public boolean isCa() {
		return this.isCa;
	}

	public void setIsCa(boolean isCa) {
		this.isCa = isCa;
	}

	public EncodedRpkiObject getEncodedRpkiObject() {
		return encodedRpkiObject;
	}

	public void setEncodedRpkiObject(EncodedRpkiObject encodedRpkiObject) {
		this.encodedRpkiObject = encodedRpkiObject;
	}

	public Set<Long> getRpkiRepositories() {
		return this.rpkiRepositories;
	}

	public void setRpkiRepositories(Set<Long> rpkiRepositories) {
		this.rpkiRepositories = rpkiRepositories;
	}

	public SortedSet<String> getLocations() {
		return this.locations;
	}

	public void setLocations(SortedSet<String> locations) {
		this.locations = locations;
	}

	public List<Roa> getRoas() {
		return this.roas;
	}

	public void setRoas(List<Roa> roas) {
		this.roas = roas;
	}

	public Gbr getGbr() {
		return this.gbr;
	}

	public void setGbr(Gbr gbr) {
		this.gbr = gbr;
	}
}