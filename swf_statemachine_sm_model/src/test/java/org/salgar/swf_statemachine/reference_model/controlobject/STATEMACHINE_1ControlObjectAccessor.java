package org.salgar.swf_statemachine.reference_model.controlobject;

public class STATEMACHINE_1ControlObjectAccessor {
	private volatile static STATEMACHINE_1ControlObjectAccessor INSTANCE = null;
	
	private STATEMACHINE_1ControlObjectAccessor() {		
	}
	
	public static STATEMACHINE_1ControlObjectAccessor getInstance() {
		if (INSTANCE == null) {
			INSTANCE = createInstance();
		}		
		return INSTANCE;
	}
	
	private static synchronized STATEMACHINE_1ControlObjectAccessor createInstance() {
		if (INSTANCE == null) {
			return new STATEMACHINE_1ControlObjectAccessor();
		}
		return INSTANCE;
	}
	
	public void placeCustomerNumber(STATEMACHINE_1ControlObject controlObject, String customerNumber) {
		controlObject.customerNumber = customerNumber;
	}
}
