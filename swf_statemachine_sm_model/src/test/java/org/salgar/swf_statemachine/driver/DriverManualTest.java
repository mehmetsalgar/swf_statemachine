package org.salgar.swf_statemachine.driver;

import org.salgar.swf_statemachine.enumeration.event.IntialTest2EventEnumeration;
import org.salgar.swf_statemachine.enumeration.event.IntialTestEventEnumeration;
import org.salgar.swf_statemachine.enumeration.state.Intial2StateEnumeration;
import org.salgar.swf_statemachine.enumeration.state.IntialStateEnumeration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "/META-INF/scope.xml",
		"/META-INF/applicationContext-test.xml",
		"/META-INF/applicationContext-test-guards.xml",
		"/META-INF/applicationContext-test-controlobjects.xml" })
public class DriverManualTest extends DriverTest {
	public DriverManualTest() {
		this.EVENT1 = IntialTestEventEnumeration.EVENT_1;
		this.EVENT2 = IntialTestEventEnumeration.EVENT_2;
		this.EVENT3 = IntialTestEventEnumeration.EVENT_3;
		this.EVENT2_SM2 = IntialTest2EventEnumeration.EVENT_2;

		this.STATE1 = IntialStateEnumeration.STATE_1;
		this.STATE2 = IntialStateEnumeration.STATE_2;
		this.STATE3 = IntialStateEnumeration.STATE_3;
		this.STATE4 = IntialStateEnumeration.STATE_4;

		this.STATE5 = Intial2StateEnumeration.STATE_5;
		this.STATE6 = Intial2StateEnumeration.STATE_6;

		this.STATE5_SUB = IntialStateEnumeration.STATE_5;
		this.STATE6_SUB = IntialStateEnumeration.STATE_6;
	}
}
