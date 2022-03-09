/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.adminClient;
import entities.TblModel;
import entities.TblPartcategory;
import entities.TblParts;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "partbean")
@SessionScoped
public class partbean implements Serializable {

    adminClient client = new adminClient();
    Response res;
    Collection<TblParts> parts = new ArrayList<TblParts>();
    Collection<TblPartcategory> categories = new ArrayList<TblPartcategory>();
    Collection<TblModel> models = new ArrayList<TblModel>();
    TblParts newpart = new TblParts();
    TblParts currentpart;
    UploadedFile file;
    UploadedFiles files;
    String uploadedfile;
    List<String> uploadedfiles = new ArrayList<String>();;
    GenericType<Collection<TblParts>> gparts = new GenericType<Collection<TblParts>>(){};
    GenericType<Collection<TblPartcategory>> gcategories = new GenericType<Collection<TblPartcategory>>(){};
    GenericType<Collection<TblModel>> gmodels = new GenericType<Collection<TblModel>>(){};
    Collection<TblParts> filteredparts;
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    Integer partcategoryid, modelid;
    
    public partbean() {
    }
    
    @PostConstruct
    public void init(){
        res = client.getAllParts(Response.class);
        parts = res.readEntity(gparts);
    }

    public TblParts getNewpart() {
        return newpart;
    }

    public void setNewpart(TblParts newpart) {
        this.newpart = newpart;
    }

    public TblParts getCurrentpart() {
        return currentpart;
    }

    public void setCurrentpart(TblParts currentpart) {
        this.currentpart = currentpart;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Collection<TblParts> getFilteredparts() {
        return filteredparts;
    }

    public void setFilteredparts(Collection<TblParts> filteredparts) {
        this.filteredparts = filteredparts;
    }

    public Integer getPartcategoryid() {
        return partcategoryid;
    }

    public void setPartcategoryid(Integer partcategoryid) {
        this.partcategoryid = partcategoryid;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public UploadedFiles getFiles() {
        return files;
    }

    public void setFiles(UploadedFiles files) {
        this.files = files;
    }
    
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblParts part = (TblParts) value;
        return part.getPartName().toLowerCase().contains(filtertext)
                || part.getModelId().getModelName().toLowerCase().contains(filtertext)
                || part.getPartcategoryId().getCategoryName().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblParts> viewparts(){
        return parts;
    }
    
    public Collection<TblPartcategory> getcategories(){
        res = client.getAllPartCategories(Response.class);
        categories = res.readEntity(gcategories);
        return categories;
    }
    
    public Collection<TblModel> getmodels(){
        res = client.getAllModels(Response.class);
        models = res.readEntity(gmodels);
        return models;
    }
    
    public void handlefileupload(FileUploadEvent event){
        String destination="G:\\ServaxoTest\\web\\uploads\\partmanuals";
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
            FacesMessage message = new FacesMessage(event.getFile().getFileName() + "Uploaded");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void handlefilesupload(FilesUploadEvent event){
        String destination="G:\\ServaxoTest\\web\\uploads\\parts";
        //uploadedfiles = event.getFiles().getFiles();
        for(UploadedFile f : event.getFiles().getFiles()){
            
            
            try{
            InputStream input = f.getInputStream();
            OutputStream output = new FileOutputStream(new File(destination+f.getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = input.read(bytes))!= -1){
                output.write(bytes, 0, read);
            }
            input.close();
            output.flush();
            output.close();
            uploadedfiles.add(f.getFileName());
            //uploadedfiles.add(0, f.getFileName());
            System.out.println("File Name: " + uploadedfiles);
            FacesMessage message = new FacesMessage(f.getFileName() + "Uploaded");
            FacesContext.getCurrentInstance().addMessage(null, message);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    public String addpart(){
        Integer partprice = newpart.getPrice();
        String image1;
        String image2;
        String image3;
        if(uploadedfiles.isEmpty()){
            image1 = null;
            image2 = null;
            image3 = null;
        }else if(uploadedfiles.size()==1){
            image1 = uploadedfiles.get(0);
            image2 = null;
            image3 = null;
        }
        else if(uploadedfiles.size()==2){
            image1 = uploadedfiles.get(0);
            image2 = uploadedfiles.get(1);
            image3 = null;
        }else{
            image1 = uploadedfiles.get(0);
            image2 = uploadedfiles.get(1);
            image3 = uploadedfiles.get(2);
        }
        System.out.println("size: " + uploadedfiles.size());
        System.out.println("Image-1: " + image1);
        System.out.println("Image-2: " + image2);
        System.out.println("Image-3: " + image3);
        client.insertPart(modelid.toString(), partcategoryid.toString(), newpart.getPartName(), partprice.toString(), newpart.getPartDescription(), image1, image2, image3, uploadedfile, newpart.getVideoUrl(), newpart.getIsactive(), datetime, datetime);
        newpart = new TblParts();
        partprice = null;
        modelid = null;
        partcategoryid = null;
        uploadedfiles.clear();
        uploadedfile = null;
        res = client.getAllParts(Response.class);
        parts = res.readEntity(gparts);
        return "viewparts.jsf?faces-redirect=true";
    }
    
    public String redirecttoupdate(){
        return "updatepart.jsf?faces-redirect=true";
    }
    
    public String updatepart(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        Integer partprice = currentpart.getPrice();
        String image1 = currentpart.getImg1();
        String image2 = currentpart.getImg2();
        String image3 = currentpart.getImg3();
        if(uploadedfiles.isEmpty()){
            uploadedfiles.add(image1);
            uploadedfiles.add(image2);
            uploadedfiles.add(image3);
        }else if(uploadedfiles.size()==1){
            uploadedfiles.add(image2);
            uploadedfiles.add(image3);
        }else if(uploadedfiles.size()==2){
            uploadedfiles.add(image3);
        }
        if(uploadedfile == null){
            uploadedfile = currentpart.getPartManualPdf();
        }
        client.updatePart(currentpart.getPartId().toString(), currentpart.getModelId().getModelId().toString(), currentpart.getPartcategoryId().getPartcategoryId().toString(), currentpart.getPartName(), partprice.toString(), currentpart.getPartDescription(), uploadedfiles.get(0).toString(), uploadedfiles.get(1).toString(), uploadedfiles.get(2).toString(), uploadedfile, currentpart.getVideoUrl(), currentpart.getIsactive(), updatetime);
        res = client.getAllParts(Response.class);
        parts = res.readEntity(gparts);
        return "viewparts.jsf?faces-redirect=true";
    }
    public String changestatus(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        String updatetime = df.format(currenttimestamp);
        String status;
        if(currentpart.getIsactive().equals("no")){
            status = "yes";
        }else{
            status = "no";
        }
        client.updateActivePart(currentpart.getPartId().toString(), status, updatetime);
        res = client.getAllParts(Response.class);
        parts = res.readEntity(gparts);
        return "viewparts.jsf?faces-redirect=true";
    }
    
    public void deletepart(TblParts part){
        parts.remove(part);
        client.deletePart(part.getPartId().toString());
    }
}
