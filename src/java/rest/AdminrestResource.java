/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminLocal;
import entities.TblCity;
import entities.TblCompany;
import entities.TblFeedback;
import entities.TblModel;
import entities.TblOrder;
import entities.TblOrderdetail;
import entities.TblPartcategory;
import entities.TblParts;
import entities.TblServicelist;
import entities.TblServiceorder;
import entities.TblServices;
import entities.TblState;
import entities.Usermaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author c computer
 */
@Path("adminrest")
public class AdminrestResource {

    @EJB AdminLocal admin;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminrestResource
     */
    public AdminrestResource() {
    }

    @POST
    @Path("addcompany/{name}/{type}/{createdat}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertcompany(@PathParam("name") String name, String logo, @PathParam("type") String type, @PathParam("createdat") String createdAt, @PathParam("updatedat") String updatedAt){
        admin.insertcompany(name, logo, type, createdAt, updatedAt);
    }
    @PUT
    @Path("updatecompany/{id}/{name}/{type}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCompany(@PathParam("id")Integer id, @PathParam("name")String name, String logo, @PathParam("type")String type, @PathParam("updatedat")String updatedAt){
        admin.updateCompany(id, name, logo, type, updatedAt);
    }
    
    @DELETE
    @Path("deletecompany/{id}")
    public void deletecompany(@PathParam("id")Integer id){
        admin.deletecompany(id);
    }
    
    @GET
    @Path("allcompanies")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCompany> getAllCompanies(){
        return admin.getAllCompanies();
    }
    
    @GET
    @Path("companiesbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCompany> getCompaniesById(@PathParam("id")Integer id){
        return admin.getCompaniesById(id);
    }
    
    @GET
    @Path("companiesbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCompany> getCompaniesByName(@PathParam("name")String name){
        return admin.getCompaniesByName(name);
    }
    
    @GET
    @Path("companiesbytype/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCompany> getCompaniesByType(@PathParam("type")String type){
        return admin.getCompaniesByType(type);
    }
    
    @POST
    @Path("addmodel/{name}/{companyid}/{createdat}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertModel(@PathParam("name")String name, @PathParam("companyid")Integer companyId, String image, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertModel(name, companyId, image, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updatemodel/{id}/{name}/{companyid}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateModel(@PathParam("id")Integer id, @PathParam("name")String name, @PathParam("companyid")Integer companyId, String image, @PathParam("updatedat")String updatedAt){
        admin.updateModel(id, name, companyId, image, updatedAt);
    }
    
    @DELETE
    @Path("deletemodel/{id}")
    public void deleteModel(@PathParam("id")Integer id){
        admin.deleteModel(id);
    }
    
    @GET
    @Path("allmodels")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblModel> getAllModels(){
        return admin.getAllModels();
    }
    
    @GET
    @Path("modelsbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblModel> getModelsById(@PathParam("id")Integer id){
        return admin.getModelsById(id);
    }
    
    @GET
    @Path("modelsbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblModel> getModelsByName(@PathParam("name")String name){
         return admin.getModelsByName(name);
    }
    
    @GET
    @Path("modelsbycompany/{companyid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblModel> getModelsByCompany(@PathParam("companyid")Integer companyId){
        return admin.getModelsByCompany(companyId);
    }
    
    @POST
    @Path("addpartcategory/{name}/{type}/{description}/{createdat}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertPartCategory(@PathParam("name")String name, @PathParam("type")String type, String image, @PathParam("description")String des, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertPartCategory(name, type, image, des, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updatepartcategory/{id}/{name}/{type}/{description}/{updatedat}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePartCategory(@PathParam("id")Integer id, @PathParam("name")String name, @PathParam("type")String type, String image, @PathParam("description")String des, @PathParam("updatedat")String updatedAt){
        admin.updatePartCategory(id, name, type, image, des, updatedAt);
    }
    
    @DELETE
    @Path("deletepartcategory/{id}")
    public void deletePartCategory(@PathParam("id")Integer id){
        admin.deletePartCategory(id);
    }
    
    @GET
    @Path("allpartcategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblPartcategory> getAllPartCategories(){
        return admin.getAllPartCategories();
    }
    
    @GET
    @Path("partcategoriesbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblPartcategory> getPartCategoriesById(@PathParam("id")Integer id){
        return admin.getPartCategoriesById(id);
    }
    
    @GET
    @Path("partcategoriesbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblPartcategory> getPartCategoriesByName(@PathParam("name")String name){
        return admin.getPartCategoriesByName(name);
    }
    
    @GET
    @Path("partcategoriesbytype/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblPartcategory> getPartCategoriesByType(@PathParam("type")String type){
        return admin.getPartCategoriesByType(type);
    }
    
