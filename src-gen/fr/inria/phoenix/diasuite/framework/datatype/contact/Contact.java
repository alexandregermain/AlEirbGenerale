package fr.inria.phoenix.diasuite.framework.datatype.contact;

import java.io.Serializable;

/**
 * ------------------------------------------------------------
 * Contact						||
 * ------------------------------------------------------------
 * 
 * <pre>
 * structure Contact {
 * 	name as String;
 * 	emailAddress as String;
 * 	phone as String;
 * 	iconUrl as String;
 * 	groups as String [];
 * }
 * </pre>
 */
public class Contact implements Serializable {
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

    // Code for field emailAddress
    private java.lang.String emailAddress;
    
    /**
     * Returns the value of the emailAddress field.
     * 
     * <pre>
     * emailAddress as String
     * </pre>
     * @return the value of emailAddress
     */
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * Set the value of the emailAddress field.
     * 
     * <pre>
     * emailAddress as String
     * </pre>
     * @param emailAddress the new value of emailAddress
     */
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }
    // End of code for field emailAddress

    // Code for field phone
    private java.lang.String phone;
    
    /**
     * Returns the value of the phone field.
     * 
     * <pre>
     * phone as String
     * </pre>
     * @return the value of phone
     */
    public java.lang.String getPhone() {
        return phone;
    }
    
    /**
     * Set the value of the phone field.
     * 
     * <pre>
     * phone as String
     * </pre>
     * @param phone the new value of phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    // End of code for field phone

    // Code for field iconUrl
    private java.lang.String iconUrl;
    
    /**
     * Returns the value of the iconUrl field.
     * 
     * <pre>
     * iconUrl as String
     * </pre>
     * @return the value of iconUrl
     */
    public java.lang.String getIconUrl() {
        return iconUrl;
    }
    
    /**
     * Set the value of the iconUrl field.
     * 
     * <pre>
     * iconUrl as String
     * </pre>
     * @param iconUrl the new value of iconUrl
     */
    public void setIconUrl(java.lang.String iconUrl) {
        this.iconUrl = iconUrl;
    }
    // End of code for field iconUrl

    // Code for field groups
    private java.util.List<java.lang.String> groups;
    
    /**
     * Returns the value of the groups field.
     * 
     * <pre>
     * groups as String []
     * </pre>
     * @return the value of groups
     */
    public java.util.List<java.lang.String> getGroups() {
        return groups;
    }
    
    /**
     * Set the value of the groups field.
     * 
     * <pre>
     * groups as String []
     * </pre>
     * @param groups the new value of groups
     */
    public void setGroups(java.util.List<java.lang.String> groups) {
        this.groups = groups;
    }
    // End of code for field groups

    public Contact() {
    }

    public Contact(java.lang.String name,
            java.lang.String emailAddress,
            java.lang.String phone,
            java.lang.String iconUrl,
            java.util.List<java.lang.String> groups) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.iconUrl = iconUrl;
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
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
        Contact other = (Contact) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (emailAddress == null) {
            if (other.emailAddress != null)
                return false;
        } else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (iconUrl == null) {
            if (other.iconUrl != null)
                return false;
        } else if (!iconUrl.equals(other.iconUrl))
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contact [" + 
            "name=" + name +", " + 
            "emailAddress=" + emailAddress +", " + 
            "phone=" + phone +", " + 
            "iconUrl=" + iconUrl +", " + 
            "groups=" + groups +
        "]";
    }
}
