package fr.inria.phoenix.diasuite.framework.controller.lampalarmsuccesscontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.lunchalarmcontext.LunchAlarmContextValue;

/**
 * <pre>
controller LampAlarmSuccessController{
 *   when provided LunchAlarmContext
 *     do ScheduleTimer on Timer;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractLampAlarmSuccessController extends Service {
    
    public AbstractLampAlarmSuccessController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/LampAlarmSuccessController/", serviceConfiguration);
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
     *     do ScheduleTimer on Timer;
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
     *     do ScheduleTimer on Timer;
     * </code>
     */
    protected final class DiscoverForLunchAlarmContext {
        private final TimerDiscovererForLunchAlarmContext timerDiscoverer = new TimerDiscovererForLunchAlarmContext(AbstractLampAlarmSuccessController.this);
        
        /**
         * @return a {@link TimerDiscovererForLunchAlarmContext} object to discover <code>Timer</code> devices
         */
        public TimerDiscovererForLunchAlarmContext timers() {
            return timerDiscoverer;
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
    // End of discover object for LunchAlarmContext
}
