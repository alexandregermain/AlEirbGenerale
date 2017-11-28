package fr.inria.phoenix.diasuite.framework.device.storage;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>data</code> from device <code>Storage</code>.
 * 
 * <pre>
 * source data as String indexed by key as String;
 * </pre>
 */
public final class DataIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public DataIndices(java.lang.String key) {
        this._key = key;
    }
    
    // Code for index key
    private java.lang.String _key;
    
    /**
     * Get the <code>key</code> index
     * 
     * @return the value of the <code>key</code> index
     */
    public java.lang.String key() {
        return _key;
    }
    
    /**
     * Set the <code>key</code> index
     * 
     * @param newKey the new value for the <code>key</code> index
     */
    public void setKey(java.lang.String newKey) {
        this._key = newKey;
    }
    // End of code for index key
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_key == null) ? 0 : _key.hashCode());
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
        DataIndices other = (DataIndices) obj;
        if (_key == null) {
            if (other._key != null)
                return false;
        } else if (!_key.equals(other._key))
            return false;
        return true;
    }
}
