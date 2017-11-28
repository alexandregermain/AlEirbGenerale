package fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification;

import java.io.Serializable;

/**
 * <pre>
 * structure NonCriticalNotification {
 * 	id as String;
 * 	title as String;
 * 	text as String;
 * 	answers as String [];
 * 	silent as Boolean;
 * }
 * </pre>
 */
public class NonCriticalNotification implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field id
    private java.lang.String id;
    
    /**
     * Returns the value of the id field.
     * 
     * <pre>
     * id as String
     * </pre>
     * @return the value of id
     */
    public java.lang.String getId() {
        return id;
    }
    
    /**
     * Set the value of the id field.
     * 
     * <pre>
     * id as String
     * </pre>
     * @param id the new value of id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }
    // End of code for field id

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

    // Code for field text
    private java.lang.String text;
    
    /**
     * Returns the value of the text field.
     * 
     * <pre>
     * text as String
     * </pre>
     * @return the value of text
     */
    public java.lang.String getText() {
        return text;
    }
    
    /**
     * Set the value of the text field.
     * 
     * <pre>
     * text as String
     * </pre>
     * @param text the new value of text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }
    // End of code for field text

    // Code for field answers
    private java.util.List<java.lang.String> answers;
    
    /**
     * Returns the value of the answers field.
     * 
     * <pre>
     * answers as String []
     * </pre>
     * @return the value of answers
     */
    public java.util.List<java.lang.String> getAnswers() {
        return answers;
    }
    
    /**
     * Set the value of the answers field.
     * 
     * <pre>
     * answers as String []
     * </pre>
     * @param answers the new value of answers
     */
    public void setAnswers(java.util.List<java.lang.String> answers) {
        this.answers = answers;
    }
    // End of code for field answers

    // Code for field silent
    private java.lang.Boolean silent;
    
    /**
     * Returns the value of the silent field.
     * 
     * <pre>
     * silent as Boolean
     * </pre>
     * @return the value of silent
     */
    public java.lang.Boolean getSilent() {
        return silent;
    }
    
    /**
     * Set the value of the silent field.
     * 
     * <pre>
     * silent as Boolean
     * </pre>
     * @param silent the new value of silent
     */
    public void setSilent(java.lang.Boolean silent) {
        this.silent = silent;
    }
    // End of code for field silent

    public NonCriticalNotification() {
    }

    public NonCriticalNotification(java.lang.String id,
            java.lang.String title,
            java.lang.String text,
            java.util.List<java.lang.String> answers,
            java.lang.Boolean silent) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.answers = answers;
        this.silent = silent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((answers == null) ? 0 : answers.hashCode());
        result = prime * result + ((silent == null) ? 0 : silent.hashCode());
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
        NonCriticalNotification other = (NonCriticalNotification) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (answers == null) {
            if (other.answers != null)
                return false;
        } else if (!answers.equals(other.answers))
            return false;
        if (silent == null) {
            if (other.silent != null)
                return false;
        } else if (!silent.equals(other.silent))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "NonCriticalNotification [" + 
            "id=" + id +", " + 
            "title=" + title +", " + 
            "text=" + text +", " + 
            "answers=" + answers +", " + 
            "silent=" + silent +
        "]";
    }
}
