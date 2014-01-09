package org.salgar.swf_statemachine.customersearch.transition.action;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;

public class CustomerJoinedAuthenticationRemovedAction implements Action,
		Serializable {

	private static final long serialVersionUID = 2490741775947067619L;

	public void processAction(Event event, AbstractStateMachine stateMachine) {
		CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) stateMachine
				.getControlObject();
		CustomerSearchSMControlObjectAccessor
				.processCustomerJoinedAuthenticationRemovedAction(controlObject);
	}

}
