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
@Table(name = "tbl_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblState.findAll", query = "SELECT t FROM TblState t"),
    @NamedQuery(name = "TblState.findByStateId", query = "SELECT t FROM TblState t WHERE t.stateId = :stateId"),
    @NamedQuery(name = "TblState.findByStateName", query = "SELECT t FROM TblState t WHERE t.stateName = :stateName"),
    @NamedQuery(name = "TblState.findByStateCode", query = "SELECT t FROM TblState t WHERE t.stateCode = :stateCode")})
public class TblState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "state_name")
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "state_code")
    private String stateCode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<TblCity> tblCityCollection;

    public TblState() {
    }

    public TblState(Integer stateId) {
        this.stateId = stateId;
    }

    public TblState(Integer stateId, String stateName, String stateCode, String createdAt, String updatedAt) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateCode = stateCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
    public Collection<TblCity> getTblCityCollection() {
        return tblCityCollection;
    }

    public void setTblCityCollection(Collection<TblCity> tblCityCollection) {
        this.tblCityCollection = tblCityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblState)) {
            return false;
        }
        TblState other = (TblState) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblState[ stateId=" + stateId + " ]";
    }
    
}
