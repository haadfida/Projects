/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author haad4
 */
public class Marksheet {
    
    Sections section;
    Student student;
    ArrayList <Marks> marksList=new ArrayList<>();
    String grade;
     private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";

    public Marksheet(Sections section, Student student) {
        this.section = section;
        this.student = student;
        
    }

    public void setMarksList(ArrayList<Marks> marksList) {
        this.marksList = marksList;
    }

    public Sections getSection() {
        return section;
    }

    public Student getStudent() {
        return student;
    }

    public String getGrade() {
        return grade;
    }
    
    
     public void setGrade2(String grade) {
         this.grade = grade;
     }
    public void setGrade(String grade) {
        
       
                      Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected to set grade");
           Statement stmt= (Statement) conn.createStatement();
           String studentid=this.student.id;
           String courseID=this.section.course.courseID;
           String sectionID=this.section.getSection();
            System.out.println(studentid+courseID+sectionID+grade);
           String insert = "Update dblink.studentevaluations Set grade='"+grade+"' WHERE studentid='"+studentid+"' AND courseID='"+courseID+"' AND sectionID='"+sectionID+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
         this.grade = grade;
    }
    public void addMarks(Marks m)
    {
        marksList.add(m);
    }
    
   public  float calcTotal(ArrayList<Marks> marksList)
    {
        float total=0;
    
        for(Marks m : marksList)
        {
            total= total+((m.getMarks()/100)*m.getEvalWeight());
        }
        return total;
    }

    public void setSection(Sections section) {
        this.section = section;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Marks> getMarksList() {
        return marksList;
    }

 

   

}
