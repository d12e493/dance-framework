package idv.danceframework.vo;

import java.io.Serializable;

public class Bread implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String link;
	private String icon;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
