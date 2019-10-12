/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.DriverManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import lms.*;



/**
 *
 * @author haadfida
 */
public class Main extends javax.swing.JFrame {
    private static final String username= "root";
    private static final String password= "";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
    public static LMS lms=new LMS();
    /**
     * Creates new form Home
     */
    
    public Main() {
        initComponents();
        setColor(btn_home);
         String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            jcurrentDate.setText(date);
 
    }
   public void selectUser(){
        String sql = "SELECT userID,age,pass, userName,userType FROM users";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             String id,username,password;
             id=username=password=null;
             int age,usertype;
   
            // loop through the result set
            while (rs.next()) {
                
                                   id=rs.getString("userID");
                                   age=rs.getInt("age");
                                   password=rs.getString("pass");
                                   username=rs.getString("userName");
                                   usertype=rs.getInt("userType");
                                   System.out.println(id+age+username+usertype);
                                   if(usertype==1){
                                       Student s=new Student(age,id,username,password);
                                       lms.loadStudents(s);
                                   }
                                    else if(usertype==2){
                                    Teacher t=new Teacher(age,id,username,password);
                                       lms.loadTeachers(t);
                                   
                                   }
                                    else if(usertype==3){
                                    Admin a=new Admin(age,id,username,password);
                                    lms.loadAdmins(a);
                                    }
                                   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
   
   public void selectCourse(){
        String sql = "SELECT courseID,courseName FROM courses";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             String id,name;
             id=name=null;
             int itemtype;
            // loop through the result set
            while (rs.next()) {
                
                                   id=rs.getString("courseID");
                                   name=rs.getString("courseName");
                                   System.out.println(id+name);
                                   Course c=new Course(id,name);
                                   lms.loadCourses(c);
                                                             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
   
    public void selectSection(){
        String sql = "SELECT section,isOpen,seatsFilled, courseID,courseName,teacherName FROM sections";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             String section,courseID,coursename,teacherName;
             section=courseID=coursename=teacherName=null;
             int isOpen,seatsFilled;
   
            // loop through the result set
            while (rs.next()) {
                
                                   section=rs.getString("section");
                                   isOpen=rs.getInt("isOpen");
                                   seatsFilled=rs.getInt("seatsFilled");
                                   courseID=rs.getString("courseID");
                                   coursename=rs.getString("courseName");
                                   teacherName=rs.getString("teacherName");
                                   
                                   Course c=lms.getCourseObject(courseID);
                                   Teacher t=lms.getTeacherObject(teacherName);
                                   
                                   Sections s=new Sections(c,seatsFilled,isOpen,t,section);
                                   System.out.println(section+isOpen+seatsFilled+c.getCourseID()+coursename+t.getUserName());
                                   
                                   lms.loadSection(s);
                                   lms.selectAttendance(s);
                                   lms.selectCriteria2(s);
                                   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void studentStudies(){
        String sql = "SELECT courseID,section,userName,UserID FROM studentsection";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             String section,courseID,userID,userName;
             section=courseID=userID=userName=null;
          
   
            // loop through the result set
            while (rs.next()) {
                
                                   courseID=rs.getString("courseID");
                                   section=rs.getString("section");
                                   userName=rs.getString("userName");
                                   userID=rs.getString("UserID");
                                   
                                   Student stu=lms.getStudentObject(userID);
                                   Sections s=lms.findSection(courseID, section);
                                   s.addStudent(stu);
                                  stu.addSection2(s);
            }
  
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
        public void studentSemester(){
        String sql = "SELECT SemesterID,UserID,sgpa FROM semester";
        
          Connection conn=null;
        try {
            conn=DriverManager.getConnection(conn_string,username,password);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             String UserID;
             UserID=null;
             float sgpa=0;
             int SemesterID=0;
          
   
            // loop through the result set
            while (rs.next()) {
                
                                   SemesterID=rs.getInt("SemesterID");
                                   UserID=rs.getString("UserID");
                                   sgpa=rs.getFloat("sgpa");
                                   
                                   
                                   Student stu=lms.getStudentObject(UserID);
                                   
                                   semester s=new semester(stu,sgpa,SemesterID);
                                   //System.out.println(s.getS().id+s.getSemID()+s.getSgpa());
                                   lms.addSem(s);
                                  
            }
  
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
     
   
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_panel = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        button_exit = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jcurrentDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        LoginButton = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        ComboUser = new javax.swing.JComboBox<String>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(23, 35, 51));
        side_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(41, 57, 80));
        btn_home.setPreferredSize(new java.awt.Dimension(170, 114));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        jPanel12.setPreferredSize(new java.awt.Dimension(5, 53));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Home Page");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/Library-icon.png"))); // NOI18N

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        side_panel.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 60));

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 850));

