package fr.inria.phoenix.scenario.aleirbgenerale.context;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.elapsedtime.ElapsedTimeValue;
import fr.inria.phoenix.diasuite.framework.context.updatepassword.AbstractUpdatePassword;
import fr.inria.phoenix.diasuite.framework.datatype.aleirbtimer.AlEirbTimer;
import fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating;
import fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep;
import fr.inria.phoenix.diasuite.framework.device.contactsensor.ContactFromContactSensor;
import fr.inria.phoenix.diasuite.framework.device.light.OnFromLight;

public class UpdatePassword extends AbstractUpdatePassword{
	public static PasswordUpdating passwordData = new PasswordUpdating();
	public int codeChangementMDP = 0; 
	public long timeChangementMDP = System.currentTimeMillis();
	public static List<String> ActualPassword = new ArrayList<String>();
	public List<String> password = new ArrayList<String>();
	public ListIterator<String> passwordIterator;
	
	private void resetVariables() {
		 password.clear();
		 codeChangementMDP = 0;
		 passwordIterator = password.listIterator();
	}
	
	public UpdatePassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected UpdatePasswordValuePublishable onContactFromContactSensor(
			ContactFromContactSensor contactFromContactSensor) {
	
		 if (contactFromContactSensor.sender().id().equals("realisation")){ //id realisation correspond a lid du tiroir realisation
			 	codeChangementMDP++;
			 	System.out.println(codeChangementMDP);
			 if(codeChangementMDP == 1) {
				 passwordData.setStep(UpdatingStep.INIT_UPDATING);
				 return new UpdatePasswordValuePublishable(passwordData,true);
			 }
			 if (codeChangementMDP<5) {
			 }else if (codeChangementMDP == 5) {
				 passwordData.setStep(UpdatingStep.VALID_PASS_1);
			 }
			 else if (codeChangementMDP == 6 && !password.isEmpty() ){
				 passwordData.setStep(UpdatingStep.VALID_PASS_2);
				 passwordIterator = password.listIterator();
			 }else if (codeChangementMDP == 7){
			 }
			 else if (codeChangementMDP == 8 ){
				 if(!passwordIterator.hasNext()){
					 passwordData.setStep(UpdatingStep.END_UPDATING);
					 passwordData.setPassword(password);
					 ActualPassword = password;
					 resetVariables();
					 return new UpdatePasswordValuePublishable(passwordData,true);
				 }else {
					 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
					 resetVariables();
					 return new UpdatePasswordValuePublishable(passwordData,true);
				 }
			 }else {
				 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
				 resetVariables();
				 return new UpdatePasswordValuePublishable(passwordData,true);
			 }
		 }else if(passwordData.getStep().compareTo(UpdatingStep.VALID_PASS_1)== 0 && codeChangementMDP == 5 ){
			 password.add(contactFromContactSensor.sender().id());
		 }else if(passwordData.getStep().compareTo(UpdatingStep.VALID_PASS_2)==0 && codeChangementMDP == 7){
			 if (passwordIterator.hasNext()) {
				 if (!passwordIterator.next().equals(contactFromContactSensor.sender().id())) {
					 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
					 resetVariables();
					 return new UpdatePasswordValuePublishable(passwordData,true);
				 }
			 }else {
				 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
				 resetVariables();
				 return new UpdatePasswordValuePublishable(passwordData,true);
			 }
		 }else {
			 passwordData.setStep(UpdatingStep.CANCEL_UPDATING);
			 resetVariables();
			 return new UpdatePasswordValuePublishable(passwordData,true);
		 }
		return null;
	}

	@Override
	protected UpdatePasswordValuePublishable onOnFromLight(OnFromLight onFromLight) {
		if(passwordData.getStep().compareTo(UpdatingStep.VALID_PASS_1) == 0 && codeChangementMDP == 5 ){
			 password.add(onFromLight.sender().id());
		 }else if(passwordData.getStep().compareTo(UpdatingStep.VALID_PASS_2)==0 && codeChangementMDP == 7 ){
			 if (passwordIterator.hasNext()) {
				 if (!passwordIterator.next().equals(onFromLight.sender().id())) {
					 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
					 resetVariables();
					 return new UpdatePasswordValuePublishable(passwordData,true);
				 }
			 }else {
				 passwordData.setStep(UpdatingStep.WRONG_PASSWORD);
				 resetVariables();
				 return new UpdatePasswordValuePublishable(passwordData,true);
			 }
		 }else {
			 passwordData.setStep(UpdatingStep.CANCEL_UPDATING);
			 resetVariables();
			 return new UpdatePasswordValuePublishable(passwordData,true);
		 }
		return null;
		
	}

	@Override
	protected UpdatePasswordValuePublishable onElapsedTime(ElapsedTimeValue elapsedTimeValue) {
		if (elapsedTimeValue.equals(AlEirbTimer.TIMER_UPDATING_PASSWORD)) {
			 passwordData.setStep(UpdatingStep.CANCEL_UPDATING);
			 resetVariables();
			 return new UpdatePasswordValuePublishable(passwordData,true);
		}
		return null;
	}

}
