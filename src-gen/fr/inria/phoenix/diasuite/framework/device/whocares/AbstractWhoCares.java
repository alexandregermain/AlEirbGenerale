package fr.inria.phoenix.diasuite.framework.device.whocares;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------------------------------------------------------------
WhoCares						||
------------------------------------------------------------

<pre>
device WhoCares {
 * 	attribute date as Date;
 * 	attribute day as Day;
 * 	attribute fileType as FileType;
 * 	attribute file as File;
 * 	attribute contact as Contact;
 * 	attribute message as Message;
 * 	attribute agendatEvent as AgendaEvent;
 * 	attribute notification as NonCriticalNotification;
 * 	attribute criticalNotification as CriticalNotification;
 * 	attribute doorState as DoorState;
 * 	attribute temperatureUnit as TemperatureUnit;
 * 	attribute dailyActivityName as DailyActivityName;
 * 	attribute periodActivityName as PeriodActivityName;
 * 	attribute dailyActivity as DailyActivity;
 * 	attribute period as Period;
 * 	attribute periodActivity as PeriodActivity;
 * 	attribute dailyReport as DailyReport;
 * 	attribute statisticReport as StatisticReport;
 * 	attribute periodActivityStats as PeriodActivityStats;
 * 	attribute dailyActivityStats as DailyActivityStats;
 * 	attribute action as Interaction;
 * 	attribute actionType as InteractionType;
 * 	attribute dayTime as DayTime;
 * 	attribute battery as Battery;
 * 	attribute androidApp as AndroidApp;
 * 	attribute soundLevel as SoundLevel;
 * 	attribute androidIntent as AndroidIntent;
 * 	attribute androidExtraString as AndroidExtraString;
 * 	attribute pulseRecord as PulseRecord;
 * 	attribute fitibitActivity as FitbitActivity;
 * 	attribute sleepPeriod as SleepPeriod;
 * 	attribute fitbitAlarm as FitbitAlarm;
 * }
</pre>
 */
public abstract class AbstractWhoCares extends Service {
    
