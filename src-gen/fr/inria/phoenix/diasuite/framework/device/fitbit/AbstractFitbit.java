package fr.inria.phoenix.diasuite.framework.device.fitbit;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------------------------------------------------------------
Fitbit							||
------------------------------------------------------------

<pre>
device Fitbit extends Device {
 * 	source dailyPulses as PulseRecord [] indexed by day as Date;
 * 	source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
 * 	source dailySteps as Integer indexed by day as Date;
 * 	source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
 * 	source dailyActivities as FitbitActivity [] indexed by day as Date;
 * 	source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
 * 	source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
 * 	source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
 * 	source alarm as FitbitAlarm indexed by alarmId as String;
 * 	action ScheduleAlarm;
 * }
</pre>
 */
public abstract class AbstractFitbit extends Service {
    
    public AbstractFitbit(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Fitbit/", serviceConfiguration);
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
        if (orderName.equals("addAlarm")) {
            addAlarm((fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm) args[0]);
            return null;
        }
        if (orderName.equals("removeAlarm")) {
            removeAlarm((java.lang.String) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("activitiesBetween")) {
            return getActivitiesBetween((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1]);
        }
        if (orderName.equals("alarm")) {
            return getAlarm((java.lang.String) args[0]);
        }
        if (orderName.equals("dailyActivities")) {
            return getDailyActivities((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0]);
        }
        if (orderName.equals("dailyPulses")) {
            return getDailyPulses((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0]);
        }
        if (orderName.equals("dailySleepPeriods")) {
            return getDailySleepPeriods((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0]);
        }
        if (orderName.equals("dailySteps")) {
            return getDailySteps((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("pulsesBetween")) {
            return getPulsesBetween((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1]);
        }
        if (orderName.equals("sleepPeriodsBetween")) {
            return getSleepPeriodsBetween((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1]);
        }
        if (orderName.equals("stepsBetween")) {
            return getStepsBetween((fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[1]);
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
    
    // Code for source activitiesBetween from device Fitbit
    private java.util.HashMap<ActivitiesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>> _activitiesBetween = new java.util.HashMap<ActivitiesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>>();
    
    /**
     * Publish the value of source <code>activitiesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newActivitiesBetweenValue the new value for the source <code>activitiesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
     */
    protected void publishActivitiesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newActivitiesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        ActivitiesBetweenIndices _indices_ = new ActivitiesBetweenIndices(startDate, endDate);
        _activitiesBetween.put(_indices_, newActivitiesBetweenValue);
        getProcessor().publishValue(getOutProperties(), "activitiesBetween", newActivitiesBetweenValue, startDate, endDate); 
    }
    
    /**
     * Returns the value of source <code>activitiesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return the value of the source <code>activitiesBetween</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> getActivitiesBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
        return _activitiesBetween.get(new ActivitiesBetweenIndices(startDate, endDate));
    }
    // End of code for source activitiesBetween from device Fitbit
    
    // Code for source alarm from device Fitbit
    private java.util.HashMap<AlarmIndices, fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm> _alarm = new java.util.HashMap<AlarmIndices, fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm>();
    
    /**
     * Publish the value of source <code>alarm</code> from device <code>Fitbit</code>.
    <p>
    alarm
    
    <pre>
    source alarm as FitbitAlarm indexed by alarmId as String;
    </pre>
    @param newAlarmValue the new value for the source <code>alarm</code>
    @param alarmId the value of the index <code>alarmId</code>
     */
    protected void publishAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newAlarmValue,
            java.lang.String alarmId) {
        AlarmIndices _indices_ = new AlarmIndices(alarmId);
        _alarm.put(_indices_, newAlarmValue);
        getProcessor().publishValue(getOutProperties(), "alarm", newAlarmValue, alarmId); 
    }
    
    /**
     * Returns the value of source <code>alarm</code> from device <code>Fitbit</code>.
    <p>
    alarm
    
    <pre>
    source alarm as FitbitAlarm indexed by alarmId as String;
    </pre>
    @param alarmId the value of the index <code>alarmId</code>
    @return the value of the source <code>alarm</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm getAlarm(java.lang.String alarmId) throws Exception {
        return _alarm.get(new AlarmIndices(alarmId));
    }
    // End of code for source alarm from device Fitbit
    
    // Code for source dailyActivities from device Fitbit
    private java.util.HashMap<DailyActivitiesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>> _dailyActivities = new java.util.HashMap<DailyActivitiesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>>();
    
    /**
     * Publish the value of source <code>dailyActivities</code> from device <code>Fitbit</code>.
    <p>
    activities
    
    <pre>
    source dailyActivities as FitbitActivity [] indexed by day as Date;
    </pre>
    @param newDailyActivitiesValue the new value for the source <code>dailyActivities</code>
    @param day the value of the index <code>day</code>
     */
    protected void publishDailyActivities(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newDailyActivitiesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyActivitiesIndices _indices_ = new DailyActivitiesIndices(day);
        _dailyActivities.put(_indices_, newDailyActivitiesValue);
        getProcessor().publishValue(getOutProperties(), "dailyActivities", newDailyActivitiesValue, day); 
    }
    
    /**
     * Returns the value of source <code>dailyActivities</code> from device <code>Fitbit</code>.
    <p>
    activities
    
    <pre>
    source dailyActivities as FitbitActivity [] indexed by day as Date;
    </pre>
    @param day the value of the index <code>day</code>
    @return the value of the source <code>dailyActivities</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> getDailyActivities(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
        return _dailyActivities.get(new DailyActivitiesIndices(day));
    }
    // End of code for source dailyActivities from device Fitbit
    
    // Code for source dailyPulses from device Fitbit
    private java.util.HashMap<DailyPulsesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>> _dailyPulses = new java.util.HashMap<DailyPulsesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>>();
    
    /**
     * Publish the value of source <code>dailyPulses</code> from device <code>Fitbit</code>.
    <p>
    pulses
    
    <pre>
    source dailyPulses as PulseRecord [] indexed by day as Date;
    </pre>
    @param newDailyPulsesValue the new value for the source <code>dailyPulses</code>
    @param day the value of the index <code>day</code>
     */
    protected void publishDailyPulses(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newDailyPulsesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyPulsesIndices _indices_ = new DailyPulsesIndices(day);
        _dailyPulses.put(_indices_, newDailyPulsesValue);
        getProcessor().publishValue(getOutProperties(), "dailyPulses", newDailyPulsesValue, day); 
    }
    
    /**
     * Returns the value of source <code>dailyPulses</code> from device <code>Fitbit</code>.
    <p>
    pulses
    
    <pre>
    source dailyPulses as PulseRecord [] indexed by day as Date;
    </pre>
    @param day the value of the index <code>day</code>
    @return the value of the source <code>dailyPulses</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> getDailyPulses(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
        return _dailyPulses.get(new DailyPulsesIndices(day));
    }
    // End of code for source dailyPulses from device Fitbit
    
    // Code for source dailySleepPeriods from device Fitbit
    private java.util.HashMap<DailySleepPeriodsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>> _dailySleepPeriods = new java.util.HashMap<DailySleepPeriodsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>>();
    
    /**
     * Publish the value of source <code>dailySleepPeriods</code> from device <code>Fitbit</code>.
    <p>
    sleep
    
    <pre>
    source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
    </pre>
    @param newDailySleepPeriodsValue the new value for the source <code>dailySleepPeriods</code>
    @param day the value of the index <code>day</code>
     */
    protected void publishDailySleepPeriods(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newDailySleepPeriodsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailySleepPeriodsIndices _indices_ = new DailySleepPeriodsIndices(day);
        _dailySleepPeriods.put(_indices_, newDailySleepPeriodsValue);
        getProcessor().publishValue(getOutProperties(), "dailySleepPeriods", newDailySleepPeriodsValue, day); 
    }
    
    /**
     * Returns the value of source <code>dailySleepPeriods</code> from device <code>Fitbit</code>.
    <p>
    sleep
    
    <pre>
    source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
    </pre>
    @param day the value of the index <code>day</code>
    @return the value of the source <code>dailySleepPeriods</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> getDailySleepPeriods(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
        return _dailySleepPeriods.get(new DailySleepPeriodsIndices(day));
    }
    // End of code for source dailySleepPeriods from device Fitbit
    
    // Code for source dailySteps from device Fitbit
    private java.util.HashMap<DailyStepsIndices, java.lang.Integer> _dailySteps = new java.util.HashMap<DailyStepsIndices, java.lang.Integer>();
    
    /**
     * Publish the value of source <code>dailySteps</code> from device <code>Fitbit</code>.
    <p>
    steps
    
    <pre>
    source dailySteps as Integer indexed by day as Date;
    </pre>
    @param newDailyStepsValue the new value for the source <code>dailySteps</code>
    @param day the value of the index <code>day</code>
     */
    protected void publishDailySteps(java.lang.Integer newDailyStepsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyStepsIndices _indices_ = new DailyStepsIndices(day);
        _dailySteps.put(_indices_, newDailyStepsValue);
        getProcessor().publishValue(getOutProperties(), "dailySteps", newDailyStepsValue, day); 
    }
    
    /**
     * Returns the value of source <code>dailySteps</code> from device <code>Fitbit</code>.
    <p>
    steps
    
    <pre>
    source dailySteps as Integer indexed by day as Date;
    </pre>
    @param day the value of the index <code>day</code>
    @return the value of the source <code>dailySteps</code>
     */
    protected java.lang.Integer getDailySteps(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
        return _dailySteps.get(new DailyStepsIndices(day));
    }
    // End of code for source dailySteps from device Fitbit
    
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
    
    // Code for source pulsesBetween from device Fitbit
    private java.util.HashMap<PulsesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>> _pulsesBetween = new java.util.HashMap<PulsesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>>();
    
    /**
     * Publish the value of source <code>pulsesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newPulsesBetweenValue the new value for the source <code>pulsesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
     */
    protected void publishPulsesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newPulsesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        PulsesBetweenIndices _indices_ = new PulsesBetweenIndices(startDate, endDate);
        _pulsesBetween.put(_indices_, newPulsesBetweenValue);
        getProcessor().publishValue(getOutProperties(), "pulsesBetween", newPulsesBetweenValue, startDate, endDate); 
    }
    
    /**
     * Returns the value of source <code>pulsesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return the value of the source <code>pulsesBetween</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> getPulsesBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
        return _pulsesBetween.get(new PulsesBetweenIndices(startDate, endDate));
    }
    // End of code for source pulsesBetween from device Fitbit
    
    // Code for source sleepPeriodsBetween from device Fitbit
    private java.util.HashMap<SleepPeriodsBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>> _sleepPeriodsBetween = new java.util.HashMap<SleepPeriodsBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>>();
    
    /**
     * Publish the value of source <code>sleepPeriodsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newSleepPeriodsBetweenValue the new value for the source <code>sleepPeriodsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
     */
    protected void publishSleepPeriodsBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newSleepPeriodsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        SleepPeriodsBetweenIndices _indices_ = new SleepPeriodsBetweenIndices(startDate, endDate);
        _sleepPeriodsBetween.put(_indices_, newSleepPeriodsBetweenValue);
        getProcessor().publishValue(getOutProperties(), "sleepPeriodsBetween", newSleepPeriodsBetweenValue, startDate, endDate); 
    }
    
    /**
     * Returns the value of source <code>sleepPeriodsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return the value of the source <code>sleepPeriodsBetween</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> getSleepPeriodsBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
        return _sleepPeriodsBetween.get(new SleepPeriodsBetweenIndices(startDate, endDate));
    }
    // End of code for source sleepPeriodsBetween from device Fitbit
    
    // Code for source stepsBetween from device Fitbit
    private java.util.HashMap<StepsBetweenIndices, java.lang.Integer> _stepsBetween = new java.util.HashMap<StepsBetweenIndices, java.lang.Integer>();
    
    /**
     * Publish the value of source <code>stepsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
    </pre>
    @param newStepsBetweenValue the new value for the source <code>stepsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
     */
    protected void publishStepsBetween(java.lang.Integer newStepsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        StepsBetweenIndices _indices_ = new StepsBetweenIndices(startDate, endDate);
        _stepsBetween.put(_indices_, newStepsBetweenValue);
        getProcessor().publishValue(getOutProperties(), "stepsBetween", newStepsBetweenValue, startDate, endDate); 
    }
    
    /**
     * Returns the value of source <code>stepsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
    </pre>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return the value of the source <code>stepsBetween</code>
     */
    protected java.lang.Integer getStepsBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
        return _stepsBetween.get(new StepsBetweenIndices(startDate, endDate));
    }
    // End of code for source stepsBetween from device Fitbit
    
    /**
     * Implement this method to define the <code>addAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit.
     * 
    
    <pre>
    addAlarm(alarm as FitbitAlarm);
    </pre>
     * @param alarm parameter 1 of the order.
     */
    protected abstract void addAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm alarm) throws Exception;
    
    /**
     * Implement this method to define the <code>removeAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit.
     * 
    
    <pre>
    removeAlarm(alarmId as String);
    </pre>
     * @param alarmId parameter 1 of the order.
     */
    protected abstract void removeAlarm(java.lang.String alarmId) throws Exception;
}
