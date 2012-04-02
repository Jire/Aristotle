package aristotle.events.users;

import aristotle.User;

public class UserContactRequestEvent extends UserEvent {

	private final String contactEmail;

	public UserContactRequestEvent(User user, String contactEmail) {
		super(user);
		this.contactEmail = contactEmail;
	}

	public String getContactEmail() {
		return contactEmail;
	}

}