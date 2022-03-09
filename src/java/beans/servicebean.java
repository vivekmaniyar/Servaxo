/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblServices;
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
@Named(value = "servicebean")
@SessionScoped
public class servicebean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblServices> services = new ArrayList<TblServices>();
    TblServices newservice = new TblServices();
    TblServices currentservice;
    GenericType<Collection<TblServices>> gservices = new GenericType<Collection<TblServices>>(){};
    Collection<TblServices> filteredservice;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public servicebean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllServices(Response.class);
        services = res.readEntity(gservices);
    }

    public TblServices getNewservice() {
        return newservice;
    }

    public void setNewservice(TblServices newservice) {
        this.newservice = newservice;
    }

    public TblServices getCurrentservice() {
        return currentservice;
    }

    public void setCurrentservice(TblServices currentservice) {
        this.currentservice = currentservice;
    }

    public Collection<TblServices> getFilteredservice() {
        return filteredservice;
    }

    public void setFilteredservice(Collection<TblServices> filteredservice) {
        this.filteredservice = filteredservice;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblServices service = (TblServices) value;
        return service.getServiceName().toLowerCase().contains(filtertext) || service.getType().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblServices> viewservices(){
        return services;
    }
    
    public String addservice(){
        Integer serviceprice = newservice.getServicePrice();
        client.insertService(newservice.getServiceName(), newservice.getServiceDescription(), serviceprice.toString(), newservice.getIsactive(), newservice.getType(), datetime, datetime);
        newservice = new TblServices();
        serviceprice = null;
        res = client.getAllServices(Response.class);
        services = res.readEntity(gservices);
        return "viewservices.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updateservice.jsf?faces-redirect=true";
    }
    
    public String updateservice(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        Integer serviceprice = currentservice.getServicePrice();
        client.updateService(currentservice.getServiceId().toString(), currentservice.getServiceName(), currentservice.getServiceDescription(), serviceprice.toString(), currentservice.getIsactive(), currentservice.getType(), updatetime);
        return "viewservices.jsf?faces-redirect=true";
    }
    
    public String changestatus(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        String status;
        if(currentservice.getIsactive().equals("no")){
            status = "yes";
        }else{
            status = "no";
        }
        client.updateActiveService(currentservice.getServiceId().toString(), status, updatetime);
        res = client.getAllServices(Response.class);
        services = res.readEntity(gservices);
        return "viewservices.jsf?faces-redirect=true";
    }
    
    public void deleteservice(TblServices service){
        services.remove(service);
        client.deleteService(service.getServiceId().toString());
    }
}
