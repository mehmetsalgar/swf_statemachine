package org.salgar.swf_statemachine.findcustomer.transition.action;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.findcustomer.controlobject.FindCustomerSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;

public class FindCustomerStartAction implements Action, Serializable {
	private static final long serialVersionUID = -978922345793959337L;
	
	public void processAction(Event event, AbstractStateMachine stateMachine) {
		String customerNumber = (String) event.getPayload();
		StateMachine masterStateMachine = (StateMachine) event.getSource();

		FindCustomerSMControlObjectAccessor.processFindCustomerStart(
				stateMachine.getControlObject(), masterStateMachine);
		CustomerManager customerManager = (CustomerManager) stateMachine
				.findObjects("customerManager");

		customerManager.findCustomer(customerNumber, stateMachine);
	}
}
