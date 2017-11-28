package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.whocares.AbstractWhoCares;

// @internal
public final class WhoCaresMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractWhoCares {
        private Proxy(ServiceConfiguration serviceConfiguration,
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
            super(serviceConfiguration, dateValue, dayValue, fileTypeValue, fileValue, contactValue, messageValue, agendatEventValue, notificationValue, criticalNotificationValue, doorStateValue, temperatureUnitValue, dailyActivityNameValue, periodActivityNameValue, dailyActivityValue, periodValue, periodActivityValue, dailyReportValue, statisticReportValue, periodActivityStatsValue, dailyActivityStatsValue, actionValue, actionTypeValue, dayTimeValue, batteryValue, androidAppValue, soundLevelValue, androidIntentValue, androidExtraStringValue, pulseRecordValue, fitibitActivityValue, sleepPeriodValue, fitbitAlarmValue);
        }
        
        public void _updateDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date newDateValue) {
            updateDate(newDateValue);
        }
        
        public void _updateDay(fr.inria.phoenix.diasuite.framework.datatype.day.Day newDayValue) {
            updateDay(newDayValue);
        }
        
        public void _updateFileType(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType newFileTypeValue) {
            updateFileType(newFileTypeValue);
        }
        
        public void _updateFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue) {
            updateFile(newFileValue);
        }
        
        public void _updateContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContactValue) {
            updateContact(newContactValue);
        }
        
        public void _updateMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newMessageValue) {
            updateMessage(newMessageValue);
        }
        
        public void _updateAgendatEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newAgendatEventValue) {
            updateAgendatEvent(newAgendatEventValue);
        }
        
        public void _updateNotification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification newNotificationValue) {
            updateNotification(newNotificationValue);
        }
        
        public void _updateCriticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification newCriticalNotificationValue) {
            updateCriticalNotification(newCriticalNotificationValue);
        }
        
        public void _updateDoorState(fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState newDoorStateValue) {
            updateDoorState(newDoorStateValue);
        }
        
        public void _updateTemperatureUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit newTemperatureUnitValue) {
            updateTemperatureUnit(newTemperatureUnitValue);
        }
        
        public void _updateDailyActivityName(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newDailyActivityNameValue) {
            updateDailyActivityName(newDailyActivityNameValue);
        }
        
        public void _updatePeriodActivityName(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName newPeriodActivityNameValue) {
            updatePeriodActivityName(newPeriodActivityNameValue);
        }
        
        public void _updateDailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
            updateDailyActivity(newDailyActivityValue);
        }
        
        public void _updatePeriod(fr.inria.phoenix.diasuite.framework.datatype.period.Period newPeriodValue) {
            updatePeriod(newPeriodValue);
        }
        
        public void _updatePeriodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
            updatePeriodActivity(newPeriodActivityValue);
        }
        
        public void _updateDailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
            updateDailyReport(newDailyReportValue);
        }
        
        public void _updateStatisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
            updateStatisticReport(newStatisticReportValue);
        }
        
        public void _updatePeriodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue) {
            updatePeriodActivityStats(newPeriodActivityStatsValue);
        }
        
        public void _updateDailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue) {
            updateDailyActivityStats(newDailyActivityStatsValue);
        }
        
        public void _updateAction(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newActionValue) {
            updateAction(newActionValue);
        }
        
        public void _updateActionType(fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType newActionTypeValue) {
            updateActionType(newActionTypeValue);
        }
        
        public void _updateDayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newDayTimeValue) {
            updateDayTime(newDayTimeValue);
        }
        
        public void _updateBattery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
            updateBattery(newBatteryValue);
        }
        
        public void _updateAndroidApp(fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp newAndroidAppValue) {
            updateAndroidApp(newAndroidAppValue);
        }
        
        public void _updateSoundLevel(fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel newSoundLevelValue) {
            updateSoundLevel(newSoundLevelValue);
        }
        
        public void _updateAndroidIntent(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent newAndroidIntentValue) {
            updateAndroidIntent(newAndroidIntentValue);
        }
        
        public void _updateAndroidExtraString(fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString newAndroidExtraStringValue) {
            updateAndroidExtraString(newAndroidExtraStringValue);
        }
        
        public void _updatePulseRecord(fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord newPulseRecordValue) {
            updatePulseRecord(newPulseRecordValue);
        }
        
        public void _updateFitibitActivity(fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity newFitibitActivityValue) {
            updateFitibitActivity(newFitibitActivityValue);
        }
        
        public void _updateSleepPeriod(fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod newSleepPeriodValue) {
            updateSleepPeriod(newSleepPeriodValue);
        }
        
        public void _updateFitbitAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newFitbitAlarmValue) {
            updateFitbitAlarm(newFitbitAlarmValue);
        }
    }
    
    Proxy proxy;
    
    WhoCaresMock(ServiceConfiguration serviceConfiguration,
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
        this.proxy = new Proxy(serviceConfiguration, dateValue, dayValue, fileTypeValue, fileValue, contactValue, messageValue, agendatEventValue, notificationValue, criticalNotificationValue, doorStateValue, temperatureUnitValue, dailyActivityNameValue, periodActivityNameValue, dailyActivityValue, periodValue, periodActivityValue, dailyReportValue, statisticReportValue, periodActivityStatsValue, dailyActivityStatsValue, actionValue, actionTypeValue, dayTimeValue, batteryValue, androidAppValue, soundLevelValue, androidIntentValue, androidExtraStringValue, pulseRecordValue, fitibitActivityValue, sleepPeriodValue, fitbitAlarmValue);
    }
    
    
    // Code for the attribute date from device WhoCares
    /**
     * Set the value of the <code>date</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Utils
     * 
     * <pre>
     * attribute date as Date;
     * </pre>
     * @param newDateValue the new value of <code>date</code>
     * @return this for fluent interface
     */
    public WhoCaresMock date(fr.inria.phoenix.diasuite.framework.datatype.date.Date newDateValue) {
        proxy._updateDate(newDateValue);
        return this;
    }
    // End of code for the attribute date from device WhoCares
    
    // Code for the attribute day from device WhoCares
    /**
     * Set the value of the <code>day</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute day as Day;
     * </pre>
     * @param newDayValue the new value of <code>day</code>
     * @return this for fluent interface
     */
    public WhoCaresMock day(fr.inria.phoenix.diasuite.framework.datatype.day.Day newDayValue) {
        proxy._updateDay(newDayValue);
        return this;
    }
    // End of code for the attribute day from device WhoCares
    
    // Code for the attribute fileType from device WhoCares
    /**
     * Set the value of the <code>fileType</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute fileType as FileType;
     * </pre>
     * @param newFileTypeValue the new value of <code>fileType</code>
     * @return this for fluent interface
     */
    public WhoCaresMock fileType(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType newFileTypeValue) {
        proxy._updateFileType(newFileTypeValue);
        return this;
    }
    // End of code for the attribute fileType from device WhoCares
    
    // Code for the attribute file from device WhoCares
    /**
     * Set the value of the <code>file</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute file as File;
     * </pre>
     * @param newFileValue the new value of <code>file</code>
     * @return this for fluent interface
     */
    public WhoCaresMock file(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue) {
        proxy._updateFile(newFileValue);
        return this;
    }
    // End of code for the attribute file from device WhoCares
    
    // Code for the attribute contact from device WhoCares
    /**
     * Set the value of the <code>contact</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Messengers
     * 
     * <pre>
     * attribute contact as Contact;
     * </pre>
     * @param newContactValue the new value of <code>contact</code>
     * @return this for fluent interface
     */
    public WhoCaresMock contact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContactValue) {
        proxy._updateContact(newContactValue);
        return this;
    }
    // End of code for the attribute contact from device WhoCares
    
    // Code for the attribute message from device WhoCares
    /**
     * Set the value of the <code>message</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute message as Message;
     * </pre>
     * @param newMessageValue the new value of <code>message</code>
     * @return this for fluent interface
     */
    public WhoCaresMock message(fr.inria.phoenix.diasuite.framework.datatype.message.Message newMessageValue) {
        proxy._updateMessage(newMessageValue);
        return this;
    }
    // End of code for the attribute message from device WhoCares
    
    // Code for the attribute agendatEvent from device WhoCares
    /**
     * Set the value of the <code>agendatEvent</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Home Service
     * 
     * <pre>
     * attribute agendatEvent as AgendaEvent;
     * </pre>
     * @param newAgendatEventValue the new value of <code>agendatEvent</code>
     * @return this for fluent interface
     */
    public WhoCaresMock agendatEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newAgendatEventValue) {
        proxy._updateAgendatEvent(newAgendatEventValue);
        return this;
    }
    // End of code for the attribute agendatEvent from device WhoCares
    
    // Code for the attribute notification from device WhoCares
    /**
     * Set the value of the <code>notification</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute notification as NonCriticalNotification;
     * </pre>
     * @param newNotificationValue the new value of <code>notification</code>
     * @return this for fluent interface
     */
    public WhoCaresMock notification(fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification newNotificationValue) {
        proxy._updateNotification(newNotificationValue);
        return this;
    }
    // End of code for the attribute notification from device WhoCares
    
    // Code for the attribute criticalNotification from device WhoCares
    /**
     * Set the value of the <code>criticalNotification</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute criticalNotification as CriticalNotification;
     * </pre>
     * @param newCriticalNotificationValue the new value of <code>criticalNotification</code>
     * @return this for fluent interface
     */
    public WhoCaresMock criticalNotification(fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification newCriticalNotificationValue) {
        proxy._updateCriticalNotification(newCriticalNotificationValue);
        return this;
    }
    // End of code for the attribute criticalNotification from device WhoCares
    
    // Code for the attribute doorState from device WhoCares
    /**
     * Set the value of the <code>doorState</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Sensors
     * 
     * <pre>
     * attribute doorState as DoorState;
     * </pre>
     * @param newDoorStateValue the new value of <code>doorState</code>
     * @return this for fluent interface
     */
    public WhoCaresMock doorState(fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState newDoorStateValue) {
        proxy._updateDoorState(newDoorStateValue);
        return this;
    }
    // End of code for the attribute doorState from device WhoCares
    
    // Code for the attribute temperatureUnit from device WhoCares
    /**
     * Set the value of the <code>temperatureUnit</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute temperatureUnit as TemperatureUnit;
     * </pre>
     * @param newTemperatureUnitValue the new value of <code>temperatureUnit</code>
     * @return this for fluent interface
     */
    public WhoCaresMock temperatureUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit newTemperatureUnitValue) {
        proxy._updateTemperatureUnit(newTemperatureUnitValue);
        return this;
    }
    // End of code for the attribute temperatureUnit from device WhoCares
    
    // Code for the attribute dailyActivityName from device WhoCares
    /**
     * Set the value of the <code>dailyActivityName</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Activity Notifier
     * 
     * <pre>
     * attribute dailyActivityName as DailyActivityName;
     * </pre>
     * @param newDailyActivityNameValue the new value of <code>dailyActivityName</code>
     * @return this for fluent interface
     */
    public WhoCaresMock dailyActivityName(fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName newDailyActivityNameValue) {
        proxy._updateDailyActivityName(newDailyActivityNameValue);
        return this;
    }
    // End of code for the attribute dailyActivityName from device WhoCares
    
    // Code for the attribute periodActivityName from device WhoCares
    /**
     * Set the value of the <code>periodActivityName</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute periodActivityName as PeriodActivityName;
     * </pre>
     * @param newPeriodActivityNameValue the new value of <code>periodActivityName</code>
     * @return this for fluent interface
     */
    public WhoCaresMock periodActivityName(fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName newPeriodActivityNameValue) {
        proxy._updatePeriodActivityName(newPeriodActivityNameValue);
        return this;
    }
    // End of code for the attribute periodActivityName from device WhoCares
    
    // Code for the attribute dailyActivity from device WhoCares
    /**
     * Set the value of the <code>dailyActivity</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute dailyActivity as DailyActivity;
     * </pre>
     * @param newDailyActivityValue the new value of <code>dailyActivity</code>
     * @return this for fluent interface
     */
    public WhoCaresMock dailyActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newDailyActivityValue) {
        proxy._updateDailyActivity(newDailyActivityValue);
        return this;
    }
    // End of code for the attribute dailyActivity from device WhoCares
    
    // Code for the attribute period from device WhoCares
    /**
     * Set the value of the <code>period</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute period as Period;
     * </pre>
     * @param newPeriodValue the new value of <code>period</code>
     * @return this for fluent interface
     */
    public WhoCaresMock period(fr.inria.phoenix.diasuite.framework.datatype.period.Period newPeriodValue) {
        proxy._updatePeriod(newPeriodValue);
        return this;
    }
    // End of code for the attribute period from device WhoCares
    
    // Code for the attribute periodActivity from device WhoCares
    /**
     * Set the value of the <code>periodActivity</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute periodActivity as PeriodActivity;
     * </pre>
     * @param newPeriodActivityValue the new value of <code>periodActivity</code>
     * @return this for fluent interface
     */
    public WhoCaresMock periodActivity(fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity newPeriodActivityValue) {
        proxy._updatePeriodActivity(newPeriodActivityValue);
        return this;
    }
    // End of code for the attribute periodActivity from device WhoCares
    
    // Code for the attribute dailyReport from device WhoCares
    /**
     * Set the value of the <code>dailyReport</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute dailyReport as DailyReport;
     * </pre>
     * @param newDailyReportValue the new value of <code>dailyReport</code>
     * @return this for fluent interface
     */
    public WhoCaresMock dailyReport(fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport newDailyReportValue) {
        proxy._updateDailyReport(newDailyReportValue);
        return this;
    }
    // End of code for the attribute dailyReport from device WhoCares
    
    // Code for the attribute statisticReport from device WhoCares
    /**
     * Set the value of the <code>statisticReport</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute statisticReport as StatisticReport;
     * </pre>
     * @param newStatisticReportValue the new value of <code>statisticReport</code>
     * @return this for fluent interface
     */
    public WhoCaresMock statisticReport(fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport newStatisticReportValue) {
        proxy._updateStatisticReport(newStatisticReportValue);
        return this;
    }
    // End of code for the attribute statisticReport from device WhoCares
    
    // Code for the attribute periodActivityStats from device WhoCares
    /**
     * Set the value of the <code>periodActivityStats</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute periodActivityStats as PeriodActivityStats;
     * </pre>
     * @param newPeriodActivityStatsValue the new value of <code>periodActivityStats</code>
     * @return this for fluent interface
     */
    public WhoCaresMock periodActivityStats(fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats newPeriodActivityStatsValue) {
        proxy._updatePeriodActivityStats(newPeriodActivityStatsValue);
        return this;
    }
    // End of code for the attribute periodActivityStats from device WhoCares
    
    // Code for the attribute dailyActivityStats from device WhoCares
    /**
     * Set the value of the <code>dailyActivityStats</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute dailyActivityStats as DailyActivityStats;
     * </pre>
     * @param newDailyActivityStatsValue the new value of <code>dailyActivityStats</code>
     * @return this for fluent interface
     */
    public WhoCaresMock dailyActivityStats(fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats newDailyActivityStatsValue) {
        proxy._updateDailyActivityStats(newDailyActivityStatsValue);
        return this;
    }
    // End of code for the attribute dailyActivityStats from device WhoCares
    
    // Code for the attribute action from device WhoCares
    /**
     * Set the value of the <code>action</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Presence Detector
     * attribute room as Room;
     * Inactivity Sensor
     * 
     * <pre>
     * attribute action as Interaction;
     * </pre>
     * @param newActionValue the new value of <code>action</code>
     * @return this for fluent interface
     */
    public WhoCaresMock action(fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction newActionValue) {
        proxy._updateAction(newActionValue);
        return this;
    }
    // End of code for the attribute action from device WhoCares
    
    // Code for the attribute actionType from device WhoCares
    /**
     * Set the value of the <code>actionType</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute actionType as InteractionType;
     * </pre>
     * @param newActionTypeValue the new value of <code>actionType</code>
     * @return this for fluent interface
     */
    public WhoCaresMock actionType(fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType newActionTypeValue) {
        proxy._updateActionType(newActionTypeValue);
        return this;
    }
    // End of code for the attribute actionType from device WhoCares
    
    // Code for the attribute dayTime from device WhoCares
    /**
     * Set the value of the <code>dayTime</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute dayTime as DayTime;
     * </pre>
     * @param newDayTimeValue the new value of <code>dayTime</code>
     * @return this for fluent interface
     */
    public WhoCaresMock dayTime(fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime newDayTimeValue) {
        proxy._updateDayTime(newDayTimeValue);
        return this;
    }
    // End of code for the attribute dayTime from device WhoCares
    
    // Code for the attribute battery from device WhoCares
    /**
     * Set the value of the <code>battery</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Android
     * 
     * <pre>
     * attribute battery as Battery;
     * </pre>
     * @param newBatteryValue the new value of <code>battery</code>
     * @return this for fluent interface
     */
    public WhoCaresMock battery(fr.inria.phoenix.diasuite.framework.datatype.battery.Battery newBatteryValue) {
        proxy._updateBattery(newBatteryValue);
        return this;
    }
    // End of code for the attribute battery from device WhoCares
    
    // Code for the attribute androidApp from device WhoCares
    /**
     * Set the value of the <code>androidApp</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute androidApp as AndroidApp;
     * </pre>
     * @param newAndroidAppValue the new value of <code>androidApp</code>
     * @return this for fluent interface
     */
    public WhoCaresMock androidApp(fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp newAndroidAppValue) {
        proxy._updateAndroidApp(newAndroidAppValue);
        return this;
    }
    // End of code for the attribute androidApp from device WhoCares
    
    // Code for the attribute soundLevel from device WhoCares
    /**
     * Set the value of the <code>soundLevel</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute soundLevel as SoundLevel;
     * </pre>
     * @param newSoundLevelValue the new value of <code>soundLevel</code>
     * @return this for fluent interface
     */
    public WhoCaresMock soundLevel(fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel newSoundLevelValue) {
        proxy._updateSoundLevel(newSoundLevelValue);
        return this;
    }
    // End of code for the attribute soundLevel from device WhoCares
    
    // Code for the attribute androidIntent from device WhoCares
    /**
     * Set the value of the <code>androidIntent</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute androidIntent as AndroidIntent;
     * </pre>
     * @param newAndroidIntentValue the new value of <code>androidIntent</code>
     * @return this for fluent interface
     */
    public WhoCaresMock androidIntent(fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent newAndroidIntentValue) {
        proxy._updateAndroidIntent(newAndroidIntentValue);
        return this;
    }
    // End of code for the attribute androidIntent from device WhoCares
    
    // Code for the attribute androidExtraString from device WhoCares
    /**
     * Set the value of the <code>androidExtraString</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute androidExtraString as AndroidExtraString;
     * </pre>
     * @param newAndroidExtraStringValue the new value of <code>androidExtraString</code>
     * @return this for fluent interface
     */
    public WhoCaresMock androidExtraString(fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString newAndroidExtraStringValue) {
        proxy._updateAndroidExtraString(newAndroidExtraStringValue);
        return this;
    }
    // End of code for the attribute androidExtraString from device WhoCares
    
    // Code for the attribute pulseRecord from device WhoCares
    /**
     * Set the value of the <code>pulseRecord</code> attribute from device <code>WhoCares</code>.
     * <p>
     * Fitbit
     * 
     * <pre>
     * attribute pulseRecord as PulseRecord;
     * </pre>
     * @param newPulseRecordValue the new value of <code>pulseRecord</code>
     * @return this for fluent interface
     */
    public WhoCaresMock pulseRecord(fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord newPulseRecordValue) {
        proxy._updatePulseRecord(newPulseRecordValue);
        return this;
    }
    // End of code for the attribute pulseRecord from device WhoCares
    
    // Code for the attribute fitibitActivity from device WhoCares
    /**
     * Set the value of the <code>fitibitActivity</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute fitibitActivity as FitbitActivity;
     * </pre>
     * @param newFitibitActivityValue the new value of <code>fitibitActivity</code>
     * @return this for fluent interface
     */
    public WhoCaresMock fitibitActivity(fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity newFitibitActivityValue) {
        proxy._updateFitibitActivity(newFitibitActivityValue);
        return this;
    }
    // End of code for the attribute fitibitActivity from device WhoCares
    
    // Code for the attribute sleepPeriod from device WhoCares
    /**
     * Set the value of the <code>sleepPeriod</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute sleepPeriod as SleepPeriod;
     * </pre>
     * @param newSleepPeriodValue the new value of <code>sleepPeriod</code>
     * @return this for fluent interface
     */
    public WhoCaresMock sleepPeriod(fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod newSleepPeriodValue) {
        proxy._updateSleepPeriod(newSleepPeriodValue);
        return this;
    }
    // End of code for the attribute sleepPeriod from device WhoCares
    
    // Code for the attribute fitbitAlarm from device WhoCares
    /**
     * Set the value of the <code>fitbitAlarm</code> attribute from device <code>WhoCares</code>.
     * 
     * <pre>
     * attribute fitbitAlarm as FitbitAlarm;
     * </pre>
     * @param newFitbitAlarmValue the new value of <code>fitbitAlarm</code>
     * @return this for fluent interface
     */
    public WhoCaresMock fitbitAlarm(fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm newFitbitAlarmValue) {
        proxy._updateFitbitAlarm(newFitbitAlarmValue);
        return this;
    }
    // End of code for the attribute fitbitAlarm from device WhoCares
}
