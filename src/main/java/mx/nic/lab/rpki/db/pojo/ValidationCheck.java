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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.ripe.rpki.commons.validation.ValidationStatus;

public class ValidationCheck {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String VALIDATION_RUN_ID = "validationRunId";
	public static final String ID = "id";
	public static final String LOCATION = "location";
	public static final String STATUS = "status";
	public static final String KEY = "key";
	public static final String PARAMETERS = "parameters";

	public enum Status {
		PASSED, WARNING, ERROR;
	}

	private Long validationRunId;

	private Long id;

	private String location;

	private Status status;

	private String key;

	private List<String> parameters;

	public ValidationCheck() {
		this.parameters = new ArrayList<>();
	}

	public ValidationCheck(Long validationRunId, String location,
			net.ripe.rpki.commons.validation.ValidationCheck check) {
		this.validationRunId = validationRunId;
		this.location = location;
		this.status = mapStatus(check.getStatus());
		this.key = check.getKey();
		this.parameters = Arrays.asList(check.getParams());
	}

	public ValidationCheck(Long validationRunId, String location, Status status, String key, String... parameters) {
		this.validationRunId = validationRunId;
		this.location = location;
		this.status = status;
		this.key = key;
		this.parameters = Arrays.asList(parameters);
	}

	static Status mapStatus(ValidationStatus status) {
		switch (status) {
		case PASSED:
			return Status.PASSED;
		case WARNING:
			return Status.WARNING;
		case ERROR:
		case FETCH_ERROR:
			return Status.ERROR;
		}
		throw new IllegalArgumentException("Unknown status: " + status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidationCheck.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(VALIDATION_RUN_ID).append("=").append(validationRunId != null ? validationRunId : "null");
		sb.append(", ");
		sb.append(LOCATION).append("=").append(location != null ? location : "null");
		sb.append(", ");
		sb.append(STATUS).append("=").append(status != null ? status : "null");
		sb.append(", ");
		sb.append(KEY).append("=").append(key != null ? key : "null");
		sb.append(", ");
		sb.append(PARAMETERS).append("=").append(parameters != null ? parameters : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((validationRunId == null) ? 0 : validationRunId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ValidationCheck))
			return false;
		ValidationCheck other = (ValidationCheck) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (validationRunId == null) {
			if (other.validationRunId != null)
				return false;
		} else if (other.validationRunId == null || !validationRunId.equals(other.validationRunId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValidationRunId() {
		return this.validationRunId;
	}

	public void setValidationRunId(Long validationRunId) {
		this.validationRunId = validationRunId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getParameters() {
		return this.parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
