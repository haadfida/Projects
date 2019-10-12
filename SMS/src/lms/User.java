/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author Aneela Ahmed
 */
public class User {
    
    public int Age;
    public String id,username, password;

    public User(int Age, String id, String username, String password) {
        this.Age = Age;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUserId()
    {
        return id;
    }
    
    public String getUserName()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    
}
