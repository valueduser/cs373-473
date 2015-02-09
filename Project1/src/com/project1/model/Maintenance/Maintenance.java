package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.List;

public class Maintenance implements MaintenanceInterface {

	private List<Maintenance> maintenanceList = new ArrayList<Maintenance>();
	private List<Maintenance> pendingMaintenance = new ArrayList<Maintenance>();
	private List<Maintenance> completedMaintenance = new ArrayList<Maintenance>();
	private int scheduledDownTime;
	private int unscheduledDownTime;

	/*Mutators*/

	public void setMaintenanceList(List<Maintenance> maintenanceList){
		this.maintenanceList = maintenanceList;
	}
	public void setPendingInspections (List<Maintenance> pendingMaintenance){
		this.pendingMaintenance = pendingMaintenance;
	}
	public void setPassedInspections (List<Maintenance> completedMaintenance) {
		this.completedMaintenance = completedMaintenance;
	}
	public void setScheduledDownTime (int scheduledDownTime){
		this.scheduledDownTime = scheduledDownTime;
	}
	public void setUnsheduledDownTime(int unscheduledDownTime){
		this.unscheduledDownTime = unscheduledDownTime;
	}

	/*Accessors*/
	public List<Maintenance> getMaintenanceList () {
		return this.maintenanceList;
	}
	public List<Maintenance> getPendingMaintenance () {
		return this.pendingMaintenance;
	}
	public List<Maintenance> getCompletedMaintenance (){
		return this.completedMaintenance;
	}
	public int getScheduledDownTime (){
		return this.scheduledDownTime;
	}
	public int getUnscheduledDownTime(){
		return this.unscheduledDownTime;
	}



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

	public void ScheduleMainence() {
		// TODO Auto-generated method stub
		
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
	}}