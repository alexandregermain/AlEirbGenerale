package fr.inria.phoenix.diasuite.framework.context.updatepassword;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>UpdatePassword</code>.
 * <p>
 * publish update canceling
 *
 * <pre>
 * context UpdatePassword as PasswordUpdating {
 * 	when provided contact from ContactSensor maybe publish; 
 * 	when provided on from Light maybe publish;
 * 	when provided ElapsedTime maybe publish; 
 * }
 * </pre>
 */
public final class UpdatePasswordValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating value;
    
    /**
     * Get the value of the context <code>UpdatePassword</code>
     * 
     * <p>
     * publish update canceling
     * 
     * @return the value of the context <code>UpdatePassword</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating value() {
        return value;
    }
    
    public UpdatePasswordValue(fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating value) {
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
        UpdatePasswordValue other = (UpdatePasswordValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
