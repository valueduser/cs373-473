package com.project2.facilityManagementApp.model.Maintenance;

public interface MaintRequest {

	public void setFacilitySerialNumber(int facilitySerialNumber);
	public void setRequestId(int id);
	public void setMaintType(String type);
	public void setTimeToComplete(int timeToComplete);
	public void setIsOpen(boolean isOpen);
	public void setIsScheduled(boolean isScheduled);
	public void setStartDate(int startDate);
	
	public int getFacilitySerialNumber();
	public int getRequestId();
	public String getMaintType();
	public int getTimeToComplete();
	public boolean getIsOpen();
	public boolean getIsScheduled();
	public int getStartDate();
}
