package fr.inria.phoenix.diasuite.framework.controller.changepassword;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.actionvalidation.ActionValidationValue;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.ChangingPasswordValue;

/**
 * <pre>
controller ChangePassword {
	when provided ChangingPassword
	do ScheduleTimer on Timer, On on Light;
	when provided ActionValidation
		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm,
		   SendMessage on Messenger,
    	   SendCriticalNotification on Notifier;
}
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractChangePassword extends Service {
    
    public AbstractChangePassword(ServiceConfiguration serviceConfiguration) {
        super("/Controller/ChangePassword/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("actionValidation", "/Context/ActionValidation/"); // subscribe to ActionValidation context
        subscribeValue("changingPassword", "/Context/ChangingPassword/"); // subscribe to ChangingPassword context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("actionValidation") && source.isCompatible("/Context/ActionValidation/")) {
            ActionValidationValue actionValidationValue = new ActionValidationValue((java.lang.Boolean) value);
            
            onActionValidation(actionValidationValue, new DiscoverForActionValidation());
        }
        if (eventName.equals("changingPassword") && source.isCompatible("/Context/ChangingPassword/")) {
            ChangingPasswordValue changingPasswordValue = new ChangingPasswordValue((java.lang.Boolean) value);
            
            onChangingPassword(changingPasswordValue, new DiscoverForChangingPassword());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>ChangingPassword</code> context publishes a value.
     * 
     * <pre>
     * when provided ChangingPassword
     * 	do ScheduleTimer on Timer, On on Light;
     * </pre>
     * 
     * @param changingPassword the value of the <code>ChangingPassword</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onChangingPassword(ChangingPasswordValue changingPassword, DiscoverForChangingPassword discover);
    
    /**
     * This method is called when the <code>ActionValidation</code> context publishes a value.
     * 
     * <pre>
     * when provided ActionValidation
     * 		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm,
     * 		   SendMessage on Messenger,
     *     	   SendCriticalNotification on Notifier;
     * </pre>
     * 
     * @param actionValidation the value of the <code>ActionValidation</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onActionValidation(ActionValidationValue actionValidation, DiscoverForActionValidation discover);
    
    // End of interaction contract implementation
    
    // Discover object for ChangingPassword
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided ChangingPassword
     * 	do ScheduleTimer on Timer, On on Light;
     * </code>
     */
    protected final class DiscoverForChangingPassword {
        private final TimerDiscovererForChangingPassword timerDiscoverer = new TimerDiscovererForChangingPassword(AbstractChangePassword.this);
        private final LightDiscovererForChangingPassword lightDiscoverer = new LightDiscovererForChangingPassword(AbstractChangePassword.this);
        
        /**
         * @return a {@link TimerDiscovererForChangingPassword} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForChangingPassword timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link LightDiscovererForChangingPassword} object to discover <code>Light</code> devices
         */
        public LightDiscovererForChangingPassword lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerDiscovererForChangingPassword {
        private Service serviceParent;
        
        private TimerDiscovererForChangingPassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForChangingPassword instantiateComposite() {
            return new TimerCompositeForChangingPassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForChangingPassword} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForChangingPassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForChangingPassword} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForChangingPassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForChangingPassword} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForChangingPassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerCompositeForChangingPassword extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForChangingPassword> {
        private TimerCompositeForChangingPassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForChangingPassword instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForChangingPassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForChangingPassword}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForChangingPassword andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>schedule(id as String, delayMs as Integer)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         */
        public void schedule(java.lang.String id,
                java.lang.Integer delayMs) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForChangingPassword proxy : proxies) {
                proxy.schedule(id, delayMs);
            }
        }
        
        /**
         * Executes the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param periodMs the <code>periodMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         */
        public void periodicSchedule(java.lang.String id,
                java.lang.Integer delayMs,
                java.lang.Integer periodMs) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForChangingPassword proxy : proxies) {
                proxy.periodicSchedule(id, delayMs, periodMs);
            }
        }
        
        /**
         * Executes the <code>cancel(id as String)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>cancel(id as String)</code> method.
         */
        public void cancel(java.lang.String id) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForChangingPassword proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerProxyForChangingPassword extends Proxy {
        private TimerProxyForChangingPassword(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>schedule(id as String, delayMs as Integer)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         */
        public void schedule(java.lang.String id,
                java.lang.Integer delayMs) throws InvocationException {
            callOrder("schedule", id, delayMs);
        }
        
        /**
         * Executes the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param periodMs the <code>periodMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         */
        public void periodicSchedule(java.lang.String id,
                java.lang.Integer delayMs,
                java.lang.Integer periodMs) throws InvocationException {
            callOrder("periodicSchedule", id, delayMs, periodMs);
        }
        
        /**
         * Executes the <code>cancel(id as String)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>cancel(id as String)</code> method.
         */
        public void cancel(java.lang.String id) throws InvocationException {
            callOrder("cancel", id);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForChangingPassword {
        private Service serviceParent;
        
        private LightDiscovererForChangingPassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForChangingPassword instantiateComposite() {
            return new LightCompositeForChangingPassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForChangingPassword} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForChangingPassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForChangingPassword} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForChangingPassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForChangingPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForChangingPassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForChangingPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForChangingPassword whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForChangingPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForChangingPassword whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForChangingPassword extends fr.inria.diagen.core.service.composite.Composite<LightProxyForChangingPassword> {
        private LightCompositeForChangingPassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForChangingPassword instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForChangingPassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForChangingPassword}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForChangingPassword andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForChangingPassword}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForChangingPassword andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForChangingPassword}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForChangingPassword andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForChangingPassword proxy : proxies) {
                proxy.on();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForChangingPassword extends Proxy {
        private LightProxyForChangingPassword(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>on()</code> action's method on this device.
         */
        public void on() throws InvocationException {
            callOrder("on");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
    // End of discover object for ChangingPassword
    
    // Discover object for ActionValidation
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided ActionValidation
     * 		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm,
     * 		   SendMessage on Messenger,
     *     	   SendCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForActionValidation {
        private final TimerDiscovererForActionValidation timerDiscoverer = new TimerDiscovererForActionValidation(AbstractChangePassword.this);
        private final LightDiscovererForActionValidation lightDiscoverer = new LightDiscovererForActionValidation(AbstractChangePassword.this);
        private final AlarmDiscovererForActionValidation alarmDiscoverer = new AlarmDiscovererForActionValidation(AbstractChangePassword.this);
        private final MessengerDiscovererForActionValidation messengerDiscoverer = new MessengerDiscovererForActionValidation(AbstractChangePassword.this);
        private final NotifierDiscovererForActionValidation notifierDiscoverer = new NotifierDiscovererForActionValidation(AbstractChangePassword.this);
        
        /**
         * @return a {@link TimerDiscovererForActionValidation} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForActionValidation timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link LightDiscovererForActionValidation} object to discover <code>Light</code> devices
         */
        public LightDiscovererForActionValidation lights() {
            return lightDiscoverer;
        }
        
        /**
         * @return a {@link AlarmDiscovererForActionValidation} object to discover <code>Alarm</code> devices
         */
        public AlarmDiscovererForActionValidation alarms() {
            return alarmDiscoverer;
        }
        
        /**
         * @return a {@link MessengerDiscovererForActionValidation} object to discover <code>Messenger</code> devices
         */
        public MessengerDiscovererForActionValidation messengers() {
            return messengerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForActionValidation} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForActionValidation notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerDiscovererForActionValidation {
        private Service serviceParent;
        
        private TimerDiscovererForActionValidation(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForActionValidation instantiateComposite() {
            return new TimerCompositeForActionValidation(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForActionValidation} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForActionValidation all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForActionValidation} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForActionValidation anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForActionValidation} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForActionValidation whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerCompositeForActionValidation extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForActionValidation> {
        private TimerCompositeForActionValidation(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForActionValidation instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForActionValidation(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForActionValidation}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForActionValidation andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>schedule(id as String, delayMs as Integer)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         */
        public void schedule(java.lang.String id,
                java.lang.Integer delayMs) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForActionValidation proxy : proxies) {
                proxy.schedule(id, delayMs);
            }
        }
        
        /**
         * Executes the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param periodMs the <code>periodMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         */
        public void periodicSchedule(java.lang.String id,
                java.lang.Integer delayMs,
                java.lang.Integer periodMs) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForActionValidation proxy : proxies) {
                proxy.periodicSchedule(id, delayMs, periodMs);
            }
        }
        
        /**
         * Executes the <code>cancel(id as String)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>cancel(id as String)</code> method.
         */
        public void cancel(java.lang.String id) throws InvocationException {
            launchDiscovering();
            for (TimerProxyForActionValidation proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Timer
    ------
    
    <pre>
    device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
    </pre>
     */
    protected final static class TimerProxyForActionValidation extends Proxy {
        private TimerProxyForActionValidation(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>schedule(id as String, delayMs as Integer)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>schedule(id as String, delayMs as Integer)</code> method.
         */
        public void schedule(java.lang.String id,
                java.lang.Integer delayMs) throws InvocationException {
            callOrder("schedule", id, delayMs);
        }
        
        /**
         * Executes the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param delayMs the <code>delayMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         * @param periodMs the <code>periodMs</code> parameter of the <code>periodicSchedule(id as String, delayMs as Integer, periodMs as Integer)</code> method.
         */
        public void periodicSchedule(java.lang.String id,
                java.lang.Integer delayMs,
                java.lang.Integer periodMs) throws InvocationException {
            callOrder("periodicSchedule", id, delayMs, periodMs);
        }
        
        /**
         * Executes the <code>cancel(id as String)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>cancel(id as String)</code> method.
         */
        public void cancel(java.lang.String id) throws InvocationException {
            callOrder("cancel", id);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForActionValidation {
        private Service serviceParent;
        
        private LightDiscovererForActionValidation(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForActionValidation instantiateComposite() {
            return new LightCompositeForActionValidation(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForActionValidation} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForActionValidation all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForActionValidation} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForActionValidation anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForActionValidation} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForActionValidation whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForActionValidation} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForActionValidation whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForActionValidation} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForActionValidation whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForActionValidation extends fr.inria.diagen.core.service.composite.Composite<LightProxyForActionValidation> {
        private LightCompositeForActionValidation(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForActionValidation instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForActionValidation(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForActionValidation}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForActionValidation andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForActionValidation}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForActionValidation andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForActionValidation}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForActionValidation andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForActionValidation proxy : proxies) {
                proxy.on();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForActionValidation extends Proxy {
        private LightProxyForActionValidation(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>on()</code> action's method on this device.
         */
        public void on() throws InvocationException {
            callOrder("on");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
    
    /**
     * Discover object that will exposes the <code>Alarm</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    Device
    
    <pre>
    device Alarm extends Service{
    	action DesactiverAlarm;
    }
    </pre>
     */
    protected final static class AlarmDiscovererForActionValidation {
        private Service serviceParent;
        
        private AlarmDiscovererForActionValidation(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private AlarmCompositeForActionValidation instantiateComposite() {
            return new AlarmCompositeForActionValidation(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Alarm</code> devices
         * 
         * @return a {@link AlarmCompositeForActionValidation} object composed of all discoverable <code>Alarm</code>
         */
        public AlarmCompositeForActionValidation all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Alarm</code> devices
         * 
         * @return a {@link AlarmProxyForActionValidation} object pointing to a random discoverable <code>Alarm</code> device
         */
        public AlarmProxyForActionValidation anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Alarm</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link AlarmCompositeForActionValidation} object composed of all matching <code>Alarm</code> devices
         */
        public AlarmCompositeForActionValidation whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Alarm</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    Device
    
    <pre>
    device Alarm extends Service{
    	action DesactiverAlarm;
    }
    </pre>
     */
    protected final static class AlarmCompositeForActionValidation extends fr.inria.diagen.core.service.composite.Composite<AlarmProxyForActionValidation> {
        private AlarmCompositeForActionValidation(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Alarm/");
        }
        
        @Override
        protected AlarmProxyForActionValidation instantiateProxy(RemoteServiceInfo rsi) {
            return new AlarmProxyForActionValidation(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link AlarmCompositeForActionValidation}, filtered using the attribute <code>id</code>.
         */
        public AlarmCompositeForActionValidation andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (AlarmProxyForActionValidation proxy : proxies) {
                proxy.on();
            }
        }
    }
    
    /**
     * A proxy to one <code>Alarm</code> device to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    <p>
    Device
    
    <pre>
    device Alarm extends Service{
    	action DesactiverAlarm;
    }
    </pre>
     */
    protected final static class AlarmProxyForActionValidation extends Proxy {
        private AlarmProxyForActionValidation(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>on()</code> action's method on this device.
         */
        public void on() throws InvocationException {
            callOrder("on");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    
    /**
     * Discover object that will exposes the <code>Messenger</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerDiscovererForActionValidation {
        private Service serviceParent;
        
        private MessengerDiscovererForActionValidation(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private MessengerCompositeForActionValidation instantiateComposite() {
            return new MessengerCompositeForActionValidation(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerCompositeForActionValidation} object composed of all discoverable <code>Messenger</code>
         */
        public MessengerCompositeForActionValidation all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerProxyForActionValidation} object pointing to a random discoverable <code>Messenger</code> device
         */
        public MessengerProxyForActionValidation anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link MessengerCompositeForActionValidation} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForActionValidation whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Messenger</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerCompositeForActionValidation extends fr.inria.diagen.core.service.composite.Composite<MessengerProxyForActionValidation> {
        private MessengerCompositeForActionValidation(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/CommunicationService/Messenger/");
        }
        
        @Override
        protected MessengerProxyForActionValidation instantiateProxy(RemoteServiceInfo rsi) {
            return new MessengerProxyForActionValidation(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link MessengerCompositeForActionValidation}, filtered using the attribute <code>id</code>.
         */
        public MessengerCompositeForActionValidation andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>sendMessage(message as Message)</code> action's method on all devices of this composite.
         * 
         * @param message the <code>message</code> parameter of the <code>sendMessage(message as Message)</code> method.
         */
        public void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message message) throws InvocationException {
            launchDiscovering();
            for (MessengerProxyForActionValidation proxy : proxies) {
                proxy.sendMessage(message);
            }
        }
    }
    
    /**
     * A proxy to one <code>Messenger</code> device to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerProxyForActionValidation extends Proxy {
        private MessengerProxyForActionValidation(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>sendMessage(message as Message)</code> action's method on this device.
         * 
         * @param message the <code>message</code> parameter of the <code>sendMessage(message as Message)</code> method.
         */
        public void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message message) throws InvocationException {
            callOrder("sendMessage", message);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    
    /**
     * Discover object that will exposes the <code>Notifier</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
    </pre>
     */
    protected final static class NotifierDiscovererForActionValidation {
        private Service serviceParent;
        
        private NotifierDiscovererForActionValidation(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForActionValidation instantiateComposite() {
            return new NotifierCompositeForActionValidation(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForActionValidation} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForActionValidation all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForActionValidation} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForActionValidation anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForActionValidation} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForActionValidation whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
    </pre>
     */
    protected final static class NotifierCompositeForActionValidation extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForActionValidation> {
        private NotifierCompositeForActionValidation(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForActionValidation instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForActionValidation(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForActionValidation}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForActionValidation andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>sendCriticalNotification(notification as CriticalNotification)</code> action's method on all devices of this composite.
         * 
         * @param notification the <code>notification</code> parameter of the <code>sendCriticalNotification(notification as CriticalNotification)</code> method.
         */
        public void sendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForActionValidation proxy : proxies) {
                proxy.sendCriticalNotification(notification);
            }
        }
        
        /**
         * Executes the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> action's method on all devices of this composite.
         * 
         * @param notification the <code>notification</code> parameter of the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> method.
         * @param displayDate the <code>displayDate</code> parameter of the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> method.
         */
        public void registerCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForActionValidation proxy : proxies) {
                proxy.registerCriticalNotification(notification, displayDate);
            }
        }
        
        /**
         * Executes the <code>cancelCriticalNotification(id as String)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>cancelCriticalNotification(id as String)</code> method.
         */
        public void cancelCriticalNotification(java.lang.String id) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForActionValidation proxy : proxies) {
                proxy.cancelCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided ActionValidation</code> interaction contract.
    
    <pre>
    device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
    </pre>
     */
    protected final static class NotifierProxyForActionValidation extends Proxy {
        private NotifierProxyForActionValidation(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>sendCriticalNotification(notification as CriticalNotification)</code> action's method on this device.
         * 
         * @param notification the <code>notification</code> parameter of the <code>sendCriticalNotification(notification as CriticalNotification)</code> method.
         */
        public void sendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) throws InvocationException {
            callOrder("sendCriticalNotification", notification);
        }
        
        /**
         * Executes the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> action's method on this device.
         * 
         * @param notification the <code>notification</code> parameter of the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> method.
         * @param displayDate the <code>displayDate</code> parameter of the <code>registerCriticalNotification(notification as CriticalNotification, displayDate as Date)</code> method.
         */
        public void registerCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) throws InvocationException {
            callOrder("registerCriticalNotification", notification, displayDate);
        }
        
        /**
         * Executes the <code>cancelCriticalNotification(id as String)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>cancelCriticalNotification(id as String)</code> method.
         */
        public void cancelCriticalNotification(java.lang.String id) throws InvocationException {
            callOrder("cancelCriticalNotification", id);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for ActionValidation
}
