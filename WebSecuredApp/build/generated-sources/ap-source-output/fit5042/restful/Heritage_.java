package fit5042.restful;

import fit5042.restful.Architecturalstyle;
import fit5042.restful.Heritagegroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-22T10:11:49")
@StaticMetamodel(Heritage.class)
public class Heritage_ { 

    public static volatile SingularAttribute<Heritage, Date> dateofconstructionfrom;
    public static volatile SingularAttribute<Heritage, Architecturalstyle> architecturalstyleArchstyleId;
    public static volatile SingularAttribute<Heritage, String> city;
    public static volatile SingularAttribute<Heritage, String> streetAddress;
    public static volatile SingularAttribute<Heritage, String> streetNumber;
    public static volatile SingularAttribute<Heritage, String> authority;
    public static volatile SingularAttribute<Heritage, Heritagegroup> heritagegroupGroupId;
    public static volatile SingularAttribute<Heritage, String> postcode;
    public static volatile SingularAttribute<Heritage, Integer> heritageId;
    public static volatile SingularAttribute<Heritage, Date> dateofconstructionto;
    public static volatile SingularAttribute<Heritage, String> suburb;

}