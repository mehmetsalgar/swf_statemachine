package org.salgar.swf_statemachine.findorders.transition.action;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObject;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.manager.OrderManager;

public class FindOrdersStartAction implements Action {

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		FindOrdersSMControlObject controlObject = (FindOrdersSMControlObject) stateMachine
				.getControlObject();

		FindOrdersSMControlObjectAccessor.processFindOrdersStart(controlObject,
				(StateMachine) event.getSource());

		OrderManager orderManager = (OrderManager) stateMachine
				.findObjects("orderManager");
		orderManager.findOrders((String) event.getPayload(), stateMachine);
	}

}
