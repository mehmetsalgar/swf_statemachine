package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.waiting_customersearch_start.action.WAITING_CUSTOMERSEARCH_START___CUSTOMERSEARCH_RUNNING_SearchRunning_ProcessSearchStart_action;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchCO;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.factory.StateMachineFactories;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.event.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findcustomersm.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.event.CustomerSearchStartEventPayload;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/4/15.
 */
@Configuration
public class WAITING_CUSTOMERSEARCH_START_CUSTOMERSEARCH_RUNNING_SearchRunningTransitionActionImpl {
    @Bean
    public WAITING_CUSTOMERSEARCH_START___CUSTOMERSEARCH_RUNNING_SearchRunning_ProcessSearchStart_action.IWAITING_CUSTOMERSEARCH_START___CUSTOMERSEARCH_RUNNING_SearchRunning_ProcessSearchStartAction getWAITING_CUSTOMERSEARCH_START_CUSTOMERSEARCH_RUNNING_SearchRunningTransitionAction() {
        return new WAITING_CUSTOMERSEARCH_START___CUSTOMERSEARCH_RUNNING_SearchRunning_ProcessSearchStart_action.IWAITING_CUSTOMERSEARCH_START___CUSTOMERSEARCH_RUNNING_SearchRunning_ProcessSearchStartAction() {
            @Override public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchCO customerSearchCO = CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchStartEventPayload customerSearchStartEventPayload = (CustomerSearchStartEventPayload) context.getMessageHeaders().get("customerSearchStartEventPayload");

                StateMachine<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> stateMachine = StateMachineFactories.getInstance().getFindCustomerSMFactory().getStateMachine();
                stateMachine.start();

                //We have to one specific Slave Maschine that is referenced from this Master State MAchine
                //for this reason we have to keep a reference to it.

                CustomerSearchSMControlObjectAccessor
                        .processCustomerSearchRunningAction(
                                (CustomerSearchSMControlObject) customerSearchCO,
                                customerSearchStartEventPayload.getCustomerNumber(),
                                customerSearchStartEventPayload.getFlowId(),
                                customerSearchStartEventPayload.getSessionId(),
                                stateMachine);

                Message<FindCustomerSM_EventEnumerationImpl> message = MessageBuilder.withPayload(FindCustomerSM_EventEnumerationImpl.onStartSearch)
                        .setHeader("customerNumber", customerSearchCO.getCustomerNumber())
                        .setHeader("masterStateMachine", context.getStateMachine())
                        .build();
                stateMachine.sendEvent(message);
            }
        };
    }
}
