/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblPartcategory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "partcategorybean")
@SessionScoped
public class partcategorybean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblPartcategory> categories = new ArrayList<TblPartcategory>();
    TblPartcategory newcategory = new TblPartcategory();
    TblPartcategory currentcategory;
    UploadedFile file;
    String uploadedfile;
    GenericType<Collection<TblPartcategory>> gcategories = new GenericType<Collection<TblPartcategory>>(){};
    Collection<TblPartcategory> filteredcategory;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public partcategorybean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllPartCategories(Response.class);
        categories = res.readEntity(gcategories);
    }
    
    public TblPartcategory getNewcategory() {
        return newcategory;
    }

    public void setNewcategory(TblPartcategory newcategory) {
        this.newcategory = newcategory;
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

    public TblPartcategory getCurrentcategory() {
        return currentcategory;
    }

    public void setCurrentcategory(TblPartcategory currentcategory) {
        this.currentcategory = currentcategory;
    }

    public Collection<TblPartcategory> getFilteredcategory() {
        return filteredcategory;
    }

    public void setFilteredcategory(Collection<TblPartcategory> filteredcategory) {
        this.filteredcategory = filteredcategory;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblPartcategory category = (TblPartcategory) value;
        return category.getCategoryName().toLowerCase().contains(filtertext) || category.getVehicleType().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblPartcategory> viewcategories(){
        return categories;
    }
    
    public void handlefileupload(FileUploadEvent event){
        String destination="C:\\Users\\vicky\\Desktop\\ServaxoTest\\web\\uploads\\partcategories\\";
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
    
    public String addcategories(){
        client.insertPartCategory(uploadedfile, newcategory.getCategoryName(), newcategory.getVehicleType(), newcategory.getCategoryDescription(), datetime, datetime);
        newcategory = new TblPartcategory();
        uploadedfile = null;
        res = client.getAllPartCategories(Response.class);
        categories = res.readEntity(gcategories);
        return "viewpartcategories.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updatepartcategory.jsf?faces-redirect=true";
    }
    
    public String updatecategory(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        if(uploadedfile==null){
            uploadedfile = currentcategory.getCategoryImg();
        }
        client.updatePartCategory(uploadedfile, currentcategory.getPartcategoryId().toString(), currentcategory.getCategoryName(), currentcategory.getVehicleType(), currentcategory.getCategoryDescription(), updatetime);
        res = client.getAllPartCategories(Response.class);
        categories = res.readEntity(gcategories);
        return "viewpartcategories.jsf?faces-redirect=true";
    }
    
    public void deletecategory(TblPartcategory category){
        categories.remove(category);
        client.deletePartCategory(category.getPartcategoryId().toString());
    }
}
