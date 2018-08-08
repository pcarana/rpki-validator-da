package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RtrSession;

/**
 * Interface for {@link RtrSession} DAO functions
 *
 */
public interface RtrSessionDAO extends DAO {

	/**
	 * Get all the RTR sessions
	 * 
	 * @return List of RTR sessions or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<RtrSession> getAll() throws ApiDataAccessException;

}
