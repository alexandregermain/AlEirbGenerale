package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.AbstractInsideContext;
import fr.inria.phoenix.diasuite.framework.device.inactivitysensor.InactivityLevelFromInactivitySensor;

public class InsideContext extends AbstractInsideContext{

	public InsideContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected InsideContextValuePublishable onInactivityLevelFromInactivitySensor(
			InactivityLevelFromInactivitySensor inactivityLevelFromInactivitySensor,
			DiscoverForInactivityLevelFromInactivitySensor discover) {
		// TODO Auto-generated method stub
		return null;
	}

}
