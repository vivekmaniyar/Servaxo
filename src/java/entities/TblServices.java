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
import javax.persistence.Lob;
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
@Table(name = "tbl_services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServices.findAll", query = "SELECT t FROM TblServices t"),
    @NamedQuery(name = "TblServices.findByServiceId", query = "SELECT t FROM TblServices t WHERE t.serviceId = :serviceId"),
    @NamedQuery(name = "TblServices.findByServiceName", query = "SELECT t FROM TblServices t WHERE t.serviceName = :serviceName"),
    @NamedQuery(name = "TblServices.findByServicePrice", query = "SELECT t FROM TblServices t WHERE t.servicePrice = :servicePrice"),
    @NamedQuery(name = "TblServices.findByIsactive", query = "SELECT t FROM TblServices t WHERE t.isactive = :isactive"),
    @NamedQuery(name = "TblServices.findByType", query = "SELECT t FROM TblServices t WHERE t.type = :type")})
public class TblServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "service_name")
    private String serviceName;
    @Lob
    @Size(max = 65535)
    @Column(name = "service_description")
    private String serviceDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_price")
    private int servicePrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isactive")
    private String isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "created_at")
    private String createdAt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private Collection<TblServicecart> tblServicecartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblServices")
    private Collection<TblServicelist> tblServicelistCollection;

    public TblServices() {
    }

    public TblServices(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public TblServices(Integer serviceId, String serviceName, int servicePrice, String isactive, String type, String createdAt, String updatedAt) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.isactive = isactive;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonbTransient
    public Collection<TblServicecart> getTblServicecartCollection() {
        return tblServicecartCollection;
    }

    public void setTblServicecartCollection(Collection<TblServicecart> tblServicecartCollection) {
        this.tblServicecartCollection = tblServicecartCollection;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServices)) {
            return false;
        }
        TblServices other = (TblServices) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServices[ serviceId=" + serviceId + " ]";
    }
    
}
