package idv.danceframework.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 資料狀態 <br/>
	 * 1：啟用 0：不啟用
	 */
	@Column(name = "STATUS")
	private boolean status = true;

	@Column(name = "CREATE_USER_ID")
	private Long createUserId;

	@Column(name = "CREATE_TIME")
	private Calendar createTime;

	@Column(name = "UPDATE_USER_ID")
	private Long updateUserId;

	@Column(name = "UPDATE_TIME")
	private Calendar updateTime;

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

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Calendar getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}

}
