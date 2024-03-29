/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import library.Book;
import library.CDs;
import library.Library;

/**
 *
 * @author haadfida
 */
public class LibrarianAddItem extends javax.swing.JFrame {
    /**
     * Creates new form Home
     */
    public static Library lms;
    public static String userdisp;
    public static String userid;
    public LibrarianAddItem(Library lms,String display,String userid) {
        initComponents();
        setColor(btn_home);
        resetColor(new JPanel[]{btn_BorrowerView,btn_Clerk});
        this.lms=lms;
        this.userdisp=display;
        this.userid=userid;
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
        btn_BorrowerView = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_home = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Clerk = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ComboUser = new javax.swing.JComboBox<>();
        jTextSearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        button_exit = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextTitle = new javax.swing.JTextField();
        jTextSubject = new javax.swing.JTextField();
        jTextAuthor = new javax.swing.JTextField();
        jTextItemID = new javax.swing.JTextField();
        btn_Add = new java.awt.Button();
        ComboItem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        btn_BorrowerView.setBackground(new java.awt.Color(23, 35, 51));
        btn_BorrowerView.setPreferredSize(new java.awt.Dimension(170, 114));
        btn_BorrowerView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_BorrowerViewMousePressed(evt);
            }
        });

        jPanel11.setPreferredSize(new java.awt.Dimension(5, 53));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Borrower");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/eye.png"))); // NOI18N

        javax.swing.GroupLayout btn_BorrowerViewLayout = new javax.swing.GroupLayout(btn_BorrowerView);
        btn_BorrowerView.setLayout(btn_BorrowerViewLayout);
        btn_BorrowerViewLayout.setHorizontalGroup(
            btn_BorrowerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_BorrowerViewLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(15, 15, 15))
        );
        btn_BorrowerViewLayout.setVerticalGroup(
            btn_BorrowerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_BorrowerViewLayout.createSequentialGroup()
                .addGroup(btn_BorrowerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_BorrowerViewLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btn_BorrowerViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        side_panel.add(btn_BorrowerView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 60));

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
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Home");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/Library-icon.png"))); // NOI18N

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(42, 42, 42))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGroup(btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_homeLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12))
                    .addGroup(btn_homeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        side_panel.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 60));

        btn_Clerk.setBackground(new java.awt.Color(23, 35, 51));
        btn_Clerk.setPreferredSize(new java.awt.Dimension(170, 114));
        btn_Clerk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ClerkMousePressed(evt);
            }
        });
        btn_Clerk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setPreferredSize(new java.awt.Dimension(5, 53));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btn_Clerk.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Clerk");
        btn_Clerk.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/eye.png"))); // NOI18N
        btn_Clerk.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        side_panel.add(btn_Clerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, 50));

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 850));

        jPanel2.setBackground(new java.awt.Color(70, 120, 197));

        ComboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "title", "author", "subject" }));
        ComboUser.setToolTipText("");
        ComboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboUserActionPerformed(evt);
            }
        });

        jTextSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/research.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(461, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel9)
                        .addGap(322, 322, 322))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1070, 80));

        jPanel3.setBackground(new java.awt.Color(120, 168, 252));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1141, 360, -1));

        button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/back-2.png"))); // NOI18N
        button_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button_exitMousePressed(evt);
            }
        });
        jPanel3.add(button_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 43, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Enter Item Title");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Enter Item Subject");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Enter Item Author");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Enter Item ID");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 360, 760));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTextTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTitleActionPerformed(evt);
            }
        });

        jTextSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSubjectActionPerformed(evt);
            }
        });

        jTextAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAuthorActionPerformed(evt);
            }
        });

        jTextItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextItemIDActionPerformed(evt);
            }
        });

        btn_Add.setActionCommand("d");
        btn_Add.setBackground(new java.awt.Color(70, 120, 197));
        btn_Add.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add.setLabel("Add Item");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        ComboItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book", "CD" }));
        ComboItem.setToolTipText("");
        ComboItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ComboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jTextSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jTextAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jTextItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 710, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        // TODO add your handling code here:
        setColor(btn_home);
        resetColor(new JPanel[]{btn_BorrowerView,btn_Clerk});
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_BorrowerViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BorrowerViewMousePressed
        // TODO add your handling code here:
        BorrowerHome b=new BorrowerHome(lms,userdisp,userid);
        b.setVisible(true);
    }//GEN-LAST:event_btn_BorrowerViewMousePressed

    private void btn_ClerkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ClerkMousePressed
          ClerkHome c=new ClerkHome(lms,userdisp,userid);
        c.setVisible(true);
          
    }//GEN-LAST:event_btn_ClerkMousePressed

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
    private void ComboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboUserActionPerformed
        // TODO add your handling code here:
        //        "Borrower", "Clerk", "Librarian"
        if(ComboUser.getSelectedItem().equals("title")){
            // JOptionPane.showMessageDialog(null,"Borrower Selected");
            selected=1;
        }
        else if(ComboUser.getSelectedItem().equals("author"))
        {
            selected=2;
        }
        else if(ComboUser.getSelectedItem().equals("subject"))
        {
            selected=3;
        }
    }//GEN-LAST:event_ComboUserActionPerformed

    private void button_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_exitMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_exitMousePressed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        if(itemselect==1)//Book
        {

            String ItemId= jTextItemID.getText();
            String Title= jTextTitle.getText();
            String Author= jTextAuthor.getText();
            String Genre= jTextSubject.getText();

            if(ItemId.equals("") || Title.equals("") || Author.equals("")||Genre.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"You didn't enter a value in one of the boxes, please try again");
            }
            else
            {
            Book b =new Book(ItemId,Title,Author,Genre);
           boolean check=lms.AddBook(b);
           if(check){
            JOptionPane.showMessageDialog(null,"Book successfully inserted");
           } 
            }
            
        }
        else if(itemselect==2)//CD
        {
            String ItemId= jTextItemID.getText().toString();
            String Title= jTextTitle.getText().toString();
            String Author= jTextAuthor.getText().toString();
            String Genre= jTextSubject.getText().toString();

            if(ItemId.equals("") || Title.equals("") || Author.equals("")||Genre.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"You didn't enter a value in one of the boxes, please try again");
            }
            else
            {
                 CDs c=new CDs(ItemId,Title,Author,Genre);
           boolean check=lms.AddCDs(c);
           if(check){
            JOptionPane.showMessageDialog(null,"CD successfully inserted");
            }
        }
        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void jTextTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTitleActionPerformed
