package org.salgar.swf_statemachine.ssm.customersearch.transition.guard;

import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.customer_authenticated.guard.CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_isOrdersFound_guard;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/9/15.
 */
@Configuration
public class CUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionGuardImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_isOrdersFound_guard.ICUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_isOrdersFoundGuard getCUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CustomerJoinedTransitionGuard() {
        return new CUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_isOrdersFound_guard.ICUSTOMER_AUTHENTICATED___CUSTOMER_JOINED_CustomerJoined_isOrdersFoundGuard() {
            @Override
            public boolean evaluate(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject customerSearchSMControlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                if (FindOrdersSM_StateEnumerationImpl.ORDERS_FOUND
                        .equals(((StateMachine)customerSearchSMControlObject.getFindOrdersSlaveSM()).getState().getId())) {
                    return true;
                }
                return false;
            }
        };
    }
}
