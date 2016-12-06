/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.userinterface.pharmaceuticalcompanymanagerrole;

import com.neu.business.enterprise.Enterprise;
import com.neu.business.organization.PharmaceuticalCompanyManagerOrganization;
import com.neu.business.useraccount.UserAccount;
import com.neu.business.workqueue.PharmacySupplyWorkRequest;
import com.neu.business.workqueue.WorkQueue;
import com.neu.business.workqueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shrikantmudholkar
 */
public class PharmaceuticalCompanyManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form pharmaceuticalCompanyManagerWA
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private PharmaceuticalCompanyManagerOrganization organization;
    private Enterprise enterprise;
    
    public PharmaceuticalCompanyManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmaceuticalCompanyManagerOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        
        populatePendingOrdersTable();
        populateCompletedOrdersTable();
    }
    
    public void populatePendingOrdersTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)tblPendingOrders.getModel();
        dtm.setRowCount(0);
        Object [] row = new Object[3];
        int count = 0;
        WorkQueue workQueue = organization.getWorkQueue();
        for(WorkRequest workRequest : workQueue.getWorkRequestList())
        {
            if(workRequest.getStatus().equals("Opioids Order Pending"))
            {
                row[0] = count++;
                row[1] = ((PharmacySupplyWorkRequest)workRequest).getPharmacyEnterprise();
                row[2] = ((PharmacySupplyWorkRequest)workRequest).getOrderAmount();
                dtm.addRow(row);
            }
        }
    }
    
    public void populateCompletedOrdersTable()
    {
       DefaultTableModel dtm = (DefaultTableModel)tblCompletedOrders.getModel();
        dtm.setRowCount(0);
        Object [] row = new Object[3];
        int count = 0;
        WorkQueue workQueue = organization.getWorkQueue();
        for(WorkRequest workRequest : workQueue.getWorkRequestList())
        {
            if(workRequest.getStatus().equals("Order Complete"))
            {
                row[0] = count++;
                row[1] = ((PharmacySupplyWorkRequest)workRequest).getPharmacyEnterprise();
                row[2] = ((PharmacySupplyWorkRequest)workRequest).getOrderAmount();
                dtm.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendingOrders = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFieldRemainingStock = new javax.swing.JTextField();
        btnAddStock = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompletedOrders = new javax.swing.JTable();
        btnRespond = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        tblPendingOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pharmacy Name", "Opioids Requested"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPendingOrders);

        jLabel2.setText("Remaining Stock :");

        btnAddStock.setText("Add to stock");

        jLabel1.setText("Pending distribution orders :");

        jLabel3.setText("Completed distribution orders :");

        tblCompletedOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pharmacy Name", "Opioids Supplied"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCompletedOrders);

        btnRespond.setText("Respond to Order");
        btnRespond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespondActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh Tables");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addContainerGap(250, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRespond)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(51, 51, 51)
                                    .addComponent(txtFieldRemainingStock, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddStock))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldRemainingStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddStock)
                    .addComponent(btnRefresh))
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRespond)
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRespondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespondActionPerformed
        // TODO add your handling code here:
        
        PharmacySupplyWorkRequest pharmaWorkRequest = (PharmacySupplyWorkRequest) tblPendingOrders.getValueAt(tblPendingOrders.getSelectedRow(), tblPendingOrders.getSelectedColumn());
        SupplyOpioidsJPanel supplyOpioidsJPanel = new SupplyOpioidsJPanel(userProcessContainer, pharmaWorkRequest, enterprise);
        userProcessContainer.add("SupplyOpioidsJPanel", supplyOpioidsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnRespondActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populatePendingOrdersTable();
        populateCompletedOrdersTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRespond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCompletedOrders;
    private javax.swing.JTable tblPendingOrders;
    private javax.swing.JTextField txtFieldRemainingStock;
    // End of variables declaration//GEN-END:variables
}
