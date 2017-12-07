package fr.inria.phoenix.diasuite.framework.controller.handlenotifier;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.elapsedtime.ElapsedTimeValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;

/**
 * <pre>
controller HandleNotifier{
 *   when provided UpdatePassword
 *     do ScheduleTimer on Timer,
 * 	   SendNonCriticalNotification on Notifier;
 *   when provided ElapsedTime
 *     do ScheduleTimer on Timer,
 * 	   SendNonCriticalNotification on Notifier;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractHandleNotifier extends Service {
    
    public AbstractHandleNotifier(ServiceConfiguration serviceConfiguration) {
        super("/Controller/HandleNotifier/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("elapsedTime", "/Context/ElapsedTime/"); // subscribe to ElapsedTime context
        subscribeValue("updatePassword", "/Context/UpdatePassword/"); // subscribe to UpdatePassword context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("elapsedTime") && source.isCompatible("/Context/ElapsedTime/")) {
            ElapsedTimeValue elapsedTimeValue = new ElapsedTimeValue((fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer) value);
            
            onElapsedTime(elapsedTimeValue, new DiscoverForElapsedTime());
        }
        if (eventName.equals("updatePassword") && source.isCompatible("/Context/UpdatePassword/")) {
            UpdatePasswordValue updatePasswordValue = new UpdatePasswordValue((fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating) value);
            
            onUpdatePassword(updatePasswordValue, new DiscoverForUpdatePassword());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>UpdatePassword</code> context publishes a value.
     * 
     * <pre>
     * when provided UpdatePassword
     *     do ScheduleTimer on Timer,
     * 	   SendNonCriticalNotification on Notifier;
     * </pre>
     * 
     * @param updatePassword the value of the <code>UpdatePassword</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover);
    
    /**
     * This method is called when the <code>ElapsedTime</code> context publishes a value.
     * 
     * <pre>
     * when provided ElapsedTime
     *     do ScheduleTimer on Timer,
     * 	   SendNonCriticalNotification on Notifier;
     * </pre>
     * 
     * @param elapsedTime the value of the <code>ElapsedTime</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onElapsedTime(ElapsedTimeValue elapsedTime, DiscoverForElapsedTime discover);
    
    // End of interaction contract implementation
    
    // Discover object for UpdatePassword
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided UpdatePassword
     *     do ScheduleTimer on Timer,
     * 	   SendNonCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForUpdatePassword {
        private final TimerDiscovererForUpdatePassword timerDiscoverer = new TimerDiscovererForUpdatePassword(AbstractHandleNotifier.this);
        private final NotifierDiscovererForUpdatePassword notifierDiscoverer = new NotifierDiscovererForUpdatePassword(AbstractHandleNotifier.this);
        
        /**
         * @return a {@link TimerDiscovererForUpdatePassword} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForUpdatePassword timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForUpdatePassword} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForUpdatePassword notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
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
    protected final static class TimerDiscovererForUpdatePassword {
        private Service serviceParent;
        
        private TimerDiscovererForUpdatePassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForUpdatePassword instantiateComposite() {
            return new TimerCompositeForUpdatePassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForUpdatePassword} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForUpdatePassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForUpdatePassword} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForUpdatePassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForUpdatePassword} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForUpdatePassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
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
    protected final static class TimerCompositeForUpdatePassword extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForUpdatePassword> {
        private TimerCompositeForUpdatePassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForUpdatePassword instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForUpdatePassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForUpdatePassword}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForUpdatePassword andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForUpdatePassword proxy : proxies) {
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
            for (TimerProxyForUpdatePassword proxy : proxies) {
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
            for (TimerProxyForUpdatePassword proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
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
    protected final static class TimerProxyForUpdatePassword extends Proxy {
        private TimerProxyForUpdatePassword(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * <code>when provided UpdatePassword</code> interaction contract.
    
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
    protected final static class NotifierDiscovererForUpdatePassword {
        private Service serviceParent;
        
        private NotifierDiscovererForUpdatePassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForUpdatePassword instantiateComposite() {
            return new NotifierCompositeForUpdatePassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForUpdatePassword} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForUpdatePassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForUpdatePassword} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForUpdatePassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForUpdatePassword} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForUpdatePassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    
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
    protected final static class NotifierCompositeForUpdatePassword extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForUpdatePassword> {
        private NotifierCompositeForUpdatePassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForUpdatePassword instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForUpdatePassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForUpdatePassword}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForUpdatePassword andId(java.lang.String id) throws CompositeException {
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
            for (NotifierProxyForUpdatePassword proxy : proxies) {
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
            for (NotifierProxyForUpdatePassword proxy : proxies) {
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
            for (NotifierProxyForUpdatePassword proxy : proxies) {
                proxy.cancelNonCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    
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
    protected final static class NotifierProxyForUpdatePassword extends Proxy {
        private NotifierProxyForUpdatePassword(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for UpdatePassword
    
    // Discover object for ElapsedTime
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided ElapsedTime
     *     do ScheduleTimer on Timer,
     * 	   SendNonCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForElapsedTime {
        private final TimerDiscovererForElapsedTime timerDiscoverer = new TimerDiscovererForElapsedTime(AbstractHandleNotifier.this);
        private final NotifierDiscovererForElapsedTime notifierDiscoverer = new NotifierDiscovererForElapsedTime(AbstractHandleNotifier.this);
        
        /**
         * @return a {@link TimerDiscovererForElapsedTime} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForElapsedTime timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link NotifierDiscovererForElapsedTime} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForElapsedTime notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to execute action on for the
     * <code>when provided ElapsedTime</code> interaction contract.
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
    protected final static class TimerDiscovererForElapsedTime {
        private Service serviceParent;
        
        private TimerDiscovererForElapsedTime(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForElapsedTime instantiateComposite() {
            return new TimerCompositeForElapsedTime(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForElapsedTime} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForElapsedTime all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForElapsedTime} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForElapsedTime anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForElapsedTime} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForElapsedTime whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to execute action on for the
     * <code>when provided ElapsedTime</code> interaction contract.
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
    protected final static class TimerCompositeForElapsedTime extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForElapsedTime> {
        private TimerCompositeForElapsedTime(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForElapsedTime instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForElapsedTime(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForElapsedTime}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForElapsedTime andId(java.lang.String id) throws CompositeException {
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
            for (TimerProxyForElapsedTime proxy : proxies) {
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
            for (TimerProxyForElapsedTime proxy : proxies) {
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
            for (TimerProxyForElapsedTime proxy : proxies) {
                proxy.cancel(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to execute action on for the
     * <code>when provided ElapsedTime</code> interaction contract.
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
    protected final static class TimerProxyForElapsedTime extends Proxy {
        private TimerProxyForElapsedTime(Service service, RemoteServiceInfo remoteServiceInfo) {
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
     * <code>when provided ElapsedTime</code> interaction contract.
    
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
    protected final static class NotifierDiscovererForElapsedTime {
        private Service serviceParent;
        
        private NotifierDiscovererForElapsedTime(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForElapsedTime instantiateComposite() {
            return new NotifierCompositeForElapsedTime(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForElapsedTime} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForElapsedTime all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForElapsedTime} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForElapsedTime anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForElapsedTime} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForElapsedTime whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided ElapsedTime</code> interaction contract.
    
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
    protected final static class NotifierCompositeForElapsedTime extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForElapsedTime> {
        private NotifierCompositeForElapsedTime(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/HomeService/Notifier/");
        }
        
        @Override
        protected NotifierProxyForElapsedTime instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForElapsedTime(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForElapsedTime}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForElapsedTime andId(java.lang.String id) throws CompositeException {
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
            for (NotifierProxyForElapsedTime proxy : proxies) {
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
            for (NotifierProxyForElapsedTime proxy : proxies) {
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
            for (NotifierProxyForElapsedTime proxy : proxies) {
                proxy.cancelNonCriticalNotification(id);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided ElapsedTime</code> interaction contract.
    
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
    protected final static class NotifierProxyForElapsedTime extends Proxy {
        private NotifierProxyForElapsedTime(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for ElapsedTime
}
