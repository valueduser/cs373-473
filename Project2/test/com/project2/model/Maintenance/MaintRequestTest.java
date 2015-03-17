package com.project2.model.Maintenance;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.project2.facilityManagementApp.Service.MaintenanceService;
import com.project2.facilityManagementApp.model.Maintenance.*;
import com.project2.facilityManagementApp.model.ManagementTools.MaintManagerImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MaintRequestTest {
    private ArrayList<MaintRequest> maintRequests = new ArrayList<MaintRequest>();

    ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");
    MaintenanceService maintServ = (MaintenanceService) context.getBean("maintenanceService");

    MaintRequestImpl request1 = (MaintRequestImpl) context.getBean("maintRequest");
    MaintRequestImpl request2 = (MaintRequestImpl) context.getBean("maintRequest");
    MaintRequestImpl request99 = (MaintRequestImpl) context.getBean("maintRequest");

    MaintManagerImpl mMgr = (MaintManagerImpl) context.getBean("maintManager");

    Boolean setupComplete = false;

    @Before
    public void setUp() throws Exception {
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
        maintRequests.add(request1);
        System.out.println("Request 1 , serial# " + request1.getFacilitySerialNumber() + " added.");


        request2.setFacilitySerialNumber(1);
        request2.setIsOpen(false);
        request2.setIsScheduled(true);
        request2.setMaintType("SEV 2");
        request2.setRequestId(2);
        request2.setStartDate(290);
        request2.setTimeToComplete(20);
        maintServ.addMaintenanceReq(request2);
        maintRequests.add(request2);
        System.out.println("Request 2, serial# " + request2.getFacilitySerialNumber() + " added.");

        request99.setFacilitySerialNumber(54);
        request99.setIsOpen(true);
        request99.setIsScheduled(true);
        request99.setMaintType("INSPECTION");
        request99.setRequestId(9);
        request99.setStartDate(101);
        request99.setTimeToComplete(168);
        maintServ.addMaintenanceReq(request99);
        maintRequests.add(request99);
        System.out.println("Request 99, serial# " + request99.getFacilitySerialNumber() + " added.");

        mMgr.setMaintenanceList(maintRequests);
        setupComplete = true;
    }

    @Test
    public void testScheduleMaintenance() {
        assertNotNull(mMgr.ScheduleMaintenance(1, 1, "Fix Roof", 1100));
    }

    @Test
    public void testMakeFacilityMaintRequest() {
        assertNotNull(mMgr.makeFacilityMaintRequest(12, 26, "Replace Bathroom Sink", 1220, false));
    }

    @Test
    public void testCalcMaintCostForFacility() {
        double cost = 25.0;
        assertEquals(cost, mMgr.calcMaintCostForFacility(request99.getFacilitySerialNumber()), 1);
    }

//    @Test //This test is not 100% relevant to the scope of this test suite
//    public void testCalcProblemRateForFacility() {
////        boolean isNull = false;
////        if (mMgr.calcProblemRateForFacility() == 0){
////            isNull = true;
////        }
////
////        assertEquals(isNull, true);
//    }

    @Test
    public void testCalcDownTimeForFaciliity() {
        double downtime = 20.0/60.0;
        assertEquals(downtime, mMgr.calcDownTimeForFaciliity(request1.getFacilitySerialNumber()), 1);
    }

    @Test
    public void testListMaintRequestsForFacility() {
        ArrayList<String> list = new ArrayList<String>();

        ArrayList<MaintRequest> maintenanceList = new ArrayList<MaintRequest>();
        maintenanceList = mMgr.listMaintRequestsForFacility(request99.getFacilitySerialNumber());
        if(maintenanceList != null) {
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while (it.hasNext()) {
                list.add(it.next().getMaintType());
            }
        }
        assertNotNull(list.get(0));
    }
    
    @Test
    public void testListFacilityInspections() {
        System.out.println("testListFacilityInspections...");

        ArrayList<String> list = new ArrayList<String>();

        ArrayList<MaintRequest> maintenanceList = new ArrayList<MaintRequest>();
        maintenanceList = mMgr.listFacilityInspections(request99.getFacilitySerialNumber());
        if(maintenanceList != null) {
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while (it.hasNext()) {
                list.add(it.next().getMaintType());
            }
        }
        assertNotNull(list.get(0));
    }


    @Test
    public void testListMaint() {
        ArrayList<String> list = new ArrayList<String>();

        ArrayList<MaintRequest> maintenanceList = new ArrayList<MaintRequest>();
        maintenanceList = mMgr.listMaint(request99.getFacilitySerialNumber(), request99.getMaintType());
        if(maintenanceList != null) {
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while (it.hasNext()) {
                list.add(it.next().getMaintType());
            }
        }
    assertNotNull(list.get(0));
    }

    @Test
    public void testListFacilityProblems() {

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<MaintRequest> maintenanceList = new ArrayList<MaintRequest>();
        maintenanceList = mMgr.listFacilityProblems(request99.getFacilitySerialNumber());
        if(maintenanceList != null) {
            Iterator<MaintRequest> it = maintenanceList.iterator();
            while (it.hasNext()) {
                list.add(it.next().getMaintType());
            }
        }
        assertNotNull(list.get(0));
    }

    @Test
    public void testSetRequestID() {
        request1.setRequestId(3);
        int id = request1.getRequestId();

        assertEquals(id, 3);
    }

    @Test
    public void testSetMaintType() {
        request1.setMaintType("SEV 3");
        String type = request1.getMaintType();
        assertEquals(type, "SEV 3");
    }

    @Test
    public void testSetTimeToComplete() {
        request1.setTimeToComplete(10);
        int time = request1.getTimeToComplete();
        assertEquals(time, 10);
    }

    @Test
    public void testSetIsOpen() {
        request1.setIsOpen(true);
        boolean open = request1.getIsOpen();
        assertEquals(open, true);
    }

    @Test
    public void testSetIsScheduled() {
        request1.setIsScheduled(true);
        boolean scheduled = request1.getIsScheduled();
        assertEquals(scheduled, true);
    }

    @Test
    public void testSetFacilitySerialNumber() {
        request1.setFacilitySerialNumber(3);
        int num = request1.getFacilitySerialNumber();

        assertEquals(num, 3);
    }

    @Test
    public void testSetStartDate() {
        request1.setStartDate(30);
        int num = request1.getStartDate();

        assertEquals(num, 30);
    }

    @Test
    public void testGetRequestID() {
        int num = request2.getRequestId();
        assertEquals(num, 2);
    }

    @Test
    public void testGetMaintType() {
        String type = request2.getMaintType();

        assertEquals(type, "SEV 2");
    }

    @Test
    public void testGetTimeToComplete() {
        int time = request1.getTimeToComplete();

        assertEquals(time, 20);
    }

    @Test
    public void testGetIsOpen() {
        boolean open = request2.getIsOpen();

        assertEquals(open, false);
    }

    @Test
    public void testGetIsScheduled() {
        boolean scheduled = request1.getIsScheduled();

        assertEquals(scheduled, true);
    }

    @Test
    public void testGetFacilitySerialNumbe() {
        int num = request1.getFacilitySerialNumber();

        assertEquals(num, 1);
    }

    @Test
    public void testGetStartDate() {
        int num = request2.getStartDate();

        assertEquals(num, 290);
    }
}