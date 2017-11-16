package fr.inria.phoenix.diasuite.framework.misc;

import java.util.HashMap;
import java.util.Map;

import fr.inria.diagen.core.service.local.Service;

/**
 * A container for the list of available devices. For internal use by introspection libraries
 * 
 * @internal
 */
public class ClassList implements fr.inria.diagen.core.deploy.DeviceLister {

    public final Map<String, Class<? extends Service>> deviceList = new HashMap<String, Class<? extends Service>>();

    public ClassList() {
    }

    public Map<String, Class<? extends Service>> getDeviceList() {
        return deviceList;
    }

}
