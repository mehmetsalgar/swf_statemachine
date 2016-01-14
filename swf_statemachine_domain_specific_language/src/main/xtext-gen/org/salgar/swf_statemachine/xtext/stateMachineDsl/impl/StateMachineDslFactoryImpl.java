/**
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext.stateMachineDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.salgar.swf_statemachine.xtext.stateMachineDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateMachineDslFactoryImpl extends EFactoryImpl implements StateMachineDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StateMachineDslFactory init()
  {
    try
    {
      StateMachineDslFactory theStateMachineDslFactory = (StateMachineDslFactory)EPackage.Registry.INSTANCE.getEFactory(StateMachineDslPackage.eNS_URI);
      if (theStateMachineDslFactory != null)
      {
        return theStateMachineDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new StateMachineDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachineDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case StateMachineDslPackage.MODEL: return createModel();
      case StateMachineDslPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case StateMachineDslPackage.STATE_MACHINE: return createStateMachine();
      case StateMachineDslPackage.BASE: return createBase();
      case StateMachineDslPackage.STATE: return createState();
      case StateMachineDslPackage.TRANSITION: return createTransition();
      case StateMachineDslPackage.EVENT: return createEvent();
      case StateMachineDslPackage.GUARD: return createGuard();
      case StateMachineDslPackage.ACTION: return createAction();
      case StateMachineDslPackage.CONTROL_OBJECT: return createControlObject();
      case StateMachineDslPackage.CONTROL_OBJECT_ATTRIBUTE: return createControlObjectAttribute();
      case StateMachineDslPackage.ATTRIBUTE_BASE: return createAttributeBase();
      case StateMachineDslPackage.SIMPLE_TYPE: return createSimpleType();
      case StateMachineDslPackage.OBJECT_TYPE: return createObjectType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StateMachineDslPackage.INTERNAL_TYPE:
        return createInternalTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StateMachineDslPackage.INTERNAL_TYPE:
        return convertInternalTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine createStateMachine()
  {
    StateMachineImpl stateMachine = new StateMachineImpl();
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Base createBase()
  {
    BaseImpl base = new BaseImpl();
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ControlObject createControlObject()
  {
    ControlObjectImpl controlObject = new ControlObjectImpl();
    return controlObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ControlObjectAttribute createControlObjectAttribute()
  {
    ControlObjectAttributeImpl controlObjectAttribute = new ControlObjectAttributeImpl();
    return controlObjectAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeBase createAttributeBase()
  {
    AttributeBaseImpl attributeBase = new AttributeBaseImpl();
    return attributeBase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleType createSimpleType()
  {
    SimpleTypeImpl simpleType = new SimpleTypeImpl();
    return simpleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectType createObjectType()
  {
    ObjectTypeImpl objectType = new ObjectTypeImpl();
    return objectType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InternalType createInternalTypeFromString(EDataType eDataType, String initialValue)
  {
    InternalType result = InternalType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertInternalTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachineDslPackage getStateMachineDslPackage()
  {
    return (StateMachineDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static StateMachineDslPackage getPackage()
  {
    return StateMachineDslPackage.eINSTANCE;
  }

} //StateMachineDslFactoryImpl
