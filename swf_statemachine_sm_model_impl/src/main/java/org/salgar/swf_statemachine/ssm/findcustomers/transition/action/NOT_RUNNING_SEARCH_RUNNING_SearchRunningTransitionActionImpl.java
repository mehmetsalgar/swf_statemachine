package org.salgar.swf_statemachine.ssm.findcustomers.transition.action;

import org.salgar.statemachine.domain.ControlObject;
import org.salgar.swf_statemachine.enumeration.event.findcustomersm.FindCustomerSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.enumeration.state.FindCustomerSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.findcustomer.controlobject.FindCustomerSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.configuration.findcustomersm.not_running.action.NOT_RUNNING___SEARCH_RUNNING_SearchRunningTransition_action;
import org.salgar.swf_statemachine.techdemo.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

/**
 * Created by salgar on 11/6/15.
 */
@Configuration
public class NOT_RUNNING_SEARCH_RUNNING_SearchRunningTransitionActionImpl {
    @Autowired
    @Qualifier("customerManager")
    private Object customerManager;

    @Bean
    public NOT_RUNNING___SEARCH_RUNNING_SearchRunningTransition_action.INOT_RUNNING_SEARCH_RUNNING_SearchRunningTransitionAction getNOT_RUNNING_SEARCH_RUNNING_SearchRunningTransitionAction() {
        return new NOT_RUNNING___SEARCH_RUNNING_SearchRunningTransition_action.INOT_RUNNING_SEARCH_RUNNING_SearchRunningTransitionAction() {

            @Override public void execute(StateContext<FindCustomerSM_StateEnumerationImpl, FindCustomerSM_EventEnumerationImpl> context) {
                String customerNumber = (String) context.getMessageHeaders().get("customerNumber");

                StateMachine masterStateMachine = (StateMachine) context.getMessageHeaders().get("masterStateMachine");

                ControlObject controlObject = (ControlObject) FindCustomerSMControlObjectAccessor.getControlObject(context.getStateMachine());
                FindCustomerSMControlObjectAccessor.processFindCustomerStart(
                        controlObject, masterStateMachine);

                ((CustomerManager)customerManager).findCustomer(customerNumber, context.getStateMachine());
            }
        };
    }
}
