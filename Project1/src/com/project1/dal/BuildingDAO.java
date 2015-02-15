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
	private String inspectionsTableName = "inspections";
	
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
		String information = null; 
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String getInfoQuery = "SELECT * FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(getInfoQuery);
			
			information = rs.toString();
			
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return information;
	}
	
	public int requestAvailableCapacity(int facilitySerialNumber) {
		int capacity = 0;
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String availabilityQuery = "SELECT capacity FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(availabilityQuery);
			
			capacity = (int) rs.getString("capacity"); //TODO cast

		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return capacity;
	}
	
	public List<String> listFacilityInspections(int facilitySerialNumber) {
		List<String> inspectionList = new ArrayList<String>();
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String inspectionsQuery = "SELECT capacity FROM " + inspectionsTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(inspectionsQuery);			

			while(rs.next()){
				String inspection = null;
				inspection = rs.getString("inspection"); //TODO cast to building -- probably just parse?
				inspectionList.add(inspection);
			}
			
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return inspectionList;
	}
	
	public List<Building> getVacancy() {
		List<Building> vacancyList = new ArrayList<Building>();

		try 
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String vacancyQuery = "SELECT id FROM " + facilityTableName + " WHERE hasVacancy =  true;";
			
			ResultSet rs = statement.executeQuery(vacancyQuery);			

			while(rs.next()){
				Building bldg = new Building();
				String inspection = null;
				bldg = (Building) rs.getString("id"); //TODO cast to building -- probably just parse?
				vacancyList.add(bldg);
			}
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return vacancyList;
	}
	
	
	public List<Integer> getChildren(int facilitySerialNumber) {
		List<Integer> children = new ArrayList<Integer>();
		try 
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String childrenQuery = "SELECT id FROM " + facilityTableName + " WHERE parentId is not 0;";
			
			ResultSet rs = statement.executeQuery(childrenQuery);
			
			while(rs.next()){
				children.add(rs.getInt("id"));
			}
			
		}catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
		return children;
	}
	
	public void assignFacilityToUse(int facilitySerialNumber, String useType) {
		try 
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String assignUseQuery = "UPDATE " + facilityTableName + " SET usage = " + useType + " WHERE id = " + facilitySerialNumber + ";";
			
			statement.executeQuery(assignUseQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void vacateFacility(int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			
			Date date = new Date();
			SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
			
			String vacateQuery = "UPDATE " + facilityTableName + " SET hasVacancy = true, SET isUsed = false, SET endDate = " + today.format(date) + " WHERE id = " + facilitySerialNumber + ";";
			statement.executeQuery(vacateQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void setStartDate(int startDate, int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String setStartQuery = "UPDATE " + facilityTableName + " SET hasVacancy = false, SET isUsed = true, SET startDate = " + startDate + " WHERE id = " + facilitySerialNumber + ";";
			statement.executeQuery(setStartQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void setEndDate(int endDate, int facilitySerialNumber) {
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String setEndQuery = "UPDATE " + facilityTableName + " SET hasVacancy = true, SET isUsed = false, SET endDate = " + endDate + " WHERE id = " + facilitySerialNumber + ";";
			statement.executeQuery(setEndQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	public void setDownTime(int downTime, int facilitySerialNumber)
	{
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String getDownTimeQuery = "SELECT downTime FROM " + facilityTableName + " WHERE id = " + facilitySerialNumber + ";";
			ResultSet rs = statement.executeQuery(getDownTimeQuery);
			int prevDownTime = (int) rs.getInt("downTime");
			
			downTime += prevDownTime;
			
			String setDownTimeQuery = "UPDATE " + facilityTableName + " SET downTime = " + downTime + " WHERE id = " + facilitySerialNumber + ";";
			statement.executeQuery(setDownTimeQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}
	
	
	public void setCapacity(int capacity, int facilitySerialNumber)
	{
		try
		{
			Statement statement = DBHelper.getConnection().createStatement();
			String setCapacityQuery = "UPDATE " + facilityTableName + " SET capacity = " + capacity + " WHERE id = " + facilitySerialNumber + ";";
			statement.executeQuery(setCapacityQuery);
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}

}
