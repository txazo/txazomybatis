package org.txazo.mybatis.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis分页
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -6689934960548171836L;

	/** 当前页 */
	private int page;
	/** 页大小 */
	private int pageSize;
	/** 总页数 */
	private int totalPage;
	/** 总数 */
	private int totalSize;
	/** 结果集 */
	private List<T> results;
	/** 参数 */
	private Map<String, Object> params = new HashMap<String, Object>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
