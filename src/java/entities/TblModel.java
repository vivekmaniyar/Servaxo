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
@Table(name = "tbl_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblModel.findAll", query = "SELECT t FROM TblModel t"),
    @NamedQuery(name = "TblModel.findByModelId", query = "SELECT t FROM TblModel t WHERE t.modelId = :modelId"),
    @NamedQuery(name = "TblModel.findByCompanyId", query = "SELECT t FROM TblModel t WHERE t.companyId = :companyId"),
    @NamedQuery(name = "TblModel.findByModelName", query = "SELECT t FROM TblModel t WHERE t.modelName = :modelName")})
public class TblModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_id")
    private Integer modelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "model_name")
    private String modelName;
    @Lob
    @Size(max = 65535)
    @Column(name = "model_img")
    private String modelImg;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelId")
    private Collection<TblServiceorder> tblServiceorderCollection;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @ManyToOne(optional = false)
    private TblCompany companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelId")
    private Collection<TblParts> tblPartsCollection;

    public TblModel() {
    }

    public TblModel(Integer modelId) {
        this.modelId = modelId;
    }

    public TblModel(Integer modelId, String modelName, String createdAt, String updatedAt) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelImg() {
        return modelImg;
    }

    public void setModelImg(String modelImg) {
        this.modelImg = modelImg;
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
    public Collection<TblServiceorder> getTblServiceorderCollection() {
        return tblServiceorderCollection;
    }

    public void setTblServiceorderCollection(Collection<TblServiceorder> tblServiceorderCollection) {
        this.tblServiceorderCollection = tblServiceorderCollection;
    }

    public TblCompany getCompanyId() {
        return companyId;
    }

    public void setCompanyId(TblCompany companyId) {
        this.companyId = companyId;
    }

    @JsonbTransient
    public Collection<TblParts> getTblPartsCollection() {
        return tblPartsCollection;
    }

    public void setTblPartsCollection(Collection<TblParts> tblPartsCollection) {
        this.tblPartsCollection = tblPartsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblModel)) {
            return false;
        }
        TblModel other = (TblModel) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblModel[ modelId=" + modelId + " ]";
    }
    
}
