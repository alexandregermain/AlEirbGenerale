package fr.inria.phoenix.diasuite.framework.device.cooker;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>on</code> of the device <code>Cooker</code>.
 *
 * <pre>
 * device Cooker extends Appliance , ElectricMeter {
 * }
 * </pre>
 */
public final class OnFromCooker implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>on</code>
     * 
     * @return the value of the source <code>on</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public OnFromCooker(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new CookerProxy(service, remoteServiceInfo);
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        OnFromCooker other = (OnFromCooker) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private CookerProxy sender;
    
    /**
     * Get the sender of the source <code>on</code>. I.e., the <code>Cooker</code> device that published the source.
     * 
     * @return A proxy to the <code>Cooker</code> that triggered the source
     */
    public CookerProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Cooker</code> that discloses subscription/unsubscription methods.
     */
    public class CookerProxy extends Proxy {
        private CookerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>on</code> from this <code>Cooker</code>.
         */
        public void subscribeOn() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "on");
        }
        
        /**
         * Unsubcribes from publication of source <code>on</code> from this <code>Cooker</code>.
         */
        public void unsubscribeOn() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "on");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
}
