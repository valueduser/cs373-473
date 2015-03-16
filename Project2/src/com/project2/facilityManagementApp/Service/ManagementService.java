package com.project2.facilityManagementApp.Service;

import com.project2.facilityManagementApp.DAO.BuildingDAO;
import com.project2.facilityManagementApp.DAO.MaintenanceDAO;
import com.project2.facilityManagementApp.model.Facility.Building;
import com.project2.facilityManagementApp.model.Facility.FacilityInterface;

public class ManagementService {
    private BuildingDAO bldgDAO = new BuildingDAO();


    public void addBuilding(FacilityInterface bldg) {
        try {
            bldgDAO.addBuilding(bldg);
        } catch (Exception se) {
            System.err.println("Mgmt Service: Threw a Exception adding Building" + bldg.getFacilitySerialNumber());
            System.err.println(se.getMessage());
        }
    }

    public void removeBuilding(FacilityInterface bldg) {

        try {
            bldgDAO.removeBuilding(bldg);
        } catch (Exception se) {
            System.err.println("Mgmt Service: Threw a Exception removing Building" + bldg.getFacilitySerialNumber());
            System.err.println(se.getMessage());
        }
    }

    public FacilityInterface retrieveBuilding(int id) {
        try {
            FacilityInterface bldg = bldgDAO.retrieveBuilding(id);
            return bldg;
        } catch (Exception se) {
            System.err.println("CustomerService: Threw a Exception retrieving building" + id);
            System.err.println(se.getMessage());
        }
        return null;
    }

}
