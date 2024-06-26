/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.carrentalsys.ui.updateEntry;

import com.mycompany.carrentalsys.database.CarsDao;
import com.mycompany.carrentalsys.domain.Car;
import com.mycompany.carrentalsys.ui.helpers.IconFactory;
import com.mycompany.carrentalsys.ui.helpers.Helpers;
import com.mycompany.carrentalsys.ui.MainGUI;
import com.mycompany.carrentalsys.ui.helpers.CurrencyCellRenderer;
import com.mycompany.carrentalsys.ui.helpers.StatusCellRenderer;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
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
public class PanelUpdateEntry extends javax.swing.JPanel {
    
    private int selectedID;
    private CarsDao database;
    private TableRowSorter tableRowSorter;
    private MainGUI mainGUI;

    public PanelUpdateEntry(JFrame parent, CarsDao db) {
        this.database = db;
        this.mainGUI = (MainGUI)parent;
        
        initComponents();
        initVisuals();
        setFormNothingSelected();
        
        addAvailableUnavailable();
        
        carTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(e.getValueIsAdjusting()) {
                return;
            }
            
            int[] selectedRows = carTable.getSelectedRows();
            if (selectedRows.length == 1) {
                selectedID = Integer.parseInt(carTable.getValueAt(selectedRows[0], 0).toString());
                changeFieldValues();
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
                btnSave.setEnabled(false);
            } else if (selectedRows.length > 1) {
                setFormNothingSelected();
                btnDelete.setEnabled(true);
            } else {
                setFormNothingSelected();
            }
            allowAccessFields(false);
        });
        
        // create row sorter
        this.tableRowSorter = new TableRowSorter(this.carTable.getModel());
        this.carTable.setRowSorter(this.tableRowSorter);
        
        //sort initially
        ArrayList<RowSorter.SortKey> list = new ArrayList<>();
        list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
        this.tableRowSorter.setSortKeys(list);
        this.tableRowSorter.sort();
        
        // format currency column
        this.carTable.getColumnModel().getColumn(4).setCellRenderer(new CurrencyCellRenderer());
        
        // format status column
        this.carTable.getColumnModel().getColumn(3).setCellRenderer(new StatusCellRenderer());
    }
    
    private void setFormNothingSelected() {
        allowAccessFields(false);
        clearFields();
        selectedID = -1;
        initButtons();
        cmbStatus.removeAllItems();
    }
    
    // initial enability of buttons
    private void initButtons() {
        this.btnSave.setEnabled(false);
        this.btnEdit.setEnabled(false);
        this.btnDelete.setEnabled(false);
    }
    
    private void populateStatus() {
        cmbStatus.addItem("Available");
        cmbStatus.addItem("Unavailable");
    }
    
    // change field values depending on the selected cars
    private void changeFieldValues() {
        try {
            Car car = database.getCar(selectedID);
            txtFieldModel.setText(car.getModel());
            txtFieldYear.setText(car.getYear() + "");
            cmbStatus.removeAllItems();
            populateStatus();
            
            if (car.isAvailable()) {
                cmbStatus.setSelectedIndex(0);
            } else {
                cmbStatus.setSelectedIndex(1);
            }
            
            txtFieldFee.setText(car.getRentalFee() + "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // set wether to enable text fields or not
    private void allowAccessFields(boolean isAllowed) {
        txtFieldModel.setEnabled(isAllowed);
        txtFieldYear.setEnabled(isAllowed);
        cmbStatus.setEnabled(isAllowed);
        txtFieldFee.setEnabled(isAllowed);
    }
    
    private void clearFields() {
        txtFieldModel.setText("");
        txtFieldYear.setText("");
        txtFieldFee.setText("");
    }

    // add available and unavailable cars to the table depending on the checkboxes
    private void addAvailableUnavailable() {
        
        //clear table
        DefaultTableModel model = (DefaultTableModel)this.carTable.getModel();
        model.setRowCount(0);
        
        if (this.chckBoxAvailable.isSelected()) {
            Helpers.populateTable(this.database.getAvailables(), this.carTable);
        }
        
        if (this.chckBoxUnavailable.isSelected()) {
            Helpers.populateTable(this.database.getUnavailables(), this.carTable);
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
        carTable = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        rightCenter = new javax.swing.JPanel();
        fieldsGroup = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFieldModel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelFee = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFieldYear = new javax.swing.JTextField();
        txtFieldFee = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fieldSearch = new javax.swing.JTextField();
        btnsGroup = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        chckBoxes = new javax.swing.JPanel();
        chckBoxAvailable = new javax.swing.JCheckBox();
        chckBoxUnavailable = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Year", "Status", "Fee/Day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carTable.setFocusable(false);
        carTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        carTable.setShowGrid(true);
        carTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(0).setMinWidth(35);
            carTable.getColumnModel().getColumn(0).setPreferredWidth(35);
            carTable.getColumnModel().getColumn(1).setMinWidth(150);
            carTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        right.setMaximumSize(new java.awt.Dimension(320, 400));
        right.setPreferredSize(new java.awt.Dimension(320, 400));
        right.setLayout(new java.awt.BorderLayout());

        rightCenter.setMinimumSize(new java.awt.Dimension(320, 400));
        rightCenter.setPreferredSize(new java.awt.Dimension(320, 400));

        jLabel1.setText("Model:");

        txtFieldModel.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel2.setText("Year:");

        labelFee.setText("Fee/Day:");

        jLabel5.setText("Status:");

        txtFieldYear.setMaximumSize(new java.awt.Dimension(64, 22));

        cmbStatus.setMaximumSize(new java.awt.Dimension(64, 22));
        cmbStatus.setMinimumSize(new java.awt.Dimension(64, 22));
        cmbStatus.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Search:");

        fieldSearch.setMaximumSize(new java.awt.Dimension(64, 22));
        fieldSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fieldSearchCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout fieldsGroupLayout = new javax.swing.GroupLayout(fieldsGroup);
        fieldsGroup.setLayout(fieldsGroupLayout);
        fieldsGroupLayout.setHorizontalGroup(
            fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsGroupLayout.createSequentialGroup()
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fieldsGroupLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fieldsGroupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(labelFee)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFieldYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFieldFee)
                            .addComponent(cmbStatus, 0, 152, Short.MAX_VALUE)
                            .addComponent(txtFieldModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fieldsGroupLayout.setVerticalGroup(
            fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFee)
                    .addComponent(txtFieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsGroup.setMaximumSize(new java.awt.Dimension(320, 178));
        btnsGroup.setPreferredSize(new java.awt.Dimension(320, 178));

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        btnsGroup.add(btnEdit);

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnsGroup.add(btnSave);

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnsGroup.add(btnDelete);

        chckBoxAvailable.setSelected(true);
        chckBoxAvailable.setText("Available");
        chckBoxAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxAvailableActionPerformed(evt);
            }
        });
        chckBoxes.add(chckBoxAvailable);

        chckBoxUnavailable.setSelected(true);
        chckBoxUnavailable.setText("Unavailable");
        chckBoxUnavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxUnavailableActionPerformed(evt);
            }
        });
        chckBoxes.add(chckBoxUnavailable);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EDIT RECORD");

        javax.swing.GroupLayout rightCenterLayout = new javax.swing.GroupLayout(rightCenter);
        rightCenter.setLayout(rightCenterLayout);
        rightCenterLayout.setHorizontalGroup(
            rightCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldsGroup, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(chckBoxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightCenterLayout.setVerticalGroup(
            rightCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightCenterLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chckBoxes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        right.add(rightCenter, java.awt.BorderLayout.LINE_END);

        add(right, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String model = txtFieldModel.getText().trim();      
        int year;
        boolean availability = cmbStatus.getSelectedIndex() == 0;
        double fee;
        
        try {
            year = Integer.parseInt(txtFieldYear.getText().trim());
            
            //prevents negative year
            if (year < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid year",
                    "Invalid input",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            fee = Double.parseDouble(txtFieldFee.getText().trim());
            fee = Math.floor(fee * 100) / 100;
            
            //prevents negative fee
            if (fee < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Please enter a valid fee value",
                    "Invalid input",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Car car = new Car(selectedID, model, year, availability, fee);
        try {
            this.database.updateCar(car);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        addAvailableUnavailable();
        //update data in the main GUI
        this.mainGUI.addAvailableUnavailable();
        setFormNothingSelected();
        JOptionPane.showMessageDialog(this, "Successfully edited!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        allowAccessFields(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "This will also delete the associated history.\nAre you sure?", "WARNING!", JOptionPane.YES_NO_OPTION);
        
        if (choice == 1) {
            return;
        }
        
        int[] selectedRows = carTable.getSelectedRows();
        try {
            if (selectedRows.length > 1) {
                for (int row : selectedRows) {
                    this.database.deleteCar(Integer.parseInt(carTable.getValueAt(row, 0).toString()));
                }
            } else {
                this.database.deleteCar(selectedID);
            }
            
            addAvailableUnavailable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        setFormNothingSelected();
        //update data in the main GUI
        this.mainGUI.addAvailableUnavailable();
        JOptionPane.showMessageDialog(this, "Successfully deleted!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void chckBoxAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxAvailableActionPerformed
        addAvailableUnavailable();
        setFormNothingSelected();
        carTable.clearSelection();
    }//GEN-LAST:event_chckBoxAvailableActionPerformed

    private void chckBoxUnavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxUnavailableActionPerformed
        addAvailableUnavailable();
        setFormNothingSelected();
        carTable.clearSelection();
    }//GEN-LAST:event_chckBoxUnavailableActionPerformed

    private void fieldSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldSearchCaretUpdate
        String search = fieldSearch.getText();
        this.tableRowSorter.setRowFilter(Helpers.generateSearchFilter(search));
        setFormNothingSelected();
        carTable.clearSelection();
    }//GEN-LAST:event_fieldSearchCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel btnsGroup;
    private javax.swing.JTable carTable;
    private javax.swing.JCheckBox chckBoxAvailable;
    private javax.swing.JCheckBox chckBoxUnavailable;
    private javax.swing.JPanel chckBoxes;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JPanel fieldsGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFee;
    private javax.swing.JPanel right;
    private javax.swing.JPanel rightCenter;
    private javax.swing.JTextField txtFieldFee;
    private javax.swing.JTextField txtFieldModel;
    private javax.swing.JTextField txtFieldYear;
    // End of variables declaration//GEN-END:variables

    private void initVisuals() {
        this.btnDelete.setIcon(IconFactory.getBtnIconDelete());
        this.btnEdit.setIcon(IconFactory.getBtnIconEdit());
        this.btnSave.setIcon(IconFactory.getBtnIconSave());
        this.labelFee.setText("Fee/Day: " + (char)8369);
    }
}
