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
		return ElapsedTime.class;
	}

	@Override
	public Class<? extends AbstractIsInside> getIsInsideClass() {
		return IsInside.class;
	}

	@Override
	public Class<? extends AbstractPasswordListener> getPasswordListenerClass() {
		return PasswordListener.class;
	}

	@Override
	public Class<? extends AbstractUpdatePassword> getUpdatePasswordClass() {
		return UpdatePassword.class;
	}

	@Override
	public Class<? extends AbstractHandleNotifier> getHandleNotifierClass() {
		return HandleNotifier.class;
	}

	@Override
	public Class<? extends AbstractHandlePassword> getHandlePasswordClass() {
		return HandlePassword.class;
	}

	@Override
	public Class<? extends AbstractHandleTimer> getHandleTimerClass() {
		return HandleTimer.class;
	}

}
