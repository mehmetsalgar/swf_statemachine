package org.salgar.swf_statemachine.enumeration.event;

import org.salgar.statemachine.domain.EventEnumeration;
import org.salgar.statemachine.domain.StateMachineEnumeration;
import org.salgar.swf_statemachine.enumeration.InitialTestStateMachineEnumeration;

public enum IntialTestEventEnumeration implements EventEnumeration {
	EVENT_1("event_1", InitialTestStateMachineEnumeration.STATE_MACHINE_1), EVENT_2(
			"event_2", InitialTestStateMachineEnumeration.STATE_MACHINE_1), EVENT_3(
			"event_3", InitialTestStateMachineEnumeration.STATE_MACHINE_1);

	private String eventName;
	private StateMachineEnumeration stateMachineEnumeration;

	IntialTestEventEnumeration(String eventName,
			StateMachineEnumeration stateMachineEnumeration) {
		this.eventName = eventName;
		this.stateMachineEnumeration = stateMachineEnumeration;
	}

	public StateMachineEnumeration getStatemachineName() {
		return this.stateMachineEnumeration;
	}

	public String getEventName() {
		return this.eventName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("eventName: ");
		sb.append(this.eventName);
		sb.append(" stateMachine: ");
		sb.append(this.stateMachineEnumeration.getStateMachineName());
		return sb.toString();
	}
}
