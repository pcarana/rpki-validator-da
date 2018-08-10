package mx.nic.lab.rpki.db.pojo;

/**
 * RTR session represented as an API object
 *
 */
public class RtrSession extends ApiObject {

	/**
	 * Text representation of each property, useful for validations and ordering
	 */
	public static final String OBJECT_NAME = RtrSession.class.getSimpleName();
	public static final String ID = "id";
	public static final String ADDRESS = "address";
	public static final String PORT = "port";
	public static final String STATUS = "status";
	public static final String LAST_REQUEST = "lastRequest";
	public static final String LAST_RESPONSE = "lastResponse";
	public static final String SESSION_ID = "sessionId";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String VERSION = "version";

	/**
	 * RTR session internal ID
	 */
	private Long id;

	/**
	 * Text representation of the router address
	 */
	private String address;

	/**
	 * Port used to communicate with the router
	 */
	private Long port;

	/**
	 * Status of the session
	 */
	private String status;

	/**
	 * Date and time of the last request received
	 */
	private String lastRequest;

	/**
	 * Date and time of the last response sent
	 */
	private String lastResponse;

	/**
	 * Session ID used for communication
	 */
	private Long sessionId;

	/**
	 * Last serial number received by the router
	 */
	private Long serialNumber;

	/**
	 * RTR version used to communicate with the router
	 */
	private Integer version;

	public RtrSession() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RtrSession.class.getName());
		sb.append("[");
		sb.append(ID).append("=").append(id != null ? id : "null");
		sb.append(", ");
		sb.append(ADDRESS).append("=").append(address != null ? address : "null");
		sb.append(", ");
		sb.append(PORT).append("=").append(port != null ? port : "null");
		sb.append(", ");
		sb.append(STATUS).append("=").append(status != null ? status : "null");
		sb.append(", ");
		sb.append(LAST_REQUEST).append("=").append(lastRequest != null ? lastRequest : "null");
		sb.append(", ");
		sb.append(LAST_RESPONSE).append("=").append(lastResponse != null ? lastResponse : "null");
		sb.append(", ");
		sb.append(SESSION_ID).append("=").append(sessionId != null ? sessionId : "null");
		sb.append(", ");
		sb.append(SERIAL_NUMBER).append("=").append(serialNumber != null ? serialNumber : "null");
		sb.append(", ");
		sb.append(VERSION).append("=").append(version != null ? version : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((lastRequest == null) ? 0 : lastRequest.hashCode());
		result = prime * result + ((lastResponse == null) ? 0 : lastResponse.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof RtrSession))
			return false;
		RtrSession other = (RtrSession) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (lastRequest == null) {
			if (other.lastRequest != null)
				return false;
		} else if (!lastRequest.equals(other.lastRequest))
			return false;
		if (lastResponse == null) {
			if (other.lastResponse != null)
				return false;
		} else if (!lastResponse.equals(other.lastResponse))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastRequest() {
		return lastRequest;
	}

	public void setLastRequest(String lastRequest) {
		this.lastRequest = lastRequest;
	}

	public String getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(String lastResponse) {
		this.lastResponse = lastResponse;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
