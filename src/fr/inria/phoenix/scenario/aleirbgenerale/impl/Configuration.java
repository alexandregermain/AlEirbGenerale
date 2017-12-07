package fr.inria.phoenix.scenario.aleirbgenerale.impl;

public class Configuration {

	//Nom des devices
	public static String timerUpdatingPassword = "TIMER_UPDATING_PASSWORD";
	public static String delayBeforeAlert = "DELAY_BEFORE_ALERT";
	public static String inactivitySensor = "inactivitySensor";
	public static String notifier = "notifier";
	
	//Configuration des timers
	public static int timeDelay = 2000;
	
	
	//Message
	public static final fr.inria.phoenix.diasuite.framework.datatype.contact.Contact Contact =
			new fr.inria.phoenix.diasuite.framework.datatype.contact.Contact("Name", "EmailAdresse", "055555555", "./icon.png", null);
	public static final java.lang.String Title = "Alarme déclanchée";
	public static final java.lang.String Message = "L'alarme a été activé";
	
	//Notification
	public static String idActived = "1";
	public static String titreActived = "INTRUSION";
	public static String messageActived = "Un intrus est dans votre maison";

	public static String idUpdatePassword = "2";
	public static String titreUpdatePassword = "CHANGEMENT MOT DE PASSE";
	public static String messageUpdatePassword = "Votre mot de passe a bien été changé";

}
