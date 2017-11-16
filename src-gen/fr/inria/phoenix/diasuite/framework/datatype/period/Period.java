package fr.inria.phoenix.diasuite.framework.datatype.period;

import java.io.Serializable;

/**
 * <pre>
structure Period {
 * 	beginning as Date;
 * 	end as Date;
 * }
</pre>
 */
public class Period implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field beginning
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date beginning;
    
    /**
     * Returns the value of the beginning field.
    <p>
    AR (21/06/17)
    
    <pre>
    beginning as Date
    </pre>
    @return the value of beginning
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getBeginning() {
        return beginning;
    }
    
    /**
     * Set the value of the beginning field.
    <p>
    AR (21/06/17)
    
    <pre>
    beginning as Date
    </pre>
    @param beginning the new value of beginning
     */
    public void setBeginning(fr.inria.phoenix.diasuite.framework.datatype.date.Date beginning) {
        this.beginning = beginning;
    }
    // End of code for field beginning

    // Code for field end
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date end;
    
    /**
     * Returns the value of the end field.
    
    <pre>
    end as Date
    </pre>
    @return the value of end
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getEnd() {
        return end;
    }
    
    /**
     * Set the value of the end field.
    
    <pre>
    end as Date
    </pre>
    @param end the new value of end
     */
    public void setEnd(fr.inria.phoenix.diasuite.framework.datatype.date.Date end) {
        this.end = end;
    }
    // End of code for field end

    public Period() {
    }

    public Period(fr.inria.phoenix.diasuite.framework.datatype.date.Date beginning,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((beginning == null) ? 0 : beginning.hashCode());
        result = prime * result + ((end == null) ? 0 : end.hashCode());
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
        Period other = (Period) obj;
        if (beginning == null) {
            if (other.beginning != null)
                return false;
        } else if (!beginning.equals(other.beginning))
            return false;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Period [" + 
            "beginning=" + beginning +", " + 
            "end=" + end +
        "]";
    }
}
