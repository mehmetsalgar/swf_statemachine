package org.salgar.swf_statemachine.reference_model.controlobject;

import org.salgar.statemachine.domain.ControlObject;

public class STATEMACHINE_1ControlObject  implements ControlObject {
	String customerNumber;
	
	public void resetStateMachine() {		
		this.customerNumber = null;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

}
