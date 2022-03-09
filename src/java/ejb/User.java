/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Groupmaster;
import entities.TblCart;
import entities.TblCity;
import entities.TblModel;
import entities.TblOrder;
import entities.TblOrderdetail;
import entities.TblOrderdetailPK;
import entities.TblParts;
import entities.TblServicecart;
import entities.TblServicelist;
import entities.TblServicelistPK;
import entities.TblServiceorder;
import entities.TblServices;
import entities.Usermaster;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author Admin
 */
@Stateless
public class User implements UserLocal {
@PersistenceContext(unitName="ServaxoTestPU")
EntityManager em;

@Inject Pbkdf2PasswordHash hasher;

    @Override
    public void registerUser(Integer groupId, String username, String password, String name, String contact, String regDate, String updatedAt) {
       Usermaster um = new Usermaster();
       Groupmaster grp = em.find(Groupmaster.class, groupId);
       um.setGroupId(grp);
       um.setUsername(username);
       um.setPassword(hasher.generate(password.toCharArray()));
       um.setName(name);
       um.setContact(contact);
       um.setRegDatetime(regDate);
       um.setUpdatedAt(updatedAt);
       em.persist(um);
    }

    @Override
    public void addToCart(Integer partId, Integer userId, Integer qty, String createdAt, String updatedAt) {
        TblCart tc = new TblCart();
        TblParts tp = em.find(TblParts.class, partId);
        tc.setPartId(tp);
        Usermaster um = em.find(Usermaster.class, userId);
        tc.setUserId(um);
        tc.setQty(qty);
        tc.setCreatedAt(createdAt);
        tc.setUpdatedAt(updatedAt);
        em.persist(tc);
    }

    @Override
    public void removePart(Integer cart_id, Integer partId, Integer userId, Integer qty, String updatedAt) {
        TblCart tc = em.find(TblCart.class, cart_id);
        TblParts tp = em.find(TblParts.class, partId);
        Usermaster um = em.find(Usermaster.class, userId);
        if(tc.getPartId()==tp && tc.getUserId()==um){
            em.remove(tc);
        }
    }

    @Override
    public void emptyCart(Integer user_id) {
        Query query = em.createNativeQuery("delete t from tbl_cart t where t.user_id = "+user_id);
        query.executeUpdate();
    }
    
    @Override
    public Collection<TblOrder> getUserOrders(Integer userId) {
        Usermaster u = em.find(Usermaster.class, userId);
        List orders = em.createNamedQuery("TblOrder.findByUserId").setParameter("userId", u).getResultList();
        return orders;
    }
    
    @Override
    public void placeOrder(Integer userId, Integer cityId, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt) {
        TblOrder to = new TblOrder();
        Usermaster u = em.find(Usermaster.class, userId);
        TblCity city = em.find(TblCity.class, cityId);
    Iterable<TblCart> carts = em.createNamedQuery("TblCart.findByUserId").setParameter("userId", u).getResultList();
        Collection<Integer> parts = new ArrayList<>();
        for(TblCart cart: carts){
            Integer temp =(cart.getPartId().getPrice() * cart.getQty());
            parts.add(temp);
        }
        Integer totalpay = 0;
        for(Integer part: parts){
            totalpay = (totalpay + part);
        }
        to.setUserId(u);
        to.setCityId(city);
        to.setTotalPayment(totalpay);
        to.setIspay(isPay);
        to.setPaymode(payMode);
        to.setAddressline1(addressline1);
        to.setAddressline2(addressline2);
        to.setLandmark(landmark);
        to.setPincode(pincode);
        to.setStatus(status);
        to.setOrderDatetime(orderDate);
        to.setUpdatesAt(updatedAt);
        em.persist(to);
        em.flush();
        Integer orderId = to.getOrderId();
        for(TblCart cart: carts){
            TblOrderdetail td = new TblOrderdetail();
            TblOrderdetailPK tk = new TblOrderdetailPK();
            tk.setOrderId(orderId);
            tk.setPartId(cart.getPartId().getPartId());
            td.setQty(cart.getQty());
            td.setTblOrderdetailPK(tk);
            td.setCreatedAt(orderDate);
            td.setUpdatedAt(updatedAt);
            em.persist(td);
            em.remove(cart);
        }
    }
    
    @Override
    public void cancelOrder(Integer orderId, Integer userId, String status) {
        TblOrder to = em.find(TblOrder.class, orderId);
        to.setStatus("cancelled");
        em.merge(to);
    }

