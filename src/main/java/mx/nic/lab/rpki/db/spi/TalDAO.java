package mx.nic.lab.rpki.db.spi;

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
	 * Get all the configured Tals
	 * 
	 * @return The list of {@link Tal}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<Tal> getAll() throws ApiDataAccessException;

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
