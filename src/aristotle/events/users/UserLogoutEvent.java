package aristotle.events.users;

import aristotle.User;

public class UserLogoutEvent extends UserEvent {

	public UserLogoutEvent(User user) {
		super(user);
	}

}