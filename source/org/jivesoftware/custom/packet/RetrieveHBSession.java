package org.jivesoftware.custom.packet;

import org.jivesoftware.custom.provider.HBSessionProvider;
import org.jivesoftware.smack.packet.IQ;


public class RetrieveHBSession extends IQ {
	
	private String with;
	
	private boolean isGroup = true;
	
	public RetrieveHBSession(String with) {
		this.with = with;
		if (this.with != null && !this.with.equals("")) 
			isGroup = false;
		
		setTo("session.socket.huoban.com");
	}

	@Override
	public String getChildElementXML() {
		String xml;
		if (isGroup) 
			xml = "<create xmlns=\"" + HBSessionProvider.SESSION_NAMESPACE + "\" type=\"groupchat\"/>";
		else
			xml = "<create xmlns=\"" + HBSessionProvider.SESSION_NAMESPACE + "\" type=\"chat\" with=\"" + this.with + "\"/>";
		return xml;
	}

}
