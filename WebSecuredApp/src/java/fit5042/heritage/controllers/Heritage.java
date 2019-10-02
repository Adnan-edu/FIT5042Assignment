/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.repository.entities.Address;
import fit5042.heritage.repository.entities.Architecturalstyle;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Adnan
 */
@RequestScoped
@Named(value = "heritage")
public class Heritage {
    private int heritageId;
    private String authority;
    private Date dateOfConstructionFrom;
    private Date dateOfConstructionTo;
    private int heritageGroupId;
    Architecturalstyle architecturalstyle;
    private int archStyleId;
    private String periodName;
    private String periodFromTo;
    
    private Address address;
    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String city;    
    
    private Set<String> tags;
    
    private Set<fit5042.heritage.repository.entities.Heritage> heritages;
    
    public Heritage() {
        this.tags = new HashSet<>();
    }

    public Heritage(int heritageId, String authority, Date dateOfConstructionFrom, Date dateOfConstructionTo, int heritageGroupId, Architecturalstyle architecturalstyle, int archStyleId, String periodName, String periodFromTo, Address address, String streetNumber, String streetAddress, String suburb, String postcode, String city, Set<String> tags, Set<fit5042.heritage.repository.entities.Heritage> heritages) {
        this.heritageId = heritageId;
        this.authority = authority;
        this.dateOfConstructionFrom = dateOfConstructionFrom;
        this.dateOfConstructionTo = dateOfConstructionTo;
        this.architecturalstyle = architecturalstyle;
        this.archStyleId = archStyleId;
        this.heritageGroupId = heritageGroupId;
        this.periodName = periodName;
        this.periodFromTo = periodFromTo;
        this.address = address;
        this.streetNumber = streetNumber;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.city = city;
        this.tags = tags;
        this.heritages = heritages;
    }

    public int getHeritageId() {
        return heritageId;
    }

    public void setHeritageId(int heritageId) {
        this.heritageId = heritageId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getDateOfConstructionFrom() {
        return dateOfConstructionFrom;
    }

    public void setDateOfConstructionFrom(Date dateOfConstructionFrom) {
        this.dateOfConstructionFrom = dateOfConstructionFrom;
    }

    public Date getDateOfConstructionTo() {
        return dateOfConstructionTo;
    }

    public void setDateOfConstructionTo(Date dateOfConstructionTo) {
        this.dateOfConstructionTo = dateOfConstructionTo;
    }

    public Architecturalstyle getArchitecturalstyle() {
        return architecturalstyle;
    }

    public void setArchitecturalstyle(Architecturalstyle architecturalstyle) {
        this.architecturalstyle = architecturalstyle;
    }

    public int getArchStyleId() {
        return archStyleId;
    }

    public void setArchStyleId(int archStyleId) {
        this.archStyleId = archStyleId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getPeriodFromTo() {
        return periodFromTo;
    }

    public void setPeriodFromTo(String periodFromTo) {
        this.periodFromTo = periodFromTo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<fit5042.heritage.repository.entities.Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(Set<fit5042.heritage.repository.entities.Heritage> heritages) {
        this.heritages = heritages;
    }

    public int getHeritageGroupId() {
        return heritageGroupId;
    }

    public void setHeritageGroupId(int heritageGroupId) {
        this.heritageGroupId = heritageGroupId;
    }
    
    @Override
    public String toString() {
        return "Heritage{" + "heritageId=" + heritageId + ", authority=" + authority + ", dateOfConstructionFrom=" + dateOfConstructionFrom + ", dateOfConstructionTo=" + dateOfConstructionTo + ", architecturalstyle=" + architecturalstyle + ", archStyleId=" + archStyleId + ", periodName=" + periodName + ", periodFromTo=" + periodFromTo + ", address=" + address + ", streetNumber=" + streetNumber + ", streetAddress=" + streetAddress + ", suburb=" + suburb + ", postcode=" + postcode + ", city=" + city + ", tags=" + tags + ", heritages=" + heritages + '}';
    }

    
}
