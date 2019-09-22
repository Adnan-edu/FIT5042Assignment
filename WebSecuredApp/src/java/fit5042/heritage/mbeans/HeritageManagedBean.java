/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.Address;
import fit5042.heritage.repository.entities.Architecturalstyle;
import fit5042.heritage.repository.entities.HeritageGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Adnan
 */
@ManagedBean(name = "heritageManagedBean")
@SessionScoped
public class HeritageManagedBean implements Serializable{
    @EJB
    HeritageRepository heritageRepository;
    private String authority;
    private Address address;
    
    private String city;
    private String postcode;
    private String streetAddress;

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
    private String streetNumber;
    private String suburb;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public HeritageManagedBean()
    {
        this.tags = new HashSet<>();
    }


    private Date dateOfConstructionFrom;
    private Date dateOfConstructionTo;

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

    public HashSet<String> getTags() {
        return tags;
    }

    public HeritageManagedBean(String authority, Address address, String city, String postcode, String streetAddress, String streetNumber, String suburb, Date dateOfConstructionFrom, Date dateOfConstructionTo, HashSet<String> tags, ArrayList<HeritageGroup> heritageGroup, ArrayList<Architecturalstyle> architecturalstyles) {
        this.authority = authority;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.dateOfConstructionFrom = dateOfConstructionFrom;
        this.dateOfConstructionTo = dateOfConstructionTo;
        this.tags = tags;
        this.heritageGroup = heritageGroup;
        this.architecturalstyles = architecturalstyles;
    }

    public ArrayList<HeritageGroup> getHeritageGroup() {
        return heritageGroup;
    }

    public void setHeritageGroup(ArrayList<HeritageGroup> heritageGroup) {
        this.heritageGroup = heritageGroup;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }
    public ArrayList<Architecturalstyle> getArchitecturalstyles() {
        return architecturalstyles;
    }

    public void setArchitecturalstyles(ArrayList<Architecturalstyle> architecturalstyles) {
        this.architecturalstyles = architecturalstyles;
    }
    private HashSet<String> tags;

    private ArrayList<HeritageGroup> heritageGroup;
    private ArrayList<Architecturalstyle> architecturalstyles;
    

}
