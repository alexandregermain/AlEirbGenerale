package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.clock.AbstractClock;

// @internal
public final class ClockMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractClock {
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
        
        protected java.lang.Integer getTickHour() throws Exception {
            java.lang.Integer result = __tickHour;
            if(result == null)
                return super.getTickHour();
            return result;
        }
        
        public void _publishTickHour(java.lang.Integer newTickHourValue) {
            publishTickHour(newTickHourValue);
        }
        
        protected java.lang.Integer getTickMinute() throws Exception {
            java.lang.Integer result = __tickMinute;
            if(result == null)
                return super.getTickMinute();
            return result;
        }
        
        public void _publishTickMinute(java.lang.Integer newTickMinuteValue) {
            publishTickMinute(newTickMinuteValue);
        }
        
        protected java.lang.Integer getTickSecond() throws Exception {
            java.lang.Integer result = __tickSecond;
            if(result == null)
                return super.getTickSecond();
            return result;
        }
        
        public void _publishTickSecond(java.lang.Integer newTickSecondValue) {
            publishTickSecond(newTickSecondValue);
        }
    }
    
    Proxy proxy;
    
    ClockMock(ServiceConfiguration serviceConfiguration,
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
    public ClockMock id(java.lang.String newIdValue) {
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
    public ClockMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public ClockMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source tickHour from device Clock
    /**
     * Publish the value of source <code>tickHour</code> from device <code>Clock</code>.
    
    <pre>
    source tickHour as Integer;
    </pre>
    @param newTickHourValue the new value for the source <code>tickHour</code>
    @return this for fluent interface
     */
    public ClockMock tickHour(java.lang.Integer newTickHourValue) {
        proxy._publishTickHour(newTickHourValue);
        return this;
    }
    
    private java.lang.Integer __tickHour = null;
    /**
     * Set the value (without publication) of source <code>tickHour</code> from device <code>Clock</code>.
    
    <pre>
    source tickHour as Integer;
    </pre>
    @param newTickHourValue the new value for the source <code>tickHour</code>
    @return this for fluent interface
     */
    public ClockMock setTickHour(java.lang.Integer newTickHourValue) {
        __tickHour = newTickHourValue;
        return this;
    }
    // End of code for source tickHour from device Clock
    
    // Code for source tickMinute from device Clock
    /**
     * Publish the value of source <code>tickMinute</code> from device <code>Clock</code>.
    
    <pre>
    source tickMinute as Integer;
    </pre>
    @param newTickMinuteValue the new value for the source <code>tickMinute</code>
    @return this for fluent interface
     */
    public ClockMock tickMinute(java.lang.Integer newTickMinuteValue) {
        proxy._publishTickMinute(newTickMinuteValue);
        return this;
    }
    
    private java.lang.Integer __tickMinute = null;
    /**
     * Set the value (without publication) of source <code>tickMinute</code> from device <code>Clock</code>.
    
    <pre>
    source tickMinute as Integer;
    </pre>
    @param newTickMinuteValue the new value for the source <code>tickMinute</code>
    @return this for fluent interface
     */
    public ClockMock setTickMinute(java.lang.Integer newTickMinuteValue) {
        __tickMinute = newTickMinuteValue;
        return this;
    }
    // End of code for source tickMinute from device Clock
    
    // Code for source tickSecond from device Clock
    /**
     * Publish the value of source <code>tickSecond</code> from device <code>Clock</code>.
    
    <pre>
    source tickSecond as Integer;
    </pre>
    @param newTickSecondValue the new value for the source <code>tickSecond</code>
    @return this for fluent interface
     */
    public ClockMock tickSecond(java.lang.Integer newTickSecondValue) {
        proxy._publishTickSecond(newTickSecondValue);
        return this;
    }
    
    private java.lang.Integer __tickSecond = null;
    /**
     * Set the value (without publication) of source <code>tickSecond</code> from device <code>Clock</code>.
    
    <pre>
    source tickSecond as Integer;
    </pre>
    @param newTickSecondValue the new value for the source <code>tickSecond</code>
    @return this for fluent interface
     */
    public ClockMock setTickSecond(java.lang.Integer newTickSecondValue) {
        __tickSecond = newTickSecondValue;
        return this;
    }
    // End of code for source tickSecond from device Clock
}
