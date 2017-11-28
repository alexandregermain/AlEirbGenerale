package fr.inria.phoenix.diasuite.framework.datatype.dailyreport;

import java.io.Serializable;

/**
 * ------------------------------------------------------------
 * ActivityReporter					||
 * ------------------------------------------------------------
 * 
 * <pre>
 * structure DailyReport {
 * 	date as Date;
 * 	dailyActivities as DailyActivity [];
 * 	toiletPassings as Period [];
 * 	outdoorPeriods as Period [];
 * }
 * </pre>
 */
public class DailyReport implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field date
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date date;
    
    /**
     * Returns the value of the date field.
     * 
     * <pre>
     * date as Date
     * </pre>
     * @return the value of date
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
     * 
     * <pre>
     * date as Date
     * </pre>
     * @param date the new value of date
     */
    public void setDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.date = date;
    }
    // End of code for field date

    // Code for field dailyActivities
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity> dailyActivities;
    
    /**
     * Returns the value of the dailyActivities field.
     * 
     * <pre>
     * dailyActivities as DailyActivity []
     * </pre>
     * @return the value of dailyActivities
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity> getDailyActivities() {
        return dailyActivities;
    }
    
    /**
     * Set the value of the dailyActivities field.
     * 
     * <pre>
     * dailyActivities as DailyActivity []
     * </pre>
     * @param dailyActivities the new value of dailyActivities
     */
    public void setDailyActivities(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity> dailyActivities) {
        this.dailyActivities = dailyActivities;
    }
    // End of code for field dailyActivities

    // Code for field toiletPassings
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> toiletPassings;
    
    /**
     * Returns the value of the toiletPassings field.
     * 
     * <pre>
     * toiletPassings as Period []
     * </pre>
     * @return the value of toiletPassings
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> getToiletPassings() {
        return toiletPassings;
    }
    
    /**
     * Set the value of the toiletPassings field.
     * 
     * <pre>
     * toiletPassings as Period []
     * </pre>
     * @param toiletPassings the new value of toiletPassings
     */
    public void setToiletPassings(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> toiletPassings) {
        this.toiletPassings = toiletPassings;
    }
    // End of code for field toiletPassings

    // Code for field outdoorPeriods
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> outdoorPeriods;
    
    /**
     * Returns the value of the outdoorPeriods field.
     * 
     * <pre>
     * outdoorPeriods as Period []
     * </pre>
     * @return the value of outdoorPeriods
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> getOutdoorPeriods() {
        return outdoorPeriods;
    }
    
    /**
     * Set the value of the outdoorPeriods field.
     * 
     * <pre>
     * outdoorPeriods as Period []
     * </pre>
     * @param outdoorPeriods the new value of outdoorPeriods
     */
    public void setOutdoorPeriods(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> outdoorPeriods) {
        this.outdoorPeriods = outdoorPeriods;
    }
    // End of code for field outdoorPeriods

    public DailyReport() {
    }

    public DailyReport(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity> dailyActivities,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> toiletPassings,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.period.Period> outdoorPeriods) {
        this.date = date;
        this.dailyActivities = dailyActivities;
        this.toiletPassings = toiletPassings;
        this.outdoorPeriods = outdoorPeriods;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((dailyActivities == null) ? 0 : dailyActivities.hashCode());
        result = prime * result + ((toiletPassings == null) ? 0 : toiletPassings.hashCode());
        result = prime * result + ((outdoorPeriods == null) ? 0 : outdoorPeriods.hashCode());
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
        DailyReport other = (DailyReport) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (dailyActivities == null) {
            if (other.dailyActivities != null)
                return false;
        } else if (!dailyActivities.equals(other.dailyActivities))
            return false;
        if (toiletPassings == null) {
            if (other.toiletPassings != null)
                return false;
        } else if (!toiletPassings.equals(other.toiletPassings))
            return false;
        if (outdoorPeriods == null) {
            if (other.outdoorPeriods != null)
                return false;
        } else if (!outdoorPeriods.equals(other.outdoorPeriods))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DailyReport [" + 
            "date=" + date +", " + 
            "dailyActivities=" + dailyActivities +", " + 
            "toiletPassings=" + toiletPassings +", " + 
            "outdoorPeriods=" + outdoorPeriods +
        "]";
    }
}
