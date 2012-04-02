package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationInviteContactEvent extends ConversationEvent {

	private final String contactEmail;

	public ConversationInviteContactEvent(Conversation conversation, String contactEmail) {
		super(conversation);
		this.contactEmail = contactEmail;
	}

	public String getContactEmail() {
		return contactEmail;
	}

}