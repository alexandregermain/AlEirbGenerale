package fr.inria.phoenix.diasuite.framework.device.activityreporter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>dailyActivityStats</code> of the device <code>ActivityReporter</code>.
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
public final class DailyActivityStatsFromActivityReporter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats value;
    
    /**
     * Get the value of the source <code>dailyActivityStats</code>
     * 
     * @return the value of the source <code>dailyActivityStats</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats value() {
        return value;
    }
    
    private DailyActivityStatsIndices indices;
    
    /**
     * Get the value of the indices of the source <code>dailyActivityStats</code>
     * 
     * @return the value of the indices
     */
    public DailyActivityStatsIndices indices() {
        return indices;
    }
    
    public DailyActivityStatsFromActivityReporter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats value, DailyActivityStatsIndices indices) {
        this.sender = new ActivityReporterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public DailyActivityStatsFromActivityReporter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats value,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        this.sender = new ActivityReporterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new DailyActivityStatsIndices(activity);
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
        DailyActivityStatsFromActivityReporter other = (DailyActivityStatsFromActivityReporter) obj;
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
     * Get the sender of the source <code>dailyActivityStats</code>. I.e., the <code>ActivityReporter</code> device that published the source.
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
         * Subcribes to publication of source <code>dailyActivityStats</code> from this <code>ActivityReporter</code>.
         */
        public void subscribeDailyActivityStats() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "dailyActivityStats");
        }
        
        /**
         * Unsubcribes from publication of source <code>dailyActivityStats</code> from this <code>ActivityReporter</code>.
         */
        public void unsubscribeDailyActivityStats() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "dailyActivityStats");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
