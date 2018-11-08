package mx.nic.lab.rpki.db.cert.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.nic.lab.rpki.db.pojo.RpkiObject.Type;

/**
 * Common class used to represent a Certification Tree node, all the objects of
 * a certification tree can have a:
 * <li>Type (references to RpkiObject.{@link Type})
 * <li>List of locations (locations where the object can be found)
 * <li>SKI (subject key identifier, except for the CRLs or an unknown object)
 *
 */
public class CertificationTreeNode {

	/**
	 * Object type (references to RpkiObject.{@link Type})
	 */
	private Type type;

	/**
	 * Locations where the object can be found
	 */
	private List<String> locations;

	/**
	 * Subject Key Identifier (SKI) of the object
	 */
	private byte[] subjectKeyIdentifier;

	/**
	 * Default constructor
	 */
	public CertificationTreeNode() {
		locations = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(CertificationTreeNode.class.getName());
		sb.append("[");
		sb.append("type=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append("locations=").append(locations != null ? locations : "null");
		sb.append(", ");
		sb.append("subjectKeyIdentifier=").append(subjectKeyIdentifier != null ? subjectKeyIdentifier : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		result = prime * result + ((subjectKeyIdentifier == null) ? 0 : subjectKeyIdentifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CertificationTreeNode))
			return false;
		CertificationTreeNode other = (CertificationTreeNode) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (type.equals(other.type))
			return false;
		if (locations == null) {
			if (other.locations != null)
				return false;
		} else if (other.locations == null || locations.size() != other.locations.size()
				|| !locations.containsAll(other.locations))
			return false;
		if (!Arrays.equals(subjectKeyIdentifier, other.subjectKeyIdentifier)) {
			return false;
		}
		return true;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public byte[] getSubjectKeyIdentifier() {
		return subjectKeyIdentifier;
	}

	public void setSubjectKeyIdentifier(byte[] subjectKeyIdentifier) {
		this.subjectKeyIdentifier = subjectKeyIdentifier;
	}
}
