package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_joined.action.CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class CUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionActionImpl {
    @Bean
    public CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransition_action.ICUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionAction getCUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionAction() {
        return new CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransition_action.ICUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionAction() {

            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor
                        .processCustomerJoinedRemovedAction(controlObject);
            }
        };
    }
}
