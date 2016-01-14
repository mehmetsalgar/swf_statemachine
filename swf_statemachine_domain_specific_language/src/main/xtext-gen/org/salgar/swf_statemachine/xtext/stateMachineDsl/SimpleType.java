/**
 * generated by Xtext 2.9.1
 */
package org.salgar.swf_statemachine.xtext.stateMachineDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.SimpleType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getSimpleType()
 * @model
 * @generated
 */
public interface SimpleType extends AttributeBase
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.salgar.swf_statemachine.xtext.stateMachineDsl.InternalType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.InternalType
   * @see #setType(InternalType)
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.StateMachineDslPackage#getSimpleType_Type()
   * @model
   * @generated
   */
  InternalType getType();

  /**
   * Sets the value of the '{@link org.salgar.swf_statemachine.xtext.stateMachineDsl.SimpleType#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.salgar.swf_statemachine.xtext.stateMachineDsl.InternalType
   * @see #getType()
   * @generated
   */
  void setType(InternalType value);

} // SimpleType