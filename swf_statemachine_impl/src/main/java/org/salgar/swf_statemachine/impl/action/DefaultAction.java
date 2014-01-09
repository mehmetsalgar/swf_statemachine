package org.salgar.swf_statemachine.impl.action;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;

public class DefaultAction implements Action, Serializable {
	private static final long serialVersionUID = 2508927839819577703L;
	private static final Logger log = Logger.getLogger(DefaultAction.class);

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		if (log.isDebugEnabled()) {
			log.debug("We are executing the default Action!");
		}
	}
}
