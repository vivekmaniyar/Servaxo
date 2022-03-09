/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tbl_servicelist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServicelist.findAll", query = "SELECT t FROM TblServicelist t"),
    @NamedQuery(name = "TblServicelist.findByUserVehicleId", query = "SELECT t FROM TblServicelist t WHERE t.tblServicelistPK.userVehicleId = :userVehicleId"),
    @NamedQuery(name = "TblServicelist.findByServiceId", query = "SELECT t FROM TblServicelist t WHERE t.tblServicelistPK.serviceId = :serviceId")})
public class TblServicelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblServicelistPK tblServicelistPK;
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
    @JoinColumn(name = "user_vehicle_id", referencedColumnName = "serviceorder_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblServiceorder tblServiceorder;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblServices tblServices;

    public TblServicelist() {
    }

    public TblServicelist(TblServicelistPK tblServicelistPK) {
        this.tblServicelistPK = tblServicelistPK;
    }

    public TblServicelist(TblServicelistPK tblServicelistPK, String createdAt, String updatedAt) {
        this.tblServicelistPK = tblServicelistPK;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TblServicelist(int userVehicleId, int serviceId) {
        this.tblServicelistPK = new TblServicelistPK(userVehicleId, serviceId);
    }

    public TblServicelistPK getTblServicelistPK() {
        return tblServicelistPK;
    }

    public void setTblServicelistPK(TblServicelistPK tblServicelistPK) {
        this.tblServicelistPK = tblServicelistPK;
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

    public TblServiceorder getTblServiceorder() {
        return tblServiceorder;
    }

    public void setTblServiceorder(TblServiceorder tblServiceorder) {
        this.tblServiceorder = tblServiceorder;
    }

    public TblServices getTblServices() {
        return tblServices;
    }

    public void setTblServices(TblServices tblServices) {
        this.tblServices = tblServices;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblServicelistPK != null ? tblServicelistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicelist)) {
            return false;
        }
        TblServicelist other = (TblServicelist) object;
        if ((this.tblServicelistPK == null && other.tblServicelistPK != null) || (this.tblServicelistPK != null && !this.tblServicelistPK.equals(other.tblServicelistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServicelist[ tblServicelistPK=" + tblServicelistPK + " ]";
    }
    
}
