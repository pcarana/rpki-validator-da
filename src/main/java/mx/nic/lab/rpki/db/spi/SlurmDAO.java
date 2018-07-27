package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.Slurm;

/**
 * Interface for {@link Slurm} DAO functions
 *
 */
public interface SlurmDAO extends DAO {

	/**
	 * Get all the SLURM Prefixes and BGPsec
	 * 
	 * @return The complete {@link Slurm} or null if not found
	 * @throws ApiDataAccessException
	 */
	public Slurm getAll() throws ApiDataAccessException;

}
