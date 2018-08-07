package mx.nic.lab.rpki.db.exception;

/**
 * Possible error types that can be handled by a {@link ValidationError}
 *
 */
public enum ValidationErrorType {
	/**
	 * The object/value is null
	 */
	NULL,
	/**
	 * The object/value isn't null
	 */
	NOT_NULL,
	/**
	 * The object/value type isn't the adequate (e.g. an <code>int</code> was
	 * expected but a <code>boolean</code> was received)
	 */
	UNEXPECTED_TYPE,
	/**
	 * The object value isn't expected, useful for constants
	 */
	UNEXPECTED_VALUE,
	/**
	 * The object/value is lesser or greater than the expected value range
	 */
	VALUE_OUT_OF_RANGE,
	/**
	 * The object/value length is lesser or greater than the expected length range
	 */
	LENGTH_OUT_OF_RANGE,
	/**
	 * The object already exists
	 */
	OBJECT_EXISTS,
	/**
	 * The object doesn't exist
	 */
	OBJECT_NOT_EXISTS
}
