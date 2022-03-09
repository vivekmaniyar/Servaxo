/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblFeedback;
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
@Named(value = "feedbackbean")
@SessionScoped
public class feedbackbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblFeedback> feedbacks = new ArrayList<TblFeedback>(){};
    Collection<TblFeedback> filteredfeedbacks;
    GenericType<Collection<TblFeedback>> gfeedbacks = new GenericType<Collection<TblFeedback>>(){};
    
    public feedbackbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllFeedbacks(Response.class);
        feedbacks = res.readEntity(gfeedbacks);
    }
    
    public Collection<TblFeedback> viewfeedbacks(){
        return feedbacks;
    }

    public Collection<TblFeedback> getFilteredfeedbacks() {
        return filteredfeedbacks;
    }

    public void setFilteredfeedbacks(Collection<TblFeedback> filteredfeedbacks) {
        this.filteredfeedbacks = filteredfeedbacks;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblFeedback feedback = (TblFeedback) value;
        return feedback.getName().toLowerCase().contains(filtertext);
    }
}
