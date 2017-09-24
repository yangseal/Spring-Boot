package com.cnten.platform.dao;

public class PageBean {

	private static int DEF_PAGE_VIEW_SIZE = 10;
	private int pageIndex;
	private int pageSize;
	private int count;

	public PageBean() {
	}

	public PageBean(Integer pageIndex, Integer pageSize) {
		int _pageIndex = 0;
		if(pageIndex != null){
			_pageIndex = (int)pageIndex;
		}
		int _pageSize = 0;
		if(pageSize != null){
			_pageSize = (int)pageSize;
		}
		this.pageIndex = _pageIndex > 0 ? _pageIndex : 1;
		this.pageSize = _pageSize > 0 ? _pageSize : DEF_PAGE_VIEW_SIZE;
	}

	public int getPageIndex() {
		return pageIndex > 0 ? pageIndex : 1;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize > 0 ? pageSize : DEF_PAGE_VIEW_SIZE;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getCount() {
		return (long) count;
	}

	public void setCount(int count) {
		this.count = count >= 0 ? count : 0;
		if (this.count == 0)
			pageIndex = 0;
	}

	public int getPages() {
		return ((count + getPageSize()) - 1) / getPageSize();
	}

	public int getStartNo() {
		return (getPageIndex() - 1) * getPageSize() + 1;
	}

	public int getEndNo() {
		return Math.min(getPageIndex() * getPageSize(), count);
	}

	public int getPrePageNo() {
		return Math.max(getPageIndex() - 1, 1);
	}

	public int getNextPageNo() {
		return Math.min(getPageIndex() + 1, getPages());
	}
}
