package fr.inria.phoenix.diasuite.framework.datatype.battery;

import java.io.Serializable;

/**
 * ------------------------------------------------------------
 * Android							||
 * ------------------------------------------------------------
 * 
 * <pre>
 * structure Battery {
 * 	level as Integer;
 * 	charging as Boolean;
 * }
 * </pre>
 */
public class Battery implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field level
    private java.lang.Integer level;
    
    /**
     * Returns the value of the level field.
     * 
     * <pre>
     * level as Integer
     * </pre>
     * @return the value of level
     */
    public java.lang.Integer getLevel() {
        return level;
    }
    
    /**
     * Set the value of the level field.
     * 
     * <pre>
     * level as Integer
     * </pre>
     * @param level the new value of level
     */
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }
    // End of code for field level

    // Code for field charging
    private java.lang.Boolean charging;
    
    /**
     * Returns the value of the charging field.
     * 
     * <pre>
     * charging as Boolean
     * </pre>
     * @return the value of charging
     */
    public java.lang.Boolean getCharging() {
        return charging;
    }
    
    /**
     * Set the value of the charging field.
     * 
     * <pre>
     * charging as Boolean
     * </pre>
     * @param charging the new value of charging
     */
    public void setCharging(java.lang.Boolean charging) {
        this.charging = charging;
    }
    // End of code for field charging

    public Battery() {
    }

    public Battery(java.lang.Integer level,
            java.lang.Boolean charging) {
        this.level = level;
        this.charging = charging;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((charging == null) ? 0 : charging.hashCode());
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
        Battery other = (Battery) obj;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (charging == null) {
            if (other.charging != null)
                return false;
        } else if (!charging.equals(other.charging))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Battery [" + 
            "level=" + level +", " + 
            "charging=" + charging +
        "]";
    }
}
