package fr.inria.phoenix.scenario.aleirbgenerale.impl;
        
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.AbstractElapsedTime;
import fr.inria.phoenix.diasuite.framework.context.isinside.AbstractIsInside;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.AbstractPasswordListener;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.AbstractUpdatePassword;
import fr.inria.phoenix.diasuite.framework.controller.handlenotifier.AbstractHandleNotifier;
import fr.inria.phoenix.diasuite.framework.controller.handlepassword.AbstractHandlePassword;
import fr.inria.phoenix.diasuite.framework.controller.handletimer.AbstractHandleTimer;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.scenario.aleirbgenerale.context.ElapsedTime;
import fr.inria.phoenix.scenario.aleirbgenerale.context.IsInside;
import fr.inria.phoenix.scenario.aleirbgenerale.context.PasswordListener;
import fr.inria.phoenix.scenario.aleirbgenerale.context.UpdatePassword;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandleNotifier;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandlePassword;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandleTimer;

/* (non-Javadoc)	
 * The binder to provides the various components of the application
 * @see fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder
 */
public class ComponentBinder extends AppComponentBinder {

	@Override
	public Class<? extends AbstractElapsedTime> getElapsedTimeClass() {
		// TODO Auto-generated method stub
		return ElapsedTime.class;
	}

	@Override
	public Class<? extends AbstractIsInside> getIsInsideClass() {
		// TODO Auto-generated method stub
		return IsInside.class;
	}

	@Override
	public Class<? extends AbstractPasswordListener> getPasswordListenerClass() {
		// TODO Auto-generated method stub
		return PasswordListener.class;
	}

	@Override
	public Class<? extends AbstractUpdatePassword> getUpdatePasswordClass() {
		// TODO Auto-generated method stub
		return UpdatePassword.class;
	}

	@Override
	public Class<? extends AbstractHandleNotifier> getHandleNotifierClass() {
		// TODO Auto-generated method stub
		return HandleNotifier.class;
	}

	@Override
	public Class<? extends AbstractHandlePassword> getHandlePasswordClass() {
		// TODO Auto-generated method stub
		return HandlePassword.class;
	}

	@Override
	public Class<? extends AbstractHandleTimer> getHandleTimerClass() {
		// TODO Auto-generated method stub
		return HandleTimer.class;
	}

}
