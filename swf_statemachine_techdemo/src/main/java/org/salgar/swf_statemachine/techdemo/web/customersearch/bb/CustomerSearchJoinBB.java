package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchJoinCO;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;

public class CustomerSearchJoinBB {
	private StateMachine stateMachine;
	private boolean customerJoined;

	public boolean isCustomerSearchJoinPanelRendered() {
		CustomerSearchJoinCO customerSearchJoinCO = (CustomerSearchJoinCO) stateMachine
				.getControlObject();
		return customerSearchJoinCO.getRenderCustomerJoin();
	}

	public void customerJoined() {
		Event event = new Event();
		event.setEventType(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked);
		event.setPayload(this.customerJoined);

		stateMachine.handleEvent(event);
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public boolean isCustomerJoined() {
		CustomerSearchJoinCO customerSearchJoinCO = (CustomerSearchJoinCO) stateMachine
				.getControlObject();
		return customerSearchJoinCO.getCustomerJoined();
	}

	public void setCustomerJoined(boolean customerJoined) {
		this.customerJoined = customerJoined;
	}
}
