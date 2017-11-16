package fr.inria.phoenix.diasuite.framework.datatype.androidintent;

import java.io.Serializable;

/**
 * <pre>
structure AndroidIntent {
 * 	packageName as String;
 * 	data as String;
 * 	className as String;
 * 	action as String;
 * 	extras as AndroidExtraString [];
 * }
</pre>
 */
public class AndroidIntent implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field packageName
    private java.lang.String packageName;
    
    /**
     * Returns the value of the packageName field.
    
    <pre>
    packageName as String
    </pre>
    @return the value of packageName
     */
    public java.lang.String getPackageName() {
        return packageName;
    }
    
    /**
     * Set the value of the packageName field.
    
    <pre>
    packageName as String
    </pre>
    @param packageName the new value of packageName
     */
    public void setPackageName(java.lang.String packageName) {
        this.packageName = packageName;
    }
    // End of code for field packageName

    // Code for field data
    private java.lang.String data;
    
    /**
     * Returns the value of the data field.
    
    <pre>
    data as String
    </pre>
    @return the value of data
     */
    public java.lang.String getData() {
        return data;
    }
    
    /**
     * Set the value of the data field.
    
    <pre>
    data as String
    </pre>
    @param data the new value of data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }
    // End of code for field data

    // Code for field className
    private java.lang.String className;
    
    /**
     * Returns the value of the className field.
    
    <pre>
    className as String
    </pre>
    @return the value of className
     */
    public java.lang.String getClassName() {
        return className;
    }
    
    /**
     * Set the value of the className field.
    
    <pre>
    className as String
    </pre>
    @param className the new value of className
     */
    public void setClassName(java.lang.String className) {
        this.className = className;
    }
    // End of code for field className

    // Code for field action
    private java.lang.String action;
    
    /**
     * Returns the value of the action field.
    
    <pre>
    action as String
    </pre>
    @return the value of action
     */
    public java.lang.String getAction() {
        return action;
    }
    
    /**
     * Set the value of the action field.
    
    <pre>
    action as String
    </pre>
    @param action the new value of action
     */
    public void setAction(java.lang.String action) {
        this.action = action;
    }
    // End of code for field action

    // Code for field extras
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString> extras;
    
    /**
     * Returns the value of the extras field.
    
    <pre>
    extras as AndroidExtraString []
    </pre>
    @return the value of extras
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString> getExtras() {
        return extras;
    }
    
    /**
     * Set the value of the extras field.
    
    <pre>
    extras as AndroidExtraString []
    </pre>
    @param extras the new value of extras
     */
    public void setExtras(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString> extras) {
        this.extras = extras;
    }
    // End of code for field extras

    public AndroidIntent() {
    }

    public AndroidIntent(java.lang.String packageName,
            java.lang.String data,
            java.lang.String className,
            java.lang.String action,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString> extras) {
        this.packageName = packageName;
        this.data = data;
        this.className = className;
        this.action = action;
        this.extras = extras;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((className == null) ? 0 : className.hashCode());
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((extras == null) ? 0 : extras.hashCode());
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
        AndroidIntent other = (AndroidIntent) obj;
        if (packageName == null) {
            if (other.packageName != null)
                return false;
        } else if (!packageName.equals(other.packageName))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (className == null) {
            if (other.className != null)
                return false;
        } else if (!className.equals(other.className))
            return false;
        if (action == null) {
            if (other.action != null)
                return false;
        } else if (!action.equals(other.action))
            return false;
        if (extras == null) {
            if (other.extras != null)
                return false;
        } else if (!extras.equals(other.extras))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AndroidIntent [" + 
            "packageName=" + packageName +", " + 
            "data=" + data +", " + 
            "className=" + className +", " + 
            "action=" + action +", " + 
            "extras=" + extras +
        "]";
    }
}
