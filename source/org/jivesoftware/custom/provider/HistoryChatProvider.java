package org.jivesoftware.custom.provider;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;

import org.jivesoftware.custom.packet.ChatHistory;

/**
 * The HistoryChatProvider parses ChatHistory packets. (@see ChatHistory)
 * @author clerkmaxwell
 *
 */
public class HistoryChatProvider implements IQProvider {
	
	public static final String HISTORY_CHAT_NAMESPACE		 = "urn:xmpp:hb_fast_archive";
    public static final String HISTORY_CHAT_ELEMENT_NAME 	 = "retrieve";
    public static final String HISTORY_CHAT_ITEM_NAMESPACE 	 = "http://jabber.org/protocol/rsm";

    // 附件情况暂时不考虑
	@Override
	public IQ parseIQ(XmlPullParser parser) throws Exception {
		ChatHistory chatHistory = new ChatHistory();
		boolean done = false;
		int eventType = -1;
		while(!done) {
			
			eventType = parser.getEventType();
			if(eventType == XmlPullParser.START_DOCUMENT) {
				
			} else if(eventType == XmlPullParser.START_TAG) {
				
				String elementName = parser.getName();
				String namespace = parser.getNamespace();
				if (elementName.equalsIgnoreCase("retrieve")) {
					String target = parser.getAttributeValue("", "with");
					String start = parser.getAttributeValue("", "start");
					String type = parser.getAttributeValue("", "type");
				} else if (elementName.equalsIgnoreCase("message")) {
					chatHistory.addMessage(parseMessage(parser));
				} else if (elementName.equalsIgnoreCase("set")) {
					
				} else if (elementName.equalsIgnoreCase("first")) {
					chatHistory.setFirst(Integer.valueOf(parser.nextText()));
				} else if (elementName.equalsIgnoreCase("last")) {
					chatHistory.setLast(Integer.valueOf(parser.nextText()));
				} else if (elementName.equalsIgnoreCase("count")) {
					String count = parser.nextText();
					chatHistory.setCount(Integer.parseInt(count));
				}
			} else if(eventType == XmlPullParser.END_TAG) {
				if (parser.getName().equalsIgnoreCase("retrieve"))
					done = true;
			} else if(eventType == XmlPullParser.TEXT) {
				
			}
			if (!done) parser.next();
		}
		
		return chatHistory;
	}
	
	private ChatHistory.Message parseMessage(XmlPullParser parser) throws Exception {
		boolean done = false;
		int eventType = -1;
		
		ChatHistory.Message message = new ChatHistory.Message();
		while(!done) {
			eventType = parser.getEventType();
			if (eventType == XmlPullParser.START_TAG) {
				String elementName = parser.getName();
				if (elementName.equalsIgnoreCase("message")) {
					String messageId = parser.getAttributeValue("", "message_id");
					String from = parser.getAttributeValue("", "from");
					String to = parser.getAttributeValue("", "to");
					String type = parser.getAttributeValue("", "type");
					message.setMessageId(messageId);
					message.setFrom(from);
					message.setTo(to);
					message.setType(type);
				} else if (elementName.equalsIgnoreCase("delay")) {
//					String from = parser.getAttributeValue("", "from");
					String stamp = parser.getAttributeValue("", "stamp");
					message.setStamp(stamp);
				} else if (elementName.equalsIgnoreCase("set")) {
					
				}
			} else if (eventType == XmlPullParser.END_TAG) {
				if (parser.getName().equalsIgnoreCase("message"))
					done = true;
			}
			if (!done) parser.next();
		}
		
		return message;
	}

}
