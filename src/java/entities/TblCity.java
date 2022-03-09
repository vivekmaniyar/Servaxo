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
@Table(name = "tbl_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCity.findAll", query = "SELECT t FROM TblCity t"),
    @NamedQuery(name = "TblCity.findByCityId", query = "SELECT t FROM TblCity t WHERE t.cityId = :cityId"),
    @NamedQuery(name = "TblCity.findByCityName", query = "SELECT t FROM TblCity t WHERE t.cityName = :cityName"),
    @NamedQuery(name = "TblCity.findByCityCode", query = "SELECT t FROM TblCity t WHERE t.cityCode = :cityCode"),
    @NamedQuery(name = "TblCity.findByState", query = "SELECT t FROM TblCity t WHERE t.stateId = :stateId")})
public class TblCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "city_name")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "city_code")
    private String cityCode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<TblOrder> tblOrderCollection;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private TblState stateId;

    public TblCity() {
    }

    public TblCity(Integer cityId) {
        this.cityId = cityId;
    }

    public TblCity(Integer cityId, String cityName, String cityCode, String createdAt, String updatedAt) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    public TblState getStateId() {
        return stateId;
    }

    public void setStateId(TblState stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCity)) {
            return false;
        }
        TblCity other = (TblCity) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCity[ cityId=" + cityId + " ]";
    }
    
}
