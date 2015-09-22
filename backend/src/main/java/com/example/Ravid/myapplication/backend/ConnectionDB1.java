package com.example.Ravid.myapplication.backend;

/**
 * Created by Ravid on 21/09/2015.
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class ConnectionDB1 {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                            "user=minty&password=greatsqldb");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}