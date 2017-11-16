package fr.inria.phoenix.diasuite.framework.context.timeover;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>TimeOver</code>.
 *
 * <pre>
 * context TimeOver as Boolean {
 *   when provided timerTriggered from Timer
 *   get timerTriggered from Timer
 *   maybe publish;
 * }
 * </pre>
 */
public final class TimeOverValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the context <code>TimeOver</code>
     * 
     * @return the value of the context <code>TimeOver</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public TimeOverValue(java.lang.Boolean value) {
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
        TimeOverValue other = (TimeOverValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
