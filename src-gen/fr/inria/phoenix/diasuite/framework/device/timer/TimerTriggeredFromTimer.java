package fr.inria.phoenix.diasuite.framework.device.timer;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>timerTriggered</code> of the device <code>Timer</code>.
 *
 * <pre>
 * device Timer extends Service {
 * 	source timerTriggered as String indexed by timerId as String;
 * 	action ScheduleTimer;
 * }
 * </pre>
 */
public final class TimerTriggeredFromTimer implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>timerTriggered</code>
     * 
     * @return the value of the source <code>timerTriggered</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    private TimerTriggeredIndices indices;
    
    /**
     * Get the value of the indices of the source <code>timerTriggered</code>
     * 
     * @return the value of the indices
     */
    public TimerTriggeredIndices indices() {
        return indices;
    }
    
    public TimerTriggeredFromTimer(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, TimerTriggeredIndices indices) {
        this.sender = new TimerProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public TimerTriggeredFromTimer(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value,
            java.lang.String timerId) {
        this.sender = new TimerProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new TimerTriggeredIndices(timerId);
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
        TimerTriggeredFromTimer other = (TimerTriggeredFromTimer) obj;
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
    private TimerProxy sender;
    
    /**
     * Get the sender of the source <code>timerTriggered</code>. I.e., the <code>Timer</code> device that published the source.
     * 
     * @return A proxy to the <code>Timer</code> that triggered the source
     */
    public TimerProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Timer</code> that discloses subscription/unsubscription methods.
     */
    public class TimerProxy extends Proxy {
        private TimerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>timerTriggered</code> from this <code>Timer</code>.
         */
        public void subscribeTimerTriggered() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "timerTriggered");
        }
        
        /**
         * Unsubcribes from publication of source <code>timerTriggered</code> from this <code>Timer</code>.
         */
        public void unsubscribeTimerTriggered() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "timerTriggered");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
