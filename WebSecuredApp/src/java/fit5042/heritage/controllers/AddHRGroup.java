/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;
import fit5042.heritage.mbeans.HGRPManagedBean;
import fit5042.heritage.mbeans.HeritageGroupMB;
import javax.faces.bean.ManagedProperty;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("addHRGroup")
public class AddHRGroup {
    @ManagedProperty(value="#{hGRPManagedBean}") 
    HGRPManagedBean hGRPManagedBean;
    
    private HeritageGroup heritageGroup;
    
    private boolean showForm = true;
    
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
    
    public AddHRGroup()
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
    
    public void addHeritageRGroup(HeritageGroup localHeritageGroup)
    {
        try
       {
            //add this property to db via EJB
           hGRPManagedBean.addHeritageCategory(localHeritageGroup);

            //refresh the list in PropertyApplication bean
            app.searchHGRPAll();
           
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage group has been added succesfully"));
            //refresh the property list in propertyApplication bean
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;       
    }
}
