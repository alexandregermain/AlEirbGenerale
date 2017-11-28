package fr.inria.phoenix.diasuite.framework.device.agenda;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device Agenda extends HomeService {
 * 	attribute owner as String;
 * 	source currentEvents as AgendaEvent [];
 * 	source nextEvent as AgendaEvent;
 * 	source nextEvents as AgendaEvent [];
 * 	source events as AgendaEvent [] indexed by filter as AgendaEvent;
 * 	action AgendaEventAction;
 * }
</pre>
 */
public abstract class AbstractAgenda extends Service {
    
    public AbstractAgenda(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        super("/Device/Device/Service/HomeService/Agenda/", serviceConfiguration);
        updateId(idValue);
        updateOwner(ownerValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("owner", _owner);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("addEvent")) {
            addEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent) args[0]);
            return null;
        }
        if (orderName.equals("removeEvent")) {
            removeEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent) args[0]);
            return null;
        }
        if (orderName.equals("replaceEvent")) {
            replaceEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("owner")) {
            return _owner;
        }
        if (orderName.equals("currentEvents")) {
            return getCurrentEvents();
        }
        if (orderName.equals("events")) {
            return getEvents((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("nextEvent")) {
            return getNextEvent();
        }
        if (orderName.equals("nextEvents")) {
            return getNextEvents();
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
    
    // Code for the attribute owner from device Agenda
    private java.lang.String _owner;
    
    /**
     * Set the value of the <code>owner</code> attribute from device <code>Agenda</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @param newOwnerValue the new value of <code>owner</code>
     */
    protected void updateOwner(java.lang.String newOwnerValue) {
        if (_owner != newOwnerValue) {
            _owner = newOwnerValue;
            updateAttribute("owner", newOwnerValue);
        }
    }
    
    /**
     * Returns the value of the <code>owner</code> attribute from device <code>Agenda</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @return the value of <code>owner</code>
     */
    public java.lang.String getOwner() {
        return _owner;
    }
    // End of code for the attribute owner from device Agenda
    
    // Code for source currentEvents from device Agenda
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> _currentEvents;
    
    /**
     * Publish the value of source <code>currentEvents</code> from device <code>Agenda</code>.
    
    <pre>
    source currentEvents as AgendaEvent [];
    </pre>
    @param newCurrentEventsValue the new value for the source <code>currentEvents</code>
     */
    protected void publishCurrentEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newCurrentEventsValue) {
        _currentEvents = newCurrentEventsValue;
        getProcessor().publishValue(getOutProperties(), "currentEvents", newCurrentEventsValue); 
    }
    
    /**
     * Returns the value of source <code>currentEvents</code> from device <code>Agenda</code>.
    
    <pre>
    source currentEvents as AgendaEvent [];
    </pre>
    @return the value of the source <code>currentEvents</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getCurrentEvents() throws Exception {
        return _currentEvents;
    }
    // End of code for source currentEvents from device Agenda
    
    // Code for source events from device Agenda
    private java.util.HashMap<EventsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>> _events = new java.util.HashMap<EventsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>>();
    
    /**
     * Publish the value of source <code>events</code> from device <code>Agenda</code>.
    
    <pre>
    source events as AgendaEvent [] indexed by filter as AgendaEvent;
    </pre>
    @param newEventsValue the new value for the source <code>events</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newEventsValue,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
        EventsIndices _indices_ = new EventsIndices(filter);
        _events.put(_indices_, newEventsValue);
        getProcessor().publishValue(getOutProperties(), "events", newEventsValue, filter); 
    }
    
    /**
     * Returns the value of source <code>events</code> from device <code>Agenda</code>.
    
    <pre>
    source events as AgendaEvent [] indexed by filter as AgendaEvent;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>events</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getEvents(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) throws Exception {
        return _events.get(new EventsIndices(filter));
    }
    // End of code for source events from device Agenda
    
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
    
    // Code for source nextEvent from device Agenda
    private fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent _nextEvent;
    
    /**
     * Publish the value of source <code>nextEvent</code> from device <code>Agenda</code>.
    
    <pre>
    source nextEvent as AgendaEvent;
    </pre>
    @param newNextEventValue the new value for the source <code>nextEvent</code>
     */
    protected void publishNextEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newNextEventValue) {
        _nextEvent = newNextEventValue;
        getProcessor().publishValue(getOutProperties(), "nextEvent", newNextEventValue); 
    }
    
    /**
     * Returns the value of source <code>nextEvent</code> from device <code>Agenda</code>.
    
    <pre>
    source nextEvent as AgendaEvent;
    </pre>
    @return the value of the source <code>nextEvent</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent getNextEvent() throws Exception {
        return _nextEvent;
    }
    // End of code for source nextEvent from device Agenda
    
    // Code for source nextEvents from device Agenda
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> _nextEvents;
    
    /**
     * Publish the value of source <code>nextEvents</code> from device <code>Agenda</code>.
    
    <pre>
    source nextEvents as AgendaEvent [];
    </pre>
    @param newNextEventsValue the new value for the source <code>nextEvents</code>
     */
    protected void publishNextEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newNextEventsValue) {
        _nextEvents = newNextEventsValue;
        getProcessor().publishValue(getOutProperties(), "nextEvents", newNextEventsValue); 
    }
    
    /**
     * Returns the value of source <code>nextEvents</code> from device <code>Agenda</code>.
    
    <pre>
    source nextEvents as AgendaEvent [];
    </pre>
    @return the value of the source <code>nextEvents</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getNextEvents() throws Exception {
        return _nextEvents;
    }
    // End of code for source nextEvents from device Agenda
    
    /**
     * Implement this method to define the <code>addEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda.
     * 
    
    <pre>
    addEvent(event as AgendaEvent);
    </pre>
     * @param event parameter 1 of the order.
     */
    protected abstract void addEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception;
    
    /**
     * Implement this method to define the <code>removeEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda.
     * 
    
    <pre>
    removeEvent(event as AgendaEvent);
    </pre>
     * @param event parameter 1 of the order.
     */
    protected abstract void removeEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception;
    
    /**
     * Implement this method to define the <code>replaceEvent</code> order from the <code>AgendaEventAction</code> action
     * defined in device Agenda.
     * 
    
    <pre>
    replaceEvent(oldEvent as AgendaEvent, newEvent as AgendaEvent);
    </pre>
     * @param oldEvent parameter 1 of the order.
     * @param newEvent parameter 2 of the order.
     */
    protected abstract void replaceEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent oldEvent,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newEvent) throws Exception;
}
