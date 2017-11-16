package fr.inria.phoenix.diasuite.framework.misc;

import fr.inria.diagen.core.deploy.AbstractDeploy;

import fr.inria.phoenix.diasuite.framework.context.actionvalidation.AbstractActionValidation;
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

/**
 * This class should be implemented to bind the implementation of the various components
 */
public abstract class AppComponentBinder extends AbstractDeploy {

    // Context instances
    private AbstractActionValidation actionValidationInstance = null;
    private AbstractInsideContext insideContextInstance = null;
    private AbstractLunchAlarmContext lunchAlarmContextInstance = null;
    private AbstractPassword passwordInstance = null;
    private AbstractTimeOver timeOverInstance = null;

    // Controller instances
    private AbstractAlarmActivitedController alarmActivitedControllerInstance = null;
    private AbstractAlarmDesactivatedController alarmDesactivatedControllerInstance = null;
    private AbstractChangePassword changePasswordInstance = null;
    private AbstractLampAlarmSuccessController lampAlarmSuccessControllerInstance = null;
    private AbstractLampSuccessController lampSuccessControllerInstance = null;
    private AbstractLunchAlarmController lunchAlarmControllerInstance = null;
    private AbstractResetAlarmController resetAlarmControllerInstance = null;
    
    @Override
    public void deployAll() {
        // Initialization of contexts
        if (actionValidationInstance == null)
            actionValidationInstance = getInstance(getActionValidationClass());
        if (insideContextInstance == null)
            insideContextInstance = getInstance(getInsideContextClass());
        if (lunchAlarmContextInstance == null)
            lunchAlarmContextInstance = getInstance(getLunchAlarmContextClass());
        if (passwordInstance == null)
            passwordInstance = getInstance(getPasswordClass());
        if (timeOverInstance == null)
            timeOverInstance = getInstance(getTimeOverClass());
        // Intialization of controllers
        if (alarmActivitedControllerInstance == null)
            alarmActivitedControllerInstance = getInstance(getAlarmActivitedControllerClass());
        if (alarmDesactivatedControllerInstance == null)
            alarmDesactivatedControllerInstance = getInstance(getAlarmDesactivatedControllerClass());
        if (changePasswordInstance == null)
            changePasswordInstance = getInstance(getChangePasswordClass());
        if (lampAlarmSuccessControllerInstance == null)
            lampAlarmSuccessControllerInstance = getInstance(getLampAlarmSuccessControllerClass());
        if (lampSuccessControllerInstance == null)
            lampSuccessControllerInstance = getInstance(getLampSuccessControllerClass());
        if (lunchAlarmControllerInstance == null)
            lunchAlarmControllerInstance = getInstance(getLunchAlarmControllerClass());
        if (resetAlarmControllerInstance == null)
            resetAlarmControllerInstance = getInstance(getResetAlarmControllerClass());
        // Deploying contexts
        deploy(actionValidationInstance);
        deploy(insideContextInstance);
        deploy(lunchAlarmContextInstance);
        deploy(passwordInstance);
        deploy(timeOverInstance);
        // Deploying controllers
        deploy(alarmActivitedControllerInstance);
        deploy(alarmDesactivatedControllerInstance);
        deploy(changePasswordInstance);
        deploy(lampAlarmSuccessControllerInstance);
        deploy(lampSuccessControllerInstance);
        deploy(lunchAlarmControllerInstance);
        deploy(resetAlarmControllerInstance);
    }
    
    @Override
    public void undeployAll() {
        // Undeploying contexts
        undeploy(actionValidationInstance);
        undeploy(insideContextInstance);
        undeploy(lunchAlarmContextInstance);
        undeploy(passwordInstance);
        undeploy(timeOverInstance);
        // Undeploying controllers
        undeploy(alarmActivitedControllerInstance);
        undeploy(alarmDesactivatedControllerInstance);
        undeploy(changePasswordInstance);
        undeploy(lampAlarmSuccessControllerInstance);
        undeploy(lampSuccessControllerInstance);
        undeploy(lunchAlarmControllerInstance);
        undeploy(resetAlarmControllerInstance);
    }
    
    // Abstract binding methods for contexts
    /**
     * Overrides this method to provide the implementation class of the <code>ActionValidation</code> context
    
    <pre>
    context ActionValidation as Boolean {
    	when provided timerTriggered from Timer
    	maybe publish;
    	when provided contact from ContactSensor
    	get timerTriggered from Timer
    	maybe publish;
    }
    </pre>
    @return a class object of a derivation of {@link AbstractActionValidation} that implements the <code>ActionValidation</code> context
     */
    public abstract Class<? extends AbstractActionValidation> getActionValidationClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>InsideContext</code> context
    <p>
    ------------------------------------------------------
    CONTEXT
    ------------------------------------------------------
    Permet de savoir si on est INSIDE ou OUTSIDE
    
