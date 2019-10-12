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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aneela Ahmed
 */
public class Attendance {
    private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
    
    ArrayList <Student> StudentList=new ArrayList<>();
    Date Attendance;
    String Attend;

    public Attendance(Date Attendance, String Attend) {
        this.Attendance = Attendance;
        this.Attend = Attend;
    }
    
    

    public Attendance() {
        this.Attendance = new Date();

    }

      public Attendance(Date d) {
        this.Attendance = d;

    }
    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public Date getAttendance() {
        return Attendance;
    }
    

    
     public boolean setAttendance(String Attendance2, String uID)
    {
       
                    Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String AttenDatea = new SimpleDateFormat("yyyy-MM-dd").format(this.getAttendance());
      
           String insert = "Update dblink.attendance Set Attend='"+Attendance2+"' WHERE userID='"+uID+"' AND AttenDate='"+AttenDatea+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
            return false;
       }
                    
                    return true;
                    
        }

    public String getAttend() {
        return Attend;
    }
    
     
    
    
    
    
}
