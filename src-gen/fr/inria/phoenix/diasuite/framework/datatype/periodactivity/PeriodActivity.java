package fr.inria.phoenix.diasuite.framework.datatype.periodactivity;

import java.io.Serializable;

/**
 * <pre>
 * structure PeriodActivity {
 * 	name as PeriodActivityName;
 * 	period as Period;
 * }
 * </pre>
 */
public class PeriodActivity implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field name
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName name;
    
    /**
     * Returns the value of the name field.
     * 
     * <pre>
     * name as PeriodActivityName
     * </pre>
     * @return the value of name
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
     * 
     * <pre>
     * name as PeriodActivityName
     * </pre>
     * @param name the new value of name
     */
    public void setName(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName name) {
        this.name = name;
    }
    // End of code for field name

    // Code for field period
    private fr.inria.phoenix.diasuite.framework.datatype.period.Period period;
    
    /**
     * Returns the value of the period field.
     * 
     * <pre>
     * period as Period
     * </pre>
     * @return the value of period
     */
    public fr.inria.phoenix.diasuite.framework.datatype.period.Period getPeriod() {
        return period;
    }
    
    /**
     * Set the value of the period field.
     * 
     * <pre>
     * period as Period
     * </pre>
     * @param period the new value of period
     */
    public void setPeriod(fr.inria.phoenix.diasuite.framework.datatype.period.Period period) {
        this.period = period;
    }
    // End of code for field period

    public PeriodActivity() {
    }

    public PeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName name,
            fr.inria.phoenix.diasuite.framework.datatype.period.Period period) {
        this.name = name;
        this.period = period;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((period == null) ? 0 : period.hashCode());
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
        PeriodActivity other = (PeriodActivity) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (period == null) {
            if (other.period != null)
                return false;
        } else if (!period.equals(other.period))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PeriodActivity [" + 
            "name=" + name +", " + 
            "period=" + period +
        "]";
    }
}
