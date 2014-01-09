package org.salgar.swf_statemachine.customersearch.transition.guard;

import java.io.Serializable;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.Guard;
import org.salgar.statemachine.domain.State;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.enumeration.state.FindOrdersSM_StateEnumerationImpl;

public class CustomerJoinedOrdersLoadedGuard implements Guard, Serializable {
	private static final long serialVersionUID = -453264357347467L;

	public Boolean evaluateGuard(Event event, AbstractStateMachine stateMachine) {
		State actualStateFindOrdersSlaveSM = ((CustomerSearchSMControlObject) stateMachine
				.getControlObject()).getFindOrdersSlaveSM().giveActualState();

		if (FindOrdersSM_StateEnumerationImpl.ORDERS_FOUND
				.equals(actualStateFindOrdersSlaveSM.getName())) {
			return true;
		}
		return false;
	}

}
