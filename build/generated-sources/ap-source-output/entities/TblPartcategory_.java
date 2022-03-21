package entities;

import entities.TblParts;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblPartcategory.class)
public class TblPartcategory_ { 

    public static volatile SingularAttribute<TblPartcategory, String> createdAt;
    public static volatile CollectionAttribute<TblPartcategory, TblParts> tblPartsCollection;
    public static volatile SingularAttribute<TblPartcategory, Integer> partcategoryId;
    public static volatile SingularAttribute<TblPartcategory, String> categoryName;
    public static volatile SingularAttribute<TblPartcategory, String> categoryImg;
    public static volatile SingularAttribute<TblPartcategory, String> vehicleType;
    public static volatile SingularAttribute<TblPartcategory, String> categoryDescription;
    public static volatile SingularAttribute<TblPartcategory, String> updatedAt;

}