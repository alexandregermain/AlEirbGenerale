package fr.inria.phoenix.diasuite.framework.device.fitbit;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>dailySteps</code> from device <code>Fitbit</code>.
<p>
steps

<pre>
source dailySteps as Integer indexed by day as Date;
</pre>
 */
public final class DailyStepsIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public DailyStepsIndices(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        this._day = day;
    }
    
    // Code for index day
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date _day;
    
    /**
     * Get the <code>day</code> index
     * 
     * @return the value of the <code>day</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date day() {
        return _day;
    }
    
    /**
     * Set the <code>day</code> index
     * 
     * @param newDay the new value for the <code>day</code> index
     */
    public void setDay(fr.inria.phoenix.diasuite.framework.datatype.date.Date newDay) {
        this._day = newDay;
    }
    // End of code for index day
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_day == null) ? 0 : _day.hashCode());
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
        DailyStepsIndices other = (DailyStepsIndices) obj;
        if (_day == null) {
            if (other._day != null)
                return false;
        } else if (!_day.equals(other._day))
            return false;
        return true;
    }
}
