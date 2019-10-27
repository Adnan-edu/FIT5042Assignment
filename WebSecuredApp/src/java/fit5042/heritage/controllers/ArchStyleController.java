/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.heritage.repository.entities.Architecturalstyle;
import fit5042.heritage.repository.entities.HeritageGroup;
import java.io.Serializable;
import javax.el.ELContext;

import javax.enterprise.context.RequestScoped;

import javax.faces.context.FacesContext;

import javax.inject.Named;
/**
 *
 * @author Adnan
 */
@Named(value = "archStyleController")
@RequestScoped
public class ArchStyleController {
    private int archStyleId;
    private Architecturalstyle architecturalstyle;

    public int getArchStyleId() {
        return archStyleId;
    }

    public void setArchStyleId(int archStyleId) {
        this.archStyleId = archStyleId;
    }
    
    public ArchStyleController()
    {
        archStyleId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("archStyleId"));
        
        architecturalstyle = this.getArchitecturalstyle();        
    }
    public Architecturalstyle getArchitecturalstyle()
    {
        if(architecturalstyle==null){
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            HeritageGroupMB app
                    = (HeritageGroupMB) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "heritageGroupMB");
           
            return app.getArchitecturalstylesList().get(--archStyleId);            
        }
        return architecturalstyle;
    }    
}
