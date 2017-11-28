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
		TimerCompositeForIsInside timerAlarm = discover.timers().whereId(Configuration.timerActiveAlarm);
		
		if(isInside.value()){
			System.out.println(isInside.value().toString());
			armed = true;
			timerAlarm.periodicSchedule(Configuration.timerActiveAlarm,0,100);
		}
		else{
			armed = false;
			timerAlarm.cancel(Configuration.timerActiveAlarm);
		}
	}

	@Override
	protected void onPasswordListener(PasswordListenerValue passwordListener, DiscoverForPasswordListener discover) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover) {
		if(updatePassword.value().getStep().equals(UpdatingStep.INIT_UPDATING)) {
			Integer delayMs = 30000; //30 sec
			discover.timers().anyOne().schedule("TIMER_UPDATING_PASSWORD", delayMs);
			//TODO Start alarm TIMER_UPDATING_PASSWORD
		}else {
			discover.timers().all().cancel("TIMER_UPDATING_PASSWORD");
			//TODO STOP alarm TIMER_UPDATING_PASSWORD
		}
	}

}
