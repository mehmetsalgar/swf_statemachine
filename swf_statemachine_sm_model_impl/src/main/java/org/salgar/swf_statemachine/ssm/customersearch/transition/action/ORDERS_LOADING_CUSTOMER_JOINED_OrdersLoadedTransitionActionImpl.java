package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.comet.CometServiceLocator;
import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.orders_loading.action.ORDERS_LOADING___CUSTOMER_JOINED_OrdersLoaded_ProcessOrdersLoaded_action;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.salgar.swf_statemachine.techdemo.domain.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

import java.util.List;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class ORDERS_LOADING_CUSTOMER_JOINED_OrdersLoadedTransitionActionImpl {
    @Bean
    public ORDERS_LOADING___CUSTOMER_JOINED_OrdersLoaded_ProcessOrdersLoaded_action.IORDERS_LOADING___CUSTOMER_JOINED_OrdersLoaded_ProcessOrdersLoadedAction getORDERS_LOADING_CUSTOMER_JOINED_OrdersLoadedTransitionAction() {
        return new  ORDERS_LOADING___CUSTOMER_JOINED_OrdersLoaded_ProcessOrdersLoaded_action.IORDERS_LOADING___CUSTOMER_JOINED_OrdersLoaded_ProcessOrdersLoadedAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor.processOrdersLoadedAction(
                        controlObject, (List<Order>) context.getMessageHeaders().get("orders"));

                CometServiceLocator.getInstance().pushMessage("orders found", controlObject.getFlowId(), controlObject.getSessionId());
            }
        };
    }
}
