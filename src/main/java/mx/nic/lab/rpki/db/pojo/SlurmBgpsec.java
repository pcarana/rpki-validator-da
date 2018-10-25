package mx.nic.lab.rpki.db.pojo;

/**
 * SLURM BGPsec (filters and assertions) represented as an API object
 *
 */
public class SlurmBgpsec extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = SlurmBgpsec.class.getSimpleName();
	public static final String ID = "id";
	public static final String ASN = "asn";
	public static final String SKI = "ski";
	public static final String ROUTER_PUBLIC_KEY = "routerPublicKey";
	public static final String TYPE = "type";
	public static final String COMMENT = "comment";

	/**
	 * Possible SLURM BGPsec types
	 */
	public static final String TYPE_FILTER = "filter";
	public static final String TYPE_ASSERTION = "assertion";

	/**
	 * SLURM BGPsec ID
	 */
	private Long id;

	/**
	 * ASN of the BGPsec
	 */
	private Long asn;

	/**
	 * Text representation of SKI
	 */
	private String ski;

	/**
	 * Text representation of the Router's Public Key
	 */
	private String routerPublicKey;

	/**
	 * BGPsec type (filter or assertion)
	 */
	private String type;

	/**
	 * Comment to the BGPsec
	 */
	private String comment;

	public SlurmBgpsec() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(SlurmBgpsec.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(ASN).append("=").append(asn != null ? asn : "null");
		sb.append(", ");
		sb.append(SKI).append("=").append(ski != null ? ski : "null");
		sb.append(", ");
		sb.append(ROUTER_PUBLIC_KEY).append("=").append(routerPublicKey != null ? routerPublicKey : "null");
		sb.append(", ");
		sb.append(TYPE).append("=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append(COMMENT).append("=").append(comment != null ? comment : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((asn == null) ? 0 : asn.hashCode());
		result = prime * result + ((ski == null) ? 0 : ski.hashCode());
		result = prime * result + ((routerPublicKey == null) ? 0 : routerPublicKey.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SlurmBgpsec))
			return false;
		SlurmBgpsec other = (SlurmBgpsec) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (asn == null) {
			if (other.asn != null)
				return false;
		} else if (!asn.equals(other.asn))
			return false;
		if (ski == null) {
			if (other.ski != null)
				return false;
		} else if (!ski.equals(other.ski))
			return false;
		if (routerPublicKey == null) {
			if (other.routerPublicKey != null)
				return false;
		} else if (!routerPublicKey.equals(other.routerPublicKey))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAsn() {
		return asn;
	}

	public void setAsn(Long asn) {
		this.asn = asn;
	}

	public String getSki() {
		return ski;
	}

	public void setSki(String ski) {
		this.ski = ski;
	}

	public String getRouterPublicKey() {
		return routerPublicKey;
	}

	public void setRouterPublicKey(String routerPublicKey) {
		this.routerPublicKey = routerPublicKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
