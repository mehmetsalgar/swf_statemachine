package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.customer_authenticated.action.CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_ProcessOrdersFoundCustomerJoined_action;
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
public class CUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionActionImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_ProcessOrdersFoundCustomerJoined_action.ICUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_ProcessOrdersFoundCustomerJoinedAction getCUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionAction() {
        return new CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_ProcessOrdersFoundCustomerJoined_action.ICUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_ProcessOrdersFoundCustomerJoinedAction() {

            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor.processCustomerJoinedAction(
                        controlObject, (Boolean) context.getMessageHeader("joined"));
            }
        };
    }
}
