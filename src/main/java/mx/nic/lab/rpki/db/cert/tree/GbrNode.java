package mx.nic.lab.rpki.db.cert.tree;

import mx.nic.lab.rpki.db.pojo.RpkiObject.Type;

/**
 * Class to represent a node that's a GBR and has a vCard, extends from
 * {@link CertificationTreeNode}
 *
 */
public class GbrNode extends CertificationTreeNode {

	/**
	 * vCard of the GBR
	 */
	private String vCard;

	/**
	 * Default constructor
	 */
	public GbrNode() {
		super();
		setType(Type.GBR);
	}

	public String getVCard() {
		return vCard;
	}

	public void setVCard(String vCard) {
		this.vCard = vCard;
	}

}
