package idv.danceframework.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Davis Chen
 *
 */
@Entity
@Table(schema = "SYSTEM", name = "MENU")
public class Menu extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8650496963428073573L;

	@Id
	@GeneratedValue
	private Long menuId;
	
	private String name;
	
	private String url;
	
	private Long parentMenuId;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
}