    public AbstractWhoCares(ServiceConfiguration serviceConfiguration,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date dateValue,
            fr.inria.phoenix.diasuite.framework.datatype.day.Day dayValue,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType fileTypeValue,
            fr.inria.phoenix.diasuite.framework.datatype.file.File fileValue,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contactValue,
            fr.inria.phoenix.diasuite.framework.datatype.message.Message messageValue,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent agendatEventValue,
            fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notificationValue,
            fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification criticalNotificationValue,
            fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState doorStateValue,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit temperatureUnitValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName dailyActivityNameValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName periodActivityNameValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivityValue,
            fr.inria.phoenix.diasuite.framework.datatype.period.Period periodValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivityValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport dailyReportValue,
            fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport statisticReportValue,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats periodActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats dailyActivityStatsValue,
            fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction actionValue,
            fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionTypeValue,
            fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime dayTimeValue,
            fr.inria.phoenix.diasuite.framework.datatype.battery.Battery batteryValue,
            fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp androidAppValue,
            fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel soundLevelValue,
            fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent androidIntentValue,
            fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString androidExtraStringValue,
            fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord pulseRecordValue,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity fitibitActivityValue,
            fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod sleepPeriodValue,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm fitbitAlarmValue) {
        super("/Device/WhoCares/", serviceConfiguration);
        updateDate(dateValue);
        updateDay(dayValue);
        updateFileType(fileTypeValue);
        updateFile(fileValue);
        updateContact(contactValue);
        updateMessage(messageValue);
        updateAgendatEvent(agendatEventValue);
        updateNotification(notificationValue);
        updateCriticalNotification(criticalNotificationValue);
        updateDoorState(doorStateValue);
        updateTemperatureUnit(temperatureUnitValue);
        updateDailyActivityName(dailyActivityNameValue);
        updatePeriodActivityName(periodActivityNameValue);
        updateDailyActivity(dailyActivityValue);
        updatePeriod(periodValue);
        updatePeriodActivity(periodActivityValue);
        updateDailyReport(dailyReportValue);
        updateStatisticReport(statisticReportValue);
        updatePeriodActivityStats(periodActivityStatsValue);
        updateDailyActivityStats(dailyActivityStatsValue);
        updateAction(actionValue);
        updateActionType(actionTypeValue);
        updateDayTime(dayTimeValue);
        updateBattery(batteryValue);
        updateAndroidApp(androidAppValue);
        updateSoundLevel(soundLevelValue);
        updateAndroidIntent(androidIntentValue);
        updateAndroidExtraString(androidExtraStringValue);
        updatePulseRecord(pulseRecordValue);
        updateFitibitActivity(fitibitActivityValue);
        updateSleepPeriod(sleepPeriodValue);
        updateFitbitAlarm(fitbitAlarmValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("action", _action);
        attributes.put("actionType", _actionType);
        attributes.put("agendatEvent", _agendatEvent);
        attributes.put("androidApp", _androidApp);
        attributes.put("androidExtraString", _androidExtraString);
        attributes.put("androidIntent", _androidIntent);
        attributes.put("battery", _battery);
        attributes.put("contact", _contact);
        attributes.put("criticalNotification", _criticalNotification);
        attributes.put("dailyActivity", _dailyActivity);
        attributes.put("dailyActivityName", _dailyActivityName);
        attributes.put("dailyActivityStats", _dailyActivityStats);
        attributes.put("dailyReport", _dailyReport);
        attributes.put("date", _date);
        attributes.put("day", _day);
        attributes.put("dayTime", _dayTime);
        attributes.put("doorState", _doorState);
        attributes.put("file", _file);
        attributes.put("fileType", _fileType);
        attributes.put("fitbitAlarm", _fitbitAlarm);
        attributes.put("fitibitActivity", _fitibitActivity);
        attributes.put("message", _message);
        attributes.put("notification", _notification);
        attributes.put("period", _period);
        attributes.put("periodActivity", _periodActivity);
        attributes.put("periodActivityName", _periodActivityName);
        attributes.put("periodActivityStats", _periodActivityStats);
        attributes.put("pulseRecord", _pulseRecord);
        attributes.put("sleepPeriod", _sleepPeriod);
        attributes.put("soundLevel", _soundLevel);
        attributes.put("statisticReport", _statisticReport);
        attributes.put("temperatureUnit", _temperatureUnit);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("action")) {
            return _action;
        }
        if (orderName.equals("actionType")) {
            return _actionType;
        }
        if (orderName.equals("agendatEvent")) {
            return _agendatEvent;
        }
        if (orderName.equals("androidApp")) {
            return _androidApp;
        }
        if (orderName.equals("androidExtraString")) {
            return _androidExtraString;
        }
        if (orderName.equals("androidIntent")) {
            return _androidIntent;
        }
        if (orderName.equals("battery")) {
            return _battery;
        }
        if (orderName.equals("contact")) {
            return _contact;
        }
        if (orderName.equals("criticalNotification")) {
            return _criticalNotification;
        }
        if (orderName.equals("dailyActivity")) {
            return _dailyActivity;
        }
        if (orderName.equals("dailyActivityName")) {
            return _dailyActivityName;
        }
        if (orderName.equals("dailyActivityStats")) {
            return _dailyActivityStats;
        }
        if (orderName.equals("dailyReport")) {
            return _dailyReport;
        }
        if (orderName.equals("date")) {
            return _date;
        }
        if (orderName.equals("day")) {
            return _day;
        }
        if (orderName.equals("dayTime")) {
            return _dayTime;
        }
        if (orderName.equals("doorState")) {
            return _doorState;
        }
        if (orderName.equals("file")) {
            return _file;
        }
        if (orderName.equals("fileType")) {
            return _fileType;
        }
        if (orderName.equals("fitbitAlarm")) {
            return _fitbitAlarm;
        }
        if (orderName.equals("fitibitActivity")) {
            return _fitibitActivity;
        }
        if (orderName.equals("message")) {
            return _message;
        }
        if (orderName.equals("notification")) {
            return _notification;
        }
        if (orderName.equals("period")) {
            return _period;
        }
        if (orderName.equals("periodActivity")) {
            return _periodActivity;
        }
        if (orderName.equals("periodActivityName")) {
            return _periodActivityName;
        }
        if (orderName.equals("periodActivityStats")) {
            return _periodActivityStats;
        }
        if (orderName.equals("pulseRecord")) {
            return _pulseRecord;
        }
        if (orderName.equals("sleepPeriod")) {
            return _sleepPeriod;
        }
        if (orderName.equals("soundLevel")) {
            return _soundLevel;
        }
        if (orderName.equals("statisticReport")) {
            return _statisticReport;
        }
        if (orderName.equals("temperatureUnit")) {
            return _temperatureUnit;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute action from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction _action;
    
    /**
     * Set the value of the <code>action</code> attribute from device <code>WhoCares</code>.
    <p>
    Presence Detector
    attribute room as Room;
    Inactivity Sensor
    
    <pre>
    attribute action as Interaction;
    </pre>
    @param newActionValue the new value of <code>action</code>
     */
    protected void updateAction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newActionValue) {
        if (_action != newActionValue) {
            _action = newActionValue;
            updateAttribute("action", newActionValue);
        }
    }
    
    /**
     * Returns the value of the <code>action</code> attribute from device <code>WhoCares</code>.
    <p>
    Presence Detector
    attribute room as Room;
    Inactivity Sensor
    
    <pre>
    attribute action as Interaction;
    </pre>
    @return the value of <code>action</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction getAction() {
        return _action;
    }
    // End of code for the attribute action from device WhoCares
    
    // Code for the attribute actionType from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType _actionType;
    
    /**
     * Set the value of the <code>actionType</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute actionType as InteractionType;
    </pre>
    @param newActionTypeValue the new value of <code>actionType</code>
     */
    protected void updateActionType(fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType newActionTypeValue) {
        if (_actionType != newActionTypeValue) {
            _actionType = newActionTypeValue;
            updateAttribute("actionType", newActionTypeValue);
        }
    }
    
    /**
     * Returns the value of the <code>actionType</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute actionType as InteractionType;
    </pre>
    @return the value of <code>actionType</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType getActionType() {
        return _actionType;
    }
    // End of code for the attribute actionType from device WhoCares
    
    // Code for the attribute agendatEvent from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent _agendatEvent;
    
    /**
     * Set the value of the <code>agendatEvent</code> attribute from device <code>WhoCares</code>.
    <p>
    Home Service
    
    <pre>
    attribute agendatEvent as AgendaEvent;
    </pre>
    @param newAgendatEventValue the new value of <code>agendatEvent</code>
     */
    protected void updateAgendatEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newAgendatEventValue) {
        if (_agendatEvent != newAgendatEventValue) {
            _agendatEvent = newAgendatEventValue;
            updateAttribute("agendatEvent", newAgendatEventValue);
        }
    }
    
