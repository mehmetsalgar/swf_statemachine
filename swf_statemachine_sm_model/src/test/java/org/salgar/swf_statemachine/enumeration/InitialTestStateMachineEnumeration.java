package org.salgar.swf_statemachine.enumeration;

import org.salgar.statemachine.domain.StateMachineEnumeration;

public enum InitialTestStateMachineEnumeration implements
		StateMachineEnumeration {
	STATE_MACHINE_1("statemachine_1"), STATE_MACHINE_2("statemachine_2"), STATE_MACHINE_3(
			"statemachine_3");

	private String name;

	InitialTestStateMachineEnumeration(String name) {
		this.name = name;
	}

	public String getStateMachineName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
