package aristotle;

import net.sf.jml.MsnUserStatus;

public enum Status {
	AVAILABLE(MsnUserStatus.ONLINE),
	AWAY(MsnUserStatus.AWAY),
	BUSY(MsnUserStatus.BUSY),
	APPEAR_OFFLINE(MsnUserStatus.HIDE);

	private final MsnUserStatus internal;

	Status(MsnUserStatus internal) {
		this.internal = internal;
	}

	MsnUserStatus getInternal() {
		return internal;
	}

	static Status forInternalStatus(MsnUserStatus internal) {
		for (Status status : values()) {
			if (status.equals(internal)) {
				return status;
			}
		}
		return Status.AVAILABLE;
	}
}