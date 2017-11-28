package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.temperaturesensor.AbstractTemperatureSensor;
import fr.inria.phoenix.diasuite.framework.device.temperaturesensor.TemperatureIndices;

// @internal
public final class TemperatureSensorMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTemperatureSensor {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String locationValue,
                java.lang.String userValue) {
            super(serviceConfiguration, idValue, locationValue, userValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateLocation(java.lang.String newLocationValue) {
            updateLocation(newLocationValue);
        }
        
        public void _updateUser(java.lang.String newUserValue) {
            updateUser(newUserValue);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected java.lang.Float getTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) throws Exception {
            java.lang.Float result = __temperature.get(new TemperatureIndices(unit));
            if(result == null)
                return super.getTemperature(unit);
            return result;
        }
        
        public void _publishTemperature(java.lang.Float newTemperatureValue,
                fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
            publishTemperature(newTemperatureValue,
                unit);
        }
    }
    
    Proxy proxy;
    
    TemperatureSensorMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, locationValue, userValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @param newIdValue the new value of <code>id</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
     * 
     * <pre>
     * attribute location as String;
     * </pre>
     * @param newLocationValue the new value of <code>location</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock location(java.lang.String newLocationValue) {
        proxy._updateLocation(newLocationValue);
        return this;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
     * 
     * <pre>
     * attribute user as String;
     * </pre>
     * @param newUserValue the new value of <code>user</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source temperature from device TemperatureSensor
    /**
     * Publish the value of source <code>temperature</code> from device <code>TemperatureSensor</code>.
     * 
     * <pre>
     * source temperature as Float indexed by unit as TemperatureUnit;
     * </pre>
     * @param newTemperatureValue the new value for the source <code>temperature</code>
     * @param unit the value of the index <code>unit</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock temperature(java.lang.Float newTemperatureValue,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        proxy._publishTemperature(newTemperatureValue,
            unit);
        return this;
    }
    
    private java.util.HashMap<TemperatureIndices, java.lang.Float> __temperature = new java.util.HashMap<TemperatureIndices, java.lang.Float>();
    /**
     * Set the value (without publication) of source <code>temperature</code> from device <code>TemperatureSensor</code>.
     * 
     * <pre>
     * source temperature as Float indexed by unit as TemperatureUnit;
     * </pre>
     * @param newTemperatureValue the new value for the source <code>temperature</code>
     * @param unit the value of the index <code>unit</code>
     * @return this for fluent interface
     */
    public TemperatureSensorMock setTemperature(java.lang.Float newTemperatureValue,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        TemperatureIndices _indices_ = new TemperatureIndices(unit);
        __temperature.put(_indices_, newTemperatureValue);
        return this;
    }
    // End of code for source temperature from device TemperatureSensor
}
