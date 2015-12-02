package org.salgar.swf_statemachine.customersearch.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.customersearch.guistate.CustomerSearchGuiState;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CustomerSearchSMControlObject extends
		AbstractCustomerSearchControlObject implements ControlObject {

	private static final long serialVersionUID = 5875786542332451L;

	public void resetStateMachine() {
		this.actualGuiState = new CustomerSearchGuiState();
		this.actualGuiState.setRenderCustomerSearchInput(true);
		this.customerNumberInternal = "";
		this.customerAuthenticatedInternal = Boolean.FALSE;
		this.customerJoinedInternal = Boolean.FALSE;
		this.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearch-form,customerSearchRunning-panel_empty_layout,customerSearchFound-empty-panel,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,handlePuplishRemoteCommand";
		this.customerInternal = null;
		this.customerOrdersInternal = null;
		this.findOrdersSlaveSM = null;
		this.findCustomerSlaveSM = null;
		this.flowId = null;
		this.sessionId = null;
	}

	CustomerSearchGuiState getCustomerSearchGuiState() {
		return actualGuiState;
	}

	public String getCustomerNumber() {
		return this.customerNumberInternal;
	}

	@Override
	public Boolean getRenderCustomerSearchInput() {
		return actualGuiState.getRenderCustomerSearchInput();
	}

	@Override
	public String getCustomerSearchRenderPanels() {
		return this.customerSearchInputRenderPanels;
	}

	@Override
	public Boolean getRenderCustomerSearchRunning() {
		return actualGuiState.getRenderCustomerSearchRunning();
	}

	@Override
	public Boolean getRenderCustomerSearchFound() {
		return actualGuiState.getRenderCustomerSearchFound();
	}

	@Override
	public Boolean getRenderCustomerSearchAuthentication() {
		return actualGuiState.getRenderCustomerSearchAuthentication();
	}

	@Override
	public Boolean getRenderCustomerJoin() {
		return actualGuiState.getRenderCustomerSearchJoin();
	}

	@Override
	public Customer getCustomer() {
		return this.customerInternal;
	}

	@Override
	public Boolean getCustomerAuthenticated() {
		return this.customerAuthenticatedInternal;
	}

	@Override
	public Boolean getCustomerJoined() {
		return this.customerJoinedInternal;
	}

	@Override
	public Boolean getRenderCustomerOrders() {
		return actualGuiState.getRenderCustomerSearchOrder();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCustomerOrders() {
		return this.customerOrdersInternal;
	}

	@Override
	public Boolean getRenderCustomerOrderLoading() {
		return actualGuiState.getRenderCustomerSearchOrderLoading();
	}
}
