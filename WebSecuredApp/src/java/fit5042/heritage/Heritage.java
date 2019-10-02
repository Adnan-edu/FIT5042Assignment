/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "HERITAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heritage.findAll", query = "SELECT h FROM Heritage h"),
    @NamedQuery(name = "Heritage.findByHeritageId", query = "SELECT h FROM Heritage h WHERE h.heritageId = :heritageId"),
    @NamedQuery(name = "Heritage.findByAuthority", query = "SELECT h FROM Heritage h WHERE h.authority = :authority"),
    @NamedQuery(name = "Heritage.findByDateofconstructionfrom", query = "SELECT h FROM Heritage h WHERE h.dateofconstructionfrom = :dateofconstructionfrom"),
    @NamedQuery(name = "Heritage.findByDateofconstructionto", query = "SELECT h FROM Heritage h WHERE h.dateofconstructionto = :dateofconstructionto"),
    @NamedQuery(name = "Heritage.findByCity", query = "SELECT h FROM Heritage h WHERE h.city = :city"),
    @NamedQuery(name = "Heritage.findByPostcode", query = "SELECT h FROM Heritage h WHERE h.postcode = :postcode"),
    @NamedQuery(name = "Heritage.findByStreetAddress", query = "SELECT h FROM Heritage h WHERE h.streetAddress = :streetAddress"),
    @NamedQuery(name = "Heritage.findByStreetNumber", query = "SELECT h FROM Heritage h WHERE h.streetNumber = :streetNumber"),
    @NamedQuery(name = "Heritage.findBySuburb", query = "SELECT h FROM Heritage h WHERE h.suburb = :suburb")})
public class Heritage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HERITAGE_ID")
    private Integer heritageId;
    @Size(max = 255)
    @Column(name = "AUTHORITY")
    private String authority;
    @Column(name = "DATEOFCONSTRUCTIONFROM")
    @Temporal(TemporalType.DATE)
    private Date dateofconstructionfrom;
    @Column(name = "DATEOFCONSTRUCTIONTO")
    @Temporal(TemporalType.DATE)
    private Date dateofconstructionto;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    @Size(max = 255)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 255)
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Size(max = 255)
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Size(max = 255)
    @Column(name = "SUBURB")
    private String suburb;
    @JoinColumn(name = "ARCHITECTURALSTYLE_ARCHSTYLE_ID", referencedColumnName = "ARCHSTYLE_ID")
    @ManyToOne
    private Architecturalstyle architecturalstyleArchstyleId;
    @JoinColumn(name = "HERITAGEGROUP_GROUP_ID", referencedColumnName = "GROUP_ID")
    @ManyToOne
    private Heritagegroup heritagegroupGroupId;

    public Heritage() {
    }

    public Heritage(Integer heritageId) {
        this.heritageId = heritageId;
    }

    public Integer getHeritageId() {
        return heritageId;
    }

    public void setHeritageId(Integer heritageId) {
        this.heritageId = heritageId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getDateofconstructionfrom() {
        return dateofconstructionfrom;
    }

    public void setDateofconstructionfrom(Date dateofconstructionfrom) {
        this.dateofconstructionfrom = dateofconstructionfrom;
    }

    public Date getDateofconstructionto() {
        return dateofconstructionto;
    }

    public void setDateofconstructionto(Date dateofconstructionto) {
        this.dateofconstructionto = dateofconstructionto;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Architecturalstyle getArchitecturalstyleArchstyleId() {
        return architecturalstyleArchstyleId;
    }

    public void setArchitecturalstyleArchstyleId(Architecturalstyle architecturalstyleArchstyleId) {
        this.architecturalstyleArchstyleId = architecturalstyleArchstyleId;
    }

    public Heritagegroup getHeritagegroupGroupId() {
        return heritagegroupGroupId;
    }

    public void setHeritagegroupGroupId(Heritagegroup heritagegroupGroupId) {
        this.heritagegroupGroupId = heritagegroupGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heritageId != null ? heritageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heritage)) {
            return false;
        }
        Heritage other = (Heritage) object;
        if ((this.heritageId == null && other.heritageId != null) || (this.heritageId != null && !this.heritageId.equals(other.heritageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.heritage.Heritage[ heritageId=" + heritageId + " ]";
    }
    
}
