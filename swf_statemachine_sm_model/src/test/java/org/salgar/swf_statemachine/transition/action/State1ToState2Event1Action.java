package org.salgar.swf_statemachine.transition.action;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.reference_model.controlobject.STATEMACHINE_1ControlObject;
import org.salgar.swf_statemachine.reference_model.controlobject.STATEMACHINE_1ControlObjectAccessor;

public class State1ToState2Event1Action implements Action {

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		STATEMACHINE_1ControlObject controlObject = (STATEMACHINE_1ControlObject) stateMachine
				.getControlObjects().get(
						stateMachine.getName().getStateMachineName().toUpperCase()
								+ "ControlObject");

		STATEMACHINE_1ControlObjectAccessor.getInstance().placeCustomerNumber(
				controlObject, (String) event.getPayload());

	}

}
