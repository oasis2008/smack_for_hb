package org.jivesoftware.custom.packet;

import org.jivesoftware.smack.packet.IQ;

public class RetrieveConversationList extends IQ {

	private String max;
	private String index;
	private String after;
	
	public RetrieveConversationList(String max, String index, String after) {
		this.max = max;
		this.index = index;
		this.after = after;
	}
	
	@Override
	public String getChildElementXML() {
		return "<retrieve xmlns=\"urn:xmpp:hb_fast_session\">" 
				+ "<set>" // "<set xmlns=\"http://jabber.org/protocol/rsm\">"
				+ "<max>" + max + "</max>"
				+ "<index>" + index + "</index>"
				+ "<after>" + after + "</after>"
				+ "</set>"
				+ "</retrieve>";
	}

}
