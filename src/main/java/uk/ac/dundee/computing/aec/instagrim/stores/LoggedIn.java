/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    String ppID = null;
    java.util.UUID userID = null;
    
    public void LogedIn(){
        
    }
    
    
    public String getUUID()
    {
        return userID.toString();
    }
    
    public void setUUID(UUID userID)
    {
        this.userID = userID;
    }
    
    public String getProfPic()
    {
        return ppID;
    }
    
    public void setProfPic(String ppID)
    {
        this.ppID = ppID;
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}
