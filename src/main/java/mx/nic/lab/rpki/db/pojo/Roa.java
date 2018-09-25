package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.ripe.ipresource.Asn;
import net.ripe.ipresource.IpRange;
import net.ripe.ipresource.IpResourceType;

/**
 * ROA represented as an API object
 *
 */
public class Roa extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = Roa.class.getSimpleName();
	public static final String RPKI_OBJECT = "rpkiObject";
	public static final String ID = "id";
	public static final String ASN = "asn";
	public static final String PREFIX_TEXT = "prefixText";
	public static final String START_PREFIX = "startPrefix";
	public static final String END_PREFIX = "endPrefix";
	public static final String PREFIX_LENGTH = "prefixLength";
	public static final String PREFIX_MAX_LENGTH = "prefixMaxLength";
	public static final String PREFIX_FAMILY = "prefixFamily";
	public static final String GBRS = "gbrs";

	/**
	 * IPv4 family type
	 */
	public static final int FAMILY_IPV4 = 4;

	/**
	 * IPv6 family type
	 */
	public static final int FAMILY_IPV6 = 6;

	/**
	 * RpkiObject related
	 */
	private RpkiObject rpkiObject;

	/**
	 * ROA ID
	 */
	private Long id;

	/**
	 * ASN of the ROA
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
	 * Maximum prefix length for the ROA
	 */
	private Integer prefixMaxLength;

	/**
	 * Prefix IP family (4 or 6)
	 */
	private Integer prefixFamily;

	/**
	 * GBRs related to the ROA
	 */
	private List<Gbr> gbrs;

	public Roa() {
		super();
		gbrs = new ArrayList<>();
	}

	public static Roa of(IpRange prefix, Integer maximumLength, Asn asn) {
		Roa result = new Roa();
		result.setAsn(asn.longValue());
		result.setPrefixText(prefix.toString());
		result.setPrefixLength(prefix.getPrefixLength());
		if (maximumLength != null) {
			result.setPrefixMaxLength(maximumLength);
		} else {
			result.setPrefixMaxLength(prefix.getPrefixLength());
		}
		result.setPrefixFamily(prefix.getType() == IpResourceType.IPv4 ? FAMILY_IPV4 : FAMILY_IPV6);
		// The BigInteger#toByteArray() adds and extra byte sometimes (leading 0),
		// remove it
		int expectedLength = result.getPrefixFamily() == FAMILY_IPV4 ? 4 : 16;

		byte[] address = prefix.getStart().getValue().toByteArray();
		if (address.length > expectedLength) {
			address = Arrays.copyOfRange(address, 1, address.length);
		}
		result.setStartPrefix(address);

		address = prefix.getEnd().getValue().toByteArray();
		if (address.length > expectedLength) {
			address = Arrays.copyOfRange(address, 1, address.length);
		}
		result.setEndPrefix(address);
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Roa.class.getName());
		sb.append("[");
		sb.append(RPKI_OBJECT).append("=").append(rpkiObject != null ? rpkiObject.getId() : "null");
		sb.append(", ");
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
		sb.append(PREFIX_FAMILY).append("=").append(prefixFamily != null ? prefixFamily : "null");
		sb.append(", ");
		sb.append(GBRS).append("=").append(gbrs != null ? gbrs : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rpkiObject == null) ? 0 : rpkiObject.getId().hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((asn == null) ? 0 : asn.hashCode());
		result = prime * result + ((prefixText == null) ? 0 : prefixText.hashCode());
		result = prime * result + ((startPrefix == null) ? 0 : startPrefix.hashCode());
		result = prime * result + ((endPrefix == null) ? 0 : endPrefix.hashCode());
		result = prime * result + ((prefixLength == null) ? 0 : prefixLength.hashCode());
		result = prime * result + ((prefixMaxLength == null) ? 0 : prefixMaxLength.hashCode());
		result = prime * result + ((prefixFamily == null) ? 0 : prefixFamily.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Roa))
			return false;
		Roa other = (Roa) obj;
		if (rpkiObject == null) {
			if (other.rpkiObject != null)
				return false;
		} else if (other.rpkiObject == null || !rpkiObject.getId().equals(other.rpkiObject.getId()))
			return false;
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
		if (prefixFamily == null) {
			if (other.prefixFamily != null)
				return false;
		} else if (!prefixFamily.equals(other.prefixFamily))
			return false;
		return true;
	}

	public RpkiObject getRpkiObject() {
		return rpkiObject;
	}

	public void setRpkiObject(RpkiObject rpkiObject) {
		this.rpkiObject = rpkiObject;
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

	public Integer getPrefixFamily() {
		return prefixFamily;
	}

	public void setPrefixFamily(Integer prefixFamily) {
		this.prefixFamily = prefixFamily;
	}

	public List<Gbr> getGbrs() {
		return gbrs;
	}

	public void setGbrs(List<Gbr> gbrs) {
		this.gbrs = gbrs;
	}
}
