package org.salgar.swf_statemachine.findcustomer.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class FindCustomerSMControlObject extends AbstractFindCustomerControlObject implements ControlObject, Serializable {
	private static final long serialVersionUID = -2200204569913643581L;
	
	public void resetStateMachine() {
		this.masterStateMachine = null;
	}

}
