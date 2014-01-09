package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchFoundCO;
import org.salgar.swf_statemachine.techdemo.domain.Customer;

public class CustomerSearchFoundBB {
	private StateMachine stateMachine;

	public boolean isCustomerSearchFoundPanelRendered() {
		CustomerSearchFoundCO customerSearchFoundCO = (CustomerSearchFoundCO) stateMachine
				.getControlObject();
		return customerSearchFoundCO.getRenderCustomerSearchFound();
	}

	public Customer getCustomer() {
		CustomerSearchFoundCO customerSearchFoundCO = (CustomerSearchFoundCO) stateMachine
				.getControlObject();

		return customerSearchFoundCO.getCustomer();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
