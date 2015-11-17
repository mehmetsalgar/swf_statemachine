package org.salgar.swf_statemachine.techdemo.web.customersearch.manager;

import org.apache.log4j.Logger;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomerManagerImpl implements CustomerManager {
	private static final Logger log = Logger
			.getLogger(CustomerManagerImpl.class);

	public void findCustomer(final String customerNumber,
			final Object stateMachine) {

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

				Message<FindCustomerSM_EventEnumerationImpl> message = MessageBuilder.withPayload(FindCustomerSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", customer).build();
				
				((StateMachine)stateMachine).sendEvent(message);
			}
		});

	}
}
