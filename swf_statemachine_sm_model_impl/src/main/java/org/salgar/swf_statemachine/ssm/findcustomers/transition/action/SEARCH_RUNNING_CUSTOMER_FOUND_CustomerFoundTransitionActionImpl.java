package org.salgar.swf_statemachine.ssm.findcustomers.transition.action;

import org.salgar.swf_statemachine.enumeration.event.customersearchsm.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.findcustomer.controlobject.AbstractFindCustomerControlObject;
import org.salgar.swf_statemachine.findcustomer.controlobject.FindCustomerSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.configuration.findcustomersm.search_running.action.SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFoundTransition_action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/6/15.
 */
@Configuration
public class SEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionActionImpl {
    @Bean
    public SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFoundTransition_action.ISEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionAction getSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionAction() {
        return new SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFoundTransition_action.ISEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionAction() {
            @Override
            public void execute(StateContext<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> context) {
                Message<CustomerSearchSM_EventEnumerationImpl> message =  MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", context.getMessageHeader("customer")).build();

                AbstractFindCustomerControlObject abstractFindCustomerControlObject = FindCustomerSMControlObjectAccessor.getControlObject(context.getStateMachine());
                ((StateMachine)abstractFindCustomerControlObject.getMasterStateMachine()).sendEvent(message);
            }
        };
    }
}
