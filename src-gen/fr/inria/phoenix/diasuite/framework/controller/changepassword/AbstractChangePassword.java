package fr.inria.phoenix.diasuite.framework.controller.changepassword;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.changingpassword.ChangingPasswordValue;

/**
 * <pre>
 * controller ChangePassword {
 * 	when provided ChangingPassword
 * 	do ScheduleTimer on Timer, 
 * 	   SendNonCriticalNotification on Notifier;
 * }
 * </pre>
 */
@SuppressWarnings("all")
public abstract class AbstractChangePassword extends Service {
    
    public AbstractChangePassword(ServiceConfiguration serviceConfiguration) {
        super("/Controller/ChangePassword/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("changingPassword", "/Context/ChangingPassword/"); // subscribe to ChangingPassword context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("changingPassword") && source.isCompatible("/Context/ChangingPassword/")) {
            ChangingPasswordValue changingPasswordValue = new ChangingPasswordValue((java.lang.String) value);
            
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
     * 	do ScheduleTimer on Timer, 
     * 	   SendNonCriticalNotification on Notifier;
     * </pre>
     * 
     * @param changingPassword the value of the <code>ChangingPassword</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onChangingPassword(ChangingPasswordValue changingPassword, DiscoverForChangingPassword discover);
    
    // End of interaction contract implementation
    
    // Discover object for ChangingPassword
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided ChangingPassword
     * 	do ScheduleTimer on Timer, 
     * 	   SendNonCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForChangingPassword {
        private final TimerDiscovererForChangingPassword timerDiscoverer = new TimerDiscovererForChangingPassword(AbstractChangePassword.this);
        private final NotifierDiscovererForChangingPassword notifierDiscoverer = new NotifierDiscovererForChangingPassword(AbstractChangePassword.this);
        
        /**
         * @return a {@link TimerDiscovererForChangingPassword} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForChangingPassword timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForChangingPassword} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForChangingPassword notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
     * <p>
     * ------
     * Timer
     * ------
     * 
     * <pre>
     * device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
     * </pre>
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
     * <p>
     * ------
     * Timer
     * ------
     * 
     * <pre>
     * device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
     * </pre>
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
     * <p>
     * ------
     * Timer
     * ------
     * 
     * <pre>
     * device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
     * </pre>
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
     * Discover object that will exposes the <code>Notifier</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
     * 
     * <pre>
     * device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
     * </pre>
     */
    protected final static class NotifierDiscovererForChangingPassword {
        private Service serviceParent;
        
        private NotifierDiscovererForChangingPassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForChangingPassword instantiateComposite() {
            return new NotifierCompositeForChangingPassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForChangingPassword} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForChangingPassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForChangingPassword} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForChangingPassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForChangingPassword} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForChangingPassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
     * 
     * <pre>
     * device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
     * </pre>
     */
    protected final static class NotifierCompositeForChangingPassword extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForChangingPassword> {
        private NotifierCompositeForChangingPassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForChangingPassword instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForChangingPassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForChangingPassword}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForChangingPassword andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>sendNonCriticalNotification(notification as NonCriticalNotification)</code> action's method on all devices of this composite.
         * 
         * @param notification the <code>notification</code> parameter of the <code>sendNonCriticalNotification(notification as NonCriticalNotification)</code> method.
         */
        public void sendNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForChangingPassword proxy : proxies) {
                proxy.sendNonCriticalNotification(notification);
            }
        }
        
        /**
         * Executes the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> action's method on all devices of this composite.
         * 
         * @param notification the <code>notification</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         * @param displayDate the <code>displayDate</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         * @param expirationDate the <code>expirationDate</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         */
        public void registerNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date expirationDate) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForChangingPassword proxy : proxies) {
                proxy.registerNonCriticalNotification(notification, displayDate, expirationDate);
            }
        }
        
        /**
         * Executes the <code>cancelNonCriticalNotification(id as String)</code> action's method on all devices of this composite.
         * 
         * @param id the <code>id</code> parameter of the <code>cancelNonCriticalNotification(id as String)</code> method.
         */
        public void cancelNonCriticalNotification(java.lang.String id) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForChangingPassword proxy : proxies) {
                proxy.cancelNonCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided ChangingPassword</code> interaction contract.
     * 
     * <pre>
     * device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
     * </pre>
     */
    protected final static class NotifierProxyForChangingPassword extends Proxy {
        private NotifierProxyForChangingPassword(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>sendNonCriticalNotification(notification as NonCriticalNotification)</code> action's method on this device.
         * 
         * @param notification the <code>notification</code> parameter of the <code>sendNonCriticalNotification(notification as NonCriticalNotification)</code> method.
         */
        public void sendNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) throws InvocationException {
            callOrder("sendNonCriticalNotification", notification);
        }
        
        /**
         * Executes the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> action's method on this device.
         * 
         * @param notification the <code>notification</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         * @param displayDate the <code>displayDate</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         * @param expirationDate the <code>expirationDate</code> parameter of the <code>registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date)</code> method.
         */
        public void registerNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date expirationDate) throws InvocationException {
            callOrder("registerNonCriticalNotification", notification, displayDate, expirationDate);
        }
        
        /**
         * Executes the <code>cancelNonCriticalNotification(id as String)</code> action's method on this device.
         * 
         * @param id the <code>id</code> parameter of the <code>cancelNonCriticalNotification(id as String)</code> method.
         */
        public void cancelNonCriticalNotification(java.lang.String id) throws InvocationException {
            callOrder("cancelNonCriticalNotification", id);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for ChangingPassword
}
