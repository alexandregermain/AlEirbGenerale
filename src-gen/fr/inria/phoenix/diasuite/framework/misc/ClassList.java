package fr.inria.phoenix.diasuite.framework.misc;

import java.util.HashMap;
import java.util.Map;

import fr.inria.diagen.core.service.local.Service;

/**
 * A container for the list of available devices. For internal use by introspection libraries
 * 
 * @internal
 */
public class ClassList implements fr.inria.diagen.core.deploy.DeviceLister {

    public final Map<String, Class<? extends Service>> deviceList = new HashMap<String, Class<? extends Service>>();

    public ClassList() {
        deviceList.put("(/Device/Device/PhysicalDevice/Appliance/|/Device/Device/PhysicalDevice/Sensor/EnergyMeter/ElectricMeter/)Cooker/", fr.inria.phoenix.diasuite.framework.device.cooker.AbstractCooker.class);
        deviceList.put("/Device/Device/", fr.inria.phoenix.diasuite.framework.device.device.AbstractDevice.class);
        deviceList.put("/Device/Device/Android/", fr.inria.phoenix.diasuite.framework.device.android.AbstractAndroid.class);
        deviceList.put("/Device/Device/Fitbit/", fr.inria.phoenix.diasuite.framework.device.fitbit.AbstractFitbit.class);
        deviceList.put("/Device/Device/PhysicalDevice/", fr.inria.phoenix.diasuite.framework.device.physicaldevice.AbstractPhysicalDevice.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/", fr.inria.phoenix.diasuite.framework.device.appliance.AbstractAppliance.class);
        deviceList.put("/Device/Device/PhysicalDevice/Appliance/Light/", fr.inria.phoenix.diasuite.framework.device.light.AbstractLight.class);
        deviceList.put("/Device/Device/PhysicalDevice/Input/", fr.inria.phoenix.diasuite.framework.device.input.AbstractInput.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/", fr.inria.phoenix.diasuite.framework.device.sensor.AbstractSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/ContactSensor/", fr.inria.phoenix.diasuite.framework.device.contactsensor.AbstractContactSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/", fr.inria.phoenix.diasuite.framework.device.energymeter.AbstractEnergyMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/EnergyMeter/ElectricMeter/", fr.inria.phoenix.diasuite.framework.device.electricmeter.AbstractElectricMeter.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/LightSensor/", fr.inria.phoenix.diasuite.framework.device.lightsensor.AbstractLightSensor.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/MotionDetector/", fr.inria.phoenix.diasuite.framework.device.motiondetector.AbstractMotionDetector.class);
        deviceList.put("/Device/Device/PhysicalDevice/Sensor/TemperatureSensor/", fr.inria.phoenix.diasuite.framework.device.temperaturesensor.AbstractTemperatureSensor.class);
        deviceList.put("/Device/Device/Service/", fr.inria.phoenix.diasuite.framework.device.service.AbstractService.class);
        deviceList.put("/Device/Device/Service/ActivityReporter/", fr.inria.phoenix.diasuite.framework.device.activityreporter.AbstractActivityReporter.class);
        deviceList.put("/Device/Device/Service/Clock/", fr.inria.phoenix.diasuite.framework.device.clock.AbstractClock.class);
        deviceList.put("/Device/Device/Service/CommunicationService/", fr.inria.phoenix.diasuite.framework.device.communicationservice.AbstractCommunicationService.class);
        deviceList.put("/Device/Device/Service/CommunicationService/Messenger/", fr.inria.phoenix.diasuite.framework.device.messenger.AbstractMessenger.class);
        deviceList.put("/Device/Device/Service/CommunicationService/Messenger/Mailer/", fr.inria.phoenix.diasuite.framework.device.mailer.AbstractMailer.class);
        deviceList.put("/Device/Device/Service/CommunicationService/Messenger/SMSSender/", fr.inria.phoenix.diasuite.framework.device.smssender.AbstractSMSSender.class);
        deviceList.put("/Device/Device/Service/HomeService/", fr.inria.phoenix.diasuite.framework.device.homeservice.AbstractHomeService.class);
        deviceList.put("/Device/Device/Service/HomeService/Agenda/", fr.inria.phoenix.diasuite.framework.device.agenda.AbstractAgenda.class);
        deviceList.put("/Device/Device/Service/HomeService/Notifier/", fr.inria.phoenix.diasuite.framework.device.notifier.AbstractNotifier.class);
        deviceList.put("/Device/Device/Service/RoutineScheduler/", fr.inria.phoenix.diasuite.framework.device.routinescheduler.AbstractRoutineScheduler.class);
        deviceList.put("/Device/Device/Service/SoftwareSensor/", fr.inria.phoenix.diasuite.framework.device.softwaresensor.AbstractSoftwareSensor.class);
        deviceList.put("/Device/Device/Service/SoftwareSensor/ActivityNotifier/", fr.inria.phoenix.diasuite.framework.device.activitynotifier.AbstractActivityNotifier.class);
        deviceList.put("/Device/Device/Service/SoftwareSensor/InactivitySensor/", fr.inria.phoenix.diasuite.framework.device.inactivitysensor.AbstractInactivitySensor.class);
        deviceList.put("/Device/Device/Service/Storage/", fr.inria.phoenix.diasuite.framework.device.storage.AbstractStorage.class);
        deviceList.put("/Device/Device/Service/Timer/", fr.inria.phoenix.diasuite.framework.device.timer.AbstractTimer.class);
        deviceList.put("/Device/WhoCares/", fr.inria.phoenix.diasuite.framework.device.whocares.AbstractWhoCares.class);
    }

    public Map<String, Class<? extends Service>> getDeviceList() {
        return deviceList;
    }

}
