package fr.inria.phoenix.diasuite.framework.misc;

import fr.inria.diagen.core.deploy.AbstractDeploy;

import fr.inria.phoenix.diasuite.framework.context.elapsedtime.AbstractElapsedTime;
import fr.inria.phoenix.diasuite.framework.context.isinside.AbstractIsInside;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.AbstractPasswordListener;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.AbstractUpdatePassword;

import fr.inria.phoenix.diasuite.framework.controller.handlenotifier.AbstractHandleNotifier;
import fr.inria.phoenix.diasuite.framework.controller.handlepassword.AbstractHandlePassword;
import fr.inria.phoenix.diasuite.framework.controller.handletimer.AbstractHandleTimer;

/**
 * This class should be implemented to bind the implementation of the various components
 */
public abstract class AppComponentBinder extends AbstractDeploy {

    // Context instances
    private AbstractElapsedTime elapsedTimeInstance = null;
    private AbstractIsInside isInsideInstance = null;
    private AbstractPasswordListener passwordListenerInstance = null;
    private AbstractUpdatePassword updatePasswordInstance = null;

    // Controller instances
    private AbstractHandleNotifier handleNotifierInstance = null;
    private AbstractHandlePassword handlePasswordInstance = null;
    private AbstractHandleTimer handleTimerInstance = null;
    
    @Override
    public void deployAll() {
        // Initialization of contexts
        if (elapsedTimeInstance == null)
            elapsedTimeInstance = getInstance(getElapsedTimeClass());
        if (isInsideInstance == null)
            isInsideInstance = getInstance(getIsInsideClass());
        if (passwordListenerInstance == null)
            passwordListenerInstance = getInstance(getPasswordListenerClass());
        if (updatePasswordInstance == null)
            updatePasswordInstance = getInstance(getUpdatePasswordClass());
        // Intialization of controllers
        if (handleNotifierInstance == null)
            handleNotifierInstance = getInstance(getHandleNotifierClass());
        if (handlePasswordInstance == null)
            handlePasswordInstance = getInstance(getHandlePasswordClass());
        if (handleTimerInstance == null)
            handleTimerInstance = getInstance(getHandleTimerClass());
        // Deploying contexts
        deploy(elapsedTimeInstance);
        deploy(isInsideInstance);
        deploy(passwordListenerInstance);
        deploy(updatePasswordInstance);
        // Deploying controllers
        deploy(handleNotifierInstance);
        deploy(handlePasswordInstance);
        deploy(handleTimerInstance);
    }
    
    @Override
    public void undeployAll() {
        // Undeploying contexts
        undeploy(elapsedTimeInstance);
        undeploy(isInsideInstance);
        undeploy(passwordListenerInstance);
        undeploy(updatePasswordInstance);
        // Undeploying controllers
        undeploy(handleNotifierInstance);
        undeploy(handlePasswordInstance);
        undeploy(handleTimerInstance);
    }
    
    // Abstract binding methods for contexts
    /**
     * Overrides this method to provide the implementation class of the <code>ElapsedTime</code> context
    <p>
    listen for all timers
    
    <pre>
    context ElapsedTime as AlEirbTimer {
     * 	when provided timerTriggered from Timer maybe publish; 
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractElapsedTime} that implements the <code>ElapsedTime</code> context
     */
    public abstract Class<? extends AbstractElapsedTime> getElapsedTimeClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>IsInside</code> context
    <p>
    ------------------------------------------------------
    CONTEXT
    ------------------------------------------------------
    Permet de savoir si on est INSIDE ou OUTSIDE
    
    <pre>
    context IsInside as Boolean {
     *   when provided inactivityLevel from InactivitySensor
     *   get lastInteraction from InactivitySensor
     *   maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractIsInside} that implements the <code>IsInside</code> context
     */
    public abstract Class<? extends AbstractIsInside> getIsInsideClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>PasswordListener</code> context
    <p>
    no more listen after ringing stops
    
    <pre>
    context PasswordListener as Boolean {
     * 	when provided IsInside no publish; 
     * 	when provided on from Light maybe publish; 
     * 	when provided contact from ContactSensor maybe publish; 
     * 	when provided ElapsedTime no publish; 
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractPasswordListener} that implements the <code>PasswordListener</code> context
     */
    public abstract Class<? extends AbstractPasswordListener> getPasswordListenerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>UpdatePassword</code> context
    <p>
    publish update canceling
    
    <pre>
    context UpdatePassword as PasswordUpdating {
     * 	when provided contact from ContactSensor maybe publish; 
     * 	when provided on from Light maybe publish;
     * 	when provided ElapsedTime maybe publish; 
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractUpdatePassword} that implements the <code>UpdatePassword</code> context
     */
    public abstract Class<? extends AbstractUpdatePassword> getUpdatePasswordClass();
    
    // End of abstract binding methods for contexts
    
    // Abstract binding methods for controllers
    /**
     * Overrides this method to provide the implementation class of the <code>HandleNotifier</code> controller
    
    <pre>
    controller HandleNotifier{
     *   when provided UpdatePassword
     *     do ScheduleTimer on Timer,
     *        SendMessage on Messenger,
     * 	   SendCriticalNotification on Notifier;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractHandleNotifier} that implements the <code>HandleNotifier</code> controller
     */
    public abstract Class<? extends AbstractHandleNotifier> getHandleNotifierClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>HandlePassword</code> controller
    
    <pre>
    controller HandlePassword{
     *   when provided PasswordListener
     *     do On on Light, 
     *        Off on Light;
     *   when provided UpdatePassword
     *     do On on Light, 
     *        Off on Light;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractHandlePassword} that implements the <code>HandlePassword</code> controller
     */
    public abstract Class<? extends AbstractHandlePassword> getHandlePasswordClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>HandleTimer</code> controller
    <p>
    ------------------------------------------------------
    CONTROLLER
    ------------------------------------------------------
    
    <pre>
    controller HandleTimer {
     *   when provided IsInside
     *     do ScheduleTimer on Timer;
     *   when provided PasswordListener
     *     do ScheduleTimer on Timer; 
     *   when provided UpdatePassword
     *     do ScheduleTimer on Timer;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractHandleTimer} that implements the <code>HandleTimer</code> controller
     */
    public abstract Class<? extends AbstractHandleTimer> getHandleTimerClass();
    
    // End of abstract binding methods for controllers
}
