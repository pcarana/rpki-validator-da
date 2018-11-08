package mx.nic.lab.rpki.db.cert.tree;

import java.util.ArrayList;
import java.util.List;

import mx.nic.lab.rpki.db.pojo.RpkiObject;
import mx.nic.lab.rpki.db.pojo.RpkiObject.Type;

/**
 * Class to represent a node that's a Certificate that can have
 * {@link CertificationTreeNode} childs, extends from
 * {@link CertificationTreeNode}
 *
 */
public class CertificateNode extends CertificationTreeNode {

	/**
	 * ID of the object, must be an {@link RpkiObject} ID
	 */
	private long id;

	/**
	 * Total number of direct childs related to this certificate
	 */
	private int childCount;

	/**
	 * {@link CertificationTreeNode} childs of this certificate
	 */
	private List<CertificationTreeNode> childs;

	/**
	 * Default constructor
	 */
	public CertificateNode() {
		super();
		childs = new ArrayList<>();
		setType(Type.CER);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public List<CertificationTreeNode> getChilds() {
		return childs;
	}

	public void setChilds(List<CertificationTreeNode> childs) {
		this.childs = childs;
	}

}
