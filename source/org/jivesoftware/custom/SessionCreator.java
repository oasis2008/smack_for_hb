package org.jivesoftware.custom;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;

import org.jivesoftware.custom.packet.HBSession;

/**
 * Created by clerkmaxwell on 14-1-8.
 */
public class SessionCreator {


    public static HBSession retrieveHBSession(Connection connection, String with) {
        try {
            HBSession session = ServiceDiscoveryManager
                    .getInstanceFor(connection).retriveHBSession(with);
            return session;
        }
        catch (XMPPException e) {
            e.printStackTrace();
            return null;
        }
    }

}
