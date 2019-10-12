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
public class Teacher extends User{
    
   public Teacher(int Age, String id, String username, String password) {
        super(Age,id,username,password);
    }

    public int getAge() {
        return Age;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
   
   
}
