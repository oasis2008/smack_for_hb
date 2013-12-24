package org.jivesoftware.custom.packet;

import java.io.Serializable;
import java.util.ArrayList;

import org.jivesoftware.smack.packet.IQ;

public class Conversation extends IQ implements Serializable {
	
	private static final long serialVersionUID = 146593172970310915L;
	
	private int first;
	private int last;
	private int count;
	private ArrayList<Item> items;
	
	public void addItem(Item item) {
		if (items == null) 
			items = new ArrayList<Item>();
		items.add(item);
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

	public ArrayList<Item> getItems() {
		return items;
	}

	public static class Item implements Serializable {
		
		private static final long serialVersionUID = 458084856438969918L;
		
		private String jid = null;
		private String typ = null;
		private Message message = null;
		public String getJid() {
			return jid;
		}
		public void setJid(String jid) {
			this.jid = jid;
		}
		public String getTyp() {
			return typ;
		}
		public void setTyp(String typ) {
			this.typ = typ;
		}
		public Message getMessage() {
			return message;
		}
		public void setMessage(Message message) {
			this.message = message;
		}
		
	}
	
	public static class Message implements Serializable {
		
		private static final long serialVersionUID = -5747149283817191164L;
		
		private String to = null;
		private String from = null;
		private String dateTime = null;
		private String type = null;
		private String messageId = null;
		private String body = null;
		private Delay delay = null;
		
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getDateTime() {
			return dateTime;
		}
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getMessageId() {
			return messageId;
		}
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public Delay getDelay() {
			return delay;
		}
		public void setDelay(Delay delay) {
			this.delay = delay;
		}
		
	}
	
	public static class Delay implements Serializable {
		
		private static final long serialVersionUID = 5040433934240761941L;
		
		private String from = null;
		private String stamp = null;
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getStamp() {
			return stamp;
		}
		public void setStamp(String stamp) {
			this.stamp = stamp;
		}
	}

	@Override
	public String getChildElementXML() {
		return null;
	}

}
