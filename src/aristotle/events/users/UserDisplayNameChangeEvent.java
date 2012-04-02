package aristotle.events.users;

import aristotle.User;

public class UserDisplayNameChangeEvent extends UserEvent {

	public UserDisplayNameChangeEvent(User user) {
		super(user);
	}

}