package aristotle.events.users;

import aristotle.User;

public class UserPersonalMessageChangeEvent extends UserEvent {

	public UserPersonalMessageChangeEvent(User user) {
		super(user);
	}

}