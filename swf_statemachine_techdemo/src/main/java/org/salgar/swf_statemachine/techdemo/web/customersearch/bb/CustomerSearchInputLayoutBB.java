package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.apache.log4j.Logger;
import org.salgar.comet.CometServiceLocator;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchInputCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.webflow.execution.FlowExecutionContext;

import javax.faces.context.FacesContext;

public class CustomerSearchInputLayoutBB {
	private static final Logger log = Logger
			.getLogger(CustomerSearchInputLayoutBB.class);
	private String customerNumber;

	/*
	 * IOC Injections
	 */

	private StateMachine stateMachine;

	public boolean isCustomerSearchInputLayoutRendered() {
		CustomerSearchInputCO customerSearchInputCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchInputCO.getRenderCustomerSearchInput();
	}

	public String getCustomerSearchRenderPanels() {
		CustomerSearchInputCO customerSearchInputCO = CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine);
		return customerSearchInputCO.getCustomerSearchRenderPanels();
	}

	public void searchCustomer() {
		log.info("We are searching customer!");
		CometServiceLocator.getInstance();

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);		
		FlowExecutionContext fec = (FlowExecutionContext) FacesContext.getCurrentInstance().getELContext()
		.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(), null, "flowExecutionContext");
		String flowId = (String) fec.getKey().toString();
		customerSearchStartEventPayload.setFlowId(flowId);
		String sessionId = ((javax.servlet.http.HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getId();
		customerSearchStartEventPayload.setSessionId(sessionId);
		//CustomerListener customerListener = new CustomerListener();
		//customerListener.setStateMachine(stateMachine);
		//customerSearchStartEventPayload.setCustomerListener(customerListener);

		Message message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onStartSearch)
				.setHeader("customerSearchStartEventPayload", customerSearchStartEventPayload)
				.build();

		stateMachine.sendEvent(message);
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
}
