package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.HeritageGroup;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adnan
 */
@ManagedBean(name = "hGRPManagedBean")
@SessionScoped
public class HGRPManagedBean implements Serializable{
    @EJB
    HeritageRepository heritageRepository;

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
    
    private String groupCategory;
    private String groupSubCategory;
    
    public List<HeritageGroup> getListHeritageCategory()
    {
        try {
                return heritageRepository.getAllHeritageGroups();
            
        } catch (Exception ex) {
            Logger.getLogger(HeritageGroup.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }

    public void editHeritageGroup(HeritageGroup heritageGroup){
        try {
            heritageRepository.editHeritageGroup(heritageGroup);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage group has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(HGRPManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void addHeritageCategory(fit5042.heritage.controllers.HeritageGroup localHeritageGroup)
    {
            HeritageGroup heritageGroupNew = convertHGToEntity(localHeritageGroup);
       
            try {
                //System.out.println("Inside local heritage 3");
                heritageRepository.addHeritageGroup(heritageGroupNew);
            } catch (Exception ex) {
                Logger.getLogger(HGRPManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }            
        
    }

    
    public HeritageGroup convertHGToEntity(fit5042.heritage.controllers.HeritageGroup localHeritageGroup){
        //System.out.println("Inside local heritage 2 ");
        HeritageGroup heritageGroupNew = new HeritageGroup();
        String hrg = localHeritageGroup.getGroupCategory();
        //System.out.println("Inside local heritage 99 "+hrg);
        String hrgs = localHeritageGroup.getGroupSubCategory();
       // System.out.println("Inside local heritage 5-> "+hrg);
        heritageGroupNew.setGroupCategory(hrg);
        heritageGroupNew.setGroupSubCategory(hrgs);
        return heritageGroupNew;
    }
    
    public void removeHeritageGroup(int groupId)
    {
         try {
            heritageRepository.removeHeritageGroup(groupId);
        } catch (Exception ex) {
            Logger.getLogger(HGRPManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
      
}
