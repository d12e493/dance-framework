package idv.danceframework.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 資料狀態 <br/>
	 * 1：啟用 0：不啟用
	 */
	private boolean status = true;

	private Long createUserId;

	private Date createTime;

	private Long updateUserId;

	private Date updateTime;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
