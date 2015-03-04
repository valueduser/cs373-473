package com.project2.model.Maintenance;

import java.util.ArrayList;
import com.project2.model.Facility.FacilityInterface;

public class MaintRequest implements MaintenanceInterface{
    private int facilitySerialNumber;
    private int requestID;
    private String maintType;
    private int timeToComplete;
    private boolean isOpen;
    private boolean isScheduled;
    private int startDate;

    public MaintRequest () {}

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
    public void setFacilitySerialNumber(int facilitySerialNumber) {
        this.facilitySerialNumber = facilitySerialNumber;
    }
    public void setStartDate (int startDate){
        this.startDate = startDate;
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
    public int getFacilitySerialNumber() {
        return this.facilitySerialNumber;
    }
    public int getStartDate(){
        return this.startDate;
    }

	/*THESE ARE NOT USED!
	 *I did not want to create abstract class that implements an interface.
	 *This project is not worth that extra complexity; therefore, I decided to allow this bad practice*/


    @Override
    public MaintenanceInterface ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate) {
        return null;
        // TODO Auto-generated method stub

    }
    @Override
    public MaintenanceInterface makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType, int startDate, boolean isScheduled) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public double calcMaintCostForFacility(int facilitySerialNumber) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public double calcProblemRateForFacility(FacilityInterface facility) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public double calcDownTimeForFaciliity(int facilitySerialNumber) {
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
