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
public class TblOrderdetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "part_id")
    private int partId;

    public TblOrderdetailPK() {
    }

    public TblOrderdetailPK(int orderId, int partId) {
        this.orderId = orderId;
        this.partId = partId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) partId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrderdetailPK)) {
            return false;
        }
        TblOrderdetailPK other = (TblOrderdetailPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.partId != other.partId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblOrderdetailPK[ orderId=" + orderId + ", partId=" + partId + " ]";
    }
    
}
