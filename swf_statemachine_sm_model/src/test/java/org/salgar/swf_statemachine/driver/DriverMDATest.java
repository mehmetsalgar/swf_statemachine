package org.salgar.swf_statemachine.driver;


import org.salgar.swf_statemachine.enumeration.event.statemachine_1.STATEMACHINE_1_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.statemachine_2.STATEMACHINE_2_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.STATEMACHINE_1_StateEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.STATEMACHINE_2_StateEnumerationImpl;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "/META-INF/scope.xml",
		"/META-INF/reference_model/applicationContext-statemachine-reference_model.xml", 
		"/META-INF/reference_model/applicationContext-statemachine-reference_model-guards.xml",
		"/META-INF/reference_model/applicationContext-statemachine-reference_model-controlobjects.xml" })
@Test( groups = "MDA")
public class DriverMDATest extends DriverTest {
	public DriverMDATest() {
		this.EVENT1 = STATEMACHINE_1_EventEnumerationImpl.EVENT_1;
		this.EVENT2 = STATEMACHINE_1_EventEnumerationImpl.EVENT_2;
		this.EVENT3 = STATEMACHINE_1_EventEnumerationImpl.EVENT_3;
		this.EVENT2_SM2 = STATEMACHINE_2_EventEnumerationImpl.EVENT_2;

		this.STATE1 = STATEMACHINE_1_StateEnumerationImpl.STATE_1;
		this.STATE2 = STATEMACHINE_1_StateEnumerationImpl.STATE_2;
		this.STATE3 = STATEMACHINE_1_StateEnumerationImpl.STATE_3;
		this.STATE4 = STATEMACHINE_1_StateEnumerationImpl.STATE_4;

		this.STATE5 = STATEMACHINE_2_StateEnumerationImpl.STATE_5;
		this.STATE6 = STATEMACHINE_2_StateEnumerationImpl.STATE_6;

		this.STATE5_SUB = STATEMACHINE_1_StateEnumerationImpl.STATE_5;
		this.STATE6_SUB = STATEMACHINE_1_StateEnumerationImpl.STATE_6;
	}

	@Override
	public void stateMachine2_event2() {
		// Because of the SteoroType STATEMACHINE_2 is not generated
	}

	@Override
	public void stateMachine2_wrongEvent() {
		// Because of the SteoroType STATEMACHINE_2 is not generated
	}
}
