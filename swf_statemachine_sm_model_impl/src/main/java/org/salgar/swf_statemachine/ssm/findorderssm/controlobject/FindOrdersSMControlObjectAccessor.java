package org.salgar.swf_statemachine.ssm.findorderssm.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.statemachine.StateMachine;

import java.util.List;

public class FindOrdersSMControlObjectAccessor {
	public static void processFindOrdersStart(ControlObject controlObject,
			StateMachine masterStateMachine) {
		((AbstractFindOrdersSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}
	
	public static List<Order> getOrders(ControlObject controlObject) {
		return ((FindOrdersSMControlObject) controlObject).getOrders();
	}

	public static AbstractFindOrdersSMControlObject getControlObject(StateMachine<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> stateMachine) {
		return 	(AbstractFindOrdersSMControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}

	public static void processOrdersFound(AbstractFindOrdersSMControlObject contolObject, List<Order> orders) {
		contolObject.orders= orders;
	}
}
