package org.salgar.swf_statemachine.customersearch.transition.action;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.salgar.swf_statemachine.techdemo.listener.AbstractAsynchroneListener;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;

public class CustomerSearchRunningAction implements Action, Serializable {
	private static final long serialVersionUID = -181796739393959337L;

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		CustomerSearchCO customerSearchCO = (CustomerSearchCO) stateMachine
				.getControlObject();

		CustomerSearchStartEventPayload customerSearchStartEventPayload = (CustomerSearchStartEventPayload) event
				.getPayload();

		AbstractAsynchroneListener customerListener = customerSearchStartEventPayload
				.getCustomerListener();
		customerListener.setStateMachine(stateMachine);

		CustomerManager customerManager = customerSearchStartEventPayload
				.getCustomerManager();
		customerManager.findCustomer(customerSearchCO.getCustomerNumber(),
				customerListener);

		CustomerSearchSMControlObjectAccessor.getInstance()
				.processCustomerSearchRunningAction(
						(CustomerSearchSMControlObject) customerSearchCO,
						customerSearchStartEventPayload.getCustomerNumber());
	}
}
