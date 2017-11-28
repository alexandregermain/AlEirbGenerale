package fr.inria.phoenix.diasuite.framework.device.notifier;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
 * device Notifier extends HomeService {
 * 	source cancelled as Boolean indexed by id as String;
 * 	source expired as Boolean indexed by id as String;
 * 	source reply as Integer indexed by id as String;
 * 	action SendCriticalNotification;
 * 	action SendNonCriticalNotification;
 * }
 * </pre>
 */
public abstract class AbstractNotifier extends Service {
    
    public AbstractNotifier(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/HomeService/Notifier/", serviceConfiguration);
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
        if (orderName.equals("cancelCriticalNotification")) {
            cancelCriticalNotification((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("cancelNonCriticalNotification")) {
            cancelNonCriticalNotification((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("registerCriticalNotification")) {
            registerCriticalNotification((fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1]);
            return null;
        }
        if (orderName.equals("registerNonCriticalNotification")) {
            registerNonCriticalNotification((fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[2]);
            return null;
        }
        if (orderName.equals("sendCriticalNotification")) {
            sendCriticalNotification((fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification) args[0]);
            return null;
        }
        if (orderName.equals("sendNonCriticalNotification")) {
            sendNonCriticalNotification((fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("cancelled")) {
            return getCancelled((java.lang.String) args[0]);
        }
        if (orderName.equals("expired")) {
            return getExpired((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("reply")) {
            return getReply((java.lang.String) args[0]);
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source cancelled from device Notifier
    private java.util.HashMap<CancelledIndices, java.lang.Boolean> _cancelled = new java.util.HashMap<CancelledIndices, java.lang.Boolean>();
    
    /**
     * Publish the value of source <code>cancelled</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source cancelled as Boolean indexed by id as String;
     * </pre>
     * @param newCancelledValue the new value for the source <code>cancelled</code>
     * @param id the value of the index <code>id</code>
     */
    protected void publishCancelled(java.lang.Boolean newCancelledValue,
            java.lang.String id) {
        CancelledIndices _indices_ = new CancelledIndices(id);
        _cancelled.put(_indices_, newCancelledValue);
        getProcessor().publishValue(getOutProperties(), "cancelled", newCancelledValue, id); 
    }
    
    /**
     * Returns the value of source <code>cancelled</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source cancelled as Boolean indexed by id as String;
     * </pre>
     * @param id the value of the index <code>id</code>
     * @return the value of the source <code>cancelled</code>
     */
    protected java.lang.Boolean getCancelled(java.lang.String id) throws Exception {
        return _cancelled.get(new CancelledIndices(id));
    }
    // End of code for source cancelled from device Notifier
    
    // Code for source expired from device Notifier
    private java.util.HashMap<ExpiredIndices, java.lang.Boolean> _expired = new java.util.HashMap<ExpiredIndices, java.lang.Boolean>();
    
    /**
     * Publish the value of source <code>expired</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source expired as Boolean indexed by id as String;
     * </pre>
     * @param newExpiredValue the new value for the source <code>expired</code>
     * @param id the value of the index <code>id</code>
     */
    protected void publishExpired(java.lang.Boolean newExpiredValue,
            java.lang.String id) {
        ExpiredIndices _indices_ = new ExpiredIndices(id);
        _expired.put(_indices_, newExpiredValue);
        getProcessor().publishValue(getOutProperties(), "expired", newExpiredValue, id); 
    }
    
    /**
     * Returns the value of source <code>expired</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source expired as Boolean indexed by id as String;
     * </pre>
     * @param id the value of the index <code>id</code>
     * @return the value of the source <code>expired</code>
     */
    protected java.lang.Boolean getExpired(java.lang.String id) throws Exception {
        return _expired.get(new ExpiredIndices(id));
    }
    // End of code for source expired from device Notifier
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source reply from device Notifier
    private java.util.HashMap<ReplyIndices, java.lang.Integer> _reply = new java.util.HashMap<ReplyIndices, java.lang.Integer>();
    
    /**
     * Publish the value of source <code>reply</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source reply as Integer indexed by id as String;
     * </pre>
     * @param newReplyValue the new value for the source <code>reply</code>
     * @param id the value of the index <code>id</code>
     */
    protected void publishReply(java.lang.Integer newReplyValue,
            java.lang.String id) {
        ReplyIndices _indices_ = new ReplyIndices(id);
        _reply.put(_indices_, newReplyValue);
        getProcessor().publishValue(getOutProperties(), "reply", newReplyValue, id); 
    }
    
    /**
     * Returns the value of source <code>reply</code> from device <code>Notifier</code>.
     * 
     * <pre>
     * source reply as Integer indexed by id as String;
     * </pre>
     * @param id the value of the index <code>id</code>
     * @return the value of the source <code>reply</code>
     */
    protected java.lang.Integer getReply(java.lang.String id) throws Exception {
        return _reply.get(new ReplyIndices(id));
    }
    // End of code for source reply from device Notifier
    
    /**
     * Implement this method to define the <code>cancelCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * cancelCriticalNotification(id as String);
     * </pre>
     * @param id parameter 1 of the order.
     */
    protected abstract void cancelCriticalNotification(java.lang.String id) throws Exception;
    
    /**
     * Implement this method to define the <code>cancelNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * cancelNonCriticalNotification(id as String);
     * </pre>
     * @param id parameter 1 of the order.
     */
    protected abstract void cancelNonCriticalNotification(java.lang.String id) throws Exception;
    
    /**
     * Implement this method to define the <code>registerCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * registerCriticalNotification(notification as CriticalNotification, displayDate as Date);
     * </pre>
     * @param notification parameter 1 of the order.
     * @param displayDate parameter 2 of the order.
     */
    protected abstract void registerCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) throws Exception;
    
    /**
     * Implement this method to define the <code>registerNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date);
     * </pre>
     * @param notification parameter 1 of the order.
     * @param displayDate parameter 2 of the order.
     * @param expirationDate parameter 3 of the order.
     */
    protected abstract void registerNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date expirationDate) throws Exception;
    
    /**
     * Implement this method to define the <code>sendCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * sendCriticalNotification(notification as CriticalNotification);
     * </pre>
     * @param notification parameter 1 of the order.
     */
    protected abstract void sendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) throws Exception;
    
    /**
     * Implement this method to define the <code>sendNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier.
     * 
     * 
     * <pre>
     * sendNonCriticalNotification(notification as NonCriticalNotification);
     * </pre>
     * @param notification parameter 1 of the order.
     */
    protected abstract void sendNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) throws Exception;
}
