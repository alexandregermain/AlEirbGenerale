package fr.inria.phoenix.diasuite.framework.controller.lampsuccesscontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.insidecontext.InsideContextValue;
import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.LunchAlarmContextValue;

/**
 * <pre>
controller LampSuccessController{
 *   when provided LunchAlarmContext
 *     do On on Light, 
 *        Off on Light;
 *   when provided InsideContext
 *   	do On on Light,
 *   	   Off on Light;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractLampSuccessController extends Service {
    
    public AbstractLampSuccessController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/LampSuccessController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("insideContext", "/Context/InsideContext/"); // subscribe to InsideContext context
        subscribeValue("lunchAlarmContext", "/Context/LunchAlarmContext/"); // subscribe to LunchAlarmContext context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("insideContext") && source.isCompatible("/Context/InsideContext/")) {
            InsideContextValue insideContextValue = new InsideContextValue((java.lang.Boolean) value);
            
            onInsideContext(insideContextValue, new DiscoverForInsideContext());
        }
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
     *     do On on Light, 
     *        Off on Light;
     * </pre>
     * 
     * @param lunchAlarmContext the value of the <code>LunchAlarmContext</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onLunchAlarmContext(LunchAlarmContextValue lunchAlarmContext, DiscoverForLunchAlarmContext discover);
    
    /**
     * This method is called when the <code>InsideContext</code> context publishes a value.
     * 
     * <pre>
     * when provided InsideContext
     *   	do On on Light,
     *   	   Off on Light;
     * </pre>
     * 
     * @param insideContext the value of the <code>InsideContext</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onInsideContext(InsideContextValue insideContext, DiscoverForInsideContext discover);
    
    // End of interaction contract implementation
    
    // Discover object for LunchAlarmContext
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided LunchAlarmContext
     *     do On on Light, 
     *        Off on Light;
     * </code>
     */
    protected final class DiscoverForLunchAlarmContext {
        private final LightDiscovererForLunchAlarmContext lightDiscoverer = new LightDiscovererForLunchAlarmContext(AbstractLampSuccessController.this);
        
        /**
         * @return a {@link LightDiscovererForLunchAlarmContext} object to discover <code>Light</code> devices
         */
        public LightDiscovererForLunchAlarmContext lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForLunchAlarmContext {
        private Service serviceParent;
        
        private LightDiscovererForLunchAlarmContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForLunchAlarmContext instantiateComposite() {
            return new LightCompositeForLunchAlarmContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForLunchAlarmContext} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForLunchAlarmContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForLunchAlarmContext} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForLunchAlarmContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForLunchAlarmContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForLunchAlarmContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForLunchAlarmContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForLunchAlarmContext whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForLunchAlarmContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForLunchAlarmContext whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForLunchAlarmContext extends fr.inria.diagen.core.service.composite.Composite<LightProxyForLunchAlarmContext> {
        private LightCompositeForLunchAlarmContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForLunchAlarmContext instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForLunchAlarmContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForLunchAlarmContext}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForLunchAlarmContext andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForLunchAlarmContext}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForLunchAlarmContext andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForLunchAlarmContext}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForLunchAlarmContext andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForLunchAlarmContext proxy : proxies) {
                proxy.on();
            }
        }
        
        /**
         * Executes the <code>off()</code> action's method on all devices of this composite.
         */
        public void off() throws InvocationException {
            launchDiscovering();
            for (LightProxyForLunchAlarmContext proxy : proxies) {
                proxy.off();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided LunchAlarmContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForLunchAlarmContext extends Proxy {
        private LightProxyForLunchAlarmContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for LunchAlarmContext
    
    // Discover object for InsideContext
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided InsideContext
     *   	do On on Light,
     *   	   Off on Light;
     * </code>
     */
    protected final class DiscoverForInsideContext {
        private final LightDiscovererForInsideContext lightDiscoverer = new LightDiscovererForInsideContext(AbstractLampSuccessController.this);
        
        /**
         * @return a {@link LightDiscovererForInsideContext} object to discover <code>Light</code> devices
         */
        public LightDiscovererForInsideContext lights() {
            return lightDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Light</code> devices to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightDiscovererForInsideContext {
        private Service serviceParent;
        
        private LightDiscovererForInsideContext(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private LightCompositeForInsideContext instantiateComposite() {
            return new LightCompositeForInsideContext(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightCompositeForInsideContext} object composed of all discoverable <code>Light</code>
         */
        public LightCompositeForInsideContext all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Light</code> devices
         * 
         * @return a {@link LightProxyForInsideContext} object pointing to a random discoverable <code>Light</code> device
         */
        public LightProxyForInsideContext anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link LightCompositeForInsideContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForInsideContext whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link LightCompositeForInsideContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForInsideContext whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Light</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link LightCompositeForInsideContext} object composed of all matching <code>Light</code> devices
         */
        public LightCompositeForInsideContext whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Light</code> devices to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightCompositeForInsideContext extends fr.inria.diagen.core.service.composite.Composite<LightProxyForInsideContext> {
        private LightCompositeForInsideContext(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Appliance/Light/");
        }
        
        @Override
        protected LightProxyForInsideContext instantiateProxy(RemoteServiceInfo rsi) {
            return new LightProxyForInsideContext(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link LightCompositeForInsideContext}, filtered using the attribute <code>id</code>.
         */
        public LightCompositeForInsideContext andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link LightCompositeForInsideContext}, filtered using the attribute <code>location</code>.
         */
        public LightCompositeForInsideContext andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link LightCompositeForInsideContext}, filtered using the attribute <code>user</code>.
         */
        public LightCompositeForInsideContext andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>on()</code> action's method on all devices of this composite.
         */
        public void on() throws InvocationException {
            launchDiscovering();
            for (LightProxyForInsideContext proxy : proxies) {
                proxy.on();
            }
        }
        
        /**
         * Executes the <code>off()</code> action's method on all devices of this composite.
         */
        public void off() throws InvocationException {
            launchDiscovering();
            for (LightProxyForInsideContext proxy : proxies) {
                proxy.off();
            }
        }
    }
    
    /**
     * A proxy to one <code>Light</code> device to execute action on for the
     * <code>when provided InsideContext</code> interaction contract.
    <p>
    ------
    Light
    ------
    
    <pre>
    device Light extends Appliance {
     * }
    </pre>
     */
    protected final static class LightProxyForInsideContext extends Proxy {
        private LightProxyForInsideContext(Service service, RemoteServiceInfo remoteServiceInfo) {
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
    // End of discover object for InsideContext
}
