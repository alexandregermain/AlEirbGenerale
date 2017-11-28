package fr.inria.phoenix.diasuite.framework.controller.handlepassword;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.passwordlistener.PasswordListenerValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.UpdatePasswordValue;

/**
 * <pre>
controller HandlePassword{
 *   when provided PasswordListener
 *     do On on Light, 
 *        Off on Light;
 *   when provided UpdatePassword
 *     do On on Light, 
 *        Off on Light;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractHandlePassword extends Service {
    
    public AbstractHandlePassword(ServiceConfiguration serviceConfiguration) {
        super("/Controller/HandlePassword/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("passwordListener", "/Context/PasswordListener/"); // subscribe to PasswordListener context
        subscribeValue("updatePassword", "/Context/UpdatePassword/"); // subscribe to UpdatePassword context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("passwordListener") && source.isCompatible("/Context/PasswordListener/")) {
            PasswordListenerValue passwordListenerValue = new PasswordListenerValue((java.lang.Boolean) value);
            
            onPasswordListener(passwordListenerValue, new DiscoverForPasswordListener());
        }
        if (eventName.equals("updatePassword") && source.isCompatible("/Context/UpdatePassword/")) {
            UpdatePasswordValue updatePasswordValue = new UpdatePasswordValue((fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating) value);
            
            onUpdatePassword(updatePasswordValue, new DiscoverForUpdatePassword());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>PasswordListener</code> context publishes a value.
     * 
     * <pre>
     * when provided PasswordListener
     *     do On on Light, 
     *        Off on Light;
     * </pre>
     * 
     * @param passwordListener the value of the <code>PasswordListener</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onPasswordListener(PasswordListenerValue passwordListener, DiscoverForPasswordListener discover);
    
    /**
     * This method is called when the <code>UpdatePassword</code> context publishes a value.
     * 
     * <pre>
     * when provided UpdatePassword
     *     do On on Light, 
     *        Off on Light;
     * </pre>
     * 
     * @param updatePassword the value of the <code>UpdatePassword</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onUpdatePassword(UpdatePasswordValue updatePassword, DiscoverForUpdatePassword discover);
    
    // End of interaction contract implementation
    
    // Discover object for PasswordListener
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided PasswordListener
     *     do On on Light, 
     *        Off on Light;
     * </code>
     */
    protected final class DiscoverForPasswordListener {
        private final LightDiscovererForPasswordListener lightDiscoverer = new LightDiscovererForPasswordListener(AbstractHandlePassword.this);
        
        /**
         * @return a {@link LightDiscovererForPasswordListener} object to discover <code>Light</code> devices
         */
        public LightDiscovererForPasswordListener lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided PasswordListener</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForPasswordListener {
        private Service serviceParent;
        
        private LightDiscovererForPasswordListener(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForPasswordListener instantiateComposite() {
            return new LightCompositeForPasswordListener(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForPasswordListener} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForPasswordListener all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForPasswordListener} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForPasswordListener anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForPasswordListener} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPasswordListener whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForPasswordListener} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPasswordListener whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForPasswordListener} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForPasswordListener whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided PasswordListener</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForPasswordListener extends fr.inria.diagen.core.service.composite.Composite<LightProxyForPasswordListener> {
        private LightCompositeForPasswordListener(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForPasswordListener instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForPasswordListener(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForPasswordListener}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForPasswordListener andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForPasswordListener}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForPasswordListener andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForPasswordListener}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForPasswordListener andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForPasswordListener proxy : proxies) {
                proxy.on();
            }
        }
        
        /**
         * Executes the <code>off()</code> action's method on all devices of this composite.
         */
        public void off() throws InvocationException {
            launchDiscovering();
            for (LightProxyForPasswordListener proxy : proxies) {
                proxy.off();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided PasswordListener</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForPasswordListener extends Proxy {
        private LightProxyForPasswordListener(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>on()</code> action's method on this device.
         */
        public void on() throws InvocationException {
            callOrder("on");
        }
        
        /**
         * Executes the <code>off()</code> action's method on this device.
         */
        public void off() throws InvocationException {
            callOrder("off");
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
    // End of discover object for PasswordListener
    
    // Discover object for UpdatePassword
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided UpdatePassword
     *     do On on Light, 
     *        Off on Light;
     * </code>
     */
    protected final class DiscoverForUpdatePassword {
        private final LightDiscovererForUpdatePassword lightDiscoverer = new LightDiscovererForUpdatePassword(AbstractHandlePassword.this);
        
        /**
         * @return a {@link LightDiscovererForUpdatePassword} object to discover <code>Light</code> devices
         */
        public LightDiscovererForUpdatePassword lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForUpdatePassword {
        private Service serviceParent;
        
        private LightDiscovererForUpdatePassword(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForUpdatePassword instantiateComposite() {
            return new LightCompositeForUpdatePassword(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForUpdatePassword} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForUpdatePassword all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForUpdatePassword} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForUpdatePassword anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForUpdatePassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForUpdatePassword whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForUpdatePassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForUpdatePassword whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForUpdatePassword} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForUpdatePassword whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForUpdatePassword extends fr.inria.diagen.core.service.composite.Composite<LightProxyForUpdatePassword> {
        private LightCompositeForUpdatePassword(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForUpdatePassword instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForUpdatePassword(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForUpdatePassword}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForUpdatePassword andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForUpdatePassword}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForUpdatePassword andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForUpdatePassword}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForUpdatePassword andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForUpdatePassword proxy : proxies) {
                proxy.on();
            }
        }
        
        /**
         * Executes the <code>off()</code> action's method on all devices of this composite.
         */
        public void off() throws InvocationException {
            launchDiscovering();
            for (LightProxyForUpdatePassword proxy : proxies) {
                proxy.off();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided UpdatePassword</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForUpdatePassword extends Proxy {
        private LightProxyForUpdatePassword(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>on()</code> action's method on this device.
         */
        public void on() throws InvocationException {
            callOrder("on");
        }
        
        /**
         * Executes the <code>off()</code> action's method on this device.
         */
        public void off() throws InvocationException {
            callOrder("off");
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
    // End of discover object for UpdatePassword
}
