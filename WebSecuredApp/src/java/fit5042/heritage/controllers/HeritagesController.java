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
@Named(value = "heritagesController")
@RequestScoped
public class HeritagesController {
    private int heritageId;
    private fit5042.heritage.repository.entities.Heritage heritage;
    public HeritagesController(){
         heritageId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("heritageId"));
        //System.out.println("The status of my id is: "+heritageId);
        heritage = getHeritage();
    }
    
    public fit5042.heritage.repository.entities.Heritage getHeritage(){
        if(heritage==null){
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            HeritageGroupMB app
                    = (HeritageGroupMB) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "heritageGroupMB");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getHeritageList().get(--heritageId); //this propertyId is the index, don't confuse with the Property Id            
        }
        return heritage;
    } 

    public int getHeritageId() {
        return heritageId;
    }

    public void setHeritageId(int heritageId) {
        this.heritageId = heritageId;
    }
    
}