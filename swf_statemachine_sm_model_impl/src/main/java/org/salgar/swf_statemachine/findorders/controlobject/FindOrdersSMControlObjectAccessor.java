package org.salgar.swf_statemachine.findorders.controlobject;

import java.util.List;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.techdemo.domain.Order;

public class FindOrdersSMControlObjectAccessor {
	public static void processFindOrdersStart(ControlObject controlObject,
			StateMachine masterStateMachine) {
		((FindOrdersSMControlObject) controlObject).masterStateMachine = masterStateMachine;
	}
	
	public static List<Order> getOrders(ControlObject controlObject) {
		return ((FindOrdersSMControlObject) controlObject).orders;
	}
}
