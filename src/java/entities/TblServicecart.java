/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vicky
 */
@Entity
@Table(name = "tbl_servicecart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServicecart.findAll", query = "SELECT t FROM TblServicecart t"),
    @NamedQuery(name = "TblServicecart.findByServicecartId", query = "SELECT t FROM TblServicecart t WHERE t.servicecartId = :servicecartId"),
    @NamedQuery(name = "TblServicecart.findByUserId", query = "SELECT t FROM TblServicecart t WHERE t.userId = :userId")})
public class TblServicecart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servicecart_id")
    private Integer servicecartId;
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
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private TblServices serviceId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Usermaster userId;

    public TblServicecart() {
    }

    public TblServicecart(Integer servicecartId) {
        this.servicecartId = servicecartId;
    }

    public TblServicecart(Integer servicecartId, String createdAt, String updatedAt) {
        this.servicecartId = servicecartId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getServicecartId() {
        return servicecartId;
    }

    public void setServicecartId(Integer servicecartId) {
        this.servicecartId = servicecartId;
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

    public TblServices getServiceId() {
        return serviceId;
    }

    public void setServiceId(TblServices serviceId) {
        this.serviceId = serviceId;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicecartId != null ? servicecartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicecart)) {
            return false;
        }
        TblServicecart other = (TblServicecart) object;
        if ((this.servicecartId == null && other.servicecartId != null) || (this.servicecartId != null && !this.servicecartId.equals(other.servicecartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServicecart[ servicecartId=" + servicecartId + " ]";
    }
    
}
