/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.Address;
import fit5042.heritage.repository.entities.Architecturalstyle;
import fit5042.heritage.repository.entities.Heritage;
import fit5042.heritage.repository.entities.HeritageGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    
    public List<fit5042.heritage.repository.entities.Heritage> getListHeritagesList(){
        try {
                return heritageRepository.getAllHeritages();
            
        } catch (Exception ex) {
            Logger.getLogger(HeritageGroup.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        return null;
    }
    
    public List<fit5042.heritage.repository.entities.Architecturalstyle> getArchFromDatabase()
    {
        try {
                return heritageRepository.getAllArchitecturalstyle();
            
        } catch (Exception ex) {
        }        
        return null;        
    }

    public void addHeritage(fit5042.heritage.controllers.Heritage heritage){
        fit5042.heritage.repository.entities.Heritage convertedHeritage = this.convertHeritageToEntity(heritage);
        try {
            System.out.println("Inside HeritageManagedBean addHeritage");
            heritageRepository.addHeritage(convertedHeritage);
        } catch (Exception ex) {
            Logger.getLogger(HeritageManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

    private fit5042.heritage.repository.entities.Heritage convertHeritageToEntity(fit5042.heritage.controllers.Heritage newHeritage){
        fit5042.heritage.repository.entities.Heritage heritageEntity = new Heritage();

        String streetNumber = newHeritage.getStreetNumber();
        String streetAddress = newHeritage.getStreetAddress();
        String suburb = newHeritage.getSuburb();
        String postcode = newHeritage.getPostcode();
        String city = newHeritage.getCity();        
        Address address = new Address(streetNumber,streetAddress,suburb,postcode,city);
        heritageEntity.setAddress(address);
        //int archStyleId = newHeritage.getArchStyleId();
        String periodName = newHeritage.getPeriodName();
        String periodFromTo = newHeritage.getPeriodFromTo();
        fit5042.heritage.repository.entities.Architecturalstyle architecturalstyle = new Architecturalstyle();
        architecturalstyle.setPeriodName(periodName);
        architecturalstyle.setPeriodFromTo(periodFromTo);
        heritageEntity.setArchitecturalstyle(architecturalstyle);
        
        String authority = newHeritage.getAuthority();
        Date dateOfConstructionFrom = newHeritage.getDateOfConstructionFrom();
        Date dateOfConstructionTo = newHeritage.getDateOfConstructionTo();
        
        heritageEntity.setAuthority(authority);
        heritageEntity.setDateOfConstructionFrom(dateOfConstructionFrom);
        heritageEntity.setDateOfConstructionTo(dateOfConstructionTo);
        try {
            heritageEntity.setHeritageGroup(heritageRepository.getHeritageGroupById(newHeritage.getHeritageGroupId()));
        } catch (Exception ex) {
            Logger.getLogger(HeritageManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return heritageEntity;
    }
    public void editHeritage(Heritage heritageUpdated){
        try {
            heritageRepository.editHeritage(heritageUpdated);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(HeritageManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public void removeHeritage(int heritageId){
         try {
            heritageRepository.removeHeritage(heritageId);
        } catch (Exception ex) {
            Logger.getLogger(HeritageManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public List<Heritage> searchHeriGrpArchId(int searchHeritageByGrpId, int searchHeriByArchId){
         try {
            return heritageRepository.searchHeritageByBoth(searchHeritageByGrpId,searchHeriByArchId);
        } catch (Exception ex) {
           
            Logger.getLogger(HeritageManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;       
    }    
}
