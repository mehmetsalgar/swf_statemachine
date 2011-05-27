package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchRunningCO;

public class CustomerSearchRunningBB {
	private StateMachine stateMachine;

	public boolean isCustomerSearchRunningPanelRendered() {
		CustomerSearchRunningCO customerSearchRunningCO = (CustomerSearchRunningCO) stateMachine
				.getControlObject();
		return customerSearchRunningCO.getRenderCustomerSearchRunning();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
