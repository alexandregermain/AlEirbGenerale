package fr.inria.phoenix.diasuite.framework.device.messenger;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device Messenger extends CommunicationService {
 * 	source lastMessage as Message;
 * 	action SendMessage;
 * }
</pre>
 */
public abstract class AbstractMessenger extends Service {
    
    public AbstractMessenger(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/CommunicationService/Messenger/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("sendMessage")) {
            sendMessage((fr.inria.phoenix.diasuite.framework.datatype.message.Message) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("lastMessage")) {
            return getLastMessage();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lastMessage from device Messenger
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message _lastMessage;
    
    /**
     * Publish the value of source <code>lastMessage</code> from device <code>Messenger</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
     */
    protected void publishLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        _lastMessage = newLastMessageValue;
        getProcessor().publishValue(getOutProperties(), "lastMessage", newLastMessageValue); 
    }
    
    /**
     * Returns the value of source <code>lastMessage</code> from device <code>Messenger</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @return the value of the source <code>lastMessage</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastMessage() throws Exception {
        return _lastMessage;
    }
    // End of code for source lastMessage from device Messenger
    
    /**
     * Implement this method to define the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger.
     * 
    
    <pre>
    sendMessage(message as Message);
    </pre>
     * @param message parameter 1 of the order.
     */
    protected abstract void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message message) throws Exception;
}
