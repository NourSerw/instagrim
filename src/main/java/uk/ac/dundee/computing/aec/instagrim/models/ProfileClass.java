/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.models;

/**
 *
 * @author NSERW
 */
public class ProfileClass {
    
    String fName = null;
    String sName = null;
    String email = null;
    
    public void setFName(String fName01)
    {
            this.fName = fName01;
    }
    
    public String getFName()
    {
        return fName;
    }
    
    public void setSName(String sName01)
    {
        this.sName = sName01;
    }
    
    public String getSName()
    {
        return sName;
    }
    
    public void setEmail(String email01)
    {
        this.email = email01;
    }
    
    public String getEmail()
    {
        return email;
    }
}
