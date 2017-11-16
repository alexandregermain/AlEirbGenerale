package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.diasuite.framework.controller.aleirbgeneralecontroller.AbstractAlEirbGeneraleController;
import fr.inria.phoenix.diasuite.framework.context.aleirbgeneralecontext.AbstractAlEirbGeneraleContext;

/**
 * Use this class to test your DiaSuite application.
 *
 * <p>
 * Here is n example of usage to test an application that should trigger an action <code>action</code> on a device <code>TestDevice</code>
 * when it receive a source "src" from this device:
 * <pre>
 * ...
 * import static fr.inria.phoenix.diasuite.framework.mocks.Mock.*;
 * ...
 *    @Before
 *    public void setUp() throws Exception {
 *        underTest(MyAppComponentBinder.class);
 *    }
 *    
 *    @After
 *    public void tearDown() {
 *        shutdown();
 *    }
 *    
 *    @Test
 *    public void testMyApplication() {
 *        assertTrue(mockTestDevice().src("hehe").expectAction());
 *    }
 * ...
 */
@SuppressWarnings("all")
public final class Mock extends AppComponentBinder {
    
    /**
     * The time out, in milliseconds, before considering an action will never happens.
     * It should be changed if the application has long computations.
     */
    public static long TIMEOUT = 1000;
    
    private static Mock mocker;
    
    /**
     * Put a class under test
     * @param binder The application class
     * @return The mocking factory
     */
    public static Mock underTest(Class<? extends AppComponentBinder> binder) throws Exception {
        mocker = new Mock(binder);
        return mocker;
    }
    
    /**
     * Tear-down the device mocking framework
     */
    public static void shutdown() {
        if(mocker != null)
            mocker.undeployAll();
        mocker = null;
    }
    
    private AppComponentBinder delegate;
    private Mock(Class<? extends AppComponentBinder> binder) throws Exception {
        delegate = binder.newInstance();
        // Starts the framework
        deployAll();
    }
    
    @SuppressWarnings("unchecked")
    public ServiceConfiguration getServiceConfiguration(String name) {
        try {
            Class<? extends ServiceConfiguration> clazz = (Class<? extends ServiceConfiguration>) Class.forName("fr.inria.diagen.commlayer.local.LocalServiceConfiguration");
            java.lang.reflect.Constructor<? extends ServiceConfiguration> constructor = clazz.getConstructor(String.class);
            return constructor.newInstance(name);
        } catch (Exception ex) {
            fr.inria.diagen.log.DiaLog.critical("Unabled to initialize local communication layer. Please make sure correct libraries are in the classpath", ex);
            System.exit(-1);
            return null;
        }
    }
    
    private String randomId() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 10; i++)
            result.append(Integer.toString((int) (Math.random() * 10)));
        return result.toString();
    }
    
    // Delegation part
    public Class<? extends AbstractAlEirbGeneraleController> getAlEirbGeneraleControllerClass() {
        return delegate.getAlEirbGeneraleControllerClass();
    }
    public Class<? extends AbstractAlEirbGeneraleContext> getAlEirbGeneraleContextClass() {
        return delegate.getAlEirbGeneraleContextClass();
    }
    
    // Mocks constructor for all devices
}
