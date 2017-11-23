package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.fitbit.AbstractFitbit;
import fr.inria.phoenix.diasuite.framework.device.fitbit.ActivitiesBetweenIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.DailyActivitiesIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.StepsBetweenIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.DailyPulsesIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.SleepPeriodsBetweenIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.DailySleepPeriodsIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.PulsesBetweenIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.DailyStepsIndices;
import fr.inria.phoenix.diasuite.framework.device.fitbit.AlarmIndices;

// @internal
public final class FitbitMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractFitbit {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> getActivitiesBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> result = __activitiesBetween.get(new ActivitiesBetweenIndices(startDate, endDate));
            if(result == null)
                return super.getActivitiesBetween(startDate, endDate);
            return result;
        }
        
        public void _publishActivitiesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newActivitiesBetweenValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
            publishActivitiesBetween(newActivitiesBetweenValue,
                startDate,
                endDate);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm getAlarm(java.lang.String alarmId) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm result = __alarm.get(new AlarmIndices(alarmId));
            if(result == null)
                return super.getAlarm(alarmId);
            return result;
        }
        
        public void _publishAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newAlarmValue,
                java.lang.String alarmId) {
            publishAlarm(newAlarmValue,
                alarmId);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> getDailyActivities(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> result = __dailyActivities.get(new DailyActivitiesIndices(day));
            if(result == null)
                return super.getDailyActivities(day);
            return result;
        }
        
        public void _publishDailyActivities(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newDailyActivitiesValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
            publishDailyActivities(newDailyActivitiesValue,
                day);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> getDailyPulses(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> result = __dailyPulses.get(new DailyPulsesIndices(day));
            if(result == null)
                return super.getDailyPulses(day);
            return result;
        }
        
        public void _publishDailyPulses(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newDailyPulsesValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
            publishDailyPulses(newDailyPulsesValue,
                day);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> getDailySleepPeriods(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> result = __dailySleepPeriods.get(new DailySleepPeriodsIndices(day));
            if(result == null)
                return super.getDailySleepPeriods(day);
            return result;
        }
        
        public void _publishDailySleepPeriods(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newDailySleepPeriodsValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
            publishDailySleepPeriods(newDailySleepPeriodsValue,
                day);
        }
        
        protected java.lang.Integer getDailySteps(fr.inria.phoenix.diasuite.framework.datatype.date.Date day) throws Exception {
            java.lang.Integer result = __dailySteps.get(new DailyStepsIndices(day));
            if(result == null)
                return super.getDailySteps(day);
            return result;
        }
        
        public void _publishDailySteps(java.lang.Integer newDailyStepsValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
            publishDailySteps(newDailyStepsValue,
                day);
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
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> getPulsesBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> result = __pulsesBetween.get(new PulsesBetweenIndices(startDate, endDate));
            if(result == null)
                return super.getPulsesBetween(startDate, endDate);
            return result;
        }
        
        public void _publishPulsesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newPulsesBetweenValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
            publishPulsesBetween(newPulsesBetweenValue,
                startDate,
                endDate);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> getSleepPeriodsBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> result = __sleepPeriodsBetween.get(new SleepPeriodsBetweenIndices(startDate, endDate));
            if(result == null)
                return super.getSleepPeriodsBetween(startDate, endDate);
            return result;
        }
        
        public void _publishSleepPeriodsBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newSleepPeriodsBetweenValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
            publishSleepPeriodsBetween(newSleepPeriodsBetweenValue,
                startDate,
                endDate);
        }
        
        protected java.lang.Integer getStepsBetween(fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
            java.lang.Integer result = __stepsBetween.get(new StepsBetweenIndices(startDate, endDate));
            if(result == null)
                return super.getStepsBetween(startDate, endDate);
            return result;
        }
        
        public void _publishStepsBetween(java.lang.Integer newStepsBetweenValue,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
            publishStepsBetween(newStepsBetweenValue,
                startDate,
                endDate);
        }
        
        protected void addAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm alarm) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addAlarm");
                __action.add(alarm);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeAlarm(java.lang.String alarmId) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeAlarm");
                __action.add(alarmId);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    FitbitMock(ServiceConfiguration serviceConfiguration,
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
    public FitbitMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source activitiesBetween from device Fitbit
    /**
     * Publish the value of source <code>activitiesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newActivitiesBetweenValue the new value for the source <code>activitiesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock activitiesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newActivitiesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        proxy._publishActivitiesBetween(newActivitiesBetweenValue,
            startDate,
            endDate);
        return this;
    }
    
    private java.util.HashMap<ActivitiesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>> __activitiesBetween = new java.util.HashMap<ActivitiesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>>();
    /**
     * Set the value (without publication) of source <code>activitiesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source activitiesBetween as FitbitActivity [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newActivitiesBetweenValue the new value for the source <code>activitiesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock setActivitiesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newActivitiesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        ActivitiesBetweenIndices _indices_ = new ActivitiesBetweenIndices(startDate, endDate);
        __activitiesBetween.put(_indices_, newActivitiesBetweenValue);
        return this;
    }
    // End of code for source activitiesBetween from device Fitbit
    
    // Code for source alarm from device Fitbit
    /**
     * Publish the value of source <code>alarm</code> from device <code>Fitbit</code>.
    <p>
    alarm
    
    <pre>
    source alarm as FitbitAlarm indexed by alarmId as String;
    </pre>
    @param newAlarmValue the new value for the source <code>alarm</code>
    @param alarmId the value of the index <code>alarmId</code>
    @return this for fluent interface
     */
    public FitbitMock alarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newAlarmValue,
            java.lang.String alarmId) {
        proxy._publishAlarm(newAlarmValue,
            alarmId);
        return this;
    }
    
    private java.util.HashMap<AlarmIndices, fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm> __alarm = new java.util.HashMap<AlarmIndices, fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm>();
    /**
     * Set the value (without publication) of source <code>alarm</code> from device <code>Fitbit</code>.
    <p>
    alarm
    
    <pre>
    source alarm as FitbitAlarm indexed by alarmId as String;
    </pre>
    @param newAlarmValue the new value for the source <code>alarm</code>
    @param alarmId the value of the index <code>alarmId</code>
    @return this for fluent interface
     */
    public FitbitMock setAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newAlarmValue,
            java.lang.String alarmId) {
        AlarmIndices _indices_ = new AlarmIndices(alarmId);
        __alarm.put(_indices_, newAlarmValue);
        return this;
    }
    // End of code for source alarm from device Fitbit
    
    // Code for source dailyActivities from device Fitbit
    /**
     * Publish the value of source <code>dailyActivities</code> from device <code>Fitbit</code>.
    <p>
    activities
    
    <pre>
    source dailyActivities as FitbitActivity [] indexed by day as Date;
    </pre>
    @param newDailyActivitiesValue the new value for the source <code>dailyActivities</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock dailyActivities(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newDailyActivitiesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        proxy._publishDailyActivities(newDailyActivitiesValue,
            day);
        return this;
    }
    
    private java.util.HashMap<DailyActivitiesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>> __dailyActivities = new java.util.HashMap<DailyActivitiesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity>>();
    /**
     * Set the value (without publication) of source <code>dailyActivities</code> from device <code>Fitbit</code>.
    <p>
    activities
    
    <pre>
    source dailyActivities as FitbitActivity [] indexed by day as Date;
    </pre>
    @param newDailyActivitiesValue the new value for the source <code>dailyActivities</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock setDailyActivities(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity> newDailyActivitiesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyActivitiesIndices _indices_ = new DailyActivitiesIndices(day);
        __dailyActivities.put(_indices_, newDailyActivitiesValue);
        return this;
    }
    // End of code for source dailyActivities from device Fitbit
    
    // Code for source dailyPulses from device Fitbit
    /**
     * Publish the value of source <code>dailyPulses</code> from device <code>Fitbit</code>.
    <p>
    pulses
    
    <pre>
    source dailyPulses as PulseRecord [] indexed by day as Date;
    </pre>
    @param newDailyPulsesValue the new value for the source <code>dailyPulses</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock dailyPulses(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newDailyPulsesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        proxy._publishDailyPulses(newDailyPulsesValue,
            day);
        return this;
    }
    
    private java.util.HashMap<DailyPulsesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>> __dailyPulses = new java.util.HashMap<DailyPulsesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>>();
    /**
     * Set the value (without publication) of source <code>dailyPulses</code> from device <code>Fitbit</code>.
    <p>
    pulses
    
    <pre>
    source dailyPulses as PulseRecord [] indexed by day as Date;
    </pre>
    @param newDailyPulsesValue the new value for the source <code>dailyPulses</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock setDailyPulses(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newDailyPulsesValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyPulsesIndices _indices_ = new DailyPulsesIndices(day);
        __dailyPulses.put(_indices_, newDailyPulsesValue);
        return this;
    }
    // End of code for source dailyPulses from device Fitbit
    
    // Code for source dailySleepPeriods from device Fitbit
    /**
     * Publish the value of source <code>dailySleepPeriods</code> from device <code>Fitbit</code>.
    <p>
    sleep
    
    <pre>
    source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
    </pre>
    @param newDailySleepPeriodsValue the new value for the source <code>dailySleepPeriods</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock dailySleepPeriods(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newDailySleepPeriodsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        proxy._publishDailySleepPeriods(newDailySleepPeriodsValue,
            day);
        return this;
    }
    
    private java.util.HashMap<DailySleepPeriodsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>> __dailySleepPeriods = new java.util.HashMap<DailySleepPeriodsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>>();
    /**
     * Set the value (without publication) of source <code>dailySleepPeriods</code> from device <code>Fitbit</code>.
    <p>
    sleep
    
    <pre>
    source dailySleepPeriods as SleepPeriod [] indexed by day as Date;
    </pre>
    @param newDailySleepPeriodsValue the new value for the source <code>dailySleepPeriods</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock setDailySleepPeriods(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newDailySleepPeriodsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailySleepPeriodsIndices _indices_ = new DailySleepPeriodsIndices(day);
        __dailySleepPeriods.put(_indices_, newDailySleepPeriodsValue);
        return this;
    }
    // End of code for source dailySleepPeriods from device Fitbit
    
    // Code for source dailySteps from device Fitbit
    /**
     * Publish the value of source <code>dailySteps</code> from device <code>Fitbit</code>.
    <p>
    steps
    
    <pre>
    source dailySteps as Integer indexed by day as Date;
    </pre>
    @param newDailyStepsValue the new value for the source <code>dailySteps</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock dailySteps(java.lang.Integer newDailyStepsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        proxy._publishDailySteps(newDailyStepsValue,
            day);
        return this;
    }
    
    private java.util.HashMap<DailyStepsIndices, java.lang.Integer> __dailySteps = new java.util.HashMap<DailyStepsIndices, java.lang.Integer>();
    /**
     * Set the value (without publication) of source <code>dailySteps</code> from device <code>Fitbit</code>.
    <p>
    steps
    
    <pre>
    source dailySteps as Integer indexed by day as Date;
    </pre>
    @param newDailyStepsValue the new value for the source <code>dailySteps</code>
    @param day the value of the index <code>day</code>
    @return this for fluent interface
     */
    public FitbitMock setDailySteps(java.lang.Integer newDailyStepsValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date day) {
        DailyStepsIndices _indices_ = new DailyStepsIndices(day);
        __dailySteps.put(_indices_, newDailyStepsValue);
        return this;
    }
    // End of code for source dailySteps from device Fitbit
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public FitbitMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public FitbitMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source pulsesBetween from device Fitbit
    /**
     * Publish the value of source <code>pulsesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newPulsesBetweenValue the new value for the source <code>pulsesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock pulsesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newPulsesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        proxy._publishPulsesBetween(newPulsesBetweenValue,
            startDate,
            endDate);
        return this;
    }
    
    private java.util.HashMap<PulsesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>> __pulsesBetween = new java.util.HashMap<PulsesBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord>>();
    /**
     * Set the value (without publication) of source <code>pulsesBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source pulsesBetween as PulseRecord [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newPulsesBetweenValue the new value for the source <code>pulsesBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock setPulsesBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord> newPulsesBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        PulsesBetweenIndices _indices_ = new PulsesBetweenIndices(startDate, endDate);
        __pulsesBetween.put(_indices_, newPulsesBetweenValue);
        return this;
    }
    // End of code for source pulsesBetween from device Fitbit
    
    // Code for source sleepPeriodsBetween from device Fitbit
    /**
     * Publish the value of source <code>sleepPeriodsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newSleepPeriodsBetweenValue the new value for the source <code>sleepPeriodsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock sleepPeriodsBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newSleepPeriodsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        proxy._publishSleepPeriodsBetween(newSleepPeriodsBetweenValue,
            startDate,
            endDate);
        return this;
    }
    
    private java.util.HashMap<SleepPeriodsBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>> __sleepPeriodsBetween = new java.util.HashMap<SleepPeriodsBetweenIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod>>();
    /**
     * Set the value (without publication) of source <code>sleepPeriodsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source sleepPeriodsBetween as SleepPeriod [] indexed by startDate as Date, endDate as Date;
    </pre>
    @param newSleepPeriodsBetweenValue the new value for the source <code>sleepPeriodsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock setSleepPeriodsBetween(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod> newSleepPeriodsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        SleepPeriodsBetweenIndices _indices_ = new SleepPeriodsBetweenIndices(startDate, endDate);
        __sleepPeriodsBetween.put(_indices_, newSleepPeriodsBetweenValue);
        return this;
    }
    // End of code for source sleepPeriodsBetween from device Fitbit
    
    // Code for source stepsBetween from device Fitbit
    /**
     * Publish the value of source <code>stepsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
    </pre>
    @param newStepsBetweenValue the new value for the source <code>stepsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock stepsBetween(java.lang.Integer newStepsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        proxy._publishStepsBetween(newStepsBetweenValue,
            startDate,
            endDate);
        return this;
    }
    
    private java.util.HashMap<StepsBetweenIndices, java.lang.Integer> __stepsBetween = new java.util.HashMap<StepsBetweenIndices, java.lang.Integer>();
    /**
     * Set the value (without publication) of source <code>stepsBetween</code> from device <code>Fitbit</code>.
    
    <pre>
    source stepsBetween as Integer indexed by startDate as Date, endDate as Date;
    </pre>
    @param newStepsBetweenValue the new value for the source <code>stepsBetween</code>
    @param startDate the value of the index <code>startDate</code>
    @param endDate the value of the index <code>endDate</code>
    @return this for fluent interface
     */
    public FitbitMock setStepsBetween(java.lang.Integer newStepsBetweenValue,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        StepsBetweenIndices _indices_ = new StepsBetweenIndices(startDate, endDate);
        __stepsBetween.put(_indices_, newStepsBetweenValue);
        return this;
    }
    // End of code for source stepsBetween from device Fitbit
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit was called.
     * 
    
    <pre>
    addAlarm(alarm as FitbitAlarm);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddAlarm() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addAlarm".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit was called.
     * 
    
    <pre>
    addAlarm(alarm as FitbitAlarm);
    </pre>
     * @param alarm parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm alarm) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addAlarm".equals(__action.poll())))
                    return false;
                if(!alarm.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit was called.
     * 
    
    <pre>
    removeAlarm(alarmId as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemoveAlarm() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAlarm".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removeAlarm</code> order from the <code>ScheduleAlarm</code> action
     * defined in device Fitbit was called.
     * 
    
    <pre>
    removeAlarm(alarmId as String);
    </pre>
     * @param alarmId parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemoveAlarm(java.lang.String alarmId) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAlarm".equals(__action.poll())))
                    return false;
                if(!alarmId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}
