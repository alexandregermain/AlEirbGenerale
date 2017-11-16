package fr.inria.phoenix.diasuite.framework.controller.aleirbgeneralecontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


/**
 * AlEirbGenerale controller

<pre>
controller AlEirbGeneraleController {
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractAlEirbGeneraleController extends Service {
    
    public AbstractAlEirbGeneraleController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/AlEirbGeneraleController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    // End of interaction contract implementation
}
