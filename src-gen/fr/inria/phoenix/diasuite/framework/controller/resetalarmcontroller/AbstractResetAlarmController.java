package fr.inria.phoenix.diasuite.framework.controller.resetalarmcontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.timeover.TimeOverValue;

/**
 * <pre>
controller ResetAlarmController{
 *   when provided TimeOver
 *     do SendNonCriticalNotification on Notifier,
 *        ScheduleTimer on Timer;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractResetAlarmController extends Service {
    
    public AbstractResetAlarmController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/ResetAlarmController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("timeOver", "/Context/TimeOver/"); // subscribe to TimeOver context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("timeOver") && source.isCompatible("/Context/TimeOver/")) {
            TimeOverValue timeOverValue = new TimeOverValue((java.lang.Boolean) value);
            
            onTimeOver(timeOverValue, new DiscoverForTimeOver());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>TimeOver</code> context publishes a value.
     * 
     * <pre>
     * when provided TimeOver
     *     do SendNonCriticalNotification on Notifier,
     *        ScheduleTimer on Timer;
     * </pre>
     * 
     * @param timeOver the value of the <code>TimeOver</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onTimeOver(TimeOverValue timeOver, DiscoverForTimeOver discover);
    
    // End of interaction contract implementation
    
    // Discover object for TimeOver
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided TimeOver
     *     do SendNonCriticalNotification on Notifier,
     *        ScheduleTimer on Timer;
     * </code>
     */
    protected final class DiscoverForTimeOver {
        private final NotifierDiscovererForTimeOver notifierDiscoverer = new NotifierDiscovererForTimeOver(AbstractResetAlarmController.this);
        private final TimerDiscovererForTimeOver timerDiscoverer = new TimerDiscovererForTimeOver(AbstractResetAlarmController.this);
        
        /**
         * @return a {@link NotifierDiscovererForTimeOver} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForTimeOver notifiers() {
            return notifierDiscoverer;
        }
        
        /**
         * @return a {@link TimerDiscovererForTimeOver} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForTimeOver timers() {
            return timerDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Notifier</code> devices to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
    
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
    protected final static class NotifierDiscovererForTimeOver {
        private Service serviceParent;
        
        private NotifierDiscovererForTimeOver(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForTimeOver instantiateComposite() {
            return new NotifierCompositeForTimeOver(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForTimeOver} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForTimeOver all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForTimeOver} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForTimeOver anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForTimeOver} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForTimeOver whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
    
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
    protected final static class NotifierCompositeForTimeOver extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForTimeOver> {
        private NotifierCompositeForTimeOver(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForTimeOver instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForTimeOver(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForTimeOver}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForTimeOver andId(java.lang.String id) throws CompositeException {
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
            for (NotifierProxyForTimeOver proxy : proxies) {
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
            for (NotifierProxyForTimeOver proxy : proxies) {
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
            for (NotifierProxyForTimeOver proxy : proxies) {
                proxy.cancelNonCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
    
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
    protected final static class NotifierProxyForTimeOver extends Proxy {
        private NotifierProxyForTimeOver(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
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
    protected final static class TimerDiscovererForTimeOver {
        private Service serviceParent;
        
        private TimerDiscovererForTimeOver(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForTimeOver instantiateComposite() {
            return new TimerCompositeForTimeOver(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForTimeOver} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForTimeOver all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForTimeOver} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForTimeOver anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForTimeOver} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForTimeOver whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
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
    protected final static class TimerCompositeForTimeOver extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForTimeOver> {
        private TimerCompositeForTimeOver(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForTimeOver instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForTimeOver(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForTimeOver}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForTimeOver andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForTimeOver proxy : proxies) {
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
            for (TimerProxyForTimeOver proxy : proxies) {
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
            for (TimerProxyForTimeOver proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided TimeOver</code> interaction contract.
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
    protected final static class TimerProxyForTimeOver extends Proxy {
        private TimerProxyForTimeOver(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for TimeOver
}
