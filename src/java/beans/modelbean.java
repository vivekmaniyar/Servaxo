/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblCompany;
import entities.TblModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "modelbean")
@SessionScoped
public class modelbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblModel> models = new ArrayList<TblModel>();
    Collection<TblCompany> companies = new ArrayList<TblCompany>();
    TblModel newmodel = new TblModel();
    TblModel currentmodel;
    UploadedFile file;
    String uploadedfile;
    TblCompany selectedcompany;
    GenericType<Collection<TblModel>> gmodels = new GenericType<Collection<TblModel>>(){};
    GenericType<Collection<TblCompany>> gcompanies = new GenericType<Collection<TblCompany>>(){};
    Collection<TblModel> filteredmodel;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    Integer companyid;
    
    public modelbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllModels(Response.class);
        models = res.readEntity(gmodels);
    }

    public TblModel getNewmodel() {
        return newmodel;
    }

    public void setNewmodel(TblModel newmodel) {
        this.newmodel = newmodel;
    }

    public TblModel getCurrentmodel() {
        return currentmodel;
    }

    public void setCurrentmodel(TblModel currentmodel) {
        this.currentmodel = currentmodel;
    }

    public TblCompany getSelectedcompany() {
        return selectedcompany;
    }

    public void setSelectedcompany(TblCompany selectedcompany) {
        this.selectedcompany = selectedcompany;
    }

    public Collection<TblModel> getFilteredmodel() {
        return filteredmodel;
    }

    public void setFilteredmodel(Collection<TblModel> filteredmodel) {
        this.filteredmodel = filteredmodel;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblModel model = (TblModel) value;
        return model.getModelName().toLowerCase().contains(filtertext)
                || model.getCompanyId().getCompanyName().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblModel> viewmodels(){
        return models;
    }
    
    public Collection<TblCompany> getcompanies(){
        res = client.getAllCompanies(Response.class);
        companies = res.readEntity(gcompanies);
        return companies;
    }
    
    public void handlefileupload(FileUploadEvent event){
        String destination="C:\\Users\\vicky\\Desktop\\ServaxoTest\\web\\uploads\\vehiclemodels\\";
        file = event.getFile();
        uploadedfile = event.getFile().getFileName();
        try{
            InputStream input = file.getInputStream();
            OutputStream output = new FileOutputStream(new File(destination+event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = input.read(bytes))!= -1){
                output.write(bytes, 0, read);
            }
            input.close();
            output.flush();
            output.close();
            file=null;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String addmodel(){
        client.insertModel(uploadedfile, newmodel.getModelName(), companyid.toString(), datetime, datetime);
        newmodel = new TblModel();
        companyid = null;
        uploadedfile = null;
        res = client.getAllModels(Response.class);
        models = res.readEntity(gmodels);
        return "viewmodels.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updatemodel.jsf?faces-redirect=true";
    }
    
    public String updatemodel(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        if(uploadedfile==null){
            uploadedfile = currentmodel.getModelImg();
        }
        client.updateModel(uploadedfile, currentmodel.getModelId().toString(), currentmodel.getModelName(), currentmodel.getCompanyId().getCompanyId().toString(), updatetime);
        res = client.getAllModels(Response.class);
        models = res.readEntity(gmodels);
        return "viewmodels.jsf?faces-redirect=true";
    }
    
    public void deletemodel(TblModel model){
        models.remove(model);
        client.deleteModel(model.getModelId().toString());
    }
}
