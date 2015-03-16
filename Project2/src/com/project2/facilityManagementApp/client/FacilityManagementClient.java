package com.project2.facilityManagementApp.client;

import com.project2.facilityManagementApp.Service.ManagementService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.project2.facilityManagementApp.DAO.HibernatePGSQLHelper;
import com.project2.facilityManagementApp.DAO.FacilityDAO;
import com.project2.facilityManagementApp.model.Facility.FacilityImpl;


public class FacilityManagementClient {
    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");

        ManagementService mgmtServ = (ManagementService) context.getBean("managementService");
        FacilityImpl building1 = (FacilityImpl) context.getBean("facility");

        System.out.println("Adding buildings...");
        //Add the buildings
        building1.setFacilitySerialNumber(99);
        building1.setCapacity(2);
        building1.setDownTime(2000);
        building1.setEndDate(9999);
        building1.setParentId(0);
        building1.setScheduledDownTime(1500);
        building1.setStartDate(408);
        building1.setUnscheduledDownTime(500);
        building1.setUsage("Rental");
        building1.setAddress("7114 W. 231st St. North Talmadge, OH 44145");
        building1.setIsVacant(false);

        mgmtServ.addFacility(building1);
        System.out.println("Building serial" + building1.getFacilitySerialNumber() + " added.");

        FacilityImpl building2 = (FacilityImpl) context.getBean("facility");

        building2.setFacilitySerialNumber(42);
        building2.setCapacity(15);
        building2.setDownTime(0);
        building2.setEndDate(5013);
        building2.setParentId(0);
        building2.setScheduledDownTime(0);
        building2.setStartDate(0);
        building2.setUnscheduledDownTime(0);
        building2.setUsage("Bank");
        building2.setAddress("1555 N. Oakmont Rd. West Village, TN 5345345");
        building2.setIsVacant(false);
        mgmtServ.addFacility(building2);
        System.out.println("Building serial" + building2.getFacilitySerialNumber() + " added.");


        System.out.println("Deleting buildings...");
    }

}