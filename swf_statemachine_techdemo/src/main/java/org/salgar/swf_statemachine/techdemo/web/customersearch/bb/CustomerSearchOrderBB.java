package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.statemachine.StateMachine;

import java.util.List;

public class CustomerSearchOrderBB {
	private StateMachine stateMachine;

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine)
				.getCustomerOrders();
	}

	public boolean isCustomerSearchOrderPanelRendered() {
		return CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine)
				.getRenderCustomerOrders();
	}

	public boolean isCustomerSearchOrderLoadingPanelRendered() {
		return CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine)
				.getRenderCustomerOrderLoading();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
