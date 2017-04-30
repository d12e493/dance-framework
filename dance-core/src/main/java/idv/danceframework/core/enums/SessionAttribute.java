package idv.danceframework.core.enums;

public enum SessionAttribute {
	SYSTEM_MESSAGE("system_message");

	private String attributeName;

	private SessionAttribute(String attr) {
		this.attributeName = attr;
	}

	public String toString() {
		return this.attributeName;
	}
}
