package org.salgar.comet;

import org.atmosphere.cpr.Broadcaster;

/**
 * ServiceLocator to locate Comet broadcaster.
 * 
 * @author salgar
 *
 */
public class CometServiceLocator {
    private volatile static CometServiceLocator instance;    
    private Broadcaster broadcaster;
    
    private CometServiceLocator() {        
    }
    
    public static CometServiceLocator getInstance() {
        if (instance == null) {
            instance = createInternalInstance();
        }
        return instance;
    }
    
    private static synchronized CometServiceLocator createInternalInstance() {
        if (instance == null) {
            return new CometServiceLocator();
        }
        return instance;
    }
    
    void setBroadcaster(Broadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    public Broadcaster getBroadcaster() {
        return broadcaster;
    }
}
