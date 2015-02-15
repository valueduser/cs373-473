package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.List;


public class Inspection implements MaintenanceInterface {
	
	private int requestID;
	private String maintType;
	private boolean isOpen;
	private boolean isScheduled;
	private int timeToComplete;
	int startDate;

	private List<MaintenanceInterface> inspectionList;
	private List<MaintenanceInterface> pendingInspections;
	private List<MaintenanceInterface> passedInspections;
	

	/*Mutators*/
	public void setRequestID(int id){
		this.requestID = id;
	}
	public void setMaintType (String type){
		this.maintType = type;
	}
	public void setTimeToComplete(int timeToComplete){
		this.timeToComplete = timeToComplete;
	}
	public void setIsOpen(boolean isOpen){
		this.isOpen = isOpen;
	}
	public void setIsScheduled(boolean isScheduled){
		this.isScheduled = isScheduled;
	}
	public void setInspectionList(List<MaintenanceInterface> inspectionList){
		this.inspectionList = inspectionList;
	}
	public void setPendingInspections (List<MaintenanceInterface> pendingInspections){
		this.pendingInspections = pendingInspections;
	}
	public void setPassedInspections (List<MaintenanceInterface> passedInspections) {
		this.passedInspections = passedInspections;
	}
	
	/*Accessors*/
	public int getRequestID(){
		return this.requestID;
	}
	public String getMaintType (){
		return this.maintType;
	}
	public int getTimeToComplete(){
		return this.timeToComplete;
	}
	public boolean getIsOpen(){
		return this.isOpen;
	}
	public boolean getIsScheduled(){
		return this.isScheduled;
	}
	public List<MaintenanceInterface> getInspectionList () {
		return this.inspectionList;
	}
	public List<MaintenanceInterface> getPendingInspections () {
		return this.pendingInspections;
	}
	public List<MaintenanceInterface> getPassedInspections (){
		return this.passedInspections;
	}
	
	@Override
	public void ScheduleMaintenance(int facilitySerialNumber, String maintType,
			int startDate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void makeFacilityMaintRequest(int facilitySerialNumber,
			String maintType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float calcMaintCostForFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float calcProblemRateForFacility(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float calcDownTimeForFaciliity(int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<MaintenanceInterface> listMaintRequestsForFacility(
			int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<MaintenanceInterface> listMaint(int facilitySerialNumber,
			String maintType) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<MaintenanceInterface> listFacilityProblems(
			int facilitySerialNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}