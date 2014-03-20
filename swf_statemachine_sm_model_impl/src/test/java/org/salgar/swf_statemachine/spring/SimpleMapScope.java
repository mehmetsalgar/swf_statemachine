package org.salgar.swf_statemachine.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;

public class  SimpleMapScope implements org.springframework.beans.factory.config.Scope {
	private final Map<String, Object> objectMap = new HashMap<String , Object>();
	
	/**public Object resolveContextualObject(String key) {
		return null;
	}*/
	
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object object = objectMap.get(name);
		
	    if (null == object) {		
	      object = objectFactory.getObject();		
	      this.objectMap.put(name, object);		
	    }
	
	    return object;
	}

	public Object remove(String name) {
		return null;
	}

	public void registerDestructionCallback(String name, Runnable callback) {

	}

	public String getConversationId() {
		return null;
	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
