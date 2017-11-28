package fr.inria.phoenix.diasuite.framework.device.agenda;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>nextEvents</code> of the device <code>Agenda</code>.
 *
 * <pre>
 * device Agenda extends HomeService {
 * 	attribute owner as String;
 * 	source currentEvents as AgendaEvent [];
 * 	source nextEvent as AgendaEvent;
 * 	source nextEvents as AgendaEvent [];
 * 	source events as AgendaEvent [] indexed by filter as AgendaEvent;
 * 	action AgendaEventAction;
 * }
 * </pre>
 */
public final class NextEventsFromAgenda implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value;
    
    /**
     * Get the value of the source <code>nextEvents</code>
     * 
     * @return the value of the source <code>nextEvents</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value() {
        return value;
    }
    
    public NextEventsFromAgenda(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value) {
        this.sender = new AgendaProxy(service, remoteServiceInfo);
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        NextEventsFromAgenda other = (NextEventsFromAgenda) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private AgendaProxy sender;
    
    /**
     * Get the sender of the source <code>nextEvents</code>. I.e., the <code>Agenda</code> device that published the source.
     * 
     * @return A proxy to the <code>Agenda</code> that triggered the source
     */
    public AgendaProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Agenda</code> that discloses subscription/unsubscription methods.
     */
    public class AgendaProxy extends Proxy {
        private AgendaProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>nextEvents</code> from this <code>Agenda</code>.
         */
        public void subscribeNextEvents() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "nextEvents");
        }
        
        /**
         * Unsubcribes from publication of source <code>nextEvents</code> from this <code>Agenda</code>.
         */
        public void unsubscribeNextEvents() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "nextEvents");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>owner</code> attribute
         */
        public java.lang.String owner() {
            return (java.lang.String) callGetValue("owner");
        }
    }
}
