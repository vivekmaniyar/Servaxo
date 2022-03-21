/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import ejb.UserLocal;
import entities.*;
import entities.TblCity;
import entities.TblState;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c computer
 */
@Named(value = "userorderbean")
@SessionScoped
public class userorderbean implements Serializable {
    @EJB UserLocal ul;
    @EJB AdminLocal al;
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    HttpSession session = (HttpSession) ec.getSession(true);
    String userName = (String) session.getAttribute("username");
    
    /////////////////////////////////////////Change UserId///////////////////////////////////////////////////////
    
    Integer userId = 3;
//    Integer userId = al.getUserId(userName);
    Integer partId,qty=1,total,cityId,pincode;
    TblOrder currentOrder;
    String username = (String) session.getAttribute("username");
    public TblOrder getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(TblOrder currentOrder) {
        this.currentOrder = currentOrder;
    }
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
    Collection<TblCity> city;

    public Collection<TblCity> getCity() {
        return city;
    }

    public void setCity(Collection<TblCity> city) {
        this.city = city;
    }
    String state,address1,address2,landmark;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public String addToCart(Integer partId){
        if(session.getAttribute("username")!=null){
//           System.out.println(userName);
            this.ul.addToCart(partId, userId, qty, datetime, datetime);
            return ""; 
        }
        else
        {
            return "userLogin.jsf?faces-redirect=true";
        }
        
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }
    
    public Collection<TblCart> viewCart(){
        total=0;
        return this.ul.viewCart(userId);
    }
    
    public Collection<TblState> allStates(){
        return this.al.getAllStates();
    }
    
    public void dropState(AjaxBehaviorEvent event){
       city = al.getCitiesByState(state);
    }
    
    public String placeOrder(){
        this.ul.placeOrder(userId, cityId, "N", "COD", address1, address2, landmark, pincode, "Pending", datetime, datetime);
        return "userOrders?faces-redirect=true";
    }
    
    public Collection<TblOrder> allOrders(){
        return this.ul.getUserOrders(userId);
    }
    
    public String removePart(Integer cartId, Integer partId){
        this.ul.removePart(cartId, partId, userId, qty, datetime);
        return "";
    }
    
    public Collection<TblOrderdetail> orderDetails(Integer orderId){
        total = 0;
        return this.ul.orderDetails(orderId);
    }
    
    public String getDetails(){
        return "userOrderDetail.jsf?faces-redirect=true";
    }
    public userorderbean() {
    }
    
}
