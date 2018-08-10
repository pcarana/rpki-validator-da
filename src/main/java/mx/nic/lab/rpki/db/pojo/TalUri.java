package mx.nic.lab.rpki.db.pojo;

import java.util.Arrays;

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
	public static final String VALUE = "value";
	public static final String LOADED_CER = "loadedCer";
	public static final String LOADED = "loaded";

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
	private String value;

	/**
	 * Loaded CER from the URI configured, MAY be null if the URI wasn't loaded
	 */
	private byte[] loadedCer;

	/**
	 * Flag to know if the URI was loaded
	 */
	private Boolean loaded;

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
		sb.append(VALUE).append("=").append(value != null ? value : "null");
		sb.append(", ");
		sb.append(LOADED_CER).append("=").append(loadedCer != null ? loadedCer : "null");
		sb.append(", ");
		sb.append(LOADED).append("=").append(loaded != null ? loaded : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((talId == null) ? 0 : talId.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((loadedCer == null) ? 0 : loadedCer.hashCode());
		result = prime * result + ((loaded == null) ? 0 : loaded.hashCode());
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (!Arrays.equals(loadedCer, other.loadedCer)) {
			return false;
		}
		if (loaded == null) {
			if (other.loaded != null)
				return false;
		} else if (!loaded.equals(other.loaded))
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public byte[] getLoadedCer() {
		return loadedCer;
	}

	public void setLoadedCer(byte[] loadedCer) {
		this.loadedCer = loadedCer;
	}

	public Boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}
}
