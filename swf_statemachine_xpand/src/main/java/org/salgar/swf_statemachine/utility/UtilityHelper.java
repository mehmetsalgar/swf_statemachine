package org.salgar.swf_statemachine.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;

public class UtilityHelper {
	private static final Logger log = Logger.getLogger(UtilityHelper.class);
	private final static String[] filter = { "\\", "/" };
	private final static String replacement = "_";

	@SuppressWarnings("unchecked")
	public static List<NamedElement> eventEnumerations(List events) {
		// System.out.println(events.getClass().toString());
		HashMap map = new HashMap();

		for (Object event : events) {
			NamedElement trigger = (NamedElement) event;
			// System.out.println(events.toString());
			map.put(trigger.getName(), event);
		}

		List result = new ArrayList();

		for (Object object : map.keySet()) {
			result.add(filterUnwantedCharacters((String) object));
		}

		return result;
	}

	public static List<State> uniqueStateNames(List<State> states) {
		// System.out.println(events.getClass().toString());
		HashMap<String, State> map = new HashMap<String, State>();

		for (State state : states) {
			map.put(state.getName(), state);
		}

		List<State> result = new ArrayList<State>();

		for (State state : map.values()) {
			result.add(state);
		}
		
		return result;
	}

	public static String filterUnwantedCharacters(String textToFilter) {
		StringBuilder tmp = new StringBuilder(textToFilter);
		for (int i = 0, n = filter.length; i < n; i++) {
			int len = tmp.indexOf(filter[i]);
			if (len != -1) {
				tmp.replace(len, len + 1, replacement);
			}
		}

		return tmp.toString();
	}

	public static String createTransitionName(Transition transition) {
		return getTransitionName(transition) + getTransitionGuard(transition);
	}

	private static String getTransitionGuard(Transition transition) {
		return transition.getGuard() != null ? transition.getGuard()
				.getSpecification().stringValue() : "";
	}

	private static String getTransitionName(Transition transition) {
		int startIndex = transition.getName().indexOf(" [") + 1;
		int endIndex = transition.getName().indexOf("]");
		String transitionSource = transition.getName().substring(
				startIndex + 1, endIndex);

		int targetStartIndex = transition.getName().indexOf("> [") + 2;
		int targetEndIndex = transition.getName().indexOf("]]");

		String transitionTarget = transition.getName().substring(
				targetStartIndex + 1, targetEndIndex);
		String firstLetter = transitionTarget.substring(0, 1);
		Trigger trigger = null;
		if (transition.getTriggers() != null) {
			if (transition.getTriggers().size() > 0) {
				trigger = transition.getTriggers().get(0);
			}
		}

		return transitionSource.toLowerCase()
				+ "To"
				+ firstLetter
				+ transitionTarget.substring(1, transitionTarget.length())
						.toLowerCase()
				+ (trigger != null ? filterUnwantedCharacters(trigger.getName())
						: "");
	}

	public static List<Transition> findOutgoingTransitions(
			List<Transition> transitions, String state) {
		System.out.println("We are here! : " + transitions.toString());
		List<Transition> result = new ArrayList<Transition>();
		for (Transition transition : transitions) {

			int startIndex = transition.getName().indexOf(" [") + 1;
			int endIndex = transition.getName().indexOf("]");

			// System.out.println("startIndex" + startIndex);
			// System.out.println("endIndex" + endIndex);

			String startState = transition.getName().substring(startIndex + 1,
					endIndex);
			// System.out.println(startState);
			if (state.equals(startState)) {
				result.add(transition);
			}
		}

		return result;
	}

	public static String findSourceState(Transition transition) {
		int startIndex = transition.getName().indexOf(" [") + 1;
		int endIndex = transition.getName().indexOf("]");

		String startState = transition.getName().substring(startIndex + 1,
				endIndex);

		return startState;
	}

	public static String findTargetState(Transition transition) {
		int targetStartIndex = transition.getName().indexOf("> [") + 2;
		int targetEndIndex = transition.getName().indexOf("]]");

		String transitionTarget = transition.getName().substring(
				targetStartIndex + 1, targetEndIndex);

		return transitionTarget;
	}

