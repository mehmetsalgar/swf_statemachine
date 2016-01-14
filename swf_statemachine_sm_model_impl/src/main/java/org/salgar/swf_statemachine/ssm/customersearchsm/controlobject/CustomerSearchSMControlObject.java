package org.salgar.swf_statemachine.ssm.customersearchsm.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.guistate.CustomerSearchGuiState;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CustomerSearchSMControlObject extends AbstractCustomerSearchSMControlObject
		implements ControlObject, CustomerSearchCO, CustomerSearchInputCO, CustomerSearchRunningCO, CustomerSearchOrderCO, CustomerSearchJoinCO, CustomerSearchFoundCO, CustomerSearchAuthenticationCO {

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

	public Boolean getRenderCustomerSearchInput() {
		return actualGuiState.getRenderCustomerSearchInput();
	}

	public String getCustomerSearchRenderPanels() {
		return this.customerSearchInputRenderPanels;
	}

	public Boolean getRenderCustomerSearchRunning() {
		return actualGuiState.getRenderCustomerSearchRunning();
	}

	public Boolean getRenderCustomerSearchFound() {
		return actualGuiState.getRenderCustomerSearchFound();
	}

	public Boolean getRenderCustomerSearchAuthentication() {
		return actualGuiState.getRenderCustomerSearchAuthentication();
	}

	public Boolean getRenderCustomerJoin() {
		return actualGuiState.getRenderCustomerSearchJoin();
	}

	public Customer getCustomer() {
		return this.customerInternal;
	}

	public Boolean getCustomerAuthenticated() {
		return this.customerAuthenticatedInternal;
	}

	public Boolean getCustomerJoined() {
		return this.customerJoinedInternal;
	}

	public Boolean getRenderCustomerOrders() {
		return actualGuiState.getRenderCustomerSearchOrder();
	}

	@SuppressWarnings("rawtypes")
	public List getCustomerOrders() {
		return this.customerOrdersInternal;
	}

	public Boolean getRenderCustomerOrderLoading() {
		return actualGuiState.getRenderCustomerSearchOrderLoading();
	}
}
