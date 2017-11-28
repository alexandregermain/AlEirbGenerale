package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.AbstractLunchAlarmContext;
import fr.inria.phoenix.diasuite.framework.context.password.PasswordValue;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

public class LunchAlarmContext extends AbstractLunchAlarmContext {

	public Boolean password = false;

	public LunchAlarmContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean onPassword(PasswordValue passwordValue) {
		password = passwordValue.value();
		return password;
	}

	@Override
	protected LunchAlarmContextValuePublishable onTimerTriggeredFromTimer(
			TimerTriggeredFromTimer timerTriggeredFromTimer, DiscoverForTimerTriggeredFromTimer discover) {
		
		int valeurTimer = Integer.parseInt(timerTriggeredFromTimer.value());
		if(password){
			return new LunchAlarmContextValuePublishable(false, true);
		}
		else if(valeurTimer >= 2*1000 && !password){
			return new LunchAlarmContextValuePublishable(true, true);
		}
		return new LunchAlarmContextValuePublishable(false, false);
	}

}
