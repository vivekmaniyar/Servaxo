/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
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
import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "statebean")
@SessionScoped
public class statebean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblState> states = new ArrayList<TblState>();
    TblState newstate = new TblState();
    TblState currentstate;
    GenericType<Collection<TblState>> gstates = new GenericType<Collection<TblState>>(){};
    Collection<FilterMeta> filterby;
    boolean globalfilteronly;
    Collection<TblState> filteredstate;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public statebean() {
    }
    
    @PostConstruct
    public void init(){
        globalfilteronly = false;
        //FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //states = new ArrayList<TblState>();
        //gstates = new GenericType<Collection<TblState>>(){};
        res = client.getAllStates(Response.class);
        states = res.readEntity(gstates);
        //currentstate = new TblState();
    }

    public TblState getNewstate() {
        return newstate;
    }

    public void setNewstate(TblState newstate) {
        this.newstate = newstate;
    }

    public TblState getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(TblState currentstate) {
        this.currentstate = currentstate;
    }
    
    public Collection<TblState> getFilteredstate() {
        return filteredstate;
    }

    public void setFilteredstate(ArrayList<TblState> filteredstate) {
        this.filteredstate = filteredstate;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblState state = (TblState) value;
        return state.getStateName().toLowerCase().contains(filtertext) || state.getStateCode().toLowerCase().contains(filtertext);
    }

    public Collection<TblState> viewstates(){
        return states;
    }
    
    public String addstate(){
        //states.add(this.newstate);
        client.insertState(newstate.getStateName(), newstate.getStateCode(), datetime, datetime);
        newstate = new TblState();
        res = client.getAllStates(Response.class);
        states = res.readEntity(gstates);
        return "viewStates.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updateState.jsf?faces-redirect=true";
    }
    public String updatestate(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        System.out.println("Current State ID: " +currentstate.getStateId());
        client.updateState(currentstate.getStateId().toString(), currentstate.getStateName(), currentstate.getStateCode(), updatetime);
        return "viewStates.jsf?faces-redirect=true";
    }
    
    public void deletestate(TblState state){
        states.remove(state);
        client.deleteState(state.getStateId().toString());
    }
}
