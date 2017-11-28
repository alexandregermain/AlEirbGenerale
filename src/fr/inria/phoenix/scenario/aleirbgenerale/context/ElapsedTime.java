package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.AbstractElapsedTime;
import fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;

public class ElapsedTime extends AbstractElapsedTime {

	public ElapsedTime(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}

	@Override
	protected ElapsedTimeValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer) {
		System.out.println(timerTriggeredFromTimer.sender().id().toString() + timerTriggeredFromTimer.value().toString());
		if (timerTriggeredFromTimer.sender().id().compareTo(Configuration.timerActiveAlarm) == 0) {
			return new ElapsedTimeValuePublishable(AlEirbTimer.TIMER_ACTIVE_ALARM, true);
		}
		if (timerTriggeredFromTimer.sender().id().compareTo(Configuration.timerUpdatingPassword) == 0) {
			return new ElapsedTimeValuePublishable(AlEirbTimer.TIMER_UPDATING_PASSWORD, true);
		}
		else if (timerTriggeredFromTimer.sender().id().compareTo(Configuration.delayBeforeAlert) == 0) {
			return new ElapsedTimeValuePublishable(AlEirbTimer.DELAY_BEFORE_ALERT, true);
		}
		return null;
	}

}
