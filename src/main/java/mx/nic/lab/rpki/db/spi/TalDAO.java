package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.PagingParameters;
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
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The list of {@link Tal}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<Tal> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

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

	/**
	 * Creates a new Tal
	 * 
	 * @param tal
	 * @return the ID of the {@link Tal} newly created
	 * @throws ApiDataAccessException
	 */
	public Long create(Tal tal) throws ApiDataAccessException;

	/**
	 * Deletes the specified Tal
	 * 
	 * @param tal
	 * @return <code>boolean</code> indicating success or failure
	 * @throws ApiDataAccessException
	 */
	public boolean delete(Tal tal) throws ApiDataAccessException;

	/**
	 * Update the loaded certificate of a TAL
	 * 
	 * @param tal
	 * @return <code>boolean</code> indicating success or failure
	 * @throws ApiDataAccessException
	 */
	public boolean updateLoadedCertificate(Tal tal) throws ApiDataAccessException;
}
