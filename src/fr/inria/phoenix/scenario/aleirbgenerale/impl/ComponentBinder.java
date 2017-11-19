package fr.inria.phoenix.scenario.aleirbgenerale.impl;
        
import fr.inria.phoenix.diasuite.framework.context.actionvalidation.AbstractActionValidation;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.AbstractChangingPassword;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.AbstractInsideContext;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.AbstractLunchAlarmContext;
import fr.inria.phoenix.diasuite.framework.context.password.AbstractPassword;
import fr.inria.phoenix.diasuite.framework.context.timeover.AbstractTimeOver;
import fr.inria.phoenix.diasuite.framework.controller.alarmactivitedcontroller.AbstractAlarmActivitedController;
import fr.inria.phoenix.diasuite.framework.controller.alarmdesactivatedcontroller.AbstractAlarmDesactivatedController;
import fr.inria.phoenix.diasuite.framework.controller.changepassword.AbstractChangePassword;
import fr.inria.phoenix.diasuite.framework.controller.lampalarmsuccesscontroller.AbstractLampAlarmSuccessController;
import fr.inria.phoenix.diasuite.framework.controller.lampsuccesscontroller.AbstractLampSuccessController;
import fr.inria.phoenix.diasuite.framework.controller.lunchalarmcontroller.AbstractLunchAlarmController;
import fr.inria.phoenix.diasuite.framework.controller.resetalarmcontroller.AbstractResetAlarmController;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;

/* (non-Javadoc)
 * The binder to provides the various components of the application
 * @see fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder
 */
public class ComponentBinder extends AppComponentBinder {

	@Override
	public Class<? extends AbstractActionValidation> getActionValidationClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractChangingPassword> getChangingPasswordClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractInsideContext> getInsideContextClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractLunchAlarmContext> getLunchAlarmContextClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractPassword> getPasswordClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractTimeOver> getTimeOverClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractAlarmActivitedController> getAlarmActivitedControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractAlarmDesactivatedController> getAlarmDesactivatedControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractChangePassword> getChangePasswordClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractLampAlarmSuccessController> getLampAlarmSuccessControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractLampSuccessController> getLampSuccessControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractLunchAlarmController> getLunchAlarmControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends AbstractResetAlarmController> getResetAlarmControllerClass() {
		// TODO Auto-generated method stub
		return null;
	}
}
