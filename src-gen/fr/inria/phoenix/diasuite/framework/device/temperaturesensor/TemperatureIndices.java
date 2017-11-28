package fr.inria.phoenix.diasuite.framework.device.temperaturesensor;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>temperature</code> from device <code>TemperatureSensor</code>.
 * 
 * <pre>
 * source temperature as Float indexed by unit as TemperatureUnit;
 * </pre>
 */
public final class TemperatureIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public TemperatureIndices(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        this._unit = unit;
    }
    
    // Code for index unit
    private fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit _unit;
    
    /**
     * Get the <code>unit</code> index
     * 
     * @return the value of the <code>unit</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit() {
        return _unit;
    }
    
    /**
     * Set the <code>unit</code> index
     * 
     * @param newUnit the new value for the <code>unit</code> index
     */
    public void setUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit newUnit) {
        this._unit = newUnit;
    }
    // End of code for index unit
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_unit == null) ? 0 : _unit.hashCode());
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
        TemperatureIndices other = (TemperatureIndices) obj;
        if (_unit == null) {
            if (other._unit != null)
                return false;
        } else if (!_unit.equals(other._unit))
            return false;
        return true;
    }
}
