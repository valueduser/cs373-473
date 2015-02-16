package com.project1.model.Facility;

import java.util.List;

public interface FacilityInterface {

	/*
	 * Functions will need to be set up to return proper datatypes.
	 */
	
	//these are all db calls
	public List<FacilityInterface> listFacilities ();
	public void addNewFacility(); //new serial number will be generated here
	public void addFacilityDetails(int facilitySerialNumber);
	public void removeFacility(int facilitySerialNumber); 

	//java has a built in dateTime object. We should look at using that or a external framework for this. I will look into this later
	public void isInUseDuringInterval(int time1, int time2); //dates in form of yyyymmdd  for now 
	public void listActualUsage(int facilitySerialNumber); //total time the unit has been in use
	public void calcUsageRate (int facilitySerialNumber);


	public void getFacilityUse(int facilitySerialNumber); // getter for usage; uses isUsed as check
	public void getFacilityInformation(int facilitySerialNumber); // getter for general facility data
	public void requestAvailableCapacity(int facilitySerialNumber); // getter for capacity
	public void listFacilityInspections(int facilitySerialNumber); //getter for inspectionInfo
	public void getVacancy(); //uses isVacant as a check before doing mathz
	public void getChildren(int facilitySerialNumber);


	public void assignFacilityToUse(int facilitySerialNumber, String useType); //setter for isUsed and useType
	public void vacateFacility(int facilitySerialNumber); //setter for isVacant
	public void setStartDate(int startDate, int facilitySerialNumber); //yyyymmdd
	public void setEndDate(int endDate, int facilitySerialNumber); //yyyymmdd
	public void setDownTime(int downTime, int facilitySerialNumber);
	public void setCapacity(int capacity, int facilitySerialNumber);

}
