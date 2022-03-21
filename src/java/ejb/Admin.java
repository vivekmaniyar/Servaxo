package ejb;

import entities.TblCity;
import entities.TblCompany;
import entities.TblFeedback;
import entities.TblModel;
import entities.TblOrder;
import entities.TblOrderdetail;
import entities.TblOrderdetailPK;
import entities.TblPartcategory;
import entities.TblParts;
import entities.TblServicelist;
import entities.TblServicelistPK;
import entities.TblServiceorder;
import entities.TblServices;
import entities.TblState;
import entities.Usermaster;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Admin implements AdminLocal {
    @PersistenceContext(name="ServaxoTestPU")
    EntityManager em;

    Collection<TblCompany> TblCompany;
    Collection<TblModel> TblModel;
    Collection<TblPartcategory> TblPartcategory;
    Collection<TblParts> TblParts;
    Collection<TblServices> TblServices;
    Collection<TblFeedback> TblFeedbacks;
    Collection<TblState> TblState;
    Collection<TblCity> TblCity;
    Collection<TblServiceorder> TblServiceorder;
    Collection<TblServicelist> TblServicelist;
    Collection<TblOrder> TblOrder;
    Collection<TblOrderdetail> TblOrderdetail;
    Collection<Usermaster> users;
            
    @Override
    public void insertcompany(String name, String logo, String type, String createdAt, String updatedAt) {
        TblCompany tc = new TblCompany();
        tc.setCompanyName(name);
        tc.setCompanyLogo(logo);
        tc.setCompanyType(type);
        tc.setCreatedAt(createdAt);
        tc.setUpdatedAt(updatedAt);
        em.persist(tc);
        
    }

    @Override
    public void insertModel(String name, Integer companyId, String image, String createdAt, String updatedAt) {
        TblModel tm = new TblModel();
        TblCompany tc = em.find(TblCompany.class, companyId);
        tm.setModelName(name);
        tm.setCompanyId(tc);
        tm.setModelImg(image);
        tm.setCreatedAt(createdAt);
        tm.setUpdatedAt(updatedAt);
        em.persist(tm);
        
    }

    @Override
    public void deletecompany(Integer id) {
        TblCompany tc = em.find(TblCompany.class, id);
        em.remove(tc);
    }

    @Override
    public Collection<TblCompany> getAllCompanies() {
        TblCompany = em.createNamedQuery("TblCompany.findAll").getResultList();
        return TblCompany;
    }
    
    @Override
    public Collection<TblCompany> getCompaniesById(Integer id) {
        TblCompany = em.createNamedQuery("TblCompany.findByCompanyId").setParameter("companyId", id).getResultList();
        return TblCompany;
    }

    @Override
    public Collection<TblCompany> getCompaniesByName(String name) {
        TblCompany = em.createNamedQuery("TblCompany.findByCompanyName").setParameter("companyName", name).getResultList();
        return TblCompany;
    }

    @Override
    public Collection<TblCompany> getCompaniesByType(String type) {
        TblCompany = em.createNamedQuery("TblCompany.findByCompanyType").setParameter("companyType", type).getResultList();
        return TblCompany;
    }

    @Override
    public void updateCompany(Integer id, String name, String logo, String type, String updatedAt) {
        TblCompany tc = em.find(TblCompany.class, id);
        tc.setCompanyName(name);
        tc.setCompanyLogo(logo);
        tc.setCompanyType(type);
        tc.setUpdatedAt(updatedAt);
        em.merge(tc); 
    }

    @Override
    public void updateModel(Integer id, String name, Integer companyId, String image, String updatedAt) {
        TblModel tm = em.find(TblModel.class, id);
        TblCompany tc = em.find(TblCompany.class, companyId);
        tm.setModelName(name);
        tm.setCompanyId(tc);
        tm.setModelImg(image);
        tm.setUpdatedAt(updatedAt);
        em.merge(tm);
    }

    @Override
    public void deleteModel(Integer id) {
        TblModel tm = em.find(TblModel.class, id);
        em.remove(tm);
    }

    @Override
    public Collection<TblModel> getAllModels() {
        TblModel = em.createNamedQuery("TblModel.findAll").getResultList();
        return TblModel;
    }

    @Override
    public Collection<TblModel> getModelsById(Integer id) {
        TblModel = em.createNamedQuery("TblModel.findByModelId").setParameter("modelId", id).getResultList();
        return TblModel;
    }

    @Override
    public Collection<TblModel> getModelsByName(String name) {
        TblModel = em.createNamedQuery("TblModel.findByModelName").setParameter("modelName", name).getResultList();
        return TblModel;
    }

    @Override
    public Collection<TblModel> getModelsByCompany(Integer companyId) {
        TblCompany tc = em.find(TblCompany.class, companyId);
        TblModel = em.createNamedQuery("TblModel.findByCompanyId").setParameter("companyId", tc).getResultList();
        return TblModel;
    }

    @Override
    public Collection<TblPartcategory> getAllPartCategories() {
        TblPartcategory = em.createNamedQuery("TblPartcategory.findAll").getResultList();
        return TblPartcategory;
    }

    @Override
    public Collection<TblPartcategory> getPartCategoriesById(Integer id) {
        TblPartcategory = em.createNamedQuery("TblPartcategory.findByPartcategoryId").setParameter("partcategoryId", id).getResultList();
        return TblPartcategory;
    }

    @Override
    public Collection<TblPartcategory> getPartCategoriesByName(String name) {
        TblPartcategory = em.createNamedQuery("TblPartcategory.findByCategoryName").setParameter("categoryName", name).getResultList();
        return TblPartcategory;
    }

    @Override
    public Collection<TblPartcategory> getPartCategoriesByType(String type) {
        TblPartcategory = em.createNamedQuery("TblPartcategory.findByVehicleType").setParameter("vehicleType", type).getResultList();
        return TblPartcategory;
    }

    @Override
    public void insertPartCategory(String name, String type, String image, String des, String createdAt, String updatedAt) {
        TblPartcategory tpc = new TblPartcategory();
        tpc.setCategoryName(name);
        tpc.setVehicleType(type);
        tpc.setCategoryImg(image);
        tpc.setCategoryDescription(des);
        tpc.setCreatedAt(createdAt);
        tpc.setUpdatedAt(updatedAt);
        em.persist(tpc);
    }

    @Override
    public void updatePartCategory(Integer id, String name, String type, String image, String des, String updatedAt) {
        TblPartcategory tpc = em.find(TblPartcategory.class, id);
        tpc.setCategoryName(name);
        tpc.setVehicleType(type);
        tpc.setCategoryImg(image);
        tpc.setCategoryDescription(des);
        tpc.setUpdatedAt(updatedAt);
        em.merge(tpc);
    }

    @Override
    public void deletePartCategory(Integer id) {
        TblPartcategory tpc = em.find(TblPartcategory.class, id);
        em.remove(tpc);
    }

    @Override
    public Collection<TblParts> getAllParts() {
        TblParts = em.createNamedQuery("TblParts.findAll").getResultList();
        return TblParts;
    }

    @Override
    public Collection<TblParts> getPartsById(Integer id) {
        TblParts = em.createNamedQuery("TblParts.findByPartId").setParameter("partId", id).getResultList();
        return TblParts;
    }

    @Override
    public Collection<TblParts> getPartsByName(String name) {
        TblParts = em.createNamedQuery("TblParts.findByPartName").setParameter("partName", name).getResultList();
        return TblParts;
    }

    @Override
    public Collection<TblParts> getPartsByModel(String model) {
        TblModel tm = (TblModel) em.createNamedQuery("TblModel.findByModelName").setParameter("modelName", model).getSingleResult();
        TblParts = em.createNamedQuery("TblParts.findByModel").setParameter("modelId", tm).getResultList();
        return TblParts;
    }

    @Override
    public Collection<TblParts> getPartsByCategory(String category) {
        TblPartcategory tpc = (TblPartcategory) em.createNamedQuery("TblPartcategory.findByCategoryName").setParameter("categoryName", category).getSingleResult();
        TblParts = em.createNamedQuery("TblParts.findByCategory").setParameter("partcategoryId", tpc).getResultList();
        return TblParts;
    }

    @Override
    public void insertPart(Integer modelId, Integer partCatId, String name, Integer price, String des, String image1, String image2, String image3, String pdf, String url, String isactive, String createdAt, String updatedAt) {
        TblParts tp = new TblParts();
        TblModel tm = em.find(TblModel.class, modelId);
        tp.setModelId(tm);
        TblPartcategory tpc = em.find(TblPartcategory.class, partCatId);
        tp.setPartcategoryId(tpc);
        tp.setPartName(name);
        tp.setPrice(price);
        tp.setPartDescription(des);
        tp.setImg1(image1);
        tp.setImg2(image2);
        tp.setImg3(image3);
        tp.setPartManualPdf(pdf);
        tp.setVideoUrl(url);
        tp.setIsactive(isactive);
        tp.setAddeddatetime(createdAt);
        tp.setUpdatedAt(updatedAt);
        em.persist(tp);
    }

    @Override
    public void updatePart(Integer partId, Integer modelId, Integer partCatId, String name, Integer price, String des, String image1, String image2, String image3, String pdf, String url, String isactive, String updatedAt) {
        TblParts tp = em.find(TblParts.class, partId);
        TblModel tm = em.find(TblModel.class, modelId);
        tp.setModelId(tm);
        TblPartcategory tpc = em.find(TblPartcategory.class, partCatId);
        tp.setPartcategoryId(tpc);
        tp.setPartName(name);
        tp.setPrice(price);
        tp.setPartDescription(des);
        tp.setImg1(image1);
        tp.setImg2(image2);
        tp.setImg3(image3);
        tp.setPartManualPdf(pdf);
        tp.setVideoUrl(url);
        tp.setIsactive(isactive);
        tp.setUpdatedAt(updatedAt);
        em.merge(tp);
    }

    @Override
    public void updateActivePart(Integer id, String isactive, String updatedAt) {
        TblParts tp = em.find(TblParts.class, id);
        tp.setIsactive(isactive);
        tp.setUpdatedAt(updatedAt);
        em.merge(tp);
    }

    @Override
    public void deletePart(Integer id) {
        TblParts tp = em.find(TblParts.class, id);
        em.remove(tp);
    }

    @Override
    public Collection<TblServices> getAllServices() {
        TblServices = em.createNamedQuery("TblServices.findAll").getResultList();
        return TblServices;
    }

    @Override
    public Collection<TblServices> getAllServicesById(Integer id) {
        TblServices = em.createNamedQuery("TblServices.findByServiceId").setParameter("serviceId", id).getResultList();
        return TblServices;
    }

    @Override
    public Collection<TblServices> getAllServicesByName(String name) {
        TblServices = em.createNamedQuery("TblServices.findByServiceName").setParameter("serviceName", name).getResultList();
        return TblServices;
    }

    @Override
    public Collection<TblServices> getAllServicesByType(String type) {
        TblServices = em.createNamedQuery("TblServices.findByType").setParameter("type", type).getResultList();
        return TblServices;
    }

    @Override
    public void insertService(String name, String des, Integer price, String isactive, String type, String createdAt, String updatedAt) {
        TblServices ts = new TblServices();
        ts.setServiceName(name);
        ts.setServiceDescription(des);
        ts.setServicePrice(price);
        ts.setIsactive(isactive);
        ts.setType(type);
        ts.setCreatedAt(createdAt);
        ts.setUpdatedAt(updatedAt);
        em.persist(ts);
    }

    @Override
    public void updateService(Integer id, String name, String des, Integer price, String isactive, String type, String updatedAt) {
        TblServices ts = em.find(TblServices.class, id);
        ts.setServiceName(name);
        ts.setServiceDescription(des);
        ts.setServicePrice(price);
        ts.setIsactive(isactive);
        ts.setType(type);
        ts.setUpdatedAt(updatedAt);
        em.merge(ts);
    }

    @Override
    public void updateActiveService(Integer id, String isactive, String updatedAt) {
        TblServices ts = em.find(TblServices.class, id);
        ts.setIsactive(isactive);
        ts.setUpdatedAt(updatedAt);
        em.merge(ts);
    }

    @Override
    public void deleteService(Integer id) {
        TblServices ts = em.find(TblServices.class, id);
        em.remove(ts);
    }

    @Override
    public Collection<TblFeedback> getAllFeedbacks() {
        TblFeedbacks = em.createNamedQuery("TblFeedback.findAll").getResultList();
        return TblFeedbacks;
    }

    @Override
    public Collection<TblFeedback> getFeedbacksById(Integer id) {
        TblFeedbacks = em.createNamedQuery("TblFeedback.findByFeedbackId").setParameter("feedbackId", id).getResultList();
        return TblFeedbacks;
    }

    @Override
    public Collection<TblFeedback> getFeedbacksByName(String name) {
        TblFeedbacks = em.createNamedQuery("TblFeedback.findByName").setParameter("name", name).getResultList();
        return TblFeedbacks;
    }

    @Override
    public Collection<TblFeedback> getFeedbacksByContactNo(String contact) {
        TblFeedbacks = em.createNamedQuery("TblFeedback.findBycontactNo").setParameter("contactNo", contact).getResultList();
        return TblFeedbacks;
    }

    @Override
    public Collection<TblFeedback> getFeedbacksByEmail(String email) {
        TblFeedbacks = em.createNamedQuery("TblFeedback.findByemail").setParameter("email", email).getResultList();
        return TblFeedbacks;
    }

    @Override
    public void insertState(String name, String code, String createdAt, String updatedAt) {
        TblState s = new TblState();
        s.setStateName(name);
        s.setStateCode(code);
        s.setCreatedAt(createdAt);
        s.setUpdatedAt(updatedAt);
        em.persist(s);
    }

    @Override
    public void updateState(Integer id, String name, String code, String updatedAt) {
        TblState s = em.find(TblState.class, id);
        s.setStateName(name);
        s.setStateCode(code);
        s.setUpdatedAt(updatedAt);
        em.merge(s);
    }

    @Override
    public void deleteState(Integer id) {
        TblState s = em.find(TblState.class, id);
        em.remove(s);
    }

    @Override
    public Collection<TblState> getAllStates() {
        TblState = em.createNamedQuery("TblState.findAll").getResultList();
        return TblState;
    }

    @Override
    public Collection<TblState> getStatesById(Integer id) {
        TblState = em.createNamedQuery("TblState.findByStateId").setParameter("stateId", id).getResultList();
        return TblState;
    }

    @Override
    public Collection<TblState> getStatesByName(String name) {
        TblState = em.createNamedQuery("TblState.findByStateName").setParameter("stateName", name).getResultList();
        return TblState;
    }

    @Override
    public Collection<TblState> getStatesByCode(String code) {
        TblState = em.createNamedQuery("TblState.findByStateCode").setParameter("stateCode", code).getResultList();
        return TblState;
    }

    @Override
    public void insertCity(String name, Integer stateId, String code, String createdAt, String updatedAt) {
        TblCity city = new TblCity();
        city.setCityName(name);
        TblState state = em.find(TblState.class, stateId);
        city.setStateId(state);
        city.setCityCode(code);
        city.setCreatedAt(createdAt);
        city.setUpdatedAt(updatedAt);
        em.persist(city);
    }

    @Override
    public void updateCity(Integer id, String name, Integer stateId, String code, String updatedAt) {
        TblCity city = em.find(TblCity.class, id);
        city.setCityName(name);
        TblState state = em.find(TblState.class, stateId);
        city.setStateId(state);
        city.setCityCode(code);
        city.setUpdatedAt(updatedAt);
        em.merge(city);
    }

    @Override
    public void deleteCity(Integer id) {
        TblCity city = em.find(TblCity.class, id);
        em.remove(city);
    }

    @Override
    public Collection<TblCity> getAllCities() {
        TblCity = em.createNamedQuery("TblCity.findAll").getResultList();
        return TblCity;
    }

    @Override
    public Collection<TblCity> getCitiesById(Integer id) {
        TblCity = em.createNamedQuery("TblCity.findByCityId").setParameter("cityId", id).getResultList();
        return TblCity;
    }

    @Override
    public Collection<TblCity> getCitiesByState(String state) {
        TblState s = (TblState) em.createNamedQuery("TblState.findByStateName").setParameter("stateName", state).getSingleResult();
        TblCity = em.createNamedQuery("TblCity.findByState").setParameter("stateId", s).getResultList();
        return TblCity;
    }

    @Override
    public Collection<TblCity> getCitiesByName(String name) {
        TblCity = em.createNamedQuery("TblCity.findByCityName").setParameter("cityName", name).getResultList();
        return TblCity;
    }

    @Override
    public Collection<TblCity> getCitiesByCode(String code) {
        TblCity = em.createNamedQuery("TblCity.findByCityCode").setParameter("cityCode", code).getResultList();
        return TblCity;
    }

    @Override
    public Collection<TblServiceorder> getAllServiceOrders() {
        TblServiceorder = em.createNamedQuery("TblServiceorder.findAll").getResultList();
        return TblServiceorder;
    }

    @Override
    public Collection<TblServiceorder> getServiceOrderById(Integer ServiceOrderId) {
        TblServiceorder = em.createNamedQuery("TblServiceorder.findByServiceorderId").setParameter("serviceorderId", ServiceOrderId).getResultList();
        return TblServiceorder;
    }

    @Override
    public Collection<TblServicelist> getServiceOrderDetailsByServiceOrderId(Integer serviceOrderId) {
        //TblServiceorder ts = em.find(TblServiceorder.class, serviceOrderId);
        TblServicelist = em.createNamedQuery("TblServicelist.findByUserVehicleId").setParameter("userVehicleId", serviceOrderId).getResultList();
        return TblServicelist;
    }

    @Override
    public Collection<TblOrder> getAllOrders() {
        TblOrder = em.createNamedQuery("TblOrder.findAll").getResultList();
        return TblOrder;
    }

    @Override
    public Collection<TblOrder> getOrdersById(Integer orderId) {
        TblOrder = em.createNamedQuery("TblOrder.findByOrderId").setParameter("orderId", orderId).getResultList();
        return TblOrder;
    }

    @Override
    public Collection<TblOrderdetail> getOrderDetailByOrderId(Integer orderId) {
        TblOrderdetail = em.createNamedQuery("TblOrderdetail.findByOrderId").setParameter("orderId", orderId).getResultList();
        return TblOrderdetail;
    }

    @Override
    public void updateStatus(Integer ServiceOrderId, String status, String updatedAt) {
        TblServiceorder ts = em.find(TblServiceorder.class, ServiceOrderId);
        ts.setStatus(status);
        ts.setUpdatedAt(updatedAt);
        em.merge(ts);
    }

    @Override
    public void updateorderStatus(Integer OrderId, String status, String updatedAt) {
        TblOrder to = em.find(TblOrder.class, OrderId);
        to.setStatus(status);
        to.setUpdatesAt(updatedAt);
        em.merge(to);
    }

    @Override
    public Collection<Usermaster> getAllUsers() {
        users = em.createNamedQuery("Usermaster.findAll").getResultList();
        return users;
    }

    @Override
    public Collection<Usermaster> getUsersByName(String userName) {
        List u = em.createNamedQuery("Usermaster.findByUsername").setParameter("username", userName).getResultList();
        return users;
    }
    
}
