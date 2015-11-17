package org.salgar.swf_statemachine.ssm.factory;

import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findorderssm.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/4/15.
 */
@Configuration
public class StateMachineFactories {
    private static  StateMachineFactories INSTANCE;

    @Autowired
    @Qualifier("CustomerSearchSM")
    private StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine;

    @Autowired
    @Qualifier("FindCustomerSM")
    private StateMachine<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> findCustomerSM;

    @Autowired
    @Qualifier("FindOrdersSM")
    private StateMachine<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> findOrdersSM;

    public StateMachineFactories() {
        if(INSTANCE == null) {
            INSTANCE = this;
        }
    }

    public static StateMachineFactories getInstance() {
        return INSTANCE;
    }

    public StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> getCustomerSearchSM() {
        return stateMachine;
    }

    public StateMachine<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> getFindCustomerSM() {
        return findCustomerSM;
    }

    public StateMachine<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> getFindOrdersSM() {
        return findOrdersSM;
    }
}