    /**
     * Returns the value of the <code>agendatEvent</code> attribute from device <code>WhoCares</code>.
    <p>
    Home Service
    
    <pre>
    attribute agendatEvent as AgendaEvent;
    </pre>
    @return the value of <code>agendatEvent</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent getAgendatEvent() {
        return _agendatEvent;
    }
    // End of code for the attribute agendatEvent from device WhoCares
    
    // Code for the attribute androidApp from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp _androidApp;
    
    /**
     * Set the value of the <code>androidApp</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidApp as AndroidApp;
    </pre>
    @param newAndroidAppValue the new value of <code>androidApp</code>
     */
    protected void updateAndroidApp(fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp newAndroidAppValue) {
        if (_androidApp != newAndroidAppValue) {
            _androidApp = newAndroidAppValue;
            updateAttribute("androidApp", newAndroidAppValue);
        }
    }
    
    /**
     * Returns the value of the <code>androidApp</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidApp as AndroidApp;
    </pre>
    @return the value of <code>androidApp</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp getAndroidApp() {
        return _androidApp;
    }
    // End of code for the attribute androidApp from device WhoCares
    
    // Code for the attribute androidExtraString from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString _androidExtraString;
    
    /**
     * Set the value of the <code>androidExtraString</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidExtraString as AndroidExtraString;
    </pre>
    @param newAndroidExtraStringValue the new value of <code>androidExtraString</code>
     */
    protected void updateAndroidExtraString(fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString newAndroidExtraStringValue) {
        if (_androidExtraString != newAndroidExtraStringValue) {
            _androidExtraString = newAndroidExtraStringValue;
            updateAttribute("androidExtraString", newAndroidExtraStringValue);
        }
    }
    
