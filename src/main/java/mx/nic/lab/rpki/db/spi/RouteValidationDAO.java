package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RouteValidation;

/**
 * Interface for {@link RouteValidation} DAO functions
 *
 */
public interface RouteValidationDAO extends DAO {

	/**
	 * Validate a prefix against the SLURM and validated ROAs
	 * 
	 * @param asn
	 *            ASN
	 * @param prefix
	 *            Prefix
	 * @param prefixLength
	 *            Prefix length
	 * @param fullCheck
	 *            Indicate if a full check will be done, if <code>false</code> then
	 *            the search must be made looking for the exact match
	 * @return The result of the validation as a {@link RouteValidation}
	 * @throws ApiDataAccessException
	 */
	public RouteValidation validate(Long asn, byte[] prefix, Integer prefixLength, boolean fullCheck)
			throws ApiDataAccessException;

}
