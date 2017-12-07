package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.PasswordListenerValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.handlepassword.AbstractHandlePassword;
import fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep;

public class HandlePassword extends AbstractHandlePassword {

	public HandlePassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onPasswordListener(PasswordListenerValue passwordListener, DiscoverForPasswordListener discover) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover) {
		// TODO Auto-generated method stub
		if(updatePassword.value().getStep().equals(UpdatingStep.END_UPDATING)){
			String id = "LightAlarm";
			LightProxyForUpdatePassword light = discover.lights().whereId(id).anyOne();
			try {
				lumiereAlarm(light);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(updatePassword.value().getStep().equals(UpdatingStep.CANCEL_UPDATING)||updatePassword.value().getStep().equals(UpdatingStep.WRONG_PASSWORD)) {
			String id = "LightAlarm";
			LightProxyForUpdatePassword light = discover.lights().whereId(id).anyOne();
			try {
				lumiereAlarm(light);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

	protected void lumiereAlarm(LightProxyForUpdatePassword light) throws InterruptedException{
		int frequence = 500;//sleep fonctionnent pas ..
		light.on();
		//Thread.sleep(frequence);
		light.off();
		//Thread.sleep(frequence);
		light.on();
		//Thread.sleep(frequence);
		light.off();
		//Thread.sleep(frequence);
		light.on();
		//Thread.sleep(frequence);
		light.off();
		
	}
}
