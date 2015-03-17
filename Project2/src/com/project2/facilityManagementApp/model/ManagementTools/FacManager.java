package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;

import com.project2.facilityManagementApp.model.Facility.Facility;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;

public interface FacManager {

	public void setFacility(Facility facInter);
	public Facility getFacility();
	public boolean isInUseDuringInterval(int time1, int time2);
    public int listActualUsage(int facilitySerialNumber);
    public int calcUsageRate(int facilitySerialNumber);
    public String getFacilityInformation();
}
