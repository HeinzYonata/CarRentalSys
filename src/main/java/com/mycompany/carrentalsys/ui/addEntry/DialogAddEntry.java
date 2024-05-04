/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.addEntry;

import com.mycompany.carrentalsys.database.CarsDao;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogAddEntry extends javax.swing.JDialog {
    
    public DialogAddEntry(JFrame parent, CarsDao db) {
        super(parent);
        PanelAddEntry panel = new PanelAddEntry(parent, db);
        panel.setVisible(true);
        this.getContentPane().add(panel);
        
        // Pack the dialog to fit its content
        this.pack();

        // Set location relative to parent
        this.setLocationRelativeTo(parent);
        
        this.setTitle("Add");
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }
}
