package mx.nic.lab.rpki.db.pojo;

import java.security.cert.X509Certificate;

/**
 * URI configured at a TAL as an API object
 *
 */
public class TalUri extends ApiObject {

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
	private X509Certificate loadedCer;

	/**
	 * Flag to know if the URI was loaded
	 */
	private Boolean loaded;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(TalUri.class.getName());
		sb.append("[");
		sb.append("id=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append("talId=").append(talId != null ? talId : "null");
		sb.append(", ");
		sb.append("value=").append(value != null ? value : "null");
		sb.append(", ");
		sb.append("loadedCer=").append(loadedCer != null ? loadedCer : "null");
		sb.append(", ");
		sb.append("loaded=").append(loaded != null ? loaded : "null");
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
		if (loadedCer == null) {
			if (other.loadedCer != null)
				return false;
		} else if (!loadedCer.equals(other.loadedCer))
			return false;
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

	public X509Certificate getLoadedCer() {
		return loadedCer;
	}

	public void setLoadedCer(X509Certificate loadedCer) {
		this.loadedCer = loadedCer;
	}

	public Boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}
}
