package com.project2.facilityManagementApp.client;

import com.project2.facilityManagementApp.Service.MaintenanceService;
import com.project2.facilityManagementApp.Service.ManagementService;
import com.project2.facilityManagementApp.model.Facility.FacilityImpl;
import com.project2.facilityManagementApp.model.Maintenance.MaintRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FacilityManagementDeleteClient {
    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");

        MaintenanceService maintServ = (MaintenanceService) context.getBean("maintenanceService");

        MaintRequestImpl request1 = (MaintRequestImpl) maintServ.getMaintenanceReq(1);
        MaintRequestImpl request2 = (MaintRequestImpl) maintServ.getMaintenanceReq(2);

        ManagementService mgmtServ = (ManagementService) context.getBean("managementService");
        FacilityImpl building1 = (FacilityImpl) mgmtServ.retrieveFacility(99);
        FacilityImpl building2 = (FacilityImpl) mgmtServ.retrieveFacility(42);

        System.out.println("Deleting requests...");
        maintServ.removeMaintenanceReq(request1);
        maintServ.removeMaintenanceReq(request2);

        System.out.println("Deleting buildings...");
        mgmtServ.removeFacility(building1);
        mgmtServ.removeFacility(building2);
    }

}