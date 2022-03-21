package entities;

import entities.TblCity;
import entities.TblOrderdetail;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblOrder.class)
public class TblOrder_ { 

    public static volatile SingularAttribute<TblOrder, Integer> pincode;
    public static volatile SingularAttribute<TblOrder, String> ispay;
    public static volatile SingularAttribute<TblOrder, Integer> orderId;
    public static volatile SingularAttribute<TblOrder, TblCity> cityId;
    public static volatile SingularAttribute<TblOrder, String> updatesAt;
    public static volatile SingularAttribute<TblOrder, Usermaster> userId;
    public static volatile CollectionAttribute<TblOrder, TblOrderdetail> tblOrderdetailCollection;
    public static volatile SingularAttribute<TblOrder, String> orderDatetime;
    public static volatile SingularAttribute<TblOrder, Integer> totalPayment;
    public static volatile SingularAttribute<TblOrder, String> paymode;
    public static volatile SingularAttribute<TblOrder, String> addressline2;
    public static volatile SingularAttribute<TblOrder, String> addressline1;
    public static volatile SingularAttribute<TblOrder, String> landmark;
    public static volatile SingularAttribute<TblOrder, String> status;

}