package mx.nic.lab.rpki.db.pojo;

/**
 * ROA represented as an API object
 *
 */
public class Roa extends ApiObject {

	private Long id;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Roa.class.getName());
		sb.append("[");
		sb.append("id=").append(id != null ? id : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
