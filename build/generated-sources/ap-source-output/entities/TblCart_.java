package entities;

import entities.TblParts;
import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-09T15:32:00")
@StaticMetamodel(TblCart.class)
public class TblCart_ { 

    public static volatile SingularAttribute<TblCart, String> createdAt;
    public static volatile SingularAttribute<TblCart, TblParts> partId;
    public static volatile SingularAttribute<TblCart, Integer> cartId;
    public static volatile SingularAttribute<TblCart, Integer> qty;
    public static volatile SingularAttribute<TblCart, Usermaster> userId;
    public static volatile SingularAttribute<TblCart, String> updatedAt;

}