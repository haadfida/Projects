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
import javax.swing.JOptionPane;

/**
 *
 * @author Aneela Ahmed
 */
public class Student extends User{
   
    private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
  ArrayList <Sections> SectionList= new ArrayList<>();
 public Student(int Age, String id, String username, String password) {
        super(Age,id,username,password);
    }

    public ArrayList<Sections> getSectionList() {
        return SectionList;
    }
    public void addSection2(Sections sec){
     SectionList.add(sec);
    
    }
    
     public void removeSection(Sections sec){
     SectionList.remove(sec);
    
    }
    public boolean addSection(Sections sec,String userID, int isOpen){
        boolean check=false;
       String sectionid = sec.section;
            for(Sections s : SectionList)
            { 
               
                if(s.section.equals(sectionid)){
                 check=true;
                 break;
                 
                }
               
            }
            
            if(isOpen==0 ){
             return false;
            }
            if(check ){
             return false;
            }
            
             Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
     
           String courseID=sec.getCourse().courseID;
           String sectiona=sec.section;
           String userName=this.getUserName();
     
           String insert = "INSERT INTO dblink.studentsection(courseID,section,userName,UserID) VALUES('"+courseID+"','"+sectiona +"','"+userName+"','"+userID+"')";
           stmt.executeUpdate(insert);
           
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        SectionList.add(sec);
        return true;
    }

    public String getId() {
        return id;
    }

    public static String getUsername() {
        return username;
    }
}