    @Override
    public void addToServiceCart(Integer serviceId, Integer userId, String createdAt, String updatedAt) {
        TblServicecart tc = new TblServicecart();
        TblServices ts = em.find(TblServices.class, serviceId);
        tc.setServiceId(ts);
        Usermaster um = em.find(Usermaster.class, userId);
        tc.setUserId(um);
        tc.setCreatedAt(createdAt);
        tc.setUpdatedAt(updatedAt);
        em.persist(tc);
    }

    @Override
    public void removeService(Integer servicecart_id, Integer serviceId, Integer userId, String updatedAt) {
        TblServicecart tc = em.find(TblServicecart.class, servicecart_id);
        TblServices ts = em.find(TblServices.class, serviceId);
        Usermaster um = em.find(Usermaster.class, userId);
        if(tc.getServiceId()==ts && tc.getUserId()==um){
            em.remove(tc);
        }
    }

    @Override
    public void emptyServiceCart(Integer user_id) {
        Query query = em.createNativeQuery("delete t from tbl_servicecart t where t.user_id = "+user_id);
        query.executeUpdate();
    }

    @Override
    public void addServiceOrder(Integer userId, Integer modelId, String vehicleNo, String remark, String pickupDate, String addressline1, String addressline2, Integer pincode, String landmark, String status, String orderDate, String updatedAt) {
        TblServiceorder ts = new TblServiceorder();    
        Usermaster um = em.find(Usermaster.class, userId);
        Iterable<TblServicecart> carts = em.createNamedQuery("TblServicecart.findByUserId").setParameter("userId", um).getResultList();
        Collection<Integer> services = new ArrayList<>();
        for(TblServicecart cart: carts){
            Integer temp =(cart.getServiceId().getServicePrice());
            services.add(temp);
        }
        Integer totalpay = 0;
        for(Integer service: services){
            totalpay = totalpay + service;
        }
        ts.setUserId(um);
        TblModel tm = em.find(TblModel.class, modelId);
        ts.setModelId(tm);
        ts.setVehicleNo(vehicleNo);
        ts.setRemark(remark);
        ts.setTotalPayment(totalpay);
        ts.setPickUpDate(pickupDate);
        ts.setAddressline1(addressline1);
        ts.setAddressline2(addressline2);
        ts.setPincode(pincode);
        ts.setLandmark(landmark);
        ts.setStatus(status);
        ts.setOrderdatetime(orderDate);
        ts.setUpdatedAt(updatedAt);
        em.persist(ts);
        em.flush();
        Integer serviceorderId = ts.getServiceorderId();
        for(TblServicecart cart: carts){
            TblServicelist tsl = new TblServicelist();
            TblServicelistPK tslk = new TblServicelistPK();
            tslk.setUserVehicleId(serviceorderId);
            tslk.setServiceId(cart.getServiceId().getServiceId());
            tsl.setTblServicelistPK(tslk);
            tsl.setCreatedAt(orderDate);
            tsl.setUpdatedAt(updatedAt);
            em.persist(tsl);
            em.remove(cart);
        }
    }
    
    @Override
    public void cancelServiceOrder(Integer serviceOrderId, Integer userId, String status) {
        TblServiceorder ts = em.find(TblServiceorder.class, serviceOrderId);
        ts.setStatus("cancelled");
        em.merge(ts);
    }

    @Override
    public Collection<TblServiceorder> getUserServiceOrders(Integer userId) {
        Usermaster u = em.find(Usermaster.class, userId);
    List sOrder = em.createNamedQuery("TblServiceorder.findByUserId").setParameter("userId", u).getResultList();
        return sOrder;
    }

    @Override
    public Collection<TblCart> viewCart(Integer userId) {
        Usermaster u = em.find(Usermaster.class, userId);
        List tc = em.createNamedQuery("TblCart.findByUserId").setParameter("userId", u).getResultList();
        return tc;
    }

    @Override
    public Collection<TblServicecart> viewServiceCart(Integer userId) {
        Usermaster u = em.find(Usermaster.class, userId);
        List tsc = em.createNamedQuery("TblServicecart.findByUserId").setParameter("userId", u).getResultList();
        return tsc;
    }

    @Override
    public Collection<TblOrderdetail> orderDetails(Integer orderId) {
        List od = em.createNamedQuery("TblOrderdetail.findByOrderId").setParameter("orderId", orderId).getResultList();
        return od;
    }
}
