package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.lightsensor.AbstractLightSensor;

// @internal
public final class LightSensorMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractLightSensor {
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
        
        protected java.lang.Float getLightLevel() throws Exception {
            java.lang.Float result = __lightLevel;
            if(result == null)
                return super.getLightLevel();
            return result;
        }
        
        public void _publishLightLevel(java.lang.Float newLightLevelValue) {
            publishLightLevel(newLightLevelValue);
        }
    }
    
    Proxy proxy;
    
    LightSensorMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, locationValue, userValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public LightSensorMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
    @return this for fluent interface
     */
    public LightSensorMock location(java.lang.String newLocationValue) {
        proxy._updateLocation(newLocationValue);
        return this;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
    @return this for fluent interface
     */
    public LightSensorMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public LightSensorMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public LightSensorMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lightLevel from device LightSensor
    /**
     * Publish the value of source <code>lightLevel</code> from device <code>LightSensor</code>.
    
    <pre>
    source lightLevel as Float;
    </pre>
    @param newLightLevelValue the new value for the source <code>lightLevel</code>
    @return this for fluent interface
     */
    public LightSensorMock lightLevel(java.lang.Float newLightLevelValue) {
        proxy._publishLightLevel(newLightLevelValue);
        return this;
    }
    
    private java.lang.Float __lightLevel = null;
    /**
     * Set the value (without publication) of source <code>lightLevel</code> from device <code>LightSensor</code>.
    
    <pre>
    source lightLevel as Float;
    </pre>
    @param newLightLevelValue the new value for the source <code>lightLevel</code>
    @return this for fluent interface
     */
    public LightSensorMock setLightLevel(java.lang.Float newLightLevelValue) {
        __lightLevel = newLightLevelValue;
        return this;
    }
    // End of code for source lightLevel from device LightSensor
}
