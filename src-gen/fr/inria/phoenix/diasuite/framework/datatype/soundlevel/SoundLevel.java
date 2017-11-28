package fr.inria.phoenix.diasuite.framework.datatype.soundlevel;

import java.io.Serializable;

/**
 * <pre>
 * structure SoundLevel {
 * 	name as String;
 * 	level as Integer;
 * }
 * </pre>
 */
public class SoundLevel implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field name
    private java.lang.String name;
    
    /**
     * Returns the value of the name field.
     * 
     * <pre>
     * name as String
     * </pre>
     * @return the value of name
     */
    public java.lang.String getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
     * 
     * <pre>
     * name as String
     * </pre>
     * @param name the new value of name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    // End of code for field name

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

    public SoundLevel() {
    }

    public SoundLevel(java.lang.String name,
            java.lang.Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
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
        SoundLevel other = (SoundLevel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SoundLevel [" + 
            "name=" + name +", " + 
            "level=" + level +
        "]";
    }
}
