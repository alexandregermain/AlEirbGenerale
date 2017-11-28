package fr.inria.phoenix.diasuite.framework.datatype.dailyactivity;

import java.io.Serializable;

/**
 * <pre>
 * structure DailyActivity {
 * 	name as DailyActivityName;
 * 	score as Float;
 * 	success as Boolean;
 * 	date as Date;
 * }
 * </pre>
 */
public class DailyActivity implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field name
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name;
    
    /**
     * Returns the value of the name field.
     * 
     * <pre>
     * name as DailyActivityName
     * </pre>
     * @return the value of name
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
     * 
     * <pre>
     * name as DailyActivityName
     * </pre>
     * @param name the new value of name
     */
    public void setName(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name) {
        this.name = name;
    }
    // End of code for field name

    // Code for field score
    private java.lang.Float score;
    
    /**
     * Returns the value of the score field.
     * 
     * <pre>
     * score as Float
     * </pre>
     * @return the value of score
     */
    public java.lang.Float getScore() {
        return score;
    }
    
    /**
     * Set the value of the score field.
     * 
     * <pre>
     * score as Float
     * </pre>
     * @param score the new value of score
     */
    public void setScore(java.lang.Float score) {
        this.score = score;
    }
    // End of code for field score

    // Code for field success
    private java.lang.Boolean success;
    
    /**
     * Returns the value of the success field.
     * 
     * <pre>
     * success as Boolean
     * </pre>
     * @return the value of success
     */
    public java.lang.Boolean getSuccess() {
        return success;
    }
    
    /**
     * Set the value of the success field.
     * 
     * <pre>
     * success as Boolean
     * </pre>
     * @param success the new value of success
     */
    public void setSuccess(java.lang.Boolean success) {
        this.success = success;
    }
    // End of code for field success

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

    public DailyActivity() {
    }

    public DailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName name,
            java.lang.Float score,
            java.lang.Boolean success,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.name = name;
        this.score = score;
        this.success = success;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((success == null) ? 0 : success.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        DailyActivity other = (DailyActivity) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        if (success == null) {
            if (other.success != null)
                return false;
        } else if (!success.equals(other.success))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DailyActivity [" + 
            "name=" + name +", " + 
            "score=" + score +", " + 
            "success=" + success +", " + 
            "date=" + date +
        "]";
    }
}
