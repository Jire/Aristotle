package aristotle;

import static aristotle.events.EventManager.dispatchEvent;

import java.util.HashMap;
import java.util.Map;

import net.sf.jml.Email;
import net.sf.jml.MsnConnection;
import net.sf.jml.MsnSwitchboard;
import aristotle.events.conversations.ConversationSendMessageEvent;

public class Conversation {

	private static final Map<MsnConnection, Conversation> cache = new HashMap<MsnConnection, Conversation>();

	private final MsnSwitchboard switchboard;

	protected static Conversation forMsnSwitchboard(MsnSwitchboard switchboard) {
		Conversation cached = cache.get(switchboard.getConnection());
		if (cached != null) {
			return cached;
		}
		Conversation conversation = new Conversation(switchboard);
		cache.put(switchboard.getConnection(), conversation);
		return conversation;
	}

	private Conversation(MsnSwitchboard switchboard) {
		this.switchboard = switchboard;
	}

	public void sendMessage(String message) {
		switchboard.sendText(message);
		dispatchEvent(new ConversationSendMessageEvent(this, message));
	}

	public User getUser() {
		return User.forMsnMessenger(switchboard.getMessenger());
	}

	public void inviteContact(String email) {
		switchboard.inviteContact(Email.parseStr(email));
	}

	public void close() {
		switchboard.close();
	}

}