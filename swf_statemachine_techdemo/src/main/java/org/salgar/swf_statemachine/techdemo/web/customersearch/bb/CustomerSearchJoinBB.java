package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchJoinCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

public class CustomerSearchJoinBB {
	private StateMachine stateMachine;
	private boolean customerJoined;

	public boolean isCustomerSearchJoinPanelRendered() {
		CustomerSearchJoinCO customerSearchJoinCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchJoinCO.getRenderCustomerJoin();
	}

	public void customerJoined() {
		Message<CustomerSearchSM_EventEnumerationImpl> message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked)
				.setHeader("joined", this.customerJoined).build();

		stateMachine.sendEvent(message);
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public boolean isCustomerJoined() {
		CustomerSearchJoinCO customerSearchJoinCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchJoinCO.getCustomerJoined();
	}

	public void setCustomerJoined(boolean customerJoined) {
		this.customerJoined = customerJoined;
	}
}
