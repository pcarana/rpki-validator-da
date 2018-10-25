package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.ListResult;
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
	 * @return The {@link ListResult} of {@link Tal}s found
	 * @throws ApiDataAccessException
	 */
	public ListResult<Tal> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

	/**
	 * Get a Tal that already exists, the search must be made by the unique fields
	 * of a {@link Tal}
	 * 
	 * @param tal
	 * @return The {@link Tal} or null if not found
	 * @throws ApiDataAccessException
	 */
	public Tal getExistentTal(Tal tal) throws ApiDataAccessException;

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
