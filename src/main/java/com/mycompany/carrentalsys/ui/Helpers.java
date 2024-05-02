/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui;

import com.mycompany.carrentalsys.domain.Car;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heinz
 */
public class Helpers {
    
    public static void populateTable(List<Car> list, JTable table) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        list.stream().forEach(car -> {
            String status = car.isAvailable() ? "Available" : "Unavailable";
            model.addRow(new Object[] {car.getId(), car.getModel(), car.getYear(), status, car.getRentalFee()});
        });
    }
    
    public static void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
    }
    
    public static RowFilter generateSearchFilter(String search) {
        return new RowFilter() {
            private String searchTxt = search.toLowerCase();
            
            @Override
            public boolean include(RowFilter.Entry entry) {
                return entry.getStringValue(1).toLowerCase().contains(searchTxt);
            }
        };
    }
}
