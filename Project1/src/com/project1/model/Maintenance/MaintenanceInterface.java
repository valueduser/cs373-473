package com.project1.model.Maintenance;

import java.util.ArrayList;
import com.project1.model.Facility.*;

public interface MaintenanceInterface {

	public final String[] maintTypes = {"SEV1", "SEV2", "SEV3", "INSPECTION", "ALL"};

	public MaintenanceInterface ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate);
	public MaintenanceInterface makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType,int startDate, boolean isScheduled);
	public double calcMaintCostForFacility(int facilitySerialNumber);
	public double calcProblemRateForFacility(FacilityInterface facility);
	public double calcDownTimeForFaciliity(int facilitySerialNumber);

	//lifetime requests for a facilities
	public ArrayList<MaintenanceInterface> listMaintRequestsForFacility(int facilitySerialNumber);

	//open requests across all facilities of a certain type if "All" is passed then all maintTypes are listed
	public ArrayList<MaintenanceInterface> listMaint(int facilitySerialNumber, String maintType);

	// currently open requests for a facility
	public ArrayList<MaintenanceInterface> listFacilityProblems(int facilitySerialNumber);


}
