package fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats;

import java.io.Serializable;

/**
 * <pre>
 * structure PeriodActivityStats {
 * 	activity as PeriodActivityName;
 * 	occurences as Integer;
 * 	dailyMean as Float;
 * 	durationMean as Float;
 * }
 * </pre>
 */
public class PeriodActivityStats implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field activity
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity;
    
    /**
     * Returns the value of the activity field.
     * 
     * <pre>
     * activity as PeriodActivityName
     * </pre>
     * @return the value of activity
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName getActivity() {
        return activity;
    }
    
    /**
     * Set the value of the activity field.
     * 
     * <pre>
     * activity as PeriodActivityName
     * </pre>
     * @param activity the new value of activity
     */
    public void setActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity) {
        this.activity = activity;
    }
    // End of code for field activity

    // Code for field occurences
    private java.lang.Integer occurences;
    
    /**
     * Returns the value of the occurences field.
     * 
     * <pre>
     * occurences as Integer
     * </pre>
     * @return the value of occurences
     */
    public java.lang.Integer getOccurences() {
        return occurences;
    }
    
    /**
     * Set the value of the occurences field.
     * 
     * <pre>
     * occurences as Integer
     * </pre>
     * @param occurences the new value of occurences
     */
    public void setOccurences(java.lang.Integer occurences) {
        this.occurences = occurences;
    }
    // End of code for field occurences

    // Code for field dailyMean
    private java.lang.Float dailyMean;
    
    /**
     * Returns the value of the dailyMean field.
     * 
     * <pre>
     * dailyMean as Float
     * </pre>
     * @return the value of dailyMean
     */
    public java.lang.Float getDailyMean() {
        return dailyMean;
    }
    
    /**
     * Set the value of the dailyMean field.
     * 
     * <pre>
     * dailyMean as Float
     * </pre>
     * @param dailyMean the new value of dailyMean
     */
    public void setDailyMean(java.lang.Float dailyMean) {
        this.dailyMean = dailyMean;
    }
    // End of code for field dailyMean

    // Code for field durationMean
    private java.lang.Float durationMean;
    
    /**
     * Returns the value of the durationMean field.
     * 
     * <pre>
     * durationMean as Float
     * </pre>
     * @return the value of durationMean
     */
    public java.lang.Float getDurationMean() {
        return durationMean;
    }
    
    /**
     * Set the value of the durationMean field.
     * 
     * <pre>
     * durationMean as Float
     * </pre>
     * @param durationMean the new value of durationMean
     */
    public void setDurationMean(java.lang.Float durationMean) {
        this.durationMean = durationMean;
    }
    // End of code for field durationMean

    public PeriodActivityStats() {
    }

    public PeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName activity,
            java.lang.Integer occurences,
            java.lang.Float dailyMean,
            java.lang.Float durationMean) {
        this.activity = activity;
        this.occurences = occurences;
        this.dailyMean = dailyMean;
        this.durationMean = durationMean;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activity == null) ? 0 : activity.hashCode());
        result = prime * result + ((occurences == null) ? 0 : occurences.hashCode());
        result = prime * result + ((dailyMean == null) ? 0 : dailyMean.hashCode());
        result = prime * result + ((durationMean == null) ? 0 : durationMean.hashCode());
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
        PeriodActivityStats other = (PeriodActivityStats) obj;
        if (activity == null) {
            if (other.activity != null)
                return false;
        } else if (!activity.equals(other.activity))
            return false;
        if (occurences == null) {
            if (other.occurences != null)
                return false;
        } else if (!occurences.equals(other.occurences))
            return false;
        if (dailyMean == null) {
            if (other.dailyMean != null)
                return false;
        } else if (!dailyMean.equals(other.dailyMean))
            return false;
        if (durationMean == null) {
            if (other.durationMean != null)
                return false;
        } else if (!durationMean.equals(other.durationMean))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PeriodActivityStats [" + 
            "activity=" + activity +", " + 
            "occurences=" + occurences +", " + 
            "dailyMean=" + dailyMean +", " + 
            "durationMean=" + durationMean +
        "]";
    }
}
