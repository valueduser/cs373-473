package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;

import com.project2.facilityManagementApp.model.Facility.FacilityInterface;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;

public class FacManagerImpl implements FacManager {
	private FacilityInterface facilityInterface;
	
	public void setFacilityInterface(FacilityInterface facInter){
		this.facilityInterface = facInter;
	}
	public FacilityInterface getFacilityInterface(){
		return this.facilityInterface;
	}

    @Override
    public boolean isInUseDuringInterval(int time1, int time2) {
        if(getFacilityInterface().getEndDate() < time2 && getFacilityInterface().getStartDate() > time1){
            return true;
        }
        return false;
    }

    @Override
    public int listActualUsage(int facilitySerialNumber) {
        int upTime = (getFacilityInterface().getEndDate() - getFacilityInterface().getStartDate()) - getFacilityInterface().getDownTime();
        return upTime;
    }

    @Override
    public int calcUsageRate(int facilitySerialNumber) {
        int upTime = this.listActualUsage(facilitySerialNumber);
        int usageRate = upTime / (getFacilityInterface().getEndDate() - getFacilityInterface().getStartDate());
        return usageRate;
    }
    @Override
    public String getFacilityInformation() { //TODO
    	String facInfo = "";
    	return facInfo;
    }
    @Override
    public ArrayList<MaintRequest> listFacilityInspections(ArrayList<MaintRequest> maintenance) { //TODO
        ArrayList<MaintRequest> facInspections = null;
        return facInspections;
    }
}
