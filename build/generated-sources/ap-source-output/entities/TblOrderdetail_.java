package entities;

import entities.TblOrder;
import entities.TblOrderdetailPK;
import entities.TblParts;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblOrderdetail.class)
public class TblOrderdetail_ { 

    public static volatile SingularAttribute<TblOrderdetail, String> createdAt;
    public static volatile SingularAttribute<TblOrderdetail, TblOrder> tblOrder;
    public static volatile SingularAttribute<TblOrderdetail, Integer> qty;
    public static volatile SingularAttribute<TblOrderdetail, TblParts> tblParts;
    public static volatile SingularAttribute<TblOrderdetail, TblOrderdetailPK> tblOrderdetailPK;
    public static volatile SingularAttribute<TblOrderdetail, String> updatedAt;

}