    <pre>
    context InsideContext as Boolean {
     *   when provided inactivityLevel from InactivitySensor
     *   get lastInteraction from InactivitySensor
     *   maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractInsideContext} that implements the <code>InsideContext</code> context
     */
    public abstract Class<? extends AbstractInsideContext> getInsideContextClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>LunchAlarmContext</code> context
    
    <pre>
    context LunchAlarmContext as Boolean {
     *   when provided Password 
     *   always publish;
     *   when provided timerTriggered from Timer
     *   get timerTriggered from Timer
     *   maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractLunchAlarmContext} that implements the <code>LunchAlarmContext</code> context
     */
    public abstract Class<? extends AbstractLunchAlarmContext> getLunchAlarmContextClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>Password</code> context
    
    <pre>
    context Password as Boolean {
     *     when provided on from Appliance
     *     get on from Appliance, contact from ContactSensor
     *     always publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractPassword} that implements the <code>Password</code> context
     */
    public abstract Class<? extends AbstractPassword> getPasswordClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>TimeOver</code> context
    
    <pre>
    context TimeOver as Boolean {
     *   when provided timerTriggered from Timer
     *   get timerTriggered from Timer
     *   maybe publish;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractTimeOver} that implements the <code>TimeOver</code> context
     */
    public abstract Class<? extends AbstractTimeOver> getTimeOverClass();
    
    // End of abstract binding methods for contexts
    
    // Abstract binding methods for controllers
    /**
     * Overrides this method to provide the implementation class of the <code>AlarmActivitedController</code> controller
    <p>
    ------------------------------------------------------
    CONTROLLER
    ------------------------------------------------------
    
    <pre>
    controller AlarmActivitedController {
     *   when provided InsideContext
     *     do ScheduleTimer on Timer,
     *        SendNonCriticalNotification on Notifier;  
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractAlarmActivitedController} that implements the <code>AlarmActivitedController</code> controller
     */
    public abstract Class<? extends AbstractAlarmActivitedController> getAlarmActivitedControllerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>AlarmDesactivatedController</code> controller
    
    <pre>
    controller AlarmDesactivatedController {
    	when provided InsideContext
    		do ScheduleTimer on Timer;
    }
    </pre>
    @return a class object of a derivation of {@link AbstractAlarmDesactivatedController} that implements the <code>AlarmDesactivatedController</code> controller
     */
    public abstract Class<? extends AbstractAlarmDesactivatedController> getAlarmDesactivatedControllerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>ChangePassword</code> controller
    
    <pre>
    controller ChangePassword {
    	when provided Password
    		do ScheduleTimer on Timer, On on Light;
    	when provided ActionValidation
    		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm;
    }
    </pre>
    @return a class object of a derivation of {@link AbstractChangePassword} that implements the <code>ChangePassword</code> controller
     */
    public abstract Class<? extends AbstractChangePassword> getChangePasswordClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>LampAlarmSuccessController</code> controller
    
    <pre>
    controller LampAlarmSuccessController{
     *   when provided LunchAlarmContext
     *     do ScheduleTimer on Timer;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractLampAlarmSuccessController} that implements the <code>LampAlarmSuccessController</code> controller
     */
    public abstract Class<? extends AbstractLampAlarmSuccessController> getLampAlarmSuccessControllerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>LampSuccessController</code> controller
    
    <pre>
    controller LampSuccessController{
     *   when provided LunchAlarmContext
     *     do On on Light, 
     *        Off on Light;
     *   when provided InsideContext
     *   	do On on Light,
     *   	   Off on Light;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractLampSuccessController} that implements the <code>LampSuccessController</code> controller
     */
    public abstract Class<? extends AbstractLampSuccessController> getLampSuccessControllerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>LunchAlarmController</code> controller
    <p>
    A regrouper avec LampAlarmSuccess ?
    
    <pre>
    controller LunchAlarmController{
     *   when provided LunchAlarmContext
     *     do SendMessage on Messenger,
     *     	   SendCriticalNotification on Notifier,
     *     	   ScheduleTimer on Timer;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractLunchAlarmController} that implements the <code>LunchAlarmController</code> controller
     */
    public abstract Class<? extends AbstractLunchAlarmController> getLunchAlarmControllerClass();
    
    /**
     * Overrides this method to provide the implementation class of the <code>ResetAlarmController</code> controller
    
    <pre>
    controller ResetAlarmController{
     *   when provided TimeOver
     *     do SendNonCriticalNotification on Notifier,
     *        ScheduleTimer on Timer;
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractResetAlarmController} that implements the <code>ResetAlarmController</code> controller
     */
    public abstract Class<? extends AbstractResetAlarmController> getResetAlarmControllerClass();
    
    // End of abstract binding methods for controllers
}
