package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.ssm.customersearchsm.configuration.customer_authenticated.action.CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdersLoading_ProcessLoadingOrders_action;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.ssm.customersearchsm.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.ssm.customersearchsm.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/9/15.
 */
@Configuration
public class CUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionActionImpl {
    @Bean
    public CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdersLoading_ProcessLoadingOrders_action.ICUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdersLoading_ProcessLoadingOrdersAction getCUSTOMER_AUTHENTICATED_ORDERS_LOADING_OrdesLoadingTransitionAction() {
        return new CUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdersLoading_ProcessLoadingOrders_action.ICUSTOMER_AUTHENTICATED___ORDERS_LOADING_OrdersLoading_ProcessLoadingOrdersAction() {
            @Override
            public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject customerSearchSMControlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor
                        .processOrdersLoadingAction(customerSearchSMControlObject);
            }
        };
    }
}
