/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.HeritageGroup;
import fit5042.heritage.repository.entities.Heritage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;



import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;


/**
 *
 * @author Adnan
 */
@Named(value = "heritageGroupMB")
@ApplicationScoped
public class HeritageGroupMB {
    
    private ArrayList<HeritageGroup> heritageGroups;
    private String groupCategory;
    private String groupSubCategory;
    @ManagedProperty(value="#{hGRPManagedBean}") 
    HGRPManagedBean hGRPManagedBean;
    //Fot Heritage
    private ArrayList<Heritage> heritageList;
    //Searched heritage by user
    private ArrayList<Heritage> searchedHeritage;

    @ManagedProperty(value="#{heritageManagedBean}") 
    HeritageManagedBean heritageManagedBean;

    private ArrayList<fit5042.heritage.repository.entities.Architecturalstyle> architecturalstylesList;
    
    
    public HeritageGroupMB() throws Exception {
        heritageGroups = new ArrayList<>();
        heritageList = new ArrayList<>();
        searchedHeritage = new ArrayList<>();
        architecturalstylesList = new ArrayList<>(); 
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        hGRPManagedBean = (HGRPManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "hGRPManagedBean");
        //For HeritageManagedBean managed bean
        heritageManagedBean = (HeritageManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "heritageManagedBean");        
        this.showHeritageCategory();
        this.showHeritagesList();
        this.showArchitecturalstyles();
    }

    public ArrayList<Heritage> getSearchedHeritage() {
        return searchedHeritage;
    }

    public void setSearchedHeritage(ArrayList<Heritage> searchedHeritage) {
        this.searchedHeritage = searchedHeritage;
    }

    public ArrayList<fit5042.heritage.repository.entities.Architecturalstyle> getArchitecturalstylesList() {
        return architecturalstylesList;
    }

    public void setArchitecturalstylesList(ArrayList<fit5042.heritage.repository.entities.Architecturalstyle> architecturalstylesList) {
        this.architecturalstylesList = architecturalstylesList;
    }

    public ArrayList<Heritage> getHeritageList() {
        return heritageList;
    }

    public void setHeritageList(ArrayList<Heritage> heritageList) {
        this.heritageList = heritageList;
    }
    
    public ArrayList<HeritageGroup> getHeritageGroups() {
        return heritageGroups;
    }

    public void setHeritageGroups(ArrayList<HeritageGroup> heritageGroups) {
        this.heritageGroups = heritageGroups;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGroupSubCategory() {
        return groupSubCategory;
    }

    public void setGroupSubCategory(String groupSubCategory) {
        this.groupSubCategory = groupSubCategory;
    }
    
    public void showArchitecturalstyles()
    {
        if (architecturalstylesList != null && architecturalstylesList.size() > 0)
         {
         }       
         else
         {
            try {
                         
                architecturalstylesList.clear();
                for (fit5042.heritage.repository.entities.Architecturalstyle architecturalstyle : heritageManagedBean.getArchFromDatabase())
                {
                    architecturalstylesList.add(architecturalstyle);
                }                  
                setArchitecturalstylesList(architecturalstylesList); 
            } catch (Exception ex) {
                Logger.getLogger(fit5042.heritage.repository.entities.Architecturalstyle.class.getName()).log(Level.SEVERE, null, ex);

            }             
         }       
    }
    
    public void showHeritagesList()
    {
          if (heritageList != null && heritageList.size() > 0)
         {
            
         }       
         else
         {
            try {
                         
                heritageList.clear();
                for (Heritage heritage : heritageManagedBean.getListHeritagesList())
                {
                    heritageList.add(heritage);
                } 
                setHeritageList(heritageList);

            } catch (Exception ex) {
                //Logger.getLogger(HeritageGroup.class.getName()).log(Level.SEVERE, null, ex);

            }             
         }       
    }
    
    public void showHeritageCategory()
    {
         if (heritageGroups != null && heritageGroups.size() > 0)
         {
            
         }       
         else
         {
            try {
                //heritageGroups.clear();          
                heritageGroups.clear();
                for (HeritageGroup heritageGroup : hGRPManagedBean.getListHeritageCategory())
                {
                    heritageGroups.add(heritageGroup);
                } 
                setHeritageGroups(heritageGroups);

            } catch (Exception ex) {
                

            }             
         }
    }
    
    public void searchHGRPAll()
    {
        heritageGroups.clear();
        
        for (fit5042.heritage.repository.entities.HeritageGroup hg : hGRPManagedBean.getListHeritageCategory())
        {
            heritageGroups.add(hg);
        }
        
        setHeritageGroups(heritageGroups);        
    }
     public void searchArchStyleAll()
    {
        try
        {
            architecturalstylesList.clear();
            for (fit5042.heritage.repository.entities.Architecturalstyle architecturalstyle : heritageManagedBean.getArchFromDatabase())
            {
                architecturalstylesList.add(architecturalstyle);
            }                  
            setArchitecturalstylesList(architecturalstylesList);            
        }
        catch(Exception ex)
        {
            
        }
       
    }   
    public void searchHeritageFromDB(){
        try {
                         
                heritageList.clear();
                for (Heritage heritage : heritageManagedBean.getListHeritagesList())
                {
                    heritageList.add(heritage);
                } 
                setHeritageList(heritageList);

            } catch (Exception ex) {
                Logger.getLogger(HGRPManagedBean.class.getName()).log(Level.SEVERE, null, ex);

            }        
    }
    
    public void searchHeritageByBoth(int searchHeritageByGrpId, int searchHeriByArchId){
        searchedHeritage.clear();
        for (Heritage heritage : heritageManagedBean.searchHeriGrpArchId(searchHeritageByGrpId,searchHeriByArchId))
        {
            searchedHeritage.add(heritage);
        } 
        setSearchedHeritage(searchedHeritage);
    }
    
    public void updateSearchedHeritageList(){
        
    }
    
    public void clearSearch(){
        this.getSearchedHeritage().clear();
    }
     
}
