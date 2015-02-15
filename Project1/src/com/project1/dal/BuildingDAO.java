package com.project1.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Facility.Building;

public class BuildingDAO {
	public BuildingDAO(){}
	
	private String facilityTableName = "facilities";
	
	public List<Building> listFacilities() {
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			String listFacilityQuery = "SELECT facility FROM " + facilityTableName + ";";
			ResultSet rs = statement.executeQuery(listFacilityQuery);
			System.out.println("");
			List<Building> facilityList = new ArrayList<Building>();
			
			while(rs.next()){
				Building bldg = new Building();
				bldg = rs.getString("facility"); //TODO cast to building -- probably just parse?
				facilityList.add(bldg);
			}
			return facilityList;
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void addNewFacility() {
		try{
			Statement statement = DBHelper.getConnection().createStatement();
			String addFacilityQuery = "INSERT INTO " + facilityTableName + ";"; //TODO add facility details (default capacity etc)
			statement.executeQuery(addFacilityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void addFacilityDetails(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			ArrayList<String> detailList = new ArrayList<String>(); //TODO build list of column names
			ArrayList detailUpdate = new ArrayList<String>(); //TODO build list of column details to update with 			
			
			for (int i = 0; i < detailList.size(); i++){
				String addFacilityDetsQuery = "UPDATE " + facilityTableName + "SET " + detailList.get(i) + " = " + detailUpdate.get(i) + " WHERE id = " + facilitySerialNumber + ";"; //TODO add facility details (default capacity etc)
				statement.executeQuery(addFacilityDetsQuery);
			}	
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
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
	
	public List<Building> isInUseDuringInterval(int time1, int time2) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String isInUseQuery = "SELECT * FROM " + facilityTableName + " WHERE isUsed = true AND startDate < " + time1 + " AND endDate > " + time2 + ";";
			
			ResultSet rs = statement.executeQuery(isInUseQuery);
			List<Building> facilityList = new ArrayList<Building>();

			while(rs.next()){
				Building bldg = new Building();
				bldg = rs.getString("facility"); //TODO cast to building -- probably just parse?
				facilityList.add(bldg);
			}
			return facilityList;
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public int listActualUsage(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String actualUsageQuery = "SELECT startDate, endDate FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(actualUsageQuery);
			
			int begin = (int) rs.getString("startDate"); //TODO cast
			int end = (int) rs.getString("endDate");//TODO cast
			
			return end - begin; 
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public double calcUsageRate(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String usageRateQuery = "SELECT downtime FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(usageRateQuery);
			
			int downtime = (int) rs.getString("downtime"); //TODO cast
			
			int total = listActualUsage(facilitySerialNumber);
			
			double rate = downtime/total; 
			return rate; 
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public boolean getFacilityUse(int facilitySerialNumber) {
		boolean usage = false;

		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String useQuery = "SELECT isUsed FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(useQuery);
			
			
			if(rs.getString("isUsed").equals("true")){
				usage = true; 
			}
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return usage;
	}
	
	public String getFacilityInformation(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String getInfoQuery = "SELECT * FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(useQuery);
			
			
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	/** TODO
	 *  requestAvailableCapacity(int facilitySerialNumber)
	 *  listFacilityInspections(int facilitySerialNumber)
	 *  getVacancy()
	 *  getChildren(int facilitySerialNumber)
	 *  assignFacilityToUse(int facilitySerialNumber, String useType)
	 *  vacateFacility(int facilitySerialNumber)
	 *  setStartDate(int startDate)
	 *  setEndDate(int endDate)
	 *  setDownTime(int downTime)
	 *  setCapacity(int capacity)
	 */
	

}
