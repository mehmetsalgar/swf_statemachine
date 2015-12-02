package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.configuration.customer_joined.action.CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinedClicked_ProcessCustomerJoinRemoved_action;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.customersearch.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.customersearch.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class CUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionActionImpl {
    @Bean
    public CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinedClicked_ProcessCustomerJoinRemoved_action.ICUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinedClicked_ProcessCustomerJoinRemovedAction getCUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinRemovedTransitionAction() {
        return new CUSTOMER_JOINED___CUSTOMER_AUTHENTICATED_CustomerJoinedClicked_ProcessCustomerJoinRemoved_action.ICUSTOMER_JOINED_CUSTOMER_AUTHENTICATED_CustomerJoinedClicked_ProcessCustomerJoinRemovedAction() {

            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor
                        .processCustomerJoinedRemovedAction(controlObject);
            }
        };
    }
}
