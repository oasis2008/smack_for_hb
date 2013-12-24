package org.jivesoftware.custom;

import org.jivesoftware.custom.packet.ChatHistory;
import org.jivesoftware.custom.packet.Conversation;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;

/**
 * Created by clerkmaxwell on 13-12-24.
 */
public class ChatMessageList {

    public static ChatHistory retrieveChatHistory(Connection connection, String targetJID,
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

    public static Conversation retrieveConversationList(Connection connection, String max, String index, String after) {
        try {
            Conversation conversation = ServiceDiscoveryManager
                    .getInstanceFor(connection).retrieveConversationList(max, index, after);
            return conversation;
        }
        catch (XMPPException e) {
            e.printStackTrace();
            return null;
        }
    }
}
