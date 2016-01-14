package org.salgar.swf_statemachine.ssm.findorderssm.transition.action;

import org.salgar.swf_statemachine.ssm.findorderssm.controlobject.FindOrdersSMControlObject;
import org.salgar.swf_statemachine.ssm.findorderssm.controlobject.FindOrdersSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.configuration.order_search_running.action.ORDER_SEARCH_RUNNING___ORDERS_FOUND_OrdersFound_ProcessOrdersFound_action;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.event.FindOrdersSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.findorderssm.enumeration.state.FindOrdersSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;

import java.util.List;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class ORDER_SEARCH_RUNNING_ORDERS_FOUND_OrdersFoundTransitionActionImpl {
    @Bean
    public ORDER_SEARCH_RUNNING___ORDERS_FOUND_OrdersFound_ProcessOrdersFound_action.IORDER_SEARCH_RUNNING___ORDERS_FOUND_OrdersFound_ProcessOrdersFoundAction getORDER_SEARCH_RUNNING_ORDERS_FOUND_OrdersFoundTransitionActionImpl() {
        return new ORDER_SEARCH_RUNNING___ORDERS_FOUND_OrdersFound_ProcessOrdersFound_action.IORDER_SEARCH_RUNNING___ORDERS_FOUND_OrdersFound_ProcessOrdersFoundAction() {

            @Override
            public void execute(StateContext<FindOrdersSM_StateEnumerationImpl, FindOrdersSM_EventEnumerationImpl> context) {
                List<Order> orders = (List<Order>) context.getMessageHeaders().get("orders");
                FindOrdersSMControlObject findOrdersSMControlObject = (FindOrdersSMControlObject) FindOrdersSMControlObjectAccessor.getControlObject(context.getStateMachine());
                FindOrdersSMControlObjectAccessor.processOrdersFound(findOrdersSMControlObject, orders);
                StateMachine<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> masterStateMachine = (StateMachine) findOrdersSMControlObject.getMasterStateMachine();

                if (CustomerSearchSM_StateEnumerationImpl.ORDERS_LOADING
                        .equals(masterStateMachine.getState().getId())) {

                    Message<CustomerSearchSM_EventEnumerationImpl> message = MessageBuilder.withPayload(CustomerSearchSM_EventEnumerationImpl.onOrdersLoaded).setHeader("orders",
                            orders).build();

                    masterStateMachine.sendEvent(message);
                }
            }
        };
    }
}
