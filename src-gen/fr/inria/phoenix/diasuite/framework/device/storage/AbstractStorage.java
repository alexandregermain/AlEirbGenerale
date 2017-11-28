package fr.inria.phoenix.diasuite.framework.device.storage;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * --------
Storage
--------

<pre>
device Storage extends Service {
 * 	source data as String indexed by key as String;
 * 	action PutStringData;
 * }
</pre>
 */
public abstract class AbstractStorage extends Service {
    
    public AbstractStorage(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/Storage/", serviceConfiguration);
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
        if (orderName.equals("put")) {
            put((java.lang.String) args[0],
                    (java.lang.String) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("data")) {
            return getData((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
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
    
    // Code for source data from device Storage
    private java.util.HashMap<DataIndices, java.lang.String> _data = new java.util.HashMap<DataIndices, java.lang.String>();
    
    /**
     * Publish the value of source <code>data</code> from device <code>Storage</code>.
    
    <pre>
    source data as String indexed by key as String;
    </pre>
    @param newDataValue the new value for the source <code>data</code>
    @param key the value of the index <code>key</code>
     */
    protected void publishData(java.lang.String newDataValue,
            java.lang.String key) {
        DataIndices _indices_ = new DataIndices(key);
        _data.put(_indices_, newDataValue);
        getProcessor().publishValue(getOutProperties(), "data", newDataValue, key); 
    }
    
    /**
     * Returns the value of source <code>data</code> from device <code>Storage</code>.
    
    <pre>
    source data as String indexed by key as String;
    </pre>
    @param key the value of the index <code>key</code>
    @return the value of the source <code>data</code>
     */
    protected java.lang.String getData(java.lang.String key) throws Exception {
        return _data.get(new DataIndices(key));
    }
    // End of code for source data from device Storage
    
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
    
    /**
     * Implement this method to define the <code>put</code> order from the <code>PutStringData</code> action
     * defined in device Storage.
     * 
    
    <pre>
    put(pKey as String, pData as String);
    </pre>
     * @param pKey parameter 1 of the order.
     * @param pData parameter 2 of the order.
     */
    protected abstract void put(java.lang.String pKey,
            java.lang.String pData) throws Exception;
}
