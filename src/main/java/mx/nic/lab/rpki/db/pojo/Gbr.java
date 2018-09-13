package mx.nic.lab.rpki.db.pojo;

/**
 * GBR (Ghostbuster record) represented an API object
 *
 */
public class Gbr extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = Gbr.class.getSimpleName();
	public static final String RPKI_OBJECT = "rpkiObject";
	public static final String ID = "id";
	public static final String VCARD = "vcard";

	/**
	 * RpkiObject related
	 */
	private RpkiObject rpkiObject;

	/**
	 * GBR ID
	 */
	private Long id;

	/**
	 * VCard of the GBR
	 */
	private String vcard;

	public Gbr() {
		super();
	}

	public Gbr(String vcard) {
		this.vcard = vcard;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Gbr.class.getName());
		sb.append("[");
		sb.append(RPKI_OBJECT).append("=").append(rpkiObject != null ? rpkiObject.getId() : "null");
		sb.append(", ");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(VCARD).append("=").append(vcard != null ? vcard : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rpkiObject == null) ? 0 : rpkiObject.getId().hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vcard == null) ? 0 : vcard.hashCode());
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
		if (vcard == null) {
			if (other.vcard != null)
				return false;
		} else if (!vcard.equals(other.vcard))
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

	public String getVcard() {
		return vcard;
	}

	public void setVcard(String vcard) {
		this.vcard = vcard;
	}
}
