package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchAuthenticationCO;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;

public class CustomerSearchAuthenticationBB {
	private StateMachine stateMachine;
	private boolean customerAuthenticated;

	public boolean isCustomerSearchAuthenticationPanelRendered() {
		CustomerSearchAuthenticationCO customerSearchAuthenticationCO = (CustomerSearchAuthenticationCO) stateMachine
				.getControlObject();
		return customerSearchAuthenticationCO
				.getRenderCustomerSearchAuthentication();
	}

	public void customerGivesAuthentication() {
		Event event = new Event();
		event.setEventType(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked);
		event.setPayload(customerAuthenticated);
		
		stateMachine.handleEvent(event);
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public boolean isCustomerAuthenticated() {
		CustomerSearchAuthenticationCO customerSearchAuthenticationCO = (CustomerSearchAuthenticationCO) stateMachine
				.getControlObject();
		return customerSearchAuthenticationCO.getCustomerAuthenticated();
	}

	public void setCustomerAuthenticated(boolean customerAuthenticated) {
		this.customerAuthenticated = customerAuthenticated;
	}
}
