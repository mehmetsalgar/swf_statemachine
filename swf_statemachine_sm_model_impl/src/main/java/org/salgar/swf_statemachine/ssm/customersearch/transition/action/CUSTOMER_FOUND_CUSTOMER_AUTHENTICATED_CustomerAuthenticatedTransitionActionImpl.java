package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.configuration.customersearchsm.customer_found.action.CUSTOMER_FOUND___CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/9/15.
 */
@Configuration
public class CUSTOMER_FOUND_CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransitionActionImpl {
    @Bean
    public CUSTOMER_FOUND___CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransition_action.ICUSTOMER_FOUND_CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransitionAction getICUSTOMER_FOUND_CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransitionAction() {
        return new CUSTOMER_FOUND___CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransition_action.ICUSTOMER_FOUND_CUSTOMER_AUTHENTICATED_CustomerAuthenticatedTransitionAction() {
            @Override public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                boolean authenticated = (Boolean) context.getMessageHeader("authenticated");
                CustomerSearchSMControlObjectAccessor
                        .processCustomerAuthenticatedAction(controlObject,
                                authenticated);
            }
        };
    }
}
