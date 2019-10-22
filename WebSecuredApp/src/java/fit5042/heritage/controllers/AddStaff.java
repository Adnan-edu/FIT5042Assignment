/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;
import fit5042.heritage.mbeans.HeritageGroupMB;
import fit5042.heritage.mbeans.HeritageManagedBean;
import fit5042.heritage.mbeans.UsersManagedBean;
import fit5042.heritage.repository.entities.Users;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named("addStaff")
public class AddStaff {
    @ManagedProperty(value="#{usersManagedBean}") 
    UsersManagedBean usersManagedBean;
    private String userName;
    private String empPass;
    private String empConfPass;
    private String userStatus;
    private String staffAddStatus="";
    
    public AddStaff()
    {
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "usersManagedBean");  
        staffAddStatus = "";
            
    }

    public String getStaffAddStatus() {
        return staffAddStatus;
    }

    public void setStaffAddStatus(String staffAddStatus) {
        this.staffAddStatus = staffAddStatus;
    }
    
    public void setUserStatus(String userStatus)
    {
        this.userStatus = userStatus;
    }
    public String getUserStatus()
    {
        return userStatus;
    }        
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setEmpPass(String empPass)
    {
        try
        {
            this.empPass =  this.toHexString(this.getSHA(empPass));        
        }
        catch (NoSuchAlgorithmException e) 
        {  
            
        }         
    }
    public String getEmpPass()
    {
        return empPass;
    }    
    public void setEmpConfPass(String empConfPass)
    {
        try
        {
            this.empConfPass =  this.toHexString(this.getSHA(empConfPass));        
        }
        catch (NoSuchAlgorithmException e) 
        {  
            
        }        
        
    }
    public String getEmpConfPass()
    {
        return empConfPass;
    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
        {   
            MessageDigest md = MessageDigest.getInstance("SHA-256");  
            return md.digest(input.getBytes(StandardCharsets.UTF_8));  
        }
    public static String toHexString(byte[] hash) 
        {  
            BigInteger number = new BigInteger(1, hash);  
            StringBuilder hexString = new StringBuilder(number.toString(16));   
            while (hexString.length() < 32)  
            {  
                hexString.insert(0, '0');  
            }  
            return hexString.toString();  
        }
    public void addEmployee()
    {
        String regexEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!this.getUserName().matches(regexEmail))
        {
            staffAddStatus = "Please provide a valid email address.";
            return;
        }
        else
        {
            staffAddStatus = "";
        }
        if(this.getEmpPass().equals(this.getEmpConfPass()))
        {
            staffAddStatus="";
           try {
                Users user = new Users();
                user.setUsername(this.getUserName());
                user.setPassword(this.getEmpPass());
                user.setUsertype("employee"); 
                if(usersManagedBean.addStaff(user)){
                    staffAddStatus = "Staff has been added successfully.";
                }
                
            } catch (Exception ex) {
                staffAddStatus = "";
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
           staffAddStatus = "Password and confirm password is not same";
        }
    }    
}
