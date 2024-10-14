package com.pokemonreview.dto;

import java.util.List;

public class PrintDrawingResponse {

	private List<PrintDrawingDto> content;
	private boolean last;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;

	public PrintDrawingResponse() {

	}

	public PrintDrawingResponse(
			List<PrintDrawingDto> content,
			int pageNo,
			int pageSize,
			long totalElements,
			int totalPages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}

	public List<PrintDrawingDto> getContent() {
		return content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean getLast() {
		return last;
	}

	public void setContent(List<PrintDrawingDto> content) {
		this.content = content;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
