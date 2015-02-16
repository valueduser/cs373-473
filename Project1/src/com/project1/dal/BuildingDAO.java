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
	 * ids | capacity | isUsed | hasVacancy | usage | startDate | endDate | scheduledDownTime | unscheduledDownTime | downTime | parentID
	 */
	
	
	public void addNewFacility(Building bldg) {
		//get the bldg's properties and add them to the table
		
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			int bldgID = bldg.getFacilitySerialNumber();
			bldg.getFacilityUse();
			bldg.getStartDate();
			bldg.getEndDate();
			
			
			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'scheduledDownTime', 'unscheduledDownTime', 'parentID	')] VALUES (" + bldgID + ", null, true, false, null, null, null, null, null, null, null);"; 
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
			bldg.setCapacity(capacity);
			
			int startDate = rs.getInt("startDate");
			bldg.setStartDate(startDate);
			
			int endDate = rs.getInt("endDate");
			bldg.setEndDate(endDate);
			
			int downTime = rs.getInt("downTime");
			bldg.setDownTime(downTime);
			
			int unscheduledDownTime = rs.getInt("unscheduledDownTime");
			bldg.setUnscheduledDownTime(unscheduledDownTime);
			
			int scheduledDownTime = rs.getInt("scheduledDownTime");
			bldg.setScheduledDownTime(scheduledDownTime);
			
			int parentID = rs.getInt("parentID");
			bldg.setParentID(parentID);
			
			String usage = rs.getString("usage");
			bldg.assignFacilityToUse(usage);
			
			boolean isVacant = rs.getBoolean("hasVacancy");
			bldg.vacateFacility(isVacant);

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
