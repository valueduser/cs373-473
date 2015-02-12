package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.List;


public class Inspection implements MaintenanceInterface {

	private List<Inspection> inspectionList = new ArrayList<Inspection>();
	private List<Inspection> pendingInspections = new ArrayList<Inspection>();
	private List<Inspection> passedInspections = new ArrayList<Inspection>();
	private int timeToComplete;

	

	public void ScheduleMaintenance() {
		// TODO Auto-generated method stub
		
	}

	public void makeFacilityMaintRequest() {
		// TODO Auto-generated method stub
		
	}

	public float calcMaintCostForFacility() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float calcProblemRateForFacility() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float calcDownTimeForFaciliity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList listMaintRequestsForFacility() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList listMaint() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList listFacilityProblems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ScheduleMaintenance(int severity, String maintType) {
		// TODO Auto-generated method stub
		
	}

	public void makeFacilityMaintRequest(int facilitySerialNumber,
			int sevarity, String maintType) {
		// TODO Auto-generated method stub
		
	}

	public float calcMaintCostForFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float calcProblemRateForFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float calcDownTimeForFaciliity(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<MaintenanceInterface> listMaintRequestsForFacility(
			int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MaintenanceInterface> listMaint(int facilitySerialNumber,
			String maintType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MaintenanceInterface> listFacilityProblems(
			int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
}