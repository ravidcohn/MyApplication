package com.example.ravid.myapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


/**
 * Created by Ravid on 22/09/2015.
 */
public class testDB {
    public static void testDB2(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.i("Android", " MySQL Connection ok");
            // Connection con = DriverManager.getConnection("jdbc:mysql://173.194.240.81:3306//database1?user=root");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306//database1?user=root");

            //         System.out.println("Database connection success");
            Log.d("Android2","Line 2");
            String result = "";
            Log.d("Android3", " Line 3");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student");

            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.w("Android-system", "system get connection");
        }
    }
}
