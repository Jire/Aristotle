package aristotle;

import java.util.HashMap;
import java.util.Map;

import net.sf.jml.Email;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnProtocol;
import net.sf.jml.impl.MsnMessengerFactory;

public class User {

	private static final Map<String, User> cache = new HashMap<String, User>();

	protected static User forMsnMessenger(MsnMessenger messenger) {
		String email = messenger.getOwner().getEmail().getEmailAddress();
		User cached = cache.get(email);
		if (cached != null) {
			return cached;
		}
		User user = new User(messenger);
		cache.put(email, user);
		return user;
	}

	protected static User forMsnContact(MsnContact contact) {
		String email = contact.getEmail().getEmailAddress();
		User cached = cache.get(email);
		if (cached != null) {
			return cached;
		}
		User user = new User(email);
		cache.put(email, user);
		return user;
	}

	public static User get(String email, String password) {
		User cached = cache.get(email);
		if (cached != null) {
			return cached;
		}
		User user = new User(email, password);
		cache.put(email, user);
		return user;
	}

	private final MsnMessenger messenger;

	private User(String email, String password) {
		this.messenger = MsnMessengerFactory.createMsnMessenger(email, password);
		messenger.setSupportedProtocol(new MsnProtocol[] {MsnProtocol.MSNP12});
		messenger.addMessengerListener(new MessengerListener());
		messenger.addContactListListener(new ContactListListener());
		messenger.addSwitchboardListener(new SwitchboardListener());
		messenger.addMessageListener(new MessageListener());
		messenger.addEmailListener(new EmailListener());
	}

	private User(String email) {
		this(email, "unknown");
	}

	private User(MsnMessenger messenger) {
		this.messenger = messenger;
	}

	public String getEmail() {
		return messenger.getOwner().getEmail().getEmailAddress();
	}

	public String getDisplayName() {
		return messenger.getOwner().getDisplayName();
	}

	public String getPersonalMessage() {
		return messenger.getOwner().getPersonalMessage();
	}

	public Status getStatus() {
		return Status.forInternalStatus(messenger.getOwner().getStatus());
	}

	public void addContact(String contactEmail) {
		messenger.addFriend(Email.parseStr(contactEmail), contactEmail);
	}

	public void blockContact(String contactEmail) {
		messenger.blockFriend(Email.parseStr(contactEmail));
	}

	public boolean isVerified() {
		return messenger.getOwner().isVerified();
	}

	public void login(String displayName, String personalMessage, Status status) {
		if (displayName != null) messenger.getOwner().setInitDisplayName(displayName);
		if (personalMessage != null) messenger.getOwner().setInitPersonalMessage(personalMessage);
		if (status != null) messenger.getOwner().setInitStatus(status.getInternal());
		messenger.login();
	}

	public void login(String displayName, String personalMessage) {
		login(displayName, personalMessage, null);
	}

	public void login(Status status) {
		login(null, null, status);
	}

	public void login() {
		login(null);
	}

	public void logout() {
		messenger.logout();
	}

	public void setDisplayName(String displayName) {
		messenger.getOwner().setDisplayName(displayName);
		messenger.getOwner().setInitDisplayName(displayName);
	}

	public void setPersonalMessage(String personalMessage) {
		messenger.getOwner().setPersonalMessage(personalMessage);
		messenger.getOwner().setInitPersonalMessage(personalMessage);
	}

	public void setStatus(Status status) {
		messenger.getOwner().setStatus(status.getInternal());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof User)) {
			return false;
		}
		return ((User)o).getEmail().equalsIgnoreCase(getEmail());
	}

	@Override
	public int hashCode() {
		return getEmail().hashCode();
	}

	@Override
	public String toString() {
		return getEmail();
	}

}