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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	public static final String TAL = "tal";
	public static final String TAL_CERTIFICATE_URI = "talCertificateURI";
	public static final String RPKI_REPOSITORIES = "rpkiRepositories";
	public static final String RPKI_OBJECTS = "rpkiObjects";
	public static final String VALIDATED_OBJECTS = "validatedObjects";
	public static final String VALIDATION_CHECKS = "validationChecks";

	public enum Status {
		RUNNING, SUCCEEDED, FAILED;
	}

	private Long id;

	private Instant updatedAt;

	private Instant completedAt;

	private Status status;

	private Tal tal;

	private String talCertificateURI;

	private Set<RpkiRepository> rpkiRepositories = new HashSet<>();

	private Set<RpkiObject> rpkiObjects = new HashSet<>();

	private Set<RpkiObject> validatedObjects = new HashSet<>();

	private List<ValidationCheck> validationChecks = new ArrayList<>();

	public ValidationRun() {
	}

	public ValidationRun(Tal tal) {
		this.tal = tal;
		this.talCertificateURI = tal.getTalUris().get(0).getLocation();
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
				if (check.getStatus() != ValidationStatus.PASSED) {
					ValidationCheck validationCheck = new ValidationCheck(this, location.getName(), check);
					addCheck(validationCheck);
				}
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
			if (c.getStatus() != ValidationStatus.PASSED) {
				final ValidationCheck.Status status = ValidationCheck.mapStatus(c.getStatus());
				addCheck(new ValidationCheck(this, validationResult.getCurrentLocation().getName(), status, c.getKey(),
						c.getParams()));
			}
		});
	}

	public void addRpkiObject(RpkiObject rpkiObject) {
		rpkiObjects.add(rpkiObject);
	}

	public void visit(Visitor visitor) {
		visitor.accept(this);
	}

	public boolean addRpkiRepository(RpkiRepository repository) {
		return getRpkiRepositories().add(repository);
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
		sb.append(TAL).append("=").append(tal != null ? tal : "null");
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
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((completedAt == null) ? 0 : completedAt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tal == null) ? 0 : tal.hashCode());
		result = prime * result + ((talCertificateURI == null) ? 0 : talCertificateURI.hashCode());
		result = prime * result + ((rpkiRepositories == null) ? 0 : rpkiRepositories.hashCode());
		result = prime * result + ((rpkiObjects == null) ? 0 : rpkiObjects.hashCode());
		result = prime * result + ((validatedObjects == null) ? 0 : validatedObjects.hashCode());
		result = prime * result + ((validationChecks == null) ? 0 : validationChecks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ValidationRun))
			return false;
		ValidationRun other = (ValidationRun) obj;
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
		if (completedAt == null) {
			if (other.completedAt != null)
				return false;
		} else if (!completedAt.equals(other.completedAt))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tal == null) {
			if (other.tal != null)
				return false;
		} else if (!tal.equals(other.tal))
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
		if (rpkiObjects == null) {
			if (other.rpkiObjects != null)
				return false;
		} else if (!rpkiObjects.equals(other.rpkiObjects))
			return false;
		if (validatedObjects == null) {
			if (other.validatedObjects != null)
				return false;
		} else if (!validatedObjects.equals(other.validatedObjects))
			return false;
		if (validationChecks == null) {
			if (other.validationChecks != null)
				return false;
		} else if (other.validationChecks == null || validationChecks.size() != other.validationChecks.size()
				|| !validationChecks.containsAll(other.validationChecks))
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

	public Tal getTal() {
		return tal;
	}

	public void setTal(Tal tal) {
		this.tal = tal;
	}

	public String getTalCertificateURI() {
		return talCertificateURI;
	}

	public void setTalCertificateURI(String talCertificateURI) {
		this.talCertificateURI = talCertificateURI;
	}

	public Set<RpkiRepository> getRpkiRepositories() {
		return rpkiRepositories;
	}

	public void setRpkiRepositories(Set<RpkiRepository> rpkiRepositories) {
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

	public List<ValidationCheck> getValidationChecks() {
		return validationChecks;
	}

	public void setValidationChecks(List<ValidationCheck> validationChecks) {
		this.validationChecks = validationChecks;
	}
}
