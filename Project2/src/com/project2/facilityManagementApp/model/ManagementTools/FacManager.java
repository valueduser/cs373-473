package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;

import com.project2.facilityManagementApp.model.Facility.FacilityInterface;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;

public interface FacManager {

	public void setFacilityInterface(FacilityInterface facInter);
	public FacilityInterface getFacilityInterface();
	public boolean isInUseDuringInterval(int time1, int time2);
    public int listActualUsage(int facilitySerialNumber);
    public int calcUsageRate(int facilitySerialNumber);
    public String getFacilityInformation();
    public ArrayList<MaintRequest> listFacilityInspections(ArrayList<MaintRequest> maintenance);
}
