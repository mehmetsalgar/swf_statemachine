package org.salgar.swf_statemachine.findcustomer.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.statemachine.domain.StateMachine;

public class FindCustomerSMControlObjectAccessor {
	public static void processFindCustomerStart(ControlObject controlObject,
			StateMachine master) {
		((FindCustomerSMControlObject) controlObject).masterStateMachine = master;
	}
}
