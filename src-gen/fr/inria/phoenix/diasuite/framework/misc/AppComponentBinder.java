package fr.inria.phoenix.diasuite.framework.misc;

import fr.inria.diagen.core.deploy.AbstractDeploy;

import fr.inria.phoenix.diasuite.framework.context.aleirbgeneralecontext.AbstractAlEirbGeneraleContext;

import fr.inria.phoenix.diasuite.framework.controller.aleirbgeneralecontroller.AbstractAlEirbGeneraleController;

/**
 * This class should be implemented to bind the implementation of the various components
 */
public abstract class AppComponentBinder extends AbstractDeploy {

    // Context instances
    private AbstractAlEirbGeneraleContext alEirbGeneraleContextInstance = null;

    // Controller instances
    private AbstractAlEirbGeneraleController alEirbGeneraleControllerInstance = null;
    
    @Override
    public void deployAll() {
        // Initialization of contexts
        if (alEirbGeneraleContextInstance == null)
            alEirbGeneraleContextInstance = getInstance(getAlEirbGeneraleContextClass());
        // Intialization of controllers
        if (alEirbGeneraleControllerInstance == null)
            alEirbGeneraleControllerInstance = getInstance(getAlEirbGeneraleControllerClass());
        // Deploying contexts
        deploy(alEirbGeneraleContextInstance);
        // Deploying controllers
        deploy(alEirbGeneraleControllerInstance);
    }
    
    @Override
    public void undeployAll() {
        // Undeploying contexts
        undeploy(alEirbGeneraleContextInstance);
        // Undeploying controllers
        undeploy(alEirbGeneraleControllerInstance);
    }
    
    // Abstract binding methods for contexts
    /**
     * Overrides this method to provide the implementation class of the <code>AlEirbGeneraleContext</code> context
    <p>
    AlEirbGenerale context
    
    <pre>
    context AlEirbGeneraleContext as Boolean {
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractAlEirbGeneraleContext} that implements the <code>AlEirbGeneraleContext</code> context
     */
    public abstract Class<? extends AbstractAlEirbGeneraleContext> getAlEirbGeneraleContextClass();
    
    // End of abstract binding methods for contexts
    
    // Abstract binding methods for controllers
    /**
     * Overrides this method to provide the implementation class of the <code>AlEirbGeneraleController</code> controller
    <p>
    AlEirbGenerale controller
    
    <pre>
    controller AlEirbGeneraleController {
     * }
    </pre>
    @return a class object of a derivation of {@link AbstractAlEirbGeneraleController} that implements the <code>AlEirbGeneraleController</code> controller
     */
    public abstract Class<? extends AbstractAlEirbGeneraleController> getAlEirbGeneraleControllerClass();
    
    // End of abstract binding methods for controllers
}
