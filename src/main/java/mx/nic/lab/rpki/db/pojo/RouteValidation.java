package mx.nic.lab.rpki.db.pojo;

/**
 * Route validation represented an API object (based on RFC 6483 section 2)
 *
 */
public class RouteValidation extends ApiObject {

	public enum ValidityState {
		VALID, INVALID, UNKNOWN
	}

	public enum PrefixState {
		/**
		 * No match at all
		 */
		NON_INTERSECTING("non-intersecting"),
		/**
		 * The prefix is less specific than ROA
		 */
		COVERING_AGGREGATE("covering-aggregate"),
		/**
		 * Exact match (prefix in range of ROA)
		 */
		MATCH_ROA("match-roa-prefix"),
		/**
		 * The prefix is more specific than ROA
		 */
		MORE_SPECIFIC("more-specific-than-roa");

		private final String description;

		private PrefixState(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return this.description;
		}
	}

	public enum AsState {
		MATCHING("matching"), NON_MATCHING("non-matching");

		private final String description;

		private AsState(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return this.description;
		}
	}

	/**
	 * General validity state of the prefix and AS
	 */
	private ValidityState validityState;

	/**
	 * Validity state exclusively of the prefix
	 */
	private PrefixState prefixState;

	/**
	 * Validity state exclusively of the AS
	 */
	private AsState asState;

	/**
	 * ROA data that matched (or is the closest to match) the prefix and AS
	 */
	private Roa roaMatch;

	public RouteValidation() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RouteValidation.class.getName());
		sb.append("[");
		sb.append("validityState=").append(validityState != null ? validityState : "null");
		sb.append(", ");
		sb.append("prefixState=").append(prefixState != null ? prefixState : "null");
		sb.append(", ");
		sb.append("asState=").append(asState != null ? asState : "null");
		sb.append(", ");
		sb.append("roaMatch=").append(roaMatch != null ? roaMatch : "null");
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((validityState == null) ? 0 : validityState.hashCode());
		result = prime * result + ((prefixState == null) ? 0 : prefixState.hashCode());
		result = prime * result + ((asState == null) ? 0 : asState.hashCode());
		result = prime * result + ((roaMatch == null) ? 0 : roaMatch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RouteValidation))
			return false;
		RouteValidation other = (RouteValidation) obj;
		if (validityState == null) {
			if (other.validityState != null)
				return false;
		} else if (!validityState.equals(other.validityState))
			return false;
		if (prefixState == null) {
			if (other.prefixState != null)
				return false;
		} else if (!prefixState.equals(other.prefixState))
			return false;
		if (asState == null) {
			if (other.asState != null)
				return false;
		} else if (!asState.equals(other.asState))
			return false;
		if (roaMatch == null) {
			if (other.roaMatch != null)
				return false;
		} else if (!roaMatch.equals(other.roaMatch))
			return false;
		return true;
	}

	public ValidityState getValidityState() {
		return validityState;
	}

	public void setValidityState(ValidityState validityState) {
		this.validityState = validityState;
	}

	public PrefixState getPrefixState() {
		return prefixState;
	}

	public void setPrefixState(PrefixState prefixState) {
		this.prefixState = prefixState;
	}

	public AsState getAsState() {
		return asState;
	}

	public void setAsState(AsState asState) {
		this.asState = asState;
	}

	public Roa getRoaMatch() {
		return roaMatch;
	}

	public void setRoaMatch(Roa roaMatch) {
		this.roaMatch = roaMatch;
	}
}
