package org.salgar.swf_statemachine.findcustomer.transition.action;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.findcustomer.controlobject.FindCustomerSMControlObject;

public class FindCustomerCustomerFoundAction implements Action {

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		Event customerFoundEvent = new Event();
		customerFoundEvent
				.setEventType(CustomerSearchSM_EventEnumerationImpl.onCustomerFound);
		customerFoundEvent.setPayload(event.getPayload());

		((FindCustomerSMControlObject) stateMachine.getControlObject())
				.getMasterStateMachine().handleEvent(customerFoundEvent);
	}
}
