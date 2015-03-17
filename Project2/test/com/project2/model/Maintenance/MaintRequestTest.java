package com.project2.model.Maintenance;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.project2.facilityManagementApp.Service.MaintenanceService;
import com.project2.facilityManagementApp.model.Maintenance.*;

import com.project2.facilityManagementApp.model.ManagementTools.MaintManagerImpl;
import org.junit.Before;
import org.junit.Test;

import com.project2.facilityManagementApp.model.Facility.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MaintRequestTest {
    private ArrayList<MaintRequest> maintRequests = new ArrayList<MaintRequest>();

    ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");
    MaintenanceService maintServ = (MaintenanceService) context.getBean("maintenanceService");

    MaintRequestImpl request1 = (MaintRequestImpl) context.getBean("maintRequest");
    MaintRequestImpl request2 = (MaintRequestImpl) context.getBean("maintRequest");

    MaintManagerImpl mMgr = (MaintManagerImpl) context.getBean("maintManager");


    Boolean setupComplete = false;

    @Before
    public void setUp() throws Exception {
        System.out.println(setupComplete.toString());
        if (setupComplete) {
            System.out.println("Setup Already Completed.");
            return;
        }
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

        setupComplete = true;
        System.out.println(setupComplete.toString());
    }

    @Test
    public void testScheduleMaintenance() {
        assertNotNull(mMgr.ScheduleMaintenance(1,1,"Fix Roof", 1100));
    }

    @Test
    public void testMakeFacilityMaintRequest() {
        assertNotNull(mMgr.makeFacilityMaintRequest(12,26, "Replace Bathroom Sink", 1220, false));
    }

    @Test
    public void testCalcMaintCostForFacility() {
        boolean isNull = false;
        if (mMgr.calcMaintCostForFacility(0) == 0){
            isNull = true;
        }

        assertEquals(isNull, true);
    }

    @Test
    public void testCalcProblemRateForFacility() {
        boolean isNull = false;
        Facility fac = new FacilityImpl();
        if (mMgr.calcProblemRateForFacility(fac) == 0){
            isNull = true;
        }

        assertEquals(isNull, true);
    }

    @Test
    public void testCalcDownTimeForFaciliity() {
        boolean isNull = false;
        if (mMgr.calcDownTimeForFaciliity(0) == 0){
            isNull = true;
        }

        assertEquals(isNull, true);
    }

    @Test
    public void testListMaintRequestsForFacility() {
        boolean isNull = false;
        if (mMgr.listMaintRequestsForFacility(0) == null){
            isNull = true;
        }

        assertEquals(isNull, true);
    }
    
    @Test
    public void testListFacilityInspections() {
        System.out.println("testListFacilityInspections...");

        boolean isNotNull = false;
        if(mMgr.listFacilityInspections(request1.getFacilitySerialNumber()) != null){
            isNotNull = true;
        }

        assertEquals(isNotNull, false);
    }

    @Test
    public void testListMaint() {
        boolean isNull = false;
        if (mMgr.listMaint(0, " ") == null){
            isNull = true;
        }

        assertEquals(isNull, true);
    }

    @Test
    public void testListFacilityProblems() {
        boolean isNull = false;
        if (mMgr.listFacilityProblems(0) == null){
            isNull = true;
        }

        assertEquals(isNull, true);
    }

    @Test
    public void testSetRequestID() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setRequestId(3);
        int id = m.getRequestId();

        assertEquals(id, 3);
    }

    @Test
    public void testSetMaintType() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setMaintType("SEV 3");
        String type = m.getMaintType();

        assertEquals(type, "SEV 3");
    }

    @Test
    public void testSetTimeToComplete() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setTimeToComplete(10);
        int time = m.getTimeToComplete();

        assertEquals(time, 10);
    }

    @Test
    public void testSetIsOpen() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setIsOpen(true);
        boolean open = m.getIsOpen();

        assertEquals(open, true);
    }

    @Test
    public void testSetIsScheduled() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setIsScheduled(true);
        boolean scheduled = m.getIsScheduled();

        assertEquals(scheduled, true);
    }

    @Test
    public void testSetFacilitySerialNumbe() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setFacilitySerialNumber(3);
        int num = m.getFacilitySerialNumber();

        assertEquals(num, 3);
    }

    @Test
    public void testSetStartDate() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        m.setStartDate(30);
        int num = m.getStartDate();

        assertEquals(num, 30);
    }

    @Test
    public void testGetRequestID() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        int num = m.getRequestId();

        assertEquals(num, 2);
    }

    @Test
    public void testGetMaintType() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        String type = m.getMaintType();

        assertEquals(type, "SEV 2");
    }

    @Test
    public void testGetTimeToComplete() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        int time = m.getTimeToComplete();

        assertEquals(time, 20);
    }

    @Test
    public void testGetIsOpen() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        boolean open = m.getIsOpen();

        assertEquals(open, false);
    }

    @Test
    public void testGetIsScheduled() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        boolean scheduled = m.getIsScheduled();

        assertEquals(scheduled, true);
    }

    @Test
    public void testGetFacilitySerialNumbe() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        int num = m.getFacilitySerialNumber();

        assertEquals(num, 1);
    }

    @Test
    public void testGetStartDate() {
        MaintRequest tempMaint = maintRequests.get(1);
        MaintRequest m = (MaintRequest) tempMaint;
        int num = m.getStartDate();

        assertEquals(num, 290);
    }
}