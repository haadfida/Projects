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
public class semdata {
        
      
       int semID; //1-8
       String CourseName;
       String Grade;
       private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";

    public semdata(int semID, String CourseName, String Grade) {
        this.semID = semID;
        this.CourseName = CourseName;
        this.Grade = Grade;
    }

  
    public int getSemID() {
        return semID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getGrade() {
        return Grade;
    }

 

    public void setSemID(int semID) {
        this.semID = semID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
    
     
    
}

