package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.PagingParameters;
import mx.nic.lab.rpki.db.pojo.SlurmPrefix;

/**
 * Interface for {@link SlurmPrefix} DAO functions
 *
 */
public interface SlurmPrefixDAO extends DAO {

	/**
	 * Get a SLURM Prefix by its ID
	 * 
	 * @param id
	 * @return The {@link SlurmPrefix} or null if not found
	 * @throws ApiDataAccessException
	 */
	public SlurmPrefix getById(Long id) throws ApiDataAccessException;

	/**
	 * Get all the SLURM Prefixes considering limit, offset and sort (if desired)
	 * 
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The list of {@link SlurmPrefix}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmPrefix> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

	/**
	 * Get all the SLURM Prefixes by its type and considering limit, offset and sort
	 * (if desired)
	 * 
	 * @param type
	 *            type of the prefix (filter or assertion)
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The list of {@link SlurmPrefix}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmPrefix> getAllByType(int type, PagingParameters pagingParams) throws ApiDataAccessException;

	/**
	 * Creates a new SLURM Prefix using the sent type. Runs the validations
	 * according to the type and returns the ID of the new object created.
	 * 
	 * @param newSlurmPrefix
	 *            {@link SlurmPrefix} that will be created
	 * @return the ID of the {@link SlurmPrefix} newly created
	 * @throws ApiDataAccessException
	 */
	public Long create(SlurmPrefix newSlurmPrefix) throws ApiDataAccessException;

	/**
	 * Deletes a SLURM Prefix by its id, returns a <code>true</code> in case of
	 * success.
	 * 
	 * @param id
	 *            the Prefix ID
	 * @return <code>boolean</code> indicating success or failure
	 * @throws ApiDataAccessException
	 */
	public boolean deleteById(Long id) throws ApiDataAccessException;
}
