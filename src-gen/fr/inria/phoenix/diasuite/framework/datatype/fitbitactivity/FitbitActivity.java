package fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity;

import java.io.Serializable;

/**
 * <pre>
structure FitbitActivity {
 * 	activityId as Integer;
 * 	calories as Float;
 * 	name as DailyActivityName;
 * 	startTime as Date;
 * 	duration as Integer;
 * 	description as String;
 * }
</pre>
 */
public class FitbitActivity implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field activityId
    private java.lang.Integer activityId;
    
    /**
     * Returns the value of the activityId field.
    
    <pre>
    activityId as Integer
    </pre>
    @return the value of activityId
     */
    public java.lang.Integer getActivityId() {
        return activityId;
    }
    
    /**
     * Set the value of the activityId field.
    
    <pre>
    activityId as Integer
    </pre>
    @param activityId the new value of activityId
     */
    public void setActivityId(java.lang.Integer activityId) {
        this.activityId = activityId;
    }
    // End of code for field activityId

    // Code for field calories
    private java.lang.Float calories;
    
    /**
     * Returns the value of the calories field.
    
    <pre>
    calories as Float
    </pre>
    @return the value of calories
     */
    public java.lang.Float getCalories() {
        return calories;
    }
    
    /**
     * Set the value of the calories field.
    
    <pre>
    calories as Float
    </pre>
    @param calories the new value of calories
     */
    public void setCalories(java.lang.Float calories) {
        this.calories = calories;
    }
    // End of code for field calories

    // Code for field name
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name;
    
    /**
     * Returns the value of the name field.
    
    <pre>
    name as DailyActivityName
    </pre>
    @return the value of name
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
    
    <pre>
    name as DailyActivityName
    </pre>
    @param name the new value of name
     */
    public void setName(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name) {
        this.name = name;
    }
    // End of code for field name

    // Code for field startTime
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime;
    
    /**
     * Returns the value of the startTime field.
    
    <pre>
    startTime as Date
    </pre>
    @return the value of startTime
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getStartTime() {
        return startTime;
    }
    
    /**
     * Set the value of the startTime field.
    
    <pre>
    startTime as Date
    </pre>
    @param startTime the new value of startTime
     */
    public void setStartTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime) {
        this.startTime = startTime;
    }
    // End of code for field startTime

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

    // Code for field description
    private java.lang.String description;
    
    /**
     * Returns the value of the description field.
    
    <pre>
    description as String
    </pre>
    @return the value of description
     */
    public java.lang.String getDescription() {
        return description;
    }
    
    /**
     * Set the value of the description field.
    
    <pre>
    description as String
    </pre>
    @param description the new value of description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    // End of code for field description

    public FitbitActivity() {
    }

    public FitbitActivity(java.lang.Integer activityId,
            java.lang.Float calories,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime,
            java.lang.Integer duration,
            java.lang.String description) {
        this.activityId = activityId;
        this.calories = calories;
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activityId == null) ? 0 : activityId.hashCode());
        result = prime * result + ((calories == null) ? 0 : calories.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        FitbitActivity other = (FitbitActivity) obj;
        if (activityId == null) {
            if (other.activityId != null)
                return false;
        } else if (!activityId.equals(other.activityId))
            return false;
        if (calories == null) {
            if (other.calories != null)
                return false;
        } else if (!calories.equals(other.calories))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FitbitActivity [" + 
            "activityId=" + activityId +", " + 
            "calories=" + calories +", " + 
            "name=" + name +", " + 
            "startTime=" + startTime +", " + 
            "duration=" + duration +", " + 
            "description=" + description +
        "]";
    }
}
