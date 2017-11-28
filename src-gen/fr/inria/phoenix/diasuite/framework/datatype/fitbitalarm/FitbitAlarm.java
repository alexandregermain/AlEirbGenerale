package fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm;

import java.io.Serializable;

/**
 * <pre>
 * structure FitbitAlarm {
 * 	alarmId as String;
 * 	date as Date;
 * 	recurring as Boolean;
 * 	reminders as Integer;
 * 	remindInterval as Integer;
 * 	weekDays as Day;
 * }
 * </pre>
 */
public class FitbitAlarm implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field alarmId
    private java.lang.String alarmId;
    
    /**
     * Returns the value of the alarmId field.
     * 
     * <pre>
     * alarmId as String
     * </pre>
     * @return the value of alarmId
     */
    public java.lang.String getAlarmId() {
        return alarmId;
    }
    
    /**
     * Set the value of the alarmId field.
     * 
     * <pre>
     * alarmId as String
     * </pre>
     * @param alarmId the new value of alarmId
     */
    public void setAlarmId(java.lang.String alarmId) {
        this.alarmId = alarmId;
    }
    // End of code for field alarmId

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

    // Code for field recurring
    private java.lang.Boolean recurring;
    
    /**
     * Returns the value of the recurring field.
     * 
     * <pre>
     * recurring as Boolean
     * </pre>
     * @return the value of recurring
     */
    public java.lang.Boolean getRecurring() {
        return recurring;
    }
    
    /**
     * Set the value of the recurring field.
     * 
     * <pre>
     * recurring as Boolean
     * </pre>
     * @param recurring the new value of recurring
     */
    public void setRecurring(java.lang.Boolean recurring) {
        this.recurring = recurring;
    }
    // End of code for field recurring

    // Code for field reminders
    private java.lang.Integer reminders;
    
    /**
     * Returns the value of the reminders field.
     * 
     * <pre>
     * reminders as Integer
     * </pre>
     * @return the value of reminders
     */
    public java.lang.Integer getReminders() {
        return reminders;
    }
    
    /**
     * Set the value of the reminders field.
     * 
     * <pre>
     * reminders as Integer
     * </pre>
     * @param reminders the new value of reminders
     */
    public void setReminders(java.lang.Integer reminders) {
        this.reminders = reminders;
    }
    // End of code for field reminders

    // Code for field remindInterval
    private java.lang.Integer remindInterval;
    
    /**
     * Returns the value of the remindInterval field.
     * 
     * <pre>
     * remindInterval as Integer
     * </pre>
     * @return the value of remindInterval
     */
    public java.lang.Integer getRemindInterval() {
        return remindInterval;
    }
    
    /**
     * Set the value of the remindInterval field.
     * 
     * <pre>
     * remindInterval as Integer
     * </pre>
     * @param remindInterval the new value of remindInterval
     */
    public void setRemindInterval(java.lang.Integer remindInterval) {
        this.remindInterval = remindInterval;
    }
    // End of code for field remindInterval

    // Code for field weekDays
    private fr.inria.phoenix.diasuite.framework.datatype.day.Day weekDays;
    
    /**
     * Returns the value of the weekDays field.
     * 
     * <pre>
     * weekDays as Day
     * </pre>
     * @return the value of weekDays
     */
    public fr.inria.phoenix.diasuite.framework.datatype.day.Day getWeekDays() {
        return weekDays;
    }
    
    /**
     * Set the value of the weekDays field.
     * 
     * <pre>
     * weekDays as Day
     * </pre>
     * @param weekDays the new value of weekDays
     */
    public void setWeekDays(fr.inria.phoenix.diasuite.framework.datatype.day.Day weekDays) {
        this.weekDays = weekDays;
    }
    // End of code for field weekDays

    public FitbitAlarm() {
    }

    public FitbitAlarm(java.lang.String alarmId,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.lang.Boolean recurring,
            java.lang.Integer reminders,
            java.lang.Integer remindInterval,
            fr.inria.phoenix.diasuite.framework.datatype.day.Day weekDays) {
        this.alarmId = alarmId;
        this.date = date;
        this.recurring = recurring;
        this.reminders = reminders;
        this.remindInterval = remindInterval;
        this.weekDays = weekDays;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alarmId == null) ? 0 : alarmId.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((recurring == null) ? 0 : recurring.hashCode());
        result = prime * result + ((reminders == null) ? 0 : reminders.hashCode());
        result = prime * result + ((remindInterval == null) ? 0 : remindInterval.hashCode());
        result = prime * result + ((weekDays == null) ? 0 : weekDays.hashCode());
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
        FitbitAlarm other = (FitbitAlarm) obj;
        if (alarmId == null) {
            if (other.alarmId != null)
                return false;
        } else if (!alarmId.equals(other.alarmId))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (recurring == null) {
            if (other.recurring != null)
                return false;
        } else if (!recurring.equals(other.recurring))
            return false;
        if (reminders == null) {
            if (other.reminders != null)
                return false;
        } else if (!reminders.equals(other.reminders))
            return false;
        if (remindInterval == null) {
            if (other.remindInterval != null)
                return false;
        } else if (!remindInterval.equals(other.remindInterval))
            return false;
        if (weekDays == null) {
            if (other.weekDays != null)
                return false;
        } else if (!weekDays.equals(other.weekDays))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FitbitAlarm [" + 
            "alarmId=" + alarmId +", " + 
            "date=" + date +", " + 
            "recurring=" + recurring +", " + 
            "reminders=" + reminders +", " + 
            "remindInterval=" + remindInterval +", " + 
            "weekDays=" + weekDays +
        "]";
    }
}
