package org.jivesoftware.custom.packet;

import org.jivesoftware.smack.packet.IQ;

public class RetrieveGroupConversationList extends IQ {

	private String max;
	private String index;
	private String before;

	public RetrieveGroupConversationList(String max, String index, String before) {
		this.max = max;
		this.index = index;
		this.before = before;
	}
	
	@Override
	public String getChildElementXML() {
		return "<retrievegroupchat xmlns=\"urn:xmpp:hb_session_log\">"
				+ "<set>"
				+ "<max>" + max + "</max>"
				+ "<index>" + index + "</index>"
				+ "<before>" + before + "</before>"
				+ "</set>"
				+ "</retrievegroupchat>";
	}

}
