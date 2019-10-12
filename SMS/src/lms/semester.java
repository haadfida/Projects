/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author haad4
 */
public class semester {
        
       Student s;
       float sgpa;
       int semID; //1-8

    public semester(Student s, float sgpa ,int semID) {
        this.s = s;
        this.sgpa = sgpa;
        this.semID = semID;
    }

    public Student getS() {
        return s;
    }

    public float getSgpa() {
        return sgpa;
    }

    public int getSemID() {
        return semID;
    }
       
        
    
}

