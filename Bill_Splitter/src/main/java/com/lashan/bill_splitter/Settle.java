/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lashan.bill_splitter;

import com.lashan.bill_splitter.db.DBConf;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author lashan_chandika
 */
public class Settle extends javax.swing.JFrame {
private double total = 0;
private double amount = 0;
private DecimalFormat df = new DecimalFormat("#.##");
    /**
     * Creates new form Settle
     */
    public Settle() {
        initComponents();
        setLocationRelativeTo(null);
        loadSession();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo_sessiondata = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        txt_total = new javax.swing.JLabel();
        txt_payment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Session");

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sourceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EID", "Name"
            }
        ));
        sourceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sourceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sourceTable);
        if (sourceTable.getColumnModel().getColumnCount() > 0) {
            sourceTable.getColumnModel().getColumn(0).setMinWidth(50);
            sourceTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            sourceTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Remark", "Amount"
            }
        ));
        jScrollPane2.setViewportView(paymentTable);
        if (paymentTable.getColumnModel().getColumnCount() > 0) {
            paymentTable.getColumnModel().getColumn(0).setMinWidth(50);
            paymentTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            paymentTable.getColumnModel().getColumn(0).setMaxWidth(50);
            paymentTable.getColumnModel().getColumn(2).setMinWidth(100);
            paymentTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            paymentTable.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        txt_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total.setForeground(new java.awt.Color(255, 0, 0));
        txt_total.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_payment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_payment.setForeground(new java.awt.Color(255, 0, 0));
        txt_payment.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(combo_sessiondata, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(txt_payment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_sessiondata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshSourceTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sourceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sourceTableMouseClicked
        refreshPaidList();
        setTotal();
        getSplitAmount();
        double ans  = total - amount;
        if (ans >0) {
            txt_payment.setText("You need to Received LKR "+df.format(ans));
            txt_payment.setForeground(Color.red);
        }else{
            txt_payment.setText("You need Pay LKR "+df.format(ans*-1));
            txt_payment.setForeground(Color.BLUE);
        }
    }//GEN-LAST:event_sourceTableMouseClicked

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
            java.util.logging.Logger.getLogger(Settle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_sessiondata;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable paymentTable;
    private javax.swing.JTable sourceTable;
    private javax.swing.JLabel txt_payment;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables
    
    private void loadSession() {

        String sql = "select * from sessiondata where active='1' order by id desc";
        try {
            ResultSet rs = DBConf.search(sql);
            Vector row = new Vector();
            while (rs.next()) {
                row.add(rs.getString("id") + "-" + rs.getString("name") + "-" + rs.getString("place") + "-" + rs.getString("date"));
            }
            combo_sessiondata.setModel(new DefaultComboBoxModel<>(row));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearTextFields() {
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JTextComponent) {
                JTextComponent text = (JTextComponent) c;
                text.setText(null);
            }
        }
    }
    
     private void refreshSourceTable() {
        String session = combo_sessiondata.getSelectedItem().toString().split("-")[0];
        DefaultTableModel dtm = (DefaultTableModel) sourceTable.getModel();
        dtm.setRowCount(0);

        try {
            String sql1 = "select e.id,m.name from eventdata e inner join member m on e.member=m.id where e.sessiondata='" + session + "'";
            ResultSet rs = DBConf.search(sql1);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                dtm.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    private void refreshPaidList() {
        String session = combo_sessiondata.getSelectedItem().toString().split("-")[0];
        String eid = sourceTable.getValueAt(sourceTable.getSelectedRow(), 0).toString();
        DefaultTableModel dtm = (DefaultTableModel) paymentTable.getModel();
        dtm.setRowCount(0);
        int index = 0;
        try {
            String sql1 = "select c.remark,c.amount from contribution c "
                    + "INNER JOIN eventdata e on c.eventdata = e.id "
                    + "INNER JOIN member m on e.member = m.id where e.sessiondata='"+session+"' and e.id='"+eid+"'";
            ResultSet rs = DBConf.search(sql1);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(++index);
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                dtm.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTotal() {
        String session = combo_sessiondata.getSelectedItem().toString().split("-")[0];
        String eid = sourceTable.getValueAt(sourceTable.getSelectedRow(), 0).toString();
        
        try {
            String sql1 = "select sum(c.amount) from contribution c "
                    + "INNER JOIN eventdata e on c.eventdata = e.id "
                    + "INNER JOIN member m on e.member = m.id "
                    + "where e.sessiondata='"+session+"' and e.id='"+eid+"';";
            ResultSet rs = DBConf.search(sql1);
            if (rs.next()) {
               txt_total.setText("Total Payment Received :"+((rs.getString(1)!=null)?rs.getString(1):"0.00"));
               total = (rs.getString(1)!=null)?Double.parseDouble(rs.getString(1)):0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSplitAmount() {
        try {
            String session = combo_sessiondata.getSelectedItem().toString().split("-")[0];
            String eid = sourceTable.getValueAt(sourceTable.getSelectedRow(), 0).toString();
            String sql2 = "select SUM(s.total/(select count(*) from event_item x where x.item=i.item)) from event_item i "
                    + "INNER JOIN eventdata e on i.eventdata = e.id "
                    + "INNER JOIN item s on i.item = s.id where e.sessiondata='"+session+"' and e.id='"+eid+"'";
            
            ResultSet rs2 = DBConf.search(sql2);
            if (rs2.next()) {
                amount = rs2.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}