package fr.inria.phoenix.diasuite.framework.context.actionvalidation;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>ActionValidation</code>.
 *
 * <pre>
 * context ActionValidation as Boolean {
 * 	when provided timerTriggered from Timer
 * 	maybe publish;
 * 	when provided contact from ContactSensor
 * 	get timerTriggered from Timer
 * 	maybe publish;
 * }
 * </pre>
 */
public final class ActionValidationValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the context <code>ActionValidation</code>
     * 
     * @return the value of the context <code>ActionValidation</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public ActionValidationValue(java.lang.Boolean value) {
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
        ActionValidationValue other = (ActionValidationValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
