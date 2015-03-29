package com.project2.facilityManagementApp.model.Facility;

import java.util.List;

import com.project2.facilityManagementApp.model.Maintenance.MaintRequestImpl;

public interface Facility {
    public String getUsage();
    public int getDownTime();
    public boolean getIsVacant();
    public int getParentId();
    public int getCapacity();
    public int getFacilitySerialNumber();
    public int getEndDate();
    public int getStartDate();
    public int getScheduledDownTime();
    public int getUnscheduledDownTime();
    public boolean getIsUsed();
    public String getAddress();
    public List<MaintRequestImpl> getMaintHistory();
    public void setMaintHistory(List<MaintRequestImpl> maintHistory);
    public void setAddress(String address);
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