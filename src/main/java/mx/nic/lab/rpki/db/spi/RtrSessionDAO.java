package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.PagingParameters;
import mx.nic.lab.rpki.db.pojo.RtrSession;

/**
 * Interface for {@link RtrSession} DAO functions
 *
 */
public interface RtrSessionDAO extends DAO {

	/**
	 * Get all the RTR sessions considering limit, offset and sort (if desired)
	 * 
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return List of RTR sessions or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<RtrSession> getAll(PagingParameters pagingParams) throws ApiDataAccessException;

}
