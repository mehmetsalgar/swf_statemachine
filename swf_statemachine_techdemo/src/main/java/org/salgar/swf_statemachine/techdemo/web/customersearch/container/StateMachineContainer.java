package org.salgar.swf_statemachine.techdemo.web.customersearch.container;

import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.factory.StateMachineFactories;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.io.Serializable;

/**
 * Created by salgar on 11/16/15.
 */
public class StateMachineContainer implements InitializingBean, Serializable {
    private StateMachineFactory<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> customerSearchSMFactory;
    private StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> customerSearchSM;

    public StateMachine getCustomerSearchSM() {
        return customerSearchSM;
    }

    public void startStateMachine() {
        this.customerSearchSM = customerSearchSMFactory.getStateMachine();

        customerSearchSM.start();
    }

    public void afterPropertiesSet() throws Exception {
        customerSearchSMFactory = StateMachineFactories.getInstance().getCustomerSearchSMFactory();
    }
}
