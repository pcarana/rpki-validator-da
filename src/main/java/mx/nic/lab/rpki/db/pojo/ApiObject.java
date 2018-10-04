package mx.nic.lab.rpki.db.pojo;

/**
 * Abstract class to represent an API object
 *
 */
public abstract class ApiObject {

	/**
	 * Minimum value permitted by an ASN, declared here since multiple objects can
	 * use it
	 */
	public static final long ASN_MIN_VALUE = 0L;

	/**
	 * Maximum value permitted by an ASN, declared here since multiple objects can
	 * use it
	 */
	public static final long ASN_MAX_VALUE = 4294967295L;

}
