package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_joined.action.CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/11/15.
 */
@Configuration
public class CUSTOMER_JOINED_CUSTOMER_FOUND_CustomerAuthenticationRemovedTransitionActionImpl {
    @Bean
    public CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedTransition_action.ICUSTOMER_JOINED_CUSTOMER_FOUND_CustomerAuthenticationRemovedTransitionAction get() {
        return new CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedTransition_action.ICUSTOMER_JOINED_CUSTOMER_FOUND_CustomerAuthenticationRemovedTransitionAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());
                CustomerSearchSMControlObjectAccessor
                        .processCustomerJoinedAuthenticationRemovedAction(controlObject);
            }
        };
    }
}
