package org.salgar.swf_statemachine.findorders.controlobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.techdemo.domain.Order;

public class FindOrdersSMControlObject implements ControlObject, Serializable {
	private static final long serialVersionUID = -123652345793959337L;
	
	StateMachine masterStateMachine = null;
	List<Order> orders = null;

	public void resetStateMachine() {
		masterStateMachine = null;
		orders = new ArrayList<Order>();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public StateMachine getMasterStateMachine() {
		return masterStateMachine;
	}

}
