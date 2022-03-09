/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entities.TblCart;
import entities.TblOrder;
import entities.TblOrderdetail;
import entities.TblServicecart;
import entities.TblServiceorder;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
//REGISTRATION MODULE
public interface UserLocal {

    void registerUser(Integer groupId, String username, String password, String name, String contact, String regDate, String updatedAt);

//CART MODULE
    void addToCart(Integer partId, Integer userId, Integer qty, String createdAt, String updatedAt);

    void removePart(Integer cart_id, Integer partId, Integer userId, Integer qty, String updatedAt);

    void emptyCart(Integer user_id);
    
    Collection<TblCart> viewCart(Integer userId);

//SERVICE CART
    void addToServiceCart(Integer serviceId, Integer userId, String createdAt, String updatedAt);

    void removeService(Integer servicecart_id, Integer serviceId, Integer userId, String updatedAt);

    void emptyServiceCart(Integer user_id);
    
    Collection<TblServicecart> viewServiceCart(Integer userId);

//PART ORDER MODULE
//    void placeOrder(Integer orderId, Integer userId, Integer cityId, Integer totalPayment, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt);
    void placeOrder(Integer userId, Integer cityId, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt);

    Collection<TblOrder> getUserOrders(Integer userId);

    void cancelOrder(Integer orderId, Integer userId, String status);
    
    Collection<TblOrderdetail> orderDetails(Integer orderId);

//SERVICE ORDER MODULE
    void addServiceOrder(Integer userId, Integer modelId, String vehicleNo, String remark, String pickupDate, String addressline1, String addressline2, Integer pincode, String landmark, String status, String orderDate, String updatedAt);
    Collection<TblServiceorder> getUserServiceOrders(Integer userId);
    void cancelServiceOrder(Integer serviceOrderId, Integer userId, String status);
}
