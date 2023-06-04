package com.byes.paap.rest.ordergateway.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class OrderQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder order, IQueryDefinitionContext aContext) {
         
       order.addSearchField("Syscode","syscode");
       order.addSelectField("OrderNumber", "orderNumber");
    }
   
    @Override
    public String getBOName() {
        return "BaseOrder";
    }
}