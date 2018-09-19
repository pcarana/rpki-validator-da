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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.ripe.rpki.commons.validation.ValidationLocation;
import net.ripe.rpki.commons.validation.ValidationResult;
import net.ripe.rpki.commons.validation.ValidationStatus;

public class ValidationRun {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = ValidationRun.class.getSimpleName();
	public static final String ID = "id";
	public static final String UPDATED_AT = "updatedAt";
	public static final String COMPLETED_AT = "completedAt";
	public static final String STATUS = "status";
	public static final String TYPE = "type";
	public static final String TAL_ID = "talId";
	public static final String TAL_CERTIFICATE_URI = "talCertificateURI";
	public static final String RPKI_REPOSITORIES = "rpkiRepositories";
	public static final String RPKI_OBJECTS = "rpkiObjects";
	public static final String VALIDATED_OBJECTS = "validatedObjects";
	public static final String VALIDATION_CHECKS = "validationChecks";

	public enum Status {
		RUNNING, SUCCEEDED, FAILED;
	}

	public enum Type {
		TRUST_ANCHOR, CERTIFICATE_TREE, RPKI_REPOSITORY;
	}

	private Long id;

	private Instant updatedAt;

	private Instant completedAt;

	private Status status;

	private Type type;

	private Long talId;

	private String talCertificateURI;

	private Set<Long> rpkiRepositories;

	private Set<RpkiObject> rpkiObjects;

	private Set<RpkiObject> validatedObjects;

	private Set<ValidationCheck> validationChecks;

	public ValidationRun(Type type) {
		this.type = type;
		this.status = Status.RUNNING;
		this.rpkiRepositories = new HashSet<>();
		this.rpkiObjects = new HashSet<>();
		this.validatedObjects = new HashSet<>();
		this.validationChecks = new HashSet<>();
	}

	public ValidationRun(Type type, Long talId, String talCertificateUri) {
		this(type);
		this.talId = talId;
		this.talCertificateURI = talCertificateUri;
	}

	public boolean isSucceeded() {
		return this.status == Status.SUCCEEDED;
	}

	public boolean isFailed() {
		return this.status == Status.FAILED;
	}

	public void setSucceeded() {
		this.completedAt = Instant.now();
		this.status = Status.SUCCEEDED;
	}

	public void setFailed() {
		this.completedAt = Instant.now();
		this.status = Status.FAILED;
	}

	public void completeWith(ValidationResult validationResult) {
		for (ValidationLocation location : validationResult.getValidatedLocations()) {
			for (net.ripe.rpki.commons.validation.ValidationCheck check : validationResult
					.getAllValidationChecksForLocation(location)) {
				ValidationCheck validationCheck = null;
				if (check.getStatus() != ValidationStatus.PASSED) {
					validationCheck = new ValidationCheck(this.getId(), location.getName(), check);
				} else {
					validationCheck = new ValidationCheck(this.getId(), location.getName(), check);
					validationCheck.setKey(null);
					validationCheck.setParameters(Collections.emptyList());
				}
				addCheck(validationCheck);
			}
		}
		if (!isFailed()) {
			setSucceeded();
		}
	}

	public void addCheck(ValidationCheck validationCheck) {
		this.validationChecks.add(validationCheck);
	}

	public void addChecks(ValidationResult validationResult) {
		validationResult.getAllValidationChecksForCurrentLocation().forEach(c -> {
			final ValidationCheck.Status status = ValidationCheck.mapStatus(c.getStatus());
			ValidationCheck validationCheck = null;
			if (c.getStatus() != ValidationStatus.PASSED) {
				validationCheck = new ValidationCheck(this.getId(), validationResult.getCurrentLocation().getName(),
						status, c.getKey(), c.getParams());
			} else {
				validationCheck = new ValidationCheck(this.getId(), validationResult.getCurrentLocation().getName(),
						status, null, new String[0]);
			}
			addCheck(validationCheck);
		});
	}

	public void addRpkiObject(RpkiObject rpkiObject) {
		rpkiObjects.add(rpkiObject);
	}

	public void visit(Visitor visitor) {
		visitor.accept(this);
	}

	public boolean addRpkiRepository(RpkiRepository repository) {
		return getRpkiRepositories().add(repository.getId());
	}

	public interface Visitor {
		default void accept(ValidationRun validationRun) {
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidationRun.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(UPDATED_AT).append("=").append(updatedAt != null ? updatedAt : "null");
		sb.append(", ");
		sb.append(COMPLETED_AT).append("=").append(completedAt != null ? completedAt : "null");
		sb.append(", ");
		sb.append(STATUS).append("=").append(status != null ? status : "null");
		sb.append(", ");
		sb.append(TYPE).append("=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append(TAL_ID).append("=").append(talId != null ? talId : "null");
		sb.append(", ");
		sb.append(TAL_CERTIFICATE_URI).append("=").append(talCertificateURI != null ? talCertificateURI : "null");
		sb.append(", ");
		sb.append(RPKI_REPOSITORIES).append("=").append(rpkiRepositories != null ? rpkiRepositories : "null");
		sb.append(", ");
		sb.append(RPKI_OBJECTS).append("=").append(rpkiObjects != null ? rpkiObjects : "null");
		sb.append(", ");
		sb.append(VALIDATED_OBJECTS).append("=").append(validatedObjects != null ? validatedObjects : "null");
		sb.append(", ");
		sb.append(VALIDATION_CHECKS).append("=").append(validationChecks != null ? validationChecks : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((talId == null) ? 0 : talId.hashCode());
		result = prime * result + ((talCertificateURI == null) ? 0 : talCertificateURI.hashCode());
		result = prime * result + ((rpkiRepositories == null) ? 0 : rpkiRepositories.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ValidationRun))
			return false;
		ValidationRun other = (ValidationRun) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (talId == null) {
			if (other.talId != null)
				return false;
		} else if (!talId.equals(other.talId))
			return false;
		if (talCertificateURI == null) {
			if (other.talCertificateURI != null)
				return false;
		} else if (!talCertificateURI.equals(other.talCertificateURI))
			return false;
		if (rpkiRepositories == null) {
			if (other.rpkiRepositories != null)
				return false;
		} else if (!rpkiRepositories.equals(other.rpkiRepositories))
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

	public Instant getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Instant completedAt) {
		this.completedAt = completedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getTalId() {
		return talId;
	}

	public void setTalId(Long talId) {
		this.talId = talId;
	}

	public String getTalCertificateURI() {
		return talCertificateURI;
	}

	public void setTalCertificateURI(String talCertificateURI) {
		this.talCertificateURI = talCertificateURI;
	}

	public Set<Long> getRpkiRepositories() {
		return rpkiRepositories;
	}

	public void setRpkiRepositories(Set<Long> rpkiRepositories) {
		this.rpkiRepositories = rpkiRepositories;
	}

	public Set<RpkiObject> getRpkiObjects() {
		return rpkiObjects;
	}

	public void setRpkiObjects(Set<RpkiObject> rpkiObjects) {
		this.rpkiObjects = rpkiObjects;
	}

	public Set<RpkiObject> getValidatedObjects() {
		return validatedObjects;
	}

	public void setValidatedObjects(Set<RpkiObject> validatedObjects) {
		this.validatedObjects = validatedObjects;
	}

	public Set<ValidationCheck> getValidationChecks() {
		return validationChecks;
	}

	public void setValidationChecks(Set<ValidationCheck> validationChecks) {
		this.validationChecks = validationChecks;
	}
}
