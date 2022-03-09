package entities;

import entities.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-09T15:32:00")
@StaticMetamodel(Groupmaster.class)
public class Groupmaster_ { 

    public static volatile SingularAttribute<Groupmaster, String> createdAt;
    public static volatile SingularAttribute<Groupmaster, String> groupName;
    public static volatile CollectionAttribute<Groupmaster, Usermaster> usermasterCollection;
    public static volatile SingularAttribute<Groupmaster, Integer> groupId;
    public static volatile SingularAttribute<Groupmaster, String> updatedAt;

}