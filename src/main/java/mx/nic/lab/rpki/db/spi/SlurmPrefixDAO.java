package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
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
	 * Get all the SLURM Prefixes
	 * 
	 * @return The list of {@link SlurmPrefix}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmPrefix> getAll() throws ApiDataAccessException;

	/**
	 * Get all the SLURM Prefixes by its type
	 * 
	 * @param type
	 *            type of the prefix (filter or assertion)
	 * @return The list of {@link SlurmPrefix}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmPrefix> getAllByType(int type) throws ApiDataAccessException;
}
