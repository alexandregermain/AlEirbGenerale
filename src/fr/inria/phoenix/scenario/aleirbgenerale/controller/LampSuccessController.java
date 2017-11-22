package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.InsideContextValue;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.LunchAlarmContextValue;
import fr.inria.phoenix.diasuite.framework.controller.lampsuccesscontroller.AbstractLampSuccessController;

public class LampSuccessController extends AbstractLampSuccessController {

	public LampSuccessController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onLunchAlarmContext(LunchAlarmContextValue lunchAlarmContext,
			DiscoverForLunchAlarmContext discover) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onInsideContext(InsideContextValue insideContext, DiscoverForInsideContext discover) {
		// TODO Auto-generated method stub
		
	}

}
