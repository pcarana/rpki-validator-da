package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.ListResult;
import mx.nic.lab.rpki.db.pojo.PagingParameters;
import mx.nic.lab.rpki.db.pojo.SlurmBgpsec;

/**
 * Interface for {@link SlurmBgpsec} DAO functions
 *
 */
public interface SlurmBgpsecDAO extends DAO {

	/**
	 * Get a SLURM BGPsec by its ID
	 * 
	 * @param id
	 * @return The {@link SlurmBgpsec} or null if not found
	 * @throws ApiDataAccessException
	 */
	public SlurmBgpsec getById(Long id) throws ApiDataAccessException;

	/**
	 * Get all the SLURM BGPsecs considering limit, offset and sort (if desired)
	 * 
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The {@link ListResult} of {@link SlurmBgpsec}s found
	 * @throws ApiDataAccessException
	 */
	public ListResult<SlurmBgpsec> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

	/**
	 * Get all the SLURM BGPsecs by its type and considering limit, offset and sort
	 * (if desired)
	 * 
	 * @param type
	 *            type of the BGPsec (filter or assertion)
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The {@link ListResult} of {@link SlurmBgpsec}s found
	 * @throws ApiDataAccessException
	 */
	public ListResult<SlurmBgpsec> getAllByType(int type, PagingParameters pagingParams) throws ApiDataAccessException;

	/**
	 * Creates a new SLURM BGPsec using the sent type. Runs the validations
	 * according to the type and returns a <code>boolean</code> to indicate if there
	 * was success storing the object
	 * 
	 * @param newSlurmBgpsec
	 *            {@link SlurmBgpsec} that will be created
	 * @return <code>boolean</code> to indicate if there was success storing the
	 *         object
	 * @throws ApiDataAccessException
	 */
	public boolean create(SlurmBgpsec newSlurmBgpsec) throws ApiDataAccessException;

	/**
	 * Deletes a SLURM BGPsec by its id, returns <code>true</code> in case of
	 * success.
	 * 
	 * @param id
	 *            the BGPsec ID
	 * @return <code>boolean</code> indicating success or failure
	 * @throws ApiDataAccessException
	 */
	public boolean deleteById(Long id) throws ApiDataAccessException;
}
