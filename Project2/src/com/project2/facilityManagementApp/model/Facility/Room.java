package com.project2.facilityManagementApp.model.Facility;

import java.util.ArrayList;
import java.util.Iterator;

public class Room implements FacilityInterface{
    public static final int MAX_ROOM_CAPACITY = 3;

    private int serialNumber;
    private int parentId;
    private int capacity; //number of people in using the room
    private boolean isUsed = false;
    private boolean isVacant = false;
    private String usage;
    private int startDate; //days from 1000/01/01
    private int endDate; //days from 1000/01/01

    /*in minutes*/
    private int downTime;
    private int scheduledDownTime;
    private int unscheduledDownTime;

    private String facilityTableName = "facilities";

    public Room() {}
    
    @Override
    public String getUsage() {
        return this.usage;
    }

    @Override
    public int getDownTime(){
        return this.downTime;
    }

    @Override
    public int getScheduledDownTime() {
        return this.scheduledDownTime;
    }

    @Override
    public int getUnscheduledDownTime() {
        return this.unscheduledDownTime;
    }

    @Override
    public int requestAvailableCapacity() {
        return this.capacity;
    }

    @Override
    public boolean getIsVacant() {
        return this.isVacant;
    }

    @Override
    public int getParentId() {
        return this.parentId;
    }

    @Override
    public ArrayList<FacilityInterface> getChildren(ArrayList<FacilityInterface> facilities) {
        ArrayList<FacilityInterface> childeren = new ArrayList<FacilityInterface>();

        Iterator<FacilityInterface> it = facilities.iterator();
        while(it.hasNext())
        {
            FacilityInterface obj = it.next();
            Room fac = (Room) obj;
            if (fac.getParentId() == this.getFacilitySerialNumber()){
                childeren.add(fac);
            }
        }
        return childeren;
    }

    @Override
    public int getFacilitySerialNumber() {
        return this.serialNumber;
    }

    @Override
    public int getEndDate() {
        return this.endDate;
    }

    @Override
    public int getStartDate() {
        return this.startDate;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void setUsage(String useType) {
            this.setIsUsed(true);
            this.usage = useType;
    }

    @Override
    public void setIsVacant(boolean isVacant) {
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
        if(capacity <= MAX_ROOM_CAPACITY){
            this.capacity = capacity;
        }
        else {
            System.out.println("Capacity not valid");
        }
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
        return this.isUsed;
    }
}
