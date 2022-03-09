/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AdminrestResource
 * [adminrest]<br>
 * USAGE:
 * <pre>
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vicky
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ServaxoTest/webresources";
    Entity<?> empty = Entity.text("");

    public adminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("adminrest");
    }

    public <T> T getPartsById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partsbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCity(String id, String name, String stateid, String code, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecity/{0}/{1}/{2}/{3}/{4}", new Object[]{id, name, stateid, code, updatedat})).request().put(empty);
    }

    public <T> T getAllServices(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allservices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteService(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteservice/{0}", new Object[]{id})).request().delete();
    }

    public void updatePart(String id, String modelid, String partcatid, String name, String price, String description, String image1, String image2, String image3, String pdf, String url, String isactive, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateparts/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{id, modelid, partcatid, name, price, description, image1, image2, image3, pdf, url, isactive, updatedat})).request().put(empty);
    }

    public void updateCompany(Object requestEntity, String id, String name, String type, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecompany/{0}/{1}/{2}/{3}", new Object[]{id, name, type, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateActivePart(String id, String isactive, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateactivepart/{0}/{1}/{2}", new Object[]{id, isactive, updatedat})).request().put(empty);
    }

    public <T> T getAllServiceOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allserviceorders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getModelsByCompany(Class<T> responseType, String companyid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("modelsbycompany/{0}", new Object[]{companyid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allorders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCity(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecity/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getOrdersById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("ordersbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deletePart(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteparts/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllParts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allparts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteModel(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletemodel/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getPartsByCategory(Class<T> responseType, String category) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partsbycategory/{0}", new Object[]{category}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllModels(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allmodels");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStatesByCode(Class<T> responseType, String code) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statesbycode/{0}", new Object[]{code}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFeedbacksByContactNo(Class<T> responseType, String contactno) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbackbycontactno/{0}", new Object[]{contactno}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertPartCategory(Object requestEntity, String name, String type, String description, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addpartcategory/{0}/{1}/{2}/{3}/{4}", new Object[]{name, type, description, createdat, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateorderStatus(String id, String status, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateorder/{0}/{1}/{2}", new Object[]{id, status, updatedat})).request().put(empty);
    }

    public void insertModel(Object requestEntity, String name, String companyid, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addmodel/{0}/{1}/{2}/{3}", new Object[]{name, companyid, createdat, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllFeedbacks(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allfeedbacks");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateModel(Object requestEntity, String id, String name, String companyid, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatemodel/{0}/{1}/{2}/{3}", new Object[]{id, name, companyid, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateService(String id, String name, String description, String price, String isactive, String type, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateservice/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{id, name, description, price, isactive, type, updatedat})).request().put(empty);
    }

    public <T> T getServiceOrderDetailsByServiceOrderId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("serviceorderdetails/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPartCategoriesByType(Class<T> responseType, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partcategoriesbytype/{0}", new Object[]{type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCompanies(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcompanies");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPartCategoriesById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partcategoriesbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deletecompany(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecompany/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getModelsByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("modelsbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertCity(String name, String stateid, String code, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcity/{0}/{1}/{2}/{3}/{4}", new Object[]{name, stateid, code, createdat, updatedat})).request().post(null);
    }

    public <T> T getAllPartCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allpartcategories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCitiesById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("citiesbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getOrderDetailByOrderId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderdetails/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFeedbacksByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbackbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFeedbacksByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbackbyemail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompaniesByType(Class<T> responseType, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("companiesbytype/{0}", new Object[]{type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateActiveService(String id, String isactive, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateactiveservice/{0}/{1}/{2}", new Object[]{id, isactive, updatedat})).request().put(empty);
    }

    public void insertcompany(Object requestEntity, String name, String type, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcompany/{0}/{1}/{2}/{3}", new Object[]{name, type, createdat, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deletePartCategory(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletepartcategory/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getCitiesByState(Class<T> responseType, String state) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("citiesbystate/{0}", new Object[]{state}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertPart(String modelid, String partcatid, String name, String price, String description, String image1, String image2, String image3, String pdf, String url, String isactive, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addparts/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{modelid, partcatid, name, price, description, image1, image2, image3, pdf, url, isactive, createdat, updatedat})).request().post(null);
    }

    public <T> T getPartsByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partsbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllServicesByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("servicesbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStatesById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statesbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCities(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcities");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCitiesByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("citiesbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteState(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletestate/{0}", new Object[]{id})).request().delete();
    }

    public void updateState(String id, String name, String code, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatestate/{0}/{1}/{2}/{3}", new Object[]{id, name, code, updatedat})).request().put(empty);
    }

    public <T> T getAllStates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allstates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompaniesByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("companiesbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFeedbacksById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbackbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompaniesById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("companiesbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertState(String name, String code, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addstate/{0}/{1}/{2}/{3}", new Object[]{name, code, createdat, updatedat})).request().post(null);
    }

    public <T> T getAllServicesByType(Class<T> responseType, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("servicesbytype/{0}", new Object[]{type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getModelsById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("modelsbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePartCategory(Object requestEntity, String id, String name, String type, String description, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatepartcategory/{0}/{1}/{2}/{3}/{4}", new Object[]{id, name, type, description, updatedat})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getStatesByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statesbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getServiceOrderById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("serviceordersbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPartCategoriesByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partcategoriesbyname/{0}", new Object[]{name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateStatus(String id, String status, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateserviceorder/{0}/{1}/{2}", new Object[]{id, status, updatedat})).request().put(empty);
    }

    public void insertService(String name, String description, String price, String isactive, String type, String createdat, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addservice/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{name, description, price, isactive, type, createdat, updatedat})).request().post(null);
    }

    public <T> T getAllServicesById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("servicesbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCitiesByCode(Class<T> responseType, String code) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("citiesbycode/{0}", new Object[]{code}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPartsByModel(Class<T> responseType, String model) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("partsbymodel/{0}", new Object[]{model}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allusers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public void close() {
        client.close();
    }
    
}
