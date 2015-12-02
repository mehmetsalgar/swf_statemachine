package org.salgar.swf_statemachine.findcustomer.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.findcustomer.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.findcustomer.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.springframework.statemachine.StateMachine;

public class FindCustomerSMControlObjectAccessor {
	public static void processFindCustomerStart(ControlObject controlObject,
			Object masterStateMachine) {
		((FindCustomerSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}

	public static AbstractFindCustomerControlObject getControlObject(StateMachine<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> stateMachine) {
		return 	(AbstractFindCustomerControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}
}
