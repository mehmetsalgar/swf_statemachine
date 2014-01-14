package org.salgar.swf_statemachine.techdemo.web.customersearch.bb;

import org.salgar.statemachine.domain.StateMachine;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchInputCO;

public class CustomerSearchBB {
	private StateMachine stateMachine;

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public String getCustomerSearchRenderPanels() {
		CustomerSearchInputCO customerSearchInputCO = (CustomerSearchInputCO) stateMachine
				.getControlObject();

		return customerSearchInputCO.getCustomerSearchRenderPanels();
	}

	public String getCustomerSearchJavaScriptRenderPanels() {
		CustomerSearchInputCO customerSearchInputCO = (CustomerSearchInputCO) stateMachine
				.getControlObject();
		String renderPanels = customerSearchInputCO
				.getCustomerSearchRenderPanels();

		String javaScriptPanels[] = renderPanels.split(",");

		StringBuilder panelString = new StringBuilder();
		for (int i = 0, n = javaScriptPanels.length; i < n; i++) {
			panelString.append(javaScriptPanels[i]);
			if (i < n -1) {
				panelString.append(",:");
			}
		}

		return panelString.toString();
	}
}
