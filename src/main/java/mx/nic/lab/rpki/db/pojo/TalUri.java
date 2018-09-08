package mx.nic.lab.rpki.db.pojo;

/**
 * URI configured at a TAL as an API object
 *
 */
public class TalUri extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = TalUri.class.getSimpleName();
	public static final String ID = "id";
	public static final String TAL_ID = "talId";
	public static final String LOCATION = "location";

	/**
	 * TalUris ID
	 */
	private Long id;

	/**
	 * Related TAL ID
	 */
	private Long talId;

	/**
	 * URI value configured
	 */
	private String location;

	public TalUri() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(TalUri.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(TAL_ID).append("=").append(talId != null ? talId : "null");
		sb.append(", ");
		sb.append(LOCATION).append("=").append(location != null ? location : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((talId == null) ? 0 : talId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof TalUri))
			return false;
		TalUri other = (TalUri) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (talId == null) {
			if (other.talId != null)
				return false;
		} else if (!talId.equals(other.talId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTalId() {
		return talId;
	}

	public void setTalId(Long talId) {
		this.talId = talId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
