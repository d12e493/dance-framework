package idv.danceframework.lo;

import java.util.List;

public class PageResult {
	private int iTotalRecords;
	private int iTotalDisplayRecords;
	private String sEcho;
	private List data;

	public PageResult(){
		
	}
	
	public PageResult(List list,long totalData){
		this.data = list;
		this.iTotalRecords = (int)totalData;
		this.iTotalDisplayRecords = data.size();
	}
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}
