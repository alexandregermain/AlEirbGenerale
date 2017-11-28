package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import java.util.Arrays;
import java.util.List;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.LunchAlarmContextValue;
import fr.inria.phoenix.diasuite.framework.controller.lunchalarmcontroller.AbstractLunchAlarmController;
import fr.inria.phoenix.diasuite.framework.datatype.file.File;
import fr.inria.phoenix.diasuite.framework.datatype.message.Message;

public class LunchAlarmController extends AbstractLunchAlarmController {
	
	private static final fr.inria.phoenix.diasuite.framework.datatype.contact.Contact Contact =
			new fr.inria.phoenix.diasuite.framework.datatype.contact.Contact("Name", "EmailAdresse", "055555555", "./icon.png", null);
	private static final java.lang.String Title = "Alarme déclanchée";
	private static final java.lang.String Message = "L'alarme a été activé";
	
	public LunchAlarmController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onLunchAlarmContext(LunchAlarmContextValue lunchAlarmContext,
			DiscoverForLunchAlarmContext discover) {
		if(lunchAlarmContext.value()){
			java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachement =  Arrays.asList(
					new File()); 
			Message message = new Message(Contact, Title, Message, attachement);
			discover.messengers().anyOne().sendMessage(message );
			
			//reset Alarm
		}	
	}

}
