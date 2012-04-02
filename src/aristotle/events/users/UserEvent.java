package aristotle.events.users;

import net.alkine.event.Event;
import aristotle.User;

public abstract class UserEvent implements Event {

	private final User user;

	public UserEvent(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}