/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;


import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.set;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;
import uk.ac.dundee.computing.aec.instagrim.stores.Profile;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(UUID picid,String username, String Password, String address, String firstName, String lastName, String email){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (userID,login,password,addresses,first_name,last_name,email) Values(?,?,?,?,?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        picid,username,EncodedPassword,address,firstName,lastName,email));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
    }
    
    public boolean updateProfile(String newUsername, String oldUN, String newFName,
                            String newLName, String newAdd, String nEmail)
    {
        
        UUID newID = null;
        Session session = cluster.connect("instagrim");
        Statement s00;
        s00 = QueryBuilder.select()
               .all()
               .from("instagrim","userprofiles");
        ResultSet rs = session.execute(s00);
        for(Row row : rs)
        {
            String dbUN = row.getString("login");
            newID = row.getUUID("userID");
            if(dbUN.equals(oldUN))   
            {
            Statement s01 = QueryBuilder.update("instagrim","userprofiles")
                        .with(set("login", newUsername))
                        .where(eq("userID",newID));
            session.execute(s01);
            Statement s02 = QueryBuilder.update("instagrim", "userprofiles")
                        .with(set("first_name", newFName))
                        .where(eq("userID", newID));
            session.execute(s02);
                Statement s03 = QueryBuilder.update("instagrim", "userprofiles")
                        .with(set("last_name", newLName))
                        .where(eq("userID", newID));
            session.execute(s03);    
                 Statement s04 = QueryBuilder.update("instagrim", "userprofiles")
                        .with(set("email", nEmail))
                        .where(eq("userID", newID));
            session.execute(s04);  
                  Statement s05 = QueryBuilder.update("instagrim","userprofiles")
                          .with(set("addresses",newAdd))
                          .where(eq("userID",newID));
            session.execute(s05);
                
            }
        }
        
        return true;
        
    }
        
    public Boolean getProfile(User user, Profile p)
    {
        Session session = cluster.connect("instagrim");
        Statement statement;
        statement = QueryBuilder.select()
                .all()
                .from("instagrim", "userprofiles");
        ResultSet rs = session.execute(statement);

        for (Row row : rs) {

            p.setFName(row.getString("first_name"));
            p.setLName(row.getString("last_name"));
            p.setEmail(row.getString("email"));
            p.setAddress(row.getString("addresses"));

        }
        return true;
    }
    
    
    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("Select * from userprofiles");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement // here you are binding the 'boundStatement'
                        );
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String userName = row.getString("login");
                if(userName.equals(username))
                {
                    String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
                }
               
            }
        }
   
    
    return false;  
    }
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    
}
