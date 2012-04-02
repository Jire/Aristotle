package aristotle;

import static aristotle.events.EventManager.dispatchEvent;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnContactPending;
import net.sf.jml.MsnGroup;
import net.sf.jml.MsnList;
import net.sf.jml.MsnMessenger;
import net.sf.jml.event.MsnContactListListener;
import aristotle.events.users.UserContactRequestEvent;
import aristotle.events.users.UserDisplayNameChangeEvent;
import aristotle.events.users.UserPersonalMessageChangeEvent;
import aristotle.events.users.UserStatusChangeEvent;

public class ContactListListener implements MsnContactListListener {

	@Override
	public void contactListSyncCompleted(MsnMessenger messenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactListInitCompleted(MsnMessenger messenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactStatusChanged(MsnMessenger messenger, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactPersonalMessageChanged(MsnMessenger messenger,
			MsnContact contact) {
		dispatchEvent(new UserPersonalMessageChangeEvent(User.forMsnMessenger(messenger)));
	}

	@Override
	public void ownerStatusChanged(MsnMessenger messenger) {
		dispatchEvent(new UserStatusChangeEvent(User.forMsnMessenger(messenger)));
	}

	@Override
	public void ownerDisplayNameChanged(MsnMessenger messenger) {
		dispatchEvent(new UserDisplayNameChangeEvent(User.forMsnMessenger(messenger)));
	}

	@Override
	public void contactAddedMe(MsnMessenger messenger, MsnContact contact) {
		dispatchEvent(new UserContactRequestEvent(User.forMsnMessenger(messenger), contact.getEmail().getEmailAddress()));
	}

	@Override
	public void contactAddedMe(MsnMessenger messenger, MsnContactPending[] pending) {
		for (MsnContactPending contact : pending) {
			dispatchEvent(new UserContactRequestEvent(User.forMsnMessenger(messenger), contact.getEmail().getEmailAddress()));
		}
	}

	@Override
	public void contactRemovedMe(MsnMessenger messenger, MsnContact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactAddCompleted(MsnMessenger messenger, MsnContact contact,
			MsnList list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactAddInGroupCompleted(MsnMessenger messenger,
			MsnContact contact, MsnGroup group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactRemoveCompleted(MsnMessenger messenger,
			MsnContact contact, MsnList list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contactRemoveFromGroupCompleted(MsnMessenger messenger,
			MsnContact contact, MsnGroup group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void groupAddCompleted(MsnMessenger messenger, MsnGroup group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void groupRemoveCompleted(MsnMessenger messenger, MsnGroup group) {
		// TODO Auto-generated method stub

	}

}