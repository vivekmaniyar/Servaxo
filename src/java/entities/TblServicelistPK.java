/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vicky
 */
@Embeddable
public class TblServicelistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_vehicle_id")
    private int userVehicleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_id")
    private int serviceId;

    public TblServicelistPK() {
    }

    public TblServicelistPK(int userVehicleId, int serviceId) {
        this.userVehicleId = userVehicleId;
        this.serviceId = serviceId;
    }

    public int getUserVehicleId() {
        return userVehicleId;
    }

    public void setUserVehicleId(int userVehicleId) {
        this.userVehicleId = userVehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userVehicleId;
        hash += (int) serviceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicelistPK)) {
            return false;
        }
        TblServicelistPK other = (TblServicelistPK) object;
        if (this.userVehicleId != other.userVehicleId) {
            return false;
        }
        if (this.serviceId != other.serviceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblServicelistPK[ userVehicleId=" + userVehicleId + ", serviceId=" + serviceId + " ]";
    }
    
}
