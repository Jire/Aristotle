package aristotle.events.users;

import aristotle.User;

public class UserSystemMessageReceived extends UserEvent {

	private final String message;

	public UserSystemMessageReceived(User user, String message) {
		super(user);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}