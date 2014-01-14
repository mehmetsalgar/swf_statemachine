package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.apache.log4j.Logger;
import org.salgar.comet.CometServiceLocator;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchInputCO;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;

public class CustomerSearchInputLayoutBB {
	private static final Logger log = Logger
			.getLogger(CustomerSearchInputLayoutBB.class);
	private String customerNumber;

	/*
	 * IOC Injections
	 */

	private StateMachine stateMachine;
	private CustomerManager customerManager;

	public boolean isCustomerSearchInputLayoutRendered() {
		CustomerSearchInputCO customerSearchInputCO = (CustomerSearchInputCO) stateMachine
				.getControlObject();
		return customerSearchInputCO.getRenderCustomerSearchInput();
	}

	public String getCustomerSearchRenderPanels() {
		CustomerSearchInputCO customerSearchInputCO = (CustomerSearchInputCO) stateMachine
				.getControlObject();
		return customerSearchInputCO.getCustomerSearchRenderPanels();
	}

	public void searchCustomer() {
		log.info("We are searching customer!");
		CometServiceLocator.getInstance();
		Event event = new Event();
		event.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);

		//CustomerListener customerListener = new CustomerListener();
		//customerListener.setStateMachine(stateMachine);
		//customerSearchStartEventPayload.setCustomerListener(customerListener);

		event.setPayload(customerSearchStartEventPayload);

		stateMachine.handleEvent(event);
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
}
