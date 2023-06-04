package com.byes.paap.rest.ordergateway;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.byes.paap.rest.ordergateway.dto.OrderDTO;
import com.byes.paap.rest.ordergateway.dto.ResponseDTO;
import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.ActionNotFoundException;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IAction;
import com.planonsoftware.platform.data.v1.IActionListManager;
import com.planonsoftware.platform.data.v1.IBusinessObject;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.Operator;

@Path("/document")
public class OrderGateway
{
    @Context 
    IJaxRsResourceContext jaxrsContext;

    @POST
    @Path("/createOrder")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public Response createOrder(OrderDTO order) throws BusinessException, ActionNotFoundException, FieldNotFoundException {

        IActionListManager actionListManager = jaxrsContext.getDataService().getActionListManager("UsrRequest");
        IAction action = actionListManager.getAction("BomAdd");
        IBusinessObject newOrder = action.execute();

        IDatabaseQuery queryProperty = jaxrsContext.getDataService().getPVDatabaseQuery("PropertyQuery");
        queryProperty.getStringSearchExpression("propertyCode", Operator.EQUAL).addValue(order.getOrderPropertyCode());
        IResultSet resultsetProperty = queryProperty.execute();
        
        if (resultsetProperty.next()) {
            newOrder.getReferenceField("PropertyRef").setValue(resultsetProperty.getPrimaryKey());
        }

        IDatabaseQuery querySpace = jaxrsContext.getDataService().getPVDatabaseQuery("SpaceQuery");
        querySpace.getStringSearchExpression("spaceCode", Operator.EQUAL).addValue(order.getOrderRoomCode());
        querySpace.getStringSearchExpression("propertyRef", Operator.EQUAL).addValue(resultsetProperty.getPrimaryKey());
        IResultSet resultsetSpace = querySpace.execute();

        if (resultsetSpace.next()) {
            newOrder.getReferenceField("SpaceRef").setValue(resultsetSpace.getPrimaryKey());
        }

        IDatabaseQuery queryAsset = jaxrsContext.getDataService().getPVDatabaseQuery("AssetQuery");
        queryAsset.getStringSearchExpression("assetCode", Operator.EQUAL).addValue(order.getOrderAssetCode());
        IResultSet resultsetAsset = queryAsset.execute();

        if (resultsetAsset.next()) {
            newOrder.getReferenceField("InventoryItemRef").setValue(resultsetAsset.getPrimaryKey());
        }

        IDatabaseQuery queryService = jaxrsContext.getDataService().getPVDatabaseQuery("ServiceQuery");
        queryService.getStringSearchExpression("serviceCode", Operator.EQUAL).addValue("LOPD 04.01");
        IResultSet resultsetService = queryService.execute();

        if (resultsetService.next()) {
            newOrder.getReferenceField("ServiceAgreementServiceRef").setValue(resultsetService.getPrimaryKey());
        }

        IDatabaseQuery queryPerson = jaxrsContext.getDataService().getPVDatabaseQuery("PersonQuery");
        queryPerson.getStringSearchExpression("personCode", Operator.EQUAL).addValue(order.getRequesterCode());
        IResultSet resultsetPerson = queryPerson.execute();

        if (resultsetPerson.next()) {
            newOrder.getReferenceField("InternalRequestorPersonRef").setValue(resultsetPerson.getPrimaryKey());
        }

        newOrder.getStringField("Description").setValue(order.getOrderDescription());
        newOrder.getStringField("FreeString15").setValue("7");
        newOrder.getStringField("Comment").setValue(order.getOrderComments());

        ResponseDTO response = new ResponseDTO();

        try {
            newOrder.executeSave();
            IDatabaseQuery queryOrder = jaxrsContext.getDataService().getPVDatabaseQuery("OrderQuery");
            queryOrder.getStringSearchExpression("syscode", Operator.EQUAL).addValue(newOrder.getPrimaryKey());
            IResultSet resultsetOrder = queryOrder.execute();

            String orderNumber = "";
            if (resultsetOrder.next()) {
                orderNumber = resultsetOrder.getString("orderNumber");
            }

            response.setStatus(200);
            response.setStatusDescription("Order created: " + orderNumber);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            response.setStatus(400);
            response.setStatusDescription(e.getMessage());
            return Response.ok().entity(response).build();
        }
        
    }
           
}