package fr.inria.phoenix.diasuite.framework.datatype.androidextrastring;

import java.io.Serializable;

/**
 * <pre>
structure AndroidExtraString {
 * 	key as String;
 * 	value as String;
 * }
</pre>
 */
public class AndroidExtraString implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field key
    private java.lang.String key;
    
    /**
     * Returns the value of the key field.
    
    <pre>
    key as String
    </pre>
    @return the value of key
     */
    public java.lang.String getKey() {
        return key;
    }
    
    /**
     * Set the value of the key field.
    
    <pre>
    key as String
    </pre>
    @param key the new value of key
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }
    // End of code for field key

    // Code for field value
    private java.lang.String value;
    
    /**
     * Returns the value of the value field.
    
    <pre>
    value as String
    </pre>
    @return the value of value
     */
    public java.lang.String getValue() {
        return value;
    }
    
    /**
     * Set the value of the value field.
    
    <pre>
    value as String
    </pre>
    @param value the new value of value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }
    // End of code for field value

    public AndroidExtraString() {
    }

    public AndroidExtraString(java.lang.String key,
            java.lang.String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
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
        AndroidExtraString other = (AndroidExtraString) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AndroidExtraString [" + 
            "key=" + key +", " + 
            "value=" + value +
        "]";
    }
}
