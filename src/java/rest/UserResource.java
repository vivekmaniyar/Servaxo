/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.UserLocal;
import entities.TblOrder;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;
    
    @EJB UserLocal user;
    public UserResource() {
    }
    
    @POST
    @Path("registerUser/{groupId}/{username}/{password}/{name}/{contact}/{regDate}/{updatedAt}")
    public void registerUser(@PathParam("groupId") Integer groupId , @PathParam("username") String username , @PathParam("password") String password , @PathParam("name") String name , @PathParam("contact") String contact , @PathParam("regDate") String regDate , @PathParam("updatedAt") String updatedAt){
        user.registerUser(groupId, username, password, name, contact, regDate, updatedAt);
    }
    
    //CART MODULE
    
    @POST
    @Path("addToCart/{partId}/{userId}/{qty}/{createdAt}/{updatedAt}")
    public void addToCart(@PathParam("partId") Integer partId, @PathParam("userId") Integer userId, @PathParam("qty") Integer qty, @PathParam("createdAt") String createdAt, @PathParam("updatedAt") String updatedAt){
        user.addToCart(partId, userId, qty, createdAt, updatedAt);
    }
    
    @DELETE
    @Path("removePart/{cart_id}/{partId}/{userId}/{qty}/{updatedAt}")
    public void removePart(@PathParam("cart_id") Integer cart_id, @PathParam("partId") Integer partId, @PathParam("userId") Integer userId, @PathParam("qty") Integer qty, @PathParam("updatedAt") String updatedAt){
        user.removePart(cart_id, partId, userId, qty, updatedAt);
    }
    
    @DELETE
    @Path("emptyCart/{user_id}")
    public void emptyCart(@PathParam("cart_id") Integer user_id){
        user.emptyCart(user_id);
    }
    
    //SERVICE CART
    @POST
    @Path("addToServiceCart/{serviceId}/{userId}/{createdAt}/{updatedAt}")
    public void addToServiceCart(@PathParam("serviceId") Integer serviceId, @PathParam("userId") Integer userId, @PathParam("createdAt") String createdAt, @PathParam("updatedAt") String updatedAt){
        user.addToServiceCart(serviceId, userId, createdAt, updatedAt);
    }
    
    @DELETE
    @Path("removeService/{servicecart_id}/{serviceId}/{userId}/{updatedAt}")
    public void removeService(@PathParam("servicecart_id") Integer servicecart_id, @PathParam("serviceId") Integer serviceId, @PathParam("userId") Integer userId, @PathParam("updatedAt") String updatedAt){
        user.removeService(servicecart_id, serviceId, userId, updatedAt);
    }
    
    @DELETE
    @Path("emptyServiceCart/{user_id}")
    public void emptyServiceCart(@PathParam("user_id") Integer user_id){
        user.emptyServiceCart(user_id);
    }
    
    //PART ORDER MODULE
    @POST
    @Path("placeOrder/{userId}/{cityId}/{isPay}/{payMode}/{addressline1}/{addressline2}/{landmark}/{pincode}/{status}/{orderDate}/{updatedAt}")
    public void placeOrder(@PathParam("userId") Integer userId, @PathParam("cityId") Integer cityId, @PathParam("isPay") String isPay, @PathParam("payMode") String payMode, @PathParam("addressline1") String addressline1, @PathParam("addressline2") String addressline2, @PathParam("landmark") String landmark, @PathParam("pincode") Integer pincode, @PathParam("status") String status, @PathParam("orderDate") String orderDate, @PathParam("updatedAt") String updatedAt){
        user.placeOrder(userId, cityId, isPay, payMode, addressline1, addressline2, landmark, pincode, status, orderDate, updatedAt);
    }
    
    @GET
    @Path("getUserOrders/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrder> getUserOrders(@PathParam("userId") Integer userId){
        return user.getUserOrders(userId);
    }
    
    @PUT
    @Path("cancelOrder/{orderId}/{userId}/{status}")
    public void cancelOrder(@PathParam("orderId") Integer orderId, @PathParam("userId") Integer userId, @PathParam("status") String status){
        user.cancelOrder(orderId, userId, status);
    }
    
    //SERVICE ORDER MODULE
    @POST
    @Path("addServiceOrder/{userId}/{modelId}/{vehicleNo}/{remark}/{pickupDate}/{addressline1}/{addressline2}/{pincode}/{landmark}/{status}/{orderDate}/{updatedAt}")
    public void addServiceOrder(@PathParam("userId") Integer userId, @PathParam("modelId") Integer modelId, @PathParam("vehicleNo") String vehicleNo, @PathParam("remark") String remark, @PathParam("pickupDate") String pickupDate, @PathParam("addressline1") String addressline1, @PathParam("addressline2") String addressline2, @PathParam("pincode") Integer pincode, @PathParam("landmark") String landmark, @PathParam("status") String status, @PathParam("orderDate") String orderDate, @PathParam("updatedAt") String updatedAt){
        user.addToServiceCart(userId, userId, updatedAt, updatedAt);
    }
    
    @PUT
    @Path("cancelServiceOrder/{serviceOrderId}/{userId}/{status}")
    public void cancelServiceOrder(@PathParam("serviceOrderId") Integer serviceOrderId, @PathParam("userId") Integer userId, @PathParam("status") String status){
        user.cancelServiceOrder(serviceOrderId, userId, status);
    }

}
