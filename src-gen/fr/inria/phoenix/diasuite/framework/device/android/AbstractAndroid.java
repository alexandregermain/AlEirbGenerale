package fr.inria.phoenix.diasuite.framework.device.android;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
 * device Android extends Device {
 * 	attribute type as String;
 * 	attribute version as Integer;
 * 	source battery as Battery;
 * 	source soundLevels as SoundLevel [];
 * 	source screenOn as Boolean;
 * 	source apps as AndroidApp [];
 * 	action ScreenAction;
 * 	action SoundAction;
 * 	action ActivityAction;
 * }
 * </pre>
 */
public abstract class AbstractAndroid extends Service {
    
    public AbstractAndroid(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String typeValue,
            java.lang.Integer versionValue) {
        super("/Device/Device/Android/", serviceConfiguration);
        updateId(idValue);
        updateType(typeValue);
        updateVersion(versionValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("type", _type);
        attributes.put("version", _version);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("setScreenStatus")) {
            setScreenStatus((java.lang.Boolean) args[0]);
            return null;
        }
        if (orderName.equals("setSoundLevel")) {
            setSoundLevel((java.lang.Integer) args[0]);
            return null;
        }
        if (orderName.equals("startActivity")) {
            startActivity((fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("type")) {
            return _type;
        }
        if (orderName.equals("version")) {
            return _version;
        }
        if (orderName.equals("apps")) {
            return getApps();
        }
        if (orderName.equals("battery")) {
            return getBattery();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("screenOn")) {
            return getScreenOn();
        }
        if (orderName.equals("soundLevels")) {
            return getSoundLevels();
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
    
    // Code for the attribute type from device Android
    private java.lang.String _type;
    
    /**
     * Set the value of the <code>type</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute type as String;
     * </pre>
     * @param newTypeValue the new value of <code>type</code>
     */
    protected void updateType(java.lang.String newTypeValue) {
        if (_type != newTypeValue) {
            _type = newTypeValue;
            updateAttribute("type", newTypeValue);
        }
    }
    
    /**
     * Returns the value of the <code>type</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute type as String;
     * </pre>
     * @return the value of <code>type</code>
     */
    public java.lang.String getType() {
        return _type;
    }
    // End of code for the attribute type from device Android
    
    // Code for the attribute version from device Android
    private java.lang.Integer _version;
    
    /**
     * Set the value of the <code>version</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute version as Integer;
     * </pre>
     * @param newVersionValue the new value of <code>version</code>
     */
    protected void updateVersion(java.lang.Integer newVersionValue) {
        if (_version != newVersionValue) {
            _version = newVersionValue;
            updateAttribute("version", newVersionValue);
        }
    }
    
    /**
     * Returns the value of the <code>version</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute version as Integer;
     * </pre>
     * @return the value of <code>version</code>
     */
    public java.lang.Integer getVersion() {
        return _version;
    }
    // End of code for the attribute version from device Android
    
    // Code for source apps from device Android
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> _apps;
    
    /**
     * Publish the value of source <code>apps</code> from device <code>Android</code>.
     * 
     * <pre>
     * source apps as AndroidApp [];
     * </pre>
     * @param newAppsValue the new value for the source <code>apps</code>
     */
    protected void publishApps(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> newAppsValue) {
        _apps = newAppsValue;
        getProcessor().publishValue(getOutProperties(), "apps", newAppsValue); 
    }
    
    /**
     * Returns the value of source <code>apps</code> from device <code>Android</code>.
     * 
     * <pre>
     * source apps as AndroidApp [];
     * </pre>
     * @return the value of the source <code>apps</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> getApps() throws Exception {
        return _apps;
    }
    // End of code for source apps from device Android
    
    // Code for source battery from device Android
    private fr.inria.phoenix.diasuite.framework.datatype.battery.Battery _battery;
    
    /**
     * Publish the value of source <code>battery</code> from device <code>Android</code>.
     * 
     * <pre>
     * source battery as Battery;
     * </pre>
     * @param newBatteryValue the new value for the source <code>battery</code>
     */
    protected void publishBattery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
        _battery = newBatteryValue;
        getProcessor().publishValue(getOutProperties(), "battery", newBatteryValue); 
    }
    
    /**
     * Returns the value of source <code>battery</code> from device <code>Android</code>.
     * 
     * <pre>
     * source battery as Battery;
     * </pre>
     * @return the value of the source <code>battery</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.battery.Battery getBattery() throws Exception {
        return _battery;
    }
    // End of code for source battery from device Android
    
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
    
    // Code for source screenOn from device Android
    private java.lang.Boolean _screenOn;
    
    /**
     * Publish the value of source <code>screenOn</code> from device <code>Android</code>.
     * 
     * <pre>
     * source screenOn as Boolean;
     * </pre>
     * @param newScreenOnValue the new value for the source <code>screenOn</code>
     */
    protected void publishScreenOn(java.lang.Boolean newScreenOnValue) {
        _screenOn = newScreenOnValue;
        getProcessor().publishValue(getOutProperties(), "screenOn", newScreenOnValue); 
    }
    
    /**
     * Returns the value of source <code>screenOn</code> from device <code>Android</code>.
     * 
     * <pre>
     * source screenOn as Boolean;
     * </pre>
     * @return the value of the source <code>screenOn</code>
     */
    protected java.lang.Boolean getScreenOn() throws Exception {
        return _screenOn;
    }
    // End of code for source screenOn from device Android
    
    // Code for source soundLevels from device Android
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> _soundLevels;
    
    /**
     * Publish the value of source <code>soundLevels</code> from device <code>Android</code>.
     * 
     * <pre>
     * source soundLevels as SoundLevel [];
     * </pre>
     * @param newSoundLevelsValue the new value for the source <code>soundLevels</code>
     */
    protected void publishSoundLevels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> newSoundLevelsValue) {
        _soundLevels = newSoundLevelsValue;
        getProcessor().publishValue(getOutProperties(), "soundLevels", newSoundLevelsValue); 
    }
    
    /**
     * Returns the value of source <code>soundLevels</code> from device <code>Android</code>.
     * 
     * <pre>
     * source soundLevels as SoundLevel [];
     * </pre>
     * @return the value of the source <code>soundLevels</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> getSoundLevels() throws Exception {
        return _soundLevels;
    }
    // End of code for source soundLevels from device Android
    
    /**
     * Implement this method to define the <code>setScreenStatus</code> order from the <code>ScreenAction</code> action
     * defined in device Android.
     * 
     * 
     * <pre>
     * setScreenStatus(turnOn as Boolean);
     * </pre>
     * @param turnOn parameter 1 of the order.
     */
    protected abstract void setScreenStatus(java.lang.Boolean turnOn) throws Exception;
    
    /**
     * Implement this method to define the <code>setSoundLevel</code> order from the <code>SoundAction</code> action
     * defined in device Android.
     * 
     * 
     * <pre>
     * setSoundLevel(level as Integer);
     * </pre>
     * @param level parameter 1 of the order.
     */
    protected abstract void setSoundLevel(java.lang.Integer level) throws Exception;
    
    /**
     * Implement this method to define the <code>startActivity</code> order from the <code>ActivityAction</code> action
     * defined in device Android.
     * 
     * 
     * <pre>
     * startActivity(intent as AndroidIntent);
     * </pre>
     * @param intent parameter 1 of the order.
     */
    protected abstract void startActivity(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent intent) throws Exception;
}
