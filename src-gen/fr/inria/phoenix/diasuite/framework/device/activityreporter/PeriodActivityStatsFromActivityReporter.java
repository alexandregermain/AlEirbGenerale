package fr.inria.phoenix.diasuite.framework.device.activityreporter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>periodActivityStats</code> of the device <code>ActivityReporter</code>.
 *
 * <pre>
 * device ActivityReporter extends Service {
 * 	source dailyReport as DailyReport;
 * 	source statisticReport as StatisticReport;
 * 	source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
 * 	source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
 * 	action UpdateCurrentReport;
 * }
 * </pre>
 */
public final class PeriodActivityStatsFromActivityReporter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats value;
    
    /**
     * Get the value of the source <code>periodActivityStats</code>
     * 
     * @return the value of the source <code>periodActivityStats</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats value() {
        return value;
    }
    
    private PeriodActivityStatsIndices indices;
    
    /**
     * Get the value of the indices of the source <code>periodActivityStats</code>
     * 
     * @return the value of the indices
     */
    public PeriodActivityStatsIndices indices() {
        return indices;
    }
    
    public PeriodActivityStatsFromActivityReporter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats value, PeriodActivityStatsIndices indices) {
        this.sender = new ActivityReporterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public PeriodActivityStatsFromActivityReporter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats value,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
        this.sender = new ActivityReporterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new PeriodActivityStatsIndices(activity);
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
        PeriodActivityStatsFromActivityReporter other = (PeriodActivityStatsFromActivityReporter) obj;
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
    private ActivityReporterProxy sender;
    
    /**
     * Get the sender of the source <code>periodActivityStats</code>. I.e., the <code>ActivityReporter</code> device that published the source.
     * 
     * @return A proxy to the <code>ActivityReporter</code> that triggered the source
     */
    public ActivityReporterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>ActivityReporter</code> that discloses subscription/unsubscription methods.
     */
    public class ActivityReporterProxy extends Proxy {
        private ActivityReporterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>periodActivityStats</code> from this <code>ActivityReporter</code>.
         */
        public void subscribePeriodActivityStats() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "periodActivityStats");
        }
        
        /**
         * Unsubcribes from publication of source <code>periodActivityStats</code> from this <code>ActivityReporter</code>.
         */
        public void unsubscribePeriodActivityStats() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "periodActivityStats");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
