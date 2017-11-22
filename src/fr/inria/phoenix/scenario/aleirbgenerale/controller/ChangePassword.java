package fr.inria.phoenix.scenario.aleirbgenerale.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.actionvalidation.ActionValidationValue;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.ChangingPasswordValue;
import fr.inria.phoenix.diasuite.framework.controller.changepassword.AbstractChangePassword;

public class ChangePassword extends AbstractChangePassword {

	public ChangePassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onChangingPassword(ChangingPasswordValue changingPassword, DiscoverForChangingPassword discover) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onActionValidation(ActionValidationValue actionValidation, DiscoverForActionValidation discover) {
		// TODO Auto-generated method stub
		
	}

}
