package com.project1.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.project1.model.Facility.Room;

public class RoomDAO {
	public RoomDAO(){}
	
	private String facilityTableName = "facilities";
	
	public void addNewFacility(Room room) {
		//get the bldg's properties and add them to the table
		
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			int roomID = room.getFacilitySerialNumber();
			room.getFacilityUse();
			room.getStartDate();
			room.getEndDate();
			
			
			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'scheduledDownTime', 'unscheduledDownTime', 'parentID	')] VALUES (" + room.getFacilitySerialNumber() + ", " + room.getCapacity() + ", true, " + room.getVacancy() + ", " + room.getFacilityUse() + ", " + room.getStartDate() + ", "  + room.getEndDate() + ", null, null, null, " + room.getParentId() + ";"; 
			statement.executeQuery(addFacilityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public Room getFacility(int facilitySerialNumber) {
		Room room = new Room();

		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			
			String getFacilityQuery = "SELECT capacity, startDate, endDate, downTime FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			ResultSet rs = statement.executeQuery(getFacilityQuery);
			
			int capacity = rs.getInt("capacity");
			room.setCapacity(capacity);
			
			int startDate = rs.getInt("startDate");
			room.setStartDate(startDate);
			
			int endDate = rs.getInt("endDate");
			room.setEndDate(endDate);
			
			int downTime = rs.getInt("downTime");
			room.setDownTime(downTime);
			
			int unscheduledDownTime = rs.getInt("unscheduledDownTime");
			room.setUnscheduledDownTime(unscheduledDownTime);
			
			int scheduledDownTime = rs.getInt("scheduledDownTime");
			room.setScheduledDownTime(scheduledDownTime);
			
			int parentID = rs.getInt("parentID");
			room.setParentID(parentID);
			
			String usage = rs.getString("usage");
			room.assignFacilityToUse(usage);
			
			boolean isVacant = rs.getBoolean("hasVacancy");
			room.vacateFacility(isVacant);

		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return room;
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
