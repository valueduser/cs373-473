package com.project2.facilityManagmentApp.model.Maintenance;

public class MaintRequestImpl implements MaintRequest{
    private int facilitySerialNumber;
    private int requestID;
    private String maintType;
    private int timeToComplete;
    private boolean isOpen;
    private boolean isScheduled;
    private int startDate;

    public MaintRequestImpl () {}

    @Override
    public void setRequestId(int id){
        this.requestID = id;
    }
    @Override
    public void setMaintType(String type){
        this.maintType = type;
    }
    @Override
    public void setTimeToComplete(int timeToComplete){
        this.timeToComplete = timeToComplete;
    }
    @Override
    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }
    @Override
    public void setIsScheduled(boolean isScheduled){
        this.isScheduled = isScheduled;
    }
    @Override
    public void setFacilitySerialNumber(int facilitySerialNumber) {
        this.facilitySerialNumber = facilitySerialNumber;
    }
    @Override
    public void setStartDate (int startDate){
        this.startDate = startDate;
    }
    @Override
    public int getRequestId(){
        return this.requestID;
    }
    @Override
    public String getMaintType (){
        return this.maintType;
    }
    @Override
    public int getTimeToComplete(){
        return this.timeToComplete;
    }
    @Override
    public boolean getIsOpen(){
        return this.isOpen;
    }
    @Override
    public boolean getIsScheduled(){
        return this.isScheduled;
    }
    @Override
    public int getFacilitySerialNumber() {
        return this.facilitySerialNumber;
    }
    @Override
    public int getStartDate(){
        return this.startDate;
    }
}
