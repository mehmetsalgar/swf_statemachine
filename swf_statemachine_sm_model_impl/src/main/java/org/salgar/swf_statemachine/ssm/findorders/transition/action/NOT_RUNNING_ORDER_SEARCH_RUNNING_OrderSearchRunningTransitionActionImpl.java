package org.salgar.swf_statemachine.ssm.findorders.transition.action;

import org.salgar.swf_statemachine.findorders.configuration.not_running.action.NOT_RUNNING___ORDER_SEARCH_RUNNING_OrderSearchRunning_ProcessOrdersSearchStart_action;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObject;
import org.salgar.swf_statemachine.findorders.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.findorders.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.findorders.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class NOT_RUNNING_ORDER_SEARCH_RUNNING_OrderSearchRunningTransitionActionImpl {
    @Autowired
    @Qualifier("orderManager")
    private Object orderManager;

    @Bean
    public NOT_RUNNING___ORDER_SEARCH_RUNNING_OrderSearchRunning_ProcessOrdersSearchStart_action.INOT_RUNNING_ORDER_SEARCH_RUNNING_OrderSearchRunning_ProcessOrdersSearchStartAction getNOT_RUNNING_ORDER_SEARCH_RUNNING_OrderSearchRunningTransitionAction() {
        return new NOT_RUNNING___ORDER_SEARCH_RUNNING_OrderSearchRunning_ProcessOrdersSearchStart_action.INOT_RUNNING_ORDER_SEARCH_RUNNING_OrderSearchRunning_ProcessOrdersSearchStartAction() {
            @Override
            public void execute(StateContext<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> context) {
                FindOrdersSMControlObject controlObject = (FindOrdersSMControlObject) FindOrdersSMControlObjectAccessor.getControlObject(context.getStateMachine());


                FindOrdersSMControlObjectAccessor.processFindOrdersStart(controlObject, context.getMessageHeader("masterStateMachine"));


                ((OrderManager)orderManager).findOrders((String) context.getMessageHeader("customerNumber"), context.getStateMachine());
            }
        };
    }
}
