package fr.inria.phoenix.diasuite.framework.device.timer;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>timerTriggered</code> from device <code>Timer</code>.

<pre>
source timerTriggered as String indexed by timerId as String;
</pre>
 */
public final class TimerTriggeredIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public TimerTriggeredIndices(java.lang.String timerId) {
        this._timerId = timerId;
    }
    
    // Code for index timerId
    private java.lang.String _timerId;
    
    /**
     * Get the <code>timerId</code> index
     * 
     * @return the value of the <code>timerId</code> index
     */
    public java.lang.String timerId() {
        return _timerId;
    }
    
    /**
     * Set the <code>timerId</code> index
     * 
     * @param newTimerId the new value for the <code>timerId</code> index
     */
    public void setTimerId(java.lang.String newTimerId) {
        this._timerId = newTimerId;
    }
    // End of code for index timerId
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_timerId == null) ? 0 : _timerId.hashCode());
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
        TimerTriggeredIndices other = (TimerTriggeredIndices) obj;
        if (_timerId == null) {
            if (other._timerId != null)
                return false;
        } else if (!_timerId.equals(other._timerId))
            return false;
        return true;
    }
}
