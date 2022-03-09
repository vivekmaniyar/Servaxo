/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserResource [user]<br>
 * USAGE:
 * <pre>
 *        userclient client = new userclient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vicky
 */
public class userclient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ServaxoTest/webresources";
    Entity<?> empty = Entity.text("");

    public userclient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }

    public void emptyServiceCart(String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("emptyServiceCart/{0}", new Object[]{user_id})).request().delete();
    }

    public void removeService(String servicecart_id, String serviceId, String userId, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeService/{0}/{1}/{2}/{3}", new Object[]{servicecart_id, serviceId, userId, updatedAt})).request().delete();
    }

    public void placeOrder(String userId, String cityId, String isPay, String payMode, String addressline1, String addressline2, String landmark, String pincode, String status, String orderDate, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("placeOrder/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{userId, cityId, isPay, payMode, addressline1, addressline2, landmark, pincode, status, orderDate, updatedAt})).request().post(null);
    }

    public void cancelOrder(String orderId, String userId, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("cancelOrder/{0}/{1}/{2}", new Object[]{orderId, userId, status})).request().put(empty);
    }

    public <T> T getUserOrders(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserOrders/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void cancelServiceOrder(String serviceOrderId, String userId, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("cancelServiceOrder/{0}/{1}/{2}", new Object[]{serviceOrderId, userId, status})).request().put(empty);
    }

    public void registerUser(String groupId, String username, String password, String name, String contact, String regDate, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registerUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{groupId, username, password, name, contact, regDate, updatedAt})).request().post(null);
    }

    public void emptyCart(String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("emptyCart/{0}", new Object[]{user_id})).request().delete();
    }

    public void addToCart(String partId, String userId, String qty, String createdAt, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}/{3}/{4}", new Object[]{partId, userId, qty, createdAt, updatedAt})).request().post(null);
    }

    public void addServiceOrder(String userId, String modelId, String vehicleNo, String remark, String pickupDate, String addressline1, String addressline2, String pincode, String landmark, String status, String orderDate, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addServiceOrder/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{userId, modelId, vehicleNo, remark, pickupDate, addressline1, addressline2, pincode, landmark, status, orderDate, updatedAt})).request().post(null);
    }

    public void addToServiceCart(String serviceId, String userId, String createdAt, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToServiceCart/{0}/{1}/{2}/{3}", new Object[]{serviceId, userId, createdAt, updatedAt})).request().post(null);
    }

    public void removePart(String cart_id, String partId, String userId, String qty, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePart/{0}/{1}/{2}/{3}/{4}", new Object[]{cart_id, partId, userId, qty, updatedAt})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
