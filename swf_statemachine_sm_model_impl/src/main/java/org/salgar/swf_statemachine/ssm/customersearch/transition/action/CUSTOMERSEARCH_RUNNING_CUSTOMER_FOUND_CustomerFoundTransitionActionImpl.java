package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.comet.CometServiceLocator;
import org.salgar.swf_statemachine.customersearch.configuration.customersearch_running.action.CUSTOMERSEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.customersearch.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.customersearch.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.findorders.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.factory.StateMachineFactories;
import org.salgar.swf_statemachine.techdemo.domain.Customer;
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
public class CUSTOMERSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionActionImpl {
    @Bean
    public CUSTOMERSEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action.ICUSTOMERSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFound_ProcessCustomerFoundAction getCUSTOMERSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFoundTransitionAction() {
        return new CUSTOMERSEARCH_RUNNING___CUSTOMER_FOUND_CustomerFound_ProcessCustomerFound_action.ICUSTOMERSEARCH_RUNNING_CUSTOMER_FOUND_CustomerFound_ProcessCustomerFoundAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                StateMachine findOrdersSM = StateMachineFactories.getInstance().getFindOrdersSMFactory().getStateMachine();
                findOrdersSM.start();

                CustomerSearchSMControlObjectAccessor.processCustomerFoundAction(
                        controlObject, (Customer) context.getMessageHeader("customer"), findOrdersSM);

                Message<FindOrdersSM_EventEnumerationImpl> message = MessageBuilder.withPayload(FindOrdersSM_EventEnumerationImpl.onOrderSearchRunning).setHeader("customerNumber", controlObject.getCustomer()
                        .getCustomerNumber()).setHeader("masterStateMachine", context.getStateMachine()).build();

                findOrdersSM.sendEvent(message);

                CometServiceLocator.getInstance().pushMessage("customer found", controlObject.getFlowId(), controlObject.getSessionId());
            }
        };
    }
}
