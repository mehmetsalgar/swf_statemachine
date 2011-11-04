package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import java.util.List;

import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchOrderCO;
import org.salgar.swf_statemachine.techdemo.domain.Order;

public class CustomerSearchOrderBB {
	private StateMachine stateMachine;

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return ((CustomerSearchOrderCO) stateMachine.getControlObject())
				.getCustomerOrders();
	}

	public boolean isCustomerSearchOrderPanelRendered() {
		return ((CustomerSearchOrderCO) stateMachine.getControlObject())
				.getRenderCustomerOrders();
	}

	public boolean isCustomerSearchOrderLoadingPanelRendered() {
		return ((CustomerSearchOrderCO) stateMachine.getControlObject())
				.getRenderCustomerOrderLoading();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
}
