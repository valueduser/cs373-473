package com.project1.model.Maintenance;

import java.util.ArrayList;
import java.util.Iterator;
import com.project1.model.Facility.*;

public class MaintDetails implements MaintenanceInterface {

	private ArrayList<MaintenanceInterface> MaintenanceList;
	
	
	public ArrayList<MaintenanceInterface> getMaintenanceList() {
		return MaintenanceList;
	}

	public void setMaintenanceList(ArrayList<MaintenanceInterface> maintenanceList) {
		MaintenanceList = maintenanceList;
	}

	@Override
	public MaintenanceInterface ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate) {
		MaintRequest scheduledMaint = new MaintRequest();
		scheduledMaint.setFacilitySerialNumber(facilitySerialNumber);
		scheduledMaint.setRequestID(requestID);
		scheduledMaint.setIsOpen(true);
		scheduledMaint.setIsScheduled(true);
		scheduledMaint.setMaintType(maintType);
		scheduledMaint.setTimeToComplete(120);
		scheduledMaint.setStartDate(startDate);
		return scheduledMaint;
	}

	@Override
	public MaintenanceInterface makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType, int startDate, boolean isScheduled) {
		MaintRequest requestedMaint = new MaintRequest();
		requestedMaint.setFacilitySerialNumber(facilitySerialNumber);
		requestedMaint.setRequestID(requestID);
		requestedMaint.setIsOpen(true);
		requestedMaint.setIsScheduled(isScheduled);
		requestedMaint.setMaintType(maintType);
		requestedMaint.setTimeToComplete(120);
		requestedMaint.setStartDate(startDate);
		return requestedMaint;

	}

	@Override
	public double calcMaintCostForFacility(int facilitySerialNumber) {
		double maintHours = 0;
		double costPerHourDownTime = 12.5;
		double maintCost = 0;
		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (maint.getFacilitySerialNumber() == facilitySerialNumber){
		    	maintHours += maint.getTimeToComplete()/60;
		    }
		}
		maintCost = maintHours * costPerHourDownTime;
		return maintCost;
	}

	@Override
	public double calcProblemRateForFacility(FacilityInterface facility) {		
		double facilityStartDate = (double) facility.getStartDate();
		double facilityEndDate = (double) facility.getEndDate();
		double problemRate = 0;
		double daysOperable = facilityEndDate-facilityStartDate;
		double daysNotOperable = 0;

		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (!maint.getIsOpen()){
		    	daysNotOperable += (maint.getTimeToComplete()/60)/24;
		    }
		}
		problemRate = daysNotOperable/daysOperable;
		return problemRate;
	}

	@Override
	public double calcDownTimeForFaciliity(int facilitySerialNumber) {
		double downTime = 0;
		
		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (maint.getFacilitySerialNumber() == facilitySerialNumber && !maint.getIsOpen()){
		    	downTime += maint.getTimeToComplete()/60;
		    }
		}
		return downTime;
	}

	@Override
	public ArrayList<MaintenanceInterface> listMaintRequestsForFacility(int facilitySerialNumber) {
		ArrayList<MaintenanceInterface> maintForFacility = new ArrayList<MaintenanceInterface>();
		
		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (maint.getFacilitySerialNumber() == facilitySerialNumber){
		    	maintForFacility.add(maint);
		    }
		}
		
		return maintForFacility;
	}

	@Override
	public ArrayList<MaintenanceInterface> listMaint(int facilitySerialNumber, String maintType) {
		ArrayList<MaintenanceInterface> maintList = new ArrayList<MaintenanceInterface>();
		
		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (maintType == "ALL"){
		    	maintList.add(maint);
		    }
		    else{
			    if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getMaintType() == maintType){
			    	maintList.add(maint);
			    }
		    }
		}
		return maintList;
	}

	@Override
	public ArrayList<MaintenanceInterface> listFacilityProblems(int facilitySerialNumber) {
		ArrayList<MaintenanceInterface> maintList = new ArrayList<MaintenanceInterface>();
		
		ArrayList<MaintenanceInterface> maintenanceList = this.getMaintenanceList();
		Iterator<MaintenanceInterface> it = maintenanceList.iterator();
		while(it.hasNext())
		{
		    MaintenanceInterface obj = it.next();
		    MaintRequest maint = (MaintRequest) obj;
		    if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getIsOpen()){
		    	maintList.add(maint);
		    }
		}
		return maintList;
	}

}
