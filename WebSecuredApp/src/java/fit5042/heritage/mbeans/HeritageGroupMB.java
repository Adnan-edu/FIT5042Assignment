/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.HeritageGroup;
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
     
    public HeritageGroupMB() throws Exception {
        heritageGroups = new ArrayList<>();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        hGRPManagedBean = (HGRPManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "hGRPManagedBean");        
        this.showHeritageCategory();
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
                Logger.getLogger(HeritageGroup.class.getName()).log(Level.SEVERE, null, ex);

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
    
    
    
}
