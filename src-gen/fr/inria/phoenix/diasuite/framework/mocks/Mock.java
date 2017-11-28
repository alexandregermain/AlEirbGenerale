package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.diasuite.framework.controller.handlenotifier.AbstractHandleNotifier;
import fr.inria.phoenix.diasuite.framework.controller.handlepassword.AbstractHandlePassword;
import fr.inria.phoenix.diasuite.framework.controller.handletimer.AbstractHandleTimer;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.AbstractElapsedTime;
import fr.inria.phoenix.diasuite.framework.context.isinside.AbstractIsInside;
import fr.inria.phoenix.diasuite.framework.context.passwordlistener.AbstractPasswordListener;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.AbstractUpdatePassword;

/**
 * Use this class to test your DiaSuite application.
 *
 * <p>
 * Here is n example of usage to test an application that should trigger an action <code>action</code> on a device <code>TestDevice</code>
 * when it receive a source "src" from this device:
 * <pre>
 * ...
 * import static fr.inria.phoenix.diasuite.framework.mocks.Mock.*;
 * ...
 *    @Before
 *    public void setUp() throws Exception {
 *        underTest(MyAppComponentBinder.class);
 *    }
 *    
 *    @After
 *    public void tearDown() {
 *        shutdown();
 *    }
 *    
 *    @Test
 *    public void testMyApplication() {
 *        assertTrue(mockTestDevice().src("hehe").expectAction());
 *    }
 * ...
 */
@SuppressWarnings("all")
public final class Mock extends AppComponentBinder {
    
    /**
     * The time out, in milliseconds, before considering an action will never happens.
     * It should be changed if the application has long computations.
     */
    public static long TIMEOUT = 1000;
    
    private static Mock mocker;
    
    /**
     * Put a class under test
     * @param binder The application class
     * @return The mocking factory
     */
    public static Mock underTest(Class<? extends AppComponentBinder> binder) throws Exception {
        mocker = new Mock(binder);
        return mocker;
    }
    
    /**
     * Tear-down the device mocking framework
     */
    public static void shutdown() {
        if(mocker != null)
            mocker.undeployAll();
        mocker = null;
    }
    
    private AppComponentBinder delegate;
    private Mock(Class<? extends AppComponentBinder> binder) throws Exception {
        delegate = binder.newInstance();
        // Starts the framework
        deployAll();
    }
    
    @SuppressWarnings("unchecked")
    public ServiceConfiguration getServiceConfiguration(String name) {
        try {
            Class<? extends ServiceConfiguration> clazz = (Class<? extends ServiceConfiguration>) Class.forName("fr.inria.diagen.commlayer.local.LocalServiceConfiguration");
            java.lang.reflect.Constructor<? extends ServiceConfiguration> constructor = clazz.getConstructor(String.class);
            return constructor.newInstance(name);
        } catch (Exception ex) {
            fr.inria.diagen.log.DiaLog.critical("Unabled to initialize local communication layer. Please make sure correct libraries are in the classpath", ex);
            System.exit(-1);
            return null;
        }
    }
    
    private String randomId() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 10; i++)
            result.append(Integer.toString((int) (Math.random() * 10)));
        return result.toString();
    }
    
    // Delegation part
    public Class<? extends AbstractHandleNotifier> getHandleNotifierClass() {
        return delegate.getHandleNotifierClass();
    }
    public Class<? extends AbstractHandlePassword> getHandlePasswordClass() {
        return delegate.getHandlePasswordClass();
    }
    public Class<? extends AbstractHandleTimer> getHandleTimerClass() {
        return delegate.getHandleTimerClass();
    }
    public Class<? extends AbstractElapsedTime> getElapsedTimeClass() {
        return delegate.getElapsedTimeClass();
    }
    public Class<? extends AbstractIsInside> getIsInsideClass() {
        return delegate.getIsInsideClass();
    }
    public Class<? extends AbstractPasswordListener> getPasswordListenerClass() {
        return delegate.getPasswordListenerClass();
    }
    public Class<? extends AbstractUpdatePassword> getUpdatePasswordClass() {
        return delegate.getUpdatePasswordClass();
    }
    
    // Mocks constructor for all devices
    /**
     * Returns a mock of the device <code>Cooker</code>.
     * <p>
     * ------------------
     * Cooking Appliance
     * ------------------
     * 
     * <pre>
     * device Cooker extends Appliance , ElectricMeter {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Cooker</code>.
     */
    public CookerMock cooker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        CookerMock mock = new CookerMock(getServiceConfiguration("Cooker" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Cooker</code>.
     * <p>
     * ------------------
     * Cooking Appliance
     * ------------------
     * 
     * <pre>
     * device Cooker extends Appliance , ElectricMeter {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Cooker</code>.
     */
    public static CookerMock mockCooker(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.cooker(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Device</code>.
     * <p>
     * ------------------------------------------------------------
     * Devices							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Device {
     * 	attribute id as String;
     * 	source isAlive as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Device</code>.
     */
    public DeviceMock device(java.lang.String id) {
        DeviceMock mock = new DeviceMock(getServiceConfiguration("Device" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Device</code>.
     * <p>
     * ------------------------------------------------------------
     * Devices							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Device {
     * 	attribute id as String;
     * 	source isAlive as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Device</code>.
     */
    public static DeviceMock mockDevice(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.device(id);
    }
    
    /**
     * Returns a mock of the device <code>Android</code>.
     * 
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
     * @param id the value of the <code>id</code> attribute
     * @param type the value of the <code>type</code> attribute
     * @param version the value of the <code>version</code> attribute
     * @return a mock of the device <code>Android</code>.
     */
    public AndroidMock android(java.lang.String id,
            java.lang.String type,
            java.lang.Integer version) {
        AndroidMock mock = new AndroidMock(getServiceConfiguration("Android" + randomId()), id, type, version);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Android</code>.
     * 
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
     * @param id the value of the <code>id</code> attribute
     * @param type the value of the <code>type</code> attribute
     * @param version the value of the <code>version</code> attribute
     * @return a mock of the device <code>Android</code>.
     */
    public static AndroidMock mockAndroid(java.lang.String id,
            java.lang.String type,
            java.lang.Integer version) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.android(id, type, version);
    }
    
    /**
     * Returns a mock of the device <code>Fitbit</code>.
     * <p>
     * ------------------------------------------------------------
     * Fitbit							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Fitbit extends Device {
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
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Fitbit</code>.
     */
    public FitbitMock fitbit(java.lang.String id) {
        FitbitMock mock = new FitbitMock(getServiceConfiguration("Fitbit" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Fitbit</code>.
     * <p>
     * ------------------------------------------------------------
     * Fitbit							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Fitbit extends Device {
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
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Fitbit</code>.
     */
    public static FitbitMock mockFitbit(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.fitbit(id);
    }
    
    /**
     * Returns a mock of the device <code>PhysicalDevice</code>.
     * <p>
     * ------------------------------------------------------------
     * Physical Devices					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device PhysicalDevice extends Device {
     * 	attribute location as String;
     * 	attribute user as String;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>PhysicalDevice</code>.
     */
    public PhysicalDeviceMock physicalDevice(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        PhysicalDeviceMock mock = new PhysicalDeviceMock(getServiceConfiguration("PhysicalDevice" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>PhysicalDevice</code>.
     * <p>
     * ------------------------------------------------------------
     * Physical Devices					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device PhysicalDevice extends Device {
     * 	attribute location as String;
     * 	attribute user as String;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>PhysicalDevice</code>.
     */
    public static PhysicalDeviceMock mockPhysicalDevice(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.physicalDevice(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Appliance</code>.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Appliance</code>.
     */
    public ApplianceMock appliance(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ApplianceMock mock = new ApplianceMock(getServiceConfiguration("Appliance" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Appliance</code>.
     * <p>
     * ------------------------------------------------------------
     * Appliances						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Appliance extends PhysicalDevice {
     * 	source on as Boolean;
     * 	action On;
     * 	action Off;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Appliance</code>.
     */
    public static ApplianceMock mockAppliance(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.appliance(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Light</code>.
     * <p>
     * ------
     * Light
     * ------
     * 
     * <pre>
     * device Light extends Appliance {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Light</code>.
     */
    public LightMock light(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        LightMock mock = new LightMock(getServiceConfiguration("Light" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Light</code>.
     * <p>
     * ------
     * Light
     * ------
     * 
     * <pre>
     * device Light extends Appliance {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Light</code>.
     */
    public static LightMock mockLight(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.light(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Input</code>.
     * <p>
     * -------
     * Input
     * -------
     * 
     * <pre>
     * device Input extends PhysicalDevice {
     * 	source message as String;
     * 	action SetInput;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Input</code>.
     */
    public InputMock input(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        InputMock mock = new InputMock(getServiceConfiguration("Input" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Input</code>.
     * <p>
     * -------
     * Input
     * -------
     * 
     * <pre>
     * device Input extends PhysicalDevice {
     * 	source message as String;
     * 	action SetInput;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Input</code>.
     */
    public static InputMock mockInput(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.input(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Sensor</code>.
     * <p>
     * ------------------------------------------------------------
     * Sensor							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Sensor extends PhysicalDevice {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Sensor</code>.
     */
    public SensorMock sensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        SensorMock mock = new SensorMock(getServiceConfiguration("Sensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Sensor</code>.
     * <p>
     * ------------------------------------------------------------
     * Sensor							||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Sensor extends PhysicalDevice {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>Sensor</code>.
     */
    public static SensorMock mockSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.sensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ContactSensor</code>.
     * 
     * <pre>
     * device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>ContactSensor</code>.
     */
    public ContactSensorMock contactSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ContactSensorMock mock = new ContactSensorMock(getServiceConfiguration("ContactSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ContactSensor</code>.
     * 
     * <pre>
     * device ContactSensor extends Sensor {
     * 	source contact as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>ContactSensor</code>.
     */
    public static ContactSensorMock mockContactSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.contactSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>EnergyMeter</code>.
     * <p>
     * -------------
     * Energy Meter
     * -------------
     * 
     * <pre>
     * device EnergyMeter extends Sensor {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>EnergyMeter</code>.
     */
    public EnergyMeterMock energyMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        EnergyMeterMock mock = new EnergyMeterMock(getServiceConfiguration("EnergyMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>EnergyMeter</code>.
     * <p>
     * -------------
     * Energy Meter
     * -------------
     * 
     * <pre>
     * device EnergyMeter extends Sensor {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>EnergyMeter</code>.
     */
    public static EnergyMeterMock mockEnergyMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.energyMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>ElectricMeter</code>.
     * 
     * <pre>
     * device ElectricMeter extends EnergyMeter {
     * 	source consumption as Float;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>ElectricMeter</code>.
     */
    public ElectricMeterMock electricMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        ElectricMeterMock mock = new ElectricMeterMock(getServiceConfiguration("ElectricMeter" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ElectricMeter</code>.
     * 
     * <pre>
     * device ElectricMeter extends EnergyMeter {
     * 	source consumption as Float;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>ElectricMeter</code>.
     */
    public static ElectricMeterMock mockElectricMeter(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.electricMeter(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>LightSensor</code>.
     * 
     * <pre>
     * device LightSensor extends Sensor {
     * 	source lightLevel as Float;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>LightSensor</code>.
     */
    public LightSensorMock lightSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        LightSensorMock mock = new LightSensorMock(getServiceConfiguration("LightSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>LightSensor</code>.
     * 
     * <pre>
     * device LightSensor extends Sensor {
     * 	source lightLevel as Float;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>LightSensor</code>.
     */
    public static LightSensorMock mockLightSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.lightSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>MotionDetector</code>.
     * 
     * <pre>
     * device MotionDetector extends Sensor {
     * 	source motion as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>MotionDetector</code>.
     */
    public MotionDetectorMock motionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        MotionDetectorMock mock = new MotionDetectorMock(getServiceConfiguration("MotionDetector" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>MotionDetector</code>.
     * 
     * <pre>
     * device MotionDetector extends Sensor {
     * 	source motion as Boolean;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>MotionDetector</code>.
     */
    public static MotionDetectorMock mockMotionDetector(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.motionDetector(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>TemperatureSensor</code>.
     * 
     * <pre>
     * device TemperatureSensor extends Sensor {
     * 	source temperature as Float indexed by unit as TemperatureUnit;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>TemperatureSensor</code>.
     */
    public TemperatureSensorMock temperatureSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        TemperatureSensorMock mock = new TemperatureSensorMock(getServiceConfiguration("TemperatureSensor" + randomId()), id, location, user);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>TemperatureSensor</code>.
     * 
     * <pre>
     * device TemperatureSensor extends Sensor {
     * 	source temperature as Float indexed by unit as TemperatureUnit;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @param location the value of the <code>location</code> attribute
     * @param user the value of the <code>user</code> attribute
     * @return a mock of the device <code>TemperatureSensor</code>.
     */
    public static TemperatureSensorMock mockTemperatureSensor(java.lang.String id,
            java.lang.String location,
            java.lang.String user) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.temperatureSensor(id, location, user);
    }
    
    /**
     * Returns a mock of the device <code>Service</code>.
     * <p>
     * ------------------------------------------------------------
     * Services						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Service extends Device {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Service</code>.
     */
    public ServiceMock service(java.lang.String id) {
        ServiceMock mock = new ServiceMock(getServiceConfiguration("Service" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Service</code>.
     * <p>
     * ------------------------------------------------------------
     * Services						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device Service extends Device {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Service</code>.
     */
    public static ServiceMock mockService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.service(id);
    }
    
    /**
     * Returns a mock of the device <code>ActivityReporter</code>.
     * 
     * <pre>
     * device ActivityReporter extends Service {
     * 	source dailyReport as DailyReport;
     * 	source statisticReport as StatisticReport;
     * 	source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
     * 	source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
     * 	action UpdateCurrentReport;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>ActivityReporter</code>.
     */
    public ActivityReporterMock activityReporter(java.lang.String id) {
        ActivityReporterMock mock = new ActivityReporterMock(getServiceConfiguration("ActivityReporter" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ActivityReporter</code>.
     * 
     * <pre>
     * device ActivityReporter extends Service {
     * 	source dailyReport as DailyReport;
     * 	source statisticReport as StatisticReport;
     * 	source dailyActivityStats as DailyActivityStats indexed by activity as DailyActivityName;
     * 	source periodActivityStats as PeriodActivityStats indexed by activity as PeriodActivityName;
     * 	action UpdateCurrentReport;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>ActivityReporter</code>.
     */
    public static ActivityReporterMock mockActivityReporter(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.activityReporter(id);
    }
    
    /**
     * Returns a mock of the device <code>Clock</code>.
     * 
     * <pre>
     * device Clock extends Service {
     * 	source tickSecond as Integer;
     * 	source tickMinute as Integer;
     * 	source tickHour as Integer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Clock</code>.
     */
    public ClockMock clock(java.lang.String id) {
        ClockMock mock = new ClockMock(getServiceConfiguration("Clock" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Clock</code>.
     * 
     * <pre>
     * device Clock extends Service {
     * 	source tickSecond as Integer;
     * 	source tickMinute as Integer;
     * 	source tickHour as Integer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Clock</code>.
     */
    public static ClockMock mockClock(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.clock(id);
    }
    
    /**
     * Returns a mock of the device <code>CommunicationService</code>.
     * <p>
     * ------------------------------------------------------------
     * Communication Service					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device CommunicationService extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>CommunicationService</code>.
     */
    public CommunicationServiceMock communicationService(java.lang.String id) {
        CommunicationServiceMock mock = new CommunicationServiceMock(getServiceConfiguration("CommunicationService" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>CommunicationService</code>.
     * <p>
     * ------------------------------------------------------------
     * Communication Service					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device CommunicationService extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>CommunicationService</code>.
     */
    public static CommunicationServiceMock mockCommunicationService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.communicationService(id);
    }
    
    /**
     * Returns a mock of the device <code>Messenger</code>.
     * 
     * <pre>
     * device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Messenger</code>.
     */
    public MessengerMock messenger(java.lang.String id) {
        MessengerMock mock = new MessengerMock(getServiceConfiguration("Messenger" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Messenger</code>.
     * 
     * <pre>
     * device Messenger extends CommunicationService {
     * 	source lastMessage as Message;
     * 	action SendMessage;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Messenger</code>.
     */
    public static MessengerMock mockMessenger(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.messenger(id);
    }
    
    /**
     * Returns a mock of the device <code>Mailer</code>.
     * 
     * <pre>
     * device Mailer extends Messenger {
     * 	source unreadEmailCount as Integer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Mailer</code>.
     */
    public MailerMock mailer(java.lang.String id) {
        MailerMock mock = new MailerMock(getServiceConfiguration("Mailer" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Mailer</code>.
     * 
     * <pre>
     * device Mailer extends Messenger {
     * 	source unreadEmailCount as Integer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Mailer</code>.
     */
    public static MailerMock mockMailer(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.mailer(id);
    }
    
    /**
     * Returns a mock of the device <code>SMSSender</code>.
     * 
     * <pre>
     * device SMSSender extends Messenger {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>SMSSender</code>.
     */
    public SMSSenderMock sMSSender(java.lang.String id) {
        SMSSenderMock mock = new SMSSenderMock(getServiceConfiguration("SMSSender" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SMSSender</code>.
     * 
     * <pre>
     * device SMSSender extends Messenger {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>SMSSender</code>.
     */
    public static SMSSenderMock mockSMSSender(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.sMSSender(id);
    }
    
    /**
     * Returns a mock of the device <code>HomeService</code>.
     * <p>
     * ------------------------------------------------------------
     * HomeService						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device HomeService extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>HomeService</code>.
     */
    public HomeServiceMock homeService(java.lang.String id) {
        HomeServiceMock mock = new HomeServiceMock(getServiceConfiguration("HomeService" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>HomeService</code>.
     * <p>
     * ------------------------------------------------------------
     * HomeService						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device HomeService extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>HomeService</code>.
     */
    public static HomeServiceMock mockHomeService(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.homeService(id);
    }
    
    /**
     * Returns a mock of the device <code>Agenda</code>.
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
     * @param id the value of the <code>id</code> attribute
     * @param owner the value of the <code>owner</code> attribute
     * @return a mock of the device <code>Agenda</code>.
     */
    public AgendaMock agenda(java.lang.String id,
            java.lang.String owner) {
        AgendaMock mock = new AgendaMock(getServiceConfiguration("Agenda" + randomId()), id, owner);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Agenda</code>.
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
     * @param id the value of the <code>id</code> attribute
     * @param owner the value of the <code>owner</code> attribute
     * @return a mock of the device <code>Agenda</code>.
     */
    public static AgendaMock mockAgenda(java.lang.String id,
            java.lang.String owner) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.agenda(id, owner);
    }
    
    /**
     * Returns a mock of the device <code>Notifier</code>.
     * 
     * <pre>
     * device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Notifier</code>.
     */
    public NotifierMock notifier(java.lang.String id) {
        NotifierMock mock = new NotifierMock(getServiceConfiguration("Notifier" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Notifier</code>.
     * 
     * <pre>
     * device Notifier extends HomeService {
     * 	source cancelled as Boolean indexed by id as String;
     * 	source expired as Boolean indexed by id as String;
     * 	source reply as Integer indexed by id as String;
     * 	action SendCriticalNotification;
     * 	action SendNonCriticalNotification;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Notifier</code>.
     */
    public static NotifierMock mockNotifier(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.notifier(id);
    }
    
    /**
     * Returns a mock of the device <code>RoutineScheduler</code>.
     * 
     * <pre>
     * device RoutineScheduler extends Service {
     * 	source currentTime as DayTime;
     * 	source startMonitoring as DailyActivityName;
     * 	source stopMonitoring as DailyActivityName;
     * 	action UpdateDayTime;
     * 	action UpdateRoutines;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>RoutineScheduler</code>.
     */
    public RoutineSchedulerMock routineScheduler(java.lang.String id) {
        RoutineSchedulerMock mock = new RoutineSchedulerMock(getServiceConfiguration("RoutineScheduler" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>RoutineScheduler</code>.
     * 
     * <pre>
     * device RoutineScheduler extends Service {
     * 	source currentTime as DayTime;
     * 	source startMonitoring as DailyActivityName;
     * 	source stopMonitoring as DailyActivityName;
     * 	action UpdateDayTime;
     * 	action UpdateRoutines;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>RoutineScheduler</code>.
     */
    public static RoutineSchedulerMock mockRoutineScheduler(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.routineScheduler(id);
    }
    
    /**
     * Returns a mock of the device <code>SoftwareSensor</code>.
     * <p>
     * ------------------------------------------------------------
     * SoftwareSensor						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device SoftwareSensor extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>SoftwareSensor</code>.
     */
    public SoftwareSensorMock softwareSensor(java.lang.String id) {
        SoftwareSensorMock mock = new SoftwareSensorMock(getServiceConfiguration("SoftwareSensor" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>SoftwareSensor</code>.
     * <p>
     * ------------------------------------------------------------
     * SoftwareSensor						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device SoftwareSensor extends Service {
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>SoftwareSensor</code>.
     */
    public static SoftwareSensorMock mockSoftwareSensor(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.softwareSensor(id);
    }
    
    /**
     * Returns a mock of the device <code>ActivityNotifier</code>.
     * <p>
     * ------------------------------------------------------------
     * ActivityNotifier					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device ActivityNotifier extends SoftwareSensor {
     * 	source dailyActivity as DailyActivity;
     * 	source periodActivity as PeriodActivity;
     * 	action NotifyActivity;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>ActivityNotifier</code>.
     */
    public ActivityNotifierMock activityNotifier(java.lang.String id) {
        ActivityNotifierMock mock = new ActivityNotifierMock(getServiceConfiguration("ActivityNotifier" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>ActivityNotifier</code>.
     * <p>
     * ------------------------------------------------------------
     * ActivityNotifier					||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device ActivityNotifier extends SoftwareSensor {
     * 	source dailyActivity as DailyActivity;
     * 	source periodActivity as PeriodActivity;
     * 	action NotifyActivity;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>ActivityNotifier</code>.
     */
    public static ActivityNotifierMock mockActivityNotifier(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.activityNotifier(id);
    }
    
    /**
     * Returns a mock of the device <code>InactivitySensor</code>.
     * <p>
     * ------------------------------------------------------------
     * Presence Detector					||
     * ------------------------------------------------------------
     * enumeration Room {
     * ENTRANCE, BEDROOM, KITCHEN, BATHROOM, LIVING, TOILET
     * }
     * 
     * device IndoorLocationDetector extends SoftwareSensor {
     * // AR (14/02/17)
     * source currentRoom as Room;
     * action SetLocation;
     * }
     * 
     * action SetLocation {
     * setLocation(location as Room);
     * resetLocation();
     * }
     * ------------------------------------------------------------
     * InactivitySensor					||
     * ------------------------------------------------------------
     * AR (01/08/17)
     * 
     * <pre>
     * device InactivitySensor extends SoftwareSensor {
     * 	source inactivityLevel as Float;
     * 	source lastInteraction as Interaction;
     * 	action UpdateInactivityLevel;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>InactivitySensor</code>.
     */
    public InactivitySensorMock inactivitySensor(java.lang.String id) {
        InactivitySensorMock mock = new InactivitySensorMock(getServiceConfiguration("InactivitySensor" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>InactivitySensor</code>.
     * <p>
     * ------------------------------------------------------------
     * Presence Detector					||
     * ------------------------------------------------------------
     * enumeration Room {
     * ENTRANCE, BEDROOM, KITCHEN, BATHROOM, LIVING, TOILET
     * }
     * 
     * device IndoorLocationDetector extends SoftwareSensor {
     * // AR (14/02/17)
     * source currentRoom as Room;
     * action SetLocation;
     * }
     * 
     * action SetLocation {
     * setLocation(location as Room);
     * resetLocation();
     * }
     * ------------------------------------------------------------
     * InactivitySensor					||
     * ------------------------------------------------------------
     * AR (01/08/17)
     * 
     * <pre>
     * device InactivitySensor extends SoftwareSensor {
     * 	source inactivityLevel as Float;
     * 	source lastInteraction as Interaction;
     * 	action UpdateInactivityLevel;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>InactivitySensor</code>.
     */
    public static InactivitySensorMock mockInactivitySensor(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.inactivitySensor(id);
    }
    
    /**
     * Returns a mock of the device <code>Storage</code>.
     * <p>
     * --------
     * Storage
     * --------
     * 
     * <pre>
     * device Storage extends Service {
     * 	source data as String indexed by key as String;
     * 	action PutStringData;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Storage</code>.
     */
    public StorageMock storage(java.lang.String id) {
        StorageMock mock = new StorageMock(getServiceConfiguration("Storage" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Storage</code>.
     * <p>
     * --------
     * Storage
     * --------
     * 
     * <pre>
     * device Storage extends Service {
     * 	source data as String indexed by key as String;
     * 	action PutStringData;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Storage</code>.
     */
    public static StorageMock mockStorage(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.storage(id);
    }
    
    /**
     * Returns a mock of the device <code>Timer</code>.
     * <p>
     * ------
     * Timer
     * ------
     * 
     * <pre>
     * device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Timer</code>.
     */
    public TimerMock timer(java.lang.String id) {
        TimerMock mock = new TimerMock(getServiceConfiguration("Timer" + randomId()), id);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>Timer</code>.
     * <p>
     * ------
     * Timer
     * ------
     * 
     * <pre>
     * device Timer extends Service {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;
     * }
     * </pre>
     * @param id the value of the <code>id</code> attribute
     * @return a mock of the device <code>Timer</code>.
     */
    public static TimerMock mockTimer(java.lang.String id) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.timer(id);
    }
    
    /**
     * Returns a mock of the device <code>WhoCares</code>.
     * <p>
     * ------------------------------------------------------------
     * WhoCares						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device WhoCares {
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
     * </pre>
     * @param date the value of the <code>date</code> attribute
     * @param day the value of the <code>day</code> attribute
     * @param fileType the value of the <code>fileType</code> attribute
     * @param file the value of the <code>file</code> attribute
     * @param contact the value of the <code>contact</code> attribute
     * @param message the value of the <code>message</code> attribute
     * @param agendatEvent the value of the <code>agendatEvent</code> attribute
     * @param notification the value of the <code>notification</code> attribute
     * @param criticalNotification the value of the <code>criticalNotification</code> attribute
     * @param doorState the value of the <code>doorState</code> attribute
     * @param temperatureUnit the value of the <code>temperatureUnit</code> attribute
     * @param dailyActivityName the value of the <code>dailyActivityName</code> attribute
     * @param periodActivityName the value of the <code>periodActivityName</code> attribute
     * @param dailyActivity the value of the <code>dailyActivity</code> attribute
     * @param period the value of the <code>period</code> attribute
     * @param periodActivity the value of the <code>periodActivity</code> attribute
     * @param dailyReport the value of the <code>dailyReport</code> attribute
     * @param statisticReport the value of the <code>statisticReport</code> attribute
     * @param periodActivityStats the value of the <code>periodActivityStats</code> attribute
     * @param dailyActivityStats the value of the <code>dailyActivityStats</code> attribute
     * @param action the value of the <code>action</code> attribute
     * @param actionType the value of the <code>actionType</code> attribute
     * @param dayTime the value of the <code>dayTime</code> attribute
     * @param battery the value of the <code>battery</code> attribute
     * @param androidApp the value of the <code>androidApp</code> attribute
     * @param soundLevel the value of the <code>soundLevel</code> attribute
     * @param androidIntent the value of the <code>androidIntent</code> attribute
     * @param androidExtraString the value of the <code>androidExtraString</code> attribute
     * @param pulseRecord the value of the <code>pulseRecord</code> attribute
     * @param fitibitActivity the value of the <code>fitibitActivity</code> attribute
     * @param sleepPeriod the value of the <code>sleepPeriod</code> attribute
     * @param fitbitAlarm the value of the <code>fitbitAlarm</code> attribute
     * @return a mock of the device <code>WhoCares</code>.
     */
    public WhoCaresMock whoCares(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            fr.inria.phoenix.diasuite.framework.datatype.day.Day day,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType fileType,
            fr.inria.phoenix.diasuite.framework.datatype.file.File file,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact,
            fr.inria.phoenix.diasuite.framework.datatype.message.Message message,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent agendatEvent,
            fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification criticalNotification,
            fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState doorState,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit temperatureUnit,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName dailyActivityName,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName periodActivityName,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivity,
            fr.inria.phoenix.diasuite.framework.datatype.period.Period period,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivity,
            fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport dailyReport,
            fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport statisticReport,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats periodActivityStats,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats dailyActivityStats,
            fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction action,
            fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionType,
            fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime dayTime,
            fr.inria.phoenix.diasuite.framework.datatype.battery.Battery battery,
            fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp androidApp,
            fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel soundLevel,
            fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent androidIntent,
            fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString androidExtraString,
            fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord pulseRecord,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity fitibitActivity,
            fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod sleepPeriod,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm fitbitAlarm) {
        WhoCaresMock mock = new WhoCaresMock(getServiceConfiguration("WhoCares" + randomId()), date, day, fileType, file, contact, message, agendatEvent, notification, criticalNotification, doorState, temperatureUnit, dailyActivityName, periodActivityName, dailyActivity, period, periodActivity, dailyReport, statisticReport, periodActivityStats, dailyActivityStats, action, actionType, dayTime, battery, androidApp, soundLevel, androidIntent, androidExtraString, pulseRecord, fitibitActivity, sleepPeriod, fitbitAlarm);
        deploy(mock.proxy);
        return mock;
    }
    
    /**
     * Returns a mock of the device <code>WhoCares</code>.
     * <p>
     * ------------------------------------------------------------
     * WhoCares						||
     * ------------------------------------------------------------
     * 
     * <pre>
     * device WhoCares {
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
     * </pre>
     * @param date the value of the <code>date</code> attribute
     * @param day the value of the <code>day</code> attribute
     * @param fileType the value of the <code>fileType</code> attribute
     * @param file the value of the <code>file</code> attribute
     * @param contact the value of the <code>contact</code> attribute
     * @param message the value of the <code>message</code> attribute
     * @param agendatEvent the value of the <code>agendatEvent</code> attribute
     * @param notification the value of the <code>notification</code> attribute
     * @param criticalNotification the value of the <code>criticalNotification</code> attribute
     * @param doorState the value of the <code>doorState</code> attribute
     * @param temperatureUnit the value of the <code>temperatureUnit</code> attribute
     * @param dailyActivityName the value of the <code>dailyActivityName</code> attribute
     * @param periodActivityName the value of the <code>periodActivityName</code> attribute
     * @param dailyActivity the value of the <code>dailyActivity</code> attribute
     * @param period the value of the <code>period</code> attribute
     * @param periodActivity the value of the <code>periodActivity</code> attribute
     * @param dailyReport the value of the <code>dailyReport</code> attribute
     * @param statisticReport the value of the <code>statisticReport</code> attribute
     * @param periodActivityStats the value of the <code>periodActivityStats</code> attribute
     * @param dailyActivityStats the value of the <code>dailyActivityStats</code> attribute
     * @param action the value of the <code>action</code> attribute
     * @param actionType the value of the <code>actionType</code> attribute
     * @param dayTime the value of the <code>dayTime</code> attribute
     * @param battery the value of the <code>battery</code> attribute
     * @param androidApp the value of the <code>androidApp</code> attribute
     * @param soundLevel the value of the <code>soundLevel</code> attribute
     * @param androidIntent the value of the <code>androidIntent</code> attribute
     * @param androidExtraString the value of the <code>androidExtraString</code> attribute
     * @param pulseRecord the value of the <code>pulseRecord</code> attribute
     * @param fitibitActivity the value of the <code>fitibitActivity</code> attribute
     * @param sleepPeriod the value of the <code>sleepPeriod</code> attribute
     * @param fitbitAlarm the value of the <code>fitbitAlarm</code> attribute
     * @return a mock of the device <code>WhoCares</code>.
     */
    public static WhoCaresMock mockWhoCares(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            fr.inria.phoenix.diasuite.framework.datatype.day.Day day,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType fileType,
            fr.inria.phoenix.diasuite.framework.datatype.file.File file,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact,
            fr.inria.phoenix.diasuite.framework.datatype.message.Message message,
            fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent agendatEvent,
            fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification notification,
            fr.inria.phoenix.diasuite.framework.datatype.criticalnotification.CriticalNotification criticalNotification,
            fr.inria.phoenix.diasuite.framework.datatype.doorstate.DoorState doorState,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit temperatureUnit,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivityname.DailyActivityName dailyActivityName,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivityname.PeriodActivityName periodActivityName,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity dailyActivity,
            fr.inria.phoenix.diasuite.framework.datatype.period.Period period,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivity.PeriodActivity periodActivity,
            fr.inria.phoenix.diasuite.framework.datatype.dailyreport.DailyReport dailyReport,
            fr.inria.phoenix.diasuite.framework.datatype.statisticreport.StatisticReport statisticReport,
            fr.inria.phoenix.diasuite.framework.datatype.periodactivitystats.PeriodActivityStats periodActivityStats,
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivitystats.DailyActivityStats dailyActivityStats,
            fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction action,
            fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType actionType,
            fr.inria.phoenix.diasuite.framework.datatype.daytime.DayTime dayTime,
            fr.inria.phoenix.diasuite.framework.datatype.battery.Battery battery,
            fr.inria.phoenix.diasuite.framework.datatype.androidapp.AndroidApp androidApp,
            fr.inria.phoenix.diasuite.framework.datatype.soundlevel.SoundLevel soundLevel,
            fr.inria.phoenix.diasuite.framework.datatype.androidintent.AndroidIntent androidIntent,
            fr.inria.phoenix.diasuite.framework.datatype.androidextrastring.AndroidExtraString androidExtraString,
            fr.inria.phoenix.diasuite.framework.datatype.pulserecord.PulseRecord pulseRecord,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitactivity.FitbitActivity fitibitActivity,
            fr.inria.phoenix.diasuite.framework.datatype.sleepperiod.SleepPeriod sleepPeriod,
            fr.inria.phoenix.diasuite.framework.datatype.fitbitalarm.FitbitAlarm fitbitAlarm) {
        if(mocker == null)
            throw new RuntimeException("Mock is not initialized");
        return mocker.whoCares(date, day, fileType, file, contact, message, agendatEvent, notification, criticalNotification, doorState, temperatureUnit, dailyActivityName, periodActivityName, dailyActivity, period, periodActivity, dailyReport, statisticReport, periodActivityStats, dailyActivityStats, action, actionType, dayTime, battery, androidApp, soundLevel, androidIntent, androidExtraString, pulseRecord, fitibitActivity, sleepPeriod, fitbitAlarm);
    }
    
}
