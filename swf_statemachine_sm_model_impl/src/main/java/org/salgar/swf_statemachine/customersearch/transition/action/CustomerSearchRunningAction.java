package org.salgar.swf_statemachine.customersearch.transition.action;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.StateMachineEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;

public class CustomerSearchRunningAction implements Action, Serializable {
	private static final long serialVersionUID = -181796739393959337L;

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		CustomerSearchCO customerSearchCO = (CustomerSearchCO) stateMachine
				.getControlObject();

		CustomerSearchStartEventPayload customerSearchStartEventPayload = (CustomerSearchStartEventPayload) event
				.getPayload();

		Event findCustomerSmEvent = new Event();
		findCustomerSmEvent
				.setEventType(FindCustomerSM_EventEnumerationImpl.onStartSearch);
		findCustomerSmEvent.setPayload(customerSearchCO.getCustomerNumber());
		findCustomerSmEvent.setSource(stateMachine);

		AbstractStateMachine findCustomerStateMachine = (AbstractStateMachine) stateMachine
				.findObjects(StateMachineEnumerationImpl.FindCustomerSM
						.getStateMachineName());
		findCustomerStateMachine.resetStateMachine();
		findCustomerStateMachine.dispatch(findCustomerSmEvent);

		CustomerSearchSMControlObjectAccessor
				.processCustomerSearchRunningAction(
						(CustomerSearchSMControlObject) customerSearchCO,
						customerSearchStartEventPayload.getCustomerNumber());
	}
}
