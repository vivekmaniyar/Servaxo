package entities;

import entities.TblCity;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-09T15:32:00")
@StaticMetamodel(TblState.class)
public class TblState_ { 

    public static volatile SingularAttribute<TblState, String> createdAt;
    public static volatile SingularAttribute<TblState, String> stateName;
    public static volatile SingularAttribute<TblState, Integer> stateId;
    public static volatile SingularAttribute<TblState, String> stateCode;
    public static volatile SingularAttribute<TblState, String> updatedAt;
    public static volatile CollectionAttribute<TblState, TblCity> tblCityCollection;

}