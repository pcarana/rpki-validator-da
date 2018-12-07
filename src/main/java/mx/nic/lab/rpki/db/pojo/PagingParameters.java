package mx.nic.lab.rpki.db.pojo;

import java.util.LinkedHashMap;

/**
 * Represents the paging and ordering parameters that can be applied to a list
 * search. This object has 3 properties: <br>
 * <ul>
 * <li><b>limit:</b> Result limit, a value less than or equal to 0 will be
 * treated as "no limit"</li>
 * <li><b>offset:</b> Result limit offset, if no limit is desired then the
 * offset will be ignored, a value less than 0 will be treated as "no
 * offset"</li>
 * <li><b>sort:</b> Map of POJO properties used for sort, the key is the
 * property and the value is the order (asc o desc), a null value will treated
 * as "no sort"</li>
 * </ul>
 *
 */
public class PagingParameters {

	/**
	 * Common ascending ordering constant
	 */
	public static final String ORDER_ASC = "asc";

	/**
	 * Common descending ordering constant
	 */
	public static final String ORDER_DESC = "desc";

	/**
	 * Desired result limit
	 */
	private int limit;

	/**
	 * Desired result offset (commonly used in conjunction with limit)
	 */
	private int offset;

	/**
	 * Columns used for sort, the order is important
	 */
	private LinkedHashMap<String, String> sort;

	/**
	 * Column used for filtering
	 */
	private String filterField;

	/**
	 * Query used for filtering (the implementation will be responsible of the
	 * search type; eg. regex, or simple filter)
	 */
	private String filterQuery;

	/**
	 * Create with default values to indicate that no limit, no offset, and no sort
	 * is desired
	 */
	public PagingParameters() {
		this.limit = -1;
		this.offset = -1;
		this.sort = null;
		this.filterField = null;
		this.filterQuery = null;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public LinkedHashMap<String, String> getSort() {
		return sort;
	}

	public void setSort(LinkedHashMap<String, String> sort) {
		this.sort = sort;
	}

	public String getFilterField() {
		return filterField;
	}

	public void setFilterField(String filterField) {
		this.filterField = filterField;
	}

	public String getFilterQuery() {
		return filterQuery;
	}

	public void setFilterQuery(String filterQuery) {
		this.filterQuery = filterQuery;
	}
}
