package aristotle.events.users;

import aristotle.User;

public class UserLoginEvent extends UserEvent {

	public UserLoginEvent(User user) {
		super(user);
	}

}