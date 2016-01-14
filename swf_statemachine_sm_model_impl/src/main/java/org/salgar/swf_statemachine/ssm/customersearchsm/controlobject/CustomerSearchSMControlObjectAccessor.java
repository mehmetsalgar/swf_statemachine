package org.salgar.swf_statemachine.ssm.customersearchsm.controlobject;

import org.salgar.swf_statemachine.ssm.findorderssm.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.statemachine.StateMachine;

import java.util.List;

public class CustomerSearchSMControlObjectAccessor {
	public static CustomerSearchSMControlObject getControlObject(StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine) {
		return (CustomerSearchSMControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}

	public static void processCustomerSearchRunningAction(
			CustomerSearchSMControlObject controlObject, String customerNumber,
			String flowId, String sessionId, StateMachine findCustomerSM) {
		controlObject.customerNumberInternal = customerNumber;
		controlObject.flowId = flowId;
		controlObject.sessionId = sessionId;
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(true);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(false);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(false);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.findCustomerSlaveSM = findCustomerSM;

		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchRunning-panel_empty_layout,customerSearchFound-empty-panel,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerFoundAction(
			AbstractCustomerSearchSMControlObject controlObject, Customer customer,
			StateMachine slaveFindOrdersSM) {

		controlObject.customerInternal = customer;
		controlObject.findOrdersSlaveSM = slaveFindOrdersSM;
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerAuthenticatedAction(
			AbstractCustomerSearchSMControlObject controlObject,
			Boolean customerAuthenticated) {
		controlObject.customerAuthenticatedInternal = customerAuthenticated;

		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedAction(
			AbstractCustomerSearchSMControlObject controlObject, Boolean customerJoined) {
		controlObject.customerJoinedInternal = customerJoined;

		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerOrdersInternal = FindOrdersSMControlObjectAccessor
				.getControlObject((StateMachine) controlObject.findOrdersSlaveSM).getOrders();
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedAuthenticationRemovedAction(
			AbstractCustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		controlObject.customerJoinedInternal = false;
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerAuthenticationRemovedAction(
			AbstractCustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;

		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadingCustomerAuthenticationRemovedAction(
			AbstractCustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		controlObject.customerJoinedInternal = false;
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedRemovedAction(
			AbstractCustomerSearchSMControlObject controlObject) {
		controlObject.customerJoinedInternal = false;

		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadingAction(
			AbstractCustomerSearchSMControlObject controlObject) {
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(false);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(true);
		controlObject.customerJoinedInternal = true;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadedAction(
			AbstractCustomerSearchSMControlObject controlObject, List<Order> orders) {
		controlObject.getActualGuiState().setRenderCustomerSearchInput(false);
		controlObject.getActualGuiState().setRenderCustomerSearchRunning(false);
		controlObject.getActualGuiState().setRenderCustomerSearchFound(true);
		controlObject.getActualGuiState().setRenderCustomerSearchAuthentication(true);
		controlObject.getActualGuiState().setRenderCustomerSearchJoin(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrder(true);
		controlObject.getActualGuiState().setRenderCustomerSearchOrderLoading(false);
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";

		controlObject.customerOrdersInternal = orders;
	}
}
