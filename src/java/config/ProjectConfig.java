/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/Servaxo",
        callerQuery = "select password from usermaster where username=?",
        groupsQuery = "select groupmaster.group_name from groupmaster JOIN usermaster ON groupmaster.group_id = usermaster.group_id where usermaster.username=?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/admin/loginAdmin.jsf",
                errorPage = ""
        )
)

@FacesConfig
@Named(value = "projectConfig")
@ApplicationScoped
public class ProjectConfig {

    /**
     * Creates a new instance of ProjectConfig
     */
    public ProjectConfig() {
    }
    
}
