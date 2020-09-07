package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String url = "";
        String user = "root";
        String passwd = "root@123";

        try {
            Connection con = DriverManager.getConnection(url,user,passwd);
            Statement st = con.createStatement();
            String sqlq = ""; // sql query
            ResultSet rs = st.executeQuery(sqlq);

            while(rs.next()){
                // any sql thing you want to retrieve
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
