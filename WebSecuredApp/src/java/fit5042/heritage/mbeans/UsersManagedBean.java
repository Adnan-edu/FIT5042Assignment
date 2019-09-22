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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Adnan
 */
@ManagedBean(name = "usersManagedBean")
@SessionScoped
public class UsersManagedBean implements Serializable{
    @EJB
    HeritageRepository heritageRepository;
    
    private String userName;
    private String empPass;
    private String empConfPass;
    private String userStatus;
    private String userLoginStatus="";

    public String getUserLoginStatus() {
        return userLoginStatus;
    }

    public void setUserLoginStatus(String userLoginStatus) {
        this.userLoginStatus = userLoginStatus;
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
            // Static getInstance method is called with hashing SHA  
            MessageDigest md = MessageDigest.getInstance("SHA-256");  

            // digest() method called  
            // to calculate message digest of an input  
            // and return array of byte 
            return md.digest(input.getBytes(StandardCharsets.UTF_8));  
        }
    public static String toHexString(byte[] hash) 
        { 
            // Convert byte array into signum representation  
            BigInteger number = new BigInteger(1, hash);  

            // Convert message digest into hex value  
            StringBuilder hexString = new StringBuilder(number.toString(16));  

            // Pad with leading zeros 
            while (hexString.length() < 32)  
            {  
                hexString.insert(0, '0');  
            }  

            return hexString.toString();  
        }
    public void userRegistration()
    {
        if(userStatus.equals("employee"))
        {
            
        }
        else
        {
        
        }
    }
    public void addEmployee()
    {
        if(this.getEmpPass().equals(this.getEmpConfPass()))
        {

             try {
                Users user = new Users();
                user.setUsername(this.getUserName());
                user.setPassword(this.getEmpPass());
                user.setUsertype("employee"); 
                heritageRepository.addUser(user);
            } catch (Exception ex) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
           
        }
    }
    public String submitMethod()
    {
        System.out.println("Method has called userLoginStatus : "+userLoginStatus);
        if(this.userLoginStatus.equals("admin"))
        {
            System.out.println("Inside Admin profile");
            return "admin/index.xhtm";
        }
        else if(this.userLoginStatus.equals("employee"))
        {
            return "employee/index.xhtm";
        }
        //return "customer/index.xhtm";
        System.out.println("At the end of the method");
        return "admin/index.xhtm";
    }
}
