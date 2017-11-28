package fr.inria.phoenix.diasuite.framework.device.fitbit;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>alarm</code> from device <code>Fitbit</code>.
<p>
alarm

<pre>
source alarm as FitbitAlarm indexed by alarmId as String;
</pre>
 */
public final class AlarmIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public AlarmIndices(java.lang.String alarmId) {
        this._alarmId = alarmId;
    }
    
    // Code for index alarmId
    private java.lang.String _alarmId;
    
    /**
     * Get the <code>alarmId</code> index
     * 
     * @return the value of the <code>alarmId</code> index
     */
    public java.lang.String alarmId() {
        return _alarmId;
    }
    
    /**
     * Set the <code>alarmId</code> index
     * 
     * @param newAlarmId the new value for the <code>alarmId</code> index
     */
    public void setAlarmId(java.lang.String newAlarmId) {
        this._alarmId = newAlarmId;
    }
    // End of code for index alarmId
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_alarmId == null) ? 0 : _alarmId.hashCode());
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
        AlarmIndices other = (AlarmIndices) obj;
        if (_alarmId == null) {
            if (other._alarmId != null)
                return false;
        } else if (!_alarmId.equals(other._alarmId))
            return false;
        return true;
    }
}
