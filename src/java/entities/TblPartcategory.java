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
@Table(name = "tbl_partcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPartcategory.findAll", query = "SELECT t FROM TblPartcategory t"),
    @NamedQuery(name = "TblPartcategory.findByPartcategoryId", query = "SELECT t FROM TblPartcategory t WHERE t.partcategoryId = :partcategoryId"),
    @NamedQuery(name = "TblPartcategory.findByCategoryName", query = "SELECT t FROM TblPartcategory t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TblPartcategory.findByVehicleType", query = "SELECT t FROM TblPartcategory t WHERE t.vehicleType = :vehicleType"),
    @NamedQuery(name = "TblPartcategory.findByCategoryImg", query = "SELECT t FROM TblPartcategory t WHERE t.categoryImg = :categoryImg")})
public class TblPartcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "partcategory_id")
    private Integer partcategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "category_img")
    private String categoryImg;
    @Lob
    @Size(max = 65535)
    @Column(name = "category_description")
    private String categoryDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partcategoryId")
    private Collection<TblParts> tblPartsCollection;

    public TblPartcategory() {
    }

    public TblPartcategory(Integer partcategoryId) {
        this.partcategoryId = partcategoryId;
    }

    public TblPartcategory(Integer partcategoryId, String categoryName, String vehicleType, String categoryImg, String createdAt, String updatedAt) {
        this.partcategoryId = partcategoryId;
        this.categoryName = categoryName;
        this.vehicleType = vehicleType;
        this.categoryImg = categoryImg;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getPartcategoryId() {
        return partcategoryId;
    }

    public void setPartcategoryId(Integer partcategoryId) {
        this.partcategoryId = partcategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
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
    public Collection<TblParts> getTblPartsCollection() {
        return tblPartsCollection;
    }

    public void setTblPartsCollection(Collection<TblParts> tblPartsCollection) {
        this.tblPartsCollection = tblPartsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partcategoryId != null ? partcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPartcategory)) {
            return false;
        }
        TblPartcategory other = (TblPartcategory) object;
        if ((this.partcategoryId == null && other.partcategoryId != null) || (this.partcategoryId != null && !this.partcategoryId.equals(other.partcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPartcategory[ partcategoryId=" + partcategoryId + " ]";
    }
    
}
