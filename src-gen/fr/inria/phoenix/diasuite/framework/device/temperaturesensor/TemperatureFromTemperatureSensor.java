package fr.inria.phoenix.diasuite.framework.device.temperaturesensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>temperature</code> of the device <code>TemperatureSensor</code>.
 *
 * <pre>
 * device TemperatureSensor extends Sensor {
 * 	source temperature as Float indexed by unit as TemperatureUnit;
 * }
 * </pre>
 */
public final class TemperatureFromTemperatureSensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Float value;
    
    /**
     * Get the value of the source <code>temperature</code>
     * 
     * @return the value of the source <code>temperature</code>
     */
    public java.lang.Float value() {
        return value;
    }
    
    private TemperatureIndices indices;
    
    /**
     * Get the value of the indices of the source <code>temperature</code>
     * 
     * @return the value of the indices
     */
    public TemperatureIndices indices() {
        return indices;
    }
    
    public TemperatureFromTemperatureSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value, TemperatureIndices indices) {
        this.sender = new TemperatureSensorProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public TemperatureFromTemperatureSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        this.sender = new TemperatureSensorProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new TemperatureIndices(unit);
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
        TemperatureFromTemperatureSensor other = (TemperatureFromTemperatureSensor) obj;
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
    private TemperatureSensorProxy sender;
    
    /**
     * Get the sender of the source <code>temperature</code>. I.e., the <code>TemperatureSensor</code> device that published the source.
     * 
     * @return A proxy to the <code>TemperatureSensor</code> that triggered the source
     */
    public TemperatureSensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TemperatureSensor</code> that discloses subscription/unsubscription methods.
     */
    public class TemperatureSensorProxy extends Proxy {
        private TemperatureSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>temperature</code> from this <code>TemperatureSensor</code>.
         */
        public void subscribeTemperature() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "temperature");
        }
        
        /**
         * Unsubcribes from publication of source <code>temperature</code> from this <code>TemperatureSensor</code>.
         */
        public void unsubscribeTemperature() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "temperature");
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
