package fr.inria.phoenix.diasuite.framework.datatype.passwordupdating;

import java.io.Serializable;

/**
 * <pre>
structure PasswordUpdating {
 * 	step as UpdatingStep;
 * 	password as String [];
 * }
</pre>
 */
public class PasswordUpdating implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field step
    private fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep step;
    
    /**
     * Returns the value of the step field.
    
    <pre>
    step as UpdatingStep
    </pre>
    @return the value of step
     */
    public fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep getStep() {
        return step;
    }
    
    /**
     * Set the value of the step field.
    
    <pre>
    step as UpdatingStep
    </pre>
    @param step the new value of step
     */
    public void setStep(fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep step) {
        this.step = step;
    }
    // End of code for field step

    // Code for field password
    private java.util.List<java.lang.String> password;
    
    /**
     * Returns the value of the password field.
    
    <pre>
    password as String []
    </pre>
    @return the value of password
     */
    public java.util.List<java.lang.String> getPassword() {
        return password;
    }
    
    /**
     * Set the value of the password field.
    
    <pre>
    password as String []
    </pre>
    @param password the new value of password
     */
    public void setPassword(java.util.List<java.lang.String> password) {
        this.password = password;
    }
    // End of code for field password

    public PasswordUpdating() {
    }

    public PasswordUpdating(fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep step,
            java.util.List<java.lang.String> password) {
        this.step = step;
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((step == null) ? 0 : step.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        PasswordUpdating other = (PasswordUpdating) obj;
        if (step == null) {
            if (other.step != null)
                return false;
        } else if (!step.equals(other.step))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PasswordUpdating [" + 
            "step=" + step +", " + 
            "password=" + password +
        "]";
    }
}
