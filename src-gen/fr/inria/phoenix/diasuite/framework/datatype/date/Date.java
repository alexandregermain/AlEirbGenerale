package fr.inria.phoenix.diasuite.framework.datatype.date;

import java.io.Serializable;

/**
 * ------------------------------------------------------------
 * Utils							||
 * ------------------------------------------------------------
 * 
 * <pre>
 * structure Date {
 * 	day as Integer;
 * 	month as Integer;
 * 	year as Integer;
 * 	hour as Integer;
 * 	minute as Integer;
 * 	second as Integer;
 * }
 * </pre>
 */
public class Date implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field day
    private java.lang.Integer day;
    
    /**
     * Returns the value of the day field.
     * 
     * <pre>
     * day as Integer
     * </pre>
     * @return the value of day
     */
    public java.lang.Integer getDay() {
        return day;
    }
    
    /**
     * Set the value of the day field.
     * 
     * <pre>
     * day as Integer
     * </pre>
     * @param day the new value of day
     */
    public void setDay(java.lang.Integer day) {
        this.day = day;
    }
    // End of code for field day

    // Code for field month
    private java.lang.Integer month;
    
    /**
     * Returns the value of the month field.
     * 
     * <pre>
     * month as Integer
     * </pre>
     * @return the value of month
     */
    public java.lang.Integer getMonth() {
        return month;
    }
    
    /**
     * Set the value of the month field.
     * 
     * <pre>
     * month as Integer
     * </pre>
     * @param month the new value of month
     */
    public void setMonth(java.lang.Integer month) {
        this.month = month;
    }
    // End of code for field month

    // Code for field year
    private java.lang.Integer year;
    
    /**
     * Returns the value of the year field.
     * 
     * <pre>
     * year as Integer
     * </pre>
     * @return the value of year
     */
    public java.lang.Integer getYear() {
        return year;
    }
    
    /**
     * Set the value of the year field.
     * 
     * <pre>
     * year as Integer
     * </pre>
     * @param year the new value of year
     */
    public void setYear(java.lang.Integer year) {
        this.year = year;
    }
    // End of code for field year

    // Code for field hour
    private java.lang.Integer hour;
    
    /**
     * Returns the value of the hour field.
     * 
     * <pre>
     * hour as Integer
     * </pre>
     * @return the value of hour
     */
    public java.lang.Integer getHour() {
        return hour;
    }
    
    /**
     * Set the value of the hour field.
     * 
     * <pre>
     * hour as Integer
     * </pre>
     * @param hour the new value of hour
     */
    public void setHour(java.lang.Integer hour) {
        this.hour = hour;
    }
    // End of code for field hour

    // Code for field minute
    private java.lang.Integer minute;
    
    /**
     * Returns the value of the minute field.
     * 
     * <pre>
     * minute as Integer
     * </pre>
     * @return the value of minute
     */
    public java.lang.Integer getMinute() {
        return minute;
    }
    
    /**
     * Set the value of the minute field.
     * 
     * <pre>
     * minute as Integer
     * </pre>
     * @param minute the new value of minute
     */
    public void setMinute(java.lang.Integer minute) {
        this.minute = minute;
    }
    // End of code for field minute

    // Code for field second
    private java.lang.Integer second;
    
    /**
     * Returns the value of the second field.
     * 
     * <pre>
     * second as Integer
     * </pre>
     * @return the value of second
     */
    public java.lang.Integer getSecond() {
        return second;
    }
    
    /**
     * Set the value of the second field.
     * 
     * <pre>
     * second as Integer
     * </pre>
     * @param second the new value of second
     */
    public void setSecond(java.lang.Integer second) {
        this.second = second;
    }
    // End of code for field second

    public Date() {
    }

    public Date(java.lang.Integer day,
            java.lang.Integer month,
            java.lang.Integer year,
            java.lang.Integer hour,
            java.lang.Integer minute,
            java.lang.Integer second) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        result = prime * result + ((month == null) ? 0 : month.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        result = prime * result + ((hour == null) ? 0 : hour.hashCode());
        result = prime * result + ((minute == null) ? 0 : minute.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
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
        Date other = (Date) obj;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        if (month == null) {
            if (other.month != null)
                return false;
        } else if (!month.equals(other.month))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        if (hour == null) {
            if (other.hour != null)
                return false;
        } else if (!hour.equals(other.hour))
            return false;
        if (minute == null) {
            if (other.minute != null)
                return false;
        } else if (!minute.equals(other.minute))
            return false;
        if (second == null) {
            if (other.second != null)
                return false;
        } else if (!second.equals(other.second))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Date [" + 
            "day=" + day +", " + 
            "month=" + month +", " + 
            "year=" + year +", " + 
            "hour=" + hour +", " + 
            "minute=" + minute +", " + 
            "second=" + second +
        "]";
    }
}
