package fr.inria.phoenix.diasuite.framework.controller.alarmactivitedcontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.insidecontext.InsideContextValue;

/**
 * ------------------------------------------------------
 * CONTROLLER
 * ------------------------------------------------------
 * 
 * <pre>
 * controller AlarmActivitedController {
 *   when provided InsideContext
 *     do ScheduleTimer on Timer,
 *        SendNonCriticalNotification on Notifier;  
 * }
 * </pre>
 */
@SuppressWarnings("all")
public abstract class AbstractAlarmActivitedController extends Service {
    
    public AbstractAlarmActivitedController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/AlarmActivitedController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("insideContext", "/Context/InsideContext/"); // subscribe to InsideContext context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("insideContext") && source.isCompatible("/Context/InsideContext/")) {
            InsideContextValue insideContextValue = new InsideContextValue((java.lang.Boolean) value);
            
            onInsideContext(insideContextValue, new DiscoverForInsideContext());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>InsideContext</code> context publishes a value.
     * 
     * <pre>
     * when provided InsideContext
     *     do ScheduleTimer on Timer,
     *        SendNonCriticalNotification on Notifier;
     * </pre>
     * 
     * @param insideContext the value of the <code>InsideContext</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onInsideContext(InsideContextValue insideContext, DiscoverForInsideContext discover);
    
    // End of interaction contract implementation
    
    // Discover object for InsideContext
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided InsideContext
     *     do ScheduleTimer on Timer,
     *        SendNonCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForInsideContext {
        private final TimerDiscovererForInsideContext timerDiscoverer = new TimerDiscovererForInsideContext(AbstractAlarmActivitedController.this);
        private final NotifierDiscovererForInsideContext notifierDiscoverer = new NotifierDiscovererForInsideContext(AbstractAlarmActivitedController.this);
        
        /**
         * @return a {@link TimerDiscovererForInsideContext} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForInsideContext timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForInsideContext} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForInsideContext notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class TimerDiscovererForInsideContext {
        private Service serviceParent;
        
        private TimerDiscovererForInsideContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForInsideContext instantiateComposite() {
            return new TimerCompositeForInsideContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForInsideContext} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForInsideContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForInsideContext} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForInsideContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForInsideContext} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForInsideContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class TimerCompositeForInsideContext extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForInsideContext> {
        private TimerCompositeForInsideContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForInsideContext instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForInsideContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForInsideContext}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForInsideContext andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForInsideContext proxy : proxies) {
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
            for (TimerProxyForInsideContext proxy : proxies) {
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
            for (TimerProxyForInsideContext proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class TimerProxyForInsideContext extends Proxy {
        private TimerProxyForInsideContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class NotifierDiscovererForInsideContext {
        private Service serviceParent;
        
        private NotifierDiscovererForInsideContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForInsideContext instantiateComposite() {
            return new NotifierCompositeForInsideContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForInsideContext} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForInsideContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForInsideContext} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForInsideContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForInsideContext} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForInsideContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class NotifierCompositeForInsideContext extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForInsideContext> {
        private NotifierCompositeForInsideContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForInsideContext instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForInsideContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForInsideContext}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForInsideContext andId(java.lang.String id) throws CompositeException {
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
            for (NotifierProxyForInsideContext proxy : proxies) {
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
            for (NotifierProxyForInsideContext proxy : proxies) {
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
            for (NotifierProxyForInsideContext proxy : proxies) {
                proxy.cancelNonCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
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
    protected final static class NotifierProxyForInsideContext extends Proxy {
        private NotifierProxyForInsideContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for InsideContext
}
