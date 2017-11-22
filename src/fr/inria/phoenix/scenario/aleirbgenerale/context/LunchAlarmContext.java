package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.AbstractLunchAlarmContext;
import fr.inria.phoenix.diasuite.framework.context.password.PasswordValue;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

public class LunchAlarmContext extends AbstractLunchAlarmContext {

	public LunchAlarmContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean onPassword(PasswordValue passwordValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected LunchAlarmContextValuePublishable onTimerTriggeredFromTimer(
			TimerTriggeredFromTimer timerTriggeredFromTimer, DiscoverForTimerTriggeredFromTimer discover) {
		// TODO Auto-generated method stub
		return null;
	}

}
