package fr.inria.phoenix.diasuite.framework.datatype.sleepperiod;

import java.io.Serializable;

/**
 * <pre>
structure SleepPeriod {
 * 	efficiency as Float;
 * 	duration as Integer;
 * 	timeToFallAsleep as Integer;
 * 	timeAsleep as Integer;
 * 	timeAwake as Integer;
 * 	timeAfterWakeup as Integer;
 * 	timeInBed as Integer;
 * }
</pre>
 */
public class SleepPeriod implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field efficiency
    private java.lang.Float efficiency;
    
    /**
     * Returns the value of the efficiency field.
    
    <pre>
    efficiency as Float
    </pre>
    @return the value of efficiency
     */
    public java.lang.Float getEfficiency() {
        return efficiency;
    }
    
    /**
     * Set the value of the efficiency field.
    
    <pre>
    efficiency as Float
    </pre>
    @param efficiency the new value of efficiency
     */
    public void setEfficiency(java.lang.Float efficiency) {
        this.efficiency = efficiency;
    }
    // End of code for field efficiency

    // Code for field duration
    private java.lang.Integer duration;
    
    /**
     * Returns the value of the duration field.
    
    <pre>
    duration as Integer
    </pre>
    @return the value of duration
     */
    public java.lang.Integer getDuration() {
        return duration;
    }
    
    /**
     * Set the value of the duration field.
    
    <pre>
    duration as Integer
    </pre>
    @param duration the new value of duration
     */
    public void setDuration(java.lang.Integer duration) {
        this.duration = duration;
    }
    // End of code for field duration

    // Code for field timeToFallAsleep
    private java.lang.Integer timeToFallAsleep;
    
    /**
     * Returns the value of the timeToFallAsleep field.
    
    <pre>
    timeToFallAsleep as Integer
    </pre>
    @return the value of timeToFallAsleep
     */
    public java.lang.Integer getTimeToFallAsleep() {
        return timeToFallAsleep;
    }
    
    /**
     * Set the value of the timeToFallAsleep field.
    
    <pre>
    timeToFallAsleep as Integer
    </pre>
    @param timeToFallAsleep the new value of timeToFallAsleep
     */
    public void setTimeToFallAsleep(java.lang.Integer timeToFallAsleep) {
        this.timeToFallAsleep = timeToFallAsleep;
    }
    // End of code for field timeToFallAsleep

    // Code for field timeAsleep
    private java.lang.Integer timeAsleep;
    
    /**
     * Returns the value of the timeAsleep field.
    
    <pre>
    timeAsleep as Integer
    </pre>
    @return the value of timeAsleep
     */
    public java.lang.Integer getTimeAsleep() {
        return timeAsleep;
    }
    
    /**
     * Set the value of the timeAsleep field.
    
    <pre>
    timeAsleep as Integer
    </pre>
    @param timeAsleep the new value of timeAsleep
     */
    public void setTimeAsleep(java.lang.Integer timeAsleep) {
        this.timeAsleep = timeAsleep;
    }
    // End of code for field timeAsleep

    // Code for field timeAwake
    private java.lang.Integer timeAwake;
    
    /**
     * Returns the value of the timeAwake field.
    
    <pre>
    timeAwake as Integer
    </pre>
    @return the value of timeAwake
     */
    public java.lang.Integer getTimeAwake() {
        return timeAwake;
    }
    
    /**
     * Set the value of the timeAwake field.
    
    <pre>
    timeAwake as Integer
    </pre>
    @param timeAwake the new value of timeAwake
     */
    public void setTimeAwake(java.lang.Integer timeAwake) {
        this.timeAwake = timeAwake;
    }
    // End of code for field timeAwake

    // Code for field timeAfterWakeup
    private java.lang.Integer timeAfterWakeup;
    
    /**
     * Returns the value of the timeAfterWakeup field.
    
    <pre>
    timeAfterWakeup as Integer
    </pre>
    @return the value of timeAfterWakeup
     */
    public java.lang.Integer getTimeAfterWakeup() {
        return timeAfterWakeup;
    }
    
    /**
     * Set the value of the timeAfterWakeup field.
    
    <pre>
    timeAfterWakeup as Integer
    </pre>
    @param timeAfterWakeup the new value of timeAfterWakeup
     */
    public void setTimeAfterWakeup(java.lang.Integer timeAfterWakeup) {
        this.timeAfterWakeup = timeAfterWakeup;
    }
    // End of code for field timeAfterWakeup

    // Code for field timeInBed
    private java.lang.Integer timeInBed;
    
    /**
     * Returns the value of the timeInBed field.
    
    <pre>
    timeInBed as Integer
    </pre>
    @return the value of timeInBed
     */
    public java.lang.Integer getTimeInBed() {
        return timeInBed;
    }
    
    /**
     * Set the value of the timeInBed field.
    
    <pre>
    timeInBed as Integer
    </pre>
    @param timeInBed the new value of timeInBed
     */
    public void setTimeInBed(java.lang.Integer timeInBed) {
        this.timeInBed = timeInBed;
    }
    // End of code for field timeInBed

    public SleepPeriod() {
    }

    public SleepPeriod(java.lang.Float efficiency,
            java.lang.Integer duration,
            java.lang.Integer timeToFallAsleep,
            java.lang.Integer timeAsleep,
            java.lang.Integer timeAwake,
            java.lang.Integer timeAfterWakeup,
            java.lang.Integer timeInBed) {
        this.efficiency = efficiency;
        this.duration = duration;
        this.timeToFallAsleep = timeToFallAsleep;
        this.timeAsleep = timeAsleep;
        this.timeAwake = timeAwake;
        this.timeAfterWakeup = timeAfterWakeup;
        this.timeInBed = timeInBed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((efficiency == null) ? 0 : efficiency.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((timeToFallAsleep == null) ? 0 : timeToFallAsleep.hashCode());
        result = prime * result + ((timeAsleep == null) ? 0 : timeAsleep.hashCode());
        result = prime * result + ((timeAwake == null) ? 0 : timeAwake.hashCode());
        result = prime * result + ((timeAfterWakeup == null) ? 0 : timeAfterWakeup.hashCode());
        result = prime * result + ((timeInBed == null) ? 0 : timeInBed.hashCode());
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
        SleepPeriod other = (SleepPeriod) obj;
        if (efficiency == null) {
            if (other.efficiency != null)
                return false;
        } else if (!efficiency.equals(other.efficiency))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (timeToFallAsleep == null) {
            if (other.timeToFallAsleep != null)
                return false;
        } else if (!timeToFallAsleep.equals(other.timeToFallAsleep))
            return false;
        if (timeAsleep == null) {
            if (other.timeAsleep != null)
                return false;
        } else if (!timeAsleep.equals(other.timeAsleep))
            return false;
        if (timeAwake == null) {
            if (other.timeAwake != null)
                return false;
        } else if (!timeAwake.equals(other.timeAwake))
            return false;
        if (timeAfterWakeup == null) {
            if (other.timeAfterWakeup != null)
                return false;
        } else if (!timeAfterWakeup.equals(other.timeAfterWakeup))
            return false;
        if (timeInBed == null) {
            if (other.timeInBed != null)
                return false;
        } else if (!timeInBed.equals(other.timeInBed))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SleepPeriod [" + 
            "efficiency=" + efficiency +", " + 
            "duration=" + duration +", " + 
            "timeToFallAsleep=" + timeToFallAsleep +", " + 
            "timeAsleep=" + timeAsleep +", " + 
            "timeAwake=" + timeAwake +", " + 
            "timeAfterWakeup=" + timeAfterWakeup +", " + 
            "timeInBed=" + timeInBed +
        "]";
    }
}
