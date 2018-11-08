package mx.nic.lab.rpki.db.cert.tree;

import mx.nic.lab.rpki.db.pojo.Roa;

/**
 * Class to represent the basic data of a ROA, includes the ROA ID to relate it
 * with a {@link Roa}, this object can only be used by {@link RoaNode}
 *
 */
public class ResourceNode {

	/**
	 * ASN
	 */
	private Long asn;

	/**
	 * Text representation of the prefix, including the prefix length
	 */
	private String prefix;

	/**
	 * Max prefix length
	 */
	private Integer maxPrefixLength;

	/**
	 * ID of the related {@link Roa}
	 */
	private Long roaId;

	/**
	 * Constructor that sets all the properties with the received data
	 * 
	 * @param asn
	 * @param prefix
	 * @param maxPrefixLength
	 * @param roaId
	 */
	public ResourceNode(Long asn, String prefix, Integer maxPrefixLength, Long roaId) {
		this.asn = asn;
		this.prefix = prefix;
		this.maxPrefixLength = maxPrefixLength;
		this.roaId = roaId;
	}

	public Long getAsn() {
		return asn;
	}

	public void setAsn(Long asn) {
		this.asn = asn;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Integer getMaxPrefixLength() {
		return maxPrefixLength;
	}

	public void setMaxPrefixLength(Integer maxPrefixLength) {
		this.maxPrefixLength = maxPrefixLength;
	}

	public Long getRoaId() {
		return roaId;
	}

	public void setRoaId(Long roaId) {
		this.roaId = roaId;
	}

}
