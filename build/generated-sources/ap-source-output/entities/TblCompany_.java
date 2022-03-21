package entities;

import entities.TblModel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblCompany.class)
public class TblCompany_ { 

    public static volatile SingularAttribute<TblCompany, String> createdAt;
    public static volatile SingularAttribute<TblCompany, Integer> companyId;
    public static volatile SingularAttribute<TblCompany, String> companyType;
    public static volatile CollectionAttribute<TblCompany, TblModel> tblModelCollection;
    public static volatile SingularAttribute<TblCompany, String> companyLogo;
    public static volatile SingularAttribute<TblCompany, String> companyName;
    public static volatile SingularAttribute<TblCompany, String> updatedAt;

}