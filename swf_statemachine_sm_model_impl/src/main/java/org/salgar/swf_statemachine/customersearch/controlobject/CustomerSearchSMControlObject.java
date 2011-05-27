package org.salgar.swf_statemachine.customersearch.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.customersearch.guistate.CustomerSearchGuiState;
import org.salgar.swf_statemachine.customersearch.controlobject.AbstractCustomerSearchControlObject;
import org.salgar.swf_statemachine.techdemo.domain.Customer;

public class CustomerSearchSMControlObject extends
		AbstractCustomerSearchControlObject implements ControlObject {

	private static final long serialVersionUID = 5875786542332451L;

	public void resetStateMachine() {
		this.actualGuiState = new CustomerSearchGuiState();
		this.actualGuiState.setRenderCustomerSearchInput(true);
		this.customerNumberInternal = "";
		this.customerAuthenticatedInternal = Boolean.FALSE;
		this.customerJoinedInternal = Boolean.FALSE;
		this.customerSearchInputRenderPanels = "customerSearch-form,customerSearchRunning-panel_empty_layout,customerSearchFound-empty-panel,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel";
	}

	CustomerSearchGuiState getCustomerSearchGuiState() {
		return actualGuiState;
	}

	public String getCustomerNumber() {
		return this.customerNumberInternal;
	}

	@Override
	public Boolean getRenderCustomerSearchInput() {
		return actualGuiState.renderCustomerSearchInput;
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
}
