package idv.danceframework.qo;

import java.util.ArrayList;
import java.util.List;

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

	private List<Order> orderList = new ArrayList<Order>();

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public void addOrder(Order... orders) {
		for (Order order : orders) {
			this.orderList.add(order);
		}
	}
}
