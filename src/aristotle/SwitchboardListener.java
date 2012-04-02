package aristotle;

import static aristotle.events.EventManager.dispatchEvent;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.event.MsnSwitchboardListener;
import aristotle.events.conversations.ConversationClosedEvent;
import aristotle.events.conversations.ConversationStartedEvent;
import aristotle.events.conversations.ConversationUserJoinEvent;
import aristotle.events.conversations.ConversationUserLeaveEvent;

class SwitchboardListener implements MsnSwitchboardListener {

	@Override
	public void switchboardStarted(MsnSwitchboard switchboard) {
		dispatchEvent(new ConversationStartedEvent(Conversation.forMsnSwitchboard(switchboard)));
	}

	@Override
	public void switchboardClosed(MsnSwitchboard switchboard) {
		dispatchEvent(new ConversationClosedEvent(Conversation.forMsnSwitchboard(switchboard)));
	}

	@Override
	public void contactJoinSwitchboard(MsnSwitchboard switchboard,
			MsnContact contact) {
		dispatchEvent(new ConversationUserJoinEvent(Conversation.forMsnSwitchboard(switchboard), contact.getEmail().getEmailAddress()));
	}

	@Override
	public void contactLeaveSwitchboard(MsnSwitchboard switchboard,
			MsnContact contact) {
		dispatchEvent(new ConversationUserLeaveEvent(Conversation.forMsnSwitchboard(switchboard), contact.getEmail().getEmailAddress()));
	}

}