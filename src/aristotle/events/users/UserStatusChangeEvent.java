package aristotle.events.users;

import aristotle.User;

public class UserStatusChangeEvent extends UserEvent {

	public UserStatusChangeEvent(User user) {
		super(user);
	}

}