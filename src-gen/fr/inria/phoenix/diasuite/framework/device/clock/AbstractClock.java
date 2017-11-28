package fr.inria.phoenix.diasuite.framework.device.clock;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
 * device Clock extends Service {
 * 	source tickSecond as Integer;
 * 	source tickMinute as Integer;
 * 	source tickHour as Integer;
 * }
 * </pre>
 */
public abstract class AbstractClock extends Service {
    
    public AbstractClock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/Clock/", serviceConfiguration);
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
        if (orderName.equals("tickHour")) {
            return getTickHour();
        }
        if (orderName.equals("tickMinute")) {
            return getTickMinute();
        }
        if (orderName.equals("tickSecond")) {
            return getTickSecond();
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
    
    // Code for source tickHour from device Clock
    private java.lang.Integer _tickHour;
    
    /**
     * Publish the value of source <code>tickHour</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickHour as Integer;
     * </pre>
     * @param newTickHourValue the new value for the source <code>tickHour</code>
     */
    protected void publishTickHour(java.lang.Integer newTickHourValue) {
        _tickHour = newTickHourValue;
        getProcessor().publishValue(getOutProperties(), "tickHour", newTickHourValue); 
    }
    
    /**
     * Returns the value of source <code>tickHour</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickHour as Integer;
     * </pre>
     * @return the value of the source <code>tickHour</code>
     */
    protected java.lang.Integer getTickHour() throws Exception {
        return _tickHour;
    }
    // End of code for source tickHour from device Clock
    
    // Code for source tickMinute from device Clock
    private java.lang.Integer _tickMinute;
    
    /**
     * Publish the value of source <code>tickMinute</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickMinute as Integer;
     * </pre>
     * @param newTickMinuteValue the new value for the source <code>tickMinute</code>
     */
    protected void publishTickMinute(java.lang.Integer newTickMinuteValue) {
        _tickMinute = newTickMinuteValue;
        getProcessor().publishValue(getOutProperties(), "tickMinute", newTickMinuteValue); 
    }
    
    /**
     * Returns the value of source <code>tickMinute</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickMinute as Integer;
     * </pre>
     * @return the value of the source <code>tickMinute</code>
     */
    protected java.lang.Integer getTickMinute() throws Exception {
        return _tickMinute;
    }
    // End of code for source tickMinute from device Clock
    
    // Code for source tickSecond from device Clock
    private java.lang.Integer _tickSecond;
    
    /**
     * Publish the value of source <code>tickSecond</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickSecond as Integer;
     * </pre>
     * @param newTickSecondValue the new value for the source <code>tickSecond</code>
     */
    protected void publishTickSecond(java.lang.Integer newTickSecondValue) {
        _tickSecond = newTickSecondValue;
        getProcessor().publishValue(getOutProperties(), "tickSecond", newTickSecondValue); 
    }
    
    /**
     * Returns the value of source <code>tickSecond</code> from device <code>Clock</code>.
     * 
     * <pre>
     * source tickSecond as Integer;
     * </pre>
     * @return the value of the source <code>tickSecond</code>
     */
    protected java.lang.Integer getTickSecond() throws Exception {
        return _tickSecond;
    }
    // End of code for source tickSecond from device Clock
}
