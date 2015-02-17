package com.project1.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project1.model.*;

public class ManagmentDB extends Db{

	String sUrlString = "jdbc:sqlite:FacMgmt.db";
	
	
	
	String call = null;
	
	public ManagmentDB()throws Exception{} 
	
	public ManagmentDB(String sDriverKey, String sUrlKey) throws Exception{
		init(sDriverKey, sUrlKey);
		
		if (conn != null) {
			System.out.println("You have a database connection!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	ManagmentDB mydb = new ManagmentDB("org.sqlite.JDBC",sUrlString);
	public ResultSet executeDBCall(String call)
	{
		ResultSet response = null;
		try
		{
			response = statement.executeQuery(call);
		}
	    catch (SQLException se) {}
		return response;
	}
	
//	public String buildDBCall(String command, String param, String table, String columns, String specifier, String values, String condition)
//	{		
//		switch (command) {
//		//INSERT INTO TABLE_NAME (column1, column2, column3,...columnN)] VALUES (value1, value2, value3,...valueN);
//	        case "INSERT": 		
//	        	call = "INSERT INTO " + table + " " + columns + " " + values + ";";
//	        	break;
//	        	
//	        //SELECT column1, column2, columnN FROM table_name;
//	        case "SELECT": 
//	        	call = "SELECT " + columns + " FROM " + table + ";";
//	        	break;
//	        
//	        //UPDATE table_name SET column1 = value1, column2 = value2...., columnN = valueN WHERE [condition];
//	        case "UPDATE": //updates one value!
//	        	call = "UPDATE " + table + " SET " + columns + " = " + values + " WHERE " + condition + ";";
//	        	break;
//        	
//        	//CREATE TABLE facilities
//	        case "CREATE":
//	        	call = "CREATE TABLE " + param + ";";
//	        	break;
//		}
//		return call;
//	}
	
	
}