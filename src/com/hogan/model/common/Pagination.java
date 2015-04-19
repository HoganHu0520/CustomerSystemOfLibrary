package com.hogan.model.common;

import java.util.List;

public class Pagination<T> {
	static Integer DEFAULT_PAGE_SIZE = 10;
	
	private Integer pageSize = 0;
	private Integer totalCount = 0;
	private Integer pageCount = 0;
	private Integer pageIndex = 0;
	private Integer currentCount = 0;
	private String sortBy;
	private Boolean isASC;
	private String keyword;
	private List<T> results;
	
	public Integer getPageSize() {
		return pageSize == 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(Integer totalCount) {
		this.pageCount = totalCount / getPageSize() + 1;
		this.totalCount = totalCount;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Boolean getIsASC() {
		return isASC;
	}

	public void setIsASC(Boolean isASC) {
		this.isASC = isASC;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.currentCount = results.size();
		this.results = results;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}
	
}
