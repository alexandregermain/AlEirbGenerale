package fr.inria.phoenix.diasuite.framework.device.activitynotifier;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------------------------------------------------------------
ActivityNotifier					||
------------------------------------------------------------

<pre>
device ActivityNotifier extends SoftwareSensor {
 * 	source dailyActivity as DailyActivity;
 * 	source periodActivity as PeriodActivity;
 * 	action NotifyActivity;
 * }
</pre>
 */
public abstract class AbstractActivityNotifier extends Service {
    
    public AbstractActivityNotifier(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/SoftwareSensor/ActivityNotifier/", serviceConfiguration);
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
        if (orderName.equals("notifyDailyActivity")) {
            notifyDailyActivity((fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity) args[0]);
            return null;
        }
        if (orderName.equals("notifyPeriodActivity")) {
            notifyPeriodActivity((fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("dailyActivity")) {
            return getDailyActivity();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("periodActivity")) {
            return getPeriodActivity();
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
    
    // Code for source dailyActivity from device ActivityNotifier
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity _dailyActivity;
    
    /**
     * Publish the value of source <code>dailyActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source dailyActivity as DailyActivity;
    </pre>
    @param newDailyActivityValue the new value for the source <code>dailyActivity</code>
     */
    protected void publishDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
        _dailyActivity = newDailyActivityValue;
        getProcessor().publishValue(getOutProperties(), "dailyActivity", newDailyActivityValue); 
    }
    
    /**
     * Returns the value of source <code>dailyActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source dailyActivity as DailyActivity;
    </pre>
    @return the value of the source <code>dailyActivity</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity getDailyActivity() throws Exception {
        return _dailyActivity;
    }
    // End of code for source dailyActivity from device ActivityNotifier
    
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
    
    // Code for source periodActivity from device ActivityNotifier
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity _periodActivity;
    
    /**
     * Publish the value of source <code>periodActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source periodActivity as PeriodActivity;
    </pre>
    @param newPeriodActivityValue the new value for the source <code>periodActivity</code>
     */
    protected void publishPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
        _periodActivity = newPeriodActivityValue;
        getProcessor().publishValue(getOutProperties(), "periodActivity", newPeriodActivityValue); 
    }
    
    /**
     * Returns the value of source <code>periodActivity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source periodActivity as PeriodActivity;
    </pre>
    @return the value of the source <code>periodActivity</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity getPeriodActivity() throws Exception {
        return _periodActivity;
    }
    // End of code for source periodActivity from device ActivityNotifier
    
    /**
     * Implement this method to define the <code>notifyDailyActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier.
     * 
    
    <pre>
    notifyDailyActivity(activity as DailyActivity);
    </pre>
     * @param activity parameter 1 of the order.
     */
    protected abstract void notifyDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity activity) throws Exception;
    
    /**
     * Implement this method to define the <code>notifyPeriodActivity</code> order from the <code>NotifyActivity</code> action
     * defined in device ActivityNotifier.
     * 
    
    <pre>
    notifyPeriodActivity(activity as PeriodActivity);
    </pre>
     * @param activity parameter 1 of the order.
     */
    protected abstract void notifyPeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity activity) throws Exception;
}
