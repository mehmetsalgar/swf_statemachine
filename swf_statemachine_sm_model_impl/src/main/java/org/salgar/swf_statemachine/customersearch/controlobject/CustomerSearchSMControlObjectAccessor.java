package org.salgar.swf_statemachine.customersearch.controlobject;

import org.salgar.swf_statemachine.techdemo.domain.Customer;

public class CustomerSearchSMControlObjectAccessor {
	private volatile static CustomerSearchSMControlObjectAccessor INSTANCE;

	private CustomerSearchSMControlObjectAccessor() {
	}

	public static CustomerSearchSMControlObjectAccessor getInstance() {
		if (INSTANCE == null) {
			INSTANCE = createInstance();
		}
		return INSTANCE;
	}

	private synchronized static CustomerSearchSMControlObjectAccessor createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerSearchSMControlObjectAccessor();
		}
		return INSTANCE;
	}

	public void processCustomerSearchRunningAction(
			CustomerSearchSMControlObject controlObject, String customerNumber) {
		controlObject.customerNumberInternal = customerNumber;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = true;
		controlObject.getActualGuiState().renderCustomerSearchFound = false;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = false;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
	}

	public void processCustomerFoundAction(
			CustomerSearchSMControlObject controlObject, Customer customer) {

		controlObject.customerInternal = customer;
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
	}

	public void processCustomerAuthenticatedAction(
			CustomerSearchSMControlObject controlObject,
			Boolean customerAuthenticated) {
		controlObject.customerAuthenticatedInternal = customerAuthenticated;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
	}

	public void processCustomerJoinedAction(
			CustomerSearchSMControlObject controlObject, Boolean customerJoined) {
		controlObject.customerJoinedInternal = customerJoined;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
	}
	
	public void processCustomerJoinedAuthenticationRemovedAction(CustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		controlObject.customerJoinedInternal = false;

		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
	}
	
	public void processCustomerAuthenticationRemovedAction(CustomerSearchSMControlObject controlObject) {
		controlObject.customerAuthenticatedInternal = false;
		
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = false;
	}
	
	public void processCustomerJoinedRemovedAction(CustomerSearchSMControlObject controlObject) {
		controlObject.customerJoinedInternal = false;
		
		controlObject.getActualGuiState().renderCustomerSearchInput = false;
		controlObject.getActualGuiState().renderCustomerSearchRunning = false;
		controlObject.getActualGuiState().renderCustomerSearchFound = true;
		controlObject.getActualGuiState().renderCustomerSearchAuthentication = true;
		controlObject.getActualGuiState().renderCustomerSearchJoin = true;
	}
}
