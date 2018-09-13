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

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import net.ripe.rpki.commons.crypto.CertificateRepositoryObject;
import net.ripe.rpki.commons.crypto.util.CertificateRepositoryObjectFactory;
import net.ripe.rpki.commons.validation.ValidationResult;

public class EncodedRpkiObject extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String ID = "id";
	public static final String UPDATED_AT = "updatedAt";
	public static final String RPKI_OBJECT = "rpkiObject";
	public static final String ENCODED = "encoded";

	private Long id;

	private Instant updatedAt;

	private RpkiObject rpkiObject;

	private byte[] encoded;

	public EncodedRpkiObject() {
	}

	public EncodedRpkiObject(byte[] encoded) {
		this.encoded = encoded;
	}

	public EncodedRpkiObject(RpkiObject rpkiObject, byte[] encoded) {
		this.rpkiObject = rpkiObject;
		this.encoded = encoded;
	}

	public <T extends CertificateRepositoryObject> Optional<T> get(Class<T> clazz, ValidationResult validationResult) {
		ValidationResult temporary = ValidationResult.withLocation(validationResult.getCurrentLocation());
		try {
			return get(clazz, validationResult.getCurrentLocation().getName());
		} finally {
			validationResult.addAll(temporary);
		}
	}

	public <T extends CertificateRepositoryObject> Optional<T> get(final Class<T> clazz, final String location) {
		ValidationResult temporary = ValidationResult.withLocation(location);
		ValidationResult ignored = ValidationResult.withLocation(location);
		CertificateRepositoryObject candidate = CertificateRepositoryObjectFactory
				.createCertificateRepositoryObject(encoded, ignored // Ignore any parse errors, as all stored objects
																	// must be parsable
		);
		temporary.rejectIfNull(candidate, "rpki.object.parsable");
		if (temporary.hasFailureForCurrentLocation()) {
			return Optional.empty();
		}
		temporary.rejectIfFalse(clazz.isInstance(candidate), "rpki.object.type.matches", clazz.getSimpleName(),
				candidate.getClass().getSimpleName());
		if (temporary.hasFailureForCurrentLocation()) {
			return Optional.empty();
		}
		return Optional.of(clazz.cast(candidate));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(EncodedRpkiObject.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(UPDATED_AT).append("=").append(updatedAt != null ? updatedAt : "null");
		sb.append(", ");
		sb.append(RPKI_OBJECT).append("=").append(rpkiObject != null ? rpkiObject.getId() : "null");
		sb.append(", ");
		sb.append(ENCODED).append("=").append(encoded != null ? encoded : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((rpkiObject == null) ? 0 : rpkiObject.getId().hashCode());
		result = prime * result + ((encoded == null) ? 0 : encoded.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof EncodedRpkiObject))
			return false;
		EncodedRpkiObject other = (EncodedRpkiObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (rpkiObject == null) {
			if (other.rpkiObject != null)
				return false;
		} else if (other.rpkiObject == null || !rpkiObject.getId().equals(other.rpkiObject.getId()))
			return false;
		if (!Arrays.equals(encoded, other.encoded)) {
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

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public RpkiObject getRpkiObject() {
		return rpkiObject;
	}

	public void setRpkiObject(RpkiObject rpkiObject) {
		this.rpkiObject = rpkiObject;
	}

	public byte[] getEncoded() {
		return this.encoded;
	}

	public void setEncoded(byte[] encoded) {
		this.encoded = encoded;
	}
}