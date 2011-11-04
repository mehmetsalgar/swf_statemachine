package org.salgar.swf_statemachine.customersearch.transition.action;

import java.util.List;

import org.atmosphere.cpr.Broadcaster;
import org.salgar.comet.CometServiceLocator;
import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.techdemo.domain.Order;

public class OrdersLoadedAction implements Action {

	@SuppressWarnings("unchecked")
	public void processAction(Event event, AbstractStateMachine stateMachine) {
		CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) stateMachine
				.getControlObject();
		CustomerSearchSMControlObjectAccessor.processOrdersLoadedAction(
				controlObject, (List<Order>) event.getPayload());

		Broadcaster broadcaster = CometServiceLocator.getInstance()
				.getBroadcaster();

		broadcaster.broadcast("orders found");
	}

}
