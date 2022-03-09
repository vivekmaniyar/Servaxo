/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.Usermaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "userbean")
@SessionScoped
public class userbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<Usermaster> users = new ArrayList<Usermaster>();
    Collection<Usermaster> filtereduser;
    GenericType<Collection<Usermaster>> gusers = new GenericType<Collection<Usermaster>>(){};    
    
    public userbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllUsers(Response.class);
        users = res.readEntity(gusers);
    }

    public Collection<Usermaster> getFiltereduser() {
        return filtereduser;
    }

    public void setFiltereduser(Collection<Usermaster> filtereduser) {
        this.filtereduser = filtereduser;
    }
    
    public Collection<Usermaster> viewusers(){
        return users;
    }

    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        Usermaster user = (Usermaster) value;
        return user.getName().toLowerCase().contains(filtertext) || user.getUsername().toLowerCase().contains(filtertext) 
                || user.getContact().toLowerCase().contains(filtertext)
                || user.getGroupId().getGroupName().toLowerCase().contains(filtertext);
    }
}
