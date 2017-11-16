package fr.inria.phoenix.diasuite.framework.device.activityreporter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>statisticReport</code> of the device <code>ActivityReporter</code>.
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
public final class StatisticReportFromActivityReporter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport value;
    
    /**
     * Get the value of the source <code>statisticReport</code>
     * 
     * @return the value of the source <code>statisticReport</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport value() {
        return value;
    }
    
    public StatisticReportFromActivityReporter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport value) {
        this.sender = new ActivityReporterProxy(service, remoteServiceInfo);
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
        StatisticReportFromActivityReporter other = (StatisticReportFromActivityReporter) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ActivityReporterProxy sender;
    
    /**
     * Get the sender of the source <code>statisticReport</code>. I.e., the <code>ActivityReporter</code> device that published the source.
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
         * Subcribes to publication of source <code>statisticReport</code> from this <code>ActivityReporter</code>.
         */
        public void subscribeStatisticReport() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "statisticReport");
        }
        
        /**
         * Unsubcribes from publication of source <code>statisticReport</code> from this <code>ActivityReporter</code>.
         */
        public void unsubscribeStatisticReport() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "statisticReport");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}
