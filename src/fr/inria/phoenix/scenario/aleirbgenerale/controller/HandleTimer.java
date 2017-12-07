package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.isinside.IsInsideValue;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.PasswordListenerValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.handletimer.AbstractHandleTimer;
import fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;

public class HandleTimer extends AbstractHandleTimer{
	public static boolean armed = false;
	
	public HandleTimer(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onIsInside(IsInsideValue isInside, DiscoverForIsInside discover) {
		TimerCompositeForIsInside timerAlarm = discover.timers().whereId(Configuration.delayBeforeAlert);

		//S'il n'y a personne on arme l'alarme
		if(!isInside.value()){
			armed = true;
			timerAlarm.schedule(Configuration.delayBeforeAlert,Configuration.timeDelay);
		}
		//Sinon on la desactive
		else{
			armed = false;
			timerAlarm.cancel(Configuration.delayBeforeAlert);
		}
	}

	@Override
	protected void onPasswordListener(PasswordListenerValue passwordListener, DiscoverForPasswordListener discover) {
		
		TimerCompositeForPasswordListener timerAlarm = discover.timers().whereId(Configuration.delayBeforeAlert);
		if(passwordListener.value()){
			armed = false;
			timerAlarm.cancel(Configuration.delayBeforeAlert);
		}
	}

	@Override
	protected void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover) {
		if(updatePassword.value().getStep().equals(UpdatingStep.INIT_UPDATING)) {
			Integer delayMs = Configuration.timeDelay; //30 sec
			discover.timers().anyOne().schedule("TIMER_UPDATING_PASSWORD", delayMs);
		}else {
			discover.timers().all().cancel("TIMER_UPDATING_PASSWORD");
		}
		
	}	

}
