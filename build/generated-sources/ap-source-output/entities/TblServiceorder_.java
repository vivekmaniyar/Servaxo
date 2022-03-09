package entities;

import entities.TblModel;
import entities.TblServicelist;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-09T15:32:00")
@StaticMetamodel(TblServiceorder.class)
public class TblServiceorder_ { 

    public static volatile SingularAttribute<TblServiceorder, Integer> pincode;
    public static volatile SingularAttribute<TblServiceorder, TblModel> modelId;
    public static volatile CollectionAttribute<TblServiceorder, TblServicelist> tblServicelistCollection;
    public static volatile SingularAttribute<TblServiceorder, Integer> serviceorderId;
    public static volatile SingularAttribute<TblServiceorder, String> remark;
    public static volatile SingularAttribute<TblServiceorder, Usermaster> userId;
    public static volatile SingularAttribute<TblServiceorder, String> vehicleNo;
    public static volatile SingularAttribute<TblServiceorder, String> pickUpDate;
    public static volatile SingularAttribute<TblServiceorder, Integer> totalPayment;
    public static volatile SingularAttribute<TblServiceorder, String> orderdatetime;
    public static volatile SingularAttribute<TblServiceorder, String> addressline2;
    public static volatile SingularAttribute<TblServiceorder, String> addressline1;
    public static volatile SingularAttribute<TblServiceorder, String> landmark;
    public static volatile SingularAttribute<TblServiceorder, String> status;
    public static volatile SingularAttribute<TblServiceorder, String> updatedAt;

}