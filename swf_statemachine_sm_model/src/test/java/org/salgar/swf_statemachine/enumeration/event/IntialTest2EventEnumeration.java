package org.salgar.swf_statemachine.enumeration.event;

import org.salgar.statemachine.domain.EventEnumeration;
import org.salgar.statemachine.domain.StateMachineEnumeration;
import org.salgar.swf_statemachine.enumeration.InitialTestStateMachineEnumeration;

public enum IntialTest2EventEnumeration implements EventEnumeration {
	EVENT_2("event_2", InitialTestStateMachineEnumeration.STATE_MACHINE_2);

	private String eventName;
	private StateMachineEnumeration stateMachineEnumeration;

	IntialTest2EventEnumeration(String eventName,
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
