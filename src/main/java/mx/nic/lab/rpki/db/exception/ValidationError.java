package mx.nic.lab.rpki.db.exception;

/**
 * Object to represent a validation error from the DA implementation
 *
 */
public class ValidationError {

	/**
	 * Object name, can be the simple class name from where the error was found
	 */
	private String objectName;

	/**
	 * Field of the object where the error was found
	 */
	private String field;

	/**
	 * Value that caused the error
	 */
	private Object value;

	/**
	 * Expected min value/length (useful for ranges error)
	 */
	private long min;

	/**
	 * Expected max value/length (useful for ranges error)
	 */
	private long max;

	/**
	 * Error type that can be understood by the consumer
	 */
	private ValidationErrorType errorType;

	public ValidationError(String objectName, ValidationErrorType errorType) {
		this.objectName = objectName;
		this.errorType = errorType;
	}

	public ValidationError(String objectName, String field, Object value, ValidationErrorType errorType) {
		this.objectName = objectName;
		this.field = field;
		this.value = value;
		this.errorType = errorType;
	}

	public ValidationError(String objectName, String field, Object value, ValidationErrorType errorType, long min,
			long max) {
		this.objectName = objectName;
		this.field = field;
		this.value = value;
		this.errorType = errorType;
		this.min = min;
		this.max = max;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public ValidationErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ValidationErrorType errorType) {
		this.errorType = errorType;
	}
}
