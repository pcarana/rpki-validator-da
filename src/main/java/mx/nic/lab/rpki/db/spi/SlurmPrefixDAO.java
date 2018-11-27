package mx.nic.lab.rpki.db.spi;

import java.util.Set;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.ListResult;
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
	 * @return The {@link ListResult} of {@link SlurmPrefix}s found
	 * @throws ApiDataAccessException
	 */
	public ListResult<SlurmPrefix> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

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
	 * @return The {@link ListResult} of {@link SlurmPrefix}s found
	 * @throws ApiDataAccessException
	 */
	public ListResult<SlurmPrefix> getAllByType(String type, PagingParameters pagingParams)
			throws ApiDataAccessException;

	/**
	 * Creates a new SLURM Prefix using the sent type. Runs the validations
	 * according to the type and returns a <code>boolean</code> to indicate if there
	 * was success storing the object
	 * 
	 * @param newSlurmPrefix
	 *            {@link SlurmPrefix} that will be created
	 * @return <code>boolean</code> to indicate if there was success storing the
	 *         object
	 * @throws ApiDataAccessException
	 */
	public boolean create(SlurmPrefix newSlurmPrefix) throws ApiDataAccessException;

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

	/**
	 * Get a prefix by its distinctive properties (comment not included), return
	 * <code>null</code> if there's no match
	 * 
	 * @param asn
	 *            Prefix's ASN
	 * @param prefix
	 *            Prefix
	 * @param prefixLength
	 *            Prefix length
	 * @param maxPrefixLength
	 *            Max prefix length (may be null)
	 * @param type
	 *            Prefix type (filter or assertion)
	 * @return the {@link SlurmPrefix} found or <code>null</code> if there's no
	 *         match
	 * @throws ApiDataAccessException
	 */
	public SlurmPrefix getPrefixByProperties(Long asn, byte[] prefix, Integer prefixLength, Integer maxPrefixLength,
			String type) throws ApiDataAccessException;

	/**
	 * Update the comment of a prefix
	 * 
	 * @param id
	 *            ID of the prefix
	 * @param newComment
	 *            New comment of the prefix
	 * @return Number of rows affected
	 * @throws ApiDataAccessException
	 */
	public int updateComment(Long id, String newComment) throws ApiDataAccessException;

	/**
	 * Update the order of a prefix inside the JSON array at the SLURM file,
	 * corresponding to the type (filter/assertion)
	 * 
	 * @param id
	 *            ID of the prefix
	 * @param newOrder
	 *            New order of the prefix
	 * @return Number of rows affected
	 * @throws ApiDataAccessException
	 */
	public int updateOrder(Long id, int newOrder) throws ApiDataAccessException;

	/**
	 * Delete all the prefixes sent at the {@link Set} of IDs
	 * 
	 * @param ids
	 *            {@link Set} of IDs to delete
	 * @throws ApiDataAccessException
	 */
	public void bulkDelete(Set<Long> ids) throws ApiDataAccessException;
}
