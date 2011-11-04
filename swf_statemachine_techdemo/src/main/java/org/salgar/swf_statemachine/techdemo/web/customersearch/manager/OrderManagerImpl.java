package org.salgar.swf_statemachine.techdemo.web.customersearch.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.enumeration.event.findorderssm.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.salgar.swf_statemachine.techdemo.manager.OrderManager;

public class OrderManagerImpl implements OrderManager {
	private static final Logger log = Logger.getLogger(OrderManagerImpl.class);

	public void findOrders(final String customerNumber,
			final StateMachine stateMachine) {
		ExecutorService executorService = Executors.newScheduledThreadPool(5);

		executorService.submit(new Runnable() {
			public void run() {
				Random rnd = new Random();
				long interval = (int) (rnd.nextDouble() * 30L);

				try {
					Thread.sleep((5 + interval) * 1000L);
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}

				List<Order> orders = new ArrayList<Order>();

				Order order1 = new Order();
				order1.setId("0000000001");
				order1.setDate(new Date(System.currentTimeMillis()
						- (90 * 24 * 60 * 60 * 1000L)));
				order1.setDescription("First order");

				orders.add(order1);

				Order order2 = new Order();
				order2.setId("0000000002");
				order2.setDate(new Date(System.currentTimeMillis()
						- (60 * 24 * 60 * 60 * 1000L)));
				order2.setDescription("Second order");

				orders.add(order2);

				Order order3 = new Order();
				order3.setId("0000000003");
				order3.setDate(new Date(System.currentTimeMillis()
						- (45 * 24 * 60 * 60 * 1000L)));
				order3.setDescription("Third order");

				orders.add(order3);

				Event ordersFoundEvent = new Event();
				ordersFoundEvent
						.setEventType(FindOrdersSM_EventEnumerationImpl.onOrdersFound);
				ordersFoundEvent.setPayload(orders);

				stateMachine.handleEvent(ordersFoundEvent);
			}
		});

	}
}
