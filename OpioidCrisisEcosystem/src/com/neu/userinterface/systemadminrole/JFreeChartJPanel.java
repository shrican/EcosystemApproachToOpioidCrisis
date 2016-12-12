/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.userinterface.systemadminrole;

import com.neu.business.EcoSystem;
import com.neu.business.patient.Patient;
import com.neu.business.patient.PatientDirectory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Soham
 */
public class JFreeChartJPanel extends javax.swing.JPanel {

    /**
     * Creates new form JFreeChartJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private PatientDirectory systemPatientDirectory;

    JFreeChartJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.systemPatientDirectory= system.getPatientDirectory();
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnShowChart = new javax.swing.JButton();
        jChartDisplayJPanel = new javax.swing.JPanel();
        comboBoxReports = new javax.swing.JComboBox<>();

        btnShowChart.setText("Show Chart");
        btnShowChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowChartActionPerformed(evt);
            }
        });

        jChartDisplayJPanel.setBackground(new java.awt.Color(153, 153, 153));
        jChartDisplayJPanel.setForeground(new java.awt.Color(255, 255, 255));
        jChartDisplayJPanel.setLayout(new java.awt.BorderLayout());

        comboBoxReports.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View Opioids Prescribed per Symptom", "General Symptoms Breakdown", "Symptoms resulting in most prescriptions", "Patient score status with highest abuse symptoms" }));
        comboBoxReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChartDisplayJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxReports, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowChart)
                        .addGap(0, 509, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowChart)
                    .addComponent(comboBoxReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jChartDisplayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowChartActionPerformed
        // TODO add your handling code here:
       
       DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
       JFreeChart barChart = ChartFactory.createBarChart("Symptoms seen in Patients", "", "Number of Patients", barChartData, PlotOrientation.VERTICAL, true, true, true);
       if(comboBoxReports.getSelectedIndex() == 0){
       HashMap<String, Integer> mostPrescribesSymptoms = systemPatientDirectory.mostPrescribedSymptom();
       
       for(Map.Entry<String, Integer> entry : mostPrescribesSymptoms.entrySet())
       {
           String symptom = entry.getKey();
           Integer prescriptions = entry.getValue();
           
           barChartData.setValue(prescriptions, "", symptom);
       }
       
//       barChartData.setValue(5, "Donation Amount", "Sept");
//
//       barChartData.setValue(8, "Donation Amount", "Oct");
//
//       barChartData.setValue(11, "Donation Amount", "Nov");



       barChart = ChartFactory.createBarChart("Symptoms Prescription Distribution", "", "Opioids Prescribed", barChartData, PlotOrientation.VERTICAL, true, true, true);
       }
       
       else if(comboBoxReports.getSelectedIndex() == 1){
           HashMap<String, Integer> symptomsBreakdown = systemPatientDirectory.generalSymptomsBreakdown((ArrayList<Patient>) systemPatientDirectory.getPatientList());
           
           for(Map.Entry<String, Integer> entry : symptomsBreakdown.entrySet())
           {
               String symptom = entry.getKey();
               Integer patients = entry.getValue();
               
               barChartData.setValue(patients, "", symptom);
           }
           
           barChart = ChartFactory.createBarChart("Symptoms seen in Patients", "", "Number of Patients", barChartData, PlotOrientation.VERTICAL, true, true, true);
       }
       
       else if(comboBoxReports.getSelectedIndex() == 2)
       {
           
       }
       CategoryPlot barchrt = barChart.getCategoryPlot();

       barchrt.setRangeGridlinePaint(Color.ORANGE);

       ChartPanel barP = new ChartPanel(barChart);

       barP.setVisible(true);

       jChartDisplayJPanel.removeAll();

       jChartDisplayJPanel.add(barP, BorderLayout.CENTER);

       jChartDisplayJPanel.validate();
        
    }//GEN-LAST:event_btnShowChartActionPerformed

    private void comboBoxReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowChart;
    private javax.swing.JComboBox<String> comboBoxReports;
    private javax.swing.JPanel jChartDisplayJPanel;
    // End of variables declaration//GEN-END:variables
}
