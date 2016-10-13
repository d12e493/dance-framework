package idv.danceframework.lo;

import java.util.List;

import idv.danceframework.qo.PageRequest;

/**
 * 資料查詢結果列表
 * 
 * @author Davis Chen
 *
 * @param <T>
 */
public class PgaeResult<T> {
	/**
	 * 資料列表
	 */
	private List<T> rows;

	/**
	 * 資料總筆數
	 */
	private int totalNumber;
	/**
	 * 總頁數
	 */
	private int totalPages;

	private PageRequest pageRequest;
	
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
}