        jPanel2.setBackground(new java.awt.Color(70, 120, 197));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(523, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(174, 174, 174)
                .addComponent(jLabel9)
                .addGap(373, 373, 373))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addComponent(jLabel9)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1070, 80));

        jPanel3.setBackground(new java.awt.Color(70, 120, 197));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(120, 168, 252));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(84, 127, 206));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/Login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(55, 55, 55))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, -1, 390));

        button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/exit-3.png"))); // NOI18N
        button_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button_exitMousePressed(evt);
            }
        });
        jPanel4.add(button_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 60, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jPanel8.setBackground(new java.awt.Color(84, 127, 206));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1127, 360, -1));

        button1.setBackground(new java.awt.Color(70, 120, 197));
        button1.setFont(new java.awt.Font("Sinhala MN", 1, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Refresh Date");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel3.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 150, 40));

        jcurrentDate.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jcurrentDate.setForeground(new java.awt.Color(255, 255, 255));
        jcurrentDate.setText("Jan 2019");
        jPanel3.add(jcurrentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 230, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 360, 780));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(240, 246, 246));

        jLabel11.setText("Username");

        jLabel18.setText("Password");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        LoginButton.setActionCommand("d");
        LoginButton.setBackground(new java.awt.Color(70, 120, 197));
        LoginButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setLabel("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(240, 246, 246));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jTextField1.setText("Login");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        ComboUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Teacher", "Admin" }));
        ComboUser.setToolTipText("");
        ComboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboUserActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/books.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/lock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(86, 396, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(338, 338, 338))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel11))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(116, 116, 116))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 710, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homeMousePressed

    private void button_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_button_exitMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_formMouseDragged
int xx,xy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx=evt.getX();
        xy=evt.getY();
        
    }//GEN-LAST:event_formMousePressed
int selected;
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
//        // TODO add your handling code here:
 String id = jTextField2.getText().toString();
  String password = jPasswordField1.getText();       
     System.out.println(id+password);
  String getusername = jTextField2.getText().toString();
                     String display=lms.DisplayName(getusername);
                     System.out.println(display);
        switch (selected) {
            case 1:
                {
                    boolean logincheck=lms.checkStudentLogin(id,password);
                    if(logincheck){
                    StudentHome b = new StudentHome(lms,display,id);
                    b.setVisible(true);
                    }
                    break;
                }
            case 2:
                {
                     boolean logincheck=lms.checkTeacherLogin(id,password);
                    if(logincheck){
                        TeacherHome c = new TeacherHome(lms,display,id);
                    c.setVisible(true);
                    }
                           else
                      {
                          JOptionPane.showMessageDialog(null,"Invalid login");
                        } 
                    break;
                }
            case 3:
                {   
                     boolean logincheck=lms.checkAdminLogin(id,password);
                    if(logincheck){
                    AdminHome c = new AdminHome(lms,display,id);
                    c.setVisible(true);
                    }
                          else
                      {
                          JOptionPane.showMessageDialog(null,"Invalid login");
                      } 
                    break;
                }
            default:
                {
                      boolean logincheck=lms.checkStudentLogin(id,password);
                    if(logincheck){
                    StudentHome b = new StudentHome(lms,display,id);
                    b.setVisible(true);
                    }
                    else
                    {
                          JOptionPane.showMessageDialog(null,"Invalid login");
                    } 
                    break;
                }
        }
       
     

        
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ComboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboUserActionPerformed
        // TODO add your handling code here:
            //        "Borrower", "Clerk", "Librarian" 
          if(ComboUser.getSelectedItem().equals("Student")){
         // JOptionPane.showMessageDialog(null,"Borrower Selected");
         selected=1;
          }
          else if(ComboUser.getSelectedItem().equals("Teacher"))
          {
          selected=2;
          }
          else if(ComboUser.getSelectedItem().equals("Admin"))
          {
          selected=3;
          }
    }//GEN-LAST:event_ComboUserActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
        
        
      
  
    
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        jcurrentDate.setText(date);
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
                Main app = new Main();
                app.selectUser();
                app.selectCourse();
                app.selectSection();
                app.studentStudies();
                app.studentSemester();
                lms.loadMarkSheet();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    private void setColor(JPanel panel)
    {
        panel.setBackground(new Color(41,57,80));
    }
    
      private void resetColor(JPanel[] panel)
    {
        for(int i=0; i<panel.length;i++){
            panel[i].setBackground(new Color(23,35,51));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboUser;
    private java.awt.Button LoginButton;
    private javax.swing.JPanel btn_home;
    private java.awt.Button button1;
    private javax.swing.JLabel button_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jcurrentDate;
    private javax.swing.JPanel side_panel;
    // End of variables declaration//GEN-END:variables
}
