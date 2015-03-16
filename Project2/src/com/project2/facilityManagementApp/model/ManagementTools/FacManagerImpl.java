package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;

import com.project2.facilityManagementApp.model.Facility.Facility;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;

public class FacManagerImpl implements FacManager {
	private Facility Facility;
	
	@Override
	public void setFacility(Facility facInter){
		this.Facility = facInter;
	}

	@Override
	public Facility getFacility(){
		return Facility;
	}

    @Override
    public boolean isInUseDuringInterval(int time1, int time2) {
        if(getFacility().getEndDate() < time2 && getFacility().getStartDate() > time1){
            return true;
        }
        return false;
    }

    @Override
    public int listActualUsage(int facilitySerialNumber) {
        int upTime = (getFacility().getEndDate() - getFacility().getStartDate()) - getFacility().getDownTime();
        return upTime;
    }

    @Override
    public int calcUsageRate(int facilitySerialNumber) {
        int upTime = this.listActualUsage(facilitySerialNumber);
        int usageRate = upTime / (getFacility().getEndDate() - getFacility().getStartDate());
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
