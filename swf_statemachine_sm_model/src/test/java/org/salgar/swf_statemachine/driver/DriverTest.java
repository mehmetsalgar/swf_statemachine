package org.salgar.swf_statemachine.driver;

import junit.framework.Assert;

import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.EventEnumeration;
import org.salgar.statemachine.domain.StateEnumeration;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.enumeration.InitialTestStateMachineEnumeration;
import org.salgar.swf_statemachine.reference_model.controlobject.STATEMACHINE_1ControlObject;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


public abstract class DriverTest extends AbstractTestNGSpringContextTests {
	protected EventEnumeration EVENT1;
	protected EventEnumeration EVENT2;
	protected EventEnumeration EVENT2_SM2;
	protected EventEnumeration EVENT3;
	
	protected StateEnumeration STATE1;
	protected StateEnumeration STATE2;
	protected StateEnumeration STATE3;
	protected StateEnumeration STATE4;
	protected StateEnumeration STATE5;
	protected StateEnumeration STATE6;
	protected StateEnumeration STATE5_SUB;
	protected StateEnumeration STATE6_SUB;
		
	@Test
	public void initialisation() {
		;
		StateMachine stateMachine1 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_1");
		stateMachine1.resetStateMachine();
		Assert.assertNotNull(stateMachine1);
		Assert.assertEquals(InitialTestStateMachineEnumeration.STATE_MACHINE_1.getStateMachineName(), stateMachine1
				.giveActualState().getName().getStateMachineName().getStateMachineName());
	}

	@Test(dependsOnMethods = { "initialisation" })
	public void event1() {
		StateMachine stateMachine1 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_1");
		Assert.assertNotNull(stateMachine1);

		stateMachine1.resetStateMachine();

		Event event1 = new Event();
		event1.setEventType(EVENT1);
		event1.setPayload("987654321");

		stateMachine1.handleEvent(event1);

		Assert.assertEquals(STATE2, stateMachine1
				.giveActualState().getName());
		STATEMACHINE_1ControlObject controlObject = (STATEMACHINE_1ControlObject) stateMachine1.getControlObject();
		Assert.assertEquals("987654321", controlObject.getCustomerNumber());
	}

	@Test(dependsOnMethods = { "event1" })
	public void event2bBeforeEvent1() {
		StateMachine stateMachine1 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_1");
		Assert.assertNotNull(stateMachine1);

		stateMachine1.resetStateMachine();

		Event event2 = new Event();
		event2.setEventType(EVENT2);
		event2.setPayload(null);

		try {
			stateMachine1.handleEvent(event2);
			Assert.fail("We should receive an Exception here for invalid transition!");
		} catch (Throwable t) {
			// Test is working correctly
		}
	}

	@Test(dependsOnMethods = { "event2bBeforeEvent1" })
	public void event2() {
		StateMachine stateMachine1 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_1");
		Assert.assertNotNull(stateMachine1);

		stateMachine1.resetStateMachine();

		Event event1 = new Event();
		event1.setEventType(EVENT1);
		event1.setPayload("987654321");

		stateMachine1.handleEvent(event1);
		
		Assert.assertEquals(STATE2, stateMachine1
				.giveActualState().getName());
		STATEMACHINE_1ControlObject controlObject = (STATEMACHINE_1ControlObject) stateMachine1.getControlObject();
		Assert.assertEquals("987654321", controlObject.getCustomerNumber());

		Event event2 = new Event();
		event2.setEventType(EVENT2);
		event2.setPayload(null);

		stateMachine1.handleEvent(event2);
		Assert.assertEquals(STATE2, stateMachine1
				.giveActualState().getName());
		Assert.assertEquals(STATE6.getStateName(), stateMachine1
				.giveActualState().getSubMachine().giveActualState().getName().getStateName());
	}

	@Test(dependsOnMethods = { "event2" })
	public void event3() {
		StateMachine stateMachine1 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_1");
		Assert.assertNotNull(stateMachine1);

		stateMachine1.resetStateMachine();

		Event event1 = new Event();
		event1.setEventType(EVENT1);
		event1.setPayload(null);

		stateMachine1.handleEvent(event1);

		Event event2 = new Event();
		event2.setEventType(EVENT3);
		event2.setPayload(null);

		stateMachine1.handleEvent(event2);
		Assert.assertEquals(STATE4, stateMachine1
				.giveActualState().getName());
	}

	@Test
	public void stateMachine2_event2() {
		StateMachine stateMachine2 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_2");

		Assert.assertNotNull(stateMachine2);

		stateMachine2.resetStateMachine();

		Event event1 = new Event();
		event1.setEventType(EVENT2_SM2);
		event1.setPayload(null);

		stateMachine2.handleEvent(event1);
		Assert.assertEquals(STATE6, stateMachine2
				.giveActualState().getName());
	}

	@Test(dependsOnMethods = { "stateMachine2_event2" })
	public void stateMachine2_wrongEvent() {
		StateMachine stateMachine2 = (StateMachine) this.applicationContext
				.getBean("STATEMACHINE_2");

		Assert.assertNotNull(stateMachine2);

		stateMachine2.resetStateMachine();

		Event event1 = new Event();
		event1.setEventType(EVENT2);
		event1.setPayload(null);

		try {
			stateMachine2.handleEvent(event1);
			Assert.fail("We are sending the wrong event, that should not work!");
		} catch (Exception e) {
		}

	}
}

