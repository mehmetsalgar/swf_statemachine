package org.salgar.swf_statemachine.ssm.customersearch.transition.guard;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_authenticated.guard.CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_guard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/9/15.
 */
@Configuration
public class CUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionGuardImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_guard.ICUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionGuard getCUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionGuard() {
        return new CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_guard.ICUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionGuard() {
            @Override
            public boolean evaluate(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject customerSearchSMControlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                if (FindOrdersSM_StateEnumerationImpl.ORDER_SEARCH_RUNNING
                        .equals(((StateMachine)customerSearchSMControlObject.getFindOrdersSlaveSM()).getState().getId())) {
                    return true;
                }
                return false;
            }
        };
    }
}
