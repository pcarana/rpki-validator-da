package mx.nic.lab.rpki.db.cert.tree;

import java.util.ArrayList;
import java.util.List;

import mx.nic.lab.rpki.db.pojo.RpkiObject.Type;

/**
 * Class to represent a ROA, includes a list of related ROA resources, extends
 * from {@link CertificationTreeNode}
 *
 */
public class RoaNode extends CertificationTreeNode {

	/**
	 * List of resources related to this object
	 */
	private List<ResourceNode> resources;

	/**
	 * Default constructor
	 */
	public RoaNode() {
		super();
		resources = new ArrayList<>();
		setType(Type.ROA);
	}

	public List<ResourceNode> getResources() {
		return resources;
	}

	public void setResources(List<ResourceNode> resources) {
		this.resources = resources;
	}

}
