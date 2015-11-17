package org.salgar.swf_statemachine.findorders.controlobject;

import org.salgar.statemachine.domain.ControlObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
@Scope("prototype")
public class FindOrdersSMControlObject extends AbstractFindOrdersControlObject implements ControlObject, Serializable {
	private static final long serialVersionUID = -123652345793959337L;

	public void resetStateMachine() {
		masterStateMachine = null;
		orders = new ArrayList();
	}
}
