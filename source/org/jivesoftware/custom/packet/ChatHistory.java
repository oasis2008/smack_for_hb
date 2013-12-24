package org.jivesoftware.custom.packet;

import java.io.Serializable;
import java.util.ArrayList;

import org.jivesoftware.smack.packet.IQ;

/**
 * IQ packet that serves for parsing history message
 * @author clerkmaxwell
 *
 */
public class ChatHistory extends IQ implements Serializable {
	
	private static final long serialVersionUID = 1083398679901752758L;
	
	private String target = null;
	private String start = null;
	private String chatType = null;
	private int first;
	private int last;
	private int count;
	private ArrayList<Message> messages = null;
	
	public void addMessage(Message message) {
		if (messages == null)
			messages = new ArrayList<Message>();
		messages.add(message);
	}

	@Override
	public String getChildElementXML() {
		return null;
	}
	
	public static class Message implements Serializable {
		
		private static final long serialVersionUID = -4778345328463443270L;
		
		String messageId = null;
		String from = null;
		String to = null;
		String type = null;
		String body = null;
		String stamp = null;
		public String getMessageId() {
			return messageId;
		}
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getStamp() {
			return stamp;
		}
		public void setStamp(String stamp) {
			this.stamp = stamp;
		}
		
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
}
