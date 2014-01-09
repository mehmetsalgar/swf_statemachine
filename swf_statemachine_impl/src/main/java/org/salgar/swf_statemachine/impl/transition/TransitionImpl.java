package org.salgar.swf_statemachine.impl.transition;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.statemachine.domain.Transition;

public class TransitionImpl extends Transition {
	private static final long serialVersionUID = -2272250606661593122L;

	@Override
	public boolean evaluateGuard(Event event, StateMachine stateMachine) {		
		return this.getGuard().evaluateGuard(event, (AbstractStateMachine) stateMachine);
	}

	@Override
	public void processAction(Event event, StateMachine stateMachine) {
		this.getAction().processAction(event, (AbstractStateMachine) stateMachine);
	}
}
