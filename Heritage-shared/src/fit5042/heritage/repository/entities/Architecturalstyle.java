/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adnan
 */
@Entity
@NamedQueries({@NamedQuery(name = Architecturalstyle.GET_ALL_QUERY_NAME, query = "SELECT c FROM Architecturalstyle c")})
@XmlRootElement
public class Architecturalstyle implements Serializable{
    public static final String GET_ALL_QUERY_NAME = "Architecturalstyle.getAll";
    private int archStyleId;
    private String periodName;
    private String periodFromTo;
    private Set<Heritage> heritages;
    public Architecturalstyle()
    {
    }
    public Architecturalstyle(int archStyleId,String periodName,String periodFromTo)
    {
        this.archStyleId = archStyleId;
        this.periodName = periodName;
        this.periodFromTo = periodFromTo;
        this.heritages = new HashSet<>();
    }
    @Id
    @GeneratedValue
    @Column(name = "archstyle_id")
    public int getArchStyleId() {
        return archStyleId;
    }

    public void setArchStyleId(int archStyleId) {
        this.archStyleId = archStyleId;
    }
    
    public String getPeriodName()
    {
        return periodName;
    }
    
    public void setPeriodName(String periodName)
    {
        this.periodName = periodName;
    }
    public String getPeriodFromTo()
    {
        return periodFromTo;
    }
    
    public void setPeriodFromTo(String periodFromTo)
    {
        this.periodFromTo = periodFromTo;
    }
    @OneToMany(mappedBy = "architecturalstyle")
    public Set<Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(Set<Heritage> heritages) {
        this.heritages = heritages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.archStyleId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Architecturalstyle other = (Architecturalstyle) obj;
        if (this.archStyleId != other.archStyleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.archStyleId + " - " + periodName + " - " + periodFromTo;
    }    
}
