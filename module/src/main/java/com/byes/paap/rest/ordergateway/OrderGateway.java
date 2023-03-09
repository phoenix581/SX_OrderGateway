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

@Path("/document")
public class OrderGateway
{
    @Context 
    IJaxRsResourceContext jaxrsContext;

    @POST
    @Path("/createOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderDTO order) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus(200);
        response.setStatusDescription("Order created.");
        return Response.ok().entity(response).build();
    }
           
}