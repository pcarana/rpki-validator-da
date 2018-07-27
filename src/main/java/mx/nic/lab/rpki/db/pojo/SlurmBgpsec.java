package mx.nic.lab.rpki.db.pojo;

/**
 * SLURM BGPsec (filters and assertions) represented as an API object
 *
 */
public class SlurmBgpsec extends ApiObject {

	/**
	 * SLURM BGPsec ID
	 */
	private Long id;

	/**
	 * ASN of the BGPsec
	 */
	private Integer asn;

	/**
	 * Text representation of SKI
	 */
	private String ski;

	/**
	 * Text representation of the Public Key
	 */
	private String publicKey;

	/**
	 * BGPsec type (filter or assertion)
	 */
	private Integer type;

	/**
	 * Comment to the BGPsec
	 */
	private String comment;

	/**
	 * Possible SLURM BGPsec types
	 */
	public static final int TYPE_FILTER = 1;
	public static final int TYPE_ASSERTION = 2;

	public SlurmBgpsec() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(SlurmBgpsec.class.getName());
		sb.append("[");
		sb.append("id=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append("asn=").append(asn != null ? asn : "null");
		sb.append(", ");
		sb.append("ski=").append(ski != null ? ski : "null");
		sb.append(", ");
		sb.append("publicKey=").append(publicKey != null ? publicKey : "null");
		sb.append(", ");
		sb.append("type=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append("comment=").append(comment != null ? comment : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((asn == null) ? 0 : asn.hashCode());
		result = prime * result + ((ski == null) ? 0 : ski.hashCode());
		result = prime * result + ((publicKey == null) ? 0 : publicKey.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
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
		if (publicKey == null) {
			if (other.publicKey != null)
				return false;
		} else if (!publicKey.equals(other.publicKey))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAsn() {
		return asn;
	}

	public void setAsn(Integer asn) {
		this.asn = asn;
	}

	public String getSki() {
		return ski;
	}

	public void setSki(String ski) {
		this.ski = ski;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
