package fr.inria.phoenix.diasuite.framework.device.inactivitysensor;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------------------------------------------------------------
 * Presence Detector					||
 * ------------------------------------------------------------
 * enumeration Room {
 * ENTRANCE, BEDROOM, KITCHEN, BATHROOM, LIVING, TOILET
 * }
 * 
 * device IndoorLocationDetector extends SoftwareSensor {
 * // AR (14/02/17)
 * source currentRoom as Room;
 * action SetLocation;
 * }
 * 
 * action SetLocation {
 * setLocation(location as Room);
 * resetLocation();
 * }
 * ------------------------------------------------------------
 * InactivitySensor					||
 * ------------------------------------------------------------
 * AR (01/08/17)
 * 
 * <pre>
 * device InactivitySensor extends SoftwareSensor {
 * 	source inactivityLevel as Float;
 * 	source lastInteraction as Interaction;
 * 	action UpdateInactivityLevel;
 * }
 * </pre>
 */
public abstract class AbstractInactivitySensor extends Service {
    
    public AbstractInactivitySensor(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/SoftwareSensor/InactivitySensor/", serviceConfiguration);
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
        if (orderName.equals("updateInactivityLevel")) {
            updateInactivityLevel((java.lang.Float) args[0]);
            return null;
        }
        if (orderName.equals("updateLastInteraction")) {
            updateLastInteraction((fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("inactivityLevel")) {
            return getInactivityLevel();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("lastInteraction")) {
            return getLastInteraction();
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
    
    // Code for source inactivityLevel from device InactivitySensor
    private java.lang.Float _inactivityLevel;
    
    /**
     * Publish the value of source <code>inactivityLevel</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source inactivityLevel as Float;
     * </pre>
     * @param newInactivityLevelValue the new value for the source <code>inactivityLevel</code>
     */
    protected void publishInactivityLevel(java.lang.Float newInactivityLevelValue) {
        _inactivityLevel = newInactivityLevelValue;
        getProcessor().publishValue(getOutProperties(), "inactivityLevel", newInactivityLevelValue); 
    }
    
    /**
     * Returns the value of source <code>inactivityLevel</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source inactivityLevel as Float;
     * </pre>
     * @return the value of the source <code>inactivityLevel</code>
     */
    protected java.lang.Float getInactivityLevel() throws Exception {
        return _inactivityLevel;
    }
    // End of code for source inactivityLevel from device InactivitySensor
    
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
    
    // Code for source lastInteraction from device InactivitySensor
    private fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction _lastInteraction;
    
    /**
     * Publish the value of source <code>lastInteraction</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source lastInteraction as Interaction;
     * </pre>
     * @param newLastInteractionValue the new value for the source <code>lastInteraction</code>
     */
    protected void publishLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newLastInteractionValue) {
        _lastInteraction = newLastInteractionValue;
        getProcessor().publishValue(getOutProperties(), "lastInteraction", newLastInteractionValue); 
    }
    
    /**
     * Returns the value of source <code>lastInteraction</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source lastInteraction as Interaction;
     * </pre>
     * @return the value of the source <code>lastInteraction</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction getLastInteraction() throws Exception {
        return _lastInteraction;
    }
    // End of code for source lastInteraction from device InactivitySensor
    
    /**
     * Implement this method to define the <code>updateInactivityLevel</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor.
     * 
     * 
     * <pre>
     * updateInactivityLevel(level as Float);
     * </pre>
     * @param level parameter 1 of the order.
     */
    protected abstract void updateInactivityLevel(java.lang.Float level) throws Exception;
    
    /**
     * Implement this method to define the <code>updateLastInteraction</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor.
     * 
     * 
     * <pre>
     * updateLastInteraction(lastInteraction as Interaction);
     * </pre>
     * @param lastInteraction parameter 1 of the order.
     */
    protected abstract void updateLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction lastInteraction) throws Exception;
}
