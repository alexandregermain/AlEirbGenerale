package fr.inria.phoenix.diasuite.framework.device.android;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>battery</code> of the device <code>Android</code>.
 *
 * <pre>
 * device Android extends Device {
 * 	attribute type as String;
 * 	attribute version as Integer;
 * 	source battery as Battery;
 * 	source soundLevels as SoundLevel [];
 * 	source screenOn as Boolean;
 * 	source apps as AndroidApp [];
 * 	action ScreenAction;
 * 	action SoundAction;
 * 	action ActivityAction;
 * }
 * </pre>
 */
public final class BatteryFromAndroid implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.battery.Battery value;
    
    /**
     * Get the value of the source <code>battery</code>
     * 
     * @return the value of the source <code>battery</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.battery.Battery value() {
        return value;
    }
    
    public BatteryFromAndroid(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.battery.Battery value) {
        this.sender = new AndroidProxy(service, remoteServiceInfo);
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
        BatteryFromAndroid other = (BatteryFromAndroid) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private AndroidProxy sender;
    
    /**
     * Get the sender of the source <code>battery</code>. I.e., the <code>Android</code> device that published the source.
     * 
     * @return A proxy to the <code>Android</code> that triggered the source
     */
    public AndroidProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Android</code> that discloses subscription/unsubscription methods.
     */
    public class AndroidProxy extends Proxy {
        private AndroidProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>battery</code> from this <code>Android</code>.
         */
        public void subscribeBattery() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "battery");
        }
        
        /**
         * Unsubcribes from publication of source <code>battery</code> from this <code>Android</code>.
         */
        public void unsubscribeBattery() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "battery");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>type</code> attribute
         */
        public java.lang.String type() {
            return (java.lang.String) callGetValue("type");
        }
        
        /**
         * @return the value of the <code>version</code> attribute
         */
        public java.lang.Integer version() {
            return (java.lang.Integer) callGetValue("version");
        }
    }
}
