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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adnan
 */
@Entity
@NamedQueries({@NamedQuery(name = HeritageGroup.GET_ALL_QUERY_NAME, query = "SELECT c FROM HeritageGroup c order by c.groupId asc")})
@XmlRootElement
public class HeritageGroup implements Serializable{
    public static final String GET_ALL_QUERY_NAME = "Group.getAll";
    private int groupId;
    private String groupCategory;
    private String groupSubCategory;
    private Set<Heritage> heritages;

    public HeritageGroup() {
    }
    
    public HeritageGroup(int groupId, String groupCategory, String groupSubCategory)
    {
        this.groupId = groupId;
        this.groupCategory = groupCategory;
        this.groupSubCategory = groupSubCategory;
        this.heritages = new HashSet<>();
    }
    @Id
    @GeneratedValue
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupCategory()
    {
        return groupCategory;
    }
    public void setGroupCategory(String groupCategory)
    {
        this.groupCategory = groupCategory;
    }
    public String getGroupSubCategory()
    {
        return groupSubCategory;
    }
    public void setGroupSubCategory(String groupSubCategory)
    {
        this.groupSubCategory = groupSubCategory;
    }
    @OneToMany(mappedBy = "heritageGroup")
    public Set<Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(Set<Heritage> heritages) {
        this.heritages = heritages;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.groupId;
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
        final HeritageGroup other = (HeritageGroup) obj;
        if (this.groupId != other.groupId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.groupId + " - " + groupCategory + " - " + groupSubCategory;
    }
        
}
