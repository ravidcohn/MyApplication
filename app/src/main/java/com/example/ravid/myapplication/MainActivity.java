package com.example.ravid.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    public static final String LISTEN_ACTIVITY = "listenActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testDB.testDB2();
    }

    public void testDB()  {

        TextView tv = (TextView)this.findViewById(R.id.textView);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.i("Android", " MySQL Connection ok");
           // Connection con = DriverManager.getConnection("jdbc:mysql://173.194.240.81:3306//database1?user=root");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306//database1?user=root");

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

            tv.setText(result);

        } catch (Exception e) {
            e.printStackTrace();
            tv.setText("Test Error:"+e.toString());
            Log.w("Android-system", "system get connection");
        }
    }

    public void getQuotes(View v) {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
