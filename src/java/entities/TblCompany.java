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
@Table(name = "tbl_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCompany.findAll", query = "SELECT t FROM TblCompany t"),
    @NamedQuery(name = "TblCompany.findByCompanyId", query = "SELECT t FROM TblCompany t WHERE t.companyId = :companyId"),
    @NamedQuery(name = "TblCompany.findByCompanyName", query = "SELECT t FROM TblCompany t WHERE t.companyName = :companyName"),
    @NamedQuery(name = "TblCompany.findByCompanyType", query = "SELECT t FROM TblCompany t WHERE t.companyType = :companyType")})
public class TblCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "company_id")
    private Integer companyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "company_name")
    private String companyName;
    @Lob
    @Size(max = 65535)
    @Column(name = "company_logo")
    private String companyLogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "company_type")
    private String companyType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<TblModel> tblModelCollection;

    public TblCompany() {
    }

    public TblCompany(Integer companyId) {
        this.companyId = companyId;
    }

    public TblCompany(Integer companyId, String companyName, String companyType, String createdAt, String updatedAt) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyType = companyType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
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
    public Collection<TblModel> getTblModelCollection() {
        return tblModelCollection;
    }

    public void setTblModelCollection(Collection<TblModel> tblModelCollection) {
        this.tblModelCollection = tblModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCompany)) {
            return false;
        }
        TblCompany other = (TblCompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCompany[ companyId=" + companyId + " ]";
    }
    
}
