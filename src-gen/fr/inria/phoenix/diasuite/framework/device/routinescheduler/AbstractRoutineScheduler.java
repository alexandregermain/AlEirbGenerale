package fr.inria.phoenix.diasuite.framework.device.routinescheduler;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device RoutineScheduler extends Service {
 * 	source currentTime as DayTime;
 * 	source startMonitoring as DailyActivityName;
 * 	source stopMonitoring as DailyActivityName;
 * 	action UpdateDayTime;
 * 	action UpdateRoutines;
 * }
</pre>
 */
public abstract class AbstractRoutineScheduler extends Service {
    
    public AbstractRoutineScheduler(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/RoutineScheduler/", serviceConfiguration);
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
        if (orderName.equals("startMonitoring")) {
            startMonitoring((fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName) args[0]);
            return null;
        }
        if (orderName.equals("stopMonitoring")) {
            stopMonitoring((fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName) args[0]);
            return null;
        }
        if (orderName.equals("updateDayTime")) {
            updateDayTime((fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("currentTime")) {
            return getCurrentTime();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("startMonitoring")) {
            return getStartMonitoring();
        }
        if (orderName.equals("stopMonitoring")) {
            return getStopMonitoring();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source currentTime from device RoutineScheduler
    private fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime _currentTime;
    
    /**
     * Publish the value of source <code>currentTime</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source currentTime as DayTime;
    </pre>
    @param newCurrentTimeValue the new value for the source <code>currentTime</code>
     */
    protected void publishCurrentTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newCurrentTimeValue) {
        _currentTime = newCurrentTimeValue;
        getProcessor().publishValue(getOutProperties(), "currentTime", newCurrentTimeValue); 
    }
    
    /**
     * Returns the value of source <code>currentTime</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source currentTime as DayTime;
    </pre>
    @return the value of the source <code>currentTime</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime getCurrentTime() throws Exception {
        return _currentTime;
    }
    // End of code for source currentTime from device RoutineScheduler
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source startMonitoring from device RoutineScheduler
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName _startMonitoring;
    
    /**
     * Publish the value of source <code>startMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source startMonitoring as DailyActivityName;
    </pre>
    @param newStartMonitoringValue the new value for the source <code>startMonitoring</code>
     */
    protected void publishStartMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStartMonitoringValue) {
        _startMonitoring = newStartMonitoringValue;
        getProcessor().publishValue(getOutProperties(), "startMonitoring", newStartMonitoringValue); 
    }
    
    /**
     * Returns the value of source <code>startMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source startMonitoring as DailyActivityName;
    </pre>
    @return the value of the source <code>startMonitoring</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getStartMonitoring() throws Exception {
        return _startMonitoring;
    }
    // End of code for source startMonitoring from device RoutineScheduler
    
    // Code for source stopMonitoring from device RoutineScheduler
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName _stopMonitoring;
    
    /**
     * Publish the value of source <code>stopMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source stopMonitoring as DailyActivityName;
    </pre>
    @param newStopMonitoringValue the new value for the source <code>stopMonitoring</code>
     */
    protected void publishStopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStopMonitoringValue) {
        _stopMonitoring = newStopMonitoringValue;
        getProcessor().publishValue(getOutProperties(), "stopMonitoring", newStopMonitoringValue); 
    }
    
    /**
     * Returns the value of source <code>stopMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source stopMonitoring as DailyActivityName;
    </pre>
    @return the value of the source <code>stopMonitoring</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getStopMonitoring() throws Exception {
        return _stopMonitoring;
    }
    // End of code for source stopMonitoring from device RoutineScheduler
    
    /**
     * Implement this method to define the <code>startMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler.
     * 
    
    <pre>
    startMonitoring(activity as DailyActivityName);
    </pre>
     * @param activity parameter 1 of the order.
     */
    protected abstract void startMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception;
    
    /**
     * Implement this method to define the <code>stopMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler.
     * 
    
    <pre>
    stopMonitoring(activity as DailyActivityName);
    </pre>
     * @param activity parameter 1 of the order.
     */
    protected abstract void stopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception;
    
    /**
     * Implement this method to define the <code>updateDayTime</code> order from the <code>UpdateDayTime</code> action
     * defined in device RoutineScheduler.
     * 
    
    <pre>
    updateDayTime(currentTime as DayTime);
    </pre>
     * @param currentTime parameter 1 of the order.
     */
    protected abstract void updateDayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime currentTime) throws Exception;
}
