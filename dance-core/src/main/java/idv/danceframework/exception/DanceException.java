package idv.danceframework.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> paramList = new ArrayList<String>();

	public DanceException(String message, String... params) {
		super(message);
		if (params != null) {
			paramList = new ArrayList<String>(Arrays.asList(params));
		}
	}

	public List<String> getParamList() {
		return paramList;
	}

	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}
}
