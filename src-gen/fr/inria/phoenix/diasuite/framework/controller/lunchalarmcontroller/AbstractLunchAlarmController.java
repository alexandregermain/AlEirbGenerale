package fr.inria.phoenix.diasuite.framework.controller.lunchalarmcontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.LunchAlarmContextValue;

/**
 * <pre>
controller LunchAlarmController{
 *   when provided LunchAlarmContext
 *     do ScheduleTimer on Timer,
 *        SendMessage on Messenger,
 * 	   SendCriticalNotification on Notifier;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractLunchAlarmController extends Service {
    
    public AbstractLunchAlarmController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/LunchAlarmController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("lunchAlarmContext", "/Context/LunchAlarmContext/"); // subscribe to LunchAlarmContext context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("lunchAlarmContext") && source.isCompatible("/Context/LunchAlarmContext/")) {
            LunchAlarmContextValue lunchAlarmContextValue = new LunchAlarmContextValue((java.lang.Boolean) value);
            
            onLunchAlarmContext(lunchAlarmContextValue, new DiscoverForLunchAlarmContext());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>LunchAlarmContext</code> context publishes a value.
     * 
     * <pre>
     * when provided LunchAlarmContext
     *     do ScheduleTimer on Timer,
     *        SendMessage on Messenger,
     * 	   SendCriticalNotification on Notifier;
     * </pre>
     * 
     * @param lunchAlarmContext the value of the <code>LunchAlarmContext</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onLunchAlarmContext(LunchAlarmContextValue lunchAlarmContext, DiscoverForLunchAlarmContext discover);
    
    // End of interaction contract implementation
    
    // Discover object for LunchAlarmContext
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided LunchAlarmContext
     *     do ScheduleTimer on Timer,
     *        SendMessage on Messenger,
     * 	   SendCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForLunchAlarmContext {
        private final TimerDiscovererForLunchAlarmContext timerDiscoverer = new TimerDiscovererForLunchAlarmContext(AbstractLunchAlarmController.this);
        private final MessengerDiscovererForLunchAlarmContext messengerDiscoverer = new MessengerDiscovererForLunchAlarmContext(AbstractLunchAlarmController.this);
        private final NotifierDiscovererForLunchAlarmContext notifierDiscoverer = new NotifierDiscovererForLunchAlarmContext(AbstractLunchAlarmController.this);
        
        /**
         * @return a {@link TimerDiscovererForLunchAlarmContext} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForLunchAlarmContext timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link MessengerDiscovererForLunchAlarmContext} object to discover <code>Messenger</code> devices
         */
        public MessengerDiscovererForLunchAlarmContext messengers() {
            return messengerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForLunchAlarmContext} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForLunchAlarmContext notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
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
    protected final static class TimerDiscovererForLunchAlarmContext {
        private Service serviceParent;
        
        private TimerDiscovererForLunchAlarmContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForLunchAlarmContext instantiateComposite() {
            return new TimerCompositeForLunchAlarmContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForLunchAlarmContext} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForLunchAlarmContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForLunchAlarmContext} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForLunchAlarmContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForLunchAlarmContext} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForLunchAlarmContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
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
    protected final static class TimerCompositeForLunchAlarmContext extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForLunchAlarmContext> {
        private TimerCompositeForLunchAlarmContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForLunchAlarmContext instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForLunchAlarmContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForLunchAlarmContext}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForLunchAlarmContext andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForLunchAlarmContext proxy : proxies) {
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
            for (TimerProxyForLunchAlarmContext proxy : proxies) {
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
            for (TimerProxyForLunchAlarmContext proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
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
    protected final static class TimerProxyForLunchAlarmContext extends Proxy {
        private TimerProxyForLunchAlarmContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * Discover object that will exposes the <code>Messenger</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerDiscovererForLunchAlarmContext {
        private Service serviceParent;
        
        private MessengerDiscovererForLunchAlarmContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private MessengerCompositeForLunchAlarmContext instantiateComposite() {
            return new MessengerCompositeForLunchAlarmContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerCompositeForLunchAlarmContext} object composed of all discoverable <code>Messenger</code>
         */
        public MessengerCompositeForLunchAlarmContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerProxyForLunchAlarmContext} object pointing to a random discoverable <code>Messenger</code> device
         */
        public MessengerProxyForLunchAlarmContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link MessengerCompositeForLunchAlarmContext} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForLunchAlarmContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Messenger</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerCompositeForLunchAlarmContext extends fr.inria.diagen.core.service.composite.Composite<MessengerProxyForLunchAlarmContext> {
        private MessengerCompositeForLunchAlarmContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/CommunicationService/Messenger/");
        }
        
        @Override
        protected MessengerProxyForLunchAlarmContext instantiateProxy(RemoteServiceInfo rsi) {
            return new MessengerProxyForLunchAlarmContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link MessengerCompositeForLunchAlarmContext}, filtered using the attribute <code>id</code>.
         */
        public MessengerCompositeForLunchAlarmContext andId(java.lang.String id) throws CompositeException {
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
            for (MessengerProxyForLunchAlarmContext proxy : proxies) {
                proxy.sendMessage(message);
            }
        }
    }
    
    /**
     * A proxy to one <code>Messenger</code> device to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerProxyForLunchAlarmContext extends Proxy {
        private MessengerProxyForLunchAlarmContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
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
    protected final static class NotifierDiscovererForLunchAlarmContext {
        private Service serviceParent;
        
        private NotifierDiscovererForLunchAlarmContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForLunchAlarmContext instantiateComposite() {
            return new NotifierCompositeForLunchAlarmContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForLunchAlarmContext} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForLunchAlarmContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForLunchAlarmContext} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForLunchAlarmContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForLunchAlarmContext} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForLunchAlarmContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
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
    protected final static class NotifierCompositeForLunchAlarmContext extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForLunchAlarmContext> {
        private NotifierCompositeForLunchAlarmContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForLunchAlarmContext instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForLunchAlarmContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForLunchAlarmContext}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForLunchAlarmContext andId(java.lang.String id) throws CompositeException {
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
            for (NotifierProxyForLunchAlarmContext proxy : proxies) {
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
            for (NotifierProxyForLunchAlarmContext proxy : proxies) {
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
            for (NotifierProxyForLunchAlarmContext proxy : proxies) {
                proxy.cancelCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    
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
    protected final static class NotifierProxyForLunchAlarmContext extends Proxy {
        private NotifierProxyForLunchAlarmContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for LunchAlarmContext
}
