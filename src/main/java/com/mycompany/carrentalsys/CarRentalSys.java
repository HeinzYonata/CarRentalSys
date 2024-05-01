/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carrentalsys;

import com.mycompany.carrentalsys.database.CarsDao;
import com.mycompany.carrentalsys.ui.MainGUI;

/**
 *
 * @author heinz
 */
public class CarRentalSys {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/carsdb";
        String user = "root";
        String pass = "panzer";
        CarsDao database = new CarsDao(dbUrl, user, pass);
        
        MainGUI.start(database);
    }
}
