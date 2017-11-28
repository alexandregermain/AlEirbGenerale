package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
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
		if(!lunchAlarmContext.value()){
			String id = "LightAlarm";
			LightProxyForLunchAlarmContext light = discover.lights().whereId(id).anyOne();
			try {
				lumiereAlarm(light);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	protected void lumiereAlarm(LightProxyForLunchAlarmContext light) throws InterruptedException{
		int frequence = 500;
		light.on();
		Thread.sleep(frequence);
		light.off();
		Thread.sleep(frequence);
		light.on();
		Thread.sleep(frequence);
		light.off();
		Thread.sleep(frequence);
		light.on();
		Thread.sleep(frequence);
		light.off();
		
	}
}
