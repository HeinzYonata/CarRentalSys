/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.carrentalsys.ui.History;

import com.mycompany.carrentalsys.database.CarsDao;
import com.mycompany.carrentalsys.ui.Helpers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author heinz
 */
public class PanelHistory extends javax.swing.JPanel {
    
    private int selectedID;
    private CarsDao database;
    private TableRowSorter tableRowSorter;
    
    public PanelHistory(CarsDao db) {
        this.database = db;
        initComponents();        
        addRentReturn();
                
        carTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(e.getValueIsAdjusting()) {
                return;
            }
            
            int[] selectedRows = carTable.getSelectedRows();
            if (selectedRows.length == 1) {
                selectedID = Integer.parseInt(carTable.getValueAt(selectedRows[0], 0).toString());
                btnDelete.setEnabled(true);
            } else if (selectedRows.length > 1) {
                btnDelete.setEnabled(true);
            } else {
            }
        });
        
        // create row sorter
        this.tableRowSorter = new TableRowSorter(this.carTable.getModel());
        this.carTable.setRowSorter(this.tableRowSorter);
        
        //sort initially
        ArrayList<RowSorter.SortKey> list = new ArrayList<>();
        list.add( new RowSorter.SortKey(3, SortOrder.DESCENDING) );
        this.tableRowSorter.setSortKeys(list);
        this.tableRowSorter.sort();
    }
    
    // initial enability of buttons
    private void initButtons() {
        this.btnDelete.setEnabled(false);
    }

    // add available and unavailable cars to the table depending on the checkboxes
    private void addRentReturn() {
        
        //clear table
        DefaultTableModel model = (DefaultTableModel)this.carTable.getModel();
        model.setRowCount(0);
        
        if (this.chckBoxAvailable.isSelected()) {
            populateTable(database.getRentHistory());
        }
        
        if (this.chckBoxUnavailable.isSelected()) {
            populateTable(database.getReturnHistory());
        }
    }
    
    public void populateTable(List<String[]> rows) {
        DefaultTableModel model = (DefaultTableModel) this.carTable.getModel();
        
        rows.stream().forEach(row -> {
            String transactionType = Integer.parseInt(row[2]) == 0 ? "Rented" : "Returned";
            model.addRow(new Object[] {row[0], row[1], transactionType, row[3]});
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        bottom = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        chckBoxAvailable = new javax.swing.JCheckBox();
        chckBoxUnavailable = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(700, 450));
        setLayout(new java.awt.BorderLayout());

        top.setMinimumSize(new java.awt.Dimension(800, 70));
        top.setPreferredSize(new java.awt.Dimension(800, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 55, 55));
        jLabel2.setText("Search:");

        fieldSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fieldSearchCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSACTION HISTORY");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14))
        );

        add(top, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 400));

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID", "Model", "Transaction type", "Date and Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carTable.setFocusable(false);
        carTable.setMinimumSize(new java.awt.Dimension(600, 250));
        carTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        carTable.setShowGrid(true);
        carTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(0).setMinWidth(15);
            carTable.getColumnModel().getColumn(0).setPreferredWidth(15);
            carTable.getColumnModel().getColumn(1).setMinWidth(150);
            carTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            carTable.getColumnModel().getColumn(3).setMinWidth(200);
            carTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bottom.setMaximumSize(new java.awt.Dimension(32767, 80));
        bottom.setMinimumSize(new java.awt.Dimension(100, 60));
        bottom.setPreferredSize(new java.awt.Dimension(100, 60));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Clear History");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        bottom.add(btnDelete);

        chckBoxAvailable.setSelected(true);
        chckBoxAvailable.setText("Rents");
        chckBoxAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxAvailableActionPerformed(evt);
            }
        });
        bottom.add(chckBoxAvailable);

        chckBoxUnavailable.setSelected(true);
        chckBoxUnavailable.setText("Returns");
        chckBoxUnavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxUnavailableActionPerformed(evt);
            }
        });
        bottom.add(chckBoxUnavailable);

        add(bottom, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "This will clear all history.\nAre you sure?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
     
        if (choice == 1) {
            return;
        }
        
        try {
            database.clearHistory();
            addRentReturn();
            JOptionPane.showMessageDialog(this, "Successfully cleared!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void chckBoxAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxAvailableActionPerformed
        addRentReturn();
        carTable.clearSelection();
    }//GEN-LAST:event_chckBoxAvailableActionPerformed

    private void chckBoxUnavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxUnavailableActionPerformed
        addRentReturn();
        carTable.clearSelection();
    }//GEN-LAST:event_chckBoxUnavailableActionPerformed

    private void fieldSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldSearchCaretUpdate
        String search = fieldSearch.getText();
        this.tableRowSorter.setRowFilter(Helpers.generateSearchFilter(search));
        this.carTable.clearSelection();
    }//GEN-LAST:event_fieldSearchCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTable carTable;
    private javax.swing.JCheckBox chckBoxAvailable;
    private javax.swing.JCheckBox chckBoxUnavailable;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
