package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.routinescheduler.AbstractRoutineScheduler;

// @internal
public final class RoutineSchedulerMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractRoutineScheduler {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime getCurrentTime() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime result = __currentTime;
            if(result == null)
                return super.getCurrentTime();
            return result;
        }
        
        public void _publishCurrentTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newCurrentTimeValue) {
            publishCurrentTime(newCurrentTimeValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getStartMonitoring() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName result = __startMonitoring;
            if(result == null)
                return super.getStartMonitoring();
            return result;
        }
        
        public void _publishStartMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStartMonitoringValue) {
            publishStartMonitoring(newStartMonitoringValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getStopMonitoring() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName result = __stopMonitoring;
            if(result == null)
                return super.getStopMonitoring();
            return result;
        }
        
        public void _publishStopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStopMonitoringValue) {
            publishStopMonitoring(newStopMonitoringValue);
        }
        
        protected void startMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("startMonitoring");
                __action.add(activity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void stopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("stopMonitoring");
                __action.add(activity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void updateDayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime currentTime) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("updateDayTime");
                __action.add(currentTime);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    RoutineSchedulerMock(ServiceConfiguration serviceConfiguration,
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
    public RoutineSchedulerMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source currentTime from device RoutineScheduler
    /**
     * Publish the value of source <code>currentTime</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source currentTime as DayTime;
    </pre>
    @param newCurrentTimeValue the new value for the source <code>currentTime</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock currentTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newCurrentTimeValue) {
        proxy._publishCurrentTime(newCurrentTimeValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime __currentTime = null;
    /**
     * Set the value (without publication) of source <code>currentTime</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source currentTime as DayTime;
    </pre>
    @param newCurrentTimeValue the new value for the source <code>currentTime</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock setCurrentTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newCurrentTimeValue) {
        __currentTime = newCurrentTimeValue;
        return this;
    }
    // End of code for source currentTime from device RoutineScheduler
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public RoutineSchedulerMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source startMonitoring from device RoutineScheduler
    /**
     * Publish the value of source <code>startMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source startMonitoring as DailyActivityName;
    </pre>
    @param newStartMonitoringValue the new value for the source <code>startMonitoring</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock startMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStartMonitoringValue) {
        proxy._publishStartMonitoring(newStartMonitoringValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName __startMonitoring = null;
    /**
     * Set the value (without publication) of source <code>startMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source startMonitoring as DailyActivityName;
    </pre>
    @param newStartMonitoringValue the new value for the source <code>startMonitoring</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock setStartMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStartMonitoringValue) {
        __startMonitoring = newStartMonitoringValue;
        return this;
    }
    // End of code for source startMonitoring from device RoutineScheduler
    
    // Code for source stopMonitoring from device RoutineScheduler
    /**
     * Publish the value of source <code>stopMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source stopMonitoring as DailyActivityName;
    </pre>
    @param newStopMonitoringValue the new value for the source <code>stopMonitoring</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock stopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStopMonitoringValue) {
        proxy._publishStopMonitoring(newStopMonitoringValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName __stopMonitoring = null;
    /**
     * Set the value (without publication) of source <code>stopMonitoring</code> from device <code>RoutineScheduler</code>.
    
    <pre>
    source stopMonitoring as DailyActivityName;
    </pre>
    @param newStopMonitoringValue the new value for the source <code>stopMonitoring</code>
    @return this for fluent interface
     */
    public RoutineSchedulerMock setStopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newStopMonitoringValue) {
        __stopMonitoring = newStopMonitoringValue;
        return this;
    }
    // End of code for source stopMonitoring from device RoutineScheduler
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>startMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    startMonitoring(activity as DailyActivityName);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectStartMonitoring() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("startMonitoring".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>startMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    startMonitoring(activity as DailyActivityName);
    </pre>
     * @param activity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectStartMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("startMonitoring".equals(__action.poll())))
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
     * Check that the <code>stopMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    stopMonitoring(activity as DailyActivityName);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectStopMonitoring() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("stopMonitoring".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>stopMonitoring</code> order from the <code>UpdateRoutines</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    stopMonitoring(activity as DailyActivityName);
    </pre>
     * @param activity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectStopMonitoring(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName activity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("stopMonitoring".equals(__action.poll())))
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
     * Check that the <code>updateDayTime</code> order from the <code>UpdateDayTime</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    updateDayTime(currentTime as DayTime);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdateDayTime() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateDayTime".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>updateDayTime</code> order from the <code>UpdateDayTime</code> action
     * defined in device RoutineScheduler was called.
     * 
    
    <pre>
    updateDayTime(currentTime as DayTime);
    </pre>
     * @param currentTime parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdateDayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime currentTime) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateDayTime".equals(__action.poll())))
                    return false;
                if(!currentTime.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
