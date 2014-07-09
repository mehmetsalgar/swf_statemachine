package org.salgar.swf_statemachine.customersearch.controlobject;

import java.util.List;

import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.domain.Order;

public class CustomerSearchSMControlObjectAccessor {

	public static void processCustomerSearchRunningAction(
			CustomerSearchSMControlObject controlObject, String customerNumber,
			String flowId, String sessionId) {
		controlObject.customerNumberInternal = customerNumber;
		controlObject.setFlowId(flowId);
		controlObject.setSessionId(sessionId);
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = true;
		controlObject.getActualGuiState().renderCustomerSearchFound = false;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = false;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
		controlObject.getActualGuiState().renderCustomerSearchOrder = false;
		controlObject.getActualGuiState().renderCustomerSearchOrderLoading = false;
		controlObject.customerSearchInputRenderPanels = "customerSearchCustomerDetail_form,customerSearchRunning-panel_empty_layout,customerSearchFound-empty-panel,customerSearchAuthentication-empty-panel,customerSearchJoin-empty-panel,customerSearchOrderLoading-empty-panel,customerSearchOrder-empty-panel,handlePuplishRemoteCommand";
	}

	public static void processCustomerFoundAction(
			CustomerSearchSMControlObject controlObject, Customer customer,
			StateMachine slaveFindOrdersSM) {

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
				.getOrders(controlObject.findOrdersSlaveSM.getControlObject());
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

	public static StateMachine deliverFindOrdersSlaveSM(
			CustomerSearchSMControlObject controlObject) {
		return controlObject.findOrdersSlaveSM;
	}
}
