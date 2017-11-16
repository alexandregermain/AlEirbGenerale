package fr.inria.phoenix.diasuite.framework.context.aleirbgeneralecontext;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


/**
 * AlEirbGenerale context

<pre>
context AlEirbGeneraleContext as Boolean {
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractAlEirbGeneraleContext extends Service {
    
    public AbstractAlEirbGeneraleContext(ServiceConfiguration serviceConfiguration) {
        super("/Context/AlEirbGeneraleContext/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("alEirbGeneraleContext")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.Boolean contextValue;
    
    private void setAlEirbGeneraleContext(java.lang.Boolean newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "alEirbGeneraleContext", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.Boolean getLastValue() {
        return contextValue;
    }
    // End of code relative to the return value of the context
    
    // Interaction contract implementation
    // End of interaction contract implementation
}
