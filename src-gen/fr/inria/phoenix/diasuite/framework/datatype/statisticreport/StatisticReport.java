package fr.inria.phoenix.diasuite.framework.datatype.statisticreport;

import java.io.Serializable;

/**
 * <pre>
 * structure StatisticReport {
 * 	period as Period;
 * 	dailyActivityStats as DailyActivityStats [];
 * 	periodActivityStats as PeriodActivityStats [];
 * }
 * </pre>
 */
public class StatisticReport implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field period
    private fr.inria.phoenix.diasuite.framework.datatype.period.Period period;
    
    /**
     * Returns the value of the period field.
     * 
     * <pre>
     * period as Period
     * </pre>
     * @return the value of period
     */
    public fr.inria.phoenix.diasuite.framework.datatype.period.Period getPeriod() {
        return period;
    }
    
    /**
     * Set the value of the period field.
     * 
     * <pre>
     * period as Period
     * </pre>
     * @param period the new value of period
     */
    public void setPeriod(fr.inria.phoenix.diasuite.framework.datatype.period.Period period) {
        this.period = period;
    }
    // End of code for field period

    // Code for field dailyActivityStats
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> dailyActivityStats;
    
    /**
     * Returns the value of the dailyActivityStats field.
     * 
     * <pre>
     * dailyActivityStats as DailyActivityStats []
     * </pre>
     * @return the value of dailyActivityStats
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> getDailyActivityStats() {
        return dailyActivityStats;
    }
    
    /**
     * Set the value of the dailyActivityStats field.
     * 
     * <pre>
     * dailyActivityStats as DailyActivityStats []
     * </pre>
     * @param dailyActivityStats the new value of dailyActivityStats
     */
    public void setDailyActivityStats(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> dailyActivityStats) {
        this.dailyActivityStats = dailyActivityStats;
    }
    // End of code for field dailyActivityStats

    // Code for field periodActivityStats
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> periodActivityStats;
    
    /**
     * Returns the value of the periodActivityStats field.
     * 
     * <pre>
     * periodActivityStats as PeriodActivityStats []
     * </pre>
     * @return the value of periodActivityStats
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> getPeriodActivityStats() {
        return periodActivityStats;
    }
    
    /**
     * Set the value of the periodActivityStats field.
     * 
     * <pre>
     * periodActivityStats as PeriodActivityStats []
     * </pre>
     * @param periodActivityStats the new value of periodActivityStats
     */
    public void setPeriodActivityStats(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> periodActivityStats) {
        this.periodActivityStats = periodActivityStats;
    }
    // End of code for field periodActivityStats

    public StatisticReport() {
    }

    public StatisticReport(fr.inria.phoenix.diasuite.framework.datatype.period.Period period,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats> dailyActivityStats,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats> periodActivityStats) {
        this.period = period;
        this.dailyActivityStats = dailyActivityStats;
        this.periodActivityStats = periodActivityStats;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((period == null) ? 0 : period.hashCode());
        result = prime * result + ((dailyActivityStats == null) ? 0 : dailyActivityStats.hashCode());
        result = prime * result + ((periodActivityStats == null) ? 0 : periodActivityStats.hashCode());
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
        StatisticReport other = (StatisticReport) obj;
        if (period == null) {
            if (other.period != null)
                return false;
        } else if (!period.equals(other.period))
            return false;
        if (dailyActivityStats == null) {
            if (other.dailyActivityStats != null)
                return false;
        } else if (!dailyActivityStats.equals(other.dailyActivityStats))
            return false;
        if (periodActivityStats == null) {
            if (other.periodActivityStats != null)
                return false;
        } else if (!periodActivityStats.equals(other.periodActivityStats))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "StatisticReport [" + 
            "period=" + period +", " + 
            "dailyActivityStats=" + dailyActivityStats +", " + 
            "periodActivityStats=" + periodActivityStats +
        "]";
    }
}
