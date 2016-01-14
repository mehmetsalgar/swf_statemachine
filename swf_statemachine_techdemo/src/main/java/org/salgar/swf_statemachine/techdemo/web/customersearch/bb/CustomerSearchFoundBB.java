package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchFoundCO;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.springframework.statemachine.StateMachine;

public class CustomerSearchFoundBB {
	private StateMachine stateMachine;

	public boolean isCustomerSearchFoundPanelRendered() {
		CustomerSearchFoundCO customerSearchFoundCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchFoundCO.getRenderCustomerSearchFound();
	}

	public Customer getCustomer() {
		CustomerSearchFoundCO customerSearchFoundCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);

		return customerSearchFoundCO.getCustomer();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
