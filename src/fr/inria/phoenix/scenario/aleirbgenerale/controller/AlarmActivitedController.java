package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.InsideContextValue;
import fr.inria.phoenix.diasuite.framework.controller.alarmactivitedcontroller.AbstractAlarmActivitedController;
import fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification;

public class AlarmActivitedController extends AbstractAlarmActivitedController{

	public AlarmActivitedController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onInsideContext(InsideContextValue insideContext, DiscoverForInsideContext discover) {
		if(insideContext.value()){
			String timer1 = "Timer1";
			TimerProxyForInsideContext timerAlarm = discover.timers().whereId(timer1).anyOne();
			timerAlarm.schedule(timer1, 1000);
			
			NotifierCompositeForInsideContext notifier = discover.notifiers().all();
			NonCriticalNotification notification = new NonCriticalNotification("id", "title", "text", null, false);
			notifier.sendNonCriticalNotification(notification );
		}
	}

}
