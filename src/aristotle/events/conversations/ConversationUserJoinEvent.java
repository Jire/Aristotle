package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationUserJoinEvent extends ConversationEvent {

	private final String userEmail;

	public ConversationUserJoinEvent(Conversation conversation, String userEmail) {
		super(conversation);
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

}