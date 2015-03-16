package com.project2.facilityManagementApp.client;

import com.project2.facilityManagementApp.Service.MaintenanceService;
import com.project2.facilityManagementApp.Service.ManagementService;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.project2.facilityManagementApp.model.Facility.FacilityImpl;


public class FacilityManagementAddClient {
    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");

        MaintenanceService maintServ = (MaintenanceService) context.getBean("maintenanceService");

        MaintRequestImpl request1 = (MaintRequestImpl) context.getBean("maintRequest");
        MaintRequestImpl request2 = (MaintRequestImpl) context.getBean("maintRequest");

        ManagementService mgmtServ = (ManagementService) context.getBean("managementService");
        FacilityImpl building1 = (FacilityImpl) context.getBean("facility");

        System.out.println("Adding buildings...");
        //Add the buildings
        building1.setFacilitySerialNumber(99);
        building1.setCapacity(2);
        building1.setDownTime(2000);
        building1.setEndDate(9999);
        building1.setIsUsed(true);
        building1.setParentId(0);
        building1.setScheduledDownTime(1500);
        building1.setStartDate(408);
        building1.setUnscheduledDownTime(500);
        building1.setUsage("Rental");
        building1.setAddress("7114 W. 231st St. North Talmadge, OH 44145");
        building1.setIsVacant(false);

        mgmtServ.addFacility(building1);
        System.out.println("Building #1,  serial #" + building1.getFacilitySerialNumber() + " added.");

        FacilityImpl building2 = (FacilityImpl) context.getBean("facility");

        building2.setFacilitySerialNumber(42);
        building2.setCapacity(15);
        building2.setDownTime(0);
        building2.setEndDate(5013);
        building2.setIsUsed(true);
        building2.setParentId(0);
        building2.setScheduledDownTime(0);
        building2.setStartDate(0);
        building2.setUnscheduledDownTime(0);
        building2.setUsage("Bank");
        building2.setAddress("1555 N. Oakmont Rd. West Village, TN 5345345");
        building2.setIsVacant(false);
        
        mgmtServ.addFacility(building2);
        System.out.println("Building #2,  serial #" + building2.getFacilitySerialNumber() + " added.");

        System.out.println("Adding maintenance requests...");
        //Add the requests

        request1.setFacilitySerialNumber(1);
        request1.setIsOpen(true);
        request1.setIsScheduled(true);
        request1.setMaintType("SEV 1");
        request1.setRequestId(1);
        request1.setStartDate(208);
        request1.setTimeToComplete(20);
        maintServ.addMaintenanceReq(request1);
        System.out.println("Request 1 , serial# " + request1.getFacilitySerialNumber() + " added.");


        request2.setFacilitySerialNumber(1);
        request2.setIsOpen(false);
        request2.setIsScheduled(true);
        request2.setMaintType("SEV 2");
        request2.setRequestId(2);
        request2.setStartDate(290);
        request2.setTimeToComplete(20);
        maintServ.addMaintenanceReq(request2);
        System.out.println("Request 2, serial# " + request2.getFacilitySerialNumber() + " added.");

//
//        System.out.println("Searching for Buildings...");
//
//        System.out.println("Retrieving building 1 (serial 99) ...");
//        System.out.println("Building #1 with serial #" + mgmtServ.retrieveFacility(99).getFacilitySerialNumber()  + " found!");
//
//        System.out.println("Retrieving building 2 (serial 42) ...");
//        System.out.println(mgmtServ.retrieveFacility(42).getFacilitySerialNumber());
//        System.out.println("Building #2 with serial #" + mgmtServ.retrieveFacility(42).getFacilitySerialNumber()  + " found!");
//
//
//        System.out.println("Searching for Requests...");
//
//        System.out.println("Retrieving request 1 (serial 1) ...");
//        System.out.println("Request #1 with serial #" + maintServ.getMaintenanceReq(1).getFacilitySerialNumber() + " found!");
//
//        System.out.println("Retrieving request 2 (serial 1) ...");
//        System.out.println("Request #2 with serial #" + maintServ.getMaintenanceReq(2).getFacilitySerialNumber() + " found!");
//
//        System.out.println("Deleting requests...");
//        maintServ.removeMaintenanceReq(1);
//        maintServ.removeMaintenanceReq(2);
//
//        System.out.println("Deleting buildings...");
//        mgmtServ.removeFacility(building1);
//        mgmtServ.removeFacility(building2);
    }

}