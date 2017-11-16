package fr.inria.phoenix.diasuite.framework.device.routinescheduler;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>stopMonitoring</code> of the device <code>RoutineScheduler</code>.
 *
 * <pre>
 * device RoutineScheduler extends Service {
 * 	source currentTime as DayTime;
 * 	source startMonitoring as DailyActivityName;
 * 	source stopMonitoring as DailyActivityName;
 * 	action UpdateDayTime;
 * 	action UpdateRoutines;
 * }
 * </pre>
 */
public final class StopMonitoringFromRoutineScheduler implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName value;
    
    /**
     * Get the value of the source <code>stopMonitoring</code>
     * 
     * @return the value of the source <code>stopMonitoring</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName value() {
        return value;
    }
    
    public StopMonitoringFromRoutineScheduler(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName value) {
        this.sender = new RoutineSchedulerProxy(service, remoteServiceInfo);
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
        StopMonitoringFromRoutineScheduler other = (StopMonitoringFromRoutineScheduler) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private RoutineSchedulerProxy sender;
    
    /**
     * Get the sender of the source <code>stopMonitoring</code>. I.e., the <code>RoutineScheduler</code> device that published the source.
     * 
     * @return A proxy to the <code>RoutineScheduler</code> that triggered the source
     */
    public RoutineSchedulerProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>RoutineScheduler</code> that discloses subscription/unsubscription methods.
     */
    public class RoutineSchedulerProxy extends Proxy {
        private RoutineSchedulerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>stopMonitoring</code> from this <code>RoutineScheduler</code>.
         */
        public void subscribeStopMonitoring() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "stopMonitoring");
        }
        
        /**
         * Unsubcribes from publication of source <code>stopMonitoring</code> from this <code>RoutineScheduler</code>.
         */
        public void unsubscribeStopMonitoring() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "stopMonitoring");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
