package fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats;

import java.io.Serializable;

/**
 * <pre>
 * structure DailyActivityStats {
 * 	activity as DailyActivityName;
 * 	successes as Integer;
 * 	failures as Integer;
 * 	meanScore as Float;
 * }
 * </pre>
 */
public class DailyActivityStats implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field activity
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity;
    
    /**
     * Returns the value of the activity field.
     * 
     * <pre>
     * activity as DailyActivityName
     * </pre>
     * @return the value of activity
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getActivity() {
        return activity;
    }
    
    /**
     * Set the value of the activity field.
     * 
     * <pre>
     * activity as DailyActivityName
     * </pre>
     * @param activity the new value of activity
     */
    public void setActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        this.activity = activity;
    }
    // End of code for field activity

    // Code for field successes
    private java.lang.Integer successes;
    
    /**
     * Returns the value of the successes field.
     * 
     * <pre>
     * successes as Integer
     * </pre>
     * @return the value of successes
     */
    public java.lang.Integer getSuccesses() {
        return successes;
    }
    
    /**
     * Set the value of the successes field.
     * 
     * <pre>
     * successes as Integer
     * </pre>
     * @param successes the new value of successes
     */
    public void setSuccesses(java.lang.Integer successes) {
        this.successes = successes;
    }
    // End of code for field successes

    // Code for field failures
    private java.lang.Integer failures;
    
    /**
     * Returns the value of the failures field.
     * 
     * <pre>
     * failures as Integer
     * </pre>
     * @return the value of failures
     */
    public java.lang.Integer getFailures() {
        return failures;
    }
    
    /**
     * Set the value of the failures field.
     * 
     * <pre>
     * failures as Integer
     * </pre>
     * @param failures the new value of failures
     */
    public void setFailures(java.lang.Integer failures) {
        this.failures = failures;
    }
    // End of code for field failures

    // Code for field meanScore
    private java.lang.Float meanScore;
    
    /**
     * Returns the value of the meanScore field.
     * 
     * <pre>
     * meanScore as Float
     * </pre>
     * @return the value of meanScore
     */
    public java.lang.Float getMeanScore() {
        return meanScore;
    }
    
    /**
     * Set the value of the meanScore field.
     * 
     * <pre>
     * meanScore as Float
     * </pre>
     * @param meanScore the new value of meanScore
     */
    public void setMeanScore(java.lang.Float meanScore) {
        this.meanScore = meanScore;
    }
    // End of code for field meanScore

    public DailyActivityStats() {
    }

    public DailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity,
            java.lang.Integer successes,
            java.lang.Integer failures,
            java.lang.Float meanScore) {
        this.activity = activity;
        this.successes = successes;
        this.failures = failures;
        this.meanScore = meanScore;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activity == null) ? 0 : activity.hashCode());
        result = prime * result + ((successes == null) ? 0 : successes.hashCode());
        result = prime * result + ((failures == null) ? 0 : failures.hashCode());
        result = prime * result + ((meanScore == null) ? 0 : meanScore.hashCode());
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
        DailyActivityStats other = (DailyActivityStats) obj;
        if (activity == null) {
            if (other.activity != null)
                return false;
        } else if (!activity.equals(other.activity))
            return false;
        if (successes == null) {
            if (other.successes != null)
                return false;
        } else if (!successes.equals(other.successes))
            return false;
        if (failures == null) {
            if (other.failures != null)
                return false;
        } else if (!failures.equals(other.failures))
            return false;
        if (meanScore == null) {
            if (other.meanScore != null)
                return false;
        } else if (!meanScore.equals(other.meanScore))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DailyActivityStats [" + 
            "activity=" + activity +", " + 
            "successes=" + successes +", " + 
            "failures=" + failures +", " + 
            "meanScore=" + meanScore +
        "]";
    }
}
