package mx.nic.lab.rpki.db.spi;

import java.util.LinkedHashMap;
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
	 * Get all the SLURM BGPsecs considering limit, offset and sort (if desired)
	 * 
	 * @param limit
	 *            Result limit, a value less than or equal to 0 will be treated as
	 *            "no limit"
	 * @param offset
	 *            Result limit offset, if no limit is desired then the offset will
	 *            be ignored, a value less than 0 will be treated as "no offset"
	 * @param sort
	 *            Map of properties used for sort, the key is the property and the
	 *            value is the order (asc o desc), a null value will treated as "no
	 *            sort"
	 * @return The list of {@link SlurmBgpsec}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmBgpsec> getAll(int limit, int offset, LinkedHashMap<String, String> sort)
			throws ApiDataAccessException;

	/**
	 * Get all the SLURM BGPsecs by its type and considering limit, offset and sort
	 * (if desired)
	 * 
	 * @param type
	 *            type of the BGPsec (filter or assertion)
	 * @param limit
	 *            Result limit, a value less than or equal to 0 will be treated as
	 *            "no limit"
	 * @param offset
	 *            Result limit offset, if no limit is desired then the offset will
	 *            be ignored, a value less than 0 will be treated as "no offset"
	 * @param sort
	 *            Map of properties used for sort, the key is the property and the
	 *            value is the order (asc o desc), a null value will treated as "no
	 *            sort"
	 * @return The list of {@link SlurmBgpsec}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<SlurmBgpsec> getAllByType(int type, int limit, int offset, LinkedHashMap<String, String> sort)
			throws ApiDataAccessException;

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
