/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author NSERW
 */
public class Profile {
    
    String fName = null;
    String lName = null;
    String address = null;
    String email = null;
    
    public Profile()
    {
    }
    
    public void setFName(String fName01)
    {
        this.fName = fName01;
    }
    
    public String getFName()
    {
        return fName;
    }
    
    public void setLName(String lName01)
    {
        this.lName = lName01;
    }
    
    public String getLName()
    {
        return lName;
    }
    
    public void setAddress(String address01)
    {
        this.address = address01;
    }
    
    public String getAddress()
    {
        return address;
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
