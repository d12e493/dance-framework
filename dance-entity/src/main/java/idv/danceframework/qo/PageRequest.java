package idv.danceframework.qo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.danceframework.qo.Order.Direction;

public class PageRequest<T> {
	private T object;
	private List<HashMap<String, String>> order = new ArrayList<HashMap<String, String>>();
	private List<Order> sortList;

	public List<HashMap<String, String>> getOrder() {
		return order;
	}

	public void setOrder(List<HashMap<String, String>> order) {
		this.order = order;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<Order> getSortList() {

		if (sortList == null && order.size() > 0) {

			sortList = new ArrayList<Order>();

			final String column = "column";
			final String direction = "dir";

			for (Map<String, String> map : order) {
				Order o = new Order();
				if (map.containsKey(column)) {
					o.setColumn(map.get(column));
				}
				if (map.containsKey(direction)) {
					String dir = map.get(direction);
					if (Direction.DESC.name().equalsIgnoreCase(dir)) {
						o.setDir(Direction.DESC);
					}
				}
				sortList.add(o);
			}
		}

		return sortList;
	}

	public void setSortList(List<Order> sortList) {
		this.sortList = sortList;
	}
}
