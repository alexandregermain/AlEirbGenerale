package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.inactivitysensor.AbstractInactivitySensor;

// @internal
public final class InactivitySensorMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractInactivitySensor {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.lang.Float getInactivityLevel() throws Exception {
            java.lang.Float result = __inactivityLevel;
            if(result == null)
                return super.getInactivityLevel();
            return result;
        }
        
        public void _publishInactivityLevel(java.lang.Float newInactivityLevelValue) {
            publishInactivityLevel(newInactivityLevelValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction getLastInteraction() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction result = __lastInteraction;
            if(result == null)
                return super.getLastInteraction();
            return result;
        }
        
        public void _publishLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newLastInteractionValue) {
            publishLastInteraction(newLastInteractionValue);
        }
        
        protected void updateInactivityLevel(java.lang.Float level) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("updateInactivityLevel");
                __action.add(level);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void updateLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction lastInteraction) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("updateLastInteraction");
                __action.add(lastInteraction);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    InactivitySensorMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
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
    public InactivitySensorMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source inactivityLevel from device InactivitySensor
    /**
     * Publish the value of source <code>inactivityLevel</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source inactivityLevel as Float;
     * </pre>
     * @param newInactivityLevelValue the new value for the source <code>inactivityLevel</code>
     * @return this for fluent interface
     */
    public InactivitySensorMock inactivityLevel(java.lang.Float newInactivityLevelValue) {
        proxy._publishInactivityLevel(newInactivityLevelValue);
        return this;
    }
    
    private java.lang.Float __inactivityLevel = null;
    /**
     * Set the value (without publication) of source <code>inactivityLevel</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source inactivityLevel as Float;
     * </pre>
     * @param newInactivityLevelValue the new value for the source <code>inactivityLevel</code>
     * @return this for fluent interface
     */
    public InactivitySensorMock setInactivityLevel(java.lang.Float newInactivityLevelValue) {
        __inactivityLevel = newInactivityLevelValue;
        return this;
    }
    // End of code for source inactivityLevel from device InactivitySensor
    
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
    public InactivitySensorMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public InactivitySensorMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lastInteraction from device InactivitySensor
    /**
     * Publish the value of source <code>lastInteraction</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source lastInteraction as Interaction;
     * </pre>
     * @param newLastInteractionValue the new value for the source <code>lastInteraction</code>
     * @return this for fluent interface
     */
    public InactivitySensorMock lastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newLastInteractionValue) {
        proxy._publishLastInteraction(newLastInteractionValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction __lastInteraction = null;
    /**
     * Set the value (without publication) of source <code>lastInteraction</code> from device <code>InactivitySensor</code>.
     * 
     * <pre>
     * source lastInteraction as Interaction;
     * </pre>
     * @param newLastInteractionValue the new value for the source <code>lastInteraction</code>
     * @return this for fluent interface
     */
    public InactivitySensorMock setLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newLastInteractionValue) {
        __lastInteraction = newLastInteractionValue;
        return this;
    }
    // End of code for source lastInteraction from device InactivitySensor
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>updateInactivityLevel</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor was called.
     * 
     * 
     * <pre>
     * updateInactivityLevel(level as Float);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdateInactivityLevel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateInactivityLevel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>updateInactivityLevel</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor was called.
     * 
     * 
     * <pre>
     * updateInactivityLevel(level as Float);
     * </pre>
     * @param level parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdateInactivityLevel(java.lang.Float level) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateInactivityLevel".equals(__action.poll())))
                    return false;
                if(!level.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>updateLastInteraction</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor was called.
     * 
     * 
     * <pre>
     * updateLastInteraction(lastInteraction as Interaction);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdateLastInteraction() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateLastInteraction".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>updateLastInteraction</code> order from the <code>UpdateInactivityLevel</code> action
     * defined in device InactivitySensor was called.
     * 
     * 
     * <pre>
     * updateLastInteraction(lastInteraction as Interaction);
     * </pre>
     * @param lastInteraction parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdateLastInteraction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction lastInteraction) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateLastInteraction".equals(__action.poll())))
                    return false;
                if(!lastInteraction.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
