package org.salgar.swf_statemachine.enumeration.state;

import org.salgar.statemachine.domain.StateEnumeration;
import org.salgar.statemachine.domain.StateMachineEnumeration;
import org.salgar.swf_statemachine.enumeration.InitialTestStateMachineEnumeration;

public enum IntialStateEnumeration implements StateEnumeration {
	STATE_1("state_1", InitialTestStateMachineEnumeration.STATE_MACHINE_1), STATE_2(
			"state_2", InitialTestStateMachineEnumeration.STATE_MACHINE_1), STATE_3(
			"state_3", InitialTestStateMachineEnumeration.STATE_MACHINE_1), STATE_4(
			"state_4", InitialTestStateMachineEnumeration.STATE_MACHINE_1), STATE_5(
			"state_5", InitialTestStateMachineEnumeration.STATE_MACHINE_1), STATE_6(
			"state_6", InitialTestStateMachineEnumeration.STATE_MACHINE_1);

	private String stateName;
	private StateMachineEnumeration stateMachineEnumeration;

	IntialStateEnumeration(String stateName,
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("stateName: ");
		sb.append(this.stateName);
		sb.append(" stateMachine: ");
		sb.append(this.stateMachineEnumeration.getStateMachineName());

		return sb.toString();
	}
}
