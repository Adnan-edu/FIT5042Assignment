/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;

import fit5042.heritage.mbeans.HeritageGroupMB;
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
@Named(value = "hGRPController")
@RequestScoped
public class HGRPController{
    private int groupId;  //this groupId is the index, don't confuse with the group Id
    private HeritageGroup heritageGroup;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public HGRPController()
    {
        groupId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("groupId"));
        heritageGroup = getHeritageGroup();
    }
    public HeritageGroup getHeritageGroup()
    {
        if(heritageGroup==null){
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            HeritageGroupMB app
                    = (HeritageGroupMB) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "heritageGroupMB");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getHeritageGroups().get(--groupId); //this propertyId is the index, don't confuse with the Property Id            
        }
        return heritageGroup;
    }
    
}
