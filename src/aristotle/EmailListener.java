package aristotle;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.event.MsnEmailListener;
import net.sf.jml.message.MsnEmailActivityMessage;
import net.sf.jml.message.MsnEmailInitEmailData;
import net.sf.jml.message.MsnEmailInitMessage;
import net.sf.jml.message.MsnEmailNotifyMessage;

class EmailListener implements MsnEmailListener {

	@Override
	public void initialEmailNotificationReceived(MsnSwitchboard switchboard,
			MsnEmailInitMessage message, MsnContact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialEmailDataReceived(MsnSwitchboard switchboard,
			MsnEmailInitEmailData message, MsnContact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newEmailNotificationReceived(MsnSwitchboard switchboard,
			MsnEmailNotifyMessage message, MsnContact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activityEmailNotificationReceived(MsnSwitchboard switchboard,
			MsnEmailActivityMessage message, MsnContact contact) {
		// TODO Auto-generated method stub
		
	}

}