int itemselect;
    private void ComboItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboItemActionPerformed
         
        if(ComboItem.getSelectedItem().equals("Book")){
            // JOptionPane.showMessageDialog(null,"Borrower Selected");
            itemselect=1;
             System.out.println(itemselect);
        }
        else if(ComboItem.getSelectedItem().equals("CD"))
        {
            itemselect=2;
            System.out.println(itemselect);
        }
   
    }//GEN-LAST:event_ComboItemActionPerformed

    private void jTextItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextItemIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextItemIDActionPerformed

    private void jTextSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSubjectActionPerformed

    private void jTextAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAuthorActionPerformed

    private void jTextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchActionPerformed

        String Search= jTextSearch.getText();
        switch (selected) {
            case 1:
            {
                SearchItemTitle s = new SearchItemTitle(lms,Search,userid);
                s.setVisible(true);
                break;
            }
            case 2:
            {
                SearchItemAuthor s = new SearchItemAuthor(lms,Search,userid);
                s.setVisible(true);
                break;
            }
            case 3:
            {
                SearchItemSubject s = new SearchItemSubject(lms,Search,userid);
                s.setVisible(true);
                break;
            }
            default:
            SearchItemTitle s = new SearchItemTitle(lms,Search,userid);
            s.setVisible(true);
            break;
        }
    }//GEN-LAST:event_jTextSearchActionPerformed

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
            java.util.logging.Logger.getLogger(LibrarianAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianAddItem(lms,userdisp,userid).setVisible(true);
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
//        for(int i=0; i<indicators.length;i++){
//            indicators[i].setOpaque(false);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboItem;
    private javax.swing.JComboBox<String> ComboUser;
    private java.awt.Button btn_Add;
    private javax.swing.JPanel btn_BorrowerView;
    private javax.swing.JPanel btn_Clerk;
    private javax.swing.JPanel btn_home;
    private javax.swing.JLabel button_exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextAuthor;
    private javax.swing.JTextField jTextItemID;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField jTextSubject;
    private javax.swing.JTextField jTextTitle;
    private javax.swing.JPanel side_panel;
    // End of variables declaration//GEN-END:variables
}
