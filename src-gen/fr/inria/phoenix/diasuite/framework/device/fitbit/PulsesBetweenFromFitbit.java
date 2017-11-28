package fr.inria.phoenix.diasuite.framework.device.fitbit;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>pulsesBetween</code> of the device <code>Fitbit</code>.
 *
 * <pre>
 * device Fitbit extends Device {
 * 	source dailyPulses as PulseRecord [] indexed by day as Date;
 * 	source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
 * 	source dailySteps as Integer indexed by day as Date;
 * 	source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
 * 	source dailyActivities as FitbitActivity [] indexed by day as Date;
 * 	source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
 * 	source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
 * 	source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
 * 	source alarm as FitbitAlarm indexed by alarmId as String;
 * 	action ScheduleAlarm;
 * }
 * </pre>
 */
public final class PulsesBetweenFromFitbit implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> value;
    
    /**
     * Get the value of the source <code>pulsesBetween</code>
     * 
     * @return the value of the source <code>pulsesBetween</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> value() {
        return value;
    }
    
    private PulsesBetweenIndices indices;
    
    /**
     * Get the value of the indices of the source <code>pulsesBetween</code>
     * 
     * @return the value of the indices
     */
    public PulsesBetweenIndices indices() {
        return indices;
    }
    
    public PulsesBetweenFromFitbit(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> value, PulsesBetweenIndices indices) {
        this.sender = new FitbitProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public PulsesBetweenFromFitbit(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> value,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        this.sender = new FitbitProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new PulsesBetweenIndices(startDate, endDate);
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
        PulsesBetweenFromFitbit other = (PulsesBetweenFromFitbit) obj;
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
    private FitbitProxy sender;
    
    /**
     * Get the sender of the source <code>pulsesBetween</code>. I.e., the <code>Fitbit</code> device that published the source.
     * 
     * @return A proxy to the <code>Fitbit</code> that triggered the source
     */
    public FitbitProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Fitbit</code> that discloses subscription/unsubscription methods.
     */
    public class FitbitProxy extends Proxy {
        private FitbitProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>pulsesBetween</code> from this <code>Fitbit</code>.
         */
        public void subscribePulsesBetween() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "pulsesBetween");
        }
        
        /**
         * Unsubcribes from publication of source <code>pulsesBetween</code> from this <code>Fitbit</code>.
         */
        public void unsubscribePulsesBetween() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "pulsesBetween");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
