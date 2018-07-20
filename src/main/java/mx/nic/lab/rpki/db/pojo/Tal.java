package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * TAL represented as an API object
 *
 */
public class Tal extends ApiObject {

	/**
	 * TALs ID
	 */
	private Long id;

	/**
	 * Last synchronization date
	 */
	private String lastSync;

	/**
	 * Public key of the loaded certificate
	 */
	private String publicKey;

	/**
	 * TAL status (values: unsynchronized, synchronizing, synchronized)
	 */
	private String status;

	/**
	 * Common name of the loaded certificate
	 */
	private String name;

	/**
	 * List of configured URIs to obtain the certificate
	 */
	private List<TalUri> talUris;

	/**
	 * List of loaded files from the whole repository
	 */
	private List<TalFile> talFiles;

	public Tal() {
		super();
		talUris = new ArrayList<>();
		talFiles = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Tal.class.getName());
		sb.append("[");
		sb.append("id=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append("lastSync=").append(lastSync != null ? lastSync : "null");
		sb.append(", ");
		sb.append("publicKey=").append(publicKey != null ? publicKey : "null");
		sb.append(", ");
		sb.append("status=").append(status != null ? status : "null");
		sb.append(", ");
		sb.append("name=").append(name != null ? name : "null");
		sb.append(", ");
		sb.append("talUris=").append(talUris != null ? talUris : "null");
		sb.append(", ");
		sb.append("talFiles=").append(talFiles != null ? talFiles : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastSync == null) ? 0 : lastSync.hashCode());
		result = prime * result + ((publicKey == null) ? 0 : publicKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((talUris == null) ? 0 : talUris.hashCode());
		result = prime * result + ((talFiles == null) ? 0 : talFiles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Tal))
			return false;
		Tal other = (Tal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastSync == null) {
			if (other.lastSync != null)
				return false;
		} else if (!lastSync.equals(other.lastSync))
			return false;
		if (publicKey == null) {
			if (other.publicKey != null)
				return false;
		} else if (!publicKey.equals(other.publicKey))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (talUris == null) {
			if (other.talUris != null)
				return false;
		} else if (other.talUris == null || talUris.size() != other.talUris.size()
				|| !talUris.containsAll(other.talUris))
			return false;
		if (talFiles == null) {
			if (other.talFiles != null)
				return false;
		} else if (other.talUris == null || talFiles.size() != other.talFiles.size()
				|| !talFiles.containsAll(other.talFiles))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastSync() {
		return lastSync;
	}

	public void setLastSync(String lastSync) {
		this.lastSync = lastSync;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TalUri> getTalUris() {
		return talUris;
	}

	public void setTalUris(List<TalUri> talUris) {
		this.talUris = talUris;
	}

	public List<TalFile> getTalFiles() {
		return talFiles;
	}

	public void setTalFiles(List<TalFile> talFiles) {
		this.talFiles = talFiles;
	}
}
