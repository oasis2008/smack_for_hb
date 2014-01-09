package org.jivesoftware.custom.packet;

import org.jivesoftware.custom.provider.HBSessionProvider;
import org.jivesoftware.smack.packet.IQ;


public class RetrieveHBSession extends IQ {
	
	private String with;
	private String name;

	private boolean isGroup = true;
	
	public RetrieveHBSession(String with, String name) {
		this.with = with;
		if (this.with != null && !this.with.equals("")) 
			isGroup = false;
        else {
            this.name = name;
        }
		
		setTo("session.socket.huoban.com");
	}

	@Override
	public String getChildElementXML() {
		String xml;
		if (isGroup) 
			xml = "<create xmlns=\"" + HBSessionProvider.SESSION_NAMESPACE + "\" type=\"groupchat\" name=\"" + this.name + "/>";
		else
			xml = "<create xmlns=\"" + HBSessionProvider.SESSION_NAMESPACE + "\" type=\"chat\" with=\"" + this.with + "\"/>";
		return xml;
	}

}
