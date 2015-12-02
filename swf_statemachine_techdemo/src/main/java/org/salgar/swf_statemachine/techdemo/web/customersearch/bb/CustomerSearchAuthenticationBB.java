package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchAuthenticationCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.customersearch.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

public class CustomerSearchAuthenticationBB {
	private StateMachine stateMachine;
	private boolean customerAuthenticated;

	public boolean isCustomerSearchAuthenticationPanelRendered() {
		CustomerSearchAuthenticationCO customerSearchAuthenticationCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchAuthenticationCO
				.getRenderCustomerSearchAuthentication();
	}

	public void customerGivesAuthentication() {
		Message message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked)
				.setHeader("authenticated", customerAuthenticated).build();
		
		stateMachine.sendEvent(message);
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public boolean isCustomerAuthenticated() {
		CustomerSearchAuthenticationCO customerSearchAuthenticationCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);

		return customerSearchAuthenticationCO.getCustomerAuthenticated();
	}

	public void setCustomerAuthenticated(boolean customerAuthenticated) {
		this.customerAuthenticated = customerAuthenticated;
	}
}
