/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblCity;
import entities.TblState;
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
@Named(value = "citybean")
@SessionScoped
public class citybean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblCity> cities = new ArrayList<TblCity>();
    Collection<TblState> states = new ArrayList<TblState>();
    TblCity newcity = new TblCity();
    TblCity currentcity;
    TblState selectedstate;
    GenericType<Collection<TblCity>> gcities = new GenericType<Collection<TblCity>>(){};
    GenericType<Collection<TblState>> gstates = new GenericType<Collection<TblState>>(){};
    Collection<TblCity> filteredcity;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    Integer stateid;
    
    public citybean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllCities(Response.class);
        cities = res.readEntity(gcities);
        
    }

    public TblCity getNewcity() {
        return newcity;
    }

    public void setNewcity(TblCity newcity) {
        this.newcity = newcity;
    }

    public TblCity getCurrentcity() {
        return currentcity;
    }

    public void setCurrentcity(TblCity currentcity) {
        this.currentcity = currentcity;
    }

    public Collection<TblCity> getFilteredcity() {
        return filteredcity;
    }

    public void setFilteredcity(ArrayList<TblCity> filteredcity) {
        this.filteredcity = filteredcity;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public TblState getSelectedstate() {
        return selectedstate;
    }

    public void setSelectedstate(TblState selectedstate) {
        this.selectedstate = selectedstate;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblCity city = (TblCity) value;
        return city.getCityName().toLowerCase().contains(filtertext)
                || city.getCityCode().toLowerCase().contains(filtertext)
                || city.getStateId().getStateName().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblCity> viewcities(){
        return cities;
    }
    
    public Collection<TblState> getstates(){
        res = client.getAllStates(Response.class);
        states = res.readEntity(gstates);
        return states;
    }
    
    public String addcity(){
        //System.out.println("Adding city...");
        //newcity.setStateId(selectedstate);
        client.insertCity(newcity.getCityName(), stateid.toString(), newcity.getCityCode(), datetime, datetime);
        newcity = new TblCity();
        stateid = null;
        res = client.getAllCities(Response.class);
        cities = res.readEntity(gcities);
        return "viewcities.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updatecity.jsf?faces-redirect=true";
    }
    
    public String updatecity(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        client.updateCity(currentcity.getCityId().toString(), currentcity.getCityName(), currentcity.getStateId().getStateId().toString(), currentcity.getCityCode(), updatetime);
        res = client.getAllCities(Response.class);
        cities = res.readEntity(gcities);
        return "viewcities.jsf?faces-redirect=true";
    }
    
    public void deletecity(TblCity city){
        cities.remove(city);
        client.deleteCity(city.getCityId().toString());
    }
}
