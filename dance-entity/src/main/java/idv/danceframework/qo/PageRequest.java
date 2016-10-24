package idv.danceframework.qo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查詢資料請求參數
 * 
 * @author Davis Chen
 *
 */
public class PageRequest {

	/**
	 * 每頁幾筆
	 */
	private int rowsPerPage = 10;
	/**
	 * 現在第幾頁
	 */
	private int currentPage = 1;

	private int start;

	private List<Map<String, String>> order = new ArrayList<Map<String, String>>();

	private List<Order> orderList = new ArrayList<Order>();

	public List<Order> getOrderList() {
		if (order.size() > 0) {
			for (Map<String, String> entity : order) {
				Order o = new Order();
				o.setDir(entity.get("dir"));
				o.setColumn(entity.get("column"));
				orderList.add(o);
			}
		}
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Map<String, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<String, String>> order) {
		this.order = order;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getCurrentPage() {
		if (start != 0) {
			return start / rowsPerPage + 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setLength(int length) {
		this.rowsPerPage = length;
	}

}
