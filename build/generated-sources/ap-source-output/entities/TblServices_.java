package entities;

import entities.TblServicecart;
import entities.TblServicelist;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblServices.class)
public class TblServices_ { 

    public static volatile SingularAttribute<TblServices, String> createdAt;
    public static volatile SingularAttribute<TblServices, Integer> servicePrice;
    public static volatile CollectionAttribute<TblServices, TblServicelist> tblServicelistCollection;
    public static volatile SingularAttribute<TblServices, String> isactive;
    public static volatile SingularAttribute<TblServices, String> serviceDescription;
    public static volatile CollectionAttribute<TblServices, TblServicecart> tblServicecartCollection;
    public static volatile SingularAttribute<TblServices, Integer> serviceId;
    public static volatile SingularAttribute<TblServices, String> serviceName;
    public static volatile SingularAttribute<TblServices, String> type;
    public static volatile SingularAttribute<TblServices, String> updatedAt;

}