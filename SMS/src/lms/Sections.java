/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author haad4
 */
public class Sections {
    
    Course course;
    int numOfSeatsFilled;
    int isOpen;
    Teacher Teacher;
    String section;
    ArrayList <Student> StudentList=new ArrayList<>();
    ArrayList <Attendance> AttendanceList=new ArrayList<>();
    ArrayList <Marks> CriteriaList=new ArrayList<>();
    ArrayList <Marksheet> MarksheetList=new ArrayList<>();

  
    private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
    
    
    
    
    public Sections(Course c, int numOfSeatsFilled, int isOpen, Teacher t, String section) {
        this.course = c;
        this.numOfSeatsFilled = numOfSeatsFilled;
        this.isOpen = isOpen;
        this.Teacher = t;
        this.section = section;
    }
    
 
 public ArrayList <Student> getStudentList()
    {
       return this.StudentList;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public void setNumOfSeatsFilled(int numOfSeatsFilled) {
        this.numOfSeatsFilled = numOfSeatsFilled;
    }

    
    public boolean removeStudent(Student s)
    {
        if(numOfSeatsFilled>0)
        {
            if(isOpen==1)
            {
            numOfSeatsFilled--;
            StudentList.remove(s);
            s.removeSection(this);
            System.out.println("here");
            }
           else
            {
                JOptionPane.showMessageDialog(null,"Registration period is closed");
                return false;
            }
        }
        else
        {
            System.out.println("not here");
            return false;
        }
        Connection conn=null;
         try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           
          
           String courseID=this.course.getCourseID();
           String studentID=s.id;
           System.out.println(courseID+studentID);
          
           String delete = "DELETE FROM dblink.studentsection WHERE UserID='"+studentID+"' AND courseID='"+courseID+"'";
           stmt.executeUpdate(delete);
           
          
       }
         
        catch(SQLException e)
       {
        System.out.println(e);
        return false;
       }
         return true;
    }

    public int getIsOpen() {
        return isOpen;
    }
    
    
    public boolean addStudent(Student s)
    {
        if(numOfSeatsFilled<60 && (isOpen==1))
        {
       StudentList.add(s);
       numOfSeatsFilled++;
       return true;
        }
        else{
        isOpen=0;
        return false;
        }
    }
    
    public boolean addCriteria2(Marks m)
    {
    boolean check=false;
        for(Marks crit : CriteriaList)
            { 
            
                if(crit.evalType==m.evalType&&crit.evalno==m.evalno){
                    check=true;
                   break;
                }
               
            }
        if(check){
            System.out.println("works");
        return false;
        }
        CriteriaList.add(m);
       return true;
    }
    
     public boolean addCriteria(Marks m)
    {
        boolean check=false;
        for(Marks crit : CriteriaList)
            { 
            
                if(crit.evalType==m.evalType&&crit.evalno==m.evalno){
                    check=true;
                   break;
                }
               
            }
        
        if(check){
           
        return false;
        
        }
        Connection conn=null;
         try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           
           String sectionID=this.getSection();
           String courseID=this.course.getCourseID();
           int evaltype=m.getEvalType();
           float weight=m.getEvalWeight() ;
           int evalno=m.getEvalno();
           String insert = "INSERT INTO dblink.evaluationcriteria(sectionID,courseID,evaltype,evalWeight,evalno) VALUES('"+sectionID+"','"+courseID+"','"+evaltype+"','"+weight+"','"+evalno+"')";
           stmt.executeUpdate(insert);
           
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        
       CriteriaList.add(m);
       return true;
    }

    public ArrayList<Marks> getCriteriaList() {
        return CriteriaList;
    }
    
    
       public boolean addAttendance(Attendance a){
       boolean check=false;
       String AttenDatea = new SimpleDateFormat("yyyy-MM-dd").format(a.getAttendance());
       String AttenDate2=null;
            for(Attendance att : AttendanceList)
            { 
                AttenDate2 = new SimpleDateFormat("yyyy-MM-dd").format(att.getAttendance());
                if(AttenDatea.equals(AttenDate2)){
                 check=true;
                 break;
                 
                }
               
            }
            
            if(check){
                
             return false;
            }
            Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           for(Student s: StudentList){
           String courseID=this.getCourse().courseID;
           String sectiona=this.getSection();
           String AttenDate = new SimpleDateFormat("yyyy-MM-dd").format(a.getAttendance());
           String userID=s.getUserId();
           String insert = "INSERT INTO dblink.attendance(courseID,section,AttenDate,userID) VALUES('"+courseID+"','"+sectiona +"','"+AttenDate+"','"+userID+"')";
           stmt.executeUpdate(insert);
           }
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
            
            AttendanceList.add(a);
           return true;
       }
 
public Student getStudent(int index){
        
       return StudentList.get(index);
    
    }
 
    
    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

 

    public Course getCourse() {
        return course;
    }

    public int getNumOfSeatsFilled() {
        return numOfSeatsFilled;
    }

  

    public Teacher getTeacher() {
        return Teacher;
    }

    public String getSection() {
        return section;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public ArrayList<Attendance> SearchStudentsSems(String studentID)
  {
      ArrayList<Attendance> L = new ArrayList<>();

      return L;
  }

    public ArrayList<Attendance> getAttendanceList(String userid){
    
        ArrayList<Attendance> A = new ArrayList<>();
        System.out.println(userid);
        System.out.println(this.section);
         String sql = "SELECT courseID,AttenDate,Attend FROM attendance WHERE userID='"+userid+"' AND section='"+this.section+"'";
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String courseID,Attendance;
             Date AttenDate=null;
             courseID=Attendance=null;
    
            // loop through the result set
            while (rs.next()) {
                
                                   courseID=rs.getString("courseID");
                                   AttenDate=rs.getDate("AttenDate");
                                   Attendance=rs.getString("Attend");
                                   System.out.println(courseID+AttenDate+Attendance);
                                  
                                   Attendance a=new Attendance(AttenDate,Attendance);
                                   A.add(a);
                                   }
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
        return A;
    }
    public void addMarksheet(Marksheet m){
        
        ArrayList<Marks> mlist2= m.getMarksList();
        MarksheetList.add(m);
        
    
    }

    public ArrayList<Marksheet> getMarksheetList() {
        return MarksheetList;
    }
    
    
}
