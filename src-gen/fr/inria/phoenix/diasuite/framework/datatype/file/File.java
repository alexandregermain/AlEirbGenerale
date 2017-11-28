package fr.inria.phoenix.diasuite.framework.datatype.file;

import java.io.Serializable;

/**
 * <pre>
structure File {
 * 	name as String;
 * 	type as FileType;
 * 	size as Integer;
 * 	content as Binary;
 * }
</pre>
 */
public class File implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field name
    private java.lang.String name;
    
    /**
     * Returns the value of the name field.
    
    <pre>
    name as String
    </pre>
    @return the value of name
     */
    public java.lang.String getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
    
    <pre>
    name as String
    </pre>
    @param name the new value of name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    // End of code for field name

    // Code for field type
    private fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType type;
    
    /**
     * Returns the value of the type field.
    
    <pre>
    type as FileType
    </pre>
    @return the value of type
     */
    public fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType getType() {
        return type;
    }
    
    /**
     * Set the value of the type field.
    
    <pre>
    type as FileType
    </pre>
    @param type the new value of type
     */
    public void setType(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType type) {
        this.type = type;
    }
    // End of code for field type

    // Code for field size
    private java.lang.Integer size;
    
    /**
     * Returns the value of the size field.
    
    <pre>
    size as Integer
    </pre>
    @return the value of size
     */
    public java.lang.Integer getSize() {
        return size;
    }
    
    /**
     * Set the value of the size field.
    
    <pre>
    size as Integer
    </pre>
    @param size the new value of size
     */
    public void setSize(java.lang.Integer size) {
        this.size = size;
    }
    // End of code for field size

    // Code for field content
    private byte[] content;
    
    /**
     * Returns the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @return the value of content
     */
    public byte[] getContent() {
        return content;
    }
    
    /**
     * Set the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @param content the new value of content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
    // End of code for field content

    public File() {
    }

    public File(java.lang.String name,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType type,
            java.lang.Integer size,
            byte[] content) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
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
        File other = (File) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "File [" + 
            "name=" + name +", " + 
            "type=" + type +", " + 
            "size=" + size +", " + 
            "content.length=" + content.length +
        "]";
    }
}
