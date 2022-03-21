package entities;

import entities.TblCart;
import entities.TblModel;
import entities.TblOrderdetail;
import entities.TblPartcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:29:02")
@StaticMetamodel(TblParts.class)
public class TblParts_ { 

    public static volatile SingularAttribute<TblParts, String> img3;
    public static volatile SingularAttribute<TblParts, Integer> partId;
    public static volatile SingularAttribute<TblParts, String> addeddatetime;
    public static volatile SingularAttribute<TblParts, TblModel> modelId;
    public static volatile SingularAttribute<TblParts, String> isactive;
    public static volatile CollectionAttribute<TblParts, TblCart> tblCartCollection;
    public static volatile CollectionAttribute<TblParts, TblOrderdetail> tblOrderdetailCollection;
    public static volatile SingularAttribute<TblParts, String> partName;
    public static volatile SingularAttribute<TblParts, String> videoUrl;
    public static volatile SingularAttribute<TblParts, Integer> price;
    public static volatile SingularAttribute<TblParts, String> partDescription;
    public static volatile SingularAttribute<TblParts, TblPartcategory> partcategoryId;
    public static volatile SingularAttribute<TblParts, String> img2;
    public static volatile SingularAttribute<TblParts, String> img1;
    public static volatile SingularAttribute<TblParts, String> partManualPdf;
    public static volatile SingularAttribute<TblParts, String> updatedAt;

}