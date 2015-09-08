package com.attendancelist.login;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mia Gruvman
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private final DataQuery query = new DataQuery();

    public String loginControl() {
        if (query.loginControl(username, password)) {
            return "home.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel inmatning", "Användarnamn eller Lösenord stämmer inte. Försök igen."));
        return "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}