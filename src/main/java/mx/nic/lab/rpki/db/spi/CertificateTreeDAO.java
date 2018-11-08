package mx.nic.lab.rpki.db.spi;

import mx.nic.lab.rpki.db.cert.tree.CertificationTreeNode;
import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RpkiObject;
import mx.nic.lab.rpki.db.pojo.Tal;

/**
 * Interface for {@link CertificationTreeNode} DAO functions
 *
 */
public interface CertificateTreeDAO extends DAO {

	/**
	 * Gets the certification tree using the {@link Tal}s loaded certificate as the
	 * root
	 * 
	 * @param talId
	 *            From where the tree will be obtained
	 * @return {@link CertificationTreeNode} with the found {@link Tal} as root
	 * @throws ApiDataAccessException
	 */
	public CertificationTreeNode getFromRoot(Long talId) throws ApiDataAccessException;

	/**
	 * Gets the certification tree using a child certificate (not the TALs loaded
	 * certificate) as the root of the tree, useful to get the childs/leafs of the
	 * tree
	 * 
	 * @param certId
	 *            ID of the certificate used as root (must be the ID of the
	 *            {@link RpkiObject})
	 * @return {@link CertificationTreeNode} with the found certificate as root, or
	 *         null if the ID sent doesn't correspond to a certificate
	 * @throws ApiDataAccessException
	 */
	public CertificationTreeNode getFromChild(Long certId) throws ApiDataAccessException;
}
