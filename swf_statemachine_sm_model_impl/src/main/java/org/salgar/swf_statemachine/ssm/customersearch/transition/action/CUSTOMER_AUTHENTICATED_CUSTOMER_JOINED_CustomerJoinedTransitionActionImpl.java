package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_authenticated.action.CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoinedTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/11/15.
 */
@Configuration
public class CUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionActionImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoinedTransition_action.ICUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionAction getCUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionAction() {
        return new CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoinedTransition_action.ICUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionAction() {

            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor.processCustomerJoinedAction(
                        controlObject, (Boolean) context.getMessageHeader("joined"));
            }
        };
    }
}
