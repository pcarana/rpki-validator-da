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

	/**
	 * Get the last checksum of the SLURM file that was synchronized
	 * 
	 * @return SLURM checksum or null if there's no checksum yet
	 * @throws ApiDataAccessException
	 */
	public byte[] getLastChecksum() throws ApiDataAccessException;

	/**
	 * Update the last checksum of the SLURM file
	 * 
	 * @param newChecksum
	 *            New checksum to assign
	 * @return Number of affected rows
	 * @throws ApiDataAccessException
	 */
	public int updateLastChecksum(byte[] newChecksum) throws ApiDataAccessException;

	/**
	 * Delete the whole SLURM (filters and assertions)
	 * 
	 * @return Number of deleted rows
	 * @throws ApiDataAccessException
	 */
	public int deleteSlurm() throws ApiDataAccessException;
}
