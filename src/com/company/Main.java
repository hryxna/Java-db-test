package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String url = "jdbc:mysql://localhost:3306/contactsdb";
        String user = "root";
        String passwd = "root@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,passwd);
            Statement st = con.createStatement();
            String sqlq = "SELECT * FROM contacts"; // sql query
            ResultSet rs = st.executeQuery(sqlq);

            while(rs.next()){
                // any sql thing you want to retrieve
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }

        } catch (SQLException | ClassNotFoundException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
