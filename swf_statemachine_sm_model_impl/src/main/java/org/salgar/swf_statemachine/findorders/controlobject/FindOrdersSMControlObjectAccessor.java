package org.salgar.swf_statemachine.findorders.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.statemachine.domain.StateMachine;

public class FindOrdersSMControlObjectAccessor {
	public static void processFindOrdersStart(ControlObject controlObject,
			StateMachine masterStateMachine) {
		((FindOrdersSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}
}
