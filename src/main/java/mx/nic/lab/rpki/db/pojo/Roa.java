package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ROA represented as an API object
 *
 */
public class Roa extends ApiObject {

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
	 * CMS data where the ROA is contained
	 */
	private byte[] cmsData;

	/**
	 * TAL ID from where the ROA was loaded
	 */
	private Long talId;

	/**
	 * GBRs related to the ROA
	 */
	private List<Gbr> gbrs;

	public Roa() {
		super();
		gbrs = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Roa.class.getName());
		sb.append("[");
		sb.append("id=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append("asn=").append(asn != null ? asn : "null");
		sb.append(", ");
		sb.append("prefixText=").append(prefixText != null ? prefixText : "null");
		sb.append(", ");
		sb.append("startPrefix=").append(startPrefix != null ? startPrefix : "null");
		sb.append(", ");
		sb.append("endPrefix=").append(endPrefix != null ? endPrefix : "null");
		sb.append(", ");
		sb.append("prefixLength=").append(prefixLength != null ? prefixLength : "null");
		sb.append(", ");
		sb.append("prefixMaxLength=").append(prefixMaxLength != null ? prefixMaxLength : "null");
		sb.append(", ");
		sb.append("cmsData=").append(cmsData != null ? cmsData : "null");
		sb.append(", ");
		sb.append("talId=").append(talId != null ? talId : "null");
		sb.append(", ");
		sb.append("gbrs=").append(gbrs != null ? gbrs : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((asn == null) ? 0 : asn.hashCode());
		result = prime * result + ((prefixText == null) ? 0 : prefixText.hashCode());
		result = prime * result + ((startPrefix == null) ? 0 : startPrefix.hashCode());
		result = prime * result + ((endPrefix == null) ? 0 : endPrefix.hashCode());
		result = prime * result + ((prefixLength == null) ? 0 : prefixLength.hashCode());
		result = prime * result + ((prefixMaxLength == null) ? 0 : prefixMaxLength.hashCode());
		result = prime * result + ((cmsData == null) ? 0 : cmsData.hashCode());
		result = prime * result + ((talId == null) ? 0 : talId.hashCode());
		result = prime * result + ((gbrs == null) ? 0 : gbrs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Roa))
			return false;
		Roa other = (Roa) obj;
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
		if (!Arrays.equals(cmsData, other.cmsData)) {
			return false;
		}
		if (talId == null) {
			if (other.talId != null)
				return false;
		} else if (!talId.equals(other.talId))
			return false;
		if (gbrs == null) {
			if (other.gbrs != null)
				return false;
		} else if (other.gbrs == null || gbrs.size() != other.gbrs.size() || !gbrs.containsAll(other.gbrs))
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

	public byte[] getCmsData() {
		return cmsData;
	}

	public void setCmsData(byte[] cmsData) {
		this.cmsData = cmsData;
	}

	public Long getTalId() {
		return talId;
	}

	public void setTalId(Long talId) {
		this.talId = talId;
	}

	public List<Gbr> getGbrs() {
		return gbrs;
	}

	public void setGbrs(List<Gbr> gbrs) {
		this.gbrs = gbrs;
	}
}
