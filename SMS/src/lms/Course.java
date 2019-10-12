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
public class Course {
    
    String courseID;
    String name;

    public Course(String courseID, String name) {
        this.courseID = courseID;
        this.name = name;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }
    
    
    
}
