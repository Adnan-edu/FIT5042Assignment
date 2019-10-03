/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.heritage.mbeans.HeritageManagedBean;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("removeHeritage")
public class RemoveHeritage {
    @ManagedProperty(value="#{heritageManagedBean}") 
    HeritageManagedBean heritageManagedBean;

    private Heritage heritageRemove;
    HeritageGroupMB heritageApplication;
    
    public RemoveHeritage(){
       ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        heritageApplication = (HeritageGroupMB) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "heritageGroupMB");
        
        heritageApplication.showHeritagesList();
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        heritageManagedBean = (HeritageManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "heritageManagedBean");    
    }

    public Heritage getHeritageRemove() {
        return heritageRemove;
    }

    public void setHeritageRemove(Heritage heritageRemove) {
        this.heritageRemove = heritageRemove;
    }
    public void removeHeritage(int heritageId) {
       try
       {
            //remove this property from db via EJB
            heritageManagedBean.removeHeritage(heritageId);

            //refresh the list in PropertyApplication bean
            heritageApplication.searchHeritageFromDB();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage has been deleted succesfully"));     
       }
       catch (Exception ex)
       {
           
       }
    }    
}
