package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.AbstractInsideContext;
import fr.inria.phoenix.diasuite.framework.context.isinside.AbstractIsInside;
import fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction;
import fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType;
import fr.inria.phoenix.diasuite.framework.device.inactivitysensor.InactivityLevelFromInactivitySensor;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;

public class IsInside extends AbstractIsInside{

	public IsInside(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IsInsideValuePublishable onInactivityLevelFromInactivitySensor(
			InactivityLevelFromInactivitySensor inactivityLevelFromInactivitySensor,
			DiscoverForInactivityLevelFromInactivitySensor discover) {

		Float inactivityLevel = inactivityLevelFromInactivitySensor.value();
		InactivitySensorProxyForInactivityLevelFromInactivitySensor InactivitySensor = discover.inactivitySensors().whereId(Configuration.inactivitySensor).anyOne();
		Interaction lastInteraction = InactivitySensor.getLastInteraction();
		
		if(lastInteraction.getActionType().equals(InteractionType.CLOSURE) && inactivityLevel >= 1){
			return new IsInsideValuePublishable(true, true);
		}
		else if(lastInteraction.equals(InteractionType.OPENNING) && inactivityLevel < 1){
			return new IsInsideValuePublishable(false, true);
		}		
		return new IsInsideValuePublishable(false, false);
	}

}
