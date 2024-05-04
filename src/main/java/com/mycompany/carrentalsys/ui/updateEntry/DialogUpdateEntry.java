/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.updateEntry;

import com.mycompany.carrentalsys.database.CarsDao;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogUpdateEntry extends javax.swing.JDialog {
    
    public DialogUpdateEntry(JFrame parent, CarsDao db) {
        super(parent);
        PanelUpdateEntry panel = new PanelUpdateEntry(parent, db);
        panel.setVisible(true);
        this.setMinimumSize(new Dimension(700, 500));
        this.getContentPane().add(panel);
        
        // Pack the dialog to fit its content
        this.pack();

        // Set location relative to parent
        this.setLocationRelativeTo(parent);
        
        this.setTitle("Editor");
        this.setModal(true);
        this.setVisible(true);
    }
}
