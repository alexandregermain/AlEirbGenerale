package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.activitynotifier.AbstractActivityNotifier;

// @internal
public final class ActivityNotifierMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractActivityNotifier {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity getDailyActivity() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity result = __dailyActivity;
            if(result == null)
                return super.getDailyActivity();
            return result;
        }
        
        public void _publishDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
            publishDailyActivity(newDailyActivityValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity getPeriodActivity() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity result = __periodActivity;
            if(result == null)
                return super.getPeriodActivity();
            return result;
        }
        
        public void _publishPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
            publishPeriodActivity(newPeriodActivityValue);
        }
        
        protected void notifyDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity activity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("notifyDailyActivity");
                __action.add(activity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void notifyPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity activity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("notifyPeriodActivity");
                __action.add(activity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    ActivityNotifierMock(ServiceConfiguration serviceConfiguration,
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
    public ActivityNotifierMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source dailyActivity from device ActivityNotifier
    /**
     * Publish the value of source <code>dailyActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source dailyActivity as DailyActivity;
    </pre>
    @param newDailyActivityValue the new value for the source <code>dailyActivity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock dailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
        proxy._publishDailyActivity(newDailyActivityValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity __dailyActivity = null;
    /**
     * Set the value (without publication) of source <code>dailyActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source dailyActivity as DailyActivity;
    </pre>
    @param newDailyActivityValue the new value for the source <code>dailyActivity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock setDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
        __dailyActivity = newDailyActivityValue;
        return this;
    }
    // End of code for source dailyActivity from device ActivityNotifier
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public ActivityNotifierMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source periodActivity from device ActivityNotifier
    /**
     * Publish the value of source <code>periodActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source periodActivity as PeriodActivity;
    </pre>
    @param newPeriodActivityValue the new value for the source <code>periodActivity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock periodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
        proxy._publishPeriodActivity(newPeriodActivityValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity __periodActivity = null;
    /**
     * Set the value (without publication) of source <code>periodActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source periodActivity as PeriodActivity;
    </pre>
    @param newPeriodActivityValue the new value for the source <code>periodActivity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock setPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
        __periodActivity = newPeriodActivityValue;
        return this;
    }
    // End of code for source periodActivity from device ActivityNotifier
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>notifyDailyActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    notifyDailyActivity(activity as DailyActivity);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectNotifyDailyActivity() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("notifyDailyActivity".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>notifyDailyActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    notifyDailyActivity(activity as DailyActivity);
    </pre>
     * @param activity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectNotifyDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity activity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("notifyDailyActivity".equals(__action.poll())))
                    return false;
                if(!activity.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>notifyPeriodActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    notifyPeriodActivity(activity as PeriodActivity);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectNotifyPeriodActivity() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("notifyPeriodActivity".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>notifyPeriodActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    notifyPeriodActivity(activity as PeriodActivity);
    </pre>
     * @param activity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectNotifyPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity activity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("notifyPeriodActivity".equals(__action.poll())))
                    return false;
                if(!activity.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
