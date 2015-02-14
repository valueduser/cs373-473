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
				bldg = rs.getString("facility"); //TODO cast to building -- probably just parse
				facilityList.add(bldg);
			}
			return facilityList;
		}
		catch (SQLException sqlExcep) {
			System.err.println("Error: " + sqlExcep.getMessage());
		}
	}

}
