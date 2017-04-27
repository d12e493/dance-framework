package idv.danceframework.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContentHeader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String subTitle;
	private String icon;
	private List<Bread> breadList = new ArrayList<Bread>();

	public boolean isNotEmpty() {
		return title != null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public List<Bread> getBreadList() {
		return breadList;
	}

	public void setBreadList(List<Bread> breadList) {
		this.breadList = breadList;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
