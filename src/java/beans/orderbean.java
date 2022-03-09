/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblOrder;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "orderbean")
@SessionScoped
public class orderbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblOrder> orders = new ArrayList<TblOrder>();
    Collection<TblOrder> filteredorder;
    TblOrder selectedorder;
    GenericType<Collection<TblOrder>> gorders = new GenericType<Collection<TblOrder>>(){};
    String orderstatus;
    
    public orderbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllOrders(Response.class);
        orders = res.readEntity(gorders);
    }

    public TblOrder getSelectedorder() {
        return selectedorder;
    }

    public void setSelectedorder(TblOrder selectedorder) {
        this.selectedorder = selectedorder;
    }
    
    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
    
    public Collection<TblOrder> getFilteredorder() {
        return filteredorder;
    }

    public void setFilteredorder(Collection<TblOrder> filteredorder) {
        this.filteredorder = filteredorder;
    }

    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblOrder order = (TblOrder) value;
        return order.getOrderId().toString().toLowerCase().contains(filtertext)
                || order.getCityId().getCityName().toLowerCase().contains(filtertext)
                || order.getUserId().getName().toLowerCase().contains(filtertext)
                || order.getPaymode().toLowerCase().contains(filtertext)
                || order.getStatus().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblOrder> vieworders(){
        return orders;
    }
    
    public String redirecttoupdate(){
        return "updateorderstatus.jsf?faces-redirect=true";
    }
    
    public String changestatus(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String updatetime = df.format(currenttimestamp);
        String status = selectedorder.getStatus();
        
        client.updateorderStatus(selectedorder.getOrderId().toString(), status, updatetime);
        res = client.getAllOrders(Response.class);
        orders = res.readEntity(gorders);
        
        return "vieworders.jsf?faces-redirect=true";
    }
}
