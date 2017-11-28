package fr.inria.phoenix.diasuite.framework.device.storage;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>data</code> of the device <code>Storage</code>.
 *
 * <pre>
 * device Storage extends Service {
 * 	source data as String indexed by key as String;
 * 	action PutStringData;
 * }
 * </pre>
 */
public final class DataFromStorage implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>data</code>
     * 
     * @return the value of the source <code>data</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    private DataIndices indices;
    
    /**
     * Get the value of the indices of the source <code>data</code>
     * 
     * @return the value of the indices
     */
    public DataIndices indices() {
        return indices;
    }
    
    public DataFromStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, DataIndices indices) {
        this.sender = new StorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public DataFromStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value,
            java.lang.String key) {
        this.sender = new StorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new DataIndices(key);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((indices == null) ? 0 : indices.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataFromStorage other = (DataFromStorage) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (indices == null) {
            if (other.indices != null)
                return false;
        } else if (!indices.equals(other.indices))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private StorageProxy sender;
    
    /**
     * Get the sender of the source <code>data</code>. I.e., the <code>Storage</code> device that published the source.
     * 
     * @return A proxy to the <code>Storage</code> that triggered the source
     */
    public StorageProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Storage</code> that discloses subscription/unsubscription methods.
     */
    public class StorageProxy extends Proxy {
        private StorageProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>data</code> from this <code>Storage</code>.
         */
        public void subscribeData() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "data");
        }
        
        /**
         * Unsubcribes from publication of source <code>data</code> from this <code>Storage</code>.
         */
        public void unsubscribeData() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "data");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
