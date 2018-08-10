package mx.nic.lab.rpki.db.spi;

import java.util.LinkedHashMap;
import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.Tal;

/**
 * Interface for {@link Tal} DAO functions
 *
 */
public interface TalDAO extends DAO {

	/**
	 * Get a Tal by its ID
	 * 
	 * @param id
	 * @return The {@link Tal} or null if not found
	 * @throws ApiDataAccessException
	 */
	public Tal getById(Long id) throws ApiDataAccessException;

	/**
	 * Get all the configured Tals considering limit, offset and sort (if desired)
	 * 
	 * @param limit
	 *            Result limit, a value less than or equal to 0 will be treated as
	 *            "no limit"
	 * @param offset
	 *            Result limit offset, if no limit is desired then the offset will
	 *            be ignored, a value less than 0 will be treated as "no offset"
	 * @param sort
	 *            Map of properties used for sort, the key is the property and the
	 *            value is the order (asc o desc), a null value will treated as "no
	 *            sort"
	 * @return The list of {@link Tal}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<Tal> getAll(int limit, int offset, LinkedHashMap<String, String> sort) throws ApiDataAccessException;

	/**
	 * Synchronize a Tal by its ID
	 * 
	 * @param id
	 * @return The {@link Tal} that will be synchronized or null if not found
	 * @throws ApiDataAccessException
	 */
	public Tal syncById(Long id) throws ApiDataAccessException;

	/**
	 * Synchronize all the configured Tals
	 * 
	 * @return The list of {@link Tal}s that will be synchronized
	 * @throws ApiDataAccessException
	 */
	public List<Tal> syncAll() throws ApiDataAccessException;
}
