package mx.nic.lab.rpki.db.pojo;

import java.util.Arrays;

/**
 * GBR (Ghostbuster record) represented an API object
 *
 */
public class Gbr extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = Gbr.class.getSimpleName();
	public static final String ID = "id";
	public static final String VCARD = "vcard";
	public static final String CMS_DATA = "cmsData";

	/**
	 * GBR ID
	 */
	private Long id;

	/**
	 * VCard of the GBR
	 */
	private String vcard;

	/**
	 * CMS data where the GBR is contained
	 */
	private byte[] cmsData;

	public Gbr() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Gbr.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(VCARD).append("=").append(vcard != null ? vcard : "null");
		sb.append(", ");
		sb.append(CMS_DATA).append("=").append(cmsData != null ? cmsData : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vcard == null) ? 0 : vcard.hashCode());
		result = prime * result + ((cmsData == null) ? 0 : cmsData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Gbr))
			return false;
		Gbr other = (Gbr) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vcard == null) {
			if (other.vcard != null)
				return false;
		} else if (!vcard.equals(other.vcard))
			return false;
		if (!Arrays.equals(cmsData, other.cmsData)) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVcard() {
		return vcard;
	}

	public void setVcard(String vcard) {
		this.vcard = vcard;
	}

	public byte[] getCmsData() {
		return cmsData;
	}

	public void setCmsData(byte[] cmsData) {
		this.cmsData = cmsData;
	}
}
