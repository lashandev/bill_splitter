/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lashan.bill_splitter;

import com.lashan.bill_splitter.db.DBConf;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lashan
 */
public class BillSplitter extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("#.##");

    private double tot_item = 0, tot_each = 0;

    /**
     * Creates new form BillSplitter
     */
    public BillSplitter() {
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Session");

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Member", "Item", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel2.setText("Each Member Need To Pay");

        jLabel3.setText("Each Member User Items and Amount");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Amount"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Account number\n0010 2036 8215\nName\nLashan Chandika Hettiarachchi\nBank\nDialog Finance PLC\n\nBranch\nHead office");
        jScrollPane3.setViewportView(jTextArea1);

        jLabel4.setText("Account Details");

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_sessiondata, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(352, 352, 352)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_sessiondata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String session = combo_sessiondata.getSelectedItem().toString().split("-")[0];
        tot_each = 0;
        tot_item = 0;
        try {
            String sql = "select i.id,s.name,m.name,s.total/(select count(*) from event_item x where x.item=i.item) from event_item i"
                    + " inner join eventdata e on i.eventdata = e.id INNER JOIN member m on e.member = m.id INNER JOIN"
                    + " item s on i.item = s.id where e.sessiondata='" + session + "' order by m.name asc";
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            ResultSet rs1 = DBConf.search(sql);
            int index = 0;
            while (rs1.next()) {
                Vector row = new Vector();
                row.add(++index);
                row.add(rs1.getString(3));
                row.add(rs1.getString(2));
                String val = df.format(rs1.getDouble(4));
                row.add(val);
                dtm.addRow(row);
                tot_item += Double.parseDouble(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "select m.name,SUM(s.total/(select count(*) from event_item x where x.item=i.item)) from event_item i"
                    + " inner join eventdata e on i.eventdata = e.id INNER JOIN member m on e.member = m.id INNER JOIN"
                    + " item s on i.item = s.id where e.sessiondata='" + session + "' GROUP BY m.id ORDER BY m.name ASC";
            DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel();
            dtm2.setRowCount(0);
            ResultSet rs2 = DBConf.search(sql2);
            int index = 0;
            while (rs2.next()) {
                Vector row = new Vector();
                row.add(++index);
                row.add(rs2.getString(1));
                row.add(df.format(rs2.getDouble(2)));
                dtm2.addRow(row);
                tot_each += Double.parseDouble(df.format(rs2.getDouble(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            List<DataDto> list = new ArrayList<>();

            String sesid = combo_sessiondata.getSelectedItem().toString().split("-")[0];
            String sql = "select m.name,SUM(s.total/(select count(*) from event_item x where x.item=i.item)) as total,"
                    + "(select sum(c.amount) from contribution c INNER JOIN eventdata e1 on c.eventdata = e1.id where e1.sessiondata=e.sessiondata and e1.id=e.id) as paid,"
                    + " ((SUM(s.total/(select count(*) from event_item x where x.item=i.item)))-(select sum(c.amount) from contribution c INNER JOIN eventdata e1 on c.eventdata = e1.id where e1.sessiondata=e.sessiondata and e1.id=e.id)) as balance"
                    + " from event_item i inner join eventdata e on i.eventdata = e.id INNER JOIN member m on e.member = m.id "
                    + "INNER JOIN item s on i.item = s.id  where e.sessiondata='" + sesid + "' GROUP BY m.id ORDER BY m.name ASC";
            ResultSet rs = DBConf.search(sql);
            while (rs.next()) {
                DataDto dataDto = new DataDto();
                dataDto.setName(rs.getString(1));
                dataDto.setTotal(df.format(rs.getDouble(2)));
                if (rs.getString(3) != null) {
                    dataDto.setPaid(df.format(rs.getDouble(3)));
                } else {
                    dataDto.setPaid("0.0");
                }

                if (rs.getString(4) != null) {
                    if (rs.getDouble(4) > 0) {
                        dataDto.setBalance("You need to Pay LKR " + df.format(rs.getDouble(4)));
                    } else {
                        dataDto.setBalance("You need Received LKR " + df.format(rs.getDouble(4) * -1));
                    }
                } else {
                    dataDto.setBalance("You need to Pay LKR " + df.format(rs.getDouble(2)));
                }
                
                list.add(dataDto);

            }

            String session = combo_sessiondata.getSelectedItem().toString();
            String path = "E:\\other_project\\bill_splitter\\billsplitter.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("sessiondata", session);

            JRTableModelDataSource dataSource1 = new JRTableModelDataSource(jTable1.getModel());
            JRTableModelDataSource dataSource2 = new JRTableModelDataSource(jTable2.getModel());
            JRBeanCollectionDataSource dataSource3 = new JRBeanCollectionDataSource(list);
            parameters.put("data1", dataSource1);
            parameters.put("data2", dataSource2);
            parameters.put("data3", dataSource3);
            parameters.put("account", jTextArea1.getText());
            parameters.put("tot_item", tot_item);
            parameters.put("tot_each_person", tot_each);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BillSplitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillSplitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillSplitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillSplitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillSplitter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_sessiondata;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
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

}
