package org.salgar.swf_statemachine.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class SimpleMapScope implements Scope {
	private final Map<String, Object> objectMap = new HashMap<String , Object>();

	public Object get(String name, ObjectFactory objectFactory) {
		Object object = objectMap.get(name);
		
	    if (null == object) {		
	      object = objectFactory.getObject();		
	      this.objectMap.put(name, object);		
	    }
	
	    return object;
	}

	public Object remove(String name) {
		return this.objectMap.remove(name);
	}

	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub

	}

	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
