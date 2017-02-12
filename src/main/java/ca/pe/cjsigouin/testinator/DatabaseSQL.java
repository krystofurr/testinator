/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator;

/**
 *
 * @author krystofurr
 */
public class DatabaseSQL {
    
    private final static String TABLE_RESTAURANTS = "restaurants";
    
    public static String createRestaurants() {
        
        return "CREATE TABLE " + TABLE_RESTAURANTS + 
               "(" +
               "id INT NOT NULL AUTO_INCREMENT," +
               "restName VARCHAR(255)," +
               "cityName VARCHAR(255)" +
               ")" +
               "PRIMARY KEY (ID)";
    }
    
}
