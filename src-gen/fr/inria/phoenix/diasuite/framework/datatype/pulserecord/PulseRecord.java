package fr.inria.phoenix.diasuite.framework.datatype.pulserecord;

import java.io.Serializable;

/**
 * <pre>
structure PulseRecord {
 * 	pulse as Integer;
 * 	time as Date;
 * }
</pre>
 */
public class PulseRecord implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field pulse
    private java.lang.Integer pulse;
    
    /**
     * Returns the value of the pulse field.
    
    <pre>
    pulse as Integer
    </pre>
    @return the value of pulse
     */
    public java.lang.Integer getPulse() {
        return pulse;
    }
    
    /**
     * Set the value of the pulse field.
    
    <pre>
    pulse as Integer
    </pre>
    @param pulse the new value of pulse
     */
    public void setPulse(java.lang.Integer pulse) {
        this.pulse = pulse;
    }
    // End of code for field pulse

    // Code for field time
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date time;
    
    /**
     * Returns the value of the time field.
    
    <pre>
    time as Date
    </pre>
    @return the value of time
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getTime() {
        return time;
    }
    
    /**
     * Set the value of the time field.
    
    <pre>
    time as Date
    </pre>
    @param time the new value of time
     */
    public void setTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date time) {
        this.time = time;
    }
    // End of code for field time

    public PulseRecord() {
    }

    public PulseRecord(java.lang.Integer pulse,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date time) {
        this.pulse = pulse;
        this.time = time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pulse == null) ? 0 : pulse.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        PulseRecord other = (PulseRecord) obj;
        if (pulse == null) {
            if (other.pulse != null)
                return false;
        } else if (!pulse.equals(other.pulse))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PulseRecord [" + 
            "pulse=" + pulse +", " + 
            "time=" + time +
        "]";
    }
}
