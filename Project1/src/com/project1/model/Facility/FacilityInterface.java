package com.project1.model.Facility;

import java.util.ArrayList;
import com.project1.model.Maintenance.*;

public interface FacilityInterface {

	//all dates are in days from 1000/01/01
	public boolean isInUseDuringInterval(int time1, int time2); //days from 1000/01/01
	public int listActualUsage(int facilitySerialNumber); //total time the unit has been in use
	public int calcUsageRate (int facilitySerialNumber);


	public String getFacilityUse(); // getter for usage; uses isUsed as check
	public String getFacilityInformation(); // getter for general facility data
	public int requestAvailableCapacity(); // getter for capacity
	public ArrayList<MaintenanceInterface> listFacilityInspections(ArrayList<MaintenanceInterface> maintenance); //getter for inspectionInfo
	public boolean getVacancy(); //uses isVacant as a check before doing mathz
	public ArrayList<FacilityInterface> getChildren(ArrayList<FacilityInterface> facilities);
	public int getFacilitySerialNumber();
	public int getEndDate();
	public int getStartDate();
	public int getParentId();
	public int getDownTime();

	public void assignFacilityToUse(String useType); //setter for isUsed and useType
	public void vacateFacility(boolean isVacant); //setter for isVacant
	public void setStartDate(int startDate); //days from 1000/01/01
	public void setEndDate(int endDate); //days from 1000/01/01
	public void setDownTime(int downTime);
	public void setCapacity(int capacity);
	public void setScheduledDownTime(int scheduledDownTime);
	public void setUnscheduledDownTime(int unscheduledDownTime);
	public void setParentID(int parentID);
}
