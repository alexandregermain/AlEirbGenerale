package fr.inria.phoenix.diasuite.framework.device.inactivitysensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>inactivityLevel</code> of the device <code>InactivitySensor</code>.
 *
 * <pre>
 * device InactivitySensor extends SoftwareSensor {
 * 	source inactivityLevel as Float;
 * 	source lastInteraction as Interaction;
 * 	action UpdateInactivityLevel;
 * }
 * </pre>
 */
public final class InactivityLevelFromInactivitySensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Float value;
    
    /**
     * Get the value of the source <code>inactivityLevel</code>
     * 
     * @return the value of the source <code>inactivityLevel</code>
     */
    public java.lang.Float value() {
        return value;
    }
    
    public InactivityLevelFromInactivitySensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value) {
        this.sender = new InactivitySensorProxy(service, remoteServiceInfo);
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
        InactivityLevelFromInactivitySensor other = (InactivityLevelFromInactivitySensor) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private InactivitySensorProxy sender;
    
    /**
     * Get the sender of the source <code>inactivityLevel</code>. I.e., the <code>InactivitySensor</code> device that published the source.
     * 
     * @return A proxy to the <code>InactivitySensor</code> that triggered the source
     */
    public InactivitySensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>InactivitySensor</code> that discloses subscription/unsubscription methods.
     */
    public class InactivitySensorProxy extends Proxy {
        private InactivitySensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>inactivityLevel</code> from this <code>InactivitySensor</code>.
         */
        public void subscribeInactivityLevel() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "inactivityLevel");
        }
        
        /**
         * Unsubcribes from publication of source <code>inactivityLevel</code> from this <code>InactivitySensor</code>.
         */
        public void unsubscribeInactivityLevel() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "inactivityLevel");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
