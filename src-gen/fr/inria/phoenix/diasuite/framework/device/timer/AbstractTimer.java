package fr.inria.phoenix.diasuite.framework.device.timer;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------
 * Timer
 * ------
 * 
 * <pre>
 * device Timer extends Service {
 * 	source timerTriggered as String indexed by timerId as String;
 * 	action ScheduleTimer;
 * }
 * </pre>
 */
public abstract class AbstractTimer extends Service {
    
    public AbstractTimer(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/Timer/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("cancel")) {
            cancel((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("periodicSchedule")) {
            periodicSchedule((java.lang.String) args[0],
                    (java.lang.Integer) args[1],
                    (java.lang.Integer) args[2]);
            return null;
        }
        if (orderName.equals("schedule")) {
            schedule((java.lang.String) args[0],
                    (java.lang.Integer) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("timerTriggered")) {
            return getTimerTriggered((java.lang.String) args[0]);
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source timerTriggered from device Timer
    private java.util.HashMap<TimerTriggeredIndices, java.lang.String> _timerTriggered = new java.util.HashMap<TimerTriggeredIndices, java.lang.String>();
    
    /**
     * Publish the value of source <code>timerTriggered</code> from device <code>Timer</code>.
     * 
     * <pre>
     * source timerTriggered as String indexed by timerId as String;
     * </pre>
     * @param newTimerTriggeredValue the new value for the source <code>timerTriggered</code>
     * @param timerId the value of the index <code>timerId</code>
     */
    protected void publishTimerTriggered(java.lang.String newTimerTriggeredValue,
            java.lang.String timerId) {
        TimerTriggeredIndices _indices_ = new TimerTriggeredIndices(timerId);
        _timerTriggered.put(_indices_, newTimerTriggeredValue);
        getProcessor().publishValue(getOutProperties(), "timerTriggered", newTimerTriggeredValue, timerId); 
    }
    
    /**
     * Returns the value of source <code>timerTriggered</code> from device <code>Timer</code>.
     * 
     * <pre>
     * source timerTriggered as String indexed by timerId as String;
     * </pre>
     * @param timerId the value of the index <code>timerId</code>
     * @return the value of the source <code>timerTriggered</code>
     */
    protected java.lang.String getTimerTriggered(java.lang.String timerId) throws Exception {
        return _timerTriggered.get(new TimerTriggeredIndices(timerId));
    }
    // End of code for source timerTriggered from device Timer
    
    /**
     * Implement this method to define the <code>cancel</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer.
     * 
     * 
     * <pre>
     * cancel(id as String);
     * </pre>
     * @param id parameter 1 of the order.
     */
    protected abstract void cancel(java.lang.String id) throws Exception;
    
    /**
     * Implement this method to define the <code>periodicSchedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer.
     * 
     * 
     * <pre>
     * periodicSchedule(id as String, delayMs as Integer, periodMs as Integer);
     * </pre>
     * @param id parameter 1 of the order.
     * @param delayMs parameter 2 of the order.
     * @param periodMs parameter 3 of the order.
     */
    protected abstract void periodicSchedule(java.lang.String id,
            java.lang.Integer delayMs,
            java.lang.Integer periodMs) throws Exception;
    
    /**
     * Implement this method to define the <code>schedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer.
     * 
     * 
     * <pre>
     * schedule(id as String, delayMs as Integer);
     * </pre>
     * @param id parameter 1 of the order.
     * @param delayMs parameter 2 of the order.
     */
    protected abstract void schedule(java.lang.String id,
            java.lang.Integer delayMs) throws Exception;
}
