package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.changingpassword.AbstractChangingPassword;
import fr.inria.phoenix.diasuite.framework.device.appliance.OnFromAppliance;

public class ChangingPassword extends AbstractChangingPassword{

	public ChangingPassword(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean onOnFromAppliance(OnFromAppliance onFromAppliance, DiscoverForOnFromAppliance discover) {
		// TODO Auto-generated method stub
		return null;
	}

}
