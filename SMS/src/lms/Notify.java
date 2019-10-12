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
public class Notify {
    
    Sections s;
    Student s1;

    public Notify(Sections s, Student s1) {
        this.s = s;
        this.s1 = s1;
    }

    public Sections getSection() {
        return s;
    }

    
    
    public Student getStudent() {
        return s1;
    }
    
    
    
    
    
    
    
    
}
