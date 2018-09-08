package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.ripe.rpki.commons.crypto.util.CertificateRepositoryObjectFactory;
import net.ripe.rpki.commons.crypto.x509cert.X509ResourceCertificate;
import net.ripe.rpki.commons.validation.ValidationResult;

/**
 * TAL represented as an API object
 *
 */
public class Tal extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = Tal.class.getSimpleName();
	public static final String ID = "id";
	public static final String LAST_SYNC = "lastSync";
	public static final String PUBLIC_KEY = "publicKey";
	public static final String SYNC_STATUS = "syncStatus";
	public static final String VALIDATION_STATUS = "validationStatus";
	public static final String NAME = "name";
	public static final String LOADED_CER = "loadedCer";
	public static final String TAL_URIS = "talUris";
	public static final String TAL_FILES = "talFiles";

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
	 * TAL sync status (values: unsynchronized, synchronizing, synchronized)
	 */
	private String syncStatus;

	/**
	 * Validation status (values: pending, validating, validated)
	 */
	private String validationStatus;

	/**
	 * Common name of the loaded certificate
	 */
	private String name;

	/**
	 * Loaded certificate from a TAL's URI
	 */
	private byte[] loadedCer;

	/**
	 * List of configured URIs to obtain the certificate
	 */
	private List<TalUri> talUris;

	/**
	 * List of loaded files from the whole repository
	 */
	private List<TalFile> talFiles;

	/**
	 * Possible TAL sync status
	 */
	public enum SyncStatus {
		UNSYNCHRONIZED, SYNCHRONIZED, SYNCHRONIZING
	}

	/**
	 * Possible TAL validation status
	 */
	public enum ValidationStatus {
		PENDING, VALIDATING, VALIDATED
	}

	public Tal() {
		super();
		talUris = new ArrayList<>();
		talFiles = new ArrayList<>();
	}

	public void setCertificate(X509ResourceCertificate certificate) {
		this.loadedCer = certificate.getEncoded();
	}

	public X509ResourceCertificate getCertificate() {
		if (loadedCer == null) {
			return null;
		}
		return (X509ResourceCertificate) CertificateRepositoryObjectFactory.createCertificateRepositoryObject(loadedCer,
				ValidationResult.withLocation(talUris.get(0).getLocation()));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Tal.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(LAST_SYNC).append("=").append(lastSync != null ? lastSync : "null");
		sb.append(", ");
		sb.append(PUBLIC_KEY).append("=").append(publicKey != null ? publicKey : "null");
		sb.append(", ");
		sb.append(SYNC_STATUS).append("=").append(syncStatus != null ? syncStatus : "null");
		sb.append(", ");
		sb.append(VALIDATION_STATUS).append("=").append(validationStatus != null ? validationStatus : "null");
		sb.append(", ");
		sb.append(NAME).append("=").append(name != null ? name : "null");
		sb.append(", ");
		sb.append(LOADED_CER).append("=").append(loadedCer != null ? loadedCer : "null");
		sb.append(", ");
		sb.append(TAL_URIS).append("=").append(talUris != null ? talUris : "null");
		sb.append(", ");
		sb.append(TAL_FILES).append("=").append(talFiles != null ? talFiles : "null");
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
		result = prime * result + ((syncStatus == null) ? 0 : syncStatus.hashCode());
		result = prime * result + ((validationStatus == null) ? 0 : validationStatus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((loadedCer == null) ? 0 : loadedCer.hashCode());
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
		if (syncStatus == null) {
			if (other.syncStatus != null)
				return false;
		} else if (!syncStatus.equals(other.syncStatus))
			return false;
		if (validationStatus == null) {
			if (other.validationStatus != null)
				return false;
		} else if (!validationStatus.equals(other.validationStatus))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(loadedCer, other.loadedCer)) {
			return false;
		}
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

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLoadedCer() {
		return loadedCer;
	}

	public void setLoadedCer(byte[] loadedCer) {
		this.loadedCer = loadedCer;
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
