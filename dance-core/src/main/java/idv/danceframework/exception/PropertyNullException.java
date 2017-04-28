package idv.danceframework.exception;

public class PropertyNullException extends DanceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyNullException(String property) {
		super("Property : " + property + " is null !!! ", property);
	}
}
