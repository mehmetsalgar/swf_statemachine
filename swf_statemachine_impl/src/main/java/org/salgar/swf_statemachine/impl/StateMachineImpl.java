package org.salgar.swf_statemachine.impl;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.salgar.statemachine.domain.AbstractStateMachine;
import org.salgar.statemachine.domain.Action;
import org.salgar.statemachine.domain.ControlObject;
import org.salgar.statemachine.domain.Event;
import org.salgar.statemachine.domain.State;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.statemachine.domain.Transition;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StateMachineImpl extends AbstractStateMachine implements
		ApplicationContextAware {
	private static final long serialVersionUID = 6254025866540535100L;
	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(StateMachineImpl.class);

	protected ApplicationContext applicationContext;

	@SuppressWarnings("rawtypes")
	public StateMachineImpl() {
		this.controlObjects = new HashMap();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException(getName()
					+ ": Event can't be null!");
		}

		if (log.isDebugEnabled()) {
			log.debug("State Machine: " + this.getName().getStateMachineName()
					+ " received the Event: "
					+ event.getEventType().getEventName());
		}

		boolean working = false;
		synchronized (eventQueue) {
			if (log.isDebugEnabled()) {
				log.debug("Adding the Event to Statemachine: "
						+ this.getName().getStateMachineName() + " Queue!");
			}
			eventQueue.add(event);
			if (log.isDebugEnabled()) {
				log.debug("Event is Statemachine: "
						+ this.getName().getStateMachineName()
						+ " Queue added!");
			}
			if (inTransition == true) {
				if (log.isDebugEnabled()) {
					log.debug("Statemachine: "
							+ this.getName().getStateMachineName()
							+ " is in transition we are living the event in the Queue and exiting!");
				}
				return;
			}
			inTransition = true;
			working = true;
			if (log.isDebugEnabled()) {
				log.debug("Statemachine: "
						+ this.getName().getStateMachineName()
						+ " is switched to in Transition Mode!");
			}
		}

		while (working) {
			try {
				if (log.isDebugEnabled()) {
					log.debug("Statemachine: "
							+ this.getName().getStateMachineName()
							+ " processing Events!");
				}
				handleEventRecursive();
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				if (eventQueue.isEmpty() == false) {
					// If an exception happened while the Event Queue is not
					// empty Statemachine
					// in finally method will further process the event and the
					// exception
					// message would be lost, so we are logging it here					
				} else {
					if (t instanceof RuntimeException) {
						throw (RuntimeException) t;
					} else {
						throw new RuntimeException(t);
					}
				}
			} finally {
				synchronized (eventQueue) {
					if (eventQueue.isEmpty()) {
						inTransition = false;
						working = false;
						if (log.isDebugEnabled()) {
							log.debug("Statemachine: "
									+ this.getName().getStateMachineName()
									+ " Event Queue is empty, we are going out from Transition Mode!");
						}
					}
				}
			}
		}
	}

	private void handleEventRecursive() {
		Event eventInQueue = null;
		while ((eventInQueue = (Event) eventQueue.poll()) != null) {
			if (log.isDebugEnabled()) {
				log.debug("We have Events in Statemachine: "
						+ this.getName().getStateMachineName()
						+ " Queue, we are processing them!");
			}
			boolean eventHandled = handleEventInternal(eventInQueue);

			if (eventHandled == false) {
				throw new IllegalStateException(
						getName()
								+ ": We are not finding any transtion for this event type in this state in State Machine: "
								+ this.getName().getStateMachineName()
								+ "! State: "
								+ getActualState().getName()
								+ " Event Type: "
								+ eventInQueue.getEventType().getEventName()
								+ " or the guard conditions are not letting us to run!");
			}
		}
	}

	private boolean handleEventInternal(Event event) {
		boolean eventHandled = false;

		if (this.getActualState().getSubMachine() != null) {
			AbstractStateMachine subStateMachine = (AbstractStateMachine) this
					.getActualState().getSubMachine();

			if (subStateMachine != null) {
				eventHandled = subStateMachine.dispatch(event);

				if (eventHandled == true) {
					return true;
				}
			}
		}

		// for (Transition transition :
		// configureDynamicTransitions(getActualState().getOutgoingTransitions()))
		// {
		// for (Transition transition :
		// configureDynamicTransitions(getActualState())) {
		// is for a future version
		for (Transition transition : getActualState().getOutgoingTransitions()) {
			if (event.getEventType().equals(transition.getEventType())) {
				if (log.isDebugEnabled()) {
					log.debug("For the State Machine: "
							+ this.getName().getStateMachineName()
							+ " We found the transition: "
							+ transition.getName() + " for event: "
							+ transition.getEventType().getEventName());
				}
				if (transition.evaluateGuard(event, this)) {
					transition.processAction(event, this);

					// As convention we are accepting that the local transitions
					// and internal transition are not causing the exit and
					// entry actions to
					// run that differs from the actual UML Notations
					// consequences are
					// open to discussion
					if (this.getActualState().equals(
							transition.getTargetState()) == false) {
						if (this.getActualState().getExitAction() != null) {
							processExitAction(this.getActualState(), event);
						}
					}

					setCurrentState(transition.getTargetState());

					// Please look to the above commentary
					if (this.getActualState().equals(
							transition.getTargetState()) == false) {
						if (transition.getTargetState().getEntryAction() != null) {
							processAction(transition.getTargetState()
									.getEntryAction(), event);
						}
					}

					return true;
				} else {
					if (log.isDebugEnabled()) {
						log.debug("Guard condition "
								+ transition.getGuard().getClass().toString()
								+ " for the transition: "
								+ transition.getName()
								+ " not letting us to execute the transition for State Machine: "
								+ this.getName().getStateMachineName() + " !");
					}
				}
			}
		}
		log.error(getName()
				+ ": We are not finding any transtion for this event type in this state! State: "
				+ getActualState().getName()
				+ " Event Type: "
				+ event.getEventType().getEventName()
				+ " the event is for the statemachine: "
				+ event.getEventType().getStatemachineName()
				+ " and we are at the statemachine: "
				+ this.getName().getStateMachineName()
				+ " or the guard conditions are not letting us to execute the transition!");

		return false;
		// throw new IllegalStateException(name
		// +
		// ": We are not finding any transtion for this event type in this state! State: "
		// + getActualState().getName() + " Event Type: " +
		// tvppEvent.getEventType().getName()
		// + " or the guard conditions are not letting us to run!");

	}

	/*
	 * In statemachine theory if a Parent statemachine passing the event
	 * (control) to submachine lying inside of a state, it is better not to use
	 * eventQueue because of possible thread locks. For this case, parent
	 * statemachine dispatch the event to the submachine by by-passing the
	 * eventQueue....
	 */
	public boolean dispatch(Event event) {
		boolean eventHandled = handleEventInternal(event);
		return eventHandled;
	}

	private void setCurrentState(State targetState)

	{
		// If we have a completely new Transition, at this point actually this
		// Transtion should
		// inserted into this collection, so no exception would be produced....
		boolean found = false;
		for (Transition transition : targetState.getIncomingTransitions()) {
			if (transition.getSourceState().equals(this.getActualState())) {
				found = true;
				break;
			}
		}

		if (found == false) {
			throw new IllegalStateException(
					getName()
							+ ": Target State is not accepting a transtion from current state. Target State: "
							+ targetState.getName() + " CurrentState: "
							+ this.getActualState().getName());
		}

		if (log.isDebugEnabled()) {
			log.debug(getName() + ": State Machine switching from State: "
					+ this.getActualState().getName() + " to State: "
					+ targetState.getName());
		}

		this.setActualState(targetState);

		// State Machine returning to its Initial State we have to reset
		if (this.getStartState().getName()
				.equals(this.getActualState().getName())) {
			resetStateMachine();
		}
	}

	/**
	 * In the case of there are Sub Machines there states must be also exited
	 */
	private void processExitAction(State actualState, Event event) {
		if (actualState.getSubMachine() != null) {
			AbstractStateMachine subStateMachine = (AbstractStateMachine) actualState
					.getSubMachine();

			if (subStateMachine != null) {
				processExitAction(subStateMachine.getActualState(), event);
			}
		}
		if (actualState.getExitAction() != null) {
			processAction(actualState.getExitAction(), event);
		}
	}

	private void processAction(Action action, Event event) {
		try {
			action.processAction(event, this);
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
	}

	@Override
	public void resetStateMachine() {
		try {
			initializeStateMachine();

			for (State state : this.getExistingStates()) {
				if (state.getSubMachine() != null) {
					StateMachine subStateMachine = (StateMachine) state
							.getSubMachine();
					if (subStateMachine != null) {
						subStateMachine.resetStateMachine();
					} else {
						log.warn("State configuration indicates that we should have a SubMachine but it is not in the SubMachine map in the context!"
								.intern());
					}
				}
			}

			// for (Object object :
			// stateMachineContext.getSubMachines().values()) {
			// de.tmobile.tvpp.statemachine.domain.IStateMachine stateMachine =
			// (de.tmobile.tvpp.statemachine.domain.IStateMachine) object;
			// if (stateMachine.equals(this) == false) {
			// stateMachine.resetStateMachine();
			// }
			// }

			this.setActualState(this.getStartState());
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
	}

	@SuppressWarnings("rawtypes")
	private void initializeStateMachine() {
		this.eventQueue = new ConcurrentLinkedQueue();
		this.inTransition = Boolean.FALSE;

		for (Object object : this.getControlObjects().values()) {
			ControlObject controlObject = (ControlObject) object;

			controlObject.resetStateMachine();
		}
	}

	@Override
	public State giveActualState() {
		return getActualState();
	}

	@Override
	public ControlObject getControlObject() {
		ControlObject controlObject = (ControlObject) this.getControlObjects()
				.get(this.getName().getStateMachineName() + "ControlObject");
		return controlObject;
	}

	@Override
	public Object findObjects(String objectName) {
		Object obj = applicationContext.getBean(objectName);

		return obj;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
