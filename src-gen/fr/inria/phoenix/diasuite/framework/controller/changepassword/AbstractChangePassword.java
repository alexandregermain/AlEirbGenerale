package fr.inria.phoenix.diasuite.framework.controller.changepassword;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.actionvalidation.ActionValidationValue;
import fr.inria.phoenix.diasuite.framework.context.password.PasswordValue;

/**
 * <pre>
controller ChangePassword {
	when provided Password
		do ScheduleTimer on Timer, On on Light;
	when provided ActionValidation
		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm;
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
        subscribeValue("password", "/Context/Password/"); // subscribe to Password context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("actionValidation") && source.isCompatible("/Context/ActionValidation/")) {
            ActionValidationValue actionValidationValue = new ActionValidationValue((java.lang.Boolean) value);
            
            onActionValidation(actionValidationValue, new DiscoverForActionValidation());
        }
        if (eventName.equals("password") && source.isCompatible("/Context/Password/")) {
            PasswordValue passwordValue = new PasswordValue((java.lang.Boolean) value);
            
            onPassword(passwordValue, new DiscoverForPassword());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>Password</code> context publishes a value.
     * 
     * <pre>
     * when provided Password
     * 		do ScheduleTimer on Timer, On on Light;
     * </pre>
     * 
     * @param password the value of the <code>Password</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onPassword(PasswordValue password, DiscoverForPassword discover);
    
    /**
     * This method is called when the <code>ActionValidation</code> context publishes a value.
     * 
     * <pre>
     * when provided ActionValidation
     * 		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm;
     * </pre>
     * 
     * @param actionValidation the value of the <code>ActionValidation</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onActionValidation(ActionValidationValue actionValidation, DiscoverForActionValidation discover);
    
    // End of interaction contract implementation
    
    // Discover object for Password
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided Password
     * 		do ScheduleTimer on Timer, On on Light;
     * </code>
     */
    protected final class DiscoverForPassword {
        private final TimerDiscovererForPassword timerDiscoverer = new TimerDiscovererForPassword(AbstractChangePassword.this);
        private final LightDiscovererForPassword lightDiscoverer = new LightDiscovererForPassword(AbstractChangePassword.this);
        
        /**
         * @return a {@link TimerDiscovererForPassword} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForPassword timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link LightDiscovererForPassword} object to discover <code>Light</code> devices
         */
        public LightDiscovererForPassword lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided Password</code> interaction contract.
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
    protected final static class TimerDiscovererForPassword {
        private Service serviceParent;
        
        private TimerDiscovererForPassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForPassword instantiateComposite() {
            return new TimerCompositeForPassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForPassword} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForPassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForPassword} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForPassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForPassword} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForPassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided Password</code> interaction contract.
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
    protected final static class TimerCompositeForPassword extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForPassword> {
        private TimerCompositeForPassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForPassword instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForPassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForPassword}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForPassword andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForPassword proxy : proxies) {
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
            for (TimerProxyForPassword proxy : proxies) {
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
            for (TimerProxyForPassword proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided Password</code> interaction contract.
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
    protected final static class TimerProxyForPassword extends Proxy {
        private TimerProxyForPassword(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * <code>when provided Password</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForPassword {
        private Service serviceParent;
        
        private LightDiscovererForPassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForPassword instantiateComposite() {
            return new LightCompositeForPassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForPassword} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForPassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForPassword} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForPassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPassword whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForPassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPassword whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided Password</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForPassword extends fr.inria.diagen.core.service.composite.Composite<LightProxyForPassword> {
        private LightCompositeForPassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForPassword instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForPassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForPassword}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForPassword andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForPassword}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForPassword andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForPassword}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForPassword andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForPassword proxy : proxies) {
                proxy.on();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided Password</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForPassword extends Proxy {
        private LightProxyForPassword(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for Password
    
    // Discover object for ActionValidation
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided ActionValidation
     * 		do ScheduleTimer on Timer, On on Light, DesactiverAlarm on Alarm;
     * </code>
     */
    protected final class DiscoverForActionValidation {
        private final TimerDiscovererForActionValidation timerDiscoverer = new TimerDiscovererForActionValidation(AbstractChangePassword.this);
        private final LightDiscovererForActionValidation lightDiscoverer = new LightDiscovererForActionValidation(AbstractChangePassword.this);
        private final AlarmDiscovererForActionValidation alarmDiscoverer = new AlarmDiscovererForActionValidation(AbstractChangePassword.this);
        
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
    // End of discover object for ActionValidation
}
