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
import java.util.HashSet;
import java.util.Set;

public class RpkiRepository {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = RpkiRepository.class.getName();
	public static final String ID = "id";
	public static final String UPDATED_AT = "updatedAt";
	public static final String TRUST_ANCHORS = "trustAnchors";
	public static final String LOCATION_URI = "locationUri";
	public static final String PARENT_REPOSITORY = "parentRepository";

	private Long id;

	private Instant updatedAt;

	private Set<Tal> trustAnchors = new HashSet<>();

	private String locationUri;

	private RpkiRepository parentRepository;

	public RpkiRepository() {

	}

	public RpkiRepository(Tal tal, String location) {
		addTrustAnchor(tal);
		this.locationUri = location;
	}

	public void addTrustAnchor(Tal tal) {
		this.trustAnchors.add(tal);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RpkiRepository.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(UPDATED_AT).append("=").append(updatedAt != null ? updatedAt : "null");
		sb.append(", ");
		sb.append(TRUST_ANCHORS).append("=").append(trustAnchors != null ? trustAnchors : "null");
		sb.append(", ");
		sb.append(LOCATION_URI).append("=").append(locationUri != null ? locationUri : "null");
		sb.append(", ");
		sb.append(PARENT_REPOSITORY).append("=").append(parentRepository != null ? parentRepository : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trustAnchors == null) ? 0 : trustAnchors.hashCode());
		result = prime * result + ((locationUri == null) ? 0 : locationUri.hashCode());
		result = prime * result + ((parentRepository == null) ? 0 : parentRepository.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RpkiRepository))
			return false;
		RpkiRepository other = (RpkiRepository) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trustAnchors == null) {
			if (other.trustAnchors != null)
				return false;
		} else if (!trustAnchors.equals(other.trustAnchors))
			return false;
		if (locationUri == null) {
			if (other.locationUri != null)
				return false;
		} else if (!locationUri.equals(other.locationUri))
			return false;
		if (parentRepository == null) {
			if (other.parentRepository != null)
				return false;
		} else if (!parentRepository.equals(other.parentRepository))
			return false;
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

	public Set<Tal> getTrustAnchors() {
		return trustAnchors;
	}

	public void setTrustAnchors(Set<Tal> trustAnchors) {
		this.trustAnchors = trustAnchors;
	}

	public String getLocationUri() {
		return locationUri;
	}

	public void setLocationUri(String locationUri) {
		this.locationUri = locationUri;
	}

	public RpkiRepository getParentRepository() {
		return parentRepository;
	}

	public void setParentRepository(RpkiRepository parentRepository) {
		this.parentRepository = parentRepository;
	}
}
