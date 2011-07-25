package org.salgar.swf_statemachine.techdemo.web.customersearch.manager;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.listener.AsynchroneListener;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;

public class CustomerManagerImpl implements CustomerManager {
	private static final Logger log = Logger
			.getLogger(CustomerManagerImpl.class);

	public void findCustomer(final String customerNumber,
			final StateMachine stateMachine) {

		ExecutorService executorService = Executors.newScheduledThreadPool(5);

		executorService.submit(new Runnable() {
			public void run() {
				Random rnd = new Random();
				long interval = (int) (rnd.nextDouble() * 5L);

				try {
					Thread.sleep((5 + interval) * 1000L);
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}

				Customer customer = new Customer();
				customer.setCustomerNumber(customerNumber);
				customer.setFirstName("Dirk");
				customer.setLastName("Pitt");
				
				
				Event customerFoundEvent = new Event();
				customerFoundEvent.setEventType(FindCustomerSM_EventEnumerationImpl.onCustomerFound);
				customerFoundEvent.setPayload(customer);
				
				stateMachine.handleEvent(customerFoundEvent);
			}
		});

	}
}
