package fr.inria.phoenix.diasuite.framework.controller.handlenotifier;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;

/**
 * <pre>
controller HandleNotifier{
 *   when provided UpdatePassword
 *     do ScheduleTimer on Timer,
 *        SendMessage on Messenger,
 * 	   SendCriticalNotification on Notifier;
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
        subscribeValue("updatePassword", "/Context/UpdatePassword/"); // subscribe to UpdatePassword context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
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
     *        SendMessage on Messenger,
     * 	   SendCriticalNotification on Notifier;
     * </pre>
     * 
     * @param updatePassword the value of the <code>UpdatePassword</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover);
    
    // End of interaction contract implementation
    
    // Discover object for UpdatePassword
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided UpdatePassword
     *     do ScheduleTimer on Timer,
     *        SendMessage on Messenger,
     * 	   SendCriticalNotification on Notifier;
     * </code>
     */
    protected final class DiscoverForUpdatePassword {
        private final TimerDiscovererForUpdatePassword timerDiscoverer = new TimerDiscovererForUpdatePassword(AbstractHandleNotifier.this);
        private final MessengerDiscovererForUpdatePassword messengerDiscoverer = new MessengerDiscovererForUpdatePassword(AbstractHandleNotifier.this);
        private final NotifierDiscovererForUpdatePassword notifierDiscoverer = new NotifierDiscovererForUpdatePassword(AbstractHandleNotifier.this);
        
        /**
         * @return a {@link TimerDiscovererForUpdatePassword} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForUpdatePassword timers() {
            return timerDiscoverer;
        }
        
        /**
         * @return a {@link MessengerDiscovererForUpdatePassword} object to discover <code>Messenger</code> devices
         */
        public MessengerDiscovererForUpdatePassword messengers() {
            return messengerDiscoverer;
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
     * Discover object that will exposes the <code>Messenger</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerDiscovererForUpdatePassword {
        private Service serviceParent;
        
        private MessengerDiscovererForUpdatePassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private MessengerCompositeForUpdatePassword instantiateComposite() {
            return new MessengerCompositeForUpdatePassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerCompositeForUpdatePassword} object composed of all discoverable <code>Messenger</code>
         */
        public MessengerCompositeForUpdatePassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerProxyForUpdatePassword} object pointing to a random discoverable <code>Messenger</code> device
         */
        public MessengerProxyForUpdatePassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link MessengerCompositeForUpdatePassword} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForUpdatePassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Messenger</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerCompositeForUpdatePassword extends fr.inria.diagen.core.service.composite.Composite<MessengerProxyForUpdatePassword> {
        private MessengerCompositeForUpdatePassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/CommunicationService/Messenger/");
        }
        
        @Override
        protected MessengerProxyForUpdatePassword instantiateProxy(RemoteServiceInfo rsi) {
            return new MessengerProxyForUpdatePassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link MessengerCompositeForUpdatePassword}, filtered using the attribute <code>id</code>.
         */
        public MessengerCompositeForUpdatePassword andId(java.lang.String id) throws CompositeException {
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
            for (MessengerProxyForUpdatePassword proxy : proxies) {
                proxy.sendMessage(message);
            }
        }
    }
    
    /**
     * A proxy to one <code>Messenger</code> device to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    
    <pre>
    device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerProxyForUpdatePassword extends Proxy {
        private MessengerProxyForUpdatePassword(Service service, RemoteServiceInfo remoteServiceInfo) {
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
         * Executes the <code>sendCriticalNotification(notification as CriticalNotification)</code> action's method on all devices of this composite.
         * 
         * @param notification the <code>notification</code> parameter of the <code>sendCriticalNotification(notification as CriticalNotification)</code> method.
         */
        public void sendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForUpdatePassword proxy : proxies) {
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
            for (NotifierProxyForUpdatePassword proxy : proxies) {
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
            for (NotifierProxyForUpdatePassword proxy : proxies) {
                proxy.cancelCriticalNotification(id);
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
    // End of discover object for UpdatePassword
}
