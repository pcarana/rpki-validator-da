package mx.nic.lab.rpki.db.spi;

import java.util.Set;

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
	public ListResult<SlurmBgpsec> getAllByType(String type, PagingParameters pagingParams)
			throws ApiDataAccessException;

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

	/**
	 * Get a SLURM BGPsec by its distinctive properties (comment not included),
	 * return <code>null</code> if there's no match
	 * 
	 * @param asn
	 *            ASN
	 * @param ski
	 *            SKI
	 * @param routerPublicKey
	 *            Router public key (may be null)
	 * @param type
	 *            SLURM BGPsec type (filter or assertion)
	 * @return the {@link SlurmBgpsec} found or <code>null</code> if there's no
	 *         match
	 * @throws ApiDataAccessException
	 */
	public SlurmBgpsec getBgpsecByProperties(Long asn, String ski, String routerPublicKey, String type)
			throws ApiDataAccessException;

	/**
	 * Update the comment of a SLURM BGPsec
	 * 
	 * @param id
	 *            ID of the SLURM BGPsec
	 * @param newComment
	 *            New comment of the SLURM BGPsec
	 * @return Number of rows affected
	 * @throws ApiDataAccessException
	 */
	public int updateComment(Long id, String newComment) throws ApiDataAccessException;

	/**
	 * Delete all the SLURM BGPsecs sent at the {@link Set} of IDs
	 * 
	 * @param ids
	 *            {@link Set} of IDs to delete
	 * @throws ApiDataAccessException
	 */
	public void bulkDelete(Set<Long> ids) throws ApiDataAccessException;
}
