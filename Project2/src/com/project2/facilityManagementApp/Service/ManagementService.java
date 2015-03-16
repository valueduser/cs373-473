package com.project2.facilityManagementApp.Service;

import com.project2.facilityManagementApp.DAO.FacilityDAO;
import com.project2.facilityManagementApp.model.Facility.FacilityImpl;

public class ManagementService {
    private FacilityDAO facDAO = new FacilityDAO();


    public void addFacility(FacilityImpl fac) {
        try {
            facDAO.addFacility(fac);
        } catch (Exception se) {
            System.err.println("Mgmt Service: Threw a Exception adding Facility" + fac.getFacilitySerialNumber());
            System.err.println(se.getMessage());
        }
    }

    public void removeFacility(FacilityImpl fac) {

        try {
            facDAO.removeFacility(fac);
        } catch (Exception se) {
            System.err.println("Mgmt Service: Threw a Exception removing Facility" + fac.getFacilitySerialNumber());
            System.err.println(se.getMessage());
        }
    }

    public FacilityImpl retrieveFacility(int id) {
        try {
            FacilityImpl fac = facDAO.retrieveFacility(id);
            return fac;
        } catch (Exception se) {
            System.err.println("CustomerService: Threw a Exception retrieving Facility" + id);
            System.err.println(se.getMessage());
        }
        return null;
    }

}
