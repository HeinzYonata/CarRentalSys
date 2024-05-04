/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.database;

import com.mycompany.carrentalsys.domain.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heinz
 */
public class CarsDao {
    private String dbPath;
    private String user;
    private String pass;
    
    public CarsDao(String dbPath, String user, String pass) {
        this.dbPath = dbPath;
        this.user = user;
        this.pass = pass;
    }
    
    public void addHistory(int carId, boolean rentReturn) throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = 
                    "INSERT INTO history_tbl (car_id, rent_return, transaction_dateTime) " +
                    "VALUES " +
                    "(" + carId + ", " + rentReturn + ", NOW())";
            statement.execute(sql);
        }
    }
    
    public void clearHistory() throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = "DELETE FROM history_tbl";
            statement.execute(sql);
        }
    }
    
    public int getCarsCount() throws SQLException {
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement("SELECT COUNT(*) AS numberOfCars FROM car_tbl").executeQuery()){
            results.next();
            return results.getInt("numberOfCars");
        }
    }
    
    public List<String[]> getRentHistory() {
        List<String[]> historyRows = new ArrayList<>();
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement(
                        "SELECT car_tbl.id, car_tbl.model, history_tbl.rent_return, history_tbl.transaction_dateTime " +
                        "FROM history_tbl " +
                        "JOIN car_tbl ON car_tbl.id = history_tbl.car_id " +
                        "WHERE rent_return = false"
                ).executeQuery()){
            while (results.next()) {
                String[] historyRow = new String[4];
                historyRow[0] = results.getString("id");
                historyRow[1] = results.getString("model");
                historyRow[2] = results.getString("rent_return");
                historyRow[3] = results.getString("transaction_dateTime");
                historyRows.add(historyRow);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return historyRows;
    }
    
    public List<String[]> getReturnHistory() {
        List<String[]> historyRows = new ArrayList<>();
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement(
                        "SELECT car_tbl.id, car_tbl.model, history_tbl.rent_return, history_tbl.transaction_dateTime " +
                        "FROM history_tbl " +
                        "JOIN car_tbl ON car_tbl.id = history_tbl.car_id " +
                        "WHERE rent_return = true"
                ).executeQuery()){
            while (results.next()) {
                String[] historyRow = new String[4];
                historyRow[0] = results.getString("id");
                historyRow[1] = results.getString("model");
                historyRow[2] = results.getString("rent_return");
                historyRow[3] = results.getString("transaction_dateTime");
                historyRows.add(historyRow);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return historyRows;
    }
    
    public void setAvailability(int id, boolean availability) throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = "UPDATE car_tbl SET availability = " + (availability ? "true" : "false") + " WHERE id = " + id;
            statement.execute(sql);
        }
    }
    
    public Car getCar(int idParam) throws SQLException {
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement("SELECT * FROM car_tbl WHERE id = " + idParam).executeQuery()){
            results.next();

            int id = results.getInt("id");
            String model = results.getString("model");
            int year = results.getInt("year_manufactured");
            boolean status = results.getBoolean("availability");
            double fee = results.getDouble("fee");
            return new Car(id, model, year, status, fee);
            
        }
    }
    
    public void updateCar(Car car) throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = 
                    "UPDATE car_tbl " +
                    "SET " +
                    "model = '" + car.getModel() + "', " +
                    "year_manufactured = " + car.getYear() + ", " +
                    "availability = " + (car.isAvailable() ? "true" : "false") + ", " +
                    "fee = " + car.getRentalFee() + " " +
                    "WHERE id = " + car.getId();
            statement.execute(sql);
        }
    }
    
    public void addCar(Car car) throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = 
                    "INSERT INTO car_tbl (model, year_manufactured, availability, fee) " +
                    "VALUES " +
                    "('" + car.getModel() + "', " + car.getYear() + ", " + car.isAvailable() + ", " + car.getRentalFee() + ")";
            statement.execute(sql);
        }
    }
    
    public void deleteCar(int id) throws SQLException {
        try (Connection conn = createConnection();
                Statement statement = conn.createStatement()){
            String sql = "DELETE FROM car_tbl WHERE id = " + id;
            statement.execute(sql);
        }
    }
    
    public List<Car> getAvailables() {
        List<Car> car_tbl = new ArrayList<>();
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement(
                        "SELECT * FROM car_tbl " +
                        "WHERE availability = true"
                ).executeQuery()){
            while (results.next()) {
                int id = results.getInt("id");
                String model = results.getString("model");
                int year = results.getInt("year_manufactured");
                boolean status = results.getBoolean("availability");
                double fee = results.getDouble("fee");
                car_tbl.add(new Car(id, model, year, status, fee));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return car_tbl;
    }
    
    public List<Car> getUnavailables() {
        List<Car> car_tbl = new ArrayList<>();
        try (Connection conn = createConnection();
                ResultSet results = conn.prepareStatement(
                        "SELECT * FROM car_tbl " +
                        "WHERE availability = false"
                ).executeQuery()){
            while (results.next()) {
                int id = results.getInt("id");
                String model = results.getString("model");
                int year = results.getInt("year_manufactured");
                boolean status = results.getBoolean("availability");
                double fee = results.getDouble("fee");
                car_tbl.add(new Car(id, model, year, status, fee));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return car_tbl;
    }
    
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(dbPath, user, pass);
    }
}
