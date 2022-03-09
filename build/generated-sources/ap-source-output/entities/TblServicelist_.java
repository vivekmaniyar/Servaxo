package entities;

import entities.TblServicelistPK;
import entities.TblServiceorder;
import entities.TblServices;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-09T15:32:00")
@StaticMetamodel(TblServicelist.class)
public class TblServicelist_ { 

    public static volatile SingularAttribute<TblServicelist, TblServices> tblServices;
    public static volatile SingularAttribute<TblServicelist, String> createdAt;
    public static volatile SingularAttribute<TblServicelist, TblServiceorder> tblServiceorder;
    public static volatile SingularAttribute<TblServicelist, TblServicelistPK> tblServicelistPK;
    public static volatile SingularAttribute<TblServicelist, String> updatedAt;

}