package mx.nic.lab.rpki.db.spi;

import java.util.LinkedHashMap;
import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RtrSession;

/**
 * Interface for {@link RtrSession} DAO functions
 *
 */
public interface RtrSessionDAO extends DAO {

	/**
	 * Get all the RTR sessions considering limit, offset and sort (if desired)
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
	 * @return List of RTR sessions or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<RtrSession> getAll(int limit, int offset, LinkedHashMap<String, String> sort)
			throws ApiDataAccessException;

}
