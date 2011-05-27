package org.salgar.swf_statemachine.customersearch;

import junit.framework.Assert;

import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchInputCO;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchRunningCO;
import org.salgar.swf_statemachine.enumeration.StateMachineEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {
		"/META-INF/scope.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch-guards.xml",
		"/META-INF/customersearch/applicationContext-statemachine-customersearch-controlobjects.xml" })
public class CustomerSearchStateMachineTest extends
		AbstractTestNGSpringContextTests {

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

		Event onSearchStartEvent = new Event();
		onSearchStartEvent
				.setEventType(CustomerSearchSM_EventEnumerationImpl.onStartSearch);
		onSearchStartEvent.setPayload(customerNumber);

		customerSearchSM.handleEvent(onSearchStartEvent);

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

	}
}
