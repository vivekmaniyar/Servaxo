package ejb;

import entities.TblCity;
import entities.TblCompany;
import entities.TblFeedback;
import entities.TblModel;
import entities.TblOrder;
import entities.TblOrderdetail;
import entities.TblPartcategory;
import entities.TblParts;
import entities.TblServicelist;
import entities.TblServicelistPK;
import entities.TblServiceorder;
import entities.TblServices;
import entities.TblState;
import entities.Usermaster;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface AdminLocal {
    
    //companies
    void insertcompany(String name,String logo, String type, String createdAt, String updatedAt);
    void deletecompany(Integer id);
    void updateCompany(Integer id, String name, String logo, String type, String updatedAt);
    Collection<TblCompany> getAllCompanies();
    Collection<TblCompany> getCompaniesById(Integer id);
    Collection<TblCompany> getCompaniesByName(String name);
    Collection<TblCompany> getCompaniesByType(String type);
    
    //models
    void insertModel(String name, Integer companyId, String image, String createdAt, String updatedAt);
    void updateModel(Integer id, String name, Integer companyId, String image, String updatedAt);
    void deleteModel(Integer id);
    Collection<TblModel> getAllModels();
    Collection<TblModel> getModelsById(Integer id);
    Collection<TblModel> getModelsByName(String name);
    Collection<TblModel> getModelsByCompany(Integer companyId);
    
    //Part categories
    Collection<TblPartcategory> getAllPartCategories();
    Collection<TblPartcategory> getPartCategoriesById(Integer id);
    Collection<TblPartcategory> getPartCategoriesByName(String name);
    Collection<TblPartcategory> getPartCategoriesByType(String type);
    void insertPartCategory(String name, String type, String image, String des, String createdAt, String updatedAt);
    void updatePartCategory(Integer id, String name, String type, String image, String des, String updatedAt);
    void deletePartCategory(Integer id);
    
    //Parts
    Collection<TblParts> getAllParts();
    Collection<TblParts> getPartsById(Integer id);
    Collection<TblParts> getPartsByName(String name);
    Collection<TblParts> getPartsByModel(String model);
    Collection<TblParts> getPartsByCategory(String category);
    void insertPart(Integer modelId, Integer partCatId, String name, Integer price, String des, String image1, String image2, String image3, String pdf, String url, String isactive, String createdAt, String updatedAt);
    void updatePart(Integer partId, Integer modelId, Integer partCatId, String name, Integer price, String des, String image1, String image2, String image3, String pdf, String url, String isactive, String updatedAt);
    void updateActivePart(Integer id, String isactive, String updatedAt);
    void deletePart(Integer id);
    
    //Services
    Collection<TblServices> getAllServices();
    Collection<TblServices> getAllServicesById(Integer id);
    Collection<TblServices> getAllServicesByName(String name);
    Collection<TblServices> getAllServicesByType(String type);
    void insertService(String name, String des, Integer price, String isactive, String type, String createdAt, String updatedAt);
    void updateService(Integer id, String name, String des, Integer price, String isactive, String type, String updatedAt);
    void updateActiveService(Integer id, String isactive, String updatedAt);
    void deleteService(Integer id);
    
    //Feedbacks
    Collection<TblFeedback> getAllFeedbacks();
    Collection<TblFeedback> getFeedbacksById(Integer id);
    Collection<TblFeedback> getFeedbacksByName(String name);
    Collection<TblFeedback> getFeedbacksByContactNo(String contact);
    Collection<TblFeedback> getFeedbacksByEmail(String email);
    
    //State
    void insertState(String name, String code, String createdAt, String updatedAt);
    void updateState(Integer id, String name, String code, String updatedAt);
    void deleteState(Integer id);
    Collection<TblState> getAllStates();
    Collection<TblState> getStatesById(Integer id);
    Collection<TblState> getStatesByName(String name);
    Collection<TblState> getStatesByCode(String code);
    
    //City
    void insertCity(String name, Integer stateId, String code, String createdAt, String updatedAt);
    void updateCity(Integer id, String name, Integer stateId, String code, String updatedAt);
    void deleteCity(Integer id);
    Collection<TblCity> getAllCities();
    Collection<TblCity> getCitiesById(Integer id);
    Collection<TblCity> getCitiesByState(String state);
    Collection<TblCity> getCitiesByName(String name);
    Collection<TblCity> getCitiesByCode(String code);
    
    //Service order
    //void serviceDetail(Integer ServiceOrderId, Integer ServiceId, String cratedAt, String updatedAt);
    void updateStatus(Integer ServiceOrderId, String status, String updatedAt);
    Collection<TblServiceorder> getAllServiceOrders();
    Collection<TblServiceorder> getServiceOrderById(Integer ServiceOrderId);
    Collection<TblServicelist> getServiceOrderDetailsByServiceOrderId(Integer serviceOrderId);
    
    //orders
    //void orderDetail(Integer orderId, Integer PartId, String createdAt, String updatedAt);
    void updateorderStatus(Integer OrderId, String status, String updatedAt);
    Collection<TblOrder> getAllOrders();
    Collection<TblOrder> getOrdersById(Integer orderId);
    Collection<TblOrderdetail> getOrderDetailByOrderId(Integer orderId);
    
    //Users
    Collection<Usermaster> getAllUsers();
    Collection<Usermaster> getUsersByName(String userName);
}
