//package com.project2.facilityManagmentApp.model.Maintenance;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import com.project2.facilityManagmentApp.model.Maintenance.MaintDetail;
//import com.project2.facilityManagmentApp.model.Facility.FacilityInterface;
//
//public class MaintDetailImpl implements MaintDetail{
//    private ArrayList<MaintDetail> maintenanceList;
//
//
//    public ArrayList<MaintDetail> getMaintenanceList() {
//        if (this.maintenanceList != null){
//            return this.maintenanceList;
//        }
//        return null;
//    }
//
//    public void setMaintenanceList(ArrayList<MaintDetail> maintenanceList) {
//        this.maintenanceList = maintenanceList;
//    }
//
//    @Override
//    public MaintDetail ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate) {
//        MaintRequest scheduledMaint = new MaintRequest();
//        scheduledMaint.setFacilitySerialNumber(facilitySerialNumber);
//        scheduledMaint.setRequestID(requestID);
//        scheduledMaint.setIsOpen(true);
//        scheduledMaint.setIsScheduled(true);
//        scheduledMaint.setMaintType(maintType);
//        scheduledMaint.setTimeToComplete(120);
//        scheduledMaint.setStartDate(startDate);
//        return scheduledMaint;
//    }
//
//    @Override
//    public MaintDetail makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType, int startDate, boolean isScheduled) {
//        MaintRequest requestedMaint = new MaintRequest();
//        requestedMaint.setFacilitySerialNumber(facilitySerialNumber);
//        requestedMaint.setRequestID(requestID);
//        requestedMaint.setIsOpen(true);
//        requestedMaint.setIsScheduled(isScheduled);
//        requestedMaint.setMaintType(maintType);
//        requestedMaint.setTimeToComplete(120);
//        requestedMaint.setStartDate(startDate);
//        return requestedMaint;
//
//    }
//
//    @Override
//    public double calcMaintCostForFacility(int facilitySerialNumber) {
//        if (facilitySerialNumber != 0){
//            double maintHours = 0;
//            double costPerHourDownTime = 12.5;
//            double maintCost = 0;
//            ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//            if (maintenanceList != null){
//                Iterator<MaintDetail> it = maintenanceList.iterator();
//                while(it.hasNext())
//                {
//                    MaintDetail obj = it.next();
//                    MaintRequest maint = (MaintRequest) obj;
//                    if (maint.getFacilitySerialNumber() == facilitySerialNumber){
//                        maintHours += maint.getTimeToComplete()/60;
//                    }
//                }
//                maintCost = maintHours * costPerHourDownTime;
//                return maintCost;
//            }
//            return 0;
//        }
//        return 0;
//    }
//
//    @Override
//    public double calcProblemRateForFacility(FacilityInterface facility) {
//        double facilityStartDate = (double) facility.getStartDate();
//        double facilityEndDate = (double) facility.getEndDate();
//        double problemRate = 0;
//        double daysOperable = facilityEndDate-facilityStartDate;
//        double daysNotOperable = 0;
//
//        ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//        if(maintenanceList != null){
//            Iterator<MaintDetail> it = maintenanceList.iterator();
//            while(it.hasNext())
//            {
//                MaintDetail obj = it.next();
//                MaintRequest maint = (MaintRequest) obj;
//                if (!maint.getIsOpen()){
//                    daysNotOperable += (maint.getTimeToComplete()/60)/24;
//                }
//            }
//            problemRate = daysNotOperable/daysOperable;
//            return problemRate;
//        }
//        return 0;
//    }
//
//    @Override
//    public double calcDownTimeForFaciliity(int facilitySerialNumber) {
//        double downTime = 0;
//
//        ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//        if(maintenanceList != null){
//            Iterator<MaintDetail> it = maintenanceList.iterator();
//            while(it.hasNext())
//            {
//                MaintDetail obj = it.next();
//                MaintRequest maint = (MaintRequest) obj;
//                if (maint.getFacilitySerialNumber() == facilitySerialNumber && !maint.getIsOpen()){
//                    downTime += maint.getTimeToComplete()/60;
//                }
//            }
//            return downTime;
//        }
//        return 0;
//    }
//
//    @Override
//    public ArrayList<MaintDetail> listMaintRequestsForFacility(int facilitySerialNumber) {
//        ArrayList<MaintDetail> maintForFacility = new ArrayList<MaintDetail>();
//
//        ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//        if(maintenanceList != null){
//            Iterator<MaintDetail> it = maintenanceList.iterator();
//            while(it.hasNext())
//            {
//                MaintDetail obj = it.next();
//                MaintRequest maint = (MaintRequest) obj;
//                if (maint.getFacilitySerialNumber() == facilitySerialNumber){
//                    maintForFacility.add(maint);
//                }
//            }
//            return maintForFacility;
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<MaintDetail> listMaint(int facilitySerialNumber, String maintType) {
//        ArrayList<MaintDetail> maintList = new ArrayList<MaintDetail>();
//
//        ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//        if(maintenanceList != null){
//            Iterator<MaintDetail> it = maintenanceList.iterator();
//            while(it.hasNext())
//            {
//                MaintDetail obj = it.next();
//                MaintRequest maint = (MaintRequest) obj;
//                if (maintType == "ALL"){
//                    maintList.add(maint);
//                }
//                else{
//                    if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getMaintType() == maintType){
//                        maintList.add(maint);
//                    }
//                }
//            }
//            return maintList;
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<MaintDetail> listFacilityProblems(int facilitySerialNumber) {
//        ArrayList<MaintDetail> maintList = new ArrayList<MaintDetail>();
//
//        ArrayList<MaintDetail> maintenanceList = this.getMaintenanceList();
//        if(maintenanceList != null){
//            Iterator<MaintDetail> it = maintenanceList.iterator();
//            while(it.hasNext())
//            {
//                MaintDetail obj = it.next();
//                MaintRequest maint = (MaintRequest) obj;
//                if (maint.getFacilitySerialNumber() == facilitySerialNumber && maint.getIsOpen()){
//                    maintList.add(maint);
//                }
//            }
//            return maintList;
//        }
//        return null;
//    }
//}
