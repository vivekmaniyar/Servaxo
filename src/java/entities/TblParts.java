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
@Table(name = "tbl_parts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblParts.findAll", query = "SELECT t FROM TblParts t"),
    @NamedQuery(name = "TblParts.findByPartId", query = "SELECT t FROM TblParts t WHERE t.partId = :partId"),
    @NamedQuery(name = "TblParts.findByPartName", query = "SELECT t FROM TblParts t WHERE t.partName = :partName"),
    @NamedQuery(name = "TblParts.findByPrice", query = "SELECT t FROM TblParts t WHERE t.price = :price"),
    @NamedQuery(name = "TblParts.findByIsactive", query = "SELECT t FROM TblParts t WHERE t.isactive = :isactive")})
public class TblParts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "part_id")
    private Integer partId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "part_name")
    private String partName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Lob
    @Size(max = 65535)
    @Column(name = "part_description")
    private String partDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "img1")
    private String img1;
    @Lob
    @Size(max = 65535)
    @Column(name = "img2")
    private String img2;
    @Lob
    @Size(max = 65535)
    @Column(name = "img3")
    private String img3;
    @Lob
    @Size(max = 65535)
    @Column(name = "part_manual_pdf")
    private String partManualPdf;
    @Lob
    @Size(max = 65535)
    @Column(name = "video_url")
    private String videoUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isactive")
    private String isactive;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "addeddatetime")
    private String addeddatetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    @ManyToOne(optional = false)
    private TblModel modelId;
    @JoinColumn(name = "partcategory_id", referencedColumnName = "partcategory_id")
    @ManyToOne(optional = false)
    private TblPartcategory partcategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblParts")
    private Collection<TblOrderdetail> tblOrderdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partId")
    private Collection<TblCart> tblCartCollection;

    public TblParts() {
    }

    public TblParts(Integer partId) {
        this.partId = partId;
    }

    public TblParts(Integer partId, String partName, int price, String isactive, String addeddatetime, String updatedAt) {
        this.partId = partId;
        this.partName = partName;
        this.price = price;
        this.isactive = isactive;
        this.addeddatetime = addeddatetime;
        this.updatedAt = updatedAt;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getPartManualPdf() {
        return partManualPdf;
    }

    public void setPartManualPdf(String partManualPdf) {
        this.partManualPdf = partManualPdf;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getAddeddatetime() {
        return addeddatetime;
    }

    public void setAddeddatetime(String addeddatetime) {
        this.addeddatetime = addeddatetime;
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

    public TblPartcategory getPartcategoryId() {
        return partcategoryId;
    }

    public void setPartcategoryId(TblPartcategory partcategoryId) {
        this.partcategoryId = partcategoryId;
    }

    @JsonbTransient
    public Collection<TblOrderdetail> getTblOrderdetailCollection() {
        return tblOrderdetailCollection;
    }

    public void setTblOrderdetailCollection(Collection<TblOrderdetail> tblOrderdetailCollection) {
        this.tblOrderdetailCollection = tblOrderdetailCollection;
    }

    @JsonbTransient
    public Collection<TblCart> getTblCartCollection() {
        return tblCartCollection;
    }

    public void setTblCartCollection(Collection<TblCart> tblCartCollection) {
        this.tblCartCollection = tblCartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partId != null ? partId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblParts)) {
            return false;
        }
        TblParts other = (TblParts) object;
        if ((this.partId == null && other.partId != null) || (this.partId != null && !this.partId.equals(other.partId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblParts[ partId=" + partId + " ]";
    }
    
}
