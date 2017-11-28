package fr.inria.phoenix.diasuite.framework.context.passwordlistener;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>PasswordListener</code>.
 * <p>
 * no more listen after ringing stops
 *
 * <pre>
 * context PasswordListener as Boolean {
 * 	when provided IsInside no publish; 
 * 	when provided on from Light maybe publish; 
 * 	when provided contact from ContactSensor maybe publish; 
 * 	when provided ElapsedTime no publish; 
 * }
 * </pre>
 */
public final class PasswordListenerValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the context <code>PasswordListener</code>
     * 
     * <p>
     * no more listen after ringing stops
     * 
     * @return the value of the context <code>PasswordListener</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public PasswordListenerValue(java.lang.Boolean value) {
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
        PasswordListenerValue other = (PasswordListenerValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
