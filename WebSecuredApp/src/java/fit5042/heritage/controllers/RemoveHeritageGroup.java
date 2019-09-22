/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HGRPManagedBean;
import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.heritage.mbeans.HeritageManagedBean;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("removeHeritageGroup")
public class RemoveHeritageGroup {
    @ManagedProperty(value="#{hGRPManagedBean}") 
    HGRPManagedBean hGRPManagedBean;
    private boolean showForm = true;
    private HeritageGroup heritageGroup;
    HeritageGroupMB app;

    public boolean isShowForm() {
        return showForm;
    }    

    public HeritageGroup getHeritageGroup() {
        return heritageGroup;
    }

    public void setHeritageGroup(HeritageGroup heritageGroup) {
        this.heritageGroup = heritageGroup;
    }

    public RemoveHeritageGroup()
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (HeritageGroupMB) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "heritageGroupMB");
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        hGRPManagedBean = (HGRPManagedBean ) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "hGRPManagedBean");         
    }
    
    public void removeHerGrp(int groupId)
    {
       try
       {
            //remove this property from db via EJB
            hGRPManagedBean.removeHeritageGroup(groupId);

            //refresh the list in PropertyApplication bean
            app.searchHGRPAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage group id "+groupId+" has been deleted succesfully."));     
       }
       catch (Exception ex)
       {
           
       }
       showForm = true;        
    }
}
