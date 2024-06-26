/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.history;

import com.mycompany.carrentalsys.database.CarsDao;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogHistory extends javax.swing.JDialog {
    
    public DialogHistory(JFrame parent, CarsDao db) {
        super(parent);
        PanelHistory panel = new PanelHistory(db);
        panel.setVisible(true);
        this.setMinimumSize(new Dimension(600, 300));
        this.getContentPane().add(panel);
        
        // Pack the dialog to fit its content
        this.pack();

        // Set location relative to parent
        this.setLocationRelativeTo(parent);
        
        this.setTitle("History");
        this.setModal(true);
        this.setVisible(true);
    }
}
