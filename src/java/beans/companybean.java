/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblCompany;
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
@Named(value = "companybean")
@SessionScoped
public class companybean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblCompany> companies = new ArrayList<TblCompany>();
    TblCompany newcompany = new TblCompany();
    TblCompany currentcompany;
    UploadedFile file;
    String uploadedfile;
    GenericType<Collection<TblCompany>> gcompanies = new GenericType<Collection<TblCompany>>(){};
    Collection<TblCompany> filteredcompany;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public companybean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllCompanies(Response.class);
        companies = res.readEntity(gcompanies);
    }

    public TblCompany getNewcompany() {
        return newcompany;
    }

    public void setNewcompany(TblCompany newcompany) {
        this.newcompany = newcompany;
    }

    public TblCompany getCurrentcompany() {
        return currentcompany;
    }

    public void setCurrentcompany(TblCompany currentcompany) {
        this.currentcompany = currentcompany;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getUploadedfile() {
        return uploadedfile;
    }

    public void setUploadedfile(String uploadedfile) {
        this.uploadedfile = uploadedfile;
    }

    public Collection<TblCompany> getFilteredcompany() {
        return filteredcompany;
    }

    public void setFilteredcompany(Collection<TblCompany> filteredcompany) {
        this.filteredcompany = filteredcompany;
    }

    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblCompany company = (TblCompany) value;
        return company.getCompanyName().toLowerCase().contains(filtertext) || company.getCompanyType().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblCompany> viewcompanies(){
        return companies;
    }
    
    public void handlefileupload(FileUploadEvent event){
        String destination="C:\\Users\\vicky\\Desktop\\ServaxoTest\\web\\uploads\\companylogos\\";
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
            file = null;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String addcompany(){
        client.insertcompany(uploadedfile, newcompany.getCompanyName(), newcompany.getCompanyType(), datetime, datetime);
        newcompany = new TblCompany();
        uploadedfile = null;
        res = client.getAllCompanies(Response.class);
        companies = res.readEntity(gcompanies);
        return "viewcompanies.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updatecompany.jsf?faces-redirect=true";
    }
    
    public String updatecompany(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        if(uploadedfile==null){
            uploadedfile = currentcompany.getCompanyLogo();
        }
        client.updateCompany(uploadedfile, currentcompany.getCompanyId().toString(), currentcompany.getCompanyName(), currentcompany.getCompanyType(), updatetime);
        res = client.getAllCompanies(Response.class);
        companies = res.readEntity(gcompanies);
        return "viewcompanies.jsf?faces-redirect=true";
    }
    
    public void deletecompany(TblCompany company){
        companies.remove(company);
        client.deletecompany(company.getCompanyId().toString());
    }
}
