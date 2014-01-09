package org.salgar.swf_statemachine.findcustomer.controlobject;

import java.io.Serializable;

import org.salgar.statemachine.domain.ControlObject;

public class FindCustomerSMControlObject extends AbstractFindCustomerControlObject implements ControlObject, Serializable {
	private static final long serialVersionUID = -2200204569913643581L;
	
	public void resetStateMachine() {
		this.masterStateMachine = null;
	}

}
