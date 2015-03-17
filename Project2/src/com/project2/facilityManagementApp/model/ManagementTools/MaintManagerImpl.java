package com.project2.facilityManagementApp.model.ManagementTools;

import java.util.ArrayList;
import java.util.Iterator;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequestImpl;
import com.project2.facilityManagementApp.model.Facility.Facility;

public class MaintManagerImpl implements MaintManager {
    private MaintRequest maintRequest;

    private ArrayList<MaintRequest> maintenanceList;

    public MaintManagerImpl(){}

    public ArrayList<MaintRequest> getMaintenanceList() {
        if (this.maintenanceList != null){
            return this.maintenanceList;
        }
        return null;
    }

    public void setMaintenanceList(ArrayList<MaintRequest> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    @Override
    public MaintRequest ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate) {
        MaintRequest scheduledMaint = new MaintRequestImpl();
        scheduledMaint.setFacilitySerialNumber(facilitySerialNumber);
        scheduledMaint.setRequestId(requestID);
        scheduledMaint.setIsOpen(true);
        scheduledMaint.setIsScheduled(true);
        scheduledMaint.setMaintType(maintType);
        scheduledMaint.setTimeToComplete(120);
        scheduledMaint.setStartDate(startDate);
        return scheduledMaint;
    }

    @Override
    public MaintRequest makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType, int startDate, boolean isScheduled) {
        MaintRequest requestedMaint = new MaintRequestImpl();
        requestedMaint.setFacilitySerialNumber(facilitySerialNumber);
        requestedMaint.setRequestId(requestID);
        requestedMaint.setIsOpen(true);
        requestedMaint.setIsScheduled(isScheduled);
        requestedMaint.setMaintType(maintType);
        requestedMaint.setTimeToComplete(120);
        requestedMaint.setStartDate(startDate);
        return requestedMaint;

    }

    @Override
    public double calcMaintCostForFacility(int facilitySerialNumber) {
        if (facilitySerialNumber != 0){
            double maintHours = 0;
            double costPerHourDownTime = 12.5;
            double maintCost = 0;
            ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
            if (maintenanceList != null){
                Iterator<MaintRequest> it = maintenanceList.iterator();
                while(it.hasNext())
                {
                    MaintRequest obj = it.next();
                    MaintRequest maint = (MaintRequest) obj;
                    if (maint.getFacilitySerialNumber() == facilitySerialNumber){
                        maintHours += maint.getTimeToComplete()/60;
                    }
                }
                maintCost = maintHours * costPerHourDownTime;
                return maintCost;
            }
            return 0;
        }
        return 0;
    }

    @Override
    public double calcProblemRateForFacility(Facility facility) {
        double facilityStartDate = (double) facility.getStartDate();
        double facilityEndDate = (double) facility.getEndDate();
        double problemRate = 0;
        double daysOperable = facilityEndDate-facilityStartDate;
        double daysNotOperable = 0;

        ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
        if(maintenanceList != null){
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
                MaintRequest maint = (MaintRequest) obj;
                if (!maint.getIsOpen()){
                    daysNotOperable += (maint.getTimeToComplete()/60)/24;
                }
            }
            problemRate = daysNotOperable/daysOperable;
            return problemRate;
        }
        return 0;
    }

    @Override
    public double calcDownTimeForFaciliity(int facilitySerialNumber) {
        double downTime = 0;

        ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
        if(maintenanceList != null){
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
                MaintRequest maint = (MaintRequest) obj;
                if (maint.getFacilitySerialNumber() == facilitySerialNumber && !maint.getIsOpen()){
                    downTime += maint.getTimeToComplete()/60.0;
                }
            }
            return downTime;
        }
        return 0;
    }

    @Override
    public ArrayList<MaintRequest> listMaintRequestsForFacility(int facilitySerialNumber) {
        ArrayList<MaintRequest> maintForFacility = new ArrayList<MaintRequest>();

        ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
        if(maintenanceList != null){
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
                MaintRequest maint = (MaintRequest) obj;
                if (maint.getFacilitySerialNumber() == facilitySerialNumber){
                    maintForFacility.add(maint);
                }
            }
            return maintForFacility;
        }
        return null;
    }

    @Override
    public ArrayList<MaintRequest> listMaint(int facilitySerialNumber, String maintType) {
        ArrayList<MaintRequest> maintList = new ArrayList<MaintRequest>();

        ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
        if(maintenanceList != null){
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
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
        return null;
    }

    @Override
    public ArrayList<MaintRequest> listFacilityProblems(int facilitySerialNumber) {
        ArrayList<MaintRequest> maintList = new ArrayList<MaintRequest>();

        ArrayList<MaintRequest> maintenanceList = this.getMaintenanceList();
        if(maintenanceList != null){
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
                MaintRequest maint = (MaintRequest) obj;
                if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getIsOpen()){
                    maintList.add(maint);
                }
            }
            return maintList;
        }
        return null;
    }

    @Override
    public ArrayList<MaintRequest> listFacilityInspections(int facilitySerialNumber) {
        ArrayList<MaintRequest> facMaint = this.listMaintRequestsForFacility(facilitySerialNumber);
        ArrayList<MaintRequest> facInspections = new ArrayList<MaintRequest>();
        if(facMaint != null){
            Iterator<MaintRequest> it = facMaint.iterator();
            while(it.hasNext())
            {
                MaintRequest obj = it.next();
                MaintRequest maint = (MaintRequest) obj;
                if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getMaintType()  == "INSPECTION"){
                    facInspections.add(maint);
                }
            }
        }
        if (facInspections.size() > 0){
            System.out.println("Inspections found.");
            return facInspections;
        }
        else {
            System.out.println("Inspections not found.");
            return null;
        }
    }

    @Override
    public void setMaintRequest(MaintRequest maintRequest) {
        this.maintRequest = maintRequest;

    }

    @Override
    public MaintRequest getMaintRequest() {
        return maintRequest;
    }

}