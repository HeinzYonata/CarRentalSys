/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.About;
import javax.swing.JFrame;

/**
 *
 * @author heinz
 */
public class DialogAbout extends javax.swing.JDialog {
    
    public DialogAbout(JFrame parent) {
        super(parent);
        PanelAbout panel = new PanelAbout();
        panel.setVisible(true);
        this.setSize(panel.getPreferredSize());
        this.getContentPane().add(panel);
        
        this.setTitle("About");
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }
}
