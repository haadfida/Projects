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
import java.util.Collections;
/**
 *
 * @author Aneela Ahmed
 */
public class LMS {
    ArrayList <User> UserList= new ArrayList<>();
    ArrayList <Course> CourseList= new ArrayList<>();
    ArrayList <Sections> SectionList= new ArrayList<>();
    ArrayList <Notify> NotifyList= new ArrayList<>();
    ArrayList <Marksheet> MarksheetList= new ArrayList<>();
    ArrayList <semester> SemList= new ArrayList<>();
    private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
    
     public LMS()    //Done
    {
        CourseList = new ArrayList<>();
        UserList = new ArrayList<>();
        SectionList= new ArrayList<>();
    }

public void loadStudents(Student s){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(s);
    }

public void loadTeachers(Teacher t){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(t);
    }

public void loadMarksheet(Marksheet m){
                 if(MarksheetList==null)
        {
                MarksheetList =  new ArrayList<>(); 
        }
           String courseID=m.section.course.courseID;
           String studentid=m.student.id;
           String sectionID=m.section.section;
           String teachername=m.section.Teacher.username;
            String grade=m.grade;
          ArrayList <Marks> MarkList =m.getMarksList();
           for (Marks s: MarkList)
            {
                Connection conn=null;
         try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           
           int evaltype=s.evalType;
           float evalmarks=s.obtainedmarks;
           int evalno=s.evalno;
           String insert = "INSERT INTO dblink.studentevaluations(courseID,studentid,sectionID,teachername,evaltype,evalno,evalmarks,grade)"
                   + " VALUES('"+courseID+"','"+studentid+"','"+sectionID+"','"+teachername+"',"+evaltype+","+evalno+","+evalmarks+",'"+grade+"')";
           stmt.executeUpdate(insert);
           
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        
            }
        MarksheetList.add(m);
    }

public void loadAdmins(Admin a){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(a);
    }

