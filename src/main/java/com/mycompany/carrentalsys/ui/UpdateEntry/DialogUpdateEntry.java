/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.UpdateEntry;

import com.mycompany.carrentalsys.database.CarsDao;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogUpdateEntry extends javax.swing.JDialog {
    
    public DialogUpdateEntry(JFrame parent, CarsDao db) {
        super(parent);
        PanelUpdateEntry panel = new PanelUpdateEntry(db);
        panel.setVisible(true);
        this.setSize(panel.getPreferredSize());
        this.getContentPane().add(panel);
        
        this.setTitle("Editor");
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }
}
