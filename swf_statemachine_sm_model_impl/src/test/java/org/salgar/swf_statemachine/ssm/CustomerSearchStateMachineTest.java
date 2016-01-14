package org.salgar.swf_statemachine.ssm;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.factory.StateMachineFactories;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;
import org.salgar.swf_statemachine.techdemo.manager.OrderManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.anyObject;
import static org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl.*;
import static org.salgar.swf_statemachine.ssm.enumeration.StateMachineEnumerationImpl.CustomerSearchSM;
import static org.salgar.swf_statemachine.ssm.findorderssm.enumeration.event.FindOrdersSM_EventEnumerationImpl.onOrdersFound;

@ContextConfiguration(locations = {
		"/META-INF/scope.xml",
		"/META-INF/applicationContext-customerManager-mock.xml" })
@Configuration
public class CustomerSearchStateMachineTest extends
		AbstractTestNGSpringContextTests {
	private static final Logger log = Logger
			.getLogger(CustomerSearchStateMachineTest.class);

	@Test
	public void initialisation() {
		StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine = StateMachineFactories.getInstance().getCustomerSearchSMFactory().getStateMachine();
		stateMachine.start();
		Assert.assertNotNull(stateMachine);
		Assert.assertEquals(CustomerSearchSM
				.getStateMachineName(), stateMachine.getState().getId().getStateMachineName().getStateMachineName());
	}

	@Test(dependsOnMethods = { "initialisation" }, enabled = true)
	public void startSearch() {
		StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine = StateMachineFactories.getInstance().getCustomerSearchSMFactory().getStateMachine();
		stateMachine.start();

		//Broadcaster br = CometServiceLocatorMocker.mock();
		//Broadcaster broadCasterMock = CometServiceLocatorMocker.getMockObject();
		String customerNumber = "987654321";

		Assert.assertNotNull(stateMachine);
		Assert.assertEquals(CustomerSearchSM
				.getStateMachineName(), stateMachine.getState().getId().getStateMachineName().getStateMachineName());

		Assert.assertEquals(
				WAITING_CUSTOMERSEARCH_START.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		Message<CustomerSearchSM_EventEnumerationImpl> message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onStartSearch).setHeader("customerSearchStartEventPayload", customerSearchStartEventPayload).build();



		//Event onSearchStartEvent = new Event();
		//onSearchStartEvent
		//		.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);
		//customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		//onSearchStartEvent.setPayload(customerSearchStartEventPayload);

		CustomerManager customerManager = (CustomerManager) this.applicationContext
				.getBean("customerManager");
		customerManager.findCustomer(anyObject(String.class),
				anyObject(Object.class));
		EasyMock.replay(customerManager);
		stateMachine.sendEvent(message);
		EasyMock.verify(customerManager);

		Assert.assertEquals(
				CUSTOMERSEARCH_RUNNING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);
		customer.setFirstName("Dirk");
		customer.setLastName("Pitt");


		stateMachine.sendEvent(message);


		Message<FindCustomerSM_EventEnumerationImpl> messageOnCustomerFound = MessageBuilder.withPayload(FindCustomerSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", customer).build();
		//EasyMock.replay(broadCasterMock);

		StateMachine findCustomerSM = (StateMachine) CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getFindCustomerSlaveSM();

		OrderManager orderManager = (OrderManager) this.applicationContext
				.getBean("orderManager");
		orderManager.findOrders(anyObject(String.class), anyObject(Object.class));
		EasyMock.replay(orderManager);
		//EasyMock.replay(br);

		findCustomerSM.sendEvent(messageOnCustomerFound);

		EasyMock.verify(orderManager);
		//EasyMock.verify(br);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());


		Message<CustomerSearchSM_EventEnumerationImpl> messageOnCustomerAuthenticated = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked)
				.setHeader("authenticated", true).build();
		stateMachine.sendEvent(messageOnCustomerAuthenticated);

		Assert.assertEquals(
				CUSTOMER_AUTHENTICATED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		stateMachine.sendEvent(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked);

		Assert.assertEquals(
				ORDERS_LOADING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());

		stateMachine.sendEvent(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked);

		Assert.assertEquals(
				CUSTOMER_AUTHENTICATED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());

		stateMachine.sendEvent(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked);

		Assert.assertEquals(
				ORDERS_LOADING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());

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

		Message<FindOrdersSM_EventEnumerationImpl> messageonOrdersFound = MessageBuilder.withPayload(onOrdersFound).setHeader("orders", orders).build();

		((StateMachine)CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getFindOrdersSlaveSM()).sendEvent(messageonOrdersFound);

		Assert.assertEquals(
				CUSTOMER_JOINED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());
		Assert.assertNotNull(
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerOrdersInternal());

		stateMachine.sendEvent(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerAuthenticatedInternal());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());
		Assert.assertNotNull(
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerOrdersInternal());

		Message<CustomerSearchSM_EventEnumerationImpl> messageOnCustomerAuthenticatedClicked = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked).setHeader("authenticated", true).build();

		stateMachine.sendEvent(messageOnCustomerAuthenticatedClicked);

		Assert.assertEquals(
				CUSTOMER_AUTHENTICATED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerAuthenticatedInternal());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());
		Assert.assertNotNull(
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerOrdersInternal());

		Message<CustomerSearchSM_EventEnumerationImpl> messageCustomerJoined = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked).setHeader("joined", true).build();
		stateMachine.sendEvent(messageCustomerJoined);

		Assert.assertEquals(
				CUSTOMER_JOINED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());
		Assert.assertNotNull(
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerOrdersInternal());

		EasyMock.reset(customerManager);
		EasyMock.reset(orderManager);
		//EasyMock.reset(br);
	}

	@Test(dependsOnMethods = { "initialisation" }, enabled = true)
	public void testCustomerAuthenticationRemoval() {
		StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine = StateMachineFactories.getInstance().getCustomerSearchSMFactory().getStateMachine();
		stateMachine.start();

		//Broadcaster br = CometServiceLocatorMocker.mock();
		//Broadcaster broadCasterMock = CometServiceLocatorMocker.getMockObject();
		String customerNumber = "987654321";

		CustomerSearchSMControlObject customerSearchSMControlObject = new CustomerSearchSMControlObject();
		Assert.assertNotNull(stateMachine);
		Assert.assertEquals(CustomerSearchSM
				.getStateMachineName(), stateMachine.getState().getId().getStateMachineName().getStateMachineName());

		Assert.assertEquals(
				WAITING_CUSTOMERSEARCH_START.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		Message<CustomerSearchSM_EventEnumerationImpl> message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onStartSearch).setHeader("customerSearchStartEventPayload", customerSearchStartEventPayload).build();



		//Event onSearchStartEvent = new Event();
		//onSearchStartEvent
		//		.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);
		//customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		//onSearchStartEvent.setPayload(customerSearchStartEventPayload);

		CustomerManager customerManager = (CustomerManager) this.applicationContext
				.getBean("customerManager");
		customerManager.findCustomer(anyObject(String.class),
				anyObject(Object.class));
		EasyMock.replay(customerManager);
		stateMachine.sendEvent(message);
		EasyMock.verify(customerManager);

		Assert.assertEquals(
				CUSTOMERSEARCH_RUNNING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);
		customer.setFirstName("Dirk");
		customer.setLastName("Pitt");


		stateMachine.sendEvent(message);


		Message<FindCustomerSM_EventEnumerationImpl> messageOnCustomerFound = MessageBuilder.withPayload(FindCustomerSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", customer).build();
		//EasyMock.replay(broadCasterMock);

		StateMachine findCustomerSM = (StateMachine) CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getFindCustomerSlaveSM();

		OrderManager orderManager = (OrderManager) this.applicationContext
				.getBean("orderManager");
		orderManager.findOrders(anyObject(String.class), anyObject(Object.class));
		EasyMock.replay(orderManager);
		//EasyMock.replay(br);

				findCustomerSM.sendEvent(messageOnCustomerFound);

		EasyMock.verify(orderManager);
		//EasyMock.verify(br);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());


		Message<CustomerSearchSM_EventEnumerationImpl> messageOnCustomerAuthenticated = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked).setHeader("authenticated", true).build();
		stateMachine.sendEvent(messageOnCustomerAuthenticated);

		Assert.assertEquals(
				CUSTOMER_AUTHENTICATED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		stateMachine.sendEvent(messageOnCustomerAuthenticated);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerAuthenticatedInternal());

		EasyMock.reset(customerManager);
		EasyMock.reset(orderManager);
	}

	@Test(dependsOnMethods = { "initialisation" }, enabled = true)
	public void testAuthenticationRemovalAtOrderRemoval() {
		StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine = StateMachineFactories.getInstance().getCustomerSearchSMFactory().getStateMachine();
		stateMachine.start();
		//Broadcaster br = CometServiceLocatorMocker.mock();
		//Broadcaster broadCasterMock = CometServiceLocatorMocker.getMockObject();
		String customerNumber = "987654321";

		CustomerSearchSMControlObject customerSearchSMControlObject = new CustomerSearchSMControlObject();
		Assert.assertNotNull(stateMachine);
		Assert.assertEquals(CustomerSearchSM
				.getStateMachineName(), stateMachine.getState().getId().getStateMachineName().getStateMachineName());

		Assert.assertEquals(
				WAITING_CUSTOMERSEARCH_START.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		Message<CustomerSearchSM_EventEnumerationImpl> message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onStartSearch).setHeader("customerSearchStartEventPayload", customerSearchStartEventPayload).build();



		//Event onSearchStartEvent = new Event();
		//onSearchStartEvent
		//		.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);
		//customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		//onSearchStartEvent.setPayload(customerSearchStartEventPayload);

		CustomerManager customerManager = (CustomerManager) this.applicationContext
				.getBean("customerManager");
		customerManager.findCustomer(anyObject(String.class),
				anyObject(Object.class));
		EasyMock.replay(customerManager);
		stateMachine.sendEvent(message);
		EasyMock.verify(customerManager);

		Assert.assertEquals(
				CUSTOMERSEARCH_RUNNING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);
		customer.setFirstName("Dirk");
		customer.setLastName("Pitt");


		stateMachine.sendEvent(message);


		Message<FindCustomerSM_EventEnumerationImpl> messageOnCustomerFound = MessageBuilder.withPayload(FindCustomerSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", customer).build();
		//EasyMock.replay(broadCasterMock);

		StateMachine findCustomerSM = (StateMachine) CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getFindCustomerSlaveSM();

		OrderManager orderManager = (OrderManager) this.applicationContext
				.getBean("orderManager");
		orderManager.findOrders(anyObject(String.class), anyObject(Object.class));
		EasyMock.replay(orderManager);
		//EasyMock.replay(br);

		findCustomerSM.sendEvent(messageOnCustomerFound);

		EasyMock.verify(orderManager);
		//EasyMock.verify(br);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());


		Message<CustomerSearchSM_EventEnumerationImpl> messageOnCustomerAuthenticated = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerAuthenticatedClicked).setHeader("authenticated", true).build();
		stateMachine.sendEvent(messageOnCustomerAuthenticated);

		Assert.assertEquals(
				CUSTOMER_AUTHENTICATED.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());

		stateMachine.sendEvent(CustomerSearchSM_EventEnumerationImpl.onCustomerJoinedClicked);

		Assert.assertEquals(
				ORDERS_LOADING.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerJoinedInternal());

		stateMachine.sendEvent(messageOnCustomerAuthenticated);

		Assert.assertEquals(
				CUSTOMER_FOUND.getStateName(),
				stateMachine.getState().getId().getStateName());
		Assert.assertEquals(customerNumber,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getRenderCustomerOrderLoading());
		Assert.assertEquals(Boolean.FALSE,
				CustomerSearchSMControlObjectAccessor.getControlObject(stateMachine).getCustomerAuthenticatedInternal());

		EasyMock.reset(customerManager);
		EasyMock.reset(orderManager);
	}
}
