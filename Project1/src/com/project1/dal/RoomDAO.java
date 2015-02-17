package com.project1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





import com.project1.model.Facility.Room;

public class RoomDAO {
	public RoomDAO(){}
	
	private String facilityTableName = "facilities";
	
	PreparedStatement psAddFacilityQuery = null;
	Connection connection =  DBHelper.getConnection();
	
	public void addNewFacility(Room room) {
		//get the bldg's properties and add them to the table
		
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			String tableCreation = "CREATE TABLE IF NOT EXISTS "+ facilityTableName + "(\"id\" INTEGER, \"capacity\" INTEGER, \"isUsed\" BOOLEAN, \"hasVacancy\" BOOLEAN, \"usage\" TEXT, \"startDate\" INTEGER, \"endDate\" INTEGER, \"downTime\" INTEGER, \"scheduledDownTime\" INTEGER, \"unscheduledDownTime\" INTEGER, \"parentId\" INTEGER);";
			statement.executeUpdate(tableCreation);
			
			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'downTime' ,'scheduledDownTime', 'unscheduledDownTime', 'parentId') VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			psAddFacilityQuery = connection.prepareStatement(addFacilityQuery);
			psAddFacilityQuery.setInt(1, room.getFacilitySerialNumber());
			psAddFacilityQuery.setInt(2, room.getCapacity());
			psAddFacilityQuery.setString(3, "true"); //TODO psAddFacilityQuery.setBoolean(3, fac.getIsUsed());
			psAddFacilityQuery.setBoolean(4, room.getVacancy());
			psAddFacilityQuery.setString(5,room.getFacilityUse()); 
			psAddFacilityQuery.setInt(6, room.getStartDate());
			psAddFacilityQuery.setInt(7, room.getEndDate());
			psAddFacilityQuery.setInt(8, room.getDownTime());
			psAddFacilityQuery.setInt(9,  room.getScheduledDownTime());
			psAddFacilityQuery.setInt(10, room.getUnscheduledDownTime());
			psAddFacilityQuery.setInt(11, room.getParentId());
	
//			statement.executeUpdate(addFacilityQuery);			
			
			psAddFacilityQuery.executeUpdate();
//			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'downTime', 'scheduledDownTime', 'unscheduledDownTime', 'parentId') VALUES (" + room.getFacilitySerialNumber() + ", " + room.getCapacity() + ", true, " + room.getVacancy() + ", " + room.getFacilityUse() + ", " + room.getStartDate() + ", "  + room.getEndDate() + ", "  + room.getDownTime() + ", "  + room.getScheduledDownTime() + ", "  + room.getUnscheduledDownTime() + ", "  + room.getParentId() + ";"; 
//			statement.executeUpdate(addFacilityQuery);
			
			psAddFacilityQuery.close();
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public Room getFacility(int facilitySerialNumber) {
		Room room = new Room();

		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			String getFacilityQuery = "SELECT id, capacity, isUsed, hasVacancy, usage, startDate, endDate, downTime, unscheduledDownTime, scheduledDownTime, parentId FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			ResultSet rs = statement.executeQuery(getFacilityQuery);
			
			while(rs.next())
			{
				room.setFacilityId(rs.getInt("id"));
				room.setCapacity(rs.getInt("capacity"));
				room.setIsUsed(rs.getBoolean("isUsed"));
				room.vacateFacility(rs.getBoolean("hasVacancy"));
				room.assignFacilityToUse(rs.getString("usage"));
				room.setStartDate(rs.getInt("startDate"));
				room.setEndDate(rs.getInt("endDate"));
				room.setDownTime(rs.getInt("downTime"));
				room.setUnscheduledDownTime(rs.getInt("unscheduledDownTime"));
				room.setScheduledDownTime(rs.getInt("scheduledDownTime"));
				room.setParentId(rs.getInt("parentId"));
			}
			
//			int capacity = rs.getInt("capacity");
//			room.setCapacity(capacity);
//			
//			int startDate = rs.getInt("startDate");
//			room.setStartDate(startDate);
//			
//			int endDate = rs.getInt("endDate");
//			room.setEndDate(endDate);
//			
//			int downTime = rs.getInt("downTime");
//			room.setDownTime(downTime);
//			
//			int unscheduledDownTime = rs.getInt("unscheduledDownTime");
//			room.setUnscheduledDownTime(unscheduledDownTime);
//			
//			int scheduledDownTime = rs.getInt("scheduledDownTime");
//			room.setScheduledDownTime(scheduledDownTime);
//			
//			int parentId = rs.getInt("parentId");
//			room.setParentId(parentId);
//			
//			String usage = rs.getString("usage");
//			room.assignFacilityToUse(usage);
//			
//			boolean isVacant = rs.getBoolean("hasVacancy");
//			room.vacateFacility(isVacant);

			statement.close();
			rs.close();
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
			
			statement.executeUpdate(removeFacilityQuery);
			
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
}
