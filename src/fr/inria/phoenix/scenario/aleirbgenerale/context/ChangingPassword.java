package fr.inria.phoenix.scenario.aleirbgenerale.context;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.AbstractChangingPassword;
import fr.inria.phoenix.diasuite.framework.device.appliance.OnFromAppliance;

public class ChangingPassword extends AbstractChangingPassword{

	public int codeChangementMDP = 0; 
	public long timeChangementMDP = System.currentTimeMillis();
	public static List<String> password = new ArrayList<String>();
	public ListIterator<String> passwordIterator;
	
	public int state = 0;//0 etat initial/1 Réinitiolisation validé par le pwd reinitialisation/ 2 
	public ChangingPassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		//TODO Auto-generated constructor stub
	}

	@Override
	protected ChangingPasswordValuePublishable onOnFromAppliance(OnFromAppliance onFromAppliance, DiscoverForOnFromAppliance discover) {
		//Récuperation des informations sur les capteurs appliances
		
		 if (onFromAppliance.sender().id().equals("realisation")){//id realisation correspond a lid du tiroir realisation
			 long now = System.currentTimeMillis();
			 long diffDate = timeChangementMDP - now;
			 if(diffDate>0 && diffDate < 30000) { // 30secondes
				 codeChangementMDP++;
			 }else {
				 timeChangementMDP = now;
				 codeChangementMDP = 1;
			 }
			 if (codeChangementMDP == 5) {
				 state = 1;
			 }
			 else if (codeChangementMDP == 7 && !password.isEmpty() ){
				 state = 2;
				 passwordIterator = password.listIterator();
			 }
			 else if (codeChangementMDP == 8 ){
				 if(!passwordIterator.hasNext()){
					 return new ChangingPasswordValuePublishable("Success",true);
				 }else {
					 return new ChangingPasswordValuePublishable("PasswordsDifferent",true);
				 }
			 }else {
				 return new ChangingPasswordValuePublishable("ErrorReinitialisation",true);
			 }
		 }else if(state == 1){
			 password.add(onFromAppliance.sender().id());
		 }else if(state == 2) {
			 if (passwordIterator.hasNext()) {
				 if (!passwordIterator.next().equals(onFromAppliance.sender().id())) {
					 return new ChangingPasswordValuePublishable("PasswordsDifferent",true);
				 }
			 }else {
				 return new ChangingPasswordValuePublishable("PasswordsDifferent",true);
			 }
		 }
		 return null;
	}
}
