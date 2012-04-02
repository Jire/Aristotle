package aristotle;

import static aristotle.events.EventManager.dispatchEvent;
import net.sf.jml.MsnMessenger;
import net.sf.jml.event.MsnMessengerListener;
import aristotle.events.users.UserLoginEvent;
import aristotle.events.users.UserLogoutEvent;

class MessengerListener implements MsnMessengerListener {

	@Override
	public void loginCompleted(MsnMessenger messenger) {
		dispatchEvent(new UserLoginEvent(User.forMsnMessenger(messenger)));
	}

	@Override
	public void logout(MsnMessenger messenger) {
		dispatchEvent(new UserLogoutEvent(User.forMsnMessenger(messenger)));
	}

	@Override
	public void exceptionCaught(MsnMessenger messenger, Throwable throwable) {
		// TODO Auto-generated method stub

	}

}