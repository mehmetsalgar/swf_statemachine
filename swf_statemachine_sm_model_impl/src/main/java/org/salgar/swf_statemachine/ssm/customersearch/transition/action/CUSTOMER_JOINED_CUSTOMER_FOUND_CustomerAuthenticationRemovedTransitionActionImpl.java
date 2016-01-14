package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.customer_joined.action.CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemoved_action;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/11/15.
 */
@Configuration
public class CUSTOMER_JOINED_CUSTOMER_FOUND_CustomerAuthenticationRemovedTransitionActionImpl {
    @Bean
    public CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemoved_action.ICUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemovedAction getCUSTOMER_JOINED_CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemovedAction() {
        return new CUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemoved_action.ICUSTOMER_JOINED___CUSTOMER_FOUND_CustomerAuthenticationRemovedFromJoined_ProcessCustomerAuthenticationRemovedAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());
                CustomerSearchSMControlObjectAccessor
                        .processCustomerJoinedAuthenticationRemovedAction(controlObject);
            }
        };
    }
}
