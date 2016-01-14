package org.salgar.swf_statemachine.ssm.findcustomersm.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.springframework.statemachine.StateMachine;

public class FindCustomerSMControlObjectAccessor {
	public static void processFindCustomerStart(ControlObject controlObject,
			StateMachine masterStateMachine) {
		((AbstractFindCustomerSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}

	public static AbstractFindCustomerSMControlObject getControlObject(StateMachine<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> stateMachine) {
		return 	(AbstractFindCustomerSMControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}
}
