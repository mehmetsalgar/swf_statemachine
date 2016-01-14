/**
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext.stateMachineDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.salgar.swf_statemachine.xtext.stateMachineDsl.ControlObject;
import org.salgar.swf_statemachine.xtext.stateMachineDsl.Event;
import org.salgar.swf_statemachine.xtext.stateMachineDsl.State;
import org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachine;
import org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.impl.StateMachineImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.impl.StateMachineImpl#getControlObject <em>Control Object</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.impl.StateMachineImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.impl.StateMachineImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateMachineImpl extends BaseImpl implements StateMachine
{
  /**
   * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialState()
   * @generated
   * @ordered
   */
  protected State initialState;

  /**
   * The cached value of the '{@link #getControlObject() <em>Control Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControlObject()
   * @generated
   * @ordered
   */
  protected ControlObject controlObject;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<Event> events;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateMachineImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StateMachineDslPackage.Literals.STATE_MACHINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getInitialState()
  {
    if (initialState != null && initialState.eIsProxy())
    {
      InternalEObject oldInitialState = (InternalEObject)initialState;
      initialState = (State)eResolveProxy(oldInitialState);
      if (initialState != oldInitialState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE, oldInitialState, initialState));
      }
    }
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetInitialState()
  {
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialState(State newInitialState)
  {
    State oldInitialState = initialState;
    initialState = newInitialState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE, oldInitialState, initialState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ControlObject getControlObject()
  {
    return controlObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetControlObject(ControlObject newControlObject, NotificationChain msgs)
  {
    ControlObject oldControlObject = controlObject;
    controlObject = newControlObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT, oldControlObject, newControlObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControlObject(ControlObject newControlObject)
  {
    if (newControlObject != controlObject)
    {
      NotificationChain msgs = null;
      if (controlObject != null)
        msgs = ((InternalEObject)controlObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT, null, msgs);
      if (newControlObject != null)
        msgs = ((InternalEObject)newControlObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT, null, msgs);
      msgs = basicSetControlObject(newControlObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT, newControlObject, newControlObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Event> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<Event>(Event.class, this, StateMachineDslPackage.STATE_MACHINE__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, StateMachineDslPackage.STATE_MACHINE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT:
        return basicSetControlObject(null, msgs);
      case StateMachineDslPackage.STATE_MACHINE__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
      case StateMachineDslPackage.STATE_MACHINE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE:
        if (resolve) return getInitialState();
        return basicGetInitialState();
      case StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT:
        return getControlObject();
      case StateMachineDslPackage.STATE_MACHINE__EVENTS:
        return getEvents();
      case StateMachineDslPackage.STATE_MACHINE__STATES:
        return getStates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE:
        setInitialState((State)newValue);
        return;
      case StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT:
        setControlObject((ControlObject)newValue);
        return;
      case StateMachineDslPackage.STATE_MACHINE__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends Event>)newValue);
        return;
      case StateMachineDslPackage.STATE_MACHINE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE:
        setInitialState((State)null);
        return;
      case StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT:
        setControlObject((ControlObject)null);
        return;
      case StateMachineDslPackage.STATE_MACHINE__EVENTS:
        getEvents().clear();
        return;
      case StateMachineDslPackage.STATE_MACHINE__STATES:
        getStates().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case StateMachineDslPackage.STATE_MACHINE__INITIAL_STATE:
        return initialState != null;
      case StateMachineDslPackage.STATE_MACHINE__CONTROL_OBJECT:
        return controlObject != null;
      case StateMachineDslPackage.STATE_MACHINE__EVENTS:
        return events != null && !events.isEmpty();
      case StateMachineDslPackage.STATE_MACHINE__STATES:
        return states != null && !states.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateMachineImpl
