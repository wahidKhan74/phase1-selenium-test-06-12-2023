package com.simplilearn.seleniumtest.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class demonstrate jdbc call.
 * 
 * @author khanw
 *
 */
public class JDBCTest {

	// data source properties
	private final static String DB_URL = "jdbc:mysql://localhost:3306/estore_zone_db";
	private final static String DB_USR = "newdevuser";
	private final static String DB_PAS = "DevUser!74";

	static Connection connection = null;
	static Statement statment = null;
	static ResultSet rst;

	public static void main(String[] args) {
		
		try {
			// step1 : Register Driver (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Register Driver class.");

			// step2 : Create a connection
			connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PAS);
			System.out.println("2. Connection is created.");

			// step3 : Create a statement
			statment = connection.createStatement();
			System.out.println("3. Statement is created.");

			// step4 : Execute query
			String query = "select * from eproducts;";
			rst = statment.executeQuery(query);
			while (rst.next()) {
			     System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"  "+rst.getString(3));  
			}
			System.out.println("4. Query is executed.");

		} catch (ClassNotFoundException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		} finally {
			// clean up
			try {
				// step5 : close connection
				rst.close();
				statment.close();
				connection.close();
				System.out.println("5. Closing the connection.");
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
			}

		}
	}
}
