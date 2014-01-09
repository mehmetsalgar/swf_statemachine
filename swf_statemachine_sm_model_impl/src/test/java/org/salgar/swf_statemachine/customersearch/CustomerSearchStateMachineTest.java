package org.salgar.swf_statemachine.customersearch;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.atmosphere.cpr.Broadcaster;
import org.easymock.EasyMock;
import org.salgar.comet.CometServiceLocator;
import org.salgar.comet.CometServiceLocatorMocker;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchAuthenticationCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchFoundCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchInputCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchJoinCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchOrderCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchRunningCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.enumeration.StateMachineEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.easymock.EasyMock.*;

@ContextConfiguration(locations = {
		"/META-INF/scope.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch-guards.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch-controlobjects.xml",
		"/META-INF/findcustomer/applicationContext-statemachine-findcustomer.xml",
		"/META-INF/findcustomer/applicationContext-statemachine-findcustomer-guards.xml",
		"/META-INF/findcustomer/applicationContext-statemachine-findcustomer-controlobjects.xml",
		"/META-INF/findorders/applicationContext-statemachine-findorders.xml",
		"/META-INF/findorders/applicationContext-statemachine-findorders-guards.xml",
		"/META-INF/findorders/applicationContext-statemachine-findorders-controlobjects.xml",
		"/META-INF/applicationContext-customerManager-mock.xml" })
public class CustomerSearchStateMachineTest extends
		AbstractTestNGSpringContextTests {
	private static final Logger log = Logger
			.getLogger(CustomerSearchStateMachineTest.class);

	@Test
	public void initialisation() {
		StateMachine customerSearchSM = (StateMachine) this.applicationContext
				.getBean("CustomerSearchSM");
		customerSearchSM.resetStateMachine();
		Assert.assertNotNull(customerSearchSM);
		Assert.assertEquals(StateMachineEnumerationImpl.CustomerSearchSM
				.getStateMachineName(), customerSearchSM.giveActualState()
				.getName().getStateMachineName().getStateMachineName());
	}

	@Test(dependsOnMethods = { "initialisation" })
	public void startSearch() {
		CometServiceLocatorMocker.mock();
		Broadcaster broadCasterMock = CometServiceLocatorMocker.getMockObject();
		String customerNumber = "987654321";
		StateMachine customerSearchSM = (StateMachine) this.applicationContext
				.getBean("CustomerSearchSM");

		customerSearchSM.resetStateMachine();
		Assert.assertNotNull(customerSearchSM);
		Assert.assertEquals(StateMachineEnumerationImpl.CustomerSearchSM
				.getStateMachineName(), customerSearchSM.giveActualState()
				.getName().getStateMachineName().getStateMachineName());

		Assert.assertEquals(
				CustomerSearchSM_StateEnumerationImpl.WAITING_CUSTOMERSEARCH_START,
				customerSearchSM.giveActualState().getName());
		Assert.assertEquals(Boolean.TRUE,
				((CustomerSearchInputCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchRunningCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchAuthenticationCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchFoundCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchJoinCO) customerSearchSM.getControlObject())
						.getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrderLoading());

		CustomerSearchStartEventPayload customerSearchStartEventPayload = new CustomerSearchStartEventPayload();
		Event onSearchStartEvent = new Event();
		onSearchStartEvent
				.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);
		customerSearchStartEventPayload.setCustomerNumber(customerNumber);
		onSearchStartEvent.setPayload(customerSearchStartEventPayload);

		CustomerManager customerManager = (CustomerManager) this.applicationContext
				.getBean("customerManager");
		customerManager.findCustomer(anyObject(String.class),
				anyObject(StateMachine.class));
		EasyMock.replay(customerManager);
		customerSearchSM.handleEvent(onSearchStartEvent);
		EasyMock.verify(customerManager);

		Assert.assertEquals(
				CustomerSearchSM_StateEnumerationImpl.CUSTOMERSEARCH_RUNNING,
				customerSearchSM.giveActualState().getName());
		Assert.assertEquals(customerNumber,
				((CustomerSearchCO) customerSearchSM.getControlObject())
						.getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchInputCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.TRUE,
				((CustomerSearchRunningCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchAuthenticationCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchFoundCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchJoinCO) customerSearchSM.getControlObject())
						.getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrderLoading());

		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);
		customer.setFirstName("Dirk");
		customer.setLastName("Pitt");

		Event customerFoundEvent = new Event();
		customerFoundEvent.setPayload(customer);
		customerFoundEvent.setSource(this);
		customerFoundEvent
				.setEventType(FindCustomerSM_EventEnumerationImpl.onCustomerFound);
		EasyMock.replay(broadCasterMock);
		((CustomerSearchSMControlObject) customerSearchSM.getControlObject())
				.getFindCustomerSlaveSM().handleEvent(customerFoundEvent);
		EasyMock.verify(broadCasterMock);

		Assert.assertEquals(
				CustomerSearchSM_StateEnumerationImpl.CUSTOMER_FOUND,
				customerSearchSM.giveActualState().getName());
		Assert.assertEquals(
				CustomerSearchSM_StateEnumerationImpl.CUSTOMERSEARCH_RUNNING,
				customerSearchSM.giveActualState().getName());
		Assert.assertEquals(customerNumber,
				((CustomerSearchCO) customerSearchSM.getControlObject())
						.getCustomerNumber());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchInputCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchInput());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchRunningCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchRunning());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchAuthenticationCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchAuthentication());
		Assert.assertEquals(Boolean.TRUE,
				((CustomerSearchFoundCO) customerSearchSM.getControlObject())
						.getRenderCustomerSearchFound());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchJoinCO) customerSearchSM.getControlObject())
						.getRenderCustomerJoin());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrders());
		Assert.assertEquals(Boolean.FALSE,
				((CustomerSearchOrderCO) customerSearchSM.getControlObject())
						.getRenderCustomerOrderLoading());
		
	}

}
