package com.project1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project1.model.Facility.*;

public class BuildingDAO {
	public BuildingDAO(){}
	
	private String facilityTableName = "facilities";
	
	public void addNewFacility(FacilityInterface fac) {
		//get the bldg's properties and add them to the table
		
		PreparedStatement psAddFacilityQuery = null;
		Connection connection =  DBHelper.getConnection();
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			String tableCreation = "CREATE TABLE IF NOT EXISTS "+ facilityTableName + "(\"id\" INTEGER, \"capacity\" INTEGER, \"isUsed\" BOOLEAN, \"hasVacancy\" BOOLEAN, \"usage\" TEXT, \"startDate\" INTEGER, \"endDate\" INTEGER, \"downTime\" INTEGER, \"scheduledDownTime\" INTEGER, \"unscheduledDownTime\" INTEGER, \"parentId\" INTEGER);";
			statement.executeUpdate(tableCreation);
			
			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'downTime' ,'scheduledDownTime', 'unscheduledDownTime', 'parentId') VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			psAddFacilityQuery = connection.prepareStatement(addFacilityQuery);
			psAddFacilityQuery.setInt(1, fac.getFacilitySerialNumber());
			psAddFacilityQuery.setInt(2, fac.getCapacity());
			psAddFacilityQuery.setString(3, "true"); //TODO psAddFacilityQuery.setBoolean(3, fac.getIsUsed());
			psAddFacilityQuery.setBoolean(4, fac.getVacancy());
			psAddFacilityQuery.setString(5,fac.getFacilityUse()); 
			psAddFacilityQuery.setInt(6, fac.getStartDate());
			psAddFacilityQuery.setInt(7, fac.getEndDate());
			psAddFacilityQuery.setInt(8, fac.getDownTime());
			psAddFacilityQuery.setInt(9,  fac.getScheduledDownTime());
			psAddFacilityQuery.setInt(10, fac.getUnscheduledDownTime());
			psAddFacilityQuery.setInt(11, fac.getParentId());
	
			psAddFacilityQuery.executeUpdate();
//			statement.executeUpdate(addFacilityQuery);
			
			psAddFacilityQuery.close();
//			connection.close();
//			String addFacilityQuery = "INSERT INTO " + facilityTableName + "('id', 'capacity', 'isUsed', 'hasVacancy', 'usage', 'startDate', 'endDate', 'downTime' ,'scheduledDownTime', 'unscheduledDownTime', 'parentId') VALUES (" + fac.getFacilitySerialNumber() + ", " + fac.getCapacity() + ", '" + true + "', '" + fac.getVacancy() + "', '" + fac.getFacilityUse() + "', " + fac.getStartDate() + ", "  + fac.getEndDate() + ", " + fac.getDownTime() + ", " + fac.getScheduledDownTime() + ", " + fac.getUnscheduledDownTime() + ", " + fac.getParentId() + ");";
//			statement.executeUpdate(addFacilityQuery);
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public Building getBuilding(int facilitySerialNumber) {
		Building bldg = new Building();

		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			
//			String getFacilityQuery = "SELECT capacity, usage, startDate, endDate, downTime, scheduledDownTime, unscheduledDownTime, parentIdFROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			String getFacilityQuery = "SELECT id, capacity, isUsed, hasVacancy, usage, startDate, endDate, downTime, unscheduledDownTime, scheduledDownTime, parentId FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			ResultSet rs = statement.executeQuery(getFacilityQuery);
			
			while(rs.next())
			{
				bldg.setFacilityId(rs.getInt("id"));
				bldg.setCapacity(rs.getInt("capacity"));
				bldg.setIsUsed(rs.getBoolean("isUsed"));
				bldg.vacateFacility(rs.getBoolean("hasVacancy"));
				bldg.assignFacilityToUse(rs.getString("usage"));
				bldg.setStartDate(rs.getInt("startDate"));
				bldg.setEndDate(rs.getInt("endDate"));
				bldg.setDownTime(rs.getInt("downTime"));
				bldg.setUnscheduledDownTime(rs.getInt("unscheduledDownTime"));
				bldg.setScheduledDownTime(rs.getInt("scheduledDownTime"));
				bldg.setParentId(rs.getInt("parentId"));
			}
			
//			int capacity = rs.getInt("capacity");
//			bldg.setCapacity(capacity);
//			
//			int startDate = rs.getInt("startDate");
//			bldg.setStartDate(startDate);
//			
//			int endDate = rs.getInt("endDate");
//			bldg.setEndDate(endDate);
//			
//			int downTime = rs.getInt("downTime");
//			bldg.setDownTime(downTime);
//			
//			int unscheduledDownTime = rs.getInt("unscheduledDownTime");
//			bldg.setUnscheduledDownTime(unscheduledDownTime);
//			
//			int scheduledDownTime = rs.getInt("scheduledDownTime");
//			bldg.setScheduledDownTime(scheduledDownTime);
//			
//			int parentId = rs.getInt("parentId");
//			bldg.setParentId(parentId);
//			
//			String usage = rs.getString("usage");
//			bldg.assignFacilityToUse(usage);
//			
//			boolean isVacant = rs.getBoolean("hasVacancy");
//			bldg.vacateFacility(isVacant);
			
			rs.close();
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return bldg;
	}
	
	public Room getRoom(int facilitySerialNumber) {
		Room rm = new Room();

		try{
			Statement statement = DBHelper.getConnection().createStatement();
			
			
			String getFacilityQuery = "SELECT capacity, startDate, endDate, downTime, scheduledDownTime, unscheduledDownTime FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			
			ResultSet rs = statement.executeQuery(getFacilityQuery);
			
			int capacity = rs.getInt("capacity");
			rm.setCapacity(capacity);
			
			int startDate = rs.getInt("startDate");
			rm.setStartDate(startDate);
			
			int endDate = rs.getInt("endDate");
			rm.setEndDate(endDate);
			
			int downTime = rs.getInt("downTime");
			rm.setDownTime(downTime);
			
			int unscheduledDownTime = rs.getInt("unscheduledDownTime");
			rm.setUnscheduledDownTime(unscheduledDownTime);
			
			int scheduledDownTime = rs.getInt("scheduledDownTime");
			rm.setScheduledDownTime(scheduledDownTime);
			
			int parentId = rs.getInt("parentId");
			rm.setParentId(parentId);
			
			String usage = rs.getString("usage");
			rm.assignFacilityToUse(usage);
			
			boolean isVacant = rs.getBoolean("hasVacancy");
			rm.vacateFacility(isVacant);
			
			rs.close();
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return rm;
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
