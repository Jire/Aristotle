package aristotle.events;

import net.alkine.event.Event;
import net.alkine.event.EventListener;

public class EventManager {

	private static final net.alkine.event.EventManager eventManager = new net.alkine.event.EventManager();

	public static void dispatchEvent(Event event) {
		eventManager.dispatchEvent(event);
	}

	public static void registerListener(EventListener listener) {
		eventManager.registerListener(listener);
	}

}