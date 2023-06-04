package com.byes.paap.rest.ordergateway.queries;

import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class SpaceQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder order, IQueryDefinitionContext aContext) {
         
       order.addSearchField("Code","spaceCode");
       order.addSearchField("PropertyRef","propertyRef");    
    }
   
    @Override
    public String getBOName() {
        return "Space";
    }
}