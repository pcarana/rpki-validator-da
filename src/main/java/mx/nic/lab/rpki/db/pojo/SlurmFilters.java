package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Object to represent the "validationOutputFilters" property at a SLURM JSON
 *
 */
public class SlurmFilters {

	/**
	 * List of prefixFilters
	 */
	private List<SlurmPrefix> prefixes;

	/**
	 * List of bgpsecFilters
	 */
	private List<SlurmBgpsec> bgpsecs;

	/**
	 * Constructor, initialize the lists
	 */
	public SlurmFilters() {
		prefixes = new ArrayList<>();
		bgpsecs = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(SlurmFilters.class.getName());
		sb.append("[");
		sb.append("prefixes=").append(prefixes != null ? prefixes : "null");
		sb.append(", ");
		sb.append("bgpsecs=").append(bgpsecs != null ? bgpsecs : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prefixes == null) ? 0 : prefixes.hashCode());
		result = prime * result + ((bgpsecs == null) ? 0 : bgpsecs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SlurmFilters))
			return false;
		SlurmFilters other = (SlurmFilters) obj;
		if (prefixes == null) {
			if (other.prefixes != null)
				return false;
		} else if (other.prefixes == null || prefixes.size() != other.prefixes.size()
				|| !prefixes.containsAll(other.prefixes))
			return false;
		if (bgpsecs == null) {
			if (other.bgpsecs != null)
				return false;
		} else if (other.bgpsecs == null || bgpsecs.size() != other.bgpsecs.size()
				|| !bgpsecs.containsAll(other.bgpsecs))
			return false;
		return true;
	}

	public List<SlurmPrefix> getPrefixes() {
		return prefixes;
	}

	public void setPrefixes(List<SlurmPrefix> prefixes) {
		this.prefixes = prefixes;
	}

	public List<SlurmBgpsec> getBgpsecs() {
		return bgpsecs;
	}

	public void setBgpsecs(List<SlurmBgpsec> bgpsecs) {
		this.bgpsecs = bgpsecs;
	}

}
