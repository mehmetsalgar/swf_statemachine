package org.salgar.swf_statemachine.ssm.findcustomers.transition.action;

import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.configuration.search_running.action.SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action;
import org.salgar.swf_statemachine.ssm.findcustomersm.controlobject.AbstractFindCustomerSMControlObject;
import org.salgar.swf_statemachine.ssm.findcustomersm.controlobject.FindCustomerSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.state.FindCustomerSM_StateEnumerationImpl;
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
    public SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action.ISEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFoundAction getSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionAction() {
        return new SEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action.ISEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFoundAction() {
            @Override
            public void execute(StateContext<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> context) {
                Message<CustomerSearchSM_EventEnumerationImpl> message =  MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onCustomerFound).setHeader("customer", context.getMessageHeader("customer")).build();

                AbstractFindCustomerSMControlObject abstractFindCustomerControlObject = FindCustomerSMControlObjectAccessor.getControlObject(context.getStateMachine());
                ((StateMachine)abstractFindCustomerControlObject.getMasterStateMachine()).sendEvent(message);
            }
        };
    }
}