	public static String givePackageName(org.eclipse.uml2.uml.Package ackage) {
		List<String> packages = new ArrayList<String>();
		org.eclipse.uml2.uml.Package tmpPackage = null;
		if (ackage.getNestingPackage() != null) {
			packages.add(ackage.getName());
			tmpPackage = ackage;
		} else {
			return "";
		}

		while ((tmpPackage = internalPackageName(tmpPackage)) != null) {
			packages.add(tmpPackage.getName());
		}

		StringBuilder sb = new StringBuilder(25);
		for (int n = packages.size(); n > 0; n--) {
			sb.append(packages.get(n - 1));
			sb.append(".");
		}

		return sb.toString();
	}

	private static org.eclipse.uml2.uml.Package internalPackageName(
			org.eclipse.uml2.uml.Package intern) {
		if (intern.getNestingPackage() != null) {
			if (intern.getNestingPackage().getNestingPackage() == null) {
				return null;
			}
			return intern.getNestingPackage();
		}
		return null;
	}

	public static State findIntialState(List<Pseudostate> pseudoStates) {
		State result = null;
		for (Pseudostate pseudostate : pseudoStates) {
			for (Transition transition : pseudostate.getOutgoings()) {
				result = (State) transition.getTarget();
				break;
			}
			break;
		}
		return result;
	}

	public static boolean isInitialState(State state) {
		boolean result = false;

		if (state.getClass().equals(Pseudostate.class)) {
			result = true;
		}

		return result;
	}

	public static String getFileName(String packageName) {
		log.info("Package Name: " + packageName);
		String[] packages = packageName.split("\\.");

		StringBuilder sb = new StringBuilder();
		int limit = packages.length - 1;
		log.info("Package lenght: " + limit);
		for (int i = 0; i < packages.length; i++) {
			String _package = packages[i];

			if (i < limit) {
				sb.append(_package);
				sb.append("/");
			} else {
				sb.append(_package);
				sb.append(".java");
			}
		}

		String className = sb.toString();

		log.info("Class Name: " + className);
		return className;
	}

	public static String getPackageName(String packageName) {
		log.info("Package Name: " + packageName);
		String[] packages = packageName.split("\\.");

		StringBuilder sb = new StringBuilder();
		int limit = packages.length - 2;
		log.info("Package lenght: " + limit);
		for (int i = 0; i < packages.length - 1; i++) {
			String _package = packages[i];

			if (i < limit) {
				sb.append(_package);
				sb.append(".");
			} else {
				sb.append(_package);
			}
		}

		String className = sb.toString();

		log.info("Package_Name: " + className);
		return className;
	}

	public static String getClassName(String packageName) {
		log.info("Package Name: " + packageName);
		String[] packages = packageName.split("\\.");

		StringBuilder sb = new StringBuilder();
		int limit = packages.length - 1;
		log.info("Package lenght: " + limit);
		for (int i = 0; i < packages.length; i++) {
			String _package = packages[i];

			if (i < limit) {
			} else {
				sb.append(_package);
			}
		}

		String className = sb.toString();

		log.info("Class_Name: " + className);
		return className;
	}

	public static List<Trigger> giveTriggers(Transition transition) {
		Map<String, Trigger> triggers = new HashMap<String, Trigger>();
		
		for (Trigger trigger : transition.getTriggers()) {
			triggers.put(trigger.getName(), trigger);
		}

		return new ArrayList<Trigger>(triggers.values());
	}

	public static List<Trigger> giveTransitionWithTrigger(
			List<Transition> transitions) {
		Map<String, Trigger> result = new HashMap<String, Trigger>();

		for (Transition transition : transitions) {
			if (transition.getTriggers() != null
					&& !transition.getTriggers().isEmpty()) {
				for (Trigger trigger : transition.getTriggers()) {
					result.put(trigger.getName(), trigger);
				}				
			}
		}

		return new ArrayList<Trigger>(result.values());
	}
}
