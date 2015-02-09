package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.List;

public class MaintRequest implements MaintenanceInterface {

	private int requestID;
	private String maintType;
	private int timeToComplete;
	private boolean isOpen;
	private boolean isScheduled;
	private int startDate;
	private int endDate;


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
	public void setStartDate(int startDate){
		this.startDate = startDate;
	}
	public void setEndDate(int endDate){
		this.endDate = endDate;
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
	public int getStartDate(){
		return this.startDate;
	}
	public int getEndDate(){
		return this.endDate;
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

