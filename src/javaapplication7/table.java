/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lukas.oros
 */
public class table extends javax.swing.JFrame {

    /**
     * Creates new form table
     */
    public table() {
        initComponents();
        Show_Tasks_in_table();
    }
    
    public Connection getConnection()
    {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/skola","root","admin");
            return con;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Task> gettaskList()
    {
        ArrayList<Task> taskList = new ArrayList<>();
        Connection connection = getConnection();
        String query = "Select * from tasksystem where is_finished = 0";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Task task;
            while(rs.next()){
                task = new Task(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("deadline"),rs.getBoolean("is_finished"));
                taskList.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;    
    }
    
    public void Show_Tasks_in_table(){
        ArrayList<Task> taskList = gettaskList();
        DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
        Object[] row = new Object[5];
        for(int i = 0; i < taskList.size(); i++){
            row[0] = taskList.get(i).getid();
            row[1] = taskList.get(i).getTaskname();
            row[2] = taskList.get(i).getDescription();
            row[3] = taskList.get(i).getDeadline();
            //row[4] = taskList.get(i).getFinished();
            
            model.addRow(row);
        }
    }
    
    public void executeSqlQuery(String query, String message){
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if (st.executeUpdate(query) == 1 ){
                //refresh data
                DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
                model.setRowCount(0);
                Show_Tasks_in_table();
                JOptionPane.showMessageDialog(null, "Data "+message+" succesfully");
            }else {
                JOptionPane.showMessageDialog(null, "Data not"+message);
            }
        }catch (Exception ex){
            ex.printStackTrace();
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_table = new javax.swing.JTable();
        jTextField_Name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Description = new javax.swing.JTextArea();
        jFormattedTextField_Deadline = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        errTxt = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Deadline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_table);
        if (jTable_table.getColumnModel().getColumnCount() > 0) {
            jTable_table.getColumnModel().getColumn(0).setResizable(false);
            jTable_table.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jTextArea_Description.setColumns(5);
        jTextArea_Description.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea_Description.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Description);

        jFormattedTextField_Deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_DeadlineActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setText("TASK SYSTEM beta");

        jLabel2.setText("Task name:");

        jLabel3.setText("Task description:");

        jLabel4.setText("Deadline:");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        errTxt.setForeground(new java.awt.Color(255, 0, 0));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        jTextField_Id.setEditable(false);

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4)
                                        .addGap(32, 32, 32))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(jTextField_Name)
                                    .addComponent(jFormattedTextField_Deadline)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 29, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField_Deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField_DeadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_DeadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_DeadlineActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         errTxt.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
        if(!jTextField_Name.getText().trim().equals("")){
            String query = "INSERT INTO `tasksystem`(`name`, `description`, `deadline`, `is_finished`) VALUES ('"+jTextField_Name.getText()+"','"+jTextArea_Description.getText()+"','"+jFormattedTextField_Deadline.getText()+"',0)";
            executeSqlQuery(query, "Inserted");
            jTextField_Name.setText("");
            jTextArea_Description.setText("");
            jFormattedTextField_Deadline.setText("");
            jTextField_Id.setText("");
            /*Show_Tasks_in_table();*/
        }else{
            errTxt.setText("Task name should not be empty!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Edit(Task t){
       errTxt.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
        if(jTable_table.getSelectedRow()==1){
           if(jTable_table.getRowCount()==0){
            errTxt.setText("Table is empty!");
        }else{
            errTxt.setText("You must select a row!");
           } 
        }else{
            String query = "UPDATE `tasksystem` SET `name`='"+jTextField_Name.getText()+"',`description`='"+jTextArea_Description.getText()+"',`deadline`='"+jFormattedTextField_Deadline.getText()+"',`is_finished`='0' WHERE `id` = '"+jTextField_Id.getText()+"'";
            jTextField_Name.setText("");
            jTextArea_Description.setText("");
            jFormattedTextField_Deadline.setText("");
            jTextField_Id.setText("");
            executeSqlQuery(query, "Updated");
        } 
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_tableMouseClicked
        int i = jTable_table.getSelectedRow();
        TableModel model = jTable_table.getModel();
        jTextField_Id.setText(model.getValueAt(jTable_table.getSelectedRow(), 0).toString());
        jTextField_Name.setText(model.getValueAt(jTable_table.getSelectedRow(), 1).toString());
        jTextArea_Description.setText(model.getValueAt(jTable_table.getSelectedRow(), 2).toString());
        jFormattedTextField_Deadline.setText(model.getValueAt(jTable_table.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_jTable_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
        if(jTable_table.getSelectedRow()==1){
           if(jTable_table.getRowCount()==0){
            errTxt.setText("Table is empty!");
        }else{
            errTxt.setText("You must select which task would you like to delete!");
           } 
        }else{
            String query = "DELETE FROM `tasksystem` WHERE id = "+jTextField_Id.getText();
            jTextField_Name.setText("");
            jTextArea_Description.setText("");
            jFormattedTextField_Deadline.setText("");
            jTextField_Id.setText("");
            executeSqlQuery(query, "Deleted");
            /*model.removeRow(jTable_table.getSelectedRow());*/
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_tableMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            DefaultTableModel model = (DefaultTableModel) jTable_table.getModel();
            int selectedRow = jTable_table.getSelectedRow();
            Task data = new Task();
            data.setId((int) model.getValueAt(selectedRow, 0));
            data.setTaskname((String) model.getValueAt(selectedRow, 1));
            data.setDescription((String) model.getValueAt(selectedRow, 2));
            data.setDeadline((String) model.getValueAt(selectedRow, 3));
            //data.setIs_finished((Boolean) model.getValueAt(selectedRow, 4));
            Task_detail modal = new Task_detail(this,true,this,data);
            modal.setVisible(true);
            
        }
    }//GEN-LAST:event_jTable_tableMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            jTextField_Id.setText("");
            jTextField_Name.setText("");
            jTextArea_Description.setText("");
            jFormattedTextField_Deadline.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFormattedTextField jFormattedTextField_Deadline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_table;
    private javax.swing.JTextArea jTextArea_Description;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_Name;
    // End of variables declaration//GEN-END:variables

}
