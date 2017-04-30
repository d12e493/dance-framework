package idv.danceframework.core;

import idv.danceframework.core.enums.MessageType;

public class Message {

	private MessageType type;
	private String content;
	private String template;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
