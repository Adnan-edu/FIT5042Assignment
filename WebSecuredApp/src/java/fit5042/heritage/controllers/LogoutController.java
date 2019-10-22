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
            ExternalContext context
                    = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) context.getSession(false);
           
            HttpServletResponse httpResponse = (HttpServletResponse) context.getResponse();
            httpResponse.setHeader("Cache-Control", "private,no-store,no-cache");
            session.invalidate();
            context.redirect("http://localhost:8080/WebSecuredApp/faces/index.xhtml");
        }catch(Exception e)
        {
            System.out.println("Exception happened during log out"+e.getMessage());
        }
        return "http://localhost:8080/WebSecuredApp/faces/index.xhtml?faces-redirect=true";
    }
    public String getHome(){
        return "/admin/index.xhtml";
    }
}
