package com.project1.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project1.model.Facility.Building;

public class BuildingDAO {
	public BuildingDAO(){}
	
	private String facilityTableName = "facilities";
	
	public void addNewFacility(Building bldg) {
		//get the bldg's properties and add them to the table
		
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			String addFacilityQuery = "INSERT INTO " + facilityTableName + ";"; //TODO add facility details (default capacity etc)
			statement.executeQuery(addFacilityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public Building getFacility(int facilitySerialNumber) {
		try{
			Statement statement = DBHelper.getConnection().createStatement();
//			String addFacilityQuery = "INSERT INTO " + facilityTableName + ";"; //TODO add facility details (default capacity etc)
			//Change ^ accordingly
//			statement.executeQuery(getFacilityQuery);
			
			//create a Building with the properties in the table row
			//return it
			return null;
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return null;
	}
	
	public void removeFacility(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String removeFacilityQuery = "DELETE FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			statement.executeQuery(removeFacilityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
}
