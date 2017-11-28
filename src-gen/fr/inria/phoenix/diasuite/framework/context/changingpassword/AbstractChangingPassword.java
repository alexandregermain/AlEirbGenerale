package fr.inria.phoenix.diasuite.framework.context.changingpassword;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.appliance.OnFromAppliance;

/**
 * <pre>
 * context ChangingPassword as String {
 *     when provided on from Appliance
 *     get on from Appliance, contact from ContactSensor
 *     maybe publish;
 * }
 * </pre>
 */
@SuppressWarnings("all")
public abstract class AbstractChangingPassword extends Service {
    
    public AbstractChangingPassword(ServiceConfiguration serviceConfiguration) {
        super("/Context/ChangingPassword/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverApplianceForSubscribe.all().subscribeOn(); // subscribe to on from all Appliance devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("on") && source.isCompatible("/Device/Device/PhysicalDevice/Appliance/")) {
            OnFromAppliance onFromAppliance = new OnFromAppliance(this, source, (java.lang.Boolean) value);
            
            ChangingPasswordValuePublishable returnValue = onOnFromAppliance(onFromAppliance, new DiscoverForOnFromAppliance());
            if(returnValue != null && returnValue.doPublish()) {
                setChangingPassword(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("changingPassword")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.String contextValue;
    
    private void setChangingPassword(java.lang.String newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "changingPassword", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.String getLastValue() {
        return contextValue;
    }
    
    /**
     * A class that represents a value that might be published for the <code>ChangingPassword</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class ChangingPasswordValuePublishable {
        
        // The value of the context
        private java.lang.String value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public ChangingPasswordValuePublishable(java.lang.String value, boolean doPublish) {
            this.value = value;
            this.doPublish = doPublish;
        }
        
        /**
         * @return the value of the context that might be published
         */
        public java.lang.String getValue() {
            return value;
        }
        
        /**
         * Sets the value that might be published
         * 
         * @param value the value that will be published if {@link #doPublish()} returns true
         */
        public void setValue(java.lang.String value) {
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
     * This method is called when a <code>Appliance</code> device on which we have subscribed publish on its <code>on</code> source.
     * 
     * <pre>
     * when provided on from Appliance
     *     get on from Appliance, contact from ContactSensor
     *     maybe publish;
     * </pre>
     * 
     * @param onFromAppliance the value of the <code>on</code> source and the <code>Appliance</code> device that published the value.
     * @param discover a discover object to get value from devices and contexts
     * @return a {@link ChangingPasswordValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract ChangingPasswordValuePublishable onOnFromAppliance(OnFromAppliance onFromAppliance, DiscoverForOnFromAppliance discover);
    
    // End of interaction contract implementation
    
    // Discover part for Appliance devices
    /**
     * Use this object to discover Appliance devices.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     * 
     * @see ApplianceDiscoverer
     */
    protected final ApplianceDiscoverer discoverApplianceForSubscribe = new ApplianceDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>Appliance</code> devices that can be discovered
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceDiscoverer {
        private Service serviceParent;
        
        private ApplianceDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private ApplianceComposite instantiateComposite() {
            return new ApplianceComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices
         * 
         * @return a {@link ApplianceComposite} object composed of all discoverable <code>Appliance</code>
         */
        public ApplianceComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Appliance</code> devices
         * 
         * @return a {@link ApplianceProxy} object pointing to a random discoverable <code>Appliance</code> device
         */
        public ApplianceProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link ApplianceComposite} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link ApplianceComposite} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceComposite whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link ApplianceComposite} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceComposite whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Appliance</code> devices
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceComposite extends fr.inria.diagen.core.service.composite.Composite<ApplianceProxy> {
        private ApplianceComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/");
        }
        
        @Override
        protected ApplianceProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new ApplianceProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link ApplianceComposite}, filtered using the attribute <code>id</code>.
         */
        public ApplianceComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link ApplianceComposite}, filtered using the attribute <code>location</code>.
         */
        public ApplianceComposite andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link ApplianceComposite}, filtered using the attribute <code>user</code>.
         */
        public ApplianceComposite andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Subscribes to the <code>on</code> source. After a call to this method, the context will be notified when a
         * <code>Appliance</code> device of this composite publishes a value on its <code>on</code> source.
         */
        public void subscribeOn() {
            subscribeValue("on");
        }
        
        /**
         * Unsubscribes from the <code>on</code> source. After a call to this method, the context will no more be notified
         * when a <code>Appliance</code> device of this composite publishes a value on its <code>on</code> source.
         */
        public void unsubscribeOn() {
            unsubscribeValue("on");
        }
    }
    
    /**
     * A proxy to one <code>Appliance</code> device
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceProxy extends Proxy {
        private ApplianceProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>on</code> source. After a call to this method, the context will be notified when the
         * <code>Appliance</code> device of this proxy publishes a value on its <code>on</code> source.
         */
        public void subscribeOn() {
            subscribeValue("on");
        }
        
        /**
         * Unsubscribes from the <code>on</code> source. After a call to this method, the context will no more be notified
         * when the <code>Appliance</code> device of this proxy publishes a value on its <code>on</code> source.
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
    // End of discover part for Appliance devices
    
    // Discover object for on from Appliance
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided on from Appliance
     *     get on from Appliance, contact from ContactSensor
     *     maybe publish;
     * </code>
     */
    protected final class DiscoverForOnFromAppliance {
        private final ApplianceDiscovererForOnFromAppliance applianceDiscoverer = new ApplianceDiscovererForOnFromAppliance(AbstractChangingPassword.this);
        private final ContactSensorDiscovererForOnFromAppliance contactSensorDiscoverer = new ContactSensorDiscovererForOnFromAppliance(AbstractChangingPassword.this);
        
        /**
         * @return a {@link ApplianceDiscovererForOnFromAppliance} object to discover <code>Appliance</code> devices
         */
        public ApplianceDiscovererForOnFromAppliance appliances() {
            return applianceDiscoverer;
        }
        
        /**
         * @return a {@link ContactSensorDiscovererForOnFromAppliance} object to discover <code>ContactSensor</code> devices
         */
        public ContactSensorDiscovererForOnFromAppliance contactSensors() {
            return contactSensorDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Appliance</code> devices to get their sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceDiscovererForOnFromAppliance {
        private Service serviceParent;
        
        private ApplianceDiscovererForOnFromAppliance(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private ApplianceCompositeForOnFromAppliance instantiateComposite() {
            return new ApplianceCompositeForOnFromAppliance(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices
         * 
         * @return a {@link ApplianceCompositeForOnFromAppliance} object composed of all discoverable <code>Appliance</code>
         */
        public ApplianceCompositeForOnFromAppliance all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Appliance</code> devices
         * 
         * @return a {@link ApplianceProxyForOnFromAppliance} object pointing to a random discoverable <code>Appliance</code> device
         */
        public ApplianceProxyForOnFromAppliance anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link ApplianceCompositeForOnFromAppliance} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceCompositeForOnFromAppliance whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link ApplianceCompositeForOnFromAppliance} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceCompositeForOnFromAppliance whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Appliance</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link ApplianceCompositeForOnFromAppliance} object composed of all matching <code>Appliance</code> devices
         */
        public ApplianceCompositeForOnFromAppliance whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Appliance</code> devices to get their sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceCompositeForOnFromAppliance extends fr.inria.diagen.core.service.composite.Composite<ApplianceProxyForOnFromAppliance> {
        private ApplianceCompositeForOnFromAppliance(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/");
        }
        
        @Override
        protected ApplianceProxyForOnFromAppliance instantiateProxy(RemoteServiceInfo rsi) {
            return new ApplianceProxyForOnFromAppliance(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link ApplianceCompositeForOnFromAppliance}, filtered using the attribute <code>id</code>.
         */
        public ApplianceCompositeForOnFromAppliance andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link ApplianceCompositeForOnFromAppliance}, filtered using the attribute <code>location</code>.
         */
        public ApplianceCompositeForOnFromAppliance andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link ApplianceCompositeForOnFromAppliance}, filtered using the attribute <code>user</code>.
         */
        public ApplianceCompositeForOnFromAppliance andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>Appliance</code> device to get its sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     */
    protected final static class ApplianceProxyForOnFromAppliance extends Proxy {
        private ApplianceProxyForOnFromAppliance(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>on</code> source of this <code>Appliance</code> device
         * 
         * @return the value of the <code>on</code> source
         */
        public java.lang.Boolean getOn() throws InvocationException {
            return (java.lang.Boolean) callGetValue("on");
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
     * Discover object that will exposes the <code>ContactSensor</code> devices to get their sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * 
     * <pre>
     * device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
     * </pre>
     */
    protected final static class ContactSensorDiscovererForOnFromAppliance {
        private Service serviceParent;
        
        private ContactSensorDiscovererForOnFromAppliance(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private ContactSensorCompositeForOnFromAppliance instantiateComposite() {
            return new ContactSensorCompositeForOnFromAppliance(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices
         * 
         * @return a {@link ContactSensorCompositeForOnFromAppliance} object composed of all discoverable <code>ContactSensor</code>
         */
        public ContactSensorCompositeForOnFromAppliance all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>ContactSensor</code> devices
         * 
         * @return a {@link ContactSensorProxyForOnFromAppliance} object pointing to a random discoverable <code>ContactSensor</code> device
         */
        public ContactSensorProxyForOnFromAppliance anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link ContactSensorCompositeForOnFromAppliance} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorCompositeForOnFromAppliance whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link ContactSensorCompositeForOnFromAppliance} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorCompositeForOnFromAppliance whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>ContactSensor</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link ContactSensorCompositeForOnFromAppliance} object composed of all matching <code>ContactSensor</code> devices
         */
        public ContactSensorCompositeForOnFromAppliance whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>ContactSensor</code> devices to get their sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * 
     * <pre>
     * device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
     * </pre>
     */
    protected final static class ContactSensorCompositeForOnFromAppliance extends fr.inria.diagen.core.service.composite.Composite<ContactSensorProxyForOnFromAppliance> {
        private ContactSensorCompositeForOnFromAppliance(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Sensor/ContactSensor/");
        }
        
        @Override
        protected ContactSensorProxyForOnFromAppliance instantiateProxy(RemoteServiceInfo rsi) {
            return new ContactSensorProxyForOnFromAppliance(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link ContactSensorCompositeForOnFromAppliance}, filtered using the attribute <code>id</code>.
         */
        public ContactSensorCompositeForOnFromAppliance andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link ContactSensorCompositeForOnFromAppliance}, filtered using the attribute <code>location</code>.
         */
        public ContactSensorCompositeForOnFromAppliance andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link ContactSensorCompositeForOnFromAppliance}, filtered using the attribute <code>user</code>.
         */
        public ContactSensorCompositeForOnFromAppliance andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>ContactSensor</code> device to get its sources for the
     * <code>when provided on from Appliance</code> interaction contract.
     * 
     * <pre>
     * device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
     * </pre>
     */
    protected final static class ContactSensorProxyForOnFromAppliance extends Proxy {
        private ContactSensorProxyForOnFromAppliance(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>contact</code> source of this <code>ContactSensor</code> device
         * 
         * @return the value of the <code>contact</code> source
         */
        public java.lang.Boolean getContact() throws InvocationException {
            return (java.lang.Boolean) callGetValue("contact");
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
    // End of discover object for on from Appliance
}
