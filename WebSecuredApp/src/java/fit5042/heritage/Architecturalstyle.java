/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adnan
 */
@Entity
@Table(name = "ARCHITECTURALSTYLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Architecturalstyle.findAll", query = "SELECT a FROM Architecturalstyle a"),
    @NamedQuery(name = "Architecturalstyle.findByArchstyleId", query = "SELECT a FROM Architecturalstyle a WHERE a.archstyleId = :archstyleId"),
    @NamedQuery(name = "Architecturalstyle.findByPeriodfromto", query = "SELECT a FROM Architecturalstyle a WHERE a.periodfromto = :periodfromto"),
    @NamedQuery(name = "Architecturalstyle.findByPeriodname", query = "SELECT a FROM Architecturalstyle a WHERE a.periodname = :periodname")})
public class Architecturalstyle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCHSTYLE_ID")
    private Integer archstyleId;
    @Size(max = 255)
    @Column(name = "PERIODFROMTO")
    private String periodfromto;
    @Size(max = 255)
    @Column(name = "PERIODNAME")
    private String periodname;
    @OneToMany(mappedBy = "architecturalstyleArchstyleId")
    private Collection<Heritage> heritageCollection;

    public Architecturalstyle() {
    }

    public Architecturalstyle(Integer archstyleId) {
        this.archstyleId = archstyleId;
    }

    public Integer getArchstyleId() {
        return archstyleId;
    }

    public void setArchstyleId(Integer archstyleId) {
        this.archstyleId = archstyleId;
    }

    public String getPeriodfromto() {
        return periodfromto;
    }

    public void setPeriodfromto(String periodfromto) {
        this.periodfromto = periodfromto;
    }

    public String getPeriodname() {
        return periodname;
    }

    public void setPeriodname(String periodname) {
        this.periodname = periodname;
    }

    @XmlTransient
    public Collection<Heritage> getHeritageCollection() {
        return heritageCollection;
    }

    public void setHeritageCollection(Collection<Heritage> heritageCollection) {
        this.heritageCollection = heritageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archstyleId != null ? archstyleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Architecturalstyle)) {
            return false;
        }
        Architecturalstyle other = (Architecturalstyle) object;
        if ((this.archstyleId == null && other.archstyleId != null) || (this.archstyleId != null && !this.archstyleId.equals(other.archstyleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.heritage.Architecturalstyle[ archstyleId=" + archstyleId + " ]";
    }
    
}
