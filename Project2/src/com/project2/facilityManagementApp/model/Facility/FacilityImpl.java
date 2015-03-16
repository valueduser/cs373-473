package com.project2.facilityManagementApp.model.Facility;

import java.util.ArrayList;
import java.util.Iterator;

public class FacilityImpl implements Facility{
    private int serialNumber;
    private int parentId;
    private int capacity; //number of rooms being used multiplied by the capacity of each room
    private boolean isUsed = false;
    private boolean isVacant = false;
    private String usage;
    private int startDate; //days from 1000/01/01
    private int endDate; //days from 1000/01/01

    private String address = null;

    /*in minutes*/
    private int downTime;
    private int scheduledDownTime;
    private int unscheduledDownTime;

    private String facilityTableName = "facilities";

    public FacilityImpl(){}
    
    @Override
    public String getUsage() {
        return usage;
    }

    @Override
    public int getDownTime(){
        return downTime;
    }
    
    @Override
    public boolean getIsVacant() {
        return isVacant;
    }

    @Override
    public int getParentId() {
        return parentId;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }


    @Override
    public ArrayList<Facility> getChildren(ArrayList<Facility> facilities) {
        ArrayList<Facility> childeren = new ArrayList<Facility>();

        Iterator<Facility> it = facilities.iterator();
        while(it.hasNext())
        {
            Facility obj = it.next();
            if (obj.getParentId() == getFacilitySerialNumber()){
                childeren.add(obj);
            }
        }
        return childeren;
    }

    @Override
    public int getFacilitySerialNumber() {
        return serialNumber;
    }

    @Override
    public int getEndDate() {
        return endDate;
    }

    @Override
    public int getStartDate() {
        return startDate;
    }

    @Override
    public int getScheduledDownTime() {
        return scheduledDownTime;
    }

    @Override
    public int getUnscheduledDownTime() {
        return unscheduledDownTime;
    }

    @Override
    public void setUsage(String useType) {
            this.setIsUsed(true);
            this.usage = useType;
    }

    @Override
    public void setIsVacant(boolean isVacant) {
        setIsUsed(false);
        this.isVacant = isVacant;
    }

    @Override
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    @Override
    public void setDownTime(int downTime) {
        this.downTime = downTime;
    }

    @Override
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    }
    @Override
    public void setScheduledDownTime(int scheduledDownTime) {
        this.scheduledDownTime = scheduledDownTime;
    }

    @Override
    public void setUnscheduledDownTime(int unscheduledDownTime) {
        this.unscheduledDownTime = unscheduledDownTime;
    }

    @Override
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public void setFacilitySerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public boolean getIsUsed() {
        return isUsed;
    }

    @Override
    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String getAddress(){
        return address;
    }
}
