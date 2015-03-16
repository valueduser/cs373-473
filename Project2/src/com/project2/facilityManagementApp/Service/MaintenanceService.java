package com.project2.facilityManagementApp.Service;

import com.project2.facilityManagementApp.DAO.MaintenanceDAO;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequest;

public class MaintenanceService {
    private MaintenanceDAO maintDAO = new MaintenanceDAO();

    public void addMaintenanceReq (MaintRequest maintReq){
        try {
            maintDAO.addMaintenanceReq(maintReq);
        } catch (Exception se) {
            System.err.println("Maint Service: Threw a Exception adding Maint Req" + maintReq.getFacilitySerialNumber());
            System.err.println(se.getMessage());
        }
    }

    public void removeMaintenanceReq (int requestID){
        try {
            maintDAO.removeMaintenanceReq(requestID);
        } catch (Exception se) {
            System.err.println("Maint Service: Threw a Exception removing Maint Req" + requestID);
            System.err.println(se.getMessage());
        }
    }

    public MaintRequest getMaintenanceReq (int requestID){
        try {
            MaintRequest maint = maintDAO.getMaintenanceReq(requestID);
            return maint;
        } catch (Exception se) {
            System.err.println("Maint Service: Threw a Exception retrieving Maint Req" + requestID);
            System.err.println(se.getMessage());
        }
        return null;
    }
}
