package org.salgar.swf_statemachine.impl.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextContainer implements ApplicationContextAware {
	private static ApplicationContextContainer instance;	
	private ApplicationContext applicationContext;

	private ApplicationContextContainer() {		
	}
	
	public static ApplicationContextContainer getInstance() {
		if(instance == null) {
			instance = new ApplicationContextContainer();
		}
		return instance;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;		
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
