package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.storage.AbstractStorage;
import fr.inria.phoenix.diasuite.framework.device.storage.DataIndices;

// @internal
public final class StorageMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractStorage {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.lang.String getData(java.lang.String key) throws Exception {
            java.lang.String result = __data.get(new DataIndices(key));
            if(result == null)
                return super.getData(key);
            return result;
        }
        
        public void _publishData(java.lang.String newDataValue,
                java.lang.String key) {
            publishData(newDataValue,
                key);
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
        
        protected void put(java.lang.String pKey,
                java.lang.String pData) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("put");
                __action.add(pKey);
                __action.add(pData);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    StorageMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
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
    public StorageMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source data from device Storage
    /**
     * Publish the value of source <code>data</code> from device <code>Storage</code>.
    
    <pre>
    source data as String indexed by key as String;
    </pre>
    @param newDataValue the new value for the source <code>data</code>
    @param key the value of the index <code>key</code>
    @return this for fluent interface
     */
    public StorageMock data(java.lang.String newDataValue,
            java.lang.String key) {
        proxy._publishData(newDataValue,
            key);
        return this;
    }
    
    private java.util.HashMap<DataIndices, java.lang.String> __data = new java.util.HashMap<DataIndices, java.lang.String>();
    /**
     * Set the value (without publication) of source <code>data</code> from device <code>Storage</code>.
    
    <pre>
    source data as String indexed by key as String;
    </pre>
    @param newDataValue the new value for the source <code>data</code>
    @param key the value of the index <code>key</code>
    @return this for fluent interface
     */
    public StorageMock setData(java.lang.String newDataValue,
            java.lang.String key) {
        DataIndices _indices_ = new DataIndices(key);
        __data.put(_indices_, newDataValue);
        return this;
    }
    // End of code for source data from device Storage
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public StorageMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public StorageMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>put</code> order from the <code>PutStringData</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    put(pKey as String, pData as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPut() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("put".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>put</code> order from the <code>PutStringData</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    put(pKey as String, pData as String);
    </pre>
     * @param pKey parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPut(java.lang.String pKey) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("put".equals(__action.poll())))
                    return false;
                if(!pKey.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>put</code> order from the <code>PutStringData</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    put(pKey as String, pData as String);
    </pre>
     * @param pKey parameter 1 of the order.
     * @param pData parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectPut(java.lang.String pKey,
            java.lang.String pData) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("put".equals(__action.poll())))
                    return false;
                if(!pKey.equals(__action.poll()))
                    return false;
                if(!pData.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
