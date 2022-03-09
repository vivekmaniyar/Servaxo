/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblServiceorder;
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
@Named(value = "serviceorderbean")
@SessionScoped
public class serviceorderbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblServiceorder> serviceorders = new ArrayList<TblServiceorder>();
    Collection<TblServiceorder> filteredserviceorders;
    TblServiceorder selectedserviceorders;
    GenericType<Collection<TblServiceorder>> gserviceorders = new GenericType<Collection<TblServiceorder>>(){};
    String serviceorderstatus;
    
    public serviceorderbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllServiceOrders(Response.class);
        serviceorders = res.readEntity(gserviceorders);
    }

    public Collection<TblServiceorder> getFilteredserviceorders() {
        return filteredserviceorders;
    }

    public void setFilteredserviceorders(Collection<TblServiceorder> filteredserviceorders) {
        this.filteredserviceorders = filteredserviceorders;
    }

    public TblServiceorder getSelectedserviceorders() {
        return selectedserviceorders;
    }

    public void setSelectedserviceorders(TblServiceorder selectedserviceorders) {
        this.selectedserviceorders = selectedserviceorders;
    }

    public String getServiceorderstatus() {
        return serviceorderstatus;
    }

    public void setServiceorderstatus(String serviceorderstatus) {
        this.serviceorderstatus = serviceorderstatus;
    }

    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblServiceorder serviceorder = (TblServiceorder) value;
        return serviceorder.getServiceorderId().toString().contains(filtertext)
                || serviceorder.getModelId().getModelName().toLowerCase().contains(filtertext)
                || serviceorder.getStatus().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblServiceorder> viewserviceorders(){
        return serviceorders;
    }
    
    public String redirecttoupdate(){
        return "updateservicestatus.jsf?faces-redirect=true";
    }
    
    public String changestatus(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String updatetime = df.format(currenttimestamp);
        serviceorderstatus = selectedserviceorders.getStatus();
        
        client.updateStatus(selectedserviceorders.getServiceorderId().toString(), serviceorderstatus, updatetime);
        res = client.getAllServiceOrders(Response.class);
        serviceorders = res.readEntity(gserviceorders);
        return "viewserviceorders.jsf?faces-redirect=true";
    }
}
