package fr.inria.phoenix.diasuite.framework.datatype.interaction;

import java.io.Serializable;

/**
 * <pre>
structure Interaction {
 * 	actionType as InteractionType;
 * 	deviceId as String;
 * 	date as Date;
 * }
</pre>
 */
public class Interaction implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field actionType
    private fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionType;
    
    /**
     * Returns the value of the actionType field.
    
    <pre>
    actionType as InteractionType
    </pre>
    @return the value of actionType
     */
    public fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType getActionType() {
        return actionType;
    }
    
    /**
     * Set the value of the actionType field.
    
    <pre>
    actionType as InteractionType
    </pre>
    @param actionType the new value of actionType
     */
    public void setActionType(fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionType) {
        this.actionType = actionType;
    }
    // End of code for field actionType

    // Code for field deviceId
    private java.lang.String deviceId;
    
    /**
     * Returns the value of the deviceId field.
    
    <pre>
    deviceId as String
    </pre>
    @return the value of deviceId
     */
    public java.lang.String getDeviceId() {
        return deviceId;
    }
    
    /**
     * Set the value of the deviceId field.
    
    <pre>
    deviceId as String
    </pre>
    @param deviceId the new value of deviceId
     */
    public void setDeviceId(java.lang.String deviceId) {
        this.deviceId = deviceId;
    }
    // End of code for field deviceId

    // Code for field date
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date date;
    
    /**
     * Returns the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @return the value of date
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @param date the new value of date
     */
    public void setDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.date = date;
    }
    // End of code for field date

    public Interaction() {
    }

    public Interaction(fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionType,
            java.lang.String deviceId,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.actionType = actionType;
        this.deviceId = deviceId;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
        result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Interaction other = (Interaction) obj;
        if (actionType == null) {
            if (other.actionType != null)
                return false;
        } else if (!actionType.equals(other.actionType))
            return false;
        if (deviceId == null) {
            if (other.deviceId != null)
                return false;
        } else if (!deviceId.equals(other.deviceId))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Interaction [" + 
            "actionType=" + actionType +", " + 
            "deviceId=" + deviceId +", " + 
            "date=" + date +
        "]";
    }
}