    /**
     * Returns the value of the <code>androidExtraString</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidExtraString as AndroidExtraString;
    </pre>
    @return the value of <code>androidExtraString</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString getAndroidExtraString() {
        return _androidExtraString;
    }
    // End of code for the attribute androidExtraString from device WhoCares
    
    // Code for the attribute androidIntent from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent _androidIntent;
    
    /**
     * Set the value of the <code>androidIntent</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidIntent as AndroidIntent;
    </pre>
    @param newAndroidIntentValue the new value of <code>androidIntent</code>
     */
    protected void updateAndroidIntent(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent newAndroidIntentValue) {
        if (_androidIntent != newAndroidIntentValue) {
            _androidIntent = newAndroidIntentValue;
            updateAttribute("androidIntent", newAndroidIntentValue);
        }
    }
    
    /**
     * Returns the value of the <code>androidIntent</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute androidIntent as AndroidIntent;
    </pre>
    @return the value of <code>androidIntent</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent getAndroidIntent() {
        return _androidIntent;
    }
    // End of code for the attribute androidIntent from device WhoCares
    
    // Code for the attribute battery from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.battery.Battery _battery;
    
    /**
     * Set the value of the <code>battery</code> attribute from device <code>WhoCares</code>.
    <p>
    Android
    
    <pre>
    attribute battery as Battery;
    </pre>
    @param newBatteryValue the new value of <code>battery</code>
     */
    protected void updateBattery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
        if (_battery != newBatteryValue) {
            _battery = newBatteryValue;
            updateAttribute("battery", newBatteryValue);
        }
    }
    
    /**
     * Returns the value of the <code>battery</code> attribute from device <code>WhoCares</code>.
    <p>
    Android
    
    <pre>
    attribute battery as Battery;
    </pre>
    @return the value of <code>battery</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.battery.Battery getBattery() {
        return _battery;
    }
    // End of code for the attribute battery from device WhoCares
    
    // Code for the attribute contact from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact _contact;
    
    /**
     * Set the value of the <code>contact</code> attribute from device <code>WhoCares</code>.
    <p>
    Messengers
    
    <pre>
    attribute contact as Contact;
    </pre>
    @param newContactValue the new value of <code>contact</code>
     */
    protected void updateContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContactValue) {
        if (_contact != newContactValue) {
            _contact = newContactValue;
            updateAttribute("contact", newContactValue);
        }
    }
    
    /**
     * Returns the value of the <code>contact</code> attribute from device <code>WhoCares</code>.
    <p>
    Messengers
    
    <pre>
    attribute contact as Contact;
    </pre>
    @return the value of <code>contact</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getContact() {
        return _contact;
    }
    // End of code for the attribute contact from device WhoCares
    
    // Code for the attribute criticalNotification from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification _criticalNotification;
    
    /**
     * Set the value of the <code>criticalNotification</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute criticalNotification as CriticalNotification;
    </pre>
    @param newCriticalNotificationValue the new value of <code>criticalNotification</code>
     */
    protected void updateCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification newCriticalNotificationValue) {
        if (_criticalNotification != newCriticalNotificationValue) {
            _criticalNotification = newCriticalNotificationValue;
            updateAttribute("criticalNotification", newCriticalNotificationValue);
        }
    }
    
    /**
     * Returns the value of the <code>criticalNotification</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute criticalNotification as CriticalNotification;
    </pre>
    @return the value of <code>criticalNotification</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification getCriticalNotification() {
        return _criticalNotification;
    }
    // End of code for the attribute criticalNotification from device WhoCares
    
    // Code for the attribute dailyActivity from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity _dailyActivity;
    
    /**
     * Set the value of the <code>dailyActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyActivity as DailyActivity;
    </pre>
    @param newDailyActivityValue the new value of <code>dailyActivity</code>
     */
    protected void updateDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
        if (_dailyActivity != newDailyActivityValue) {
            _dailyActivity = newDailyActivityValue;
            updateAttribute("dailyActivity", newDailyActivityValue);
        }
    }
    
    /**
     * Returns the value of the <code>dailyActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyActivity as DailyActivity;
    </pre>
    @return the value of <code>dailyActivity</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity getDailyActivity() {
        return _dailyActivity;
    }
    // End of code for the attribute dailyActivity from device WhoCares
    
    // Code for the attribute dailyActivityName from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName _dailyActivityName;
    
    /**
     * Set the value of the <code>dailyActivityName</code> attribute from device <code>WhoCares</code>.
    <p>
    Activity Notifier
    
    <pre>
    attribute dailyActivityName as DailyActivityName;
    </pre>
    @param newDailyActivityNameValue the new value of <code>dailyActivityName</code>
     */
    protected void updateDailyActivityName(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newDailyActivityNameValue) {
        if (_dailyActivityName != newDailyActivityNameValue) {
            _dailyActivityName = newDailyActivityNameValue;
            updateAttribute("dailyActivityName", newDailyActivityNameValue);
        }
    }
    
    /**
     * Returns the value of the <code>dailyActivityName</code> attribute from device <code>WhoCares</code>.
    <p>
    Activity Notifier
    
    <pre>
    attribute dailyActivityName as DailyActivityName;
    </pre>
    @return the value of <code>dailyActivityName</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName getDailyActivityName() {
        return _dailyActivityName;
    }
    // End of code for the attribute dailyActivityName from device WhoCares
    
    // Code for the attribute dailyActivityStats from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats _dailyActivityStats;
    
    /**
     * Set the value of the <code>dailyActivityStats</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyActivityStats as DailyActivityStats;
    </pre>
    @param newDailyActivityStatsValue the new value of <code>dailyActivityStats</code>
     */
    protected void updateDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue) {
        if (_dailyActivityStats != newDailyActivityStatsValue) {
            _dailyActivityStats = newDailyActivityStatsValue;
            updateAttribute("dailyActivityStats", newDailyActivityStatsValue);
        }
    }
    
    /**
     * Returns the value of the <code>dailyActivityStats</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyActivityStats as DailyActivityStats;
    </pre>
    @return the value of <code>dailyActivityStats</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats getDailyActivityStats() {
        return _dailyActivityStats;
    }
    // End of code for the attribute dailyActivityStats from device WhoCares
    
    // Code for the attribute dailyReport from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport _dailyReport;
    
    /**
     * Set the value of the <code>dailyReport</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyReport as DailyReport;
    </pre>
    @param newDailyReportValue the new value of <code>dailyReport</code>
     */
    protected void updateDailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
        if (_dailyReport != newDailyReportValue) {
            _dailyReport = newDailyReportValue;
            updateAttribute("dailyReport", newDailyReportValue);
        }
    }
    
    /**
     * Returns the value of the <code>dailyReport</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dailyReport as DailyReport;
    </pre>
    @return the value of <code>dailyReport</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport getDailyReport() {
        return _dailyReport;
    }
    // End of code for the attribute dailyReport from device WhoCares
    
    // Code for the attribute date from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date _date;
    
    /**
     * Set the value of the <code>date</code> attribute from device <code>WhoCares</code>.
    <p>
    Utils
    
    <pre>
    attribute date as Date;
    </pre>
    @param newDateValue the new value of <code>date</code>
     */
    protected void updateDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date newDateValue) {
        if (_date != newDateValue) {
            _date = newDateValue;
            updateAttribute("date", newDateValue);
        }
    }
    
    /**
     * Returns the value of the <code>date</code> attribute from device <code>WhoCares</code>.
    <p>
    Utils
    
    <pre>
    attribute date as Date;
    </pre>
    @return the value of <code>date</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return _date;
    }
    // End of code for the attribute date from device WhoCares
    
    // Code for the attribute day from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.day.Day _day;
    
    /**
     * Set the value of the <code>day</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute day as Day;
    </pre>
    @param newDayValue the new value of <code>day</code>
     */
    protected void updateDay(fr.inria.phoenix.diasuite.framework.datatype.day.Day newDayValue) {
        if (_day != newDayValue) {
            _day = newDayValue;
            updateAttribute("day", newDayValue);
        }
    }
    
    /**
     * Returns the value of the <code>day</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute day as Day;
    </pre>
    @return the value of <code>day</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.day.Day getDay() {
        return _day;
    }
    // End of code for the attribute day from device WhoCares
    
    // Code for the attribute dayTime from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime _dayTime;
    
    /**
     * Set the value of the <code>dayTime</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dayTime as DayTime;
    </pre>
    @param newDayTimeValue the new value of <code>dayTime</code>
     */
    protected void updateDayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newDayTimeValue) {
        if (_dayTime != newDayTimeValue) {
            _dayTime = newDayTimeValue;
            updateAttribute("dayTime", newDayTimeValue);
        }
    }
    
    /**
     * Returns the value of the <code>dayTime</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute dayTime as DayTime;
    </pre>
    @return the value of <code>dayTime</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime getDayTime() {
        return _dayTime;
    }
    // End of code for the attribute dayTime from device WhoCares
    
    // Code for the attribute doorState from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState _doorState;
    
    /**
     * Set the value of the <code>doorState</code> attribute from device <code>WhoCares</code>.
    <p>
    Sensors
    
    <pre>
    attribute doorState as DoorState;
    </pre>
    @param newDoorStateValue the new value of <code>doorState</code>
     */
    protected void updateDoorState(fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState newDoorStateValue) {
        if (_doorState != newDoorStateValue) {
            _doorState = newDoorStateValue;
            updateAttribute("doorState", newDoorStateValue);
        }
    }
    
    /**
     * Returns the value of the <code>doorState</code> attribute from device <code>WhoCares</code>.
    <p>
    Sensors
    
    <pre>
    attribute doorState as DoorState;
    </pre>
    @return the value of <code>doorState</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState getDoorState() {
        return _doorState;
    }
    // End of code for the attribute doorState from device WhoCares
    
    // Code for the attribute file from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.file.File _file;
    
    /**
     * Set the value of the <code>file</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute file as File;
    </pre>
    @param newFileValue the new value of <code>file</code>
     */
    protected void updateFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue) {
        if (_file != newFileValue) {
            _file = newFileValue;
            updateAttribute("file", newFileValue);
        }
    }
    
    /**
     * Returns the value of the <code>file</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute file as File;
    </pre>
    @return the value of <code>file</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File getFile() {
        return _file;
    }
    // End of code for the attribute file from device WhoCares
    
    // Code for the attribute fileType from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType _fileType;
    
    /**
     * Set the value of the <code>fileType</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fileType as FileType;
    </pre>
    @param newFileTypeValue the new value of <code>fileType</code>
     */
    protected void updateFileType(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType newFileTypeValue) {
        if (_fileType != newFileTypeValue) {
            _fileType = newFileTypeValue;
            updateAttribute("fileType", newFileTypeValue);
        }
    }
    
    /**
     * Returns the value of the <code>fileType</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fileType as FileType;
    </pre>
    @return the value of <code>fileType</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType getFileType() {
        return _fileType;
    }
    // End of code for the attribute fileType from device WhoCares
    
    // Code for the attribute fitbitAlarm from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm _fitbitAlarm;
    
    /**
     * Set the value of the <code>fitbitAlarm</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fitbitAlarm as FitbitAlarm;
    </pre>
    @param newFitbitAlarmValue the new value of <code>fitbitAlarm</code>
     */
    protected void updateFitbitAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newFitbitAlarmValue) {
        if (_fitbitAlarm != newFitbitAlarmValue) {
            _fitbitAlarm = newFitbitAlarmValue;
            updateAttribute("fitbitAlarm", newFitbitAlarmValue);
        }
    }
    
    /**
     * Returns the value of the <code>fitbitAlarm</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fitbitAlarm as FitbitAlarm;
    </pre>
    @return the value of <code>fitbitAlarm</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm getFitbitAlarm() {
        return _fitbitAlarm;
    }
    // End of code for the attribute fitbitAlarm from device WhoCares
    
    // Code for the attribute fitibitActivity from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity _fitibitActivity;
    
    /**
     * Set the value of the <code>fitibitActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fitibitActivity as FitbitActivity;
    </pre>
    @param newFitibitActivityValue the new value of <code>fitibitActivity</code>
     */
    protected void updateFitibitActivity(fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity newFitibitActivityValue) {
        if (_fitibitActivity != newFitibitActivityValue) {
            _fitibitActivity = newFitibitActivityValue;
            updateAttribute("fitibitActivity", newFitibitActivityValue);
        }
    }
    
    /**
     * Returns the value of the <code>fitibitActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute fitibitActivity as FitbitActivity;
    </pre>
    @return the value of <code>fitibitActivity</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity getFitibitActivity() {
        return _fitibitActivity;
    }
    // End of code for the attribute fitibitActivity from device WhoCares
    
    // Code for the attribute message from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message _message;
    
    /**
     * Set the value of the <code>message</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute message as Message;
    </pre>
    @param newMessageValue the new value of <code>message</code>
     */
    protected void updateMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newMessageValue) {
        if (_message != newMessageValue) {
            _message = newMessageValue;
            updateAttribute("message", newMessageValue);
        }
    }
    
    /**
     * Returns the value of the <code>message</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute message as Message;
    </pre>
    @return the value of <code>message</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.message.Message getMessage() {
        return _message;
    }
    // End of code for the attribute message from device WhoCares
    
    // Code for the attribute notification from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification _notification;
    
    /**
     * Set the value of the <code>notification</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute notification as NonCriticalNotification;
    </pre>
    @param newNotificationValue the new value of <code>notification</code>
     */
    protected void updateNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification newNotificationValue) {
        if (_notification != newNotificationValue) {
            _notification = newNotificationValue;
            updateAttribute("notification", newNotificationValue);
        }
    }
    
    /**
     * Returns the value of the <code>notification</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute notification as NonCriticalNotification;
    </pre>
    @return the value of <code>notification</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification getNotification() {
        return _notification;
    }
    // End of code for the attribute notification from device WhoCares
    
    // Code for the attribute period from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.period.Period _period;
    
    /**
     * Set the value of the <code>period</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute period as Period;
    </pre>
    @param newPeriodValue the new value of <code>period</code>
     */
    protected void updatePeriod(fr.inria.phoenix.diasuite.framework.datatype.period.Period newPeriodValue) {
        if (_period != newPeriodValue) {
            _period = newPeriodValue;
            updateAttribute("period", newPeriodValue);
        }
    }
    
    /**
     * Returns the value of the <code>period</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute period as Period;
    </pre>
    @return the value of <code>period</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.period.Period getPeriod() {
        return _period;
    }
    // End of code for the attribute period from device WhoCares
    
    // Code for the attribute periodActivity from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity _periodActivity;
    
    /**
     * Set the value of the <code>periodActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivity as PeriodActivity;
    </pre>
    @param newPeriodActivityValue the new value of <code>periodActivity</code>
     */
    protected void updatePeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
        if (_periodActivity != newPeriodActivityValue) {
            _periodActivity = newPeriodActivityValue;
            updateAttribute("periodActivity", newPeriodActivityValue);
        }
    }
    
    /**
     * Returns the value of the <code>periodActivity</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivity as PeriodActivity;
    </pre>
    @return the value of <code>periodActivity</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity getPeriodActivity() {
        return _periodActivity;
    }
    // End of code for the attribute periodActivity from device WhoCares
    
    // Code for the attribute periodActivityName from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName _periodActivityName;
    
    /**
     * Set the value of the <code>periodActivityName</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivityName as PeriodActivityName;
    </pre>
    @param newPeriodActivityNameValue the new value of <code>periodActivityName</code>
     */
    protected void updatePeriodActivityName(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName newPeriodActivityNameValue) {
        if (_periodActivityName != newPeriodActivityNameValue) {
            _periodActivityName = newPeriodActivityNameValue;
            updateAttribute("periodActivityName", newPeriodActivityNameValue);
        }
    }
    
    /**
     * Returns the value of the <code>periodActivityName</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivityName as PeriodActivityName;
    </pre>
    @return the value of <code>periodActivityName</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName getPeriodActivityName() {
        return _periodActivityName;
    }
    // End of code for the attribute periodActivityName from device WhoCares
    
    // Code for the attribute periodActivityStats from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats _periodActivityStats;
    
    /**
     * Set the value of the <code>periodActivityStats</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivityStats as PeriodActivityStats;
    </pre>
    @param newPeriodActivityStatsValue the new value of <code>periodActivityStats</code>
     */
    protected void updatePeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue) {
        if (_periodActivityStats != newPeriodActivityStatsValue) {
            _periodActivityStats = newPeriodActivityStatsValue;
            updateAttribute("periodActivityStats", newPeriodActivityStatsValue);
        }
    }
    
    /**
     * Returns the value of the <code>periodActivityStats</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute periodActivityStats as PeriodActivityStats;
    </pre>
    @return the value of <code>periodActivityStats</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats getPeriodActivityStats() {
        return _periodActivityStats;
    }
    // End of code for the attribute periodActivityStats from device WhoCares
    
    // Code for the attribute pulseRecord from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord _pulseRecord;
    
    /**
     * Set the value of the <code>pulseRecord</code> attribute from device <code>WhoCares</code>.
    <p>
    Fitbit
    
    <pre>
    attribute pulseRecord as PulseRecord;
    </pre>
    @param newPulseRecordValue the new value of <code>pulseRecord</code>
     */
    protected void updatePulseRecord(fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord newPulseRecordValue) {
        if (_pulseRecord != newPulseRecordValue) {
            _pulseRecord = newPulseRecordValue;
            updateAttribute("pulseRecord", newPulseRecordValue);
        }
    }
    
    /**
     * Returns the value of the <code>pulseRecord</code> attribute from device <code>WhoCares</code>.
    <p>
    Fitbit
    
    <pre>
    attribute pulseRecord as PulseRecord;
    </pre>
    @return the value of <code>pulseRecord</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord getPulseRecord() {
        return _pulseRecord;
    }
    // End of code for the attribute pulseRecord from device WhoCares
    
    // Code for the attribute sleepPeriod from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod _sleepPeriod;
    
    /**
     * Set the value of the <code>sleepPeriod</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute sleepPeriod as SleepPeriod;
    </pre>
    @param newSleepPeriodValue the new value of <code>sleepPeriod</code>
     */
    protected void updateSleepPeriod(fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod newSleepPeriodValue) {
        if (_sleepPeriod != newSleepPeriodValue) {
            _sleepPeriod = newSleepPeriodValue;
            updateAttribute("sleepPeriod", newSleepPeriodValue);
        }
    }
    
    /**
     * Returns the value of the <code>sleepPeriod</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute sleepPeriod as SleepPeriod;
    </pre>
    @return the value of <code>sleepPeriod</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod getSleepPeriod() {
        return _sleepPeriod;
    }
    // End of code for the attribute sleepPeriod from device WhoCares
    
    // Code for the attribute soundLevel from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel _soundLevel;
    
    /**
     * Set the value of the <code>soundLevel</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute soundLevel as SoundLevel;
    </pre>
    @param newSoundLevelValue the new value of <code>soundLevel</code>
     */
    protected void updateSoundLevel(fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel newSoundLevelValue) {
        if (_soundLevel != newSoundLevelValue) {
            _soundLevel = newSoundLevelValue;
            updateAttribute("soundLevel", newSoundLevelValue);
        }
    }
    
    /**
     * Returns the value of the <code>soundLevel</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute soundLevel as SoundLevel;
    </pre>
    @return the value of <code>soundLevel</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel getSoundLevel() {
        return _soundLevel;
    }
    // End of code for the attribute soundLevel from device WhoCares
    
    // Code for the attribute statisticReport from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport _statisticReport;
    
    /**
     * Set the value of the <code>statisticReport</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute statisticReport as StatisticReport;
    </pre>
    @param newStatisticReportValue the new value of <code>statisticReport</code>
     */
    protected void updateStatisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
        if (_statisticReport != newStatisticReportValue) {
            _statisticReport = newStatisticReportValue;
            updateAttribute("statisticReport", newStatisticReportValue);
        }
    }
    
    /**
     * Returns the value of the <code>statisticReport</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute statisticReport as StatisticReport;
    </pre>
    @return the value of <code>statisticReport</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport getStatisticReport() {
        return _statisticReport;
    }
    // End of code for the attribute statisticReport from device WhoCares
    
    // Code for the attribute temperatureUnit from device WhoCares
    private fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit _temperatureUnit;
    
    /**
     * Set the value of the <code>temperatureUnit</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute temperatureUnit as TemperatureUnit;
    </pre>
    @param newTemperatureUnitValue the new value of <code>temperatureUnit</code>
     */
    protected void updateTemperatureUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit newTemperatureUnitValue) {
        if (_temperatureUnit != newTemperatureUnitValue) {
            _temperatureUnit = newTemperatureUnitValue;
            updateAttribute("temperatureUnit", newTemperatureUnitValue);
        }
    }
    
    /**
     * Returns the value of the <code>temperatureUnit</code> attribute from device <code>WhoCares</code>.
    
    <pre>
    attribute temperatureUnit as TemperatureUnit;
    </pre>
    @return the value of <code>temperatureUnit</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit getTemperatureUnit() {
        return _temperatureUnit;
    }
    // End of code for the attribute temperatureUnit from device WhoCares
}
