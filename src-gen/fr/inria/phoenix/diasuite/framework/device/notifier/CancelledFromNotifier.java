package fr.inria.phoenix.diasuite.framework.device.notifier;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>cancelled</code> of the device <code>Notifier</code>.
 *
 * <pre>
 * device Notifier extends HomeService {
 * 	source cancelled as Boolean indexed by id as String;
 * 	source expired as Boolean indexed by id as String;
 * 	source reply as Integer indexed by id as String;
 * 	action SendCriticalNotification;
 * 	action SendNonCriticalNotification;
 * }
 * </pre>
 */
public final class CancelledFromNotifier implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>cancelled</code>
     * 
     * @return the value of the source <code>cancelled</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    private CancelledIndices indices;
    
    /**
     * Get the value of the indices of the source <code>cancelled</code>
     * 
     * @return the value of the indices
     */
    public CancelledIndices indices() {
        return indices;
    }
    
    public CancelledFromNotifier(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value, CancelledIndices indices) {
        this.sender = new NotifierProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public CancelledFromNotifier(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value,
            java.lang.String id) {
        this.sender = new NotifierProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new CancelledIndices(id);
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
        CancelledFromNotifier other = (CancelledFromNotifier) obj;
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
    private NotifierProxy sender;
    
    /**
     * Get the sender of the source <code>cancelled</code>. I.e., the <code>Notifier</code> device that published the source.
     * 
     * @return A proxy to the <code>Notifier</code> that triggered the source
     */
    public NotifierProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Notifier</code> that discloses subscription/unsubscription methods.
     */
    public class NotifierProxy extends Proxy {
        private NotifierProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>cancelled</code> from this <code>Notifier</code>.
         */
        public void subscribeCancelled() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "cancelled");
        }
        
        /**
         * Unsubcribes from publication of source <code>cancelled</code> from this <code>Notifier</code>.
         */
        public void unsubscribeCancelled() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "cancelled");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
