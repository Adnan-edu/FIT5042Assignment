/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;
import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.heritage.mbeans.HeritageManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



/**
 *
 * @author Adnan
 */
@RequestScoped
@Named("addHeritage")
public class AddHeritage {
    @ManagedProperty(value="#{heritageManagedBean}") 
    HeritageManagedBean heritageManagedBean;
    
    private Heritage heritage;
    private HeritageGroupMB heritageApplication;

    public Heritage getHeritage() {
        return heritage;
    }

    public void setHeritage(Heritage heritage) {
        this.heritage = heritage;
    }
    public AddHeritage(){
         ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        heritageApplication  = (HeritageGroupMB) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "heritageGroupMB");
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        heritageManagedBean = (HeritageManagedBean ) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "heritageManagedBean");       
    }
    
    public void saveHeritage(Heritage heritageLocal){
       System.out.println(heritageLocal.toString());
       try
       {
           System.out.println("Inside BB AddHeritage saveHeritage");
            heritageManagedBean.addHeritage(heritageLocal);

            //refresh the list in PropertyApplication bean
            //app.searchAll();
            //updatePropertyListInPropertyApplicationBean();

            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property has been added succesfully"));
            //refresh the property list in propertyApplication bean
       }
       catch (Exception ex)
       {
           
       }      
    }
}
