package fr.inria.phoenix.scenario.aleirbgenerale.controller;


import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.ElapsedTimeValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.handlenotifier.AbstractHandleNotifier;
import fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer;
import fr.inria.phoenix.diasuite.framework.datatype.message.Message;
import fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification;
import fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;

public class HandleNotifier extends AbstractHandleNotifier{
	
	public HandleNotifier(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}

	@Override
	protected void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover) {
		if(updatePassword.value().getStep().equals(UpdatingStep.END_UPDATING)){
			NonCriticalNotification notification = new NonCriticalNotification("MDPChanged", "MDP Changed", "MDP CHANGED Successfully", null, false);
			discover.notifiers().whereId(Configuration.notifier).sendNonCriticalNotification(notification);
			
		}else if(updatePassword.value().getStep().equals(UpdatingStep.CANCEL_UPDATING)||updatePassword.value().getStep().equals(UpdatingStep.WRONG_PASSWORD)) {
			NonCriticalNotification notification = new NonCriticalNotification("MDPNotChanged", "MDP Not Changed", "MDP Not CHANGED, Try again..", null, false);
			discover.notifiers().whereId(Configuration.notifier).sendNonCriticalNotification(notification);
		}
	}

	@Override
	protected void onElapsedTime(ElapsedTimeValue elapsedTime, DiscoverForElapsedTime discover) {
		if(elapsedTime.value().equals(AlEirbTimer.DELAY_BEFORE_ALERT) && HandleTimer.armed){
			NotifierCompositeForElapsedTime notifier = discover.notifiers().whereId(Configuration.notifier);
			NonCriticalNotification notification = new NonCriticalNotification(
					Configuration.idActived, Configuration.titreActived, Configuration.messageActived, null , false);
			notifier.sendNonCriticalNotification(notification);
		}		
	}

}
