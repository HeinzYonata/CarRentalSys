/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.AddEntry;

import com.mycompany.carrentalsys.database.CarsDao;
import com.mycompany.carrentalsys.ui.MainGUI;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogAddEntry extends javax.swing.JDialog {
    
    public DialogAddEntry(JFrame parent, CarsDao db) {
        super(parent);
        PanelAddEntry panel = new PanelAddEntry(db, (MainGUI)parent);
        panel.setVisible(true);
        this.setSize(panel.getPreferredSize());
        this.getContentPane().add(panel);
        
        this.setTitle("Add");
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }
}
