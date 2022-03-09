/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import ejb.AdminLocal;
import entities.TblCompany;
import entities.TblModel;
import entities.TblPartcategory;
import entities.TblParts;
import entities.TblServices;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author c computer
 */
@Named(value = "userHome")
@SessionScoped
public class userHome implements Serializable {
    
    adminClient arc = new adminClient();
    @EJB AdminLocal al;
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    Response res;
    Collection<TblParts> parts;
    Collection<TblModel> model;
  
    public Collection<TblParts> getParts() {
        return parts;
    }

    public void setParts(Collection<TblParts> parts) {
        this.parts = parts;
    }

    public Collection<TblModel> getModel() {
        return model;
    }

    public void setModel(Collection<TblModel> model) {
        this.model = model;
    }
    Collection<TblCompany> company;
    GenericType<Collection<TblParts>> gParts = new GenericType<Collection<TblParts>>(){
    };  
    Integer partId, price;
    Integer companyId, modelId;

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
    String partName, partDescription, image1;

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
    
    public Collection<TblParts> allParts(){
//        res =   arc.getAllParts(Response.class);
//        parts = res.readEntity(gParts);
//        return parts;
        return this.al.getAllParts();
    }
    
    public Collection<TblPartcategory> allCats(){
        return this.al.getAllPartCategories();
    }
    
    public Collection<TblCompany> allCompanies(){
        return this.al.getAllCompanies();
    }
    
    public Collection<TblModel> allModels(){
        return this.al.getAllModels();
    }

    public Collection<TblServices> allServices(){
        return this.al.getAllServices();
    }
    public userHome() {
    }
    
    
    
}
