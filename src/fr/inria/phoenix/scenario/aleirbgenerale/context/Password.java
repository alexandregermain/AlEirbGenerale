package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.password.AbstractPassword;
import fr.inria.phoenix.diasuite.framework.device.appliance.OnFromAppliance;

public class Password extends AbstractPassword {

	public Password(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean onOnFromAppliance(OnFromAppliance onFromAppliance, DiscoverForOnFromAppliance discover) {
		// TODO Auto-generated method stub
		return null;
	}

}
