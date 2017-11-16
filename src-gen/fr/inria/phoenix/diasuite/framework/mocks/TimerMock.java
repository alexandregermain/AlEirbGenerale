package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.timer.AbstractTimer;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredIndices;

// @internal
public final class TimerMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTimer {
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
        
        protected java.lang.String getTimerTriggered(java.lang.String timerId) throws Exception {
            java.lang.String result = __timerTriggered.get(new TimerTriggeredIndices(timerId));
            if(result == null)
                return super.getTimerTriggered(timerId);
            return result;
        }
        
        public void _publishTimerTriggered(java.lang.String newTimerTriggeredValue,
                java.lang.String timerId) {
            publishTimerTriggered(newTimerTriggeredValue,
                timerId);
        }
        
        protected void cancel(java.lang.String id) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("cancel");
                __action.add(id);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void periodicSchedule(java.lang.String id,
                java.lang.Integer delayMs,
                java.lang.Integer periodMs) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("periodicSchedule");
                __action.add(id);
                __action.add(delayMs);
                __action.add(periodMs);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void schedule(java.lang.String id,
                java.lang.Integer delayMs) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("schedule");
                __action.add(id);
                __action.add(delayMs);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    TimerMock(ServiceConfiguration serviceConfiguration,
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
    public TimerMock id(java.lang.String newIdValue) {
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
    public TimerMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TimerMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source timerTriggered from device Timer
    /**
     * Publish the value of source <code>timerTriggered</code> from device <code>Timer</code>.
    
    <pre>
    source timerTriggered as String indexed by timerId as String;
    </pre>
    @param newTimerTriggeredValue the new value for the source <code>timerTriggered</code>
    @param timerId the value of the index <code>timerId</code>
    @return this for fluent interface
     */
    public TimerMock timerTriggered(java.lang.String newTimerTriggeredValue,
            java.lang.String timerId) {
        proxy._publishTimerTriggered(newTimerTriggeredValue,
            timerId);
        return this;
    }
    
    private java.util.HashMap<TimerTriggeredIndices, java.lang.String> __timerTriggered = new java.util.HashMap<TimerTriggeredIndices, java.lang.String>();
    /**
     * Set the value (without publication) of source <code>timerTriggered</code> from device <code>Timer</code>.
    
    <pre>
    source timerTriggered as String indexed by timerId as String;
    </pre>
    @param newTimerTriggeredValue the new value for the source <code>timerTriggered</code>
    @param timerId the value of the index <code>timerId</code>
    @return this for fluent interface
     */
    public TimerMock setTimerTriggered(java.lang.String newTimerTriggeredValue,
            java.lang.String timerId) {
        TimerTriggeredIndices _indices_ = new TimerTriggeredIndices(timerId);
        __timerTriggered.put(_indices_, newTimerTriggeredValue);
        return this;
    }
    // End of code for source timerTriggered from device Timer
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>cancel</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    cancel(id as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectCancel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>cancel</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    cancel(id as String);
    </pre>
     * @param id parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectCancel(java.lang.String id) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("cancel".equals(__action.poll())))
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
     * Check that the <code>periodicSchedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    periodicSchedule(id as String, delayMs as Integer, periodMs as Integer);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPeriodicSchedule() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("periodicSchedule".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>periodicSchedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    periodicSchedule(id as String, delayMs as Integer, periodMs as Integer);
    </pre>
     * @param id parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPeriodicSchedule(java.lang.String id) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("periodicSchedule".equals(__action.poll())))
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
     * Check that the <code>periodicSchedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    periodicSchedule(id as String, delayMs as Integer, periodMs as Integer);
    </pre>
     * @param id parameter 1 of the order.
     * @param delayMs parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPeriodicSchedule(java.lang.String id,
            java.lang.Integer delayMs) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("periodicSchedule".equals(__action.poll())))
                    return false;
                if(!id.equals(__action.poll()))
                    return false;
                if(!delayMs.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>periodicSchedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    periodicSchedule(id as String, delayMs as Integer, periodMs as Integer);
    </pre>
     * @param id parameter 1 of the order.
     * @param delayMs parameter 2 of the order.
     * @param periodMs parameter 3 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectPeriodicSchedule(java.lang.String id,
            java.lang.Integer delayMs,
            java.lang.Integer periodMs) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("periodicSchedule".equals(__action.poll())))
                    return false;
                if(!id.equals(__action.poll()))
                    return false;
                if(!delayMs.equals(__action.poll()))
                    return false;
                if(!periodMs.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>schedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    schedule(id as String, delayMs as Integer);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSchedule() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("schedule".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>schedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    schedule(id as String, delayMs as Integer);
    </pre>
     * @param id parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSchedule(java.lang.String id) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("schedule".equals(__action.poll())))
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
     * Check that the <code>schedule</code> order from the <code>ScheduleTimer</code> action
     * defined in device Timer was called.
     * 
    
    <pre>
    schedule(id as String, delayMs as Integer);
    </pre>
     * @param id parameter 1 of the order.
     * @param delayMs parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSchedule(java.lang.String id,
            java.lang.Integer delayMs) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("schedule".equals(__action.poll())))
                    return false;
                if(!id.equals(__action.poll()))
                    return false;
                if(!delayMs.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
