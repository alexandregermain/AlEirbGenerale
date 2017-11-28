package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.agenda.AbstractAgenda;
import fr.inria.phoenix.diasuite.framework.device.agenda.EventsIndices;

// @internal
public final class AgendaMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractAgenda {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String ownerValue) {
            super(serviceConfiguration, idValue, ownerValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateOwner(java.lang.String newOwnerValue) {
            updateOwner(newOwnerValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getCurrentEvents() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> result = __currentEvents;
            if(result == null)
                return super.getCurrentEvents();
            return result;
        }
        
        public void _publishCurrentEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newCurrentEventsValue) {
            publishCurrentEvents(newCurrentEventsValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getEvents(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> result = __events.get(new EventsIndices(filter));
            if(result == null)
                return super.getEvents(filter);
            return result;
        }
        
        public void _publishEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newEventsValue,
                fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
            publishEvents(newEventsValue,
                filter);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent getNextEvent() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent result = __nextEvent;
            if(result == null)
                return super.getNextEvent();
            return result;
        }
        
        public void _publishNextEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newNextEventValue) {
            publishNextEvent(newNextEventValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getNextEvents() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> result = __nextEvents;
            if(result == null)
                return super.getNextEvents();
            return result;
        }
        
        public void _publishNextEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newNextEventsValue) {
            publishNextEvents(newNextEventsValue);
        }
        
        protected void addEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addEvent");
                __action.add(event);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeEvent");
                __action.add(event);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void replaceEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent oldEvent,
                fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newEvent) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("replaceEvent");
                __action.add(oldEvent);
                __action.add(newEvent);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    AgendaMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, ownerValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
     * 
     * <pre>
     * attribute id as String;
     * </pre>
     * @param newIdValue the new value of <code>id</code>
     * @return this for fluent interface
     */
    public AgendaMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute owner from device Agenda
    /**
     * Set the value of the <code>owner</code> attribute from device <code>Agenda</code>.
     * 
     * <pre>
     * attribute owner as String;
     * </pre>
     * @param newOwnerValue the new value of <code>owner</code>
     * @return this for fluent interface
     */
    public AgendaMock owner(java.lang.String newOwnerValue) {
        proxy._updateOwner(newOwnerValue);
        return this;
    }
    // End of code for the attribute owner from device Agenda
    
    // Code for source currentEvents from device Agenda
    /**
     * Publish the value of source <code>currentEvents</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source currentEvents as AgendaEvent [];
     * </pre>
     * @param newCurrentEventsValue the new value for the source <code>currentEvents</code>
     * @return this for fluent interface
     */
    public AgendaMock currentEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newCurrentEventsValue) {
        proxy._publishCurrentEvents(newCurrentEventsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> __currentEvents = null;
    /**
     * Set the value (without publication) of source <code>currentEvents</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source currentEvents as AgendaEvent [];
     * </pre>
     * @param newCurrentEventsValue the new value for the source <code>currentEvents</code>
     * @return this for fluent interface
     */
    public AgendaMock setCurrentEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newCurrentEventsValue) {
        __currentEvents = newCurrentEventsValue;
        return this;
    }
    // End of code for source currentEvents from device Agenda
    
    // Code for source events from device Agenda
    /**
     * Publish the value of source <code>events</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source events as AgendaEvent [] indexed by filter as AgendaEvent;
     * </pre>
     * @param newEventsValue the new value for the source <code>events</code>
     * @param filter the value of the index <code>filter</code>
     * @return this for fluent interface
     */
    public AgendaMock events(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newEventsValue,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
        proxy._publishEvents(newEventsValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<EventsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>> __events = new java.util.HashMap<EventsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>>();
    /**
     * Set the value (without publication) of source <code>events</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source events as AgendaEvent [] indexed by filter as AgendaEvent;
     * </pre>
     * @param newEventsValue the new value for the source <code>events</code>
     * @param filter the value of the index <code>filter</code>
     * @return this for fluent interface
     */
    public AgendaMock setEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newEventsValue,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
        EventsIndices _indices_ = new EventsIndices(filter);
        __events.put(_indices_, newEventsValue);
        return this;
    }
    // End of code for source events from device Agenda
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     * @return this for fluent interface
     */
    public AgendaMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
     * 
     * <pre>
     * source isAlive as Boolean;
     * </pre>
     * @param newIsAliveValue the new value for the source <code>isAlive</code>
     * @return this for fluent interface
     */
    public AgendaMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source nextEvent from device Agenda
    /**
     * Publish the value of source <code>nextEvent</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source nextEvent as AgendaEvent;
     * </pre>
     * @param newNextEventValue the new value for the source <code>nextEvent</code>
     * @return this for fluent interface
     */
    public AgendaMock nextEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newNextEventValue) {
        proxy._publishNextEvent(newNextEventValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent __nextEvent = null;
    /**
     * Set the value (without publication) of source <code>nextEvent</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source nextEvent as AgendaEvent;
     * </pre>
     * @param newNextEventValue the new value for the source <code>nextEvent</code>
     * @return this for fluent interface
     */
    public AgendaMock setNextEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newNextEventValue) {
        __nextEvent = newNextEventValue;
        return this;
    }
    // End of code for source nextEvent from device Agenda
    
    // Code for source nextEvents from device Agenda
    /**
     * Publish the value of source <code>nextEvents</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source nextEvents as AgendaEvent [];
     * </pre>
     * @param newNextEventsValue the new value for the source <code>nextEvents</code>
     * @return this for fluent interface
     */
    public AgendaMock nextEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newNextEventsValue) {
        proxy._publishNextEvents(newNextEventsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> __nextEvents = null;
    /**
     * Set the value (without publication) of source <code>nextEvents</code> from device <code>Agenda</code>.
     * 
     * <pre>
     * source nextEvents as AgendaEvent [];
     * </pre>
     * @param newNextEventsValue the new value for the source <code>nextEvents</code>
     * @return this for fluent interface
     */
    public AgendaMock setNextEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newNextEventsValue) {
        __nextEvents = newNextEventsValue;
        return this;
    }
    // End of code for source nextEvents from device Agenda
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * addEvent(event as AgendaEvent);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddEvent() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addEvent".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * addEvent(event as AgendaEvent);
     * </pre>
     * @param event parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addEvent".equals(__action.poll())))
                    return false;
                if(!event.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * removeEvent(event as AgendaEvent);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemoveEvent() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeEvent".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removeEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * removeEvent(event as AgendaEvent);
     * </pre>
     * @param event parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemoveEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeEvent".equals(__action.poll())))
                    return false;
                if(!event.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>replaceEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * replaceEvent(oldEvent as AgendaEvent, newEvent as AgendaEvent);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectReplaceEvent() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceEvent".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>replaceEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * replaceEvent(oldEvent as AgendaEvent, newEvent as AgendaEvent);
     * </pre>
     * @param oldEvent parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectReplaceEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent oldEvent) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceEvent".equals(__action.poll())))
                    return false;
                if(!oldEvent.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>replaceEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda was called.
     * 
     * 
     * <pre>
     * replaceEvent(oldEvent as AgendaEvent, newEvent as AgendaEvent);
     * </pre>
     * @param oldEvent parameter 1 of the order.
     * @param newEvent parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectReplaceEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent oldEvent,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newEvent) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceEvent".equals(__action.poll())))
                    return false;
                if(!oldEvent.equals(__action.poll()))
                    return false;
                if(!newEvent.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
