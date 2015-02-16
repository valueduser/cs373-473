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
	/**
	 * ids | capacity | isUsed | hasVacancy | usage | startDate | endDate |
	 */
	
	
	public void addNewFacility(Building bldg) {
		//get the bldg's properties and add them to the table
		
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			int bldgID = bldg.getFacilitySerialNumber();
			bldg.getFacilityUse(bldgID);
			bldg.getStartDate(bldgID);
			bldg.getEndDate(bldgID);
			
			//Date date = new Date();
			SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
			
			
			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate')] VALUES (" + bldgID + ", null, true, false, null, " + today + ", null);"; 
			statement.executeQuery(addFacilityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public Building getFacility(int facilitySerialNumber) {
		Building bldg = new Building();

		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			
			String getFacilityQuery = "SELECT capacity, startDate, endDate, downTime FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			ResultSet rs = statement.executeQuery(getFacilityQuery);
			
			int capacity = rs.getInt("capacity");
			bldg.setCapacity(capacity, facilitySerialNumber);
			
			int startDate = rs.getInt("startDate");
			bldg.setStartDate(startDate, facilitySerialNumber);
			
			int endDate = rs.getInt("endDate");
			bldg.setEndDate(endDate, facilitySerialNumber);
			
			int downTime = rs.getInt("downTime");
			bldg.setDownTime(downTime, facilitySerialNumber);

		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return bldg;
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
