package org.salgar.swf_statemachine.ssm.customersearch.transition.action;

import org.salgar.swf_statemachine.customersearch.configuration.orders_loading.action.ORDERS_LOADING___CUSTOMER_AUTHENTICATED_CustomerJoinRemoved_ProcessCustomerJoinRemoved_action;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObject;
import org.salgar.swf_statemachine.customersearch.controlobject.CustomerSearchSMControlObjectAccessor;
import org.salgar.swf_statemachine.customersearch.enumeration.event.CustomerSearchSM_EventEnumerationImpl;
import org.salgar.swf_statemachine.customersearch.enumeration.state.CustomerSearchSM_StateEnumerationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;

/**
 * Created by salgar on 11/10/15.
 */
@Configuration
public class ORDERS_LOADING_CUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CLICKEDActionImpl {
    @Bean
    public ORDERS_LOADING___CUSTOMER_AUTHENTICATED_CustomerJoinRemoved_ProcessCustomerJoinRemoved_action.IORDERS_LOADING_CUSTOMER_AUTHENTICATED_CustomerJoinRemoved_ProcessCustomerJoinRemovedAction getORDERS_LOADING_CUSTOMER_AUTHENTICATED_CUSTOMER_JOINED_CLICKEDAction() {
        return new ORDERS_LOADING___CUSTOMER_AUTHENTICATED_CustomerJoinRemoved_ProcessCustomerJoinRemoved_action.IORDERS_LOADING_CUSTOMER_AUTHENTICATED_CustomerJoinRemoved_ProcessCustomerJoinRemovedAction() {

            @Override public void execute(StateContext<CustomerSearchSM_StateEnumerationImpl, CustomerSearchSM_EventEnumerationImpl> context) {
                CustomerSearchSMControlObject controlObject = (CustomerSearchSMControlObject) CustomerSearchSMControlObjectAccessor.getControlObject(context.getStateMachine());

                CustomerSearchSMControlObjectAccessor
                        .processCustomerJoinedRemovedAction(controlObject);
            }
        };
    }
}
