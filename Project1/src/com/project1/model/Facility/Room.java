package com.project1.model.Facility;

import java.util.ArrayList;
import java.util.List;

public class Room implements FacilityInterface {

	public static final int MAX_ROOM_CAPACITY = 3;

	private int serialNumber;
	private int parentId;
	private int capacity; //number of people in using the room
	private boolean isUsed = false;
	private boolean isVacant = false;
	private String usage;
	private String startDate; //days from 1000/01/01
	private String endDate; //days from 1000/01/01

	/*in minutes*/
	private float downTime; 
	private int scheduledDownTime;
	private int unscheduledDownTime;
	
	private String facilityTableName = "facilities";
	
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
	@Override
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getFacilitySerialNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getEndDate() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getStartDate() {
		// TODO Auto-generated method stub
		return 0;
	}
}