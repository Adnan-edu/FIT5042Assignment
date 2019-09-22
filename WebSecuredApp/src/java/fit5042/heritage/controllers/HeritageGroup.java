/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
/**
 *
 * @author Adnan
 */

@RequestScoped
@Named(value = "heritage_group")
public class HeritageGroup implements Serializable{
    private int groupId;
    private String groupCategory;
    private String groupSubCategory; 

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return "HeritageGroup{" + "groupId=" + groupId + ", groupCategory=" + groupCategory + ", groupSubCategory=" + groupSubCategory + '}';
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

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
    
    public HeritageGroup(){}

    public HeritageGroup(int groupId, String groupCategory, String groupSubCategory) {
        this.groupId = groupId;
        this.groupCategory = groupCategory;
        this.groupSubCategory = groupSubCategory;
    }
}
