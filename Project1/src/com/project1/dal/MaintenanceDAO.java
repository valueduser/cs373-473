package com.project1.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project1.model.Maintenance.MaintRequest;

public class MaintenanceDAO {
	public MaintenanceDAO(){}

	private String MaintenanceTableName = "maintenance";
	
	public void addMaintenanceReq(MaintRequest maintReq){
		try
		{			
			Statement statement = DBHelper.getConnection().createStatement();
			String tableCreation = "CREATE TABLE IF NOT EXISTS "+ MaintenanceTableName + "(\"facilitySerialNumber\" INTEGER, \"requestID\" INTEGER, \"maintType\" TEXT, \"timeToComplete\" INTEGER, \"isOpen\" BOOLEAN, \"isScheduled\" BOOLEAN, \"startDate\" INTEGER)";
			statement.executeUpdate(tableCreation);
			String addMaintRequestQuery = "INSERT INTO " + MaintenanceTableName + "(facilitySerialNumber, requestID, maintType, timeToComplete, isOpen, isScheduled, startDate) VALUES (" + maintReq.getFacilitySerialNumber() + ", " + maintReq.getRequestID() + ", '" + maintReq.getMaintType() + "', " + maintReq.getTimeToComplete() + ", '" + maintReq.getIsOpen() + "', '" +  maintReq.getIsScheduled() + "', " +  maintReq.getStartDate() + ");";
			statement.executeUpdate(addMaintRequestQuery);
			
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void getMaintenanceReq(int requestID){
		try
		{
			MaintRequest maintReq = new MaintRequest();
			
			Statement statement = DBHelper.getConnection().createStatement();
			String getMaintRequestQuery = "SELECT facilitySerialNumber, requestID, maintType, timeToComplete, isOpen, isScheduled, startDate FROM " + MaintenanceTableName + " WHERE requestID = " + requestID + ";";
			ResultSet rs = statement.executeQuery(getMaintRequestQuery);
			
			int facilitySerialNumber = rs.getInt("facilitySerialNumber");
			maintReq.setFacilitySerialNumber(facilitySerialNumber);
			
			maintReq.setRequestID(requestID);
			
			String maintType = rs.getString("maintType");
			maintReq.setMaintType(maintType);
			
			int timeToComplete = rs.getInt("timeToComplete");
			maintReq.setTimeToComplete(timeToComplete);
			
			boolean isOpen = rs.getBoolean("isOpen");
			maintReq.setIsOpen(isOpen);
			
			boolean isScheduled = rs.getBoolean("isScheduled");
			maintReq.setIsScheduled(isScheduled);
			
			int startDate = rs.getInt("startDate");
			maintReq.setStartDate(startDate);
			
			statement.close();
			rs.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void removeMaintenanceReq(int requestID){
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String removeMaintReqQuery = "DELETE FROM " + MaintenanceTableName + " WHERE requestID = " + requestID + ";";
			statement.executeUpdate(removeMaintReqQuery);
			
			statement.close();
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
}