package mx.nic.lab.rpki.db.pojo;

/**
 * Object to represent a complete SLURM as an API Object
 *
 */
public class Slurm extends ApiObject {

	/**
	 * Version of the SLURM
	 */
	private Integer slurmVersion;

	/**
	 * Validation Output Filters declared at SLURM
	 */
	private SlurmFilters validationOutputFilters;

	/**
	 * Locally Added Assertions declared at SLURM
	 */
	private SlurmAssertions locallyAddedAssertions;

	/**
	 * Constructor, initialize objects with default values; slurmVersion has the
	 * value 1
	 */
	public Slurm() {
		super();
		slurmVersion = 1;
		validationOutputFilters = new SlurmFilters();
		locallyAddedAssertions = new SlurmAssertions();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Slurm.class.getName());
		sb.append("[");
		sb.append("slurmVersion=").append(slurmVersion != null ? slurmVersion : "null");
		sb.append(", ");
		sb.append("validationOutputFilters=")
				.append(validationOutputFilters != null ? validationOutputFilters : "null");
		sb.append(", ");
		sb.append("locallyAddedAssertions=").append(locallyAddedAssertions != null ? locallyAddedAssertions : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slurmVersion == null) ? 0 : slurmVersion.hashCode());
		result = prime * result + ((validationOutputFilters == null) ? 0 : validationOutputFilters.hashCode());
		result = prime * result + ((locallyAddedAssertions == null) ? 0 : locallyAddedAssertions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Slurm))
			return false;
		Slurm other = (Slurm) obj;
		if (slurmVersion == null) {
			if (other.slurmVersion != null)
				return false;
		} else if (slurmVersion.equals(other.slurmVersion))
			return false;
		if (validationOutputFilters == null) {
			if (other.validationOutputFilters != null)
				return false;
		} else if (validationOutputFilters.equals(other.validationOutputFilters))
			return false;
		if (locallyAddedAssertions == null) {
			if (other.locallyAddedAssertions != null)
				return false;
		} else if (locallyAddedAssertions.equals(other.locallyAddedAssertions))
			return false;
		return true;
	}

	public Integer getSlurmVersion() {
		return slurmVersion;
	}

	public void setSlurmVersion(Integer slurmVersion) {
		this.slurmVersion = slurmVersion;
	}

	public SlurmFilters getValidationOutputFilters() {
		return validationOutputFilters;
	}

	public void setValidationOutputFilters(SlurmFilters validationOutputFilters) {
		this.validationOutputFilters = validationOutputFilters;
	}

	public SlurmAssertions getLocallyAddedAssertions() {
		return locallyAddedAssertions;
	}

	public void setLocallyAddedAssertions(SlurmAssertions locallyAddedAssertions) {
		this.locallyAddedAssertions = locallyAddedAssertions;
	}

}
