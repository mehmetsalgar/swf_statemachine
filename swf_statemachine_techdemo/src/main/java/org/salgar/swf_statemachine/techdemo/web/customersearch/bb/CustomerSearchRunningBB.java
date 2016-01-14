package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchRunningCO;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.springframework.statemachine.StateMachine;

public class CustomerSearchRunningBB {
	private StateMachine stateMachine;

	public boolean isCustomerSearchRunningPanelRendered() {
		CustomerSearchRunningCO customerSearchRunningCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);

		return customerSearchRunningCO.getRenderCustomerSearchRunning();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
