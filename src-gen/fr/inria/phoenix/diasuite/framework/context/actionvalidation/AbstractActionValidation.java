package fr.inria.phoenix.diasuite.framework.context.actionvalidation;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.contactsensor.ContactFromContactSensor;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

/**
 * <pre>
context ActionValidation as Boolean {
	when provided timerTriggered from Timer
	maybe publish;
	when provided contact from ContactSensor
	get timerTriggered from Timer
	maybe publish;
}
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractActionValidation extends Service {
    
    public AbstractActionValidation(ServiceConfiguration serviceConfiguration) {
        super("/Context/ActionValidation/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverContactSensorForSubscribe.all().subscribeContact(); // subscribe to contact from all ContactSensor devices
        discoverTimerForSubscribe.all().subscribeTimerTriggered(); // subscribe to timerTriggered from all Timer devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("contact") && source.isCompatible("/Device/Device/PhysicalDevice/Sensor/ContactSensor/")) {
            ContactFromContactSensor contactFromContactSensor = new ContactFromContactSensor(this, source, (java.lang.Boolean) value);
            
            ActionValidationValuePublishable returnValue = onContactFromContactSensor(contactFromContactSensor, new DiscoverForContactFromContactSensor());
            if(returnValue != null && returnValue.doPublish()) {
                setActionValidation(returnValue.getValue());
            }
        }
        if (eventName.equals("timerTriggered") && source.isCompatible("/Device/Device/Service/Timer/")) {
            TimerTriggeredFromTimer timerTriggeredFromTimer = new TimerTriggeredFromTimer(this, source, (java.lang.String) value,
                    (java.lang.String) indexes[0]);
            
            ActionValidationValuePublishable returnValue = onTimerTriggeredFromTimer(timerTriggeredFromTimer);
            if(returnValue != null && returnValue.doPublish()) {
                setActionValidation(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("actionValidation")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.Boolean contextValue;
    
    private void setActionValidation(java.lang.Boolean newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "actionValidation", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.Boolean getLastValue() {
        return contextValue;
    }
    
    /**
     * A class that represents a value that might be published for the <code>ActionValidation</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class ActionValidationValuePublishable {
        
        // The value of the context
        private java.lang.Boolean value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public ActionValidationValuePublishable(java.lang.Boolean value, boolean doPublish) {
            this.value = value;
            this.doPublish = doPublish;
        }
        
        /**
         * @return the value of the context that might be published
         */
        public java.lang.Boolean getValue() {
            return value;
        }
        
        /**
         * Sets the value that might be published
         * 
         * @param value the value that will be published if {@link #doPublish()} returns true
         */
        public void setValue(java.lang.Boolean value) {
            this.value = value;
        }
        
        /**
         * @return true if the value should be published
         */
        public boolean doPublish() {
            return doPublish;
        }
        
        /**
         * Set the value to be publishable or not
         * 
         * @param doPublish if true, the value will be published
         */
        public void setDoPublish(boolean doPublish) {
            this.doPublish = doPublish;
        }
    }
    // End of code relative to the return value of the context
    
    // Interaction contract implementation
    /**
     * This method is called when a <code>Timer</code> device on which we have subscribed publish on its <code>timerTriggered</code> source.
    
    <pre>
    when provided timerTriggered from Timer
    	maybe publish;
    </pre>
     * 
     * @param timerTriggeredFromTimer the value of the <code>timerTriggered</code> source and the <code>Timer</code> device that published the value.
     * @return a {@link ActionValidationValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract ActionValidationValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer);
    
    /**
     * This method is called when a <code>ContactSensor</code> device on which we have subscribed publish on its <code>contact</code> source.
    
    <pre>
    when provided contact from ContactSensor
    	get timerTriggered from Timer
    	maybe publish;
    </pre>
     * 
     * @param contactFromContactSensor the value of the <code>contact</code> source and the <code>ContactSensor</code> device that published the value.
     * @param discover a discover object to get value from devices and contexts
     * @return a {@link ActionValidationValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract ActionValidationValuePublishable onContactFromContactSensor(ContactFromContactSensor contactFromContactSensor, DiscoverForContactFromContactSensor discover);
    
    // End of interaction contract implementation
    
    // Discover part for Timer devices
    /**
     * Use this object to discover Timer devices.
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
     * 
     * @see TimerDiscoverer
     */
    protected final TimerDiscoverer discoverTimerForSubscribe = new TimerDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices that can be discovered
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
    protected final static class TimerDiscoverer {
        private Service serviceParent;
        
        private TimerDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerComposite instantiateComposite() {
            return new TimerComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerComposite} object composed of all discoverable <code>Timer</code>
         */
        public TimerComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxy} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerComposite} object composed of all matching <code>Timer</code> devices
         */
        public TimerComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices
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
    protected final static class TimerComposite extends fr.inria.diagen.core.service.composite.Composite<TimerProxy> {
        private TimerComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerComposite}, filtered using the attribute <code>id</code>.
         */
        public TimerComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Subscribes to the <code>timerTriggered</code> source. After a call to this method, the context will be notified when a
         * <code>Timer</code> device of this composite publishes a value on its <code>timerTriggered</code> source.
         */
        public void subscribeTimerTriggered() {
            subscribeValue("timerTriggered");
        }
        
        /**
         * Unsubscribes from the <code>timerTriggered</code> source. After a call to this method, the context will no more be notified
         * when a <code>Timer</code> device of this composite publishes a value on its <code>timerTriggered</code> source.
         */
        public void unsubscribeTimerTriggered() {
            unsubscribeValue("timerTriggered");
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device
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
    protected final static class TimerProxy extends Proxy {
        private TimerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>timerTriggered</code> source. After a call to this method, the context will be notified when the
         * <code>Timer</code> device of this proxy publishes a value on its <code>timerTriggered</code> source.
         */
        public void subscribeTimerTriggered() {
            subscribeValue("timerTriggered");
        }
        
        /**
         * Unsubscribes from the <code>timerTriggered</code> source. After a call to this method, the context will no more be notified
         * when the <code>Timer</code> device of this proxy publishes a value on its <code>timerTriggered</code> source.
         */
        public void unsubscribeTimerTriggered() {
            unsubscribeValue("timerTriggered");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover part for Timer devices
    
    // Discover part for ContactSensor devices
    /**
     * Use this object to discover ContactSensor devices.
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
    </pre>
     * 
     * @see ContactSensorDiscoverer
     */
    protected final ContactSensorDiscoverer discoverContactSensorForSubscribe = new ContactSensorDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>ContactSensor</code> devices that can be discovered
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
    </pre>
     */
    protected final static class ContactSensorDiscoverer {
        private Service serviceParent;
        
        private ContactSensorDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private ContactSensorComposite instantiateComposite() {
            return new ContactSensorComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices
         * 
         * @return a {@link ContactSensorComposite} object composed of all discoverable <code>ContactSensor</code>
         */
        public ContactSensorComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>ContactSensor</code> devices
         * 
         * @return a {@link ContactSensorProxy} object pointing to a random discoverable <code>ContactSensor</code> device
         */
        public ContactSensorProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link ContactSensorComposite} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link ContactSensorComposite} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorComposite whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link ContactSensorComposite} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorComposite whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>ContactSensor</code> devices
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
    </pre>
     */
    protected final static class ContactSensorComposite extends fr.inria.diagen.core.service.composite.Composite<ContactSensorProxy> {
        private ContactSensorComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Sensor/ContactSensor/");
        }
        
        @Override
        protected ContactSensorProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new ContactSensorProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link ContactSensorComposite}, filtered using the attribute <code>id</code>.
         */
        public ContactSensorComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link ContactSensorComposite}, filtered using the attribute <code>location</code>.
         */
        public ContactSensorComposite andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link ContactSensorComposite}, filtered using the attribute <code>user</code>.
         */
        public ContactSensorComposite andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Subscribes to the <code>contact</code> source. After a call to this method, the context will be notified when a
         * <code>ContactSensor</code> device of this composite publishes a value on its <code>contact</code> source.
         */
        public void subscribeContact() {
            subscribeValue("contact");
        }
        
        /**
         * Unsubscribes from the <code>contact</code> source. After a call to this method, the context will no more be notified
         * when a <code>ContactSensor</code> device of this composite publishes a value on its <code>contact</code> source.
         */
        public void unsubscribeContact() {
            unsubscribeValue("contact");
        }
    }
    
    /**
     * A proxy to one <code>ContactSensor</code> device
    
    <pre>
    device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
    </pre>
     */
    protected final static class ContactSensorProxy extends Proxy {
        private ContactSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>contact</code> source. After a call to this method, the context will be notified when the
         * <code>ContactSensor</code> device of this proxy publishes a value on its <code>contact</code> source.
         */
        public void subscribeContact() {
            subscribeValue("contact");
        }
        
        /**
         * Unsubscribes from the <code>contact</code> source. After a call to this method, the context will no more be notified
         * when the <code>ContactSensor</code> device of this proxy publishes a value on its <code>contact</code> source.
         */
        public void unsubscribeContact() {
            unsubscribeValue("contact");
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
    // End of discover part for ContactSensor devices
    
    // Discover object for contact from ContactSensor
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided contact from ContactSensor
     * 	get timerTriggered from Timer
     * 	maybe publish;
     * </code>
     */
    protected final class DiscoverForContactFromContactSensor {
        private final TimerDiscovererForContactFromContactSensor timerDiscoverer = new TimerDiscovererForContactFromContactSensor(AbstractActionValidation.this);
        
        /**
         * @return a {@link TimerDiscovererForContactFromContactSensor} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForContactFromContactSensor timers() {
            return timerDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices to get their sources for the
     * <code>when provided contact from ContactSensor</code> interaction contract.
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
    protected final static class TimerDiscovererForContactFromContactSensor {
        private Service serviceParent;
        
        private TimerDiscovererForContactFromContactSensor(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerCompositeForContactFromContactSensor instantiateComposite() {
            return new TimerCompositeForContactFromContactSensor(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerCompositeForContactFromContactSensor} object composed of all discoverable <code>Timer</code>
         */
        public TimerCompositeForContactFromContactSensor all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxyForContactFromContactSensor} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxyForContactFromContactSensor anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerCompositeForContactFromContactSensor} object composed of all matching <code>Timer</code> devices
         */
        public TimerCompositeForContactFromContactSensor whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices to get their sources for the
     * <code>when provided contact from ContactSensor</code> interaction contract.
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
    protected final static class TimerCompositeForContactFromContactSensor extends fr.inria.diagen.core.service.composite.Composite<TimerProxyForContactFromContactSensor> {
        private TimerCompositeForContactFromContactSensor(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/Timer/");
        }
        
        @Override
        protected TimerProxyForContactFromContactSensor instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxyForContactFromContactSensor(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerCompositeForContactFromContactSensor}, filtered using the attribute <code>id</code>.
         */
        public TimerCompositeForContactFromContactSensor andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device to get its sources for the
     * <code>when provided contact from ContactSensor</code> interaction contract.
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
    protected final static class TimerProxyForContactFromContactSensor extends Proxy {
        private TimerProxyForContactFromContactSensor(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>timerTriggered</code> source of this <code>Timer</code> device
         * 
         * @param timerId the value of the <code>timerId</code> index.
         * @return the value of the <code>timerTriggered</code> source
         */
        public java.lang.String getTimerTriggered(java.lang.String timerId) throws InvocationException {
            return (java.lang.String) callGetValue("timerTriggered", timerId);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for contact from ContactSensor
}
