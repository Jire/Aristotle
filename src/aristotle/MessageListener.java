package aristotle;

import static aristotle.events.EventManager.dispatchEvent;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.event.MsnMessageListener;
import net.sf.jml.message.MsnControlMessage;
import net.sf.jml.message.MsnDatacastMessage;
import net.sf.jml.message.MsnInstantMessage;
import net.sf.jml.message.MsnSystemMessage;
import net.sf.jml.message.MsnUnknownMessage;
import net.sf.jml.message.p2p.MsnP2PMessage;
import aristotle.events.conversations.ConversationMessageReceivedEvent;
import aristotle.events.users.UserSystemMessageReceived;

class MessageListener implements MsnMessageListener {

	@Override
	public void instantMessageReceived(MsnSwitchboard switchboard,
			MsnInstantMessage message, MsnContact contact) {
		dispatchEvent(new ConversationMessageReceivedEvent(Conversation.forMsnSwitchboard(switchboard), message.getContent(), contact.getEmail().getEmailAddress()));
	}

	@Override
	public void offlineMessageReceived(String body, String contentType,
			String encoding, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controlMessageReceived(MsnSwitchboard switchboard,
			MsnControlMessage message, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void systemMessageReceived(MsnMessenger messenger,
			MsnSystemMessage message) {
		dispatchEvent(new UserSystemMessageReceived(User.forMsnMessenger(messenger), message.getContent()));
	}

	@Override
	public void datacastMessageReceived(MsnSwitchboard switchboard,
			MsnDatacastMessage message, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unknownMessageReceived(MsnSwitchboard switchboard,
			MsnUnknownMessage message, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void p2pMessageReceived(MsnSwitchboard switchboard,
			MsnP2PMessage message, MsnContact contact) {
		// TODO Auto-generated method stub

	}

}