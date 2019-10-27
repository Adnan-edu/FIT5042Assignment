/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HGRPManagedBean;
import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.restful.Architecturalstyle;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("removeArchStyle")
public class RemoveArchStyle {
    @ManagedProperty(value="#{hGRPManagedBean}") 
    HGRPManagedBean hGRPManagedBean;
    private Architecturalstyle architecturalstyle;
    HeritageGroupMB app;  

    public Architecturalstyle getArchitecturalstyle() {
        return architecturalstyle;
    }

    public void setArchitecturalstyle(Architecturalstyle architecturalstyle) {
        this.architecturalstyle = architecturalstyle;
    }
    
    public RemoveArchStyle()
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
    public void removeArchStyle(int archStyleId)
    {
       try
       {
            
            hGRPManagedBean.removeArchStyle(archStyleId);
            app.searchArchStyleAll();

       }
       catch (Exception ex)
       {
           
       }      
    }    
}
