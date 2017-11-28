package fr.inria.phoenix.diasuite.framework.context.elapsedtime;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

/**
 * listen for all timers

<pre>
context ElapsedTime as AlEirbTimer {
 * 	when provided timerTriggered from Timer maybe publish; 
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractElapsedTime extends Service {
    
    public AbstractElapsedTime(ServiceConfiguration serviceConfiguration) {
        super("/Context/ElapsedTime/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverTimerForSubscribe.all().subscribeTimerTriggered(); // subscribe to timerTriggered from all Timer devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("timerTriggered") && source.isCompatible("/Device/Device/Service/Timer/")) {
            TimerTriggeredFromTimer timerTriggeredFromTimer = new TimerTriggeredFromTimer(this, source, (java.lang.String) value,
                    (java.lang.String) indexes[0]);
            
            ElapsedTimeValuePublishable returnValue = onTimerTriggeredFromTimer(timerTriggeredFromTimer);
            if(returnValue != null && returnValue.doPublish()) {
                setElapsedTime(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("elapsedTime")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer contextValue;
    
    private void setElapsedTime(fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "elapsedTime", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer getLastValue() {
        return contextValue;
    }
    
    /**
     * A class that represents a value that might be published for the <code>ElapsedTime</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class ElapsedTimeValuePublishable {
        
        // The value of the context
        private fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public ElapsedTimeValuePublishable(fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value, boolean doPublish) {
            this.value = value;
            this.doPublish = doPublish;
        }
        
        /**
         * @return the value of the context that might be published
         */
        public fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer getValue() {
            return value;
        }
        
        /**
         * Sets the value that might be published
         * 
         * @param value the value that will be published if {@link #doPublish()} returns true
         */
        public void setValue(fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value) {
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
    when provided timerTriggered from Timer maybe publish;
    </pre>
     * 
     * @param timerTriggeredFromTimer the value of the <code>timerTriggered</code> source and the <code>Timer</code> device that published the value.
     * @return a {@link ElapsedTimeValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract ElapsedTimeValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer);
    
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
}
