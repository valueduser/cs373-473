package com.project2.facilityManagementApp.client;

import com.project2.facilityManagementApp.Service.MaintenanceService;
import com.project2.facilityManagementApp.Service.ManagementService;
import com.project2.facilityManagementApp.model.Facility.FacilityImpl;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FacilityManagementSearchClient {
    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");

        MaintenanceService maintServ = (MaintenanceService) context.getBean("maintenanceService");
        ManagementService mgmtServ = (ManagementService) context.getBean("managementService");

        System.out.println("Searching for Buildings...");

        System.out.println("Retrieving building 1 (serial 99) ...");
        FacilityImpl building1 = (FacilityImpl) mgmtServ.retrieveFacility(99);
        System.out.println("Building #1 with serial #" + building1.getFacilitySerialNumber()  + " found!");

        System.out.println("Retrieving building 2 (serial 42) ...");
        FacilityImpl building2 = (FacilityImpl) mgmtServ.retrieveFacility(42);
        System.out.println("Building #2 with serial #" + building2.getFacilitySerialNumber()  + " found!");


        System.out.println("Searching for Requests...");

        System.out.println("Retrieving request 1 (serial 1) ...");
        MaintRequestImpl request1 = (MaintRequestImpl) maintServ.getMaintenanceReq(1);
        System.out.println("Request #1 with serial #" + request1.getFacilitySerialNumber() + " found!");

        System.out.println("Retrieving request 2 (serial 1) ...");
        MaintRequestImpl request2 = (MaintRequestImpl) maintServ.getMaintenanceReq(2);
        System.out.println("Request #2 with serial #" + request2.getFacilitySerialNumber() + " found!");
    }
}