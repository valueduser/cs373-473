package com.project2.facilityManagementApp.model.Facility;

import java.util.ArrayList;

public interface FacilityInterface {
    public String getUsage();
    public int getDownTime();
    public int requestAvailableCapacity();
    public boolean getIsVacant();
    public int getParentId();
    public int getCapacity();
    public ArrayList<FacilityInterface> getChildren(ArrayList<FacilityInterface> facilities);
    public int getFacilitySerialNumber();
    public int getEndDate();
    public int getStartDate();
    public int getScheduledDownTime();
    public int getUnscheduledDownTime();
    public boolean getIsUsed();
    public void setUsage(String useType);
    public void setIsVacant(boolean isVacant);
    public void setStartDate(int startDate);
    public void setEndDate(int endDate);
    public void setDownTime(int downTime);
    public void setCapacity(int capacity);
    public void setScheduledDownTime(int scheduledDownTime);
    public void setUnscheduledDownTime(int unscheduledDownTime);
    public void setParentId(int parentId);
    public void setFacilitySerialNumber(int serialNumber);
    public void setIsUsed(boolean isUsed);
}