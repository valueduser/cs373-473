package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.List;

public class MaintRequest implements MaintenanceInterface {

	private int requestID;
	private String maintType;
	private int timeToComplete;
	private boolean isOpen;
	private boolean isScheduled;
	int startDate;

	private List<MaintenanceInterface> maintenanceList;
	private List<MaintenanceInterface> pendingMaintenance;
	private List<MaintenanceInterface> completedMaintenance;


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
	public void setMaintenanceList(List<MaintenanceInterface> maintenanceList){
		this.maintenanceList = maintenanceList;
	}
	public void setPendingInspections (List<MaintenanceInterface> pendingMaintenance){
		this.pendingMaintenance = pendingMaintenance;
	}
	public void setPassedInspections (List<MaintenanceInterface> completedMaintenance) {
		this.completedMaintenance = completedMaintenance;
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
	public List<MaintenanceInterface> getMaintenanceList () {
		return this.maintenanceList;
	}
	public List<MaintenanceInterface> getPendingMaintenance () {
		return this.pendingMaintenance;
	}
	public List<MaintenanceInterface> getCompletedMaintenance (){
		return this.completedMaintenance;
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