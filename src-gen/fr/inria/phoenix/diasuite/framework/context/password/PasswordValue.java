package fr.inria.phoenix.diasuite.framework.context.password;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>Password</code>.
 * <p>
 * ------------------------------------------------------
 * CONTEXT
 * ------------------------------------------------------
 * Permet de savoir si le password est juste
 *
 * <pre>
 * context Password as Boolean {
 * 	when provided contact from ContactSensor
 * 	get timerTriggered from Timer
 * 	maybe publish;
 * }
 * </pre>
 */
public final class PasswordValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the context <code>Password</code>
     * 
     * <p>
     * ------------------------------------------------------
     * CONTEXT
     * ------------------------------------------------------
     * Permet de savoir si le password est juste
     * 
     * @return the value of the context <code>Password</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public PasswordValue(java.lang.Boolean value) {
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
        PasswordValue other = (PasswordValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
