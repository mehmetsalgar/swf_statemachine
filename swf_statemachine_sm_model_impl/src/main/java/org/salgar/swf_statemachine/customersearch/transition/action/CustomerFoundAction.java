package org.salgar.swf_statemachine.customersearch.transition.action;

import java.io.Serializable;

import org.salgar.comet.CometServiceLocator;
import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.StateMachineEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findorderssm.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;

public class CustomerFoundAction implements Action, Serializable {
	private static final long serialVersionUID = -7004212543590335419L;

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) stateMachine
				.getControlObject();

		AbstractStateMachine findOrdersSM = (AbstractStateMachine) stateMachine
				.findObjects(StateMachineEnumerationImpl.FindOrdersSM.name());

		CustomerSearchSMControlObjectAccessor.processCustomerFoundAction(
				controlObject, (Customer) event.getPayload(), findOrdersSM);

		Event findOrdersSMStartEvent = new Event();
		findOrdersSMStartEvent
				.setEventType(FindOrdersSM_EventEnumerationImpl.onOrderSearchRunning);
		findOrdersSMStartEvent.setPayload(controlObject.getCustomer()
				.getCustomerNumber());
		findOrdersSMStartEvent.setSource(stateMachine);

		findOrdersSM.resetStateMachine();
		findOrdersSM.dispatch(findOrdersSMStartEvent);

		CometServiceLocator.getInstance().pushMessage("customer found");
	}
}
