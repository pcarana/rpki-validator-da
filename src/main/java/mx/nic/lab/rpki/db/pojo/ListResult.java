package mx.nic.lab.rpki.db.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Object to represent a list of {@link ApiObject}s as a result, including the
 * total results found before applying any filter or paging
 *
 * @param <T>
 *            that extends {@link ApiObject}, used as the results type
 */
public class ListResult<T extends ApiObject> {

	/**
	 * List of objects returned as results
	 */
	private List<T> results;

	/**
	 * Total objects found before limiting the search
	 */
	private Integer totalFound;

	public ListResult() {
		this.results = new ArrayList<>();
		this.totalFound = 0;
	}

	public ListResult(List<T> results, Integer totalFound) {
		this.results = results != null ? results : new ArrayList<>();
		this.totalFound = totalFound != null ? totalFound : 0;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Integer getTotalFound() {
		return totalFound;
	}

	public void setTotalFound(Integer totalFound) {
		this.totalFound = totalFound;
	}
}
