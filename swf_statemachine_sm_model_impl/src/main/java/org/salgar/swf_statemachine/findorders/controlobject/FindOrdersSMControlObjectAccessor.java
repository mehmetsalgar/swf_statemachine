package org.salgar.swf_statemachine.findorders.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.enumeration.event.findorderssm.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.statemachine.StateMachine;

import java.util.List;

public class FindOrdersSMControlObjectAccessor {
	public static void processFindOrdersStart(ControlObject controlObject,
			Object masterStateMachine) {
		((FindOrdersSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}
	
	public static List<Order> getOrders(ControlObject controlObject) {
		return ((FindOrdersSMControlObject) controlObject).orders;
	}

	public static AbstractFindOrdersControlObject getControlObject(StateMachine<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> stateMachine) {
		return 	(AbstractFindOrdersControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}

	public static void processOrdersFound(AbstractFindOrdersControlObject contolObject, List<Order> orders) {
		contolObject.orders = orders;
	}
}
