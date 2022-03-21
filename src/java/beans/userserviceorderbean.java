/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import ejb.UserLocal;
import entities.*;
import entities.TblServicecart;
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
@Named(value = "userserviceorderbean")
@SessionScoped
public class userserviceorderbean implements Serializable {

    @EJB UserLocal ul;
    @EJB AdminLocal al;
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    HttpSession session = (HttpSession) ec.getSession(true);
    
    ////////////////////////////////////////Change UserId//////////////////////////////////////////////////////////////
    Integer userId=3;
    
    Integer serviceId,qty=1,total,pincode,companyId,modelId,serviceCartId;

    public Integer getServiceCartId() {
        return serviceCartId;
    }

    public void setServiceCartId(Integer serviceCartId) {
        this.serviceCartId = serviceCartId;
    }
    String vehicleNumber,address1,address2,landmark,remark;
    Collection<TblModel> model;
    //Getter setter thi baaki
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    TblServiceorder currentServiceOrder;

    public TblServiceorder getCurrentServiceOrder() {
        return currentServiceOrder;
    }

    public void setCurrentServiceOrder(TblServiceorder currentServiceOrder) {
        this.currentServiceOrder = currentServiceOrder;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Collection<TblModel> getModel() {
        return model;
    }

    public void setModel(Collection<TblModel> model) {
        this.model = model;
    }
    
    public String addToCart(Integer serviceId){
        if(session.getAttribute("username")!=null){
            total = 0;
            this.ul.addToServiceCart(serviceId, userId, datetime, datetime);
            return "";
        }
        else{
            return "userLogin.jsf?faces-redirect=true";
        }
        
    }
    
    public Collection<TblServicecart> viewServiceCart(){
        total=0;
        return this.ul.viewServiceCart(userId);
    }
    
    public Collection<TblCompany> allCompanies(){
        return this.al.getAllCompanies();
    }
    
    public void dropCompany(AjaxBehaviorEvent event){
        model = al.getModelsByCompany(companyId);
    }
    
    public String placeOrder(){
        this.ul.addServiceOrder(userId, modelId, vehicleNumber, remark, datetime, address1, address2, pincode, landmark, "Pending", datetime, datetime);
        vehicleNumber = "";
        remark = "";
        address1="";
        address2="";
        pincode=null;
        landmark="";
        return "userServiceOrders.jsf?faces-redirect=true";
    }
    
    public Collection<TblServiceorder> allOrders(){
        return this.ul.getUserServiceOrders(userId);
    }
    
    public String removePart(Integer serviceCartId, Integer serviceId){
        this.ul.removeService(serviceCartId, serviceId, userId, datetime);
        return "";
    }
    
    public String getDetails(){
        return "userServiceOrderDetail.jsf?faces-redirect=true";
    }
    
    public Collection<TblServicelist> orderDetails(Integer serviceOrderId){
        total = 0;
        return this.ul.serviceOrderDetails(serviceOrderId);
    }
    public userserviceorderbean() {
    }
    
}
