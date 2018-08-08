package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
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
	 * Get all the SLURM BGPsecs
	 * 
	 * @return The list of {@link SlurmBgpsec}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmBgpsec> getAll() throws ApiDataAccessException;

	/**
	 * Get all the SLURM BGPsecs by its type
	 * 
	 * @param type
	 *            type of the BGPsec (filter or assertion)
	 * @return The list of {@link SlurmBgpsec}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmBgpsec> getAllByType(int type) throws ApiDataAccessException;

	/**
	 * Creates a new SLURM BGPsec using the sent type. Runs the validations
	 * according to the type and returns the ID of the new object created.
	 * 
	 * @param newSlurmBgpsec
	 *            {@link SlurmBgpsec} that will be created
	 * @return the ID of the {@link SlurmBgpsec} newly created
	 * @throws ApiDataAccessException
	 */
	public Long create(SlurmBgpsec newSlurmBgpsec) throws ApiDataAccessException;

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
