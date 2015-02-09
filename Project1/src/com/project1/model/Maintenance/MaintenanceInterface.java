package com.project1.model.Maintenance;

import java.util.ArrayList;

public interface MaintenanceInterface {

	public final String[] maintTypes = {"SEV1", "SEV2", "SEV3", "INSPECTION", "ALL"};

	public void ScheduleMaintenance(int severity, String maintType);
	public void makeFacilityMaintRequest(int facilitySerialNumber, int sevarity, String maintType);
	public float calcMaintCostForFacility(int facilitySerialNumber);
	public float calcProblemRateForFacility(int facilitySerialNumber);
	public float calcDownTimeForFaciliity(int facilitySerialNumber);

	//lifetime requests for a facilities
	public ArrayList<MaintenanceInterface> listMaintRequestsForFacility(int facilitySerialNumber);

	//open requests across all facilities of a certain type if "All" is passed then all maintTypes are listed
	public ArrayList<MaintenanceInterface> listMaint(int facilitySerialNumber, String maintType);

	// currently open requests for a facility
	public ArrayList<MaintenanceInterface> listFacilityProblems(int facilitySerialNumber);



}
