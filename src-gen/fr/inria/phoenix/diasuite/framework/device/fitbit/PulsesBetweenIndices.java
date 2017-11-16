package fr.inria.phoenix.diasuite.framework.device.fitbit;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>pulsesBetween</code> from device <code>Fitbit</code>.

<pre>
source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
</pre>
 */
public final class PulsesBetweenIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public PulsesBetweenIndices(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        this._startDate = startDate;
        this._endDate = endDate;
    }
    
    // Code for index startDate
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date _startDate;
    
    /**
     * Get the <code>startDate</code> index
     * 
     * @return the value of the <code>startDate</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate() {
        return _startDate;
    }
    
    /**
     * Set the <code>startDate</code> index
     * 
     * @param newStartDate the new value for the <code>startDate</code> index
     */
    public void setStartDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date newStartDate) {
        this._startDate = newStartDate;
    }
    // End of code for index startDate
    
    // Code for index endDate
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date _endDate;
    
    /**
     * Get the <code>endDate</code> index
     * 
     * @return the value of the <code>endDate</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate() {
        return _endDate;
    }
    
    /**
     * Set the <code>endDate</code> index
     * 
     * @param newEndDate the new value for the <code>endDate</code> index
     */
    public void setEndDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date newEndDate) {
        this._endDate = newEndDate;
    }
    // End of code for index endDate
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_startDate == null) ? 0 : _startDate.hashCode());
        result = prime * result + ((_endDate == null) ? 0 : _endDate.hashCode());
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
        PulsesBetweenIndices other = (PulsesBetweenIndices) obj;
        if (_startDate == null) {
            if (other._startDate != null)
                return false;
        } else if (!_startDate.equals(other._startDate))
            return false;
        if (_endDate == null) {
            if (other._endDate != null)
                return false;
        } else if (!_endDate.equals(other._endDate))
            return false;
        return true;
    }
}
