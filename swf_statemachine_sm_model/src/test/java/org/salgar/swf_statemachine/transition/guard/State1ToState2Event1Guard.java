package org.salgar.swf_statemachine.transition.guard;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.Guard;

public class State1ToState2Event1Guard implements Guard {

	public Boolean evaluateGuard(Event event, AbstractStateMachine stateMachine) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

}
