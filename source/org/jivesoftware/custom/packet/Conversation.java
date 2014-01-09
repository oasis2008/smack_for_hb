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
		private String type = null;
		private Message message = null;
        private String name = null;
        private String unread = null;
        private String member = null; // 单聊聊天对方

		public String getJid() {
			return jid;
		}
		public void setJid(String jid) {
			this.jid = jid;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Message getMessage() {
			return message;
		}
		public void setMessage(Message message) {
			this.message = message;
		}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUnread() {
            return unread;
        }

        public void setUnread(String unread) {
            this.unread = unread;
        }

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }
    }
	
	public static class Message implements Serializable {
		
		private static final long serialVersionUID = -5747149283817191164L;
		
		private String to = null;  // deprecated
		private String from = null;
		private String dateTime = null; // deprecated
        private String user = null;
		private String type = null;
		private String messageId = null;
		private String body = null;
		private Delay delay = null; // deprecated
        private String fileId = null;
        private String fileType = null;
		
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

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
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
