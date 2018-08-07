package mx.nic.lab.rpki.db.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic exception to handle multiple {@link ValidationError}s found at the
 * implementation, extends from {@link ApiDataAccessException}
 *
 */
public class ValidationException extends ApiDataAccessException {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * List of {@link ValidationError}s found
	 */
	private List<ValidationError> validationErrors;

	public ValidationException() {
		super();
		validationErrors = new ArrayList<>();
	}

	public ValidationException(List<ValidationError> validationErrors) {
		super();
		this.validationErrors = new ArrayList<>();
		if (validationErrors != null) {
			this.validationErrors.addAll(validationErrors);
		}
	}

	public ValidationException(ValidationError validationError) {
		super();
		this.validationErrors = new ArrayList<>();
		if (validationError != null) {
			this.validationErrors.add(validationError);
		}
	}

	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}
}
