package org.salgar.swf_statemachine.impl.guard;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.Guard;

public class DefaultGuardImpl implements Guard, Serializable {
	private static final long serialVersionUID = -4349277654239072103L;
	private final static Logger log = Logger.getLogger(DefaultGuardImpl.class);
	
	public Boolean evaluateGuard(Event event, AbstractStateMachine stateMachine) {
		if (log.isDebugEnabled()) {
			log.debug("Default guard returning always true....!");
		}
		
		return Boolean.TRUE;
	}
}
