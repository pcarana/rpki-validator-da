package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RouteValidation;

/**
 * Interface for {@link RouteValidation} DAO functions
 *
 */
public interface RouteValidationDAO extends DAO {

	/**
	 * Validate a prefix against the validated ROAs
	 * 
	 * @return The result of the validation as a {@link RouteValidation}
	 * @throws ApiDataAccessException
	 */
	public RouteValidation validate(Long asn, byte[] prefix, Integer prefixLength) throws ApiDataAccessException;

}
