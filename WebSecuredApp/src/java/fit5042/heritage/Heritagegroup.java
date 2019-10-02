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
@Table(name = "HERITAGEGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heritagegroup.findAll", query = "SELECT h FROM Heritagegroup h"),
    @NamedQuery(name = "Heritagegroup.findByGroupId", query = "SELECT h FROM Heritagegroup h WHERE h.groupId = :groupId"),
    @NamedQuery(name = "Heritagegroup.findByGroupcategory", query = "SELECT h FROM Heritagegroup h WHERE h.groupcategory = :groupcategory"),
    @NamedQuery(name = "Heritagegroup.findByGroupsubcategory", query = "SELECT h FROM Heritagegroup h WHERE h.groupsubcategory = :groupsubcategory")})
public class Heritagegroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUP_ID")
    private Integer groupId;
    @Size(max = 255)
    @Column(name = "GROUPCATEGORY")
    private String groupcategory;
    @Size(max = 255)
    @Column(name = "GROUPSUBCATEGORY")
    private String groupsubcategory;
    @OneToMany(mappedBy = "heritagegroupGroupId")
    private Collection<Heritage> heritageCollection;

    public Heritagegroup() {
    }

    public Heritagegroup(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupcategory() {
        return groupcategory;
    }

    public void setGroupcategory(String groupcategory) {
        this.groupcategory = groupcategory;
    }

    public String getGroupsubcategory() {
        return groupsubcategory;
    }

    public void setGroupsubcategory(String groupsubcategory) {
        this.groupsubcategory = groupsubcategory;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heritagegroup)) {
            return false;
        }
        Heritagegroup other = (Heritagegroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.heritage.Heritagegroup[ groupId=" + groupId + " ]";
    }
    
}
