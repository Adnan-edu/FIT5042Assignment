/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HeritageGroupMB;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("searchHeritage")
public class SearchHeritage {
    private Heritage heritage;
    private HeritageGroup heritageGroup;
    HeritageGroupMB heritageApplication;
    private int searchHeritageByGrpId;
    private int searchHeriByArchId;
    
    public SearchHeritage(){
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        heritageApplication = (HeritageGroupMB) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "heritageGroupMB");
        
        //heritageApplication.updateSearchedHeritageList();    
    }

    public Heritage getHeritage() {
        return heritage;
    }

    public void setHeritage(Heritage heritage) {
        this.heritage = heritage;
    }

    public HeritageGroup getHeritageGroup() {
        return heritageGroup;
    }

    public void setHeritageGroup(HeritageGroup heritageGroup) {
        this.heritageGroup = heritageGroup;
    }

    public HeritageGroupMB getHeritageApplication() {
        return heritageApplication;
    }

    public void setHeritageApplication(HeritageGroupMB heritageApplication) {
        this.heritageApplication = heritageApplication;
    }

    public int getSearchHeritageByGrpId() {
        return searchHeritageByGrpId;
    }

    public void setSearchHeritageByGrpId(int searchHeritageByGrpId) {
        this.searchHeritageByGrpId = searchHeritageByGrpId;
    }

    public int getSearchHeriByArchId() {
        return searchHeriByArchId;
    }

    public void setSearchHeriByArchId(int searchHeriByArchId) {
        this.searchHeriByArchId = searchHeriByArchId;
    }
    
    public void searchByGrpAndArch(int searchHeritageByGrpId,int searchHeriByArchId){
        try
       {
            heritageApplication.searchHeritageByBoth(searchHeritageByGrpId,searchHeriByArchId);
       }
       catch (Exception ex)
       {
       }   
    }
    public void searchByGroup(int searchHeritageByGrpId){
    
    }
    public void searchByArchStyleId(int searchHeriByArchId){
    
    }
}
