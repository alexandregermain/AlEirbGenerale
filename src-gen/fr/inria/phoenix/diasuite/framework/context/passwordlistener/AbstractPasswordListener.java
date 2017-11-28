package fr.inria.phoenix.diasuite.framework.context.passwordlistener;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.contactsensor.ContactFromContactSensor;
import fr.inria.phoenix.diasuite.framework.device.light.OnFromLight;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.ElapsedTimeValue;
import fr.inria.phoenix.diasuite.framework.context.isinside.IsInsideValue;

/**
 * no more listen after ringing stops

<pre>
context PasswordListener as Boolean {
 * 	when provided IsInside no publish; 
 * 	when provided on from Light maybe publish; 
 * 	when provided contact from ContactSensor maybe publish; 
 * 	when provided ElapsedTime no publish; 
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractPasswordListener extends Service {
    
    public AbstractPasswordListener(ServiceConfiguration serviceConfiguration) {
        super("/Context/PasswordListener/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("elapsedTime", "/Context/ElapsedTime/"); // subscribe to ElapsedTime context
        subscribeValue("isInside", "/Context/IsInside/"); // subscribe to IsInside context
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverContactSensorForSubscribe.all().subscribeContact(); // subscribe to contact from all ContactSensor devices
        discoverLightForSubscribe.all().subscribeOn(); // subscribe to on from all Light devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("elapsedTime") && source.isCompatible("/Context/ElapsedTime/")) {
            ElapsedTimeValue elapsedTimeValue = new ElapsedTimeValue((fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer) value);
            
            onElapsedTime(elapsedTimeValue);
        }
        if (eventName.equals("isInside") && source.isCompatible("/Context/IsInside/")) {
            IsInsideValue isInsideValue = new IsInsideValue((java.lang.Boolean) value);
            
            onIsInside(isInsideValue);
        }
        if (eventName.equals("contact") && source.isCompatible("/Device/Device/PhysicalDevice/Sensor/ContactSensor/")) {
            ContactFromContactSensor contactFromContactSensor = new ContactFromContactSensor(this, source, (java.lang.Boolean) value);
            
            PasswordListenerValuePublishable returnValue = onContactFromContactSensor(contactFromContactSensor);
            if(returnValue != null && returnValue.doPublish()) {
                setPasswordListener(returnValue.getValue());
            }
        }
        if (eventName.equals("on") && source.isCompatible("/Device/Device/PhysicalDevice/Appliance/Light/")) {
            OnFromLight onFromLight = new OnFromLight(this, source, (java.lang.Boolean) value);
            
            PasswordListenerValuePublishable returnValue = onOnFromLight(onFromLight);
            if(returnValue != null && returnValue.doPublish()) {
                setPasswordListener(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("passwordListener")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.Boolean contextValue;
    
    private void setPasswordListener(java.lang.Boolean newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "passwordListener", newContextValue);
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
     * A class that represents a value that might be published for the <code>PasswordListener</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class PasswordListenerValuePublishable {
        
        // The value of the context
        private java.lang.Boolean value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public PasswordListenerValuePublishable(java.lang.Boolean value, boolean doPublish) {
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
     * This method is called when the <code>IsInside</code> context publishes a value.
    
    <pre>
    when provided IsInside no publish;
    </pre>
     * 
     * @param isInsideValue the value of the <code>IsInside</code> context.
     */
    protected abstract void onIsInside(IsInsideValue isInsideValue);
    
    /**
     * This method is called when a <code>Light</code> device on which we have subscribed publish on its <code>on</code> source.
    <p>
    Save info about home occupancy - listen if true, no if false
    
    <pre>
    when provided on from Light maybe publish;
    </pre>
     * 
     * @param onFromLight the value of the <code>on</code> source and the <code>Light</code> device that published the value.
     * @return a {@link PasswordListenerValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract PasswordListenerValuePublishable onOnFromLight(OnFromLight onFromLight);
    
    /**
     * This method is called when a <code>ContactSensor</code> device on which we have subscribed publish on its <code>contact</code> source.
    <p>
    store and compare
    
    <pre>
    when provided contact from ContactSensor maybe publish;
    </pre>
     * 
     * @param contactFromContactSensor the value of the <code>contact</code> source and the <code>ContactSensor</code> device that published the value.
     * @return a {@link PasswordListenerValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract PasswordListenerValuePublishable onContactFromContactSensor(ContactFromContactSensor contactFromContactSensor);
    
    /**
     * This method is called when the <code>ElapsedTime</code> context publishes a value.
    <p>
    store and compare
    
    <pre>
    when provided ElapsedTime no publish;
    </pre>
     * 
     * @param elapsedTimeValue the value of the <code>ElapsedTime</code> context.
     */
    protected abstract void onElapsedTime(ElapsedTimeValue elapsedTimeValue);
    
    // End of interaction contract implementation
    
    // Discover part for Light devices
    /**
     * Use this object to discover Light devices.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     * 
     * @see LightDiscoverer
     */
    protected final LightDiscoverer discoverLightForSubscribe = new LightDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>Light</code> devices that can be discovered
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscoverer {
        private Service serviceParent;
        
        private LightDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightComposite instantiateComposite() {
            return new LightComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightComposite} object composed of all discoverable <code>Light</code>
         */
        public LightComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxy} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightComposite} object composed of all matching <code>Light</code> devices
         */
        public LightComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightComposite} object composed of all matching <code>Light</code> devices
         */
        public LightComposite whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightComposite} object composed of all matching <code>Light</code> devices
         */
        public LightComposite whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightComposite extends fr.inria.diagen.core.service.composite.Composite<LightProxy> {
        private LightComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightComposite}, filtered using the attribute <code>id</code>.
         */
        public LightComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightComposite}, filtered using the attribute <code>location</code>.
         */
        public LightComposite andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightComposite}, filtered using the attribute <code>user</code>.
         */
        public LightComposite andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Subscribes to the <code>on</code> source. After a call to this method, the context will be notified when a
         * <code>Light</code> device of this composite publishes a value on its <code>on</code> source.
         */
        public void subscribeOn() {
            subscribeValue("on");
        }
        
        /**
         * Unsubscribes from the <code>on</code> source. After a call to this method, the context will no more be notified
         * when a <code>Light</code> device of this composite publishes a value on its <code>on</code> source.
         */
        public void unsubscribeOn() {
            unsubscribeValue("on");
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxy extends Proxy {
        private LightProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>on</code> source. After a call to this method, the context will be notified when the
         * <code>Light</code> device of this proxy publishes a value on its <code>on</code> source.
         */
        public void subscribeOn() {
            subscribeValue("on");
        }
        
        /**
         * Unsubscribes from the <code>on</code> source. After a call to this method, the context will no more be notified
         * when the <code>Light</code> device of this proxy publishes a value on its <code>on</code> source.
         */
        public void unsubscribeOn() {
            unsubscribeValue("on");
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
    // End of discover part for Light devices
    
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
}
