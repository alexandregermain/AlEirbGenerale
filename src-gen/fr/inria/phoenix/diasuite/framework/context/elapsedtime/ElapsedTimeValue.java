package fr.inria.phoenix.diasuite.framework.context.elapsedtime;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>ElapsedTime</code>.
 * <p>
 * listen for all timers
 *
 * <pre>
 * context ElapsedTime as AlEirbTimer {
 * 	when provided timerTriggered from Timer maybe publish; 
 * }
 * </pre>
 */
public final class ElapsedTimeValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value;
    
    /**
     * Get the value of the context <code>ElapsedTime</code>
     * 
     * <p>
     * listen for all timers
     * 
     * @return the value of the context <code>ElapsedTime</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value() {
        return value;
    }
    
    public ElapsedTimeValue(fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        ElapsedTimeValue other = (ElapsedTimeValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
