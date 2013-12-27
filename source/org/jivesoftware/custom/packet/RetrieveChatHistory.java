package org.jivesoftware.custom.packet;

import org.jivesoftware.smack.packet.IQ;

public class RetrieveChatHistory extends IQ {
	
	private String targetJID;
	private String UTC;
	private String limit;
	private String offset;
	private String index;
	private String chatType = "chat";
	
	public RetrieveChatHistory(String targetJID, String UTC, String limit, String index, String offset) {
		this.targetJID = targetJID;
        String server = targetJID.split("@")[1];
        if (server.startsWith("conference")) chatType = "groupchat";
		this.UTC = UTC;
		this.limit = limit;
		this.index = index;
		this.offset = offset;
	}

	@Override
	public String getChildElementXML() {
		return "<retrieve xmlns=\"urn:xmpp:hb_fast_archive\" with=\"" 
				+ targetJID + "\" start=\"" + UTC + "\" type=\"" + chatType + "\">"
				+ "<set xmlns=\"http://jabber.org/protocol/rsm\">"
				+ "<max>" + limit + "</max>"
				+ "<index>" + index + "</index>"
				+ "<after>" + offset + "</after>"
				+ "</set>"
				+ "</retrieve>";
	}

}
