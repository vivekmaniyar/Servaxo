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
@Table(name = "usermaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByUserId", query = "SELECT u FROM Usermaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usermaster.findByUsername", query = "SELECT u FROM Usermaster u WHERE u.username = :username"),
    @NamedQuery(name = "Usermaster.findByName", query = "SELECT u FROM Usermaster u WHERE u.username = :username"),
    @NamedQuery(name = "Usermaster.findByContact", query = "SELECT u FROM Usermaster u WHERE u.contact = :contact")})
public class Usermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reg_datetime")
    private String regDatetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<TblServiceorder> tblServiceorderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<TblServicecart> tblServicecartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<TblOrder> tblOrderCollection;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private Groupmaster groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<TblCart> tblCartCollection;

    public Usermaster() {
    }

    public Usermaster(Integer userId) {
        this.userId = userId;
    }

    public Usermaster(Integer userId, String username, String password, String name, String contact, String regDatetime, String updatedAt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.regDatetime = regDatetime;
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(String regDatetime) {
        this.regDatetime = regDatetime;
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

    @JsonbTransient
    public Collection<TblServicecart> getTblServicecartCollection() {
        return tblServicecartCollection;
    }

    public void setTblServicecartCollection(Collection<TblServicecart> tblServicecartCollection) {
        this.tblServicecartCollection = tblServicecartCollection;
    }

    @JsonbTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    public Groupmaster getGroupId() {
        return groupId;
    }

    public void setGroupId(Groupmaster groupId) {
        this.groupId = groupId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usermaster[ userId=" + userId + " ]";
    }
    
}
