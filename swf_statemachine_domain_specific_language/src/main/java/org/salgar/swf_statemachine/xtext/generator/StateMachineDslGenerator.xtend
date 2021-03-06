/*
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.salgar.swf_statemachine.xtext.stateMachineDsl.PackageDeclaration
import org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine
import org.salgar.swf_statemachine.xtext.stateMachineDsl.Event
import org.salgar.swf_statemachine.xtext.stateMachineDsl.State
import org.salgar.swf_statemachine.xtext.stateMachineDsl.Transition
import org.salgar.swf_statemachine.xtext.stateMachineDsl.SimpleType
import org.salgar.swf_statemachine.xtext.stateMachineDsl.ObjectType


import org.eclipse.xtext.naming.IQualifiedNameProvider

import com.google.inject.Inject

import org.apache.commons.lang3.text.WordUtils;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class StateMachineDslGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile(resource.getAllContents.findFirst(object | object instanceof PackageDeclaration).fullyQualifiedName.toString("/") + "/enumeration/StateMachineEnumerationImpl.java",
			resource.allContents.toIterable.filter(StateMachine).complileStateMachineEnumeration(resource.getAllContents.findFirst(object | object instanceof PackageDeclaration) as PackageDeclaration))

		for(e : resource.allContents.toIterable.filter(StateMachine)) {
			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase + "/enumeration/state/" + e.name + "_StateEnumerationImpl.java",
			e.eAllContents.toIterable.filter(State).compileState(e))

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase + "/enumeration/event/" + e.name + "_EventEnumerationImpl.java",
			e.eAllContents.toIterable.filter(Event).compileEvent(e))

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + e.name + "ControlObjectLocator.java",
			e.compileControlObjectLocator)

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + e.name + "GuardContainer.java",
			e.compileGuardContainer)

			for(state : e.states) {
				for(transition : state.transitions) {
					if(transition.guard != null) {
						fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + state.name.toLowerCase() + "/guard/" + state.name + "___" + transition.target.name + "_" + transition.name + "_" + transition.guard.name + "_guard.java",
						e.compileGuard(state, transition))
					}
					if(transition.action != null) {
						fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + state.name.toLowerCase() + "/action/" + state.name + "___" + transition.target.name + "_" + transition.name + "_" + transition.action.name + "_action.java",
						e.compileAction(state, transition))
					}
				}
			}

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + e.name + "ActionContainer.java",
			e.compileActionContainer)

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/controlobject/Abstract" + e.name + "ControlObject.java",
			e.compileControlObject)

			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/" + e.name.toLowerCase() + "/configuration/" + e.name + "Configuration.java",
			e.compileStateMachine)
		}
	}

	def complileStateMachineEnumeration(Iterable<StateMachine> e, PackageDeclaration p) '''
		package «p.fullyQualifiedName».enumeration;

		import org.salgar.statemachine.domain.StateMachineEnumeration;

		public enum StateMachineEnumerationImpl implements StateMachineEnumeration {
		    «FOR statemachine : e SEPARATOR ','»
				«statemachine.name»("«statemachine.name»")
			«ENDFOR»;

			private String name;

			StateMachineEnumerationImpl(String name) {
			this.name = name;
			}

			@Override
			public String getStateMachineName() {
				return this.name;
			}

			@Override
			public String toString() {
				return this.name;
			}
		}
	'''

	def compileState(Iterable<State> e, StateMachine s) '''
		package «s.eContainer.fullyQualifiedName».«s.name.toLowerCase()».enumeration.state;

		import org.salgar.statemachine.domain.StateEnumeration;
		import org.salgar.statemachine.domain.StateMachineEnumeration;
		import «s.eContainer.fullyQualifiedName».enumeration.StateMachineEnumerationImpl;

		public enum «s.name»_StateEnumerationImpl implements StateEnumeration {

			«FOR state : e SEPARATOR ','»
				«state.name»("«state.name.toLowerCase»", StateMachineEnumerationImpl.«s.name»)
			«ENDFOR»;

			private String stateName;
			private StateMachineEnumeration stateMachineEnumeration;

			«s.name»_StateEnumerationImpl(String stateName, StateMachineEnumeration stateMachineEnumeration) {
				this.stateName = stateName;
				this.stateMachineEnumeration = stateMachineEnumeration;
			}

			public StateMachineEnumeration getStateMachineName() {
				return this.stateMachineEnumeration;
			}

			public String getStateName() {
				return this.stateName;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append("State Name: ");
				sb.append(this.stateName);
				sb.append(" stateMachine: ");
				sb.append(this.stateMachineEnumeration.getStateMachineName());
				return sb.toString();
			}
		}
	'''


	def compileControlObjectLocator(StateMachine e) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration;

		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».controlobject.Abstract«e.name»ControlObject;
		import org.springframework.beans.factory.annotation.Lookup;
		import org.springframework.stereotype.Component;

		@Component
		public class «e.name»ControlObjectLocator {

			@Lookup
			public Abstract«e.name»ControlObject getControlObject() {
				return null;
			}
		}
	'''

	def compileControlObject(StateMachine e) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».controlobject;

		/**
		*
		*/

		public abstract class Abstract«e.name»ControlObject implements
					java.io.Serializable {

			private final static long serialVersionUID = -2067325695L;

			«FOR controlObjectAttribute : e.controlObject.attributes»
				«IF controlObjectAttribute.type instanceof SimpleType»
					«val tmp = controlObjectAttribute.type as SimpleType»
					«tmp.type.literal» «controlObjectAttribute.name»;
				«ELSE»
					«val tmp = controlObjectAttribute.type as ObjectType»
					«tmp.type» «controlObjectAttribute.name»;
				«ENDIF»
			«ENDFOR»

			«FOR controlObjectAttribute : e.controlObject.attributes»
				«IF controlObjectAttribute.type instanceof SimpleType»
					«val tmp = controlObjectAttribute.type as SimpleType»
					public «tmp.type.literal» get«WordUtils.capitalize(controlObjectAttribute.name)»() {
				«ELSE»
					«val tmp = controlObjectAttribute.type as ObjectType»
					public «tmp.type» get«WordUtils.capitalize(controlObjectAttribute.name)»() {
				«ENDIF»
					return «controlObjectAttribute.name»;
				}
			«ENDFOR»

			public abstract void resetStateMachine();
		}
	'''

	def compileEvent(Iterable<Event> e, StateMachine s) '''
		package «s.eContainer.fullyQualifiedName».«s.name.toLowerCase()».enumeration.event;

		import org.salgar.statemachine.domain.EventEnumeration;
		import org.salgar.statemachine.domain.StateMachineEnumeration;
		import «s.eContainer.fullyQualifiedName».enumeration.StateMachineEnumerationImpl;

		public enum «s.name»_EventEnumerationImpl implements EventEnumeration {

			«FOR event : e SEPARATOR ','»
				«event.name»("«event.name.toLowerCase»", StateMachineEnumerationImpl.«s.name»)
			«ENDFOR»;

			private String eventName;
			private StateMachineEnumeration stateMachineEnumeration;

			«s.name»_EventEnumerationImpl(String eventName, StateMachineEnumeration stateMachineEnumeration) {
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
	'''

	def compileGuard(StateMachine e, State state, Transition transition) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».guard;

		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.event.«e.name»_EventEnumerationImpl;
		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.state.«e.name»_StateEnumerationImpl;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.context.annotation.Bean;
		import org.springframework.statemachine.StateContext;
		import org.springframework.statemachine.guard.Guard;

		import org.apache.log4j.Logger;

		@Configuration
		public class «state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard {
		    private static final Logger LOG = Logger.getLogger(
					«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard.class);

			@Autowired(required = false)
			private I«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»Guard realImplementation;

			@Bean
			public Guard<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> «state.name»_«transition.target.name»_«transition.name»_«transition.guard.name»_guard() {
				return new Guard<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl>() {

					@Override
					public boolean evaluate(
							StateContext<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> context) {
						if (realImplementation != null) {
							return realImplementation.evaluate(context);
						} else {
						    LOG.warn(
									"This Guard defined in the Model but Spring could not find a concrete implementation class!");
						}
						return false;
					}
				};
			}
			public interface I«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»Guard {
				boolean evaluate(
						StateContext<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> context);
			}
		}
	'''

	def compileAction(StateMachine e, State state, Transition transition) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».action;

		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.event.«e.name»_EventEnumerationImpl;
		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.state.«e.name»_StateEnumerationImpl;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.context.annotation.Bean;
		import org.springframework.statemachine.StateContext;
		import org.springframework.statemachine.action.Action;

		import org.apache.log4j.Logger;

		@Configuration
		public class «state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action {
			private static final Logger LOG = Logger.getLogger(
					«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action.class);

			@Autowired(required = false)
			private I«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»Action realImplementation;

			@Bean
			public Action<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> «state.name»_«transition.target.name»_«transition.name»_«transition.action.name»_action() {
				return new Action<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl>() {

					@Override
					public void execute(
							StateContext<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> context) {
						if (realImplementation != null) {
							realImplementation.execute(context);
						} else {
							LOG.warn(
									"This Action defined in the Model but Spring could not find a concrete implementation class!");
						}
					}
				};
			}
			public interface I«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»Action {
				void execute(
						StateContext<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> context);
			}
		}
	'''


	def compileActionContainer(StateMachine e) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Configuration;

		@Configuration
		public class «e.name»ActionContainer {
			«FOR state : e.states»
				«FOR transition : state.transitions»
					«IF transition.action != null»
						@Autowired
						private «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».action.«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action «state.name.toLowerCase()»___«transition.target.name»_«transition.name»_«transition.action.name»_action;

						public «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».action.«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action get«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action() {
							return «state.name.toLowerCase()»___«transition.target.name»_«transition.name»_«transition.action.name»_action;
						}
					«ENDIF»
				«ENDFOR»
		    «ENDFOR»
		}
	'''

	def compileGuardContainer(StateMachine e) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Configuration;

		@Configuration
		public class «e.name»GuardContainer {
			«FOR state : e.states»
				«FOR transition : state.transitions»
					«IF transition.guard != null»
						@Autowired
						private «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».guard.«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard «state.name.toLowerCase()»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard;

						public «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration.«state.name.toLowerCase()».guard.«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard get«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard() {
							return «state.name.toLowerCase()»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard;
						}
					«ENDIF»
				«ENDFOR»
		    «ENDFOR»
		}
	'''

	def compileStateMachine(StateMachine e) '''
		package «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».configuration;

		import org.salgar.statemachine.domain.ControlObject;
		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».controlobject.Abstract«e.name»ControlObject;
		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.event.«e.name»_EventEnumerationImpl;
		import «e.eContainer.fullyQualifiedName».«e.name.toLowerCase()».enumeration.state.«e.name»_StateEnumerationImpl;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.context.annotation.Bean;
		import org.springframework.messaging.Message;
		import org.springframework.statemachine.config.EnableStateMachineFactory;
		import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
		import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
		import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
		import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
		import org.springframework.statemachine.StateContext;
		import org.springframework.statemachine.action.Action;
		import org.springframework.statemachine.listener.StateMachineListener;
		import org.springframework.statemachine.listener.StateMachineListenerAdapter;
		import org.springframework.statemachine.state.State;

		import java.util.EnumSet;

		import org.apache.log4j.Logger;

		@Configuration
		@EnableStateMachineFactory(name = "«e.name»")
		public class «e.name»Configuration extends
			EnumStateMachineConfigurerAdapter<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> {
			private static final Logger LOG = Logger.getLogger(«e.name»Configuration.class);

			@Autowired
			private «e.name»ActionContainer «WordUtils.uncapitalize(e.name)»ActionContainer;

			@Autowired
			private «e.name»GuardContainer «WordUtils.uncapitalize(e.name)»GuardContainer;

			@Autowired
			private «e.name»ControlObjectLocator controlObjectLocator;

			@Override
			public void configure(
				StateMachineConfigurationConfigurer<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> config)
						throws Exception {
				config.withConfiguration().listener(listener());
			}

			@Override
			public void configure(
				StateMachineStateConfigurer<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> states)
						throws Exception {
				states.withStates()
					.initial(«e.name»_StateEnumerationImpl.«e.initialState.name»,
							initialState«e.name»Action())
					.states(EnumSet.allOf(«e.name»_StateEnumerationImpl.class));
		}

		@Override
		public void configure(
				StateMachineTransitionConfigurer<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> transitions)
						throws Exception {
			transitions
				«FOR state : e.states SEPARATOR '.and()'»
					//STATE - «state.name»
					«FOR transition : state.transitions SEPARATOR '.and()'»
						//TRANSITION - «transition.name»
						.withExternal().source(«e.name»_StateEnumerationImpl.«state.name»)
						.target(«e.name»_StateEnumerationImpl.«transition.target.name»)
						.event(«e.name»_EventEnumerationImpl.«transition.trigger.name»)
						«IF transition.guard != null»
							.guard(«WordUtils.uncapitalize(e.name)»GuardContainer
							.get«state.name»___«transition.target.name»_«transition.name»_«transition.guard.name»_guard()
							.«state.name»_«transition.target.name»_«transition.name»_«transition.guard.name»_guard())
						«ENDIF»
						«IF transition.action != null»
							.action(«WordUtils.uncapitalize(e.name)»ActionContainer
							.get«state.name»___«transition.target.name»_«transition.name»_«transition.action.name»_action()
							.«state.name»_«transition.target.name»_«transition.name»_«transition.action.name»_action())
						«ENDIF»
					«ENDFOR»
				«ENDFOR»;
		}


			public StateMachineListener<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> listener() {
				return new StateMachineListenerAdapter<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl>() {
					@Override
					public void stateChanged(
							State<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> from,
							State<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> to) {
						LOG.info("State change to " + to.getId());
					}

					@Override
					public void eventNotAccepted(Message<«e.name»_EventEnumerationImpl> event) {
						LOG.warn("The event " + event.toString() + " is not accepted!");
					}
				};
			}

			@Bean
			public Action<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> initialState«e.name»Action() {
				return new Action<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl>() {
					@Override
					public void execute(
							StateContext<«e.name»_StateEnumerationImpl, «e.name»_EventEnumerationImpl> context) {
						Abstract«e.name»ControlObject controlObject = controlObjectLocator.getControlObject();
						((ControlObject) controlObject).resetStateMachine();
						context.getExtendedState().getVariables().put("«e.name»ControlObject", controlObject);
					}
				};
			}
		}
	'''
}
