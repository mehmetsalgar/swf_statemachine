package org.salgar.comet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.atmosphere.cpr.AtmosphereServlet;

/**
 * Intial idea for the concept comes from this thread in Primefaces forum.
 * 
 * http://primefaces.prime.com.tr/forum/viewtopic.php?f=3&t=1480
 * @author salgar
 *
 */
public class CometServlet extends AtmosphereServlet {
    private static final long serialVersionUID = 7457627547476L;
    public static final String BROADCASTER = "BROADCASTER";

    /**
     * Servlet initializer would create an instance of the broadcaster and
     * places in the ServiceLocator so the clients can access it.
     * 
     * Servlet in web.xml as single instance configured so normally for the whole
     * application there can be only one instance of the broadcaster.
     */
    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
//        DefaultBroadcaster defaultBroadcaster = new DefaultBroadcaster();
//        atmosphereHandlers.put(CometContext.CHANNEL_PATH + "*", new AtmosphereHandlerWrapper(
//                new PrimeFacesCometHandler(), defaultBroadcaster));
//        sc.getServletContext().setAttribute(BROADCASTER, defaultBroadcaster);
//        CometServiceLocator.getInstance().setBroadcaster(defaultBroadcaster);
    }
}
