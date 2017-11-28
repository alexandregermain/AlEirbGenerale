package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.insidecontext.AbstractInsideContext;
import fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction;
import fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType;
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
		Float insideContext = inactivityLevelFromInactivitySensor.value();
		
		// Last Interaction
		String id = "1";
		InactivitySensorProxyForInactivityLevelFromInactivitySensor InactivitySensor = discover.inactivitySensors().whereId(id).anyOne();
		Interaction lastInteraction = InactivitySensor.getLastInteraction();
		
		if(lastInteraction.equals(InteractionType.CLOSURE) && insideContext == 0){
			return new InsideContextValuePublishable(true, true);
		}
		else if(lastInteraction.equals(InteractionType.OPENNING) && insideContext >= 1){
			return new InsideContextValuePublishable(false, true);
		}		
		
		return new InsideContextValuePublishable(false, false);
	}

}
