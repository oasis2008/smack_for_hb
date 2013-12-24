package org.jivesoftware.custom;

import org.jivesoftware.custom.packet.ChatHistory;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;

/**
 * Created by clerkmaxwell on 13-12-24.
 */
public class ChatMessaegList {

    public static ChatHistory retrieveChatHistory(String targetJID,
                     String UTC, String limit, String index, String offset) {
        try {
            ChatHistory chatHistory = ServiceDiscoveryManager
                    .getInstanceFor(connection).retrieveChatHistory(targetJID, UTC, limit, index, offset);
            return chatHistory;
        }
        catch (XMPPException e) {
            e.printStackTrace();
            return null;
        }

    }
}
