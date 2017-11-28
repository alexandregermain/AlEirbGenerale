package fr.inria.phoenix.diasuite.framework.datatype.message;

import java.io.Serializable;

/**
 * <pre>
 * structure Message {
 * 	to as Contact;
 * 	title as String;
 * 	content as String;
 * 	attachments as File [];
 * }
 * </pre>
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field to
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to;
    
    /**
     * Returns the value of the to field.
     * 
     * <pre>
     * to as Contact
     * </pre>
     * @return the value of to
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getTo() {
        return to;
    }
    
    /**
     * Set the value of the to field.
     * 
     * <pre>
     * to as Contact
     * </pre>
     * @param to the new value of to
     */
    public void setTo(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        this.to = to;
    }
    // End of code for field to

    // Code for field title
    private java.lang.String title;
    
    /**
     * Returns the value of the title field.
     * 
     * <pre>
     * title as String
     * </pre>
     * @return the value of title
     */
    public java.lang.String getTitle() {
        return title;
    }
    
    /**
     * Set the value of the title field.
     * 
     * <pre>
     * title as String
     * </pre>
     * @param title the new value of title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    // End of code for field title

    // Code for field content
    private java.lang.String content;
    
    /**
     * Returns the value of the content field.
     * 
     * <pre>
     * content as String
     * </pre>
     * @return the value of content
     */
    public java.lang.String getContent() {
        return content;
    }
    
    /**
     * Set the value of the content field.
     * 
     * <pre>
     * content as String
     * </pre>
     * @param content the new value of content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    // End of code for field content

    // Code for field attachments
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments;
    
    /**
     * Returns the value of the attachments field.
     * 
     * <pre>
     * attachments as File []
     * </pre>
     * @return the value of attachments
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> getAttachments() {
        return attachments;
    }
    
    /**
     * Set the value of the attachments field.
     * 
     * <pre>
     * attachments as File []
     * </pre>
     * @param attachments the new value of attachments
     */
    public void setAttachments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        this.attachments = attachments;
    }
    // End of code for field attachments

    public Message() {
    }

    public Message(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        this.to = to;
        this.title = title;
        this.content = content;
        this.attachments = attachments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
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
        Message other = (Message) obj;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (attachments == null) {
            if (other.attachments != null)
                return false;
        } else if (!attachments.equals(other.attachments))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Message [" + 
            "to=" + to +", " + 
            "title=" + title +", " + 
            "content=" + content +", " + 
            "attachments=" + attachments +
        "]";
    }
}
