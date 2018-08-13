package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.PagingParameters;
import mx.nic.lab.rpki.db.pojo.Roa;

/**
 * Interface for {@link Roa} DAO functions
 *
 */
public interface RoaDAO extends DAO {

	/**
	 * Get a ROA by its ID
	 * 
	 * @param id
	 * @return The {@link Roa} or null if not found
	 * @throws ApiDataAccessException
	 */
	public Roa getById(Long id) throws ApiDataAccessException;

	/**
	 * Get all the ROAs considering limit, offset and sort (if desired)
	 * 
	 * @param pagingParams
	 *            {@link PagingParameters} to use at search, <code>null</code> is
	 *            accepted and should mean that no paging parameters will be used
	 *            (limit, offset, nor sort)
	 * @return The list of {@link Roa}s or empty list if not found
	 * @throws ApiDataAccessException
	 */
	public List<Roa> getAll(PagingParameters pagingParams) throws ApiDataAccessException;
}
