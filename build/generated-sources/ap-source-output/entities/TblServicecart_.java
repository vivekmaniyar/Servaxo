package entities;

import entities.TblServices;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblServicecart.class)
public class TblServicecart_ { 

    public static volatile SingularAttribute<TblServicecart, String> createdAt;
    public static volatile SingularAttribute<TblServicecart, Integer> servicecartId;
    public static volatile SingularAttribute<TblServicecart, TblServices> serviceId;
    public static volatile SingularAttribute<TblServicecart, Usermaster> userId;
    public static volatile SingularAttribute<TblServicecart, String> updatedAt;

}