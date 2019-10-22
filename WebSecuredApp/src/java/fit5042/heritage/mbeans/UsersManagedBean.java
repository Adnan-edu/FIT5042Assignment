/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.mbeans;

import fit5042.heritage.repository.HeritageRepository;
import fit5042.heritage.repository.entities.Users;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adnan
 */
@ManagedBean(name = "usersManagedBean")
@SessionScoped
public class UsersManagedBean implements Serializable{
    @EJB
    HeritageRepository heritageRepository;
    

    private String userLoginStatus="";
    public String getUserLoginStatus() {
        return userLoginStatus;
    }

    public void setUserLoginStatus(String userLoginStatus) {
        this.userLoginStatus = userLoginStatus;
    }


    public String submitMethod()
    {
        if(this.userLoginStatus.equals("admin"))
        {
            return "admin/index.xhtm";
        }
        else if(this.userLoginStatus.equals("employee"))
        {
            return "employee/index.xhtm";
        }
        return "admin/index.xhtm";
    }
    public boolean addStaff(Users user)
    {
        try{
            heritageRepository.addUser(user);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
