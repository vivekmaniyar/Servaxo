/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import entities.Usermaster;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vicky
 */
@Named(value = "loginbean")
@SessionScoped
public class loginbean implements Serializable{
    
    @PersistenceContext(name="ServaxoTestPU")
    EntityManager em;
    
    @Inject FacesContext facescontext;
    //FacesContext context;
    ExternalContext ec;
    
    @Inject SecurityContext securitycontext;
    //@Inject IdentityStoreHandler handler;
    
    
    //CredentialValidationResult result;
    
    String username;
    String password;
    AuthenticationStatus status;
    
    public loginbean() {
        //this.context = FacesContext.getCurrentInstance();
    }
    
//    @PostConstruct
//    public void init(){
//        //context = FacesContext.getCurrentInstance();
//        ec = facescontext.getExternalContext();
//    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

//    public CredentialValidationResult getResult() {
//        return result;
//    }
//
//    public void setResult(CredentialValidationResult result) {
//        this.result = result;
//    }
    
    public void login() throws IOException{
        
        try{
            ec = facescontext.getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(true);
            session.setAttribute("username", username);
            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            //result = handler.validate(credential);
            //HttpSession session = (HttpSession) ec.getSession(false);
            //session.setAttribute("user", securitycontext.getCallerPrincipal().getName());
            AuthenticationStatus status = securitycontext.authenticate((HttpServletRequest)ec.getRequest(), (HttpServletResponse)ec.getResponse(), withParams().credential(credential));
            //System.out.println(ec.getUserPrincipal().getName());
            if(securitycontext.isCallerInRole("admin")){
                //System.out.println(status);
                ec.redirect("dashboard.jsf");
                //return "dashboard.jsf?faces-redirect=true";
            }else if(securitycontext.isCallerInRole("user")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Login Successful"));
                ec.redirect("/ServaxoTest/index.jsf");
                //return "/index.jsf";
            }else{
                String message = "Either username or password is wrong";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            }
            
        }catch(Exception e){
            System.out.println(e);
            ec.redirect("loginAdmin.jsf?faces-redirect=true");
            //return "loginAdmin.jsf";
        }
        //facescontext.renderResponse();
        facescontext.responseComplete();
        //return null;
        
    }
    
    public String logout() throws ServletException{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.logout();
        return "loginAdmin.jsf?faces-redirect=true";
    }
}
