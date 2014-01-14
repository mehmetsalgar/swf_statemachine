package org.salgar.comet;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

/**
 * ServiceLocator to locate Comet broadcaster.
 * 
 * @author salgar
 * 
 */
public class CometServiceLocator {
	private volatile static CometServiceLocator instance;
	private PushContext pushContext;

	private CometServiceLocator() {		
	}
	
	private CometServiceLocator(PushContext pushContext) {
		this.pushContext = pushContext;
	}

	public static CometServiceLocator getInstance() {
		if (instance == null) {
			instance = createInternalInstance();
		}
		return instance;
	}

	private static synchronized CometServiceLocator createInternalInstance() {
		if (instance == null) {
			PushContext pushContext = PushContextFactory.getDefault()
					.getPushContext();
			instance = new CometServiceLocator(pushContext);
		}
		return instance;
	}
	
	public void pushMessage(String message) {
		this.pushContext.push("/customer_search_result", message);
	}
}
