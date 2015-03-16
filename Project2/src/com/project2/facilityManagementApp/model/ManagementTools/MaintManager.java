package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;
import com.project2.facilityManagementApp.model.Facility.FacilityInterface;

public interface MaintManager {
	
	public void setMaintRequest(MaintRequest maintRequest);
	public MaintRequest getMaintRequest();

	public MaintRequest ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate);
	public MaintRequest makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType,int startDate, boolean isScheduled);
	public double calcMaintCostForFacility(int facilitySerialNumber);
	public double calcProblemRateForFacility(FacilityInterface facility);
	public double calcDownTimeForFaciliity(int facilitySerialNumber);
	
	//lifetime requests for a facilities
	public ArrayList<MaintRequest> listMaintRequestsForFacility(int facilitySerialNumber);

	//open requests across all facilities of a certain type if "All" is passed then all maintTypes are listed
	public ArrayList<MaintRequest> listMaint(int facilitySerialNumber, String maintType);

	// currently open requests for a facility
	public ArrayList<MaintRequest> listFacilityProblems(int facilitySerialNumber);
}
