package org.salgar.swf_statemachine.techdemo.web.customersearch.container;

import org.salgar.swf_statemachine.ssm.factory.StateMachineFactories;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.statemachine.StateMachine;

import java.io.Serializable;

/**
 * Created by salgar on 11/16/15.
 */
public class StateMachineContainer implements InitializingBean, Serializable {
    private StateMachine customerSearchSM;

    public StateMachine getCustomerSearchSM() {
        return customerSearchSM;
    }

    public void startStateMachine() {
        customerSearchSM.start();
    }

    public void afterPropertiesSet() throws Exception {
        StateMachine stateMachine = StateMachineFactories.getInstance().getCustomerSearchSM();

        this.customerSearchSM = stateMachine;
    }
}
