package aristotle.events.contacts;

public abstract class ContactEvent {

	private final String contact;

	public ContactEvent(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

}