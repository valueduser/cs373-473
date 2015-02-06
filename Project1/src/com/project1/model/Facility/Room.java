package com.project1.model.Facility;


import java.util.ArrayList;
import java.util.List;

public class Room implements Facility {

	public static final int MAX_ROOM_CAPACITY = 3;

	private int serialNumber;
	private int capacity; //number of people in using the room
	private boolean isUsed = false;
	private boolean isVacant = false;
	private String usage;
	private List<Facility> rooms = new ArrayList<Facility>();
	private String inspectionInfo; //will probably change this to a list of inspection objects or, to keep it simple, structs
	private String startDate; //yyyymmdd
	private String endDate; //yyyymmdd
	private float downTime;
	public void listFacilities() {
		// TODO Auto-generated method stub
		
	}
	public void addNewFacility() {
		// TODO Auto-generated method stub
		
	}
	public void addFacilityDetails(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void removeFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void isInUseDuringInterval(int time1, int time2) {
		// TODO Auto-generated method stub
		
	}
	public void listActualUsage(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void calcUsageRate(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void getFacilityUse(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void getFacilityInformation(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void requestAvailableCapacity(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void listFacilityInspections(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void getVacancy() {
		// TODO Auto-generated method stub
		
	}
	public void getChildren(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
	public void assignFacilityToUse(int facilitySerialNumber, String useType) {
		// TODO Auto-generated method stub
		
	}
	public void vacateFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		
	}
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
		// TODO Auto-generated method stub
		
	}
}