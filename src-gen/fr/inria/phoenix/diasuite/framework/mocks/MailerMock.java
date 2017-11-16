package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.mailer.AbstractMailer;

// @internal
public final class MailerMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractMailer {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastMessage() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.message.Message result = __lastMessage;
            if(result == null)
                return super.getLastMessage();
            return result;
        }
        
        public void _publishLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
            publishLastMessage(newLastMessageValue);
        }
        
        protected java.lang.Integer getUnreadEmailCount() throws Exception {
            java.lang.Integer result = __unreadEmailCount;
            if(result == null)
                return super.getUnreadEmailCount();
            return result;
        }
        
        public void _publishUnreadEmailCount(java.lang.Integer newUnreadEmailCountValue) {
            publishUnreadEmailCount(newUnreadEmailCountValue);
        }
        
        protected void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message message) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendMessage");
                __action.add(message);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    MailerMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public MailerMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public MailerMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public MailerMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lastMessage from device Messenger
    /**
     * Publish the value of source <code>lastMessage</code> from device <code>Messenger</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
    @return this for fluent interface
     */
    public MailerMock lastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        proxy._publishLastMessage(newLastMessageValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message __lastMessage = null;
    /**
     * Set the value (without publication) of source <code>lastMessage</code> from device <code>Messenger</code>.
    
    <pre>
    source lastMessage as Message;
    </pre>
    @param newLastMessageValue the new value for the source <code>lastMessage</code>
    @return this for fluent interface
     */
    public MailerMock setLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue) {
        __lastMessage = newLastMessageValue;
        return this;
    }
    // End of code for source lastMessage from device Messenger
    
    // Code for source unreadEmailCount from device Mailer
    /**
     * Publish the value of source <code>unreadEmailCount</code> from device <code>Mailer</code>.
    
    <pre>
    source unreadEmailCount as Integer;
    </pre>
    @param newUnreadEmailCountValue the new value for the source <code>unreadEmailCount</code>
    @return this for fluent interface
     */
    public MailerMock unreadEmailCount(java.lang.Integer newUnreadEmailCountValue) {
        proxy._publishUnreadEmailCount(newUnreadEmailCountValue);
        return this;
    }
    
    private java.lang.Integer __unreadEmailCount = null;
    /**
     * Set the value (without publication) of source <code>unreadEmailCount</code> from device <code>Mailer</code>.
    
    <pre>
    source unreadEmailCount as Integer;
    </pre>
    @param newUnreadEmailCountValue the new value for the source <code>unreadEmailCount</code>
    @return this for fluent interface
     */
    public MailerMock setUnreadEmailCount(java.lang.Integer newUnreadEmailCountValue) {
        __unreadEmailCount = newUnreadEmailCountValue;
        return this;
    }
    // End of code for source unreadEmailCount from device Mailer
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(message as Message);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(message as Message);
    </pre>
     * @param message parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message message) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!message.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
