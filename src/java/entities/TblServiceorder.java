/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vicky
 */
@Entity
@Table(name = "tbl_serviceorder")
@XmlRootElement  
@NamedQueries({
    @NamedQuery(name = "TblServiceorder.findAll", query = "SELECT t FROM TblServiceorder t"),
    @NamedQuery(name = "TblServiceorder.findByServiceorderId", query = "SELECT t FROM TblServiceorder t WHERE t.serviceorderId = :serviceorderId"),
    @NamedQuery(name = "TblServiceorder.findByVehicleNo", query = "SELECT t FROM TblServiceorder t WHERE t.vehicleNo = :vehicleNo"),
    @NamedQuery(name = "TblServiceorder.findByTotalPayment", query = "SELECT t FROM TblServiceorder t WHERE t.totalPayment = :totalPayment"),
    @NamedQuery(name = "TblServiceorder.findByPincode", query = "SELECT t FROM TblServiceorder t WHERE t.pincode = :pincode"),
    @NamedQuery(name = "TblServiceorder.findByUserId", query = "SELECT t FROM TblServiceorder t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblServiceorder.findByLandmark", query = "SELECT t FROM TblServiceorder t WHERE t.landmark = :landmark"),
    @NamedQuery(name = "TblServiceorder.findByStatus", query = "SELECT t FROM TblServiceorder t WHERE t.status = :status")})
public class TblServiceorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceorder_id")
    private Integer serviceorderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Lob
    @Size(max = 65535)
    @Column(name = "remark")
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_payment")
    private int totalPayment;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pick_up_date")
    private String pickUpDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "addressline1")
    private String addressline1;
    @Lob
    @Size(max = 65535)
    @Column(name = "addressline2")
    private String addressline2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "landmark")
    private String landmark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "orderdatetime")
    private String orderdatetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    @ManyToOne(optional = false)
    private TblModel modelId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Usermaster userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblServiceorder")
    private Collection<TblServicelist> tblServicelistCollection;

    public TblServiceorder() {
    }

    public TblServiceorder(Integer serviceorderId) {
        this.serviceorderId = serviceorderId;
    }

    public TblServiceorder(Integer serviceorderId, String vehicleNo, int totalPayment, String pickUpDate, String addressline1, int pincode, String landmark, String status, String orderdatetime, String updatedAt) {
        this.serviceorderId = serviceorderId;
        this.vehicleNo = vehicleNo;
        this.totalPayment = totalPayment;
        this.pickUpDate = pickUpDate;
        this.addressline1 = addressline1;
        this.pincode = pincode;
        this.landmark = landmark;
        this.status = status;
        this.orderdatetime = orderdatetime;
        this.updatedAt = updatedAt;
    }

    public Integer getServiceorderId() {
        return serviceorderId;
    }

    public void setServiceorderId(Integer serviceorderId) {
        this.serviceorderId = serviceorderId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TblModel getModelId() {
        return modelId;
    }

    public void setModelId(TblModel modelId) {
        this.modelId = modelId;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    @JsonbTransient
    public Collection<TblServicelist> getTblServicelistCollection() {
        return tblServicelistCollection;
    }

    public void setTblServicelistCollection(Collection<TblServicelist> tblServicelistCollection) {
        this.tblServicelistCollection = tblServicelistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceorderId != null ? serviceorderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServiceorder)) {
            return false;
        }
        TblServiceorder other = (TblServiceorder) object;
        if ((this.serviceorderId == null && other.serviceorderId != null) || (this.serviceorderId != null && !this.serviceorderId.equals(other.serviceorderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServiceorder[ serviceorderId=" + serviceorderId + " ]";
    }
    
}
