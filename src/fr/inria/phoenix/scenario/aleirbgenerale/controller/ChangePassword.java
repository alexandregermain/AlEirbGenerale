package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.ChangingPasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.changepassword.AbstractChangePassword;
import fr.inria.phoenix.diasuite.framework.datatype.date.Date;
import fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification;

public class ChangePassword extends AbstractChangePassword {

	public ChangePassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onChangingPassword(ChangingPasswordValue changingPassword, DiscoverForChangingPassword discover) {
		 NotifierProxyForChangingPassword notifier = discover.notifiers().anyOne();
		 NonCriticalNotification notification;
		if (changingPassword.value() =="Success") {
			notification = new NonCriticalNotification("Success", "Passeword changed", "The password have been changed succesfully", null, false);
			
		}else if(changingPassword.value() =="PasswordsDifferent"){
			notification = new NonCriticalNotification("PasswordsDifferent", "Changing Passeword Failed", "Passwords were different. Try again.", null, false);
		} else {
			notification = new NonCriticalNotification("error", "Changing Passeword Failed", "The reinitialisation password was incorrect. Try again.", null, false);
		}
		Date displayDate = new Date();
		Date expirationDate = new Date();
		expirationDate.setDay(expirationDate.getDay()+1);
		notifier.registerNonCriticalNotification(notification , displayDate, expirationDate);
		
	}
}
