package fr.inria.phoenix.diasuite.framework.device.input;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>message</code> of the device <code>Input</code>.
 *
 * <pre>
 * device Input extends PhysicalDevice {
 * 	source message as String;
 * 	action SetInput;
 * }
 * </pre>
 */
public final class MessageFromInput implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>message</code>
     * 
     * @return the value of the source <code>message</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    public MessageFromInput(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value) {
        this.sender = new InputProxy(service, remoteServiceInfo);
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
        MessageFromInput other = (MessageFromInput) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private InputProxy sender;
    
    /**
     * Get the sender of the source <code>message</code>. I.e., the <code>Input</code> device that published the source.
     * 
     * @return A proxy to the <code>Input</code> that triggered the source
     */
    public InputProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Input</code> that discloses subscription/unsubscription methods.
     */
    public class InputProxy extends Proxy {
        private InputProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>message</code> from this <code>Input</code>.
         */
        public void subscribeMessage() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "message");
        }
        
        /**
         * Unsubcribes from publication of source <code>message</code> from this <code>Input</code>.
         */
        public void unsubscribeMessage() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "message");
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
