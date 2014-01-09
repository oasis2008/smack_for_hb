package org.jivesoftware.custom.provider;

import org.jivesoftware.custom.packet.Conversation;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;


public class ConversationProvider implements IQProvider {

	public static final String CONVERSATION_NAMESPACE = "urn:xmpp:hb_session_log";
    public static final String CONVERSATION_ELEMENT_NAME = "retrieve";
    public static final String CONVERSATION_ITEM_NAMESPACE = "http://jabber.org/protocol/rsm";
    
	@Override
	public IQ parseIQ(XmlPullParser parser) throws Exception {
		boolean done = false;
		Conversation conversation = new Conversation();
		int eventType;
		while (!done) {
			eventType = parser.getEventType();
			
			if(eventType == XmlPullParser.START_DOCUMENT) {
				
			} else if(eventType == XmlPullParser.START_TAG) {
				String elementName = parser.getName();
	            String namespace = parser.getNamespace();
	            
	            if (elementName.equalsIgnoreCase("retrieve") 
	            		&& namespace.equalsIgnoreCase(CONVERSATION_NAMESPACE)) {
	            	
	            } else if (elementName.equalsIgnoreCase("item") && namespace.equalsIgnoreCase(CONVERSATION_NAMESPACE)) {
	            	conversation.addItem(parseItem(parser));
	            } else if (elementName.equalsIgnoreCase("set") 
	            		&& namespace.equals(CONVERSATION_ITEM_NAMESPACE)) {
	            	
	            } else if (elementName.equalsIgnoreCase("first") 
	            		&& namespace.equals(CONVERSATION_ITEM_NAMESPACE)) {
	            	String first = parser.nextText();
	            	conversation.setFirst(Integer.valueOf(first));
	            } else if (elementName.equalsIgnoreCase("last") 
	            		&& namespace.equals(CONVERSATION_ITEM_NAMESPACE)) {
	            	String last = parser.nextText();
	            	conversation.setLast(Integer.valueOf(last));
	            } else if (elementName.equalsIgnoreCase("count") 
	            		&& namespace.equals(CONVERSATION_ITEM_NAMESPACE)) {
	            	String count = parser.nextText();
	            	conversation.setCount(Integer.valueOf(count));
	            } 
	           
			} else if(eventType == XmlPullParser.END_TAG) {
				if (parser.getName().equalsIgnoreCase("retrieve"))
					done = true;
			} else if(eventType == XmlPullParser.TEXT) {
				
			}
			 
			if (!done) parser.next();
			
		}
		
		return conversation;
	}
	
	private Conversation.Item parseItem(XmlPullParser parser) throws Exception {
		boolean done = false;
		int eventType;
		Conversation.Item item = new Conversation.Item();
		Conversation.Message message = new Conversation.Message();
		Conversation.Delay delay = new Conversation.Delay();
		while(!done) {
			eventType = parser.getEventType();
			if (eventType == XmlPullParser.START_TAG) {
				String elementName = parser.getName();
				if (elementName.equalsIgnoreCase("item")) {
					String jid = parser.getAttributeValue("", "jid");
	            	String type = parser.getAttributeValue("", "type");
                    String name = parser.getAttributeValue("", "name");
                    String unread = parser.getAttributeValue("", "unread");
	            	item.setJid(jid);
	            	item.setType(type);
                    item.setUnread(unread);
                    item.setName(name);
				} else if (elementName.equalsIgnoreCase("message")) {
	            	String to = parser.getAttributeValue("", "to");
	            	String type = parser.getAttributeValue("", "type");
	            	String from = parser.getAttributeValue("", "from");
	            	String messageId = parser.getAttributeValue("", "mid");
	            	String dateTime = parser.getAttributeValue("", "datetime");
                    String user = parser.getAttributeValue("", "user");
	            	
	            	message.setTo(to);
	            	message.setFrom(from);
	            	message.setType(type);
	            	message.setMessageId(messageId);
	            	message.setDateTime(dateTime);
                    message.setUser(user);
	            } else if (elementName.equalsIgnoreCase("delay")) {
	            	String from = parser.getAttributeValue("", "from");
	            	String timeStamp = parser.getAttributeValue("", "stamp");
	            	delay.setFrom(from);
	            	delay.setStamp(timeStamp);
	            } else if (elementName.equalsIgnoreCase("body")) {
	            	String body = parser.nextText();
	            	message.setBody(body);
	            } else if (elementName.equalsIgnoreCase("playload")) { // 有附件的情况
	            	String fileId = parser.getAttributeValue("", "id");
                    String fileType = parser.getAttributeValue("", "type");
                    message.setFileId(fileId);
                    message.setFileType(fileType);
	            }
			} else if (eventType == XmlPullParser.END_TAG) {
				if (parser.getName().equalsIgnoreCase("item"))
					done = true;
			}
			if (!done) parser.next();
		}
		message.setDelay(delay);
		item.setMessage(message);
		return item;
	}

}
