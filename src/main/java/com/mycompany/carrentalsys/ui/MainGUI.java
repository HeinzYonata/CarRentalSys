/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carrentalsys.ui;

import com.mycompany.carrentalsys.ui.helpers.Helpers;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mycompany.carrentalsys.database.CarsDao;
import com.mycompany.carrentalsys.domain.Car;
import com.mycompany.carrentalsys.ui.about.DialogAbout;
import com.mycompany.carrentalsys.ui.addEntry.DialogAddEntry;
import com.mycompany.carrentalsys.ui.helpers.CurrencyCellRenderer;
import com.mycompany.carrentalsys.ui.helpers.IconFactory;
import com.mycompany.carrentalsys.ui.helpers.StatusCellRenderer;
import com.mycompany.carrentalsys.ui.history.DialogHistory;
import com.mycompany.carrentalsys.ui.updateEntry.DialogUpdateEntry;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author heinz
 */
public class MainGUI extends javax.swing.JFrame {
    /**
     * Creates new form MainUI
     */
    private int selectedId;
    private CarsDao database;
    private TableRowSorter tableRowSorter;
    
    public MainGUI(CarsDao database) {
        initComponents();
        initVisuals();
        this.database = database;
        
        selectedId = -1;
        btnRent.setEnabled(false);
        btnReturn.setEnabled(false);
        
        addAvailableUnavailable();
        
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(e.getValueIsAdjusting()) {
                return;
            }
            
            int selectedRow = carTable.getSelectedRow();
            if (selectedRow != -1) {
                selectedId = Integer.parseInt(carTable.getValueAt(selectedRow, 0).toString());
            } else {
                selectedId = -1;
            }
            updateButtonAccess();
        });

        // create row sorter
        this.tableRowSorter = new TableRowSorter(this.carTable.getModel());
        this.carTable.setRowSorter(this.tableRowSorter);
        
        //sort initially
        ArrayList<RowSorter.SortKey> list = new ArrayList<>();
        list.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        this.tableRowSorter.setSortKeys(list);
        this.tableRowSorter.sort();
        
        // set focus to jframe at start
        this.getContentPane().requestFocusInWindow();
        
        //center to screen
        setLocationRelativeTo(null);
        
        // format currency column
        this.carTable.getColumnModel().getColumn(4).setCellRenderer(new CurrencyCellRenderer());
        
        // format status column
        this.carTable.getColumnModel().getColumn(3).setCellRenderer(new StatusCellRenderer());
        
    }
    
    // add available and unavailable cars to the table depending on the checkboxes
    public void addAvailableUnavailable() {
        
        //clear table
        DefaultTableModel model = (DefaultTableModel)this.carTable.getModel();
        model.setRowCount(0);
        
        if (this.chckBoxAvailable.isSelected()) {
            Helpers.populateTable(this.database.getAvailables(), this.carTable);
        }
        
        if (this.chckBoxUnavailable.isSelected()) {
            Helpers.populateTable(this.database.getUnavailables(), this.carTable);
        }
        
        try {
            this.labelCarsCount.setText("Total cars: " + this.database.getCarsCount());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // turn on/off rent and return
    private void updateButtonAccess() {
        if (selectedId == -1) {
            btnRent.setEnabled(false);
            btnReturn.setEnabled(false);
            return;
        }
        
        try {
            // turn on return button when car is not available, else off
            if (database.getCar(selectedId).isAvailable()) {
                btnReturn.setEnabled(false);
            } else {
                btnReturn.setEnabled(true);
            }
            
            // turn on rent button when car is available, else off
            if (!database.getCar(selectedId).isAvailable()) {
                btnRent.setEnabled(false);
            } else {
                btnRent.setEnabled(true);
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

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        filterGroup = new javax.swing.JPanel();
        chckBoxUnavailable = new javax.swing.JCheckBox();
        chckBoxAvailable = new javax.swing.JCheckBox();
        buttonGroup = new javax.swing.JPanel();
        btnRent = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        labelCarsCount = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuManage = new javax.swing.JMenu();
        subMenuEdit = new javax.swing.JMenuItem();
        subMenuAdd = new javax.swing.JMenuItem();
        menuHistory = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 450));

        header.setMaximumSize(new java.awt.Dimension(32767, 50));
        header.setPreferredSize(new java.awt.Dimension(800, 70));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAR RENTAL MANAGER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 55, 55));
        jLabel2.setText("Search:");

        fieldSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(800, 400));

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Year", "Status", "Fee/Day "
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
        carTable.setShowGrid(true);
        carTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            carTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        footer.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        footer.setPreferredSize(new java.awt.Dimension(10, 60));
        footer.setLayout(new java.awt.BorderLayout());

        filterGroup.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        chckBoxUnavailable.setSelected(true);
        chckBoxUnavailable.setText("Unavailable");
        chckBoxUnavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxUnavailableActionPerformed(evt);
            }
        });
        filterGroup.add(chckBoxUnavailable);

        chckBoxAvailable.setSelected(true);
        chckBoxAvailable.setText("Available");
        chckBoxAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckBoxAvailableActionPerformed(evt);
            }
        });
        filterGroup.add(chckBoxAvailable);

        footer.add(filterGroup, java.awt.BorderLayout.EAST);

        buttonGroup.setMinimumSize(new java.awt.Dimension(350, 32));
        buttonGroup.setPreferredSize(new java.awt.Dimension(350, 428));
        buttonGroup.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        btnRent.setText("Rent");
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });
        buttonGroup.add(btnRent);

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        buttonGroup.add(btnReturn);

        labelCarsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCarsCount.setText("Total cars: ");
        labelCarsCount.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        buttonGroup.add(labelCarsCount);

        footer.add(buttonGroup, java.awt.BorderLayout.WEST);

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        menuManage.setText("Manage");
        menuManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuManageMouseClicked(evt);
            }
        });

        subMenuEdit.setText("Edit cars");
        subMenuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuEditActionPerformed(evt);
            }
        });
        menuManage.add(subMenuEdit);

        subMenuAdd.setText("Add cars");
        subMenuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAddActionPerformed(evt);
            }
        });
        menuManage.add(subMenuAdd);

        jMenuBar1.add(menuManage);

        menuHistory.setText("History");
        menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHistoryMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuHistory);

        menuAbout.setText("About");
        menuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAboutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentActionPerformed
        try {
            Car selectedCar = database.getCar(selectedId);
            database.setAvailability(selectedId, false);
                        
            // add to history
            database.addHistory(selectedId, false);
            // update table
            addAvailableUnavailable();
            
            JOptionPane.showMessageDialog(this, 
                    "Successfully rented \"" + selectedCar.getModel() +"\"!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRentActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        String input = JOptionPane.showInputDialog(this, "Number of days the car was used:", "Returning car", JOptionPane.PLAIN_MESSAGE);
        
        double days;
        
        try {
            days = Integer.parseInt(input);
            if (days < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Please enter a valid number", 
                    "Invalid input", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Car selectedCar = database.getCar(selectedId);
            double totalFee = (days == 0 ? selectedCar.getRentalFee() : days * selectedCar.getRentalFee());
            // truncate to nearest hundredths
            totalFee = Math.floor(totalFee * 100) / 100;
            
            database.setAvailability(selectedId, true);
            // add to history
            database.addHistory(selectedId, true);
            // update table
            addAvailableUnavailable();
            
            JOptionPane.showMessageDialog(this, 
                    "Successfully returned \"" + 
                    selectedCar.getModel() + 
                    "\"!\n\nTotal fee: " + Helpers.toPeso(totalFee),
                    "Returned",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }//GEN-LAST:event_btnReturnActionPerformed

    private void menuManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuManageMouseClicked

        
    }//GEN-LAST:event_menuManageMouseClicked

    private void subMenuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuEditActionPerformed
        new DialogUpdateEntry(this, database);
        addAvailableUnavailable();
    }//GEN-LAST:event_subMenuEditActionPerformed

    private void subMenuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAddActionPerformed
        new DialogAddEntry(this, database);
        addAvailableUnavailable();
    }//GEN-LAST:event_subMenuAddActionPerformed

    private void fieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyReleased
        String search = fieldSearch.getText();
        this.tableRowSorter.setRowFilter(Helpers.generateSearchFilter(search));
    }//GEN-LAST:event_fieldSearchKeyReleased

    private void chckBoxAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxAvailableActionPerformed
        addAvailableUnavailable();
    }//GEN-LAST:event_chckBoxAvailableActionPerformed

    private void chckBoxUnavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckBoxUnavailableActionPerformed
        addAvailableUnavailable();
    }//GEN-LAST:event_chckBoxUnavailableActionPerformed

    private void menuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseClicked
        new DialogAbout(this);
    }//GEN-LAST:event_menuAboutMouseClicked

    private void menuHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHistoryMouseClicked
        new DialogHistory(this, database); 
    }//GEN-LAST:event_menuHistoryMouseClicked

    
    public static void start(CarsDao database) {
        FlatLaf.registerCustomDefaultsSource("style");
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI(database).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRent;
    private javax.swing.JButton btnReturn;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JTable carTable;
    private javax.swing.JCheckBox chckBoxAvailable;
    private javax.swing.JCheckBox chckBoxUnavailable;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JPanel filterGroup;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCarsCount;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuHistory;
    private javax.swing.JMenu menuManage;
    private javax.swing.JMenuItem subMenuAdd;
    private javax.swing.JMenuItem subMenuEdit;
    // End of variables declaration//GEN-END:variables

    private void initVisuals() {
        URL iconPath = this.getClass().getResource("/images/wheelIcon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(iconPath);  
        this.setIconImage(icon);  
        
        this.btnRent.setIcon(IconFactory.getBtnIconRent());
        this.btnReturn.setIcon(IconFactory.getBtnIconReturn());
        
        this.subMenuEdit.setIcon(IconFactory.getBtnIconEdit());
        this.subMenuAdd.setIcon(IconFactory.getBtnIconAdd());
        
        this.menuManage.setIcon(IconFactory.getMenuIconManage());
        this.menuHistory.setIcon(IconFactory.getMenuIconHistory());
        this.menuAbout.setIcon(IconFactory.getMenuIconAbout());
        
        this.footer.setBorder(new EmptyBorder(5, 40, 5, 40));
    }
}
