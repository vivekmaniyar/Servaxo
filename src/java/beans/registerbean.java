/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.userclient;
import entities.Usermaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author vicky
 */
@Named(value = "registerbean")
@SessionScoped
public class registerbean implements Serializable {

    Usermaster newuser = new Usermaster();
    userclient client = new userclient();
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public registerbean() {
    }

    public Usermaster getNewuser() {
        return newuser;
    }

    public void setNewuser(Usermaster newuser) {
        this.newuser = newuser;
    }
    
    public String registeradmin(){
        client.registerUser("2", newuser.getUsername(), newuser.getPassword(), newuser.getName(), newuser.getContact(), datetime, datetime);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration successful"));
        newuser = null;
        return "loginAdmin.jsf";
    }
    
    public String registeruser(){
        client.registerUser("1", newuser.getUsername(), newuser.getPassword(), newuser.getName(), newuser.getContact(), datetime, datetime);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration successful"));
        newuser = null;
        return "registeruser.jsf";
    }
}
