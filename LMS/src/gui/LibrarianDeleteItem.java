/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.LibrarianUpdateItem.lms;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import library.Library;
import javax.swing.table.DefaultTableModel;
import library.Book;
import library.CDs;
import library.Items;

/**
 *
 * @author haadfida
 */
public class LibrarianDeleteItem extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public static Library lms;
    public static String userdisp;
    public static String userid;
    public LibrarianDeleteItem(Library lms,String display,String userid) {
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
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextDeleteID = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        ComboItem = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableitem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_Delete = new java.awt.Button();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(19, 19, 19))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(44, 44, 44))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGroup(btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_homeLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
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

        jPanel13.setPreferredSize(new java.awt.Dimension(5, 53));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Clerk");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LBMS/images/eye.png"))); // NOI18N

        javax.swing.GroupLayout btn_ClerkLayout = new javax.swing.GroupLayout(btn_Clerk);
        btn_Clerk.setLayout(btn_ClerkLayout);
        btn_ClerkLayout.setHorizontalGroup(
            btn_ClerkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ClerkLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(45, 45, 45))
        );
        btn_ClerkLayout.setVerticalGroup(
            btn_ClerkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(btn_ClerkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(btn_ClerkLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                .addComponent(jLabel2)
                .addGap(174, 174, 174)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(329, 329, 329))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel17))
                .addContainerGap(25, Short.MAX_VALUE))
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

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Enter Item ID");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 360, 200));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextDeleteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDeleteIDActionPerformed(evt);
            }
        });
        jPanel6.add(jTextDeleteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 352, 34));

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel6.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, 40));

        ComboItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book", "CD" }));
        ComboItem.setToolTipText("");
        ComboItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboItemActionPerformed(evt);
            }
        });
        jPanel6.add(ComboItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 710, 200));

        jTableitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableitem.setRowHeight(40);
        jTableitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableitemMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableitem);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 1070, -1));

        jPanel1.setBackground(new java.awt.Color(120, 168, 252));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 700, 360, 150));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_Delete.setActionCommand("d");
        btn_Delete.setBackground(new java.awt.Color(70, 120, 197));
        btn_Delete.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete.setLabel("Delete Item");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 700, 710, 150));

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

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        
              String ItemId= jTextDeleteID.getText().toString();
              if(ItemId.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"You didn't enter a value in the box, please try again");
            }
              else
            {
           lms.DeleteItemID(ItemId);
            }
         
    }//GEN-LAST:event_btn_DeleteActionPerformed
int itemselect;
    private void ComboItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboItemActionPerformed
        if(ComboItem.getSelectedItem().equals("Book")){
            // JOptionPane.showMessageDialog(null,"Borrower Selected");
            itemselect=1;
        }
        else if(ComboItem.getSelectedItem().equals("CD"))
        {
            itemselect=2;
        }

    }//GEN-LAST:event_ComboItemActionPerformed

    private void jTextDeleteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDeleteIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDeleteIDActionPerformed

    private void jTableitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableitemMouseClicked
        int selectedrow = jTableitem.rowAtPoint(evt.getPoint());
        DefaultTableModel model= (DefaultTableModel)jTableitem.getModel();
        jTextDeleteID.setText(model.getValueAt(selectedrow,0).toString());
    }//GEN-LAST:event_jTableitemMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
         String ItemId= jTextDeleteID.getText().toString();
         ArrayList <Items> ItemList=lms.searchItem(ItemId);
         DefaultTableModel model= (DefaultTableModel)jTableitem.getModel();
         model.setRowCount(0);
         
        if(itemselect==1){
            
            
                for (Items x: ItemList)
            {
                    if (x instanceof Book)
                 {
                     model.addRow(new Object[]{x.getItemId(),x.getTitle(),x.getAuthor(),x.getSubject()});        
                 }        
            }
        }
        else if(itemselect==2){
            
            
                for (Items x: ItemList)
            {
                    if (x instanceof CDs)
                 {
                     model.addRow(new Object[]{x.getItemId(),x.getTitle(),x.getAuthor(),x.getSubject()});           
                 }
            }
        }
        else
        {
            for (Items x: ItemList)
            {
                     model.addRow(new Object[]{x.getItemId(),x.getTitle(),x.getAuthor(),x.getSubject()});           
            }
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void jTextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchActionPerformed

        String Search= jTextSearch.getText().toString();
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
            java.util.logging.Logger.getLogger(LibrarianDeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianDeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianDeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianDeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianDeleteItem(lms,userdisp,userid).setVisible(true);
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
    private javax.swing.JPanel btn_BorrowerView;
    private javax.swing.JPanel btn_Clerk;
    private java.awt.Button btn_Delete;
    private javax.swing.JPanel btn_home;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel button_exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableitem;
    private javax.swing.JTextField jTextDeleteID;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JPanel side_panel;
    // End of variables declaration//GEN-END:variables
}