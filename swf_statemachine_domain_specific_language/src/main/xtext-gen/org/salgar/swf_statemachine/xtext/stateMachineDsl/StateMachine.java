/**
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext.stateMachineDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getControlObject <em>Control Object</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getEvents <em>Events</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends Base
{
  /**
   * Returns the value of the '<em><b>Initial State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial State</em>' reference.
   * @see #setInitialState(State)
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getStateMachine_InitialState()
   * @model
   * @generated
   */
  State getInitialState();

  /**
   * Sets the value of the '{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getInitialState <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial State</em>' reference.
   * @see #getInitialState()
   * @generated
   */
  void setInitialState(State value);

  /**
   * Returns the value of the '<em><b>Control Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Control Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Control Object</em>' containment reference.
   * @see #setControlObject(ControlObject)
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getStateMachine_ControlObject()
   * @model containment="true"
   * @generated
   */
  ControlObject getControlObject();

  /**
   * Sets the value of the '{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine#getControlObject <em>Control Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Control Object</em>' containment reference.
   * @see #getControlObject()
   * @generated
   */
  void setControlObject(ControlObject value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.salgar.swf_statemachine.xtext.stateMachineDsl.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getStateMachine_Events()
   * @model containment="true"
   * @generated
   */
  EList<Event> getEvents();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.salgar.swf_statemachine.xtext.stateMachineDsl.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getStateMachine_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // StateMachine
