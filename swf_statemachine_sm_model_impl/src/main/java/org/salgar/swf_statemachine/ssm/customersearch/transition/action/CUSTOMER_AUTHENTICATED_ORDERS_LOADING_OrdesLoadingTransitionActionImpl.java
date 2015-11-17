package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_authenticated.action.CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/9/15.
 */
@Configuration
public class CUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionActionImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_action.ICUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionAction getCUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionAction() {
        return new CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdesLoadingTransition_action.ICUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject customerSearchSMControlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor
                        .processOrdersLoadingAction(customerSearchSMControlObject);
            }
        };
    }
}
