package fr.inria.phoenix.diasuite.framework.datatype.androidapp;

import java.io.Serializable;

/**
 * <pre>
structure AndroidApp {
 * 	packageName as String;
 * 	versionCode as Integer;
 * }
</pre>
 */
public class AndroidApp implements Serializable {
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

    // Code for field versionCode
    private java.lang.Integer versionCode;
    
    /**
     * Returns the value of the versionCode field.
    
    <pre>
    versionCode as Integer
    </pre>
    @return the value of versionCode
     */
    public java.lang.Integer getVersionCode() {
        return versionCode;
    }
    
    /**
     * Set the value of the versionCode field.
    
    <pre>
    versionCode as Integer
    </pre>
    @param versionCode the new value of versionCode
     */
    public void setVersionCode(java.lang.Integer versionCode) {
        this.versionCode = versionCode;
    }
    // End of code for field versionCode

    public AndroidApp() {
    }

    public AndroidApp(java.lang.String packageName,
            java.lang.Integer versionCode) {
        this.packageName = packageName;
        this.versionCode = versionCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
        result = prime * result + ((versionCode == null) ? 0 : versionCode.hashCode());
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
        AndroidApp other = (AndroidApp) obj;
        if (packageName == null) {
            if (other.packageName != null)
                return false;
        } else if (!packageName.equals(other.packageName))
            return false;
        if (versionCode == null) {
            if (other.versionCode != null)
                return false;
        } else if (!versionCode.equals(other.versionCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AndroidApp [" + 
            "packageName=" + packageName +", " + 
            "versionCode=" + versionCode +
        "]";
    }
}