    @POST
    @Path("addparts/{modelid}/{partcatid}/{name}/{price}/{description}/{image1}/{image2}/{image3}/{pdf}/{url}/{isactive}/{createdat}/{updatedat}")
    public void insertPart(@PathParam("modelid")Integer modelId, @PathParam("partcatid")Integer partCatId, @PathParam("name")String name, @PathParam("price")Integer price, @PathParam("description")String des, @PathParam("image1")String image1, @PathParam("image2")String image2, @PathParam("image3")String image3, @PathParam("pdf")String pdf, @PathParam("url")String url, @PathParam("isactive")String isactive, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertPart(modelId, partCatId, name, price, des, image1, image2, image3, pdf, url, isactive, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updateparts/{id}/{modelid}/{partcatid}/{name}/{price}/{description}/{image1}/{image2}/{image3}/{pdf}/{url}/{isactive}/{updatedat}")
    public void updatePart(@PathParam("id")Integer partId, @PathParam("modelid")Integer modelId, @PathParam("partcatid")Integer partCatId, @PathParam("name")String name, @PathParam("price")Integer price, @PathParam("description")String des, @PathParam("image1")String image1, @PathParam("image2")String image2, @PathParam("image3")String image3, @PathParam("pdf")String pdf, @PathParam("url")String url, @PathParam("isactive")String isactive, @PathParam("updatedat")String updatedAt){
        admin.updatePart(partId, modelId, partCatId, name, price, des, image1, image2, image3, pdf, url, isactive, updatedAt);
    }
    
    @PUT
    @Path("updateactivepart/{id}/{isactive}/{updatedat}")
    public void updateActivePart(@PathParam("id")Integer id, @PathParam("isactive")String isactive, @PathParam("updatedat")String updatedAt){
        admin.updateActivePart(id, isactive, updatedAt);
    }
    
    @DELETE
    @Path("deleteparts/{id}")
    public void deletePart(@PathParam("id")Integer id){
        admin.deletePart(id);
    }
    
    @GET
    @Path("allparts")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblParts> getAllParts(){
        return admin.getAllParts();
    }
    
    @GET
    @Path("partsbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblParts> getPartsById(@PathParam("id")Integer id){
        return admin.getPartsById(id);
    }
    
    @GET
    @Path("partsbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblParts> getPartsByName(@PathParam("name")String name){
        return admin.getPartsByName(name);
    }
    
    @GET
    @Path("partsbymodel/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblParts> getPartsByModel(@PathParam("model")String model){
        return admin.getPartsByModel(model);
    }
    
    @GET
    @Path("partsbycategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblParts> getPartsByCategory(@PathParam("category")String category){
        return admin.getPartsByCategory(category);
    }
    
    @POST
    @Path("addservice/{name}/{description}/{price}/{isactive}/{type}/{createdat}/{updatedat}")
    public void insertService(@PathParam("name")String name, @PathParam("description")String des, @PathParam("price")Integer price, @PathParam("isactive")String isactive, @PathParam("type")String type, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertService(name, des, price, isactive, type, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updateservice/{id}/{name}/{description}/{price}/{isactive}/{type}/{updatedat}")
    public void updateService(@PathParam("id")Integer id, @PathParam("name")String name, @PathParam("description")String des, @PathParam("price")Integer price, @PathParam("isactive")String isactive, @PathParam("type")String type, @PathParam("updatedat")String updatedAt){
        admin.updateService(id, name, des, price, isactive, type, updatedAt);
    }
    
    @PUT
    @Path("updateactiveservice/{id}/{isactive}/{updatedat}")
    public void updateActiveService(@PathParam("id")Integer id, @PathParam("isactive")String isactive, @PathParam("updatedat")String updatedAt){
        admin.updateActiveService(id, isactive, updatedAt);
    }
    
    @DELETE
    @Path("deleteservice/{id}")
    public void deleteService(@PathParam("id")Integer id){
        admin.deleteService(id);
    }
    
    @GET
    @Path("allservices")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServices> getAllServices(){
        return admin.getAllServices();
    }
    
    @GET
    @Path("servicesbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServices> getAllServicesById(@PathParam("id")Integer id){
        return admin.getAllServicesById(id);
    }
    
    @GET
    @Path("servicesbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServices> getAllServicesByName(@PathParam("name")String name){
        return admin.getAllServicesByName(name);
    }
    
    @GET
    @Path("servicesbytype/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServices> getAllServicesByType(@PathParam("type")String type){
        return admin.getAllServicesByType(type);
    }
    
    @GET
    @Path("allfeedbacks")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> getAllFeedbacks(){
        return admin.getAllFeedbacks();
    }
    
    @GET
    @Path("feedbackbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> getFeedbacksById(@PathParam("id")Integer id){
        return admin.getFeedbacksById(id);
    }
    
    @GET
    @Path("feedbackbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> getFeedbacksByName(@PathParam("name")String name){
        return admin.getFeedbacksByName(name);
    }
    
    @GET
    @Path("feedbackbycontactno/{contactno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> getFeedbacksByContactNo(@PathParam("contactno")String contact){
        return admin.getFeedbacksByContactNo(contact);
    }
    
    @GET
    @Path("feedbackbyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> getFeedbacksByEmail(@PathParam("email")String email){
        return admin.getFeedbacksByEmail(email);
    }
    
    @POST
    @Path("addstate/{name}/{code}/{createdat}/{updatedat}")
    public void insertState(@PathParam("name")String name, @PathParam("code")String code, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertState(name, code, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updatestate/{id}/{name}/{code}/{updatedat}")
    public void updateState(@PathParam("id")Integer id, @PathParam("name")String name, @PathParam("code")String code, @PathParam("updatedat")String updatedAt){
        admin.updateState(id, name, code, updatedAt);
    }
    
    @DELETE
    @Path("deletestate/{id}")
    public void deleteState(@PathParam("id")Integer id){
        admin.deleteState(id);
    }
    
    @GET
    @Path("allstates")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> getAllStates(){
        return admin.getAllStates();
    }
    
    @GET
    @Path("statesbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> getStatesById(@PathParam("id")Integer id){
        return admin.getStatesById(id);
    }
    
    @GET
    @Path("statesbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> getStatesByName(@PathParam("name")String name){
        return admin.getStatesByName(name);
    }
    
    @GET
    @Path("statesbycode/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> getStatesByCode(@PathParam("code")String code){
        return admin.getStatesByCode(code);
    }
    
    @POST
    @Path("addcity/{name}/{stateid}/{code}/{createdat}/{updatedat}")
    public void insertCity(@PathParam("name")String name, @PathParam("stateid")Integer stateId, @PathParam("code")String code, @PathParam("createdat")String createdAt, @PathParam("updatedat")String updatedAt){
        admin.insertCity(name, stateId, code, createdAt, updatedAt);
    }
    
    @PUT
    @Path("updatecity/{id}/{name}/{stateid}/{code}/{updatedat}")
    public void updateCity(@PathParam("id")Integer id, @PathParam("name")String name, @PathParam("stateid")Integer stateId, @PathParam("code")String code, @PathParam("updatedat")String updatedAt){
        admin.updateCity(id, name, stateId, code, updatedAt);
    }
    
    @DELETE
    @Path("deletecity/{id}")
    public void deleteCity(@PathParam("id")Integer id){
        admin.deleteCity(id);
    }
    
    @GET
    @Path("allcities")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCity> getAllCities(){
        return admin.getAllCities();
    }
    
    @GET
    @Path("citiesbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCity> getCitiesById(@PathParam("id")Integer id){
        return admin.getCitiesById(id);
    }
    
    @GET
    @Path("citiesbystate/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCity> getCitiesByState(@PathParam("state")String state){
        return admin.getCitiesByState(state);
    }
    
    @GET
    @Path("citiesbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCity> getCitiesByName(@PathParam("name")String name){
        return admin.getCitiesByName(name);
    }
    
    @GET
    @Path("citiesbycode/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCity> getCitiesByCode(@PathParam("code")String code){
        return admin.getCitiesByCode(code);
    }
    
    @PUT
    @Path("updateserviceorder/{id}/{status}/{updatedat}")
    public void updateStatus(@PathParam("id")Integer ServiceOrderId, @PathParam("status")String status, @PathParam("updatedat")String updatedAt){
        admin.updateStatus(ServiceOrderId, status, updatedAt);
    }
    
    @GET
    @Path("allserviceorders")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServiceorder> getAllServiceOrders(){
        return admin.getAllServiceOrders();
    }
    
    @GET
    @Path("serviceordersbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServiceorder> getServiceOrderById(@PathParam("id")Integer ServiceOrderId){
        return admin.getServiceOrderById(ServiceOrderId);
    }
    
    @GET
    @Path("serviceorderdetails/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblServicelist> getServiceOrderDetailsByServiceOrderId(@PathParam("id")Integer serviceOrderId){
        return admin.getServiceOrderDetailsByServiceOrderId(serviceOrderId);
    }
    
    @PUT
    @Path("updateorder/{id}/{status}/{updatedat}")
    public void updateorderStatus(@PathParam("id")Integer OrderId, @PathParam("status")String status, @PathParam("updatedat")String updatedAt){
        admin.updateorderStatus(OrderId, status, updatedAt);
    }
    
    @GET
    @Path("allorders")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrder> getAllOrders(){
        return admin.getAllOrders();
    }
    
    @GET
    @Path("ordersbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrder> getOrdersById(@PathParam("id")Integer orderId){
        return admin.getOrdersById(orderId);
    }
    
    @GET
    @Path("orderdetails/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrderdetail> getOrderDetailByOrderId(@PathParam("id")Integer orderId){
        return admin.getOrderDetailByOrderId(orderId);
    }
    
    @GET
    @Path("allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usermaster> getAllUsers(){
        return admin.getAllUsers();
    }
}
