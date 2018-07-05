package mx.nic.lab.rpki.db.pojo;

/**
 * Exception representation as an API object, it has: code, title and
 * description
 *
 */
public class ApiException extends ApiObject {

	private int errorCode;
	private String errorTitle;
	private String errorDescription;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ApiException.class.getName());
		sb.append("[");
		sb.append("errorCode=").append(errorCode);
		sb.append(", ");
		sb.append("errorTitle=").append(errorTitle != null ? errorTitle : "null");
		sb.append(", ");
		sb.append("errorDescription=").append(errorDescription != null ? errorDescription : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + errorCode;
		result = prime * result + ((errorTitle == null) ? 0 : errorTitle.hashCode());
		result = prime * result + ((errorDescription == null) ? 0 : errorDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ApiException))
			return false;
		ApiException other = (ApiException) obj;
		if (errorCode != other.errorCode)
			return false;
		if (errorTitle == null) {
			if (other.errorTitle != null)
				return false;
		} else if (!errorTitle.equals(other.errorTitle))
			return false;
		if (errorDescription == null) {
			if (other.errorDescription != null)
				return false;
		} else if (!errorDescription.equals(other.errorDescription))
			return false;
		return true;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorTitle() {
		return errorTitle;
	}

	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
