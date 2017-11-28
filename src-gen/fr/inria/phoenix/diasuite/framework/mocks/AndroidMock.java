package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.android.AbstractAndroid;

// @internal
public final class AndroidMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractAndroid {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String typeValue,
                java.lang.Integer versionValue) {
            super(serviceConfiguration, idValue, typeValue, versionValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateType(java.lang.String newTypeValue) {
            updateType(newTypeValue);
        }
        
        public void _updateVersion(java.lang.Integer newVersionValue) {
            updateVersion(newVersionValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> getApps() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> result = __apps;
            if(result == null)
                return super.getApps();
            return result;
        }
        
        public void _publishApps(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> newAppsValue) {
            publishApps(newAppsValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.battery.Battery getBattery() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.battery.Battery result = __battery;
            if(result == null)
                return super.getBattery();
            return result;
        }
        
        public void _publishBattery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
            publishBattery(newBatteryValue);
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
        
        protected java.lang.Boolean getScreenOn() throws Exception {
            java.lang.Boolean result = __screenOn;
            if(result == null)
                return super.getScreenOn();
            return result;
        }
        
        public void _publishScreenOn(java.lang.Boolean newScreenOnValue) {
            publishScreenOn(newScreenOnValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> getSoundLevels() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> result = __soundLevels;
            if(result == null)
                return super.getSoundLevels();
            return result;
        }
        
        public void _publishSoundLevels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> newSoundLevelsValue) {
            publishSoundLevels(newSoundLevelsValue);
        }
        
        protected void setScreenStatus(java.lang.Boolean turnOn) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setScreenStatus");
                __action.add(turnOn);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void setSoundLevel(java.lang.Integer level) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setSoundLevel");
                __action.add(level);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void startActivity(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent intent) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("startActivity");
                __action.add(intent);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    AndroidMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String typeValue,
            java.lang.Integer versionValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, typeValue, versionValue);
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
    public AndroidMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute type from device Android
    /**
     * Set the value of the <code>type</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute type as String;
     * </pre>
     * @param newTypeValue the new value of <code>type</code>
     * @return this for fluent interface
     */
    public AndroidMock type(java.lang.String newTypeValue) {
        proxy._updateType(newTypeValue);
        return this;
    }
    // End of code for the attribute type from device Android
    
    // Code for the attribute version from device Android
    /**
     * Set the value of the <code>version</code> attribute from device <code>Android</code>.
     * 
     * <pre>
     * attribute version as Integer;
     * </pre>
     * @param newVersionValue the new value of <code>version</code>
     * @return this for fluent interface
     */
    public AndroidMock version(java.lang.Integer newVersionValue) {
        proxy._updateVersion(newVersionValue);
        return this;
    }
    // End of code for the attribute version from device Android
    
    // Code for source apps from device Android
    /**
     * Publish the value of source <code>apps</code> from device <code>Android</code>.
     * 
     * <pre>
     * source apps as AndroidApp [];
     * </pre>
     * @param newAppsValue the new value for the source <code>apps</code>
     * @return this for fluent interface
     */
    public AndroidMock apps(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> newAppsValue) {
        proxy._publishApps(newAppsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> __apps = null;
    /**
     * Set the value (without publication) of source <code>apps</code> from device <code>Android</code>.
     * 
     * <pre>
     * source apps as AndroidApp [];
     * </pre>
     * @param newAppsValue the new value for the source <code>apps</code>
     * @return this for fluent interface
     */
    public AndroidMock setApps(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp> newAppsValue) {
        __apps = newAppsValue;
        return this;
    }
    // End of code for source apps from device Android
    
    // Code for source battery from device Android
    /**
     * Publish the value of source <code>battery</code> from device <code>Android</code>.
     * 
     * <pre>
     * source battery as Battery;
     * </pre>
     * @param newBatteryValue the new value for the source <code>battery</code>
     * @return this for fluent interface
     */
    public AndroidMock battery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
        proxy._publishBattery(newBatteryValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.battery.Battery __battery = null;
    /**
     * Set the value (without publication) of source <code>battery</code> from device <code>Android</code>.
     * 
     * <pre>
     * source battery as Battery;
     * </pre>
     * @param newBatteryValue the new value for the source <code>battery</code>
     * @return this for fluent interface
     */
    public AndroidMock setBattery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
        __battery = newBatteryValue;
        return this;
    }
    // End of code for source battery from device Android
    
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
    public AndroidMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public AndroidMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source screenOn from device Android
    /**
     * Publish the value of source <code>screenOn</code> from device <code>Android</code>.
     * 
     * <pre>
     * source screenOn as Boolean;
     * </pre>
     * @param newScreenOnValue the new value for the source <code>screenOn</code>
     * @return this for fluent interface
     */
    public AndroidMock screenOn(java.lang.Boolean newScreenOnValue) {
        proxy._publishScreenOn(newScreenOnValue);
        return this;
    }
    
    private java.lang.Boolean __screenOn = null;
    /**
     * Set the value (without publication) of source <code>screenOn</code> from device <code>Android</code>.
     * 
     * <pre>
     * source screenOn as Boolean;
     * </pre>
     * @param newScreenOnValue the new value for the source <code>screenOn</code>
     * @return this for fluent interface
     */
    public AndroidMock setScreenOn(java.lang.Boolean newScreenOnValue) {
        __screenOn = newScreenOnValue;
        return this;
    }
    // End of code for source screenOn from device Android
    
    // Code for source soundLevels from device Android
    /**
     * Publish the value of source <code>soundLevels</code> from device <code>Android</code>.
     * 
     * <pre>
     * source soundLevels as SoundLevel [];
     * </pre>
     * @param newSoundLevelsValue the new value for the source <code>soundLevels</code>
     * @return this for fluent interface
     */
    public AndroidMock soundLevels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> newSoundLevelsValue) {
        proxy._publishSoundLevels(newSoundLevelsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> __soundLevels = null;
    /**
     * Set the value (without publication) of source <code>soundLevels</code> from device <code>Android</code>.
     * 
     * <pre>
     * source soundLevels as SoundLevel [];
     * </pre>
     * @param newSoundLevelsValue the new value for the source <code>soundLevels</code>
     * @return this for fluent interface
     */
    public AndroidMock setSoundLevels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel> newSoundLevelsValue) {
        __soundLevels = newSoundLevelsValue;
        return this;
    }
    // End of code for source soundLevels from device Android
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>setScreenStatus</code> order from the <code>ScreenAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * setScreenStatus(turnOn as Boolean);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetScreenStatus() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setScreenStatus".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setScreenStatus</code> order from the <code>ScreenAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * setScreenStatus(turnOn as Boolean);
     * </pre>
     * @param turnOn parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetScreenStatus(java.lang.Boolean turnOn) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setScreenStatus".equals(__action.poll())))
                    return false;
                if(!turnOn.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>setSoundLevel</code> order from the <code>SoundAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * setSoundLevel(level as Integer);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetSoundLevel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setSoundLevel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setSoundLevel</code> order from the <code>SoundAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * setSoundLevel(level as Integer);
     * </pre>
     * @param level parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetSoundLevel(java.lang.Integer level) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setSoundLevel".equals(__action.poll())))
                    return false;
                if(!level.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>startActivity</code> order from the <code>ActivityAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * startActivity(intent as AndroidIntent);
     * </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectStartActivity() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("startActivity".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>startActivity</code> order from the <code>ActivityAction</code> action
     * defined in device Android was called.
     * 
     * 
     * <pre>
     * startActivity(intent as AndroidIntent);
     * </pre>
     * @param intent parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectStartActivity(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent intent) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("startActivity".equals(__action.poll())))
                    return false;
                if(!intent.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
