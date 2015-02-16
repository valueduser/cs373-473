package com.project1.model.Facility;

import java.util.ArrayList;
import java.util.List;

import com.project1.dal.ManagmentDB;
import com.project1.model.Maintenance.*;
import com.project1.model.Facility.Room;

public class Building implements FacilityInterface {

	public static final int MAX_BUILDING_CAPACITY = 15;

	private int serialNumber;
	private int parentId;
	private int capacity; //number of rooms being used multiplied by the capacity of each room
	private boolean isUsed = false;
	private boolean isVacant = false;
	private String usage;
	private List<Room> rooms = new ArrayList<Room>();
	private String startDate; //yyyymmdd
	private String endDate; //yyyymmdd
	
	/*in minutes*/
	private float downTime;
	private int scheduledDownTime;
	private int unscheduledDownTime;
	
	private String facilityTableName = "facilities";
<<<<<<< HEAD

	public void listFacilities() {
		String call = "SELECT id, capacity, isUsed, hasVacancy, usage, startDate, endDate, downTime " + "FROM " + facilityTableName + ";";
	}
=======
>>>>>>> 20678a4908770e36f9cb6793b869e598ac8b392a
	
	@Override
	public List<FacilityInterface> listFacilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewFacility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFacilityDetails(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isInUseDuringInterval(int time1, int time2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listActualUsage(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcUsageRate(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFacilityUse(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
=======

	@Override
>>>>>>> 20678a4908770e36f9cb6793b869e598ac8b392a
	public void getFacilityInformation(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestAvailableCapacity(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listFacilityInspections(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getVacancy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getChildren(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignFacilityToUse(int facilitySerialNumber, String useType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vacateFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
	public void setStartDate(int startDate) {
		// TODO Auto-generated method stub
		
	}
	public void setEndDate(int endDate) {
		// TODO Auto-generated method stub
		
	}
	public void setDownTime(int downTime) {
		// TODO Auto-generated method stub
		
	}
	public void setCapacity(int capacity) {
=======

	@Override
	public void setStartDate(int startDate, int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEndDate(int endDate, int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDownTime(int downTime, int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapacity(int capacity, int facilitySerialNumber) {
>>>>>>> 20678a4908770e36f9cb6793b869e598ac8b392a
		// TODO Auto-generated method stub
		
	}
}