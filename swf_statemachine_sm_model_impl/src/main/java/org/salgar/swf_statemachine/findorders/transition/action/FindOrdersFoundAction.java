package org.salgar.swf_statemachine.findorders.transition.action;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObject;

public class FindOrdersFoundAction implements Action, Serializable {
	private static final long serialVersionUID = -236662345793959337L;
	
	public void processAction(Event event, AbstractStateMachine stateMachine) {
		StateMachine masterStateMachine = ((FindOrdersSMControlObject) stateMachine
				.getControlObject()).getMasterStateMachine();

		if (CustomerSearchSM_StateEnumerationImpl.ORDERS_LOADING
				.equals(masterStateMachine.giveActualState().getName())) {
			Event ordersFoundEvent = new Event();
			ordersFoundEvent
					.setEventType(CustomerSearchSM_EventEnumerationImpl.onOrdersLoaded);
			ordersFoundEvent.setPayload(event.getPayload());
			masterStateMachine.handleEvent(ordersFoundEvent);
		}
	}
}
