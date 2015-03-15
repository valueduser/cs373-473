//package com.project2.facilityManagmentApp.model.Maintenance;
//
//import com.project2.facilityManagementApp.model.Facility.FacilityInterface;
//
//import java.util.ArrayList;
//
//public interface MaintDetail {
//
//    public final String[] maintTypes = {"SEV1", "SEV2", "SEV3", "INSPECTION", "ALL"};
//
//    public MaintDetail ScheduleMaintenance(int facilitySerialNumber, int requestID, String maintType, int startDate);
//    public MaintDetail makeFacilityMaintRequest(int facilitySerialNumber, int requestID, String maintType,int startDate, boolean isScheduled);
//    public double calcMaintCostForFacility(int facilitySerialNumber);
//    public double calcProblemRateForFacility(FacilityInterface facility);
//    public double calcDownTimeForFaciliity(int facilitySerialNumber);
//
//    //lifetime requests for a facilities
//    public ArrayList<MaintDetail> listMaintRequestsForFacility(int facilitySerialNumber);
//
//    //open requests across all facilities of a certain type if "All" is passed then all maintTypes are listed
//    public ArrayList<MaintDetail> listMaint(int facilitySerialNumber, String maintType);
//
//    // currently open requests for a facility
//    public ArrayList<MaintDetail> listFacilityProblems(int facilitySerialNumber);
//
//}
