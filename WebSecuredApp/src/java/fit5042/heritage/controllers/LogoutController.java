/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.controllers;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Adnan
 */
@Named(value = "logoutController")
@RequestScoped
public class LogoutController {
    public LogoutController(){
    
    }
    public String logoutNow()
    {
        try
        {
            ExternalContext contextForSession = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession heritageSession = (HttpSession) contextForSession.getSession(false);
            HttpServletResponse httpResponse = (HttpServletResponse) contextForSession.getResponse();
            httpResponse.setHeader("Cache-Control", "private,no-store,no-cache");
            heritageSession.invalidate();
            contextForSession.redirect("http://localhost:8080/WebSecuredApp/faces/index.xhtml");
        }catch(Exception e)
        {}
        return "http://localhost:8080/WebSecuredApp/faces/index.xhtml?faces-redirect=true";
    }
    public String getHome(){
        return "/faces/admin/index.xhtml";
    }
    //This method returns the logged in user email at the top left corner in the nav 
    public String getLoggedInUser()
    {
        return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    }     
}
