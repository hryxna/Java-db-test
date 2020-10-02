package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String url = "jdbc:mysql://localhost:3306/contactsdb";
        String user = "root";
        String passwd = "root@123";

        Scanner scan = new Scanner(System.in);


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,passwd);
            Statement st = con.createStatement();

            System.out.println("Select the appropriate choice from below :");
            System.out.println("==========================================");

            System.out.println("1. Display All Contacts from Database.");
            System.out.println("2. Insert a contact to Database.");
            System.out.println("3. Modify a contact from Database.");
            System.out.println("4. Delete a contact from Database.");

            System.out.println("==========================================");

            int choice = scan.nextInt();

            String sqlq = null;


            switch (choice){
                case 1: sqlq = "SELECT * FROM contacts"; // sql query
                    break;
                case 2:
                    System.out.println("enter contact no.");
                        String contact = scan.next();
                    System.out.println("enter first-name");
                        String fname = scan.next();
                    System.out.println("enter middle-name");
                        String mname = scan.next();
                    System.out.println("enter last-name");
                        String lname = scan.next();

                        sqlq = "INSERT INTO contacts VALUES('"+contact+"','"+fname+"','"+mname+"','"+lname+"');";
                        //st.executeUpdate(sqlq);
                    PreparedStatement pst = con.prepareStatement(sqlq);
                    int val = pst.executeUpdate();
                    if(val>0){
                        System.out.println("Insertion Successfull");
                    }else {
                        System.out.println("Error Occurred");
                    }
                    break;
                default:System.out.println("no choice selected");
                break;
            }


            if(choice == 1){
                ResultSet rs = st.executeQuery(sqlq);
                while(rs.next()){
                    // any sql thing you want to retrieve
                    System.out.println(rs.getBigDecimal(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
                }
            }else if(choice == 2){
                ResultSet rs = st.executeQuery("SELECT * FROM contacts;");
                //rs.getMetaData();
            }


        } catch (SQLException | ClassNotFoundException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