 public String DisplayName(String id){
        
         for (User x: UserList)
        {
            if (x.getUserId().contains(id))
            {
                return x.getUserId();
            }
           
        }
         return null;
    }
     
 
 public boolean checkStudentLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(User tempU : UserList)
            {
                if(tempU instanceof Student){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                  
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }
 
 public boolean checkTeacherLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(User tempU : UserList)
            {
                if(tempU instanceof Teacher){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                  
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }
 
 public boolean checkAdminLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(User tempU : UserList)
            {
                if(tempU instanceof Admin){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                    System.out.println(curItem+curItem2);
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }

    public ArrayList<Sections> getSectionList() {
        return SectionList;
    }
    
   
public void loadCourses(Course c){
                 if(CourseList==null)
        {
                CourseList =  new ArrayList<>(); 
        }
             
        CourseList.add(c);
    }




public void loadSection(Sections s){
                 if(SectionList==null)
        {
                SectionList =  new ArrayList<>(); 
        }
        System.out.println(s.getCourse().getCourseID());
        SectionList.add(s);
    }
   public Course getCourseObject(String search)//Done
    {
        Course temp=null;
        
        for (Course c: CourseList)
        {
            
            if (c.getCourseID().equals(search))
            {
                temp=c;
            }
           
        }

        return temp;
    }
   

    
  public Teacher getTeacherObject(String s)  //Done
    {
        Teacher temp = null;
        
        for (User u: UserList)
        {
            if (u instanceof Teacher)
            {
                Teacher t = (Teacher) u;
                if (t.getUserName().equals(s))
                {
                    temp=t;
                }
            }
        }
        return temp;
    }
  
   public boolean OpenRegistrations(int isOpen)
    {
        System.out.println(isOpen);
         for (Sections x: SectionList)
        {
                    System.out.println(x.section);
                    
                    x.setIsOpen(isOpen);
                     System.out.println(x.getIsOpen());
                    Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String insert = "Update dblink.sections Set isOpen="+isOpen+"";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
            return false;
       }
                    
                  
                    
        }
    
         return true;
    }
   
   public Student getStudentObject(String s)  //Done
    {
        Student temp = null;
        
        for (User u: UserList)
        {
            if (u instanceof Student)
            {
                Student stu = (Student) u;
                if (stu.getUserId().equals(s))
                {
                    temp=stu;
                }
            }
        }
        return temp;
    }
   
   public void addSem(semester s){
   
       SemList.add(s);
   }
   public ArrayList<semester> SearchStudentsSems(String studentID)
  {
      ArrayList<semester> L = new ArrayList<>();
      for (semester s: SemList)
      {
          if (s.s.id.equals(studentID))
          {
              L.add(s);
          }
      }
      return L;
  }
   
   public Sections getSectionObject(String s)  //Done
    {
        Sections temp = null;
        
        for (Sections sec: SectionList)
        {
            
               
                if (sec.getSection().equals(s))
                {
                    temp=sec;
                }
            
        }
        return temp;
    }
   public void addStudentSubscription(Notify n){
    NotifyList.add(n);
   }  
    

 public void removeStudentSubscription(Notify n){
     if(NotifyList.isEmpty()==false)
      NotifyList.remove(n);
   }     
public boolean scanNotifyList(Student s)
{
    for(Notify  n : NotifyList)
    {
        if(n.getStudent().equals(s))  
        {
            if(n.getSection().getNumOfSeatsFilled()<60 )
             JOptionPane.showMessageDialog(null,n.getSection()+"has available seats");
            return true;
        }
        
    }
    return false;
}

public boolean scanNotifyList2(Student s,Sections sec)
{
    for(Notify  n : NotifyList)
    {
        if(n.getStudent().equals(s) && n.getSection().equals(sec))  
        {
            NotifyList.remove(n);
            return true;
        }
        
    }
    return false;
}
public ArrayList<Sections> searchTeacher(String search)//Done
    {
        
        ArrayList <Sections> sectionslist2 = new ArrayList<>();
       
        
        for (Sections x: SectionList)
        {
            if(x.Teacher.id.equals(search))
            {
                sectionslist2.add(x);
            }
          
           
        }
        return sectionslist2;
        
       
    }


public Sections findSection(String Search,String Search2)
{
    Sections temp=null;
    for (Sections c : SectionList)
        if( c.getCourse().getCourseID().equals(Search) && c.getSection().equals(Search2)){
            temp=c;
        }
            return temp;
}
        
public void selectAttendance(Sections s){
         String sectionID=s.getSection();
         String courseIDa=s.getCourse().getCourseID();
        String sql = "SELECT courseID,section,AttenDate,Attend,userID FROM attendance WHERE section='"+sectionID+"' AND courseID='"+courseIDa+"'";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String courseID,section,userID,Attendance;
             Date AttenDate=null;
             courseID=section=userID=Attendance=null;
    
            // loop through the result set
            while (rs.next()) {
                
                                   courseID=rs.getString("courseID");
                                   section=rs.getString("section");
                                   AttenDate=rs.getDate("AttenDate");
                                   Attendance=rs.getString("Attendance");
                                   userID=rs.getString("userID");
                                  
                                   Attendance a=new Attendance(AttenDate);
                                   a.setStudentList(this.selectStudentAttendance(a,s));
                                   s.addAttendance(a);
                                   }
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
        
        
    }

public void selectCriteria2(Sections s){
         String sectionIDa=s.getSection();
         String courseIDa=s.getCourse().getCourseID();
        String sql = "SELECT sectionID,courseID,evaltype,evalWeight,evalno FROM evaluationcriteria WHERE sectionID='"+sectionIDa+"' AND courseID='"+courseIDa+"'";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String sectionID,courseID;
             int evaltype;
             float evalWeight;
             int evalno;
             evaltype=evalno=0;
             evalWeight=0;
             courseID=sectionID=null;
    
            // loop through the result set
            while (rs.next()) {
                                   sectionID=rs.getString("sectionID");
                                   courseID=rs.getString("courseID");
                                   evaltype=rs.getInt("evaltype");
                                   evalWeight=rs.getFloat("evalWeight");
                                   evalno=rs.getInt("evalno");
                                   
                                    Marks m=new Marks(evaltype,evalno,evalWeight,0);
                                    s.addCriteria2(m);
       
                                   
                                   }
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
    }


public void selectCriteria(Sections s){
         String sectionIDa=s.getSection();
         String courseIDa=s.getCourse().getCourseID();
        String sql = "SELECT sectionID,courseID,evaltype,evalWeight,evalno FROM evaluationcriteria WHERE sectionID='"+sectionIDa+"' AND courseID='"+courseIDa+"'";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String sectionID,courseID;
             int evaltype;
             float evalWeight;
             int evalno;
             evaltype=evalno=0;
             evalWeight=0;
             courseID=sectionID=null;
    
            // loop through the result set
            while (rs.next()) {
                                   sectionID=rs.getString("sectionID");
                                   courseID=rs.getString("courseID");
                                   evaltype=rs.getInt("evaltype");
                                   evalWeight=rs.getFloat("evalWeight");
                                   evalno=rs.getInt("evalno");
                                   
                                    Marks m=new Marks(evaltype,evalno,evalWeight,0);
                                    s.addCriteria(m);
       
                                   
                                   }
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
    }

public ArrayList<Student> selectStudentAttendance(Attendance a,Sections s){
         String AttenDatea = new SimpleDateFormat("yyyy-MM-dd").format(a.getAttendance());
          String sectionID=s.getSection();
         String courseIDa=s.getCourse().getCourseID();
          ArrayList <Student> StudentList=null;
        String sql = "SELECT courseID,section,AttenDate,userID FROM attendance WHERE AttenDate='"+AttenDatea+"' AND section='"+sectionID+"' AND courseID='"+courseIDa+"'";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String courseID,section,userID;
             Date AttenDate=null;
             courseID=section=userID=null;
        StudentList= new ArrayList<>();
            // loop through the result set
            while (rs.next()) {
                
                                   courseID=rs.getString("courseID");
                                   section=rs.getString("section");
                                   AttenDate=rs.getDate("AttenDate");
                                   userID=rs.getString("userID");
                                  
                                   StudentList.add(this.getStudentObject(userID));
                                    
                                   }
                                  
                                   
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return StudentList;
    }
public ArrayList<semdata> getSemDataList(String userid){
    
        ArrayList<semdata> S = new ArrayList<>();
        System.out.println(userid);
         String sql = "SELECT SemesterID,courseName,Grade FROM semdata " +
"WHERE rollno='"+userid+"'" +
"group by SemesterID,courseName,Grade";
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String courseName,Grade;
             courseName=Grade=null;
             int SemesterID=0;
            // loop through the result set
            while (rs.next()) {
                
                                   SemesterID=rs.getInt("SemesterID");
                                   courseName=rs.getString("courseName");
                                   Grade=rs.getString("Grade");
                                   
                                  semdata s=new semdata(SemesterID,courseName,Grade);
                                   S.add(s);
                                   }
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
        return S;
    }
    
   
    public void loadMarkSheet()
    {
       
        Connection conn=null;
        try {
            String sql="SELECT courseID,studentid,sectionID,teachername,evaltype,evalno,evalmarks,grade FROM dblink.studentevaluations";
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
   
             String courseID,Grade,studentID,sectionID,teacherName;
             int evalType,evalNo,evalmarks;
             courseID=Grade=studentID=sectionID=teacherName=null;
             evalType=evalNo=evalmarks=0;
           
            ArrayList <Marks> mlist = new ArrayList<>();
            // loop through the result set
            while (rs.next()) {
                
                                 
                                   courseID=rs.getString("courseID");
                                   studentID=rs.getString("studentID");
                                   sectionID=rs.getString("sectionID");
                                   teacherName=rs.getString("teacherName");
                                   evalType=rs.getInt("evaltype");
                                   evalNo=rs.getInt("evalno");
                                   evalmarks=rs.getInt("evalmarks");
                                   Grade=rs.getString("grade");
                                           
                                   Marks mark= new Marks(evalType,evalNo, evalmarks);
                                   mlist.add(mark);
                                   if(evalType==5){
                                       Sections sec=this.getSectionObject(sectionID);
                                        Marksheet ms = new Marksheet(sec,this.getStudentObject(studentID));
                                        
                                        ms.setGrade2(Grade);
                                         
                                         ArrayList<Marks> mlist2 = new ArrayList<>(mlist);
                                        ms.setMarksList(mlist2);
                                        MarksheetList.add(ms);
                                        mlist.clear();
                                        mlist = new ArrayList<>();

                                                sec.addMarksheet(ms);
                                   }
                                   }
           
            
                              
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
        
        
    }

}
    

