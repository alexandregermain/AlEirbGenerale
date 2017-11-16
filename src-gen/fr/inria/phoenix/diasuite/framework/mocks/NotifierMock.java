package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.notifier.AbstractNotifier;
import fr.inria.phoenix.diasuite.framework.device.notifier.ExpiredIndices;
import fr.inria.phoenix.diasuite.framework.device.notifier.CancelledIndices;
import fr.inria.phoenix.diasuite.framework.device.notifier.ReplyIndices;

// @internal
public final class NotifierMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractNotifier {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.lang.Boolean getCancelled(java.lang.String id) throws Exception {
            java.lang.Boolean result = __cancelled.get(new CancelledIndices(id));
            if(result == null)
                return super.getCancelled(id);
            return result;
        }
        
        public void _publishCancelled(java.lang.Boolean newCancelledValue,
                java.lang.String id) {
            publishCancelled(newCancelledValue,
                id);
        }
        
        protected java.lang.Boolean getExpired(java.lang.String id) throws Exception {
            java.lang.Boolean result = __expired.get(new ExpiredIndices(id));
            if(result == null)
                return super.getExpired(id);
            return result;
        }
        
        public void _publishExpired(java.lang.Boolean newExpiredValue,
                java.lang.String id) {
            publishExpired(newExpiredValue,
                id);
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
        
        protected java.lang.Integer getReply(java.lang.String id) throws Exception {
            java.lang.Integer result = __reply.get(new ReplyIndices(id));
            if(result == null)
                return super.getReply(id);
            return result;
        }
        
        public void _publishReply(java.lang.Integer newReplyValue,
                java.lang.String id) {
            publishReply(newReplyValue,
                id);
        }
        
        protected void cancelCriticalNotification(java.lang.String id) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("cancelCriticalNotification");
                __action.add(id);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void cancelNonCriticalNotification(java.lang.String id) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("cancelNonCriticalNotification");
                __action.add(id);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void registerCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("registerCriticalNotification");
                __action.add(notification);
                __action.add(displayDate);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void registerNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date expirationDate) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("registerNonCriticalNotification");
                __action.add(notification);
                __action.add(displayDate);
                __action.add(expirationDate);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendCriticalNotification");
                __action.add(notification);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendNonCriticalNotification");
                __action.add(notification);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    NotifierMock(ServiceConfiguration serviceConfiguration,
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
    public NotifierMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source cancelled from device Notifier
    /**
     * Publish the value of source <code>cancelled</code> from device <code>Notifier</code>.
    
    <pre>
    source cancelled as Boolean indexed by id as String;
    </pre>
    @param newCancelledValue the new value for the source <code>cancelled</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock cancelled(java.lang.Boolean newCancelledValue,
            java.lang.String id) {
        proxy._publishCancelled(newCancelledValue,
            id);
        return this;
    }
    
    private java.util.HashMap<CancelledIndices, java.lang.Boolean> __cancelled = new java.util.HashMap<CancelledIndices, java.lang.Boolean>();
    /**
     * Set the value (without publication) of source <code>cancelled</code> from device <code>Notifier</code>.
    
    <pre>
    source cancelled as Boolean indexed by id as String;
    </pre>
    @param newCancelledValue the new value for the source <code>cancelled</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock setCancelled(java.lang.Boolean newCancelledValue,
            java.lang.String id) {
        CancelledIndices _indices_ = new CancelledIndices(id);
        __cancelled.put(_indices_, newCancelledValue);
        return this;
    }
    // End of code for source cancelled from device Notifier
    
    // Code for source expired from device Notifier
    /**
     * Publish the value of source <code>expired</code> from device <code>Notifier</code>.
    
    <pre>
    source expired as Boolean indexed by id as String;
    </pre>
    @param newExpiredValue the new value for the source <code>expired</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock expired(java.lang.Boolean newExpiredValue,
            java.lang.String id) {
        proxy._publishExpired(newExpiredValue,
            id);
        return this;
    }
    
    private java.util.HashMap<ExpiredIndices, java.lang.Boolean> __expired = new java.util.HashMap<ExpiredIndices, java.lang.Boolean>();
    /**
     * Set the value (without publication) of source <code>expired</code> from device <code>Notifier</code>.
    
    <pre>
    source expired as Boolean indexed by id as String;
    </pre>
    @param newExpiredValue the new value for the source <code>expired</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock setExpired(java.lang.Boolean newExpiredValue,
            java.lang.String id) {
        ExpiredIndices _indices_ = new ExpiredIndices(id);
        __expired.put(_indices_, newExpiredValue);
        return this;
    }
    // End of code for source expired from device Notifier
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public NotifierMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public NotifierMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source reply from device Notifier
    /**
     * Publish the value of source <code>reply</code> from device <code>Notifier</code>.
    
    <pre>
    source reply as Integer indexed by id as String;
    </pre>
    @param newReplyValue the new value for the source <code>reply</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock reply(java.lang.Integer newReplyValue,
            java.lang.String id) {
        proxy._publishReply(newReplyValue,
            id);
        return this;
    }
    
    private java.util.HashMap<ReplyIndices, java.lang.Integer> __reply = new java.util.HashMap<ReplyIndices, java.lang.Integer>();
    /**
     * Set the value (without publication) of source <code>reply</code> from device <code>Notifier</code>.
    
    <pre>
    source reply as Integer indexed by id as String;
    </pre>
    @param newReplyValue the new value for the source <code>reply</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public NotifierMock setReply(java.lang.Integer newReplyValue,
            java.lang.String id) {
        ReplyIndices _indices_ = new ReplyIndices(id);
        __reply.put(_indices_, newReplyValue);
        return this;
    }
    // End of code for source reply from device Notifier
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>cancelCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    cancelCriticalNotification(id as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectCancelCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancelCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>cancelCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    cancelCriticalNotification(id as String);
    </pre>
     * @param id parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectCancelCriticalNotification(java.lang.String id) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancelCriticalNotification".equals(__action.poll())))
                    return false;
                if(!id.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>cancelNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    cancelNonCriticalNotification(id as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectCancelNonCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancelNonCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>cancelNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    cancelNonCriticalNotification(id as String);
    </pre>
     * @param id parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectCancelNonCriticalNotification(java.lang.String id) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancelNonCriticalNotification".equals(__action.poll())))
                    return false;
                if(!id.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>registerCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerCriticalNotification(notification as CriticalNotification, displayDate as Date);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRegisterCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>registerCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerCriticalNotification(notification as CriticalNotification, displayDate as Date);
    </pre>
     * @param notification parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRegisterCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>registerCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerCriticalNotification(notification as CriticalNotification, displayDate as Date);
    </pre>
     * @param notification parameter 1 of the order.
     * @param displayDate parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRegisterCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                if(!displayDate.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>registerNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRegisterNonCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerNonCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>registerNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date);
    </pre>
     * @param notification parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRegisterNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerNonCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>registerNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date);
    </pre>
     * @param notification parameter 1 of the order.
     * @param displayDate parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRegisterNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerNonCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                if(!displayDate.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>registerNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    registerNonCriticalNotification(notification as NonCriticalNotification, displayDate as Date, expirationDate as Date);
    </pre>
     * @param notification parameter 1 of the order.
     * @param displayDate parameter 2 of the order.
     * @param expirationDate parameter 3 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRegisterNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date displayDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date expirationDate) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("registerNonCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                if(!displayDate.equals(__action.poll()))
                    return false;
                if(!expirationDate.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    sendCriticalNotification(notification as CriticalNotification);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendCriticalNotification</code> order from the <code>SendCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    sendCriticalNotification(notification as CriticalNotification);
    </pre>
     * @param notification parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification notification) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    sendNonCriticalNotification(notification as NonCriticalNotification);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendNonCriticalNotification() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendNonCriticalNotification".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendNonCriticalNotification</code> order from the <code>SendNonCriticalNotification</code> action
     * defined in device Notifier was called.
     * 
    
    <pre>
    sendNonCriticalNotification(notification as NonCriticalNotification);
    </pre>
     * @param notification parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendNonCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendNonCriticalNotification".equals(__action.poll())))
                    return false;
                if(!notification.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
