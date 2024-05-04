/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.helpers;

/**
 *
 * @author heinz
 */
import javax.swing.*;
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;

public class CurrencyCellRenderer extends DefaultTableCellRenderer {

  public CurrencyCellRenderer() {
    super();
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    if (!(value instanceof Number)) {
        value = 0;
    }
    
    setText(Helpers.toPeso((double)value));

    return this;
  }
}

