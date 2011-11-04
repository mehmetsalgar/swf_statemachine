package org.salgar.swf_statemachine.customersearch.transition.guard;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.Guard;
import org.salgar.statemachine.domain.State;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.enumeration.state.FindOrdersSM_StateEnumerationImpl;

public class CustomerJoinedOrdersLoadedGuard implements Guard {

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
