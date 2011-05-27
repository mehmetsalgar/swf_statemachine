package org.salgar.swf_statemachine.techdemo.web.customersearch.listener;

import org.atmosphere.cpr.Broadcaster;
import org.salgar.comet.CometServiceLocator;
import org.salgar.statemachine.domain.Event;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.listener.AbstractAsynchroneListener;

public class CustomerListener extends AbstractAsynchroneListener {
	private static final long serialVersionUID = -456346364564561L;

	@Override
	public void doResult(Object payload) {
		Event customerFoundEvent = new Event();
		customerFoundEvent
				.setEventType(CustomerSearchSM_EventEnumerationImpl.onCustomerFound);
		customerFoundEvent.setPayload(payload);
		this.stateMachine.handleEvent(customerFoundEvent);

		Broadcaster broadcaster = CometServiceLocator.getInstance()
				.getBroadcaster();

		broadcaster.broadcast("customer found");
	}

}
