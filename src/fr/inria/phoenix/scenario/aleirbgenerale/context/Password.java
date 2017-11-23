package fr.inria.phoenix.scenario.aleirbgenerale.context;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.password.AbstractPassword;
import fr.inria.phoenix.diasuite.framework.device.appliance.OnFromAppliance;

public class Password extends AbstractPassword {


	public ListIterator<String> passwordIter =  ChangingPassword.password.listIterator();
	public Password(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
	}

	@Override
	protected PasswordValuePublishable onOnFromAppliance(OnFromAppliance onFromAppliance, DiscoverForOnFromAppliance discover) {
		if (passwordIter.hasNext()) {
			if (passwordIter.next().equals(onFromAppliance.sender().id())) {
				if(!passwordIter.hasNext()) {
					return new PasswordValuePublishable(true,true);
				}
			}else {
				passwordIter =  ChangingPassword.password.listIterator();
			}
		}else {
			passwordIter =  ChangingPassword.password.listIterator();
		}
		return null;
	}

}
