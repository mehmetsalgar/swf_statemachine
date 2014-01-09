package org.salgar.swf_statemachine.enumeration.state;

import org.salgar.statemachine.domain.StateEnumeration;
import org.salgar.statemachine.domain.StateMachineEnumeration;
import org.salgar.swf_statemachine.enumeration.InitialTestStateMachineEnumeration;

public enum Intial2StateEnumeration implements StateEnumeration {
	STATE_5("state_5", InitialTestStateMachineEnumeration.STATE_MACHINE_2), STATE_6(
			"state_6", InitialTestStateMachineEnumeration.STATE_MACHINE_2);

	private String stateName;
	private StateMachineEnumeration stateMachineEnumeration;

	Intial2StateEnumeration(String stateName,
			StateMachineEnumeration stateMachineEnumeration) {
		this.stateName = stateName;
		this.stateMachineEnumeration = stateMachineEnumeration;
	}

	public String getStateName() {
		return this.stateName;
	}

	public StateMachineEnumeration getStateMachineName() {
		return this.stateMachineEnumeration;
	}

}
