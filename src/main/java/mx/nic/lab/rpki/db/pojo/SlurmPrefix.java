package mx.nic.lab.rpki.db.pojo;

import java.util.Arrays;

/**
 * SLURM Prefix (filters and assertions) represented as an API object
 *
 */
public class SlurmPrefix extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = SlurmPrefix.class.getSimpleName();
	public static final String ID = "id";
	public static final String ASN = "asn";
	public static final String PREFIX_TEXT = "prefixText";
	public static final String START_PREFIX = "startPrefix";
	public static final String END_PREFIX = "endPrefix";
	public static final String PREFIX_LENGTH = "prefixLength";
	public static final String PREFIX_MAX_LENGTH = "prefixMaxLength";
	public static final String TYPE = "type";
	public static final String COMMENT = "comment";
	public static final String ORDER = "order";

	/**
	 * Possible SLURM Prefix types
	 */
	public static final String TYPE_FILTER = "filter";
	public static final String TYPE_ASSERTION = "assertion";
	/**
	 * SLURM Prefix ID
	 */
	private Long id;

	/**
	 * ASN of the prefix
	 */
	private Long asn;

	/**
	 * Text representation of the prefix
	 */
	private String prefixText;

	/**
	 * Initial IP address of the prefix
	 */
	private byte[] startPrefix;

	/**
	 * Last IP address of the prefix (calculated with the prefixMaxLength)
	 */
	private byte[] endPrefix;

	/**
	 * Prefix length
	 */
	private Integer prefixLength;

	/**
	 * Maximum prefix length
	 */
	private Integer prefixMaxLength;

	/**
	 * Prefix type (filter or assertion)
	 */
	private String type;

	/**
	 * Comment to the prefix
	 */
	private String comment;

	/**
	 * Order of the prefix inside the filters/assertions array
	 */
	private Integer order;

	public SlurmPrefix() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(SlurmPrefix.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(ASN).append("=").append(asn != null ? asn : "null");
		sb.append(", ");
		sb.append(PREFIX_TEXT).append("=").append(prefixText != null ? prefixText : "null");
		sb.append(", ");
		sb.append(START_PREFIX).append("=").append(startPrefix != null ? startPrefix : "null");
		sb.append(", ");
		sb.append(END_PREFIX).append("=").append(endPrefix != null ? endPrefix : "null");
		sb.append(", ");
		sb.append(PREFIX_LENGTH).append("=").append(prefixLength != null ? prefixLength : "null");
		sb.append(", ");
		sb.append(PREFIX_MAX_LENGTH).append("=").append(prefixMaxLength != null ? prefixMaxLength : "null");
		sb.append(", ");
		sb.append(TYPE).append("=").append(type != null ? type : "null");
		sb.append(", ");
		sb.append(COMMENT).append("=").append(comment != null ? comment : "null");
		sb.append(", ");
		sb.append(ORDER).append("=").append(order != null ? order : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((asn == null) ? 0 : asn.hashCode());
		result = prime * result + ((prefixText == null) ? 0 : prefixText.hashCode());
		result = prime * result + ((startPrefix == null) ? 0 : startPrefix.hashCode());
		result = prime * result + ((endPrefix == null) ? 0 : endPrefix.hashCode());
		result = prime * result + ((prefixLength == null) ? 0 : prefixLength.hashCode());
		result = prime * result + ((prefixMaxLength == null) ? 0 : prefixMaxLength.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SlurmPrefix))
			return false;
		SlurmPrefix other = (SlurmPrefix) obj;
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
		if (prefixText == null) {
			if (other.prefixText != null)
				return false;
		} else if (!prefixText.equals(other.prefixText))
			return false;
		if (!Arrays.equals(startPrefix, other.startPrefix)) {
			return false;
		}
		if (!Arrays.equals(endPrefix, other.endPrefix)) {
			return false;
		}
		if (prefixLength == null) {
			if (other.prefixLength != null)
				return false;
		} else if (!prefixLength.equals(other.prefixLength))
			return false;
		if (prefixMaxLength == null) {
			if (other.prefixMaxLength != null)
				return false;
		} else if (!prefixMaxLength.equals(other.prefixMaxLength))
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

	public String getPrefixText() {
		return prefixText;
	}

	public void setPrefixText(String prefixText) {
		this.prefixText = prefixText;
	}

	public byte[] getStartPrefix() {
		return startPrefix;
	}

	public void setStartPrefix(byte[] startPrefix) {
		this.startPrefix = startPrefix;
	}

	public byte[] getEndPrefix() {
		return endPrefix;
	}

	public void setEndPrefix(byte[] endPrefix) {
		this.endPrefix = endPrefix;
	}

	public Integer getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(Integer prefixLength) {
		this.prefixLength = prefixLength;
	}

	public Integer getPrefixMaxLength() {
		return prefixMaxLength;
	}

	public void setPrefixMaxLength(Integer prefixMaxLength) {
		this.prefixMaxLength = prefixMaxLength;
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
