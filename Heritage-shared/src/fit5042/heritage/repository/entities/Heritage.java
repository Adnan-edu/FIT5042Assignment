/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.repository.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adnan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Heritage.GET_ALL_QUERY_NAME, query = "SELECT p FROM Heritage p order by p.heritageId desc")})
@XmlRootElement
public class Heritage implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_ALL_QUERY_NAME = "Heritage.getAll";

    private int heritageId;
    private String authority;
    private Date dateOfConstructionFrom;
    private Date dateOfConstructionTo;
    Architecturalstyle architecturalstyle;

    private Address address;
    private HeritageGroup heritageGroup;

    private Set<String> tags;

    public Heritage() {
        this.tags = new HashSet<>();
    }

    public Heritage(String authority, Date dateOfConstructionFrom, Date dateOfConstructionTo, Architecturalstyle architecturalstyle, Address address, HeritageGroup heritageGroup, Set<String> tags) {
        this.authority = authority;
        this.dateOfConstructionFrom = dateOfConstructionFrom;
        this.dateOfConstructionTo = dateOfConstructionTo;
        this.architecturalstyle = architecturalstyle;
        this.address = address;
        this.heritageGroup = heritageGroup;
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "heritage_id")
    public int getHeritageId() {
        return heritageId;
    }

    public void setHeritageId(int heritageId) {
        this.heritageId = heritageId;
    }
    
    public String getAuthority()
    {
        return authority;
    }
    public void setAuthority(String authority)
    {
        this.authority = authority;
    }
    @Temporal(TemporalType.DATE)
    public Date getDateOfConstructionFrom()
    {
        return dateOfConstructionFrom;
    }
    public void setDateOfConstructionFrom(Date dateOfConstructionFrom)
    {
        this.dateOfConstructionFrom = dateOfConstructionFrom;
    }
    @Temporal(TemporalType.DATE)
    public Date getDateOfConstructionTo()
    {
        return dateOfConstructionTo;
    }
    public void setDateOfConstructionTo(Date dateOfConstructionTo)
    {
        this.dateOfConstructionTo = dateOfConstructionTo;
    }
    
    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }    

    @ManyToOne
    public Architecturalstyle getArchitecturalstyle() {
        return architecturalstyle;
    }

    public void setArchitecturalstyle(Architecturalstyle architecturalstyle) {
        this.architecturalstyle = architecturalstyle;
    }
    @ManyToOne
    public HeritageGroup getHeritageGroup() {
        return heritageGroup;
    }

    public void setHeritageGroup(HeritageGroup heritageGroup) {
        this.heritageGroup = heritageGroup;
    }
    @Override
    public String toString() {
        return "Heritage{" + "heritageId=" + heritageId + ", authority=" + authority + ", dateOfConstructionFrom=" + dateOfConstructionFrom + ", dateOfConstructionTo=" + dateOfConstructionTo + ", address=" + address + ", heritageGroup=" + heritageGroup + ", architecturalstyle=" + architecturalstyle + ", tags=" + tags + '}';
    }    
}
