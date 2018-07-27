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
	 * Get all the SLURM BGPsec by its type
	 * 
	 * @param type
	 *            type of the BGPsec (filter or assertion)
	 * @return The list of {@link SlurmBgpsec}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmBgpsec> getAll(int type) throws ApiDataAccessException;
}
