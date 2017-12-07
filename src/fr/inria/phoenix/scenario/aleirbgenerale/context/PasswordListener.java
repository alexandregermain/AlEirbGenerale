package fr.inria.phoenix.scenario.aleirbgenerale.context;

import java.util.ListIterator;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.ElapsedTimeValue;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.AbstractPasswordListener;
import fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer;
import fr.inria.phoenix.diasuite.framework.device.contactsensor.ContactFromContactSensor;
import fr.inria.phoenix.diasuite.framework.device.light.OnFromLight;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandleTimer;

public class PasswordListener extends AbstractPasswordListener {
	public static ListIterator<String> passwordIter =  initPass();
	private Boolean isInside = true;
	private Boolean isStillTime = true;
	
	private static ListIterator<String> initPass(){
		return UpdatePassword.ActualPassword.listIterator();
	}
	
	@SuppressWarnings("unused")
	private void resetVariables() {
		isStillTime = true;
		passwordIter =  initPass();
	}
	
	public PasswordListener(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PasswordListenerValuePublishable onOnFromLight(OnFromLight onFromLight) {
		if(isInside && HandleTimer.armed && isStillTime) {
			if (passwordIter.hasNext()) {
				if (passwordIter.next().equals(onFromLight.sender().id())) {
					if(!passwordIter.hasNext()) {
						return new PasswordListenerValuePublishable(true,true);
					}
				}
				else {
					passwordIter = initPass();
				}
			}else {
				passwordIter =  initPass();
			}
		}
		return null;
	}

	@Override
	protected PasswordListenerValuePublishable onContactFromContactSensor(
			ContactFromContactSensor contactFromContactSensor) {
		if(isInside && HandleTimer.armed && isStillTime) {
			if (passwordIter.hasNext()) {
				if (passwordIter.next().equals(contactFromContactSensor.sender().id())) {
					if(!passwordIter.hasNext()) {
						return new PasswordListenerValuePublishable(true,true);
					}
				}else {
					passwordIter = initPass();
				}
			}else {
				passwordIter =  initPass();
			}
		}
		return null;
	}

	@Override
	protected void onElapsedTime(ElapsedTimeValue elapsedTimeValue) {
		if (elapsedTimeValue.equals(AlEirbTimer.DELAY_BEFORE_ALERT)) {
			 isStillTime = false;
		}
	}

}
