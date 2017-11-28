package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.input.AbstractInput;

// @internal
public final class InputMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractInput {
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
        
        protected java.lang.String getMessage() throws Exception {
            java.lang.String result = __message;
            if(result == null)
                return super.getMessage();
            return result;
        }
        
        public void _publishMessage(java.lang.String newMessageValue) {
            publishMessage(newMessageValue);
        }
        
        protected void setInput(java.lang.String message) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setInput");
                __action.add(message);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    InputMock(ServiceConfiguration serviceConfiguration,
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
    public InputMock id(java.lang.String newIdValue) {
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
    public InputMock location(java.lang.String newLocationValue) {
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
    public InputMock user(java.lang.String newUserValue) {
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
    public InputMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public InputMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source message from device Input
    /**
     * Publish the value of source <code>message</code> from device <code>Input</code>.
     * 
     * <pre>
     * source message as String;
     * </pre>
     * @param newMessageValue the new value for the source <code>message</code>
     * @return this for fluent interface
     */
    public InputMock message(java.lang.String newMessageValue) {
        proxy._publishMessage(newMessageValue);
        return this;
    }
    
    private java.lang.String __message = null;
    /**
     * Set the value (without publication) of source <code>message</code> from device <code>Input</code>.
     * 
     * <pre>
     * source message as String;
     * </pre>
     * @param newMessageValue the new value for the source <code>message</code>
     * @return this for fluent interface
     */
    public InputMock setMessage(java.lang.String newMessageValue) {
        __message = newMessageValue;
        return this;
    }
    // End of code for source message from device Input
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>setInput</code> order from the <code>SetInput</code> action
     * defined in device Input was called.
     * 
     * 
     * <pre>
     * setInput(message as String);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetInput() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setInput".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setInput</code> order from the <code>SetInput</code> action
     * defined in device Input was called.
     * 
     * 
     * <pre>
     * setInput(message as String);
     * </pre>
     * @param message parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetInput(java.lang.String message) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setInput".equals(__action.poll())))
                    return false;
                if(!message.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
