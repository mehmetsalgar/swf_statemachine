package org.salgar.swf_statemachine.customersearch.controlobject;

import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.statemachine.StateMachine;

import java.util.List;

public class CustomerSearchSMControlObjectAccessor {
	public static AbstractCustomerSearchControlObject getControlObject(StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine) {
		return (AbstractCustomerSearchControlObject) stateMachine.getExtendedState().getVariables().get(stateMachine.getState().getId().getStateMachineName() + "ControlObject");
	}

	public static void processCustomerSearchRunningAction(
			CustomerSearchSMControlObject controlObject, String customerNumber,
			String flowId, String sessionId, Object findCustomerSM) {
		controlObject.customerNumberInternal = customerNumber;
		controlObject.flowId = flowId;
		controlObject.sessionId = sessionId;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = true;
		controlObject.getActualGuiState().renderCustomerSearchFound = false;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = false;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.findCustomerSlaveSM = findCustomerSM;

		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchRunning-panel_empty_layout,customerSearchFound-empty-panel,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerFoundAction(
			CustomerSearchSMControlObject controlObject, Customer customer,
			Object slaveFindOrdersSM) {

		controlObject.customerInternal = customer;
		controlObject.findOrdersSlaveSM = slaveFindOrdersSM;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerAuthenticatedAction(
			CustomerSearchSMControlObject controlObject,
			Boolean customerAuthenticated) {
		controlObject.customerAuthenticatedInternal = customerAuthenticated;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedAction(
			CustomerSearchSMControlObject controlObject, Boolean customerJoined) {
		controlObject.customerJoinedInternal = customerJoined;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
		controlObject.getActualGuiState().renderCustomerSearchOrder = true;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerOrdersInternal = FindOrdersSMControlObjectAccessor
				.getControlObject((StateMachine) controlObject.findOrdersSlaveSM).getOrders();
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedAuthenticationRemovedAction(
			CustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		controlObject.customerJoinedInternal = false;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerAuthenticationRemovedAction(
			CustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadingCustomerAuthenticationRemovedAction(
			CustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		controlObject.customerJoinedInternal = false;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerJoinedRemovedAction(
			CustomerSearchSMControlObject controlObject) {
		controlObject.customerJoinedInternal = false;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadingAction(
			CustomerSearchSMControlObject controlObject) {
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = true;
		controlObject.customerJoinedInternal = true;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processOrdersLoadedAction(
			CustomerSearchSMControlObject controlObject, List<Order> orders) {
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
		controlObject.getActualGuiState().renderCustomerSearchOrder = true;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";

		controlObject.customerOrdersInternal = orders;
	}
}
