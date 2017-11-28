package fr.inria.phoenix.diasuite.framework.device.activityreporter;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device ActivityReporter extends Service {
 * 	source dailyReport as DailyReport;
 * 	source statisticReport as StatisticReport;
 * 	source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
 * 	source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
 * 	action UpdateCurrentReport;
 * }
</pre>
 */
public abstract class AbstractActivityReporter extends Service {
    
    public AbstractActivityReporter(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/ActivityReporter/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("addDailyActivityToCurrentReport")) {
            addDailyActivityToCurrentReport((fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity) args[0]);
            return null;
        }
        if (orderName.equals("addPeriodActivityToCurrentReport")) {
            addPeriodActivityToCurrentReport((fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity) args[0]);
            return null;
        }
        if (orderName.equals("saveCurrentReport")) {
            saveCurrentReport();
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("dailyActivityStats")) {
            return getDailyActivityStats((fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName) args[0]);
        }
        if (orderName.equals("dailyReport")) {
            return getDailyReport();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("periodActivityStats")) {
            return getPeriodActivityStats((fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName) args[0]);
        }
        if (orderName.equals("statisticReport")) {
            return getStatisticReport();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source dailyActivityStats from device ActivityReporter
    private java.util.HashMap<DailyActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> _dailyActivityStats = new java.util.HashMap<DailyActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats>();
    
    /**
     * Publish the value of source <code>dailyActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
    </pre>
    @param newDailyActivityStatsValue the new value for the source <code>dailyActivityStats</code>
    @param activity the value of the index <code>activity</code>
     */
    protected void publishDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        DailyActivityStatsIndices _indices_ = new DailyActivityStatsIndices(activity);
        _dailyActivityStats.put(_indices_, newDailyActivityStatsValue);
        getProcessor().publishValue(getOutProperties(), "dailyActivityStats", newDailyActivityStatsValue, activity); 
    }
    
    /**
     * Returns the value of source <code>dailyActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
    </pre>
    @param activity the value of the index <code>activity</code>
    @return the value of the source <code>dailyActivityStats</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats getDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception {
        return _dailyActivityStats.get(new DailyActivityStatsIndices(activity));
    }
    // End of code for source dailyActivityStats from device ActivityReporter
    
    // Code for source dailyReport from device ActivityReporter
    private fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport _dailyReport;
    
    /**
     * Publish the value of source <code>dailyReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyReport as DailyReport;
    </pre>
    @param newDailyReportValue the new value for the source <code>dailyReport</code>
     */
    protected void publishDailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
        _dailyReport = newDailyReportValue;
        getProcessor().publishValue(getOutProperties(), "dailyReport", newDailyReportValue); 
    }
    
    /**
     * Returns the value of source <code>dailyReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyReport as DailyReport;
    </pre>
    @return the value of the source <code>dailyReport</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport getDailyReport() throws Exception {
        return _dailyReport;
    }
    // End of code for source dailyReport from device ActivityReporter
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source periodActivityStats from device ActivityReporter
    private java.util.HashMap<PeriodActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> _periodActivityStats = new java.util.HashMap<PeriodActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats>();
    
    /**
     * Publish the value of source <code>periodActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
    </pre>
    @param newPeriodActivityStatsValue the new value for the source <code>periodActivityStats</code>
    @param activity the value of the index <code>activity</code>
     */
    protected void publishPeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
        PeriodActivityStatsIndices _indices_ = new PeriodActivityStatsIndices(activity);
        _periodActivityStats.put(_indices_, newPeriodActivityStatsValue);
        getProcessor().publishValue(getOutProperties(), "periodActivityStats", newPeriodActivityStatsValue, activity); 
    }
    
    /**
     * Returns the value of source <code>periodActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
    </pre>
    @param activity the value of the index <code>activity</code>
    @return the value of the source <code>periodActivityStats</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats getPeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) throws Exception {
        return _periodActivityStats.get(new PeriodActivityStatsIndices(activity));
    }
    // End of code for source periodActivityStats from device ActivityReporter
    
    // Code for source statisticReport from device ActivityReporter
    private fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport _statisticReport;
    
    /**
     * Publish the value of source <code>statisticReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source statisticReport as StatisticReport;
    </pre>
    @param newStatisticReportValue the new value for the source <code>statisticReport</code>
     */
    protected void publishStatisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
        _statisticReport = newStatisticReportValue;
        getProcessor().publishValue(getOutProperties(), "statisticReport", newStatisticReportValue); 
    }
    
    /**
     * Returns the value of source <code>statisticReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source statisticReport as StatisticReport;
    </pre>
    @return the value of the source <code>statisticReport</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport getStatisticReport() throws Exception {
        return _statisticReport;
    }
    // End of code for source statisticReport from device ActivityReporter
    
    /**
     * Implement this method to define the <code>addDailyActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter.
     * 
    
    <pre>
    addDailyActivityToCurrentReport(dailyActivity as DailyActivity);
    </pre>
     * @param dailyActivity parameter 1 of the order.
     */
    protected abstract void addDailyActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivity) throws Exception;
    
    /**
     * Implement this method to define the <code>addPeriodActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter.
     * 
    
    <pre>
    addPeriodActivityToCurrentReport(periodActivity as PeriodActivity);
    </pre>
     * @param periodActivity parameter 1 of the order.
     */
    protected abstract void addPeriodActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivity) throws Exception;
    
    /**
     * Implement this method to define the <code>saveCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter.
     * 
    
    <pre>
    saveCurrentReport();
    </pre>
     */
    protected abstract void saveCurrentReport() throws Exception;
}
