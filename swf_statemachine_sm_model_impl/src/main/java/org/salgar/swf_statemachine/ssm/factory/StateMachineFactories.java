package org.salgar.swf_statemachine.ssm.factory;

import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineFactory;

/**
 * Created by salgar on 11/4/15.
 */
@Configuration
public class StateMachineFactories {
    private static  StateMachineFactories INSTANCE;

    @Autowired
    @Qualifier("CustomerSearchSM")
    private StateMachineFactory<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> stateMachine;

    @Autowired
    @Qualifier("FindCustomerSM")
    private StateMachineFactory<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> findCustomerSM;

    @Autowired
    @Qualifier("FindOrdersSM")
    private StateMachineFactory<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> findOrdersSM;

    public StateMachineFactories() {
        if(INSTANCE == null) {
            INSTANCE = this;
        }
    }

    public static StateMachineFactories getInstance() {
        return INSTANCE;
    }

    public StateMachineFactory<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> getCustomerSearchSMFactory() {
        return stateMachine;
    }

    public StateMachineFactory<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> getFindCustomerSMFactory() {
        return findCustomerSM;
    }

    public StateMachineFactory<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> getFindOrdersSMFactory() {
        return findOrdersSM;
    }
}
