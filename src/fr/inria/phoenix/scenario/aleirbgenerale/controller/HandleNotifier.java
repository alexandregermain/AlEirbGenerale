package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import java.util.Arrays;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.handlenotifier.AbstractHandleNotifier;
import fr.inria.phoenix.diasuite.framework.datatype.file.File;
import fr.inria.phoenix.diasuite.framework.datatype.message.Message;
import fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification;

public class HandleNotifier extends AbstractHandleNotifier{

	
	private static final fr.inria.phoenix.diasuite.framework.datatype.contact.Contact Contact =
			new fr.inria.phoenix.diasuite.framework.datatype.contact.Contact("Name", "EmailAdresse", "055555555", "./icon.png", null);
	private static final java.lang.String Title = "Alarme déclanchée";
	private static final java.lang.String Message = "L'alarme a été activé";
	
	
	public HandleNotifier(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}

	@Override
	protected void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover) {
		
		NotifierCompositeForUpdatePassword notifier = discover.notifiers().whereId("");
		NonCriticalNotification notification = new NonCriticalNotification("id", "title", "text", null, false);
		if(true){
			java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachement =  Arrays.asList(
					new File()); 
			Message message = new Message(Contact, Title, Message, attachement);
			discover.messengers().anyOne().sendMessage(message );
			
			//reset Alarm
		}			
	}

}
