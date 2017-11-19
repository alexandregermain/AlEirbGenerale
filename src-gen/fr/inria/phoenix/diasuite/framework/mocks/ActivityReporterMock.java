package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.activityreporter.AbstractActivityReporter;
import fr.inria.phoenix.diasuite.framework.device.activityreporter.PeriodActivityStatsIndices;
import fr.inria.phoenix.diasuite.framework.device.activityreporter.DailyActivityStatsIndices;

// @internal
public final class ActivityReporterMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractActivityReporter {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats getDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats result = __dailyActivityStats.get(new DailyActivityStatsIndices(activity));
            if(result == null)
                return super.getDailyActivityStats(activity);
            return result;
        }
        
        public void _publishDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue,
                fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
            publishDailyActivityStats(newDailyActivityStatsValue,
                activity);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport getDailyReport() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport result = __dailyReport;
            if(result == null)
                return super.getDailyReport();
            return result;
        }
        
        public void _publishDailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
            publishDailyReport(newDailyReportValue);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats getPeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats result = __periodActivityStats.get(new PeriodActivityStatsIndices(activity));
            if(result == null)
                return super.getPeriodActivityStats(activity);
            return result;
        }
        
        public void _publishPeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue,
                fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
            publishPeriodActivityStats(newPeriodActivityStatsValue,
                activity);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport getStatisticReport() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport result = __statisticReport;
            if(result == null)
                return super.getStatisticReport();
            return result;
        }
        
        public void _publishStatisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
            publishStatisticReport(newStatisticReportValue);
        }
        
        protected void addDailyActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addDailyActivityToCurrentReport");
                __action.add(dailyActivity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void addPeriodActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addPeriodActivityToCurrentReport");
                __action.add(periodActivity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void saveCurrentReport() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("saveCurrentReport");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    ActivityReporterMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public ActivityReporterMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source dailyActivityStats from device ActivityReporter
    /**
     * Publish the value of source <code>dailyActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
    </pre>
    @param newDailyActivityStatsValue the new value for the source <code>dailyActivityStats</code>
    @param activity the value of the index <code>activity</code>
    @return this for fluent interface
     */
    public ActivityReporterMock dailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        proxy._publishDailyActivityStats(newDailyActivityStatsValue,
            activity);
        return this;
    }
    
    private java.util.HashMap<DailyActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> __dailyActivityStats = new java.util.HashMap<DailyActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats>();
    /**
     * Set the value (without publication) of source <code>dailyActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
    </pre>
    @param newDailyActivityStatsValue the new value for the source <code>dailyActivityStats</code>
    @param activity the value of the index <code>activity</code>
    @return this for fluent interface
     */
    public ActivityReporterMock setDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        DailyActivityStatsIndices _indices_ = new DailyActivityStatsIndices(activity);
        __dailyActivityStats.put(_indices_, newDailyActivityStatsValue);
        return this;
    }
    // End of code for source dailyActivityStats from device ActivityReporter
    
    // Code for source dailyReport from device ActivityReporter
    /**
     * Publish the value of source <code>dailyReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyReport as DailyReport;
    </pre>
    @param newDailyReportValue the new value for the source <code>dailyReport</code>
    @return this for fluent interface
     */
    public ActivityReporterMock dailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
        proxy._publishDailyReport(newDailyReportValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport __dailyReport = null;
    /**
     * Set the value (without publication) of source <code>dailyReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source dailyReport as DailyReport;
    </pre>
    @param newDailyReportValue the new value for the source <code>dailyReport</code>
    @return this for fluent interface
     */
    public ActivityReporterMock setDailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
        __dailyReport = newDailyReportValue;
        return this;
    }
    // End of code for source dailyReport from device ActivityReporter
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public ActivityReporterMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public ActivityReporterMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source periodActivityStats from device ActivityReporter
    /**
     * Publish the value of source <code>periodActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
    </pre>
    @param newPeriodActivityStatsValue the new value for the source <code>periodActivityStats</code>
    @param activity the value of the index <code>activity</code>
    @return this for fluent interface
     */
    public ActivityReporterMock periodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
        proxy._publishPeriodActivityStats(newPeriodActivityStatsValue,
            activity);
        return this;
    }
    
    private java.util.HashMap<PeriodActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> __periodActivityStats = new java.util.HashMap<PeriodActivityStatsIndices, fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats>();
    /**
     * Set the value (without publication) of source <code>periodActivityStats</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
    </pre>
    @param newPeriodActivityStatsValue the new value for the source <code>periodActivityStats</code>
    @param activity the value of the index <code>activity</code>
    @return this for fluent interface
     */
    public ActivityReporterMock setPeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
        PeriodActivityStatsIndices _indices_ = new PeriodActivityStatsIndices(activity);
        __periodActivityStats.put(_indices_, newPeriodActivityStatsValue);
        return this;
    }
    // End of code for source periodActivityStats from device ActivityReporter
    
    // Code for source statisticReport from device ActivityReporter
    /**
     * Publish the value of source <code>statisticReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source statisticReport as StatisticReport;
    </pre>
    @param newStatisticReportValue the new value for the source <code>statisticReport</code>
    @return this for fluent interface
     */
    public ActivityReporterMock statisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
        proxy._publishStatisticReport(newStatisticReportValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport __statisticReport = null;
    /**
     * Set the value (without publication) of source <code>statisticReport</code> from device <code>ActivityReporter</code>.
    
    <pre>
    source statisticReport as StatisticReport;
    </pre>
    @param newStatisticReportValue the new value for the source <code>statisticReport</code>
    @return this for fluent interface
     */
    public ActivityReporterMock setStatisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
        __statisticReport = newStatisticReportValue;
        return this;
    }
    // End of code for source statisticReport from device ActivityReporter
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addDailyActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter was called.
     * 
    
    <pre>
    addDailyActivityToCurrentReport(dailyActivity as DailyActivity);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddDailyActivityToCurrentReport() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addDailyActivityToCurrentReport".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addDailyActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter was called.
     * 
    
    <pre>
    addDailyActivityToCurrentReport(dailyActivity as DailyActivity);
    </pre>
     * @param dailyActivity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddDailyActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addDailyActivityToCurrentReport".equals(__action.poll())))
                    return false;
                if(!dailyActivity.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>addPeriodActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter was called.
     * 
    
    <pre>
    addPeriodActivityToCurrentReport(periodActivity as PeriodActivity);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddPeriodActivityToCurrentReport() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPeriodActivityToCurrentReport".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addPeriodActivityToCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter was called.
     * 
    
    <pre>
    addPeriodActivityToCurrentReport(periodActivity as PeriodActivity);
    </pre>
     * @param periodActivity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddPeriodActivityToCurrentReport(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPeriodActivityToCurrentReport".equals(__action.poll())))
                    return false;
                if(!periodActivity.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>saveCurrentReport</code> order from the <code>UpdateCurrentReport</code> action
     * defined in device ActivityReporter was called.
     * 
    
    <pre>
    saveCurrentReport();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectSaveCurrentReport() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("saveCurrentReport".